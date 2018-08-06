package com.gwy.controller;

import com.gwy.model.*;
import com.gwy.service.*;
import com.gwy.util.DateAndString;
import com.gwy.util.DoPage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.Date;
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
    @Resource
    private InterviewService interviewService;
    @Resource
    private CultivateService cultivateService;
    @Resource
    private AttendanceService attendanceService;
    @Resource
    private RapService rapService;
    @Resource
    private PayService payService;
    @RequestMapping("/adminLogin")
    public String adminLogin(Admin admin, HttpSession session, Model model) throws Exception{
        admin = adminService.getAdminByNamePass(admin);
        if (null!=admin){
            session.setAttribute("admin",admin);
            return "redirect:admin";
        }
        model.addAttribute("str","�û������������");
        return "../../adminLogin";
    }
    @RequestMapping("/admin")
    public String admin(@RequestParam(value = "s_state",defaultValue = "1")int s_state,@RequestParam(value = "d_id",defaultValue = "0")int d_id,@RequestParam(value = "j_id",defaultValue = "0")int j_id,@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpServletRequest request,HttpSession session) throws Exception{
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
        response.getWriter().print("���سɹ�");
    }
    @RequestMapping("/issue")
    public void issue(@RequestParam(value = "ri_id",defaultValue = "0")int ri_id, HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        Recruit_Information recruitInformation = recruit_informationService.getRecruit_InformationByRiid(ri_id);
        recruitInformation.setRi_state(1);
        recruit_informationService.updateRecruit_Information(recruitInformation);
        response.getWriter().print("�����ɹ�");
    }
    @RequestMapping("/delete")
    public void delete(@RequestParam(value = "ri_id",defaultValue = "0")int ri_id, HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        recruit_informationService.deleteRecruit_Information(ri_id);
        response.getWriter().print("ɾ���ɹ�");
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
            if (recruit.getR_state()==0){
                recruit.setR_state(1);//ȡ���ı��Ϊ�Ѷ�
                recruitService.updateRecruit(recruit);
            }
        }
        Recruit_Information recruitInformation=recruit_informationService.getRecruit_InformationByRiid(ri_id);
        request.setAttribute("recruits",recruits);
        request.setAttribute("recruitInformation",recruitInformation);
        request.setAttribute("r_state",r_state);
        request.setAttribute("ri_id",ri_id);
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("totalPages",totalPages);
        return "check";
    }
    @RequestMapping("/refuse")
    public String refuse(int ri_id,int r_id) throws Exception{
        Recruit recruit = recruitService.getRecruitByRid(r_id);
        recruit.setR_state(3);
        recruitService.updateRecruit(recruit);
        return "redirect:check?ri_id="+ri_id;
    }
    @RequestMapping("/interview")
    public String interview(int r_id, HttpServletRequest request) throws Exception{
        Recruit recruit = recruitService.getRecruitByRid(r_id);
        List<Staff> staffs=staffService.getStaffsByDidJidState(recruit.getRecruitInformation().getDepartment().getD_id(),0,1);
        request.setAttribute("recruit",recruit);
        request.setAttribute("staffs",staffs);
        return "interview";
    }
    @RequestMapping("/addInterview")
    public String addInterview(String mi_date,int r_id,Interview interview, HttpServletRequest request) throws Exception{
        mi_date=mi_date.replaceAll("T"," ");
        Date i_date= DateAndString.dateToStringTime(mi_date);
        Recruit recruit = recruitService.getRecruitByRid(r_id);
        recruit.setR_state(2);
        recruitService.updateRecruit(recruit);//����Ϊ����
        interview.setI_date(i_date);
        interview.setUser(recruit.getResume().getUser());//�����û�
        interview.setRecruit_Information(recruit.getRecruitInformation());//��Ƹ��Ϣ
        interviewService.addInterview(interview);
        int ri_id = recruit.getRecruitInformation().getRi_id();
        return "redirect:check?ri_id="+ri_id;
    }
    @RequestMapping("/interviewManage")
    public String interviewManage(@RequestParam(value = "i_state",defaultValue = "1")int i_state,int ri_id,@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpServletRequest request) throws Exception{
        int pageSize = 10;
        int totalRows=interviewService.getInterviewByRiid(ri_id,i_state);
        int totalPages = DoPage.getTotalPages(totalRows,pageSize);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Interview> interviews = interviewService.queryCurrentPageInterviewByRiid(ri_id,i_state,begin,end);
        request.setAttribute("interviews",interviews);
        request.setAttribute("ri_id",ri_id);
        request.setAttribute("i_state",i_state);
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("totalPages",totalPages);
        return "interviewManage";
    }
    @RequestMapping("/hire")
    public void hire(int i_id, HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        Interview interview =  interviewService.getInterviewByIid(i_id);
        int ri_id = interview.getRecruit_Information().getRi_id();
        int u_id = interview.getUser().getU_id();
        Recruit recruit=recruitService.getRecruitByUidRiid(u_id,ri_id);
        Recruit_Information recruitInformation = recruit.getRecruitInformation();
        Resume resume = recruit.getResume();
        Staff staff=new Staff(null,null,recruitInformation.getDepartment(),recruitInformation.getJob(),0,resume.getRe_name(),
                resume.getRe_sex(),resume.getRe_idcardno(),resume.getRe_birthday(),resume.getRe_phone(),
                resume.getRe_email(),resume.getRe_address(),resume.getRe_post(),resume.getRe_education(),
                resume.getRe_college(),resume.getRe_major(),resume.getRe_graduate(),resume.getRe_intro());
        staffService.addStaff(staff);
        int s_id = staff.getS_id();
        staff.setS_username("gwyhxl"+s_id);
        staff.setS_pass("gwyhxl"+s_id);
        interview.setI_state(3);
        interviewService.updateInterview(interview);
        staffService.updateStaff(staff);
        response.getWriter().print("¼�óɹ�");
    }
    @RequestMapping("/loadJob")
    @ResponseBody
    public Object loadJob(int d_id, HttpServletResponse response) throws Exception{
        List<Job> jobList = jobService.getJobByDid(d_id);
        /*String jobs=JSONArray.toJSONString(jobList);*/
        return jobList;
    }
    @RequestMapping("/organizationalManagement")
    public String organizationalManagement(HttpServletRequest request) throws Exception{
        List<Department> departments = departmentService.getDepartment();
        request.setAttribute("departments",departments);
        return "organizationalManagement";
    }
    @RequestMapping("/deld")
    public void deld(int d_id,HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        int count=staffService.countStaffByDid(d_id);//��ȡ�ò�������
        if (count==0){//û����ɾ��
            jobService.deleteJobByDid(d_id);//ɾ���ò�����ְλ
            departmentService.deleteDepartment(d_id);//ɾ���ò���
            response.getWriter().print("����ɾ���ɹ�");
        }else{
            response.getWriter().print("�ò��Ż���Ա��������ɾ��");
        }
    }
    @RequestMapping("/delj")
    public void delj(int j_id,HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        int count=staffService.countStaffByJid(j_id);//��ȡ��ְλ����
        if (count==0){//û����ɾ��
            jobService.deleteJobByJid(j_id);//ɾ����ְλ
            response.getWriter().print("ְλɾ���ɹ�");
        }else{
            response.getWriter().print("��ְλ����Ա��������ɾ��");
        }
    }
    @RequestMapping("/addd")
    public void addd(String d_name,HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        departmentService.addDepartment(d_name);
        response.getWriter().print("��Ӳ��ųɹ�");
    }
    @RequestMapping("/updated")
    public void updated(int d_id,String d_name,HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        departmentService.updateDepartment(d_id,d_name);
        response.getWriter().print("�޸Ĳ��ųɹ�");
    }
    @RequestMapping("/addj")
    public void addj(int d_id,double j_salary,String j_name,HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        jobService.addJob(d_id,j_name,j_salary);
        response.getWriter().print("���ְλ�ɹ�");
    }
    @RequestMapping("/updatej")
    public void updatej(int j_id,double j_salary,String j_name,HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        jobService.updateJob(j_id,j_name,j_salary);
        response.getWriter().print("�޸�ְλ�ɹ�");
    }
    @RequestMapping("/dimission")
    public void dimission(int s_id,String s_intro,HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        Staff staff = staffService.getStaffBySid(s_id);
        staff.setDepartment(new Department(0));
        staff.setJob(new Job(0));
        staff.setS_intro(s_intro);
        staff.setS_state(2);
        staffService.updateStaff(staff);
        response.getWriter().print("��ְ����ɹ�");
    }
    @RequestMapping("/positive")
    public void positive(int s_id,String s_intro,HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        double months = staffService.getMonthsBySid(s_id);
        if (months>=1){
            Staff staff = staffService.getStaffBySid(s_id);
            staff.setS_intro(s_intro);
            staff.setS_state(1);
            staffService.updateStaff(staff);
            response.getWriter().print("ת������ɹ�");
        }else{
            response.getWriter().print("�����ڲ���һ���²���ת��");
        }
    }
    @RequestMapping("/change")
    public void change(int s_id,int d_id,int j_id,HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        Staff staff = staffService.getStaffBySid(s_id);
        staff.getDepartment().setD_id(d_id);
        staff.getJob().setJ_id(j_id);
        staffService.updateStaff(staff);
        response.getWriter().print("ת�ڰ���ɹ�");
    }
    @RequestMapping("/cultivate")
    public String cultivate(@RequestParam(value = "c_state",defaultValue = "1")int c_state,@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpServletRequest request) throws Exception{
        int pageSize = 10;
        int totalRows=cultivateService.getCultivateByCstate(c_state);
        int totalPages = DoPage.getTotalPages(totalRows,pageSize);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Cultivate> cultivates = cultivateService.queryCurrentPageCultivateByCstate(c_state,begin,end);
        List<Department> departments=departmentService.getDepartment();
        request.setAttribute("departments",departments);
        request.setAttribute("cultivates",cultivates);
        request.setAttribute("c_state",c_state);
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("totalPages",totalPages);
        return "cultivate";
    }
    @RequestMapping("/addcultivate1")
    public String addcultivate1(HttpServletRequest request) throws Exception{
        List<Department> departments=departmentService.getDepartment();
        request.setAttribute("departments",departments);
        return "addCultivate";
    }
    @RequestMapping("/addcultivate")
    public String addcultivate(Cultivate cultivate,String begintime,String endtime,HttpServletRequest request) throws Exception{
        begintime=begintime.replaceAll("T"," ");
        Date c_begintime= DateAndString.dateToStringTime(begintime);
        endtime=endtime.replaceAll("T"," ");
        Date c_endtime= DateAndString.dateToStringTime(endtime);
        cultivate.setC_begintime(c_begintime);
        cultivate.setC_endtime(c_endtime);
        int c_id=cultivate.getC_id();
        if (c_id==0){
            cultivateService.addCultivate(cultivate);
        }else{
            cultivateService.updateCultivate(cultivate);
        }

        return "redirect:cultivate";
    }
    @RequestMapping("/issueCultivate")
    public void issueCultivate(int c_id,int d_id,HttpServletRequest request,HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        if (d_id==0){
            Calendar calendar=Calendar.getInstance();
            int day=calendar.get(calendar.DAY_OF_MONTH);
            if (day!=1){
                response.getWriter().print("ÿ��1�Ųſ��Է���������ѵ");
                return;
            }
            List<Staff> staffs = staffService.getStaffBySstate(0);
            for (Staff staff:staffs) {
                double months=staffService.getMonthsBySid(staff.getS_id());
                if (months<1){
                    staffService.addCultivate(staff.getS_id(),c_id);
                }
            }
        }else{
            List<Staff> staffs = staffService.getStaffByDid(d_id);
            for (Staff staff:staffs) {
                staffService.addCultivate(staff.getS_id(),c_id);
            }
        }
        Cultivate cultivate = cultivateService.getCultivateByCid(c_id);
        cultivate.setC_state(1);
        cultivate.setC_issuetime(new Date());
        cultivateService.updateCultivate(cultivate);
        response.getWriter().print("��ѵ�����ɹ�");
    }
    @RequestMapping("/recallCultivate")
    public void recallCultivate(int c_id,HttpServletRequest request,HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        double minutes = cultivateService.getMinutesByCid(c_id);
        if(minutes>10){
            response.getWriter().print("�ѷ���10���ӣ����ܳ���");
        }else {
            staffService.deleteCultivate(c_id);
            Cultivate cultivate = new Cultivate();
            cultivate.setC_state(0);
            cultivate.setC_id(c_id);
            cultivateService.updateCultivate(cultivate);
            response.getWriter().print("��ѵ���سɹ�");
        }
    }
    @RequestMapping("/updateCultivate1")
    public String updateCultivate1(int c_id,HttpServletRequest request) throws Exception{
        Cultivate cultivate = cultivateService.getCultivateByCid(c_id);
        request.setAttribute("cultivate",cultivate);
        return "addCultivate";
    }
    @RequestMapping("/staffAttendance")
    public String staffAttendance(int s_id,@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpServletRequest request) throws Exception{
        int pageSize = 10;
        int totalRows=attendanceService.getCountMonthBySid(s_id);
        int totalPages = DoPage.getTotalPages(totalRows,pageSize);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Attendance> attendances = attendanceService.queryCountMonthBySid(s_id,begin,end);
        request.setAttribute("attendances",attendances);
        request.setAttribute("s_id",s_id);
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("totalPages",totalPages);
        return "staffAttendance";
    }
    @RequestMapping("/staffCultivate")
    public String staffCultivate(int s_id,@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpServletRequest request) throws Exception{
        int pageSize = 10;
        int totalRows=cultivateService.getCountBySid(s_id);
        int totalPages = DoPage.getTotalPages(totalRows,pageSize);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Cultivate> cultivates = cultivateService.getCultivateBySid(s_id,begin,end);
        request.setAttribute("cultivates",cultivates);
        request.setAttribute("s_id",s_id);
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("totalPages",totalPages);
        return "staffCultivate";
    }
    @RequestMapping("/staffInformation")
    public String staffInformation(int s_id,HttpServletRequest request) throws Exception{
        Staff staff = staffService.getStaffBySid(s_id);
        request.setAttribute("staff",staff);
        return "staffInformation";
    }
    @RequestMapping("/attendanceInformation")
    public String attendanceInformation(@RequestParam(value = "d_id",defaultValue = "0")int d_id,@RequestParam(value = "j_id",defaultValue = "0")int j_id,@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpServletRequest request,HttpSession session) throws Exception{
        List<Department> departments = departmentService.getDepartment();
        int pageSize = 10;
        int totalRows=attendanceService.getCountDayByDidJid(d_id,j_id);
        int totalPages = DoPage.getTotalPages(totalRows,pageSize);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Attendance> attendances = attendanceService.queryCurrentPageStaffDayByDidJid(d_id,j_id,begin,end);
        request.setAttribute("departments",departments);
        request.setAttribute("d_id",d_id);
        request.setAttribute("j_id",j_id);
        request.setAttribute("attendances",attendances);
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("totalPages",totalPages);
        return "attendanceInformation";
    }
    @RequestMapping("/rap")
    public String rap(@RequestParam(value = "d_id",defaultValue = "0")int d_id,@RequestParam(value = "j_id",defaultValue = "0")int j_id,@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpServletRequest request,HttpSession session) throws Exception{
        List<Department> departments = departmentService.getDepartment();
        int pageSize = 10;
        int totalRows=rapService.getCountDayByDidJid(d_id,j_id);
        int totalPages = DoPage.getTotalPages(totalRows,pageSize);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Rap> raps = rapService.queryCurrentPageStaffDayByDidJid(d_id,j_id,begin,end);
        request.setAttribute("departments",departments);
        request.setAttribute("d_id",d_id);
        request.setAttribute("j_id",j_id);
        request.setAttribute("raps",raps);
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("totalPages",totalPages);
        return "rap";
    }
    @RequestMapping("/pay")
    public String pay(@RequestParam(value = "d_id",defaultValue = "0")int d_id,@RequestParam(value = "j_id",defaultValue = "0")int j_id,@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpServletRequest request,HttpSession session) throws Exception{
        List<Department> departments = departmentService.getDepartment();
        int pageSize = 10;
        int totalRows=payService.getPayByDidJid(d_id,j_id);
        int totalPages = DoPage.getTotalPages(totalRows,pageSize);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Pay> pays = payService.queryCurrentPagePayByDidJid(d_id,j_id,begin,end);
        request.setAttribute("departments",departments);
        request.setAttribute("d_id",d_id);
        request.setAttribute("j_id",j_id);
        request.setAttribute("pays",pays);
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("totalPages",totalPages);
        return "pay";
    }
    @RequestMapping("/payCalculation")//���ʽ���
    public void payCalculation(HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        Calendar calendar=Calendar.getInstance();
        int day=calendar.get(calendar.DAY_OF_MONTH);
        /*if (day!=1){
            response.getWriter().print("ÿ��1�Ųſ��Խ����ϸ��¹���");
            return;
        }*/
        int count = payService.getCountMonthPay();
        if (count!=0){
            response.getWriter().print("�����Ѿ������ϸ��¹���");
            return;
        }
        List<Staff> staffs = staffService.getStaffBySstate(0);//���������ڹ���
        for (Staff staff:staffs) {
            double p_base = 0.0;//������8��
            double p_performance = staff.getJob().getJ_salary()*0.3;//��Ч����*0.3
            double p_overtime = 0.0;//�Ӱ��
            double overtime = 0.0;//�Ӱ��
            double p_rap = 0.0;//����
            double p_ss = staff.getJob().getJ_salary()*(-0.25);//�籣��0.25
            double p_pay = 0.0;//
            int count1 = attendanceService.getCountLastMonthBySid(staff.getS_id());//�����ϰ�1���Ӱ�2������3���ٵ�4 ���ٵ��Ӱ�5���ٵ����� 6���������ϰ�����
            if(count1<22){
                p_base=(staff.getJob().getJ_salary()*0.8)/22*count1;//��ʵ�ʰ������㹤��
            }else if (count1==22){
                p_base=staff.getJob().getJ_salary()*0.8;//����8��
            }else{
                p_base=staff.getJob().getJ_salary()*0.8;//����8��
                overtime=8*60*(count1-22);//����ϰ�������Ӱ�ÿ��8Сʱ
            }
            List<Attendance> attendances = attendanceService.getAttendanceLastMonthBySid(staff.getS_id());//��ȡ�ϸ��¼Ӱ�Ŀ��� �Ӱ�2���ٵ��Ӱ�5�������Ӱ�8
            for (Attendance attendance:attendances) {
                double off_Minutes = attendanceService.getOffMinutesByAid(attendance.getA_id());//ÿһ���Ӱ��¼�ļӰ�ʱ��
                overtime+=off_Minutes;//����ÿһ���Ӱ��¼�ļӰ�ʱ��
            }
            p_overtime=overtime/60*50;//�Ӱ��ÿСʱ50
            List<Rap> raps = rapService.getRapLastMonthBySid(staff.getS_id());
            for (Rap rap:raps) {
                p_rap+=rap.getRa_money();//����ÿһ�����ͼ�¼
            }
            p_pay=p_base+p_performance+p_overtime+p_rap+p_ss;
            Pay pay = new Pay(staff,p_base,p_performance,p_overtime,p_rap,p_ss,p_pay,0);
            payService.addPay(pay);
        }
        List<Staff> staffs1 = staffService.getStaffBySstate(0);//������ʽԱ������
        for (Staff staff:staffs1) {
            double p_base = 0.0;//
            double p_performance = staff.getJob().getJ_salary()*0.3;//��Ч����*0.3
            double p_overtime = 0.0;//�Ӱ��
            double overtime = 0.0;//�Ӱ��
            double p_rap = 0.0;//����
            double p_ss = staff.getJob().getJ_salary()*(-0.25);//�籣��0.25
            double p_pay = 0.0;//
            int count1 = attendanceService.getCountLastMonthBySid(staff.getS_id());//�����ϰ�1���Ӱ�2������3���ٵ�4 ���ٵ��Ӱ�5���ٵ����� 6���������ϰ�����
            if(count1<22){
                p_base=staff.getJob().getJ_salary()/22*count1;//��ʵ�ʰ������㹤��
            }else if (count1==22){
                p_base=staff.getJob().getJ_salary();//����8��
            }else{
                p_base=staff.getJob().getJ_salary();//����8��
                overtime=8*60*(count1-22);//����ϰ�������Ӱ�ÿ��8Сʱ
            }
            List<Attendance> attendances = attendanceService.getAttendanceLastMonthBySid(staff.getS_id());//��ȡ�ϸ��¼Ӱ�Ŀ��� �Ӱ�2���ٵ��Ӱ�5�������Ӱ�8
            for (Attendance attendance:attendances) {
                double off_Minutes = attendanceService.getOffMinutesByAid(attendance.getA_id());//ÿһ���Ӱ��¼�ļӰ�ʱ��
                overtime+=off_Minutes;//����ÿһ���Ӱ��¼�ļӰ�ʱ��
            }
            p_overtime=overtime/60*50;//�Ӱ��ÿСʱ50
            List<Rap> raps = rapService.getRapLastMonthBySid(staff.getS_id());
            for (Rap rap:raps) {
                p_rap+=rap.getRa_money();//����ÿһ�����ͼ�¼
            }
            p_pay=p_base+p_performance+p_overtime+p_rap+p_ss;
            Pay pay = new Pay(staff,p_base,p_performance,p_overtime,p_rap,p_ss,p_pay,0);
            payService.addPay(pay);
        }
        response.getWriter().print("��������н�ʳɹ�");
    }
}
