package org.xujin.springboot.controller;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xujin.springboot.exception.UserNotExistException;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xujin
 * @package-name org.xujin.springboot.controller
 * @createtime 2020-02-28 14:32
 */
@ControllerAdvice
public class MyExceptionHandler {
    //浏览器和客户端返回的都是json
    /*@ResponseBody
    @ExceptionHandler(UserNotExistException.class)
    public Map<String,Object> handlerException(Exception e){
        Map<String,Object> map = new HashMap<>();
        map.put("error","user not exist");
        map.put("message",e.getMessage());
        return  map;
    }*/

    @ExceptionHandler(UserNotExistException.class)
    public String handlerException(Exception e, HttpServletRequest request){
        request.setAttribute("javax.servlet.error.status_code",400);
        return  "forward:/error";
    }
}
