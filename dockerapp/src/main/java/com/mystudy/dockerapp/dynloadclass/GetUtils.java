package com.mystudy.dockerapp.dynloadclass;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * @author ：songdalin
 * @date ：2021-12-22 下午 04:42
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class GetUtils {

    public GetUtils() {
        System.out.println("执行了构造方法。。。。。。。。。");
    }

    public static String getEnv() {
        System.out.println("执行了get方法。。。。。。。。。");
        return env;
    }

    public static void setEnv(String env) {
        GetUtils.env = env;
    }

    private static String env;

    private static String location;

    static {
        //1:加载配置文件
        Resource app =  new ClassPathResource("application.yml");
        Resource appDev = new ClassPathResource("application-dev.yml");
        Resource appProd =  new ClassPathResource("application-prod.yml");
        YamlPropertiesFactoryBean yamlPropertiesFactoryBean = new YamlPropertiesFactoryBean();
        // 2:将加载的配置文件交给 YamlPropertiesFactoryBean
        yamlPropertiesFactoryBean.setResources(app);
        // 3：将yml转换成 key：val
        Properties properties = yamlPropertiesFactoryBean.getObject();
/*        String active = null;
        if (properties != null) {
            active = properties.getProperty("spring.profiles.active");
        }
        if (StringUtils.isEmpty(active)) {
            System.out.println("未找到spring.profiles.active配置！");
        } else {
            //判断当前配置是什么环境
            if ("dev".equals(active)) {
                yamlPropertiesFactoryBean.setResources(app, appDev);
            } else if ("prod".equals(active)) {
                yamlPropertiesFactoryBean.setResources(app, appProd);
            }
        }*/
        final String env1 = properties.getProperty("env");
        env = env1;
        final String env2 = properties.getProperty("location");
        location = env2;
        System.out.println("执行了静态代码块。。。。。。。。。");

    }

    public static String getPorp(String name) {
        String value = "";
        Class clazz;
        try {
            clazz = Class.forName(location + env);
            //clazz.newInstance();
//2.返回字段的数组
            Field[] fields = clazz.getDeclaredFields();
            final List<Field> fieldList = Arrays.asList(fields);
            final List<Field> collect = fieldList.stream().filter(f -> Objects.equals(name, f.getName())).collect(Collectors.toList());
            if (CollectionUtils.isEmpty(collect)) {
                throw new RuntimeException("no this property " + name);
            }
            String methodName = "get" + captureName(name);
            Object o = clazz.newInstance();
            final Method declaredMethod = clazz.getDeclaredMethod(methodName);

            value = (String) declaredMethod.invoke(o);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return value;
    }

    /**
     * 将字符串的首字母转大写
     * @param str 需要转换的字符串
     * @return
     */
    private static String captureName(String str) {
        // 进行字母的ascii编码前移，效率要高于截取字符串进行转换的操作
        char[] cs=str.toCharArray();
        cs[0]-=32;
        return String.valueOf(cs);
    }

}
