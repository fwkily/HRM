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
import java.util.Date;
import java.util.List;

/**
 * Created by destiny on 2018/7/18/0018.
 */
@Controller
public class StaffController {
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
    @Resource
    private InterviewService interviewService;
    @Resource
    private CultivateService cultivateService;
    @Resource
    private AttendanceService attendanceService;
    @Resource
    private RapService rapService;
    @RequestMapping("/staffLogin")
    public String staffLogin(Staff staff, HttpSession session, Model model) throws Exception{
        staff = staffService.getStaffByNamePass(staff);
        if (null!=staff){
            session.setAttribute("staff",staff);
            return "redirect:staff";
        }
        model.addAttribute("str","用户名或密码错误");
        return "../../staffLogin";
    }
    @RequestMapping("/staff")
    public String staff(@RequestParam(value = "s_state",defaultValue = "1")int s_state,@RequestParam(value = "d_id",defaultValue = "0")int d_id,@RequestParam(value = "j_id",defaultValue = "0")int j_id,@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpServletRequest request,HttpSession session) throws Exception{
        List<Department> departments = departmentService.getDepartment();
        int pageSize = 10;
        int totalRows=staffService.getStaffByDidJidState(d_id,j_id,s_state);
        int totalPages = DoPage.getTotalPages(totalRows,pageSize);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Staff> staffs = staffService.queryCurrentPageStaffByDidJidState(d_id,j_id,s_state,begin,end);
        request.setAttribute("departments",departments);
        request.setAttribute("s_state",s_state);
        request.setAttribute("d_id",d_id);
        request.setAttribute("j_id",j_id);
        request.setAttribute("staffs",staffs);
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("totalPages",totalPages);
        return "staff";
    }
    @RequestMapping("/staffDetail")
    public String staffDetail() throws Exception{
        return "staffDetail";
    }
    @RequestMapping("/updateDetail")
    public String updateDetail() throws Exception{
        return "updateDetail";
    }
    @RequestMapping("/updateD")
    public String updateD(Staff staff,HttpSession session) throws Exception{
        staffService.updateStaff(staff);
        staff=staffService.getStaffBySid(staff.getS_id());
        session.setAttribute("staff",staff);
        return "redirect:staffDetail";
    }
    @RequestMapping("/cultivateMessage")
    public String cultivateMessage(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpServletRequest request,HttpSession session) throws Exception{
        Staff staff = (Staff) session.getAttribute("staff");
        int pageSize = 10;
        int totalRows=cultivateService.getCountBySid(staff.getS_id());
        int totalPages = DoPage.getTotalPages(totalRows,pageSize);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Cultivate> cultivates=cultivateService.getCultivateBySid(staff.getS_id(),begin,end);
        request.setAttribute("cultivates",cultivates);
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("totalPages",totalPages);
        return "cultivateMessage";
    }
    @RequestMapping("/attendanceMessage")
    public String attendanceMessage(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpServletRequest request,HttpSession session) throws Exception{
        Staff staff = (Staff) session.getAttribute("staff");
        int pageSize = 10;
        int totalRows=attendanceService.getCountMonthBySid(staff.getS_id());
        int totalPages = DoPage.getTotalPages(totalRows,pageSize);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Attendance> attendances=attendanceService.queryCountMonthBySid(staff.getS_id(),begin,end);
        request.setAttribute("attendances",attendances);
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("totalPages",totalPages);
        return "attendanceMessage";
    }
    @RequestMapping("/on")
    public void on(HttpSession session,HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        Staff staff = (Staff) session.getAttribute("staff");
        Attendance attendance = new Attendance();
        attendance.setStaff(staff);
        int count = attendanceService.getCountDayBySid(staff.getS_id());
        if (count!=0){
            response.getWriter().print("该天已打上班卡");
        }else{
            attendanceService.addAttendance(attendance);
            response.getWriter().print("打上班卡成功");
        }
    }
    @RequestMapping("/off")
    public void off(HttpSession session,HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        Staff staff = (Staff) session.getAttribute("staff");
        Attendance attendance = new Attendance();
        attendance.setStaff(staff);
        int count = attendanceService.getCountDayBySid(staff.getS_id());
        if (count==0){
            response.getWriter().print("该天未打上班卡，请联系管理员");
            return;
        }else {
            attendance = attendanceService.getAttendanceBySid(staff.getS_id());
            if (attendance.getA_state() == 0) {//第一次打下班卡
                attendanceService.off(attendance.getA_id());//打下班卡
                attendance = attendanceService.getAttendanceBySid(staff.getS_id());//获取打卡记录
                double on_Minutes = attendanceService.getOnMinutes(staff.getS_id());//上班打卡
                double off_Minutes = attendanceService.getOffMinutes(staff.getS_id());//下班打卡
                if (on_Minutes >= 0) {//上班打卡9:00之前
                    if (off_Minutes >= 0) {//下班打卡18:00之后
                        if (off_Minutes <= 30) {//下班打卡18:30之前
                            attendance.setA_state(1);//正常上班打卡
                            attendanceService.updateAttendance(attendance);
                            response.getWriter().print("正常下班打卡");
                            return;
                        } else {//下班打卡18:30之后 加班
                            attendance.setA_state(2);//正常加班打卡
                            attendanceService.updateAttendance(attendance);
                            response.getWriter().print("正常加班打卡");
                            return;
                        }
                    } else if (off_Minutes > -180) {//下班打卡18:00之前 15:00之后 早退
                        attendance.setA_state(3);//早退打卡
                        attendanceService.updateAttendance(attendance);
                        Rap rap = new Rap(-100, staff, "早退");
                        rapService.addRap(rap);
                        response.getWriter().print("早退打卡");
                        return;
                    } else {//下班打卡15:00之前 旷工
                        attendance.setA_state(7);//旷工打卡
                        attendanceService.updateAttendance(attendance);
                        response.getWriter().print("早退超3小时旷工打卡");
                        return;
                    }
                } else if (on_Minutes > -180) {//上班打卡9:00之后 12:00之前 迟到
                    if (off_Minutes >= 0) {//下班打卡18:00之后
                        if (off_Minutes <= 30) {//下班打卡18:30之前
                            attendance.setA_state(4);//迟到打卡
                            attendanceService.updateAttendance(attendance);
                            Rap rap = new Rap(-100, staff, "迟到");
                            rapService.addRap(rap);
                            response.getWriter().print("迟到打卡");
                            return;
                        } else {//下班打卡18:30之后 加班
                            attendance.setA_state(5);//迟到加班打卡
                            attendanceService.updateAttendance(attendance);
                            Rap rap = new Rap(-100, staff, "迟到");
                            rapService.addRap(rap);
                            response.getWriter().print("迟到加班打卡");
                            return;
                        }
                    } else if (off_Minutes > -180) {//下班打卡18:00之前 15:00之前 早退
                        if ((on_Minutes + off_Minutes) <= -180) {
                            attendance.setA_state(7);//迟到早退旷工打卡
                            attendanceService.updateAttendance(attendance);
                            response.getWriter().print("迟到早退超3小时旷工打卡");
                            return;
                        } else {
                            attendance.setA_state(6);//迟到加早退打卡
                            attendanceService.updateAttendance(attendance);
                            Rap rap = new Rap(-100, staff, "迟到");
                            Rap rap1 = new Rap(-100, staff, "早退");
                            rapService.addRap(rap);
                            rapService.addRap(rap1);
                            response.getWriter().print("迟到加早退打卡");
                            return;
                        }
                    } else {//下班打卡15:00之前 旷工
                        attendance.setA_state(7);//早退超3小时旷工打卡
                        attendanceService.updateAttendance(attendance);
                        response.getWriter().print("早退超3小时旷工打卡");
                        return;
                    }
                } else {//上班打卡12:00之后 旷工
                    attendance.setA_state(7);//迟到超3小时旷工旷工打卡
                    attendanceService.updateAttendance(attendance);
                    response.getWriter().print("迟到超3小时旷工打卡");
                    return;
                }
            } else if (attendance.getA_state() == 1) {
                attendance.setA_state(2);//变成加班打卡
                attendanceService.updateAttendance(attendance);
                attendanceService.off(attendance.getA_id());//打加班卡
                response.getWriter().print("加班打卡");
                return;
            } else if (attendance.getA_state() == 2) {
                attendanceService.off(attendance.getA_id());//打加班卡
                response.getWriter().print("加班时间更新成功");
                return;
            } else if (attendance.getA_state() == 4) {
                attendance.setA_state(5);//迟到变迟到加班
                attendanceService.updateAttendance(attendance);
                attendanceService.off(attendance.getA_id());//打加班卡
                response.getWriter().print("加班打卡");
                return;
            } else if (attendance.getA_state() == 5) {
                attendanceService.off(attendance.getA_id());//打加班卡
                response.getWriter().print("加班时间更新成功");
                return;
            } else if (attendance.getA_state() == 7) {
                attendance.setA_state(8);//旷工变旷工加班
                attendanceService.updateAttendance(attendance);
                attendanceService.off(attendance.getA_id());//打加班卡
                response.getWriter().print("加班打卡");
                return;
            }else if (attendance.getA_state() == 8) {
                attendanceService.off(attendance.getA_id());//打加班卡
                response.getWriter().print("加班时间更新成功");
                return;
            } else {
                response.getWriter().print("打卡异常，请联系管理员");
                return;
            }
        }
    }
}
