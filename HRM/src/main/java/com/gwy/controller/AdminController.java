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
public class AdminController {
    @Resource
    private AdminService adminService;
    @Resource
    private UserService userService;
    @Resource
    private DepartmentService departmentService;
    @Resource
    private JobService jobService;
    @Resource
    private ResumeService resumeService;
    @Resource
    private StaffService staffService;
    @Resource
    private Recruit_InformationService recruit_informationService;
    @Resource
    private RecruitService recruitService;
    @RequestMapping("/adminLogin")
    public String adminLogin(Admin admin, HttpSession session, Model model) throws Exception{
        admin = adminService.getAdminByNamePass(admin);
        if (null!=admin){
            session.setAttribute("admin",admin);
            return "redirect:admin";
        }
        model.addAttribute("str","用户名或密码错误");
        return "../../adminLogin";
    }
    @RequestMapping("/admin")
    public String admin(@RequestParam(value = "s_state",defaultValue = "1")int s_state,@RequestParam(value = "d_id",defaultValue = "0")int d_id,@RequestParam(value = "j_id",defaultValue = "0")int j_id,@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpServletRequest request,HttpSession session) throws Exception{
        List<Department> departments = departmentService.getDepartment();
        List<Job> jobs = jobService.getJob();
        int pageSize = 10;
        int totalRows=staffService.getStaffByDidJidState(d_id,j_id,s_state);
        int totalPages = DoPage.getTotalPages(totalRows,pageSize);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Staff> staffs = staffService.queryCurrentPageStaffByDidJidState(d_id,j_id,s_state,begin,end);
        request.setAttribute("departments",departments);
        request.setAttribute("jobs",jobs);
        request.setAttribute("staffs",staffs);
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("totalPages",totalPages);
        return "admin";
    }
    @RequestMapping("/ri")
    public String ri(@RequestParam(value = "ri_state",defaultValue = "1")int ri_state,@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpServletRequest request,HttpSession session) throws Exception{
        int pageSize = 10;
        int totalRows=recruit_informationService.getRecruit_InformationByRiState(ri_state);
        int totalPages = DoPage.getTotalPages(totalRows,pageSize);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Recruit_Information> recruitInformations = recruit_informationService.queryCurrentPageRecruit_InformationByRiState(ri_state,begin,end);
        request.setAttribute("recruitInformations",recruitInformations);
        request.setAttribute("ri_state",ri_state);
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("totalPages",totalPages);
        return "ri";
    }
    @RequestMapping("/recall")
    public void recall(@RequestParam(value = "ri_id",defaultValue = "0")int ri_id,HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        Recruit_Information recruitInformation = recruit_informationService.getRecruit_InformationByRiid(ri_id);
        recruitInformation.setRi_state(0);
        recruitInformation.setRi_date(null);
        recruit_informationService.updateRecruit_Information(recruitInformation);
        response.getWriter().print("撤回成功");
    }
    @RequestMapping("/issue")
    public void issue(@RequestParam(value = "ri_id",defaultValue = "0")int ri_id, HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        Recruit_Information recruitInformation = recruit_informationService.getRecruit_InformationByRiid(ri_id);
        recruitInformation.setRi_state(1);
        recruit_informationService.updateRecruit_Information(recruitInformation);
        response.getWriter().print("发布成功");
    }
    @RequestMapping("/delete")
    public void delete(@RequestParam(value = "ri_id",defaultValue = "0")int ri_id, HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        recruit_informationService.deleteRecruit_Information(ri_id);
        response.getWriter().print("删除成功");
    }
    @RequestMapping("/alter")
    public String alter(@RequestParam(value = "ri_id",defaultValue = "0")int ri_id, HttpServletRequest request) throws Exception{
        Recruit_Information recruitInformation = recruit_informationService.getRecruit_InformationByRiid(ri_id);
        List<Department> departments = departmentService.getDepartment();
        List<Job> jobs = jobService.getJob();
        request.setAttribute("departments",departments);
        request.setAttribute("jobs",jobs);
        request.setAttribute("recruitInformation",recruitInformation);
        return "alter";
    }
    @RequestMapping("/addRi")
    public String addRi(HttpServletRequest request) throws Exception{
        List<Department> departments = departmentService.getDepartment();
        List<Job> jobs = jobService.getJob();
        request.setAttribute("departments",departments);
        request.setAttribute("jobs",jobs);
        return "alter";
    }
    @RequestMapping("/update")
    public String update(Recruit_Information recruit_information, HttpServletRequest request) throws Exception{
        if(recruit_information.getRi_id()==0){
            recruit_informationService.addRecruit_Information(recruit_information);
        }else{
            recruit_informationService.updateRecruit_Information(recruit_information);
        }
        return "redirect:ri";
    }
    @RequestMapping("/r")
    public String r(@RequestParam(value = "ri_state",defaultValue = "1")int ri_state,@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpServletRequest request) throws Exception{
        int pageSize = 10;
        int totalRows=recruit_informationService.getRecruit_InformationByRiState(ri_state);
        int totalPages = DoPage.getTotalPages(totalRows,pageSize);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Recruit_Information> recruitInformations = recruit_informationService.queryCurrentPageRecruit_InformationByRiState(ri_state,begin,end);
        request.setAttribute("recruitInformations",recruitInformations);
        request.setAttribute("ri_state",ri_state);
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("totalPages",totalPages);
        return "r";
    }
    @RequestMapping("/check")
    public String check(@RequestParam(value = "ri_id",defaultValue = "0")int ri_id,@RequestParam(value = "r_state",defaultValue = "0")int r_state,@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpServletRequest request) throws Exception{
        int pageSize = 1;
        int totalRows=recruitService.getRecruitByRiidRstate(ri_id,r_state);
        int totalPages = DoPage.getTotalPages(totalRows,pageSize);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Recruit> recruits = recruitService.queryCurrentPageRecruitByRiidRstate(ri_id,r_state,begin,end);
        if (!recruits.isEmpty()){
            Recruit recruit = recruits.get(0);
            recruit.setR_state(1);//取出的标记为已读
            recruitService.updateRecruit(recruit);
        }
        request.setAttribute("recruits",recruits);
        request.setAttribute("r_state",r_state);
        request.setAttribute("ri_id",ri_id);
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("totalPages",totalPages);
        return "check";
    }
}
