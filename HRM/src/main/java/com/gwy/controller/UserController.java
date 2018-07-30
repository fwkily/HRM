package com.gwy.controller;

import com.gwy.model.*;
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
    @Resource
    private RecruitService recruitService;
    @Resource
    private InterviewService interviewService;
    @RequestMapping("/checkName")
    public void checkName(User user, HttpServletRequest request, HttpServletResponse response) throws Exception{
        System.out.println(user.getU_name());
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
    public String user(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpServletRequest request,HttpSession session) throws Exception{
        int state = 1;
        int pageSize = 10;
        User user = (User) session.getAttribute("user");
        int totalRows=recruit_informationService.getRecruit_InformationByRiState(state);
        int totalPages = DoPage.getTotalPages(totalRows,pageSize);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Recruit_Information> recruitInformations = recruit_informationService.queryCurrentPageRecruit_InformationByRiState(state,begin,end);
        List<Resume> resumes = resumeService.getResumesByUser(user);
        request.setAttribute("resumes",resumes);
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
        List<Resume> resumes = resumeService.queryCurrentResumeByUser(user.getU_id(),begin,end);
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
        return "redirect:myResume";
    }
    @RequestMapping("/updateresume")
    public String updateresume(int re_id,HttpSession session,HttpServletRequest request) throws Exception{
        Resume resume=resumeService.getResumeByReid(re_id);
        request.setAttribute("resume",resume);
        return "updateResume";
    }
    @RequestMapping("/updateResume")
    public String updateResume(Resume resume) throws Exception{
        resumeService.updateResume(resume);
        return "redirect:myResume";
    }
    @RequestMapping("/deleteResume")
    public String deleteResume(Resume resume) throws Exception{
        resumeService.deleteResume(resume);
        return "redirect:myResume";
    }
    @RequestMapping("/checkResume")
    public String checkResume(Resume resume) throws Exception{
        resumeService.deleteResume(resume);
        return "redirect:myResume";
    }
    @RequestMapping("/sendResume")
    public void sendResume(int ri_id,int re_id,HttpSession session,HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        User user = (User) session.getAttribute("user");
        Recruit recruit=recruitService.getRecruitByUserRe(user.getU_id(),ri_id);//查看当前用户对该条招聘信息是否投递过简历
        if (recruit!=null){
            response.getWriter().print("该职位你已经投递简历");
        }else {
            recruit=new Recruit(new Recruit_Information(ri_id),new Resume(re_id),0);
            recruitService.addRecruit(recruit);
            response.getWriter().print("投递简历成功");
        }
    }
    @RequestMapping("/myInterview")
    public String myInterview(@RequestParam(value = "i_state",defaultValue = "0")int i_state,@RequestParam(value = "currentPage",defaultValue = "1")int currentPage,HttpSession session,HttpServletRequest request) throws Exception{
        User user = (User) session.getAttribute("user");
        int pageSize = 10;
        int totalRows=interviewService.getInterviewByUidIstate(user.getU_id(),i_state);
        int totalPages = DoPage.getTotalPages(totalRows,pageSize);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Interview> interviews = interviewService.queryCurrentInterviewByUidIstate(user.getU_id(),i_state,begin,end);
        request.setAttribute("interviews",interviews);
        request.setAttribute("i_state",i_state);
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("totalPages",totalPages);
        return "myInterview";
    }
    @RequestMapping("/jion")
    public void jion(int i_id,HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        Interview interview = interviewService.getInterviewByIid(i_id);
        interview.setI_state(1);
        interviewService.updateInterview(interview);
        response.getWriter().print("已参加此次面试，请做好准备");
    }
    @RequestMapping("/refuseInterview")
    public void refuseInterview(int i_id,HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        Interview interview = interviewService.getInterviewByIid(i_id);
        interview.setI_state(2);
        interviewService.updateInterview(interview);
        response.getWriter().print("已拒绝此次面试，请珍惜每一次面试机会");
    }
}
