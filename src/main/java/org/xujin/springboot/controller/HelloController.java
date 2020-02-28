package org.xujin.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xujin.springboot.exception.UserNotExistException;

import java.util.Arrays;
import java.util.Map;

/**
 * @author xujin
 * @package-name org.xujin.springboot.controller
 * @createtime 2020-02-24 12:31
 */
@Controller
public class HelloController {
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(String user){
        if ("aaa".equals(user)){
            throw new UserNotExistException();
        }
        return "hello world";
    }

    //查出一些数据，在页面展示
    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","<h1>您好</h1>");
        map.put("users",Arrays.asList("zhangsan","lisi","wangwu"));
        return "success";
    }

//    @RequestMapping({"/","login.html"})
//    public String index(){
//        return "login";
//    }
}
