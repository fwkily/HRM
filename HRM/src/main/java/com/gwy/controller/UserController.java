package com.gwy.controller;

import com.gwy.model.User;
import com.gwy.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by destiny on 2018/7/18/0018.
 */
@Controller
public class UserController {
    @Resource
    private UserService userService;
    @RequestMapping("/checkName")
    public void checkName(User user, HttpServletRequest request, HttpServletResponse response) throws Exception{
        System.out.println(user.getUname());
        response.setContentType("text/html;charset=utf-8");
        User user1 = userService.getUserByName(user);
        if (user1==null){
            response.getWriter().print("可以注册");
        }else{
            response.getWriter().print("已有该用户");
        }
    }
    @RequestMapping("/register")
    public String register(User user, HttpSession session, Model model) throws Exception{
        User user1 = userService.getUserByName(user);
        if (null==user1){
            userService.addUser(user);
            return "../../login";
        }
        model.addAttribute("str","该用户名已存在");
        return "../../register";
    }
    @RequestMapping("/login")
    public String login(User user, HttpSession session, Model model) throws Exception{
        User user1 = userService.getUserByNamePass(user);
        if (null!=user1){
            session.setAttribute("user",user1);
            return "redirect:user";
        }
        model.addAttribute("str","用户名或密码错误");
        return "../../login";
    }
    @RequestMapping("/")
    public String index(HttpServletRequest request) throws Exception{

        return "../../index";
    }
    /*
    @RequestMapping("/user")
    public String user(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpServletRequest request) throws Exception{
        int state = 1;
        int pageSize = 10;
        List<Good> goodList = goodService.getGoodByState(state);
        int totalRows  = goodList.size();
        int totalPages = DoPage.getTotalPages(totalRows,pageSize);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Good> goods = goodService.queryCurrentPageGoodByState(state,begin,end);
        request.setAttribute("goods",goods);
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("totalPages",totalPages);
        return "user";
    }
    @RequestMapping("/changePassWord")
    public String changePassWord(String oldPassWord,String newPassWord, HttpSession session) throws Exception{
        User user = (User) session.getAttribute("user");
        if (oldPassWord.equals(user.getUpass())){
            user.setUpass(newPassWord);
            userService.updateUser(user);
            return "../../login";
        }
        session.setAttribute("error","密码错误");
        return "redirect:myUserDetail";
    }
    @RequestMapping("/chongZhi")
    public String chongZhi(double money, HttpSession session) throws Exception{
        User user = (User) session.getAttribute("user");
        user.setUmoney(user.getUmoney()+money);
        userService.updateUser(user);
        session.setAttribute("user",user);
        return "redirect:myUserDetail";
    }
    @RequestMapping("/index")
    public String index(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpServletRequest request) throws Exception{
        int state = 1;
        int pageSize = 10;
        List<Good> goodList = goodService.getGoodByState(state);
        int totalRows  = goodList.size();
        int totalPages = DoPage.getTotalPages(totalRows,pageSize);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Good> goods = goodService.queryCurrentPageGoodByState(state,begin,end);
        request.setAttribute("goods",goods);
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("totalPages",totalPages);
        return "../../index";
    }*/
}
