package org.xujin.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author xujin
 * @package-name org.xujin.springboot.controller
 * @createtime 2020-02-26 14:46
 */
@Controller
@RequestMapping("/user")
public class LoginController {
    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session){
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
            session.setAttribute("loginUser",username);
            //防止表单重复提交，使用请求重定向
            return "redirect:../main.html";
        }
        return "redirect:../";
    }
}
