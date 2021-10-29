package com.mystudy.dockerapp.se;

import com.google.common.collect.Lists;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.stream.Collectors;

public class Cengcifenxi {
    /**
     *
     *@author LJ
     *2016-3-30
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        double[][] matrix=new double[3][3];
        for(int i=0;i<3;i++){
            matrix[i][i]=1.0;
        }


        //数组0,1 位置存放的是影响因素0相对于影响因素1的重要程度 。
        //0.25代表 影响因素0的重要程度为影响因素1的重要程度的4分之1。
        matrix[0][1]=0.25;
        matrix[0][2]=0.5;
/*        matrix[0][3]=1.0;
        matrix[0][4]=1.0;
        matrix[0][5]=0.5;*/
        matrix[1][2]=0.5;
/*        matrix[1][3]=1.0;
        matrix[1][4]=2.0;
        matrix[1][5]=1.0;
        matrix[2][3]=1.0;
        matrix[2][4]=0.5;
        matrix[2][5]=0.5;
        matrix[3][4]=2.0;
        matrix[3][5]=1.0;
        matrix[4][5]=0.5;*/


        List<AhqProperty> ahqPropertityList = new ArrayList<>();
        AhqProperty ahqProperty = new AhqProperty();
        ahqProperty.setName("111");
        ahqProperty.setValue(25.5);
        ahqProperty.setActive(true);
        AhqProperty ahqProperty1 = new AhqProperty();
        ahqProperty1.setName("22");
        ahqProperty1.setValue(10.2);
        ahqProperty1.setActive(true);
        AhqProperty ahqProperty2 = new AhqProperty();
        ahqProperty2.setName("333");
        ahqProperty2.setValue(15.2);
        ahqProperty2.setActive(false);
        ahqPropertityList.add(ahqProperty);
        ahqPropertityList.add(ahqProperty1);
        ahqPropertityList.add(ahqProperty2);




        Cengcifenxi cengcifenxi = new Cengcifenxi();
        System.out.println(cengcifenxi.calcNormalization(ahqPropertityList));
        cengcifenxi.calcAhqDispatchScore(matrix);
    }


    private void calcAhqDispatchScore(double[][] matrix) {
        final int arrLen = matrix.length;
        //根据输入值填写矩阵剩余项
        for(int i=arrLen - 1;i>=0;i--){
            for(int j=arrLen - 1;j>=0;j--){
                matrix[i][j]=1/matrix[j][i];
            }
        }
        double[] column=new double[arrLen];
        for(int j=0;j<arrLen;j++){
            for(int i=0;i<arrLen;i++){
               // if(column[j]!=null){
                    column[j]=column[j]+matrix[i][j];
/*                }else{
                    column[j]=matrix[i][j];
                }*/
            }

        }
        //矩阵归一化
        Double[][] matrixColumn= new Double[arrLen][arrLen];
        for(int j=0;j<arrLen;j++){
            for(int i=0;i<arrLen;i++){
                matrixColumn[i][j]=matrix[i][j]/column[j];
            }

        }
        //获得行数组
        Double[] line=new Double[arrLen];
        for(int i=0;i<arrLen;i++){
            for(int j=0;j<arrLen;j++){
                if(line[i]!=null){
                    line[i]=line[i]+matrixColumn[i][j];
                }else{
                    line[i]=matrixColumn[i][j];
                }
            }

        }
        //行归一化获得特征向量
        Double[] w=new Double[arrLen];
        Double sum=0.0;
        for(int i=0;i<arrLen;i++){
            sum=sum+line[i];
        }
        for(int i=0;i<arrLen;i++){
            w[i]=line[i]/sum;                    //特征向量
        }
        Double[] bw=new Double[arrLen];
        for(int i=0;i<arrLen;i++){
            for(int j=0;j<arrLen;j++){
                if(bw[i]!=null){
                    bw[i]=bw[i]+matrix[i][j]*w[j];
                }else{
                    bw[i]=matrix[i][j]*w[j];
                }
            }
        }
        Double sumR=0.0;                        //最大特征跟R
        for(int i=0;i<arrLen;i++){
            sumR=sumR+bw[i]/(arrLen*w[i]);
        }
        Double ci=(sumR-arrLen)/(arrLen-1);                //矩阵一致性指标
        System.out.println("计算出的矩阵一致性指标"+ci+"\n");
        Double cr=ci/1.24;                        //随机一致性比率 1.24为6阶矩阵的平均一致性指标
        if(cr>=0.1){
            System.out.println("权重设置不合理");
        }else{
            //输出特征向量
            for(int i=0;i<arrLen;i++){
                System.out.println("特征"+i+"的权重："+w[i]);
            }
        }

    }
    /**
     * 指标归一化计算，最终值越大越好
     * @param ahqPropertityList
     * @return
     */
    private Map<String, Double> calcNormalization(List<AhqProperty> ahqPropertityList) {
        //List<Double> valueList = ahqPropertityList.stream().map(AhqProperty::getValue).collect(Collectors.toList());
       // double[] arr = new double[valueList.size()];
/*        for (int i = 0; i < valueList.size(); i++) {
            arr[i] = valueList.get(i);
        }*/
        Map<String, Double> map = new HashMap<>();
        double min = getMinInArr(ahqPropertityList);
        double max = getMaxInArr(ahqPropertityList);
        for (AhqProperty ahqProperty : ahqPropertityList) {
            double tmp;
            if (ahqProperty.isActive()) {
                tmp = activeIndicator(min, max, ahqProperty.getValue());
            }else {
                tmp = negativeIndicator(min, max, ahqProperty.getValue());
            }
            map.put(ahqProperty.getName(), tmp);
        }
        return map;
    }

    private double activeIndicator(double min, double max, double value) {
/*        double[] calc = checkAndGet(arr);
        double min = calc[0];
        double max = calc[1];*/
        if (max == min) {
            return 1;
        }
        return (value - min) / (max - min);
    }

    private double negativeIndicator(double min, double max, double value) {
        //double[] calc = checkAndGet(arr);
/*        double min = calc[0];
        double max = calc[1];*/
        if (min == max) {
            return 1;
        }
        return (max - value) / (max - min);

    }

/*    private double[] checkAndGet(double[] arr) {
        //最小值、 最大值
        double[] result = {0, 0};
        if (arr.length == 0) {
            return result;
        }
        double min = getMinInArr(arr);
        double max = getMaxInArr(arr);
        result[0] = min;
        result[1] = max;
        return result;
    }*/

    private double getMaxInArr(List<AhqProperty> arr) {
        Optional<Double> optional = arr.stream().map(AhqProperty::getValue).max(Double::compareTo);
        if (optional.isPresent()) {
            return optional.get();
        }
        return 0;
    }

    private double getMinInArr(List<AhqProperty> arr) {
        Optional<Double> optional = arr.stream().map(AhqProperty::getValue).min(Double::compareTo);
        if (optional.isPresent()) {
            return optional.get();
        }
        return 0;
    }
}

/**
 * 层次分析法-传参属性
 */
@Data
class AhqProperty {

    /**
     * 属性名称
     */
    private String name;

    /**
     * 属性值
     */
    private double value;

    /**
     * 属性性质：true：正向属性（效益型）、 false：负向属性（成本型）
     */
    private boolean isActive;
}