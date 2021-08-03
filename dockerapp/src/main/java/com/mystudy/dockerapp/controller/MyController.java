package com.mystudy.dockerapp.controller;

import com.mystudy.dockerapp.annotation.MyAnnotation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：songdalin
 * @date ：2021-07-18 下午 08:26
 * @description：
 * @modified By：
 * @version: 1.0
 */
@RestController
@RequestMapping("/api")
public class MyController {

    @GetMapping("/get")
    public String get(String name, String password, String type) {
       return "name: " + name + "password: " + password + "type: " + type;
    }

    @PostMapping("/submit")
    public String submit(){
        return "submit success";
    }

    @MyAnnotation(name = "this is cancle")
    @GetMapping("/cancle")
    public String cancle() {
        return "cancle success";
    }

    @GetMapping("/testnot/{str}")
    public String test(@PathVariable("str") @NotNull(message = "not null~~") String str) {
        return str;
    }

    @GetMapping("/login")
    public Rtn login(String username, String password, HttpServletResponse response) {
        //response.setHeader("Access-Control-Allow-Origin", "*");
        //response.setHeader("Cache-Control", "no-cahce");
        Rtn rtn = new Rtn();
        if ("admin".equals(username) && "123456".equals(password)) {
            rtn.setMsg("ok");
            return rtn;
        }
        throw new RuntimeException("用户名和密码错误");
    }

    @GetMapping("/getaxios")
    public AxiosEntity getAxiosTest() {
        AxiosEntity axiosEntity = new AxiosEntity();
        axiosEntity.setId(1);
        axiosEntity.setMe(true);
        List<Axios> objects = new ArrayList<>();
        Axios axios = new Axios();
        axios.setAge(10);
        axios.setName("大喵");
        objects.add(axios);
        axiosEntity.setObject(axios);
        axiosEntity.setObjects(objects);
        return axiosEntity;
    }

}

class Rtn{
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Rtn(String msg) {
        this.msg = msg;
    }

    private String msg;

    public Rtn() {
    }
}

class AxiosEntity{

    private Integer id;

    private Boolean isMe;

    private Axios object;

    private List<Axios> objects;

    public AxiosEntity(Integer id, Boolean isMe, Axios object, List<Axios> objects) {
        this.id = id;
        this.isMe = isMe;
        this.object = object;
        this.objects = objects;
    }

    public AxiosEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getMe() {
        return isMe;
    }

    public void setMe(Boolean me) {
        isMe = me;
    }

    public Axios getObject() {
        return object;
    }

    public void setObject(Axios object) {
        this.object = object;
    }

    public List<Axios> getObjects() {
        return objects;
    }

    public void setObjects(List<Axios> objects) {
        this.objects = objects;
    }
}


class Axios{
    private Integer age;
    private String name;

    public Axios(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public Axios() {
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

