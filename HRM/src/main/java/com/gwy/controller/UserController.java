package com.gwy.controller;

import com.gwy.model.Recruit_Information;
import com.gwy.model.Resume;
import com.gwy.model.User;
import com.gwy.service.*;
import com.gwy.util.DoPage;
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
    @Resource
    private DepartmentService departmentService;
    @Resource
    private JobService jobService;
    @Resource
    private ResumeService resumeService;
    @Resource
    private Recruit_InformationService recruit_informationService;
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
    public String begin(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage,HttpServletRequest request) throws Exception{
        int state = 1;
        int pageSize = 10;
        int totalRows=recruit_informationService.getRecruit_InformationByRiState(state);
        int totalPages = DoPage.getTotalPages(totalRows,pageSize);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Recruit_Information> recruitInformations = recruit_informationService.queryCurrentPageRecruit_InformationByRiState(state,begin,end);
        request.setAttribute("recruitInformations",recruitInformations);
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("totalPages",totalPages);
        return "../../begin";
    }
    @RequestMapping("/index")
    public String index(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage,HttpServletRequest request) throws Exception{
        int state = 1;
        int pageSize = 10;
        int totalRows=recruit_informationService.getRecruit_InformationByRiState(state);
        int totalPages = DoPage.getTotalPages(totalRows,pageSize);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Recruit_Information> recruitInformations = recruit_informationService.queryCurrentPageRecruit_InformationByRiState(state,begin,end);
        request.setAttribute("recruitInformations",recruitInformations);
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("totalPages",totalPages);
        return "../../begin";
    }
    @RequestMapping("/user")
    public String user(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpServletRequest request) throws Exception{
        int state = 1;
        int pageSize = 10;
        int totalRows=recruit_informationService.getRecruit_InformationByRiState(state);
        int totalPages = DoPage.getTotalPages(totalRows,pageSize);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Recruit_Information> recruitInformations = recruit_informationService.queryCurrentPageRecruit_InformationByRiState(state,begin,end);
        request.setAttribute("recruitInformations",recruitInformations);
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("totalPages",totalPages);
        return "user";
    }
    @RequestMapping("/myResume")
    public String myResume(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpServletRequest request,HttpSession session) throws Exception{
        User user = (User) session.getAttribute("user");
        int pageSize = 1;
        int totalRows=resumeService.getResumeByUser(user);
        int totalPages = DoPage.getTotalPages(totalRows,pageSize);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Resume> resumes = resumeService.queryCurrentResumeByUser(user.getUid(),begin,end);
        request.setAttribute("resumes",resumes);
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("totalPages",totalPages);
        return "myResume";
    }
    @RequestMapping("/addresume")
    public String addresume() throws Exception{
        return "addResume";
    }
    @RequestMapping("/addResume1")
    public String addResume(Resume resume,HttpSession session) throws Exception{
        User user = (User) session.getAttribute("user");
        resume.setUser(user);
        resumeService.addResume(resume);
        return "myResume";
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
