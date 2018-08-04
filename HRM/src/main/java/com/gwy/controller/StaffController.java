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
        model.addAttribute("str","�û������������");
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
            response.getWriter().print("�����Ѵ��ϰ࿨");
        }else{
            attendanceService.addAttendance(attendance);
            response.getWriter().print("���ϰ࿨�ɹ�");
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
            response.getWriter().print("����δ���ϰ࿨������ϵ����Ա");
            return;
        }else {
            attendance = attendanceService.getAttendanceBySid(staff.getS_id());
            if (attendance.getA_state() == 0) {//��һ�δ��°࿨
                attendanceService.off(attendance.getA_id());//���°࿨
                attendance = attendanceService.getAttendanceBySid(staff.getS_id());//��ȡ�򿨼�¼
                double on_Minutes = attendanceService.getOnMinutes(staff.getS_id());//�ϰ��
                double off_Minutes = attendanceService.getOffMinutes(staff.getS_id());//�°��
                if (on_Minutes >= 0) {//�ϰ��9:00֮ǰ
                    if (off_Minutes >= 0) {//�°��18:00֮��
                        if (off_Minutes <= 30) {//�°��18:30֮ǰ
                            attendance.setA_state(1);//�����ϰ��
                            attendanceService.updateAttendance(attendance);
                            response.getWriter().print("�����°��");
                            return;
                        } else {//�°��18:30֮�� �Ӱ�
                            attendance.setA_state(2);//�����Ӱ��
                            attendanceService.updateAttendance(attendance);
                            response.getWriter().print("�����Ӱ��");
                            return;
                        }
                    } else if (off_Minutes > -180) {//�°��18:00֮ǰ 15:00֮�� ����
                        attendance.setA_state(3);//���˴�
                        attendanceService.updateAttendance(attendance);
                        Rap rap = new Rap(-100, staff, "����");
                        rapService.addRap(rap);
                        response.getWriter().print("���˴�");
                        return;
                    } else {//�°��15:00֮ǰ ����
                        attendance.setA_state(7);//������
                        attendanceService.updateAttendance(attendance);
                        response.getWriter().print("���˳�3Сʱ������");
                        return;
                    }
                } else if (on_Minutes > -180) {//�ϰ��9:00֮�� 12:00֮ǰ �ٵ�
                    if (off_Minutes >= 0) {//�°��18:00֮��
                        if (off_Minutes <= 30) {//�°��18:30֮ǰ
                            attendance.setA_state(4);//�ٵ���
                            attendanceService.updateAttendance(attendance);
                            Rap rap = new Rap(-100, staff, "�ٵ�");
                            rapService.addRap(rap);
                            response.getWriter().print("�ٵ���");
                            return;
                        } else {//�°��18:30֮�� �Ӱ�
                            attendance.setA_state(5);//�ٵ��Ӱ��
                            attendanceService.updateAttendance(attendance);
                            Rap rap = new Rap(-100, staff, "�ٵ�");
                            rapService.addRap(rap);
                            response.getWriter().print("�ٵ��Ӱ��");
                            return;
                        }
                    } else if (off_Minutes > -180) {//�°��18:00֮ǰ 15:00֮ǰ ����
                        if ((on_Minutes + off_Minutes) <= -180) {
                            attendance.setA_state(7);//�ٵ����˿�����
                            attendanceService.updateAttendance(attendance);
                            response.getWriter().print("�ٵ����˳�3Сʱ������");
                            return;
                        } else {
                            attendance.setA_state(6);//�ٵ������˴�
                            attendanceService.updateAttendance(attendance);
                            Rap rap = new Rap(-100, staff, "�ٵ�");
                            Rap rap1 = new Rap(-100, staff, "����");
                            rapService.addRap(rap);
                            rapService.addRap(rap1);
                            response.getWriter().print("�ٵ������˴�");
                            return;
                        }
                    } else {//�°��15:00֮ǰ ����
                        attendance.setA_state(7);//���˳�3Сʱ������
                        attendanceService.updateAttendance(attendance);
                        response.getWriter().print("���˳�3Сʱ������");
                        return;
                    }
                } else {//�ϰ��12:00֮�� ����
                    attendance.setA_state(7);//�ٵ���3Сʱ����������
                    attendanceService.updateAttendance(attendance);
                    response.getWriter().print("�ٵ���3Сʱ������");
                    return;
                }
            } else if (attendance.getA_state() == 1) {
                attendance.setA_state(2);//��ɼӰ��
                attendanceService.updateAttendance(attendance);
                attendanceService.off(attendance.getA_id());//��Ӱ࿨
                response.getWriter().print("�Ӱ��");
                return;
            } else if (attendance.getA_state() == 2) {
                attendanceService.off(attendance.getA_id());//��Ӱ࿨
                response.getWriter().print("�Ӱ�ʱ����³ɹ�");
                return;
            } else if (attendance.getA_state() == 4) {
                attendance.setA_state(5);//�ٵ���ٵ��Ӱ�
                attendanceService.updateAttendance(attendance);
                attendanceService.off(attendance.getA_id());//��Ӱ࿨
                response.getWriter().print("�Ӱ��");
                return;
            } else if (attendance.getA_state() == 5) {
                attendanceService.off(attendance.getA_id());//��Ӱ࿨
                response.getWriter().print("�Ӱ�ʱ����³ɹ�");
                return;
            } else if (attendance.getA_state() == 7) {
                attendance.setA_state(8);//����������Ӱ�
                attendanceService.updateAttendance(attendance);
                attendanceService.off(attendance.getA_id());//��Ӱ࿨
                response.getWriter().print("�Ӱ��");
                return;
            }else if (attendance.getA_state() == 8) {
                attendanceService.off(attendance.getA_id());//��Ӱ࿨
                response.getWriter().print("�Ӱ�ʱ����³ɹ�");
                return;
            } else {
                response.getWriter().print("���쳣������ϵ����Ա");
                return;
            }
        }
    }
}
