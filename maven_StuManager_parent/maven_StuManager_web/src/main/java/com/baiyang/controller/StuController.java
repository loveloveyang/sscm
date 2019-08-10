package com.baiyang.controller;

import com.baiyang.domain.Page;
import com.baiyang.domain.Student;
import com.baiyang.service.StuService;
import com.baiyang.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller("stuController")
public class StuController {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private StuService stuService;

    /**
     * 学生主页(学生)
     *
     * @return
     */
    @RequestMapping(path = "/studentPage")
    public String studentPage() {
        System.out.println("学生页面");
        if (request.getSession().getAttribute("student") == null) {
            return "redirect:login.jsp";
        } else {
            Student student = (Student) request.getSession().getAttribute("student");
            return "stu/student";
        }
    }

    /**
     * 学生信息(学生)
     *
     * @return
     */
    @RequestMapping(path = "/stuInfoPage")
    public String stuInfoPage(Model model) {
        System.out.println("学生信息页");
        if (request.getSession().getAttribute("student") == null) {
            return "redirect:login.jsp";
        } else {
            try {
                Student student = (Student) request.getSession().getAttribute("student");
                Double stuScre = stuService.findScreBySno(student.getSno());
                model.addAttribute("stuScre", stuScre);
                return "stu/stuInfo";
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("查找学生总学分异常,回到主页");
                return "forward:stu/student.jsp";
            }

        }
    }

    /**
     * 学生修改自己密码页面
     * @param model
     * @return
     */
    @RequestMapping(path = "/updateStuPassPage")
    public String updateStuPassPage(Model model){
        System.out.println("学生修改自己密码页面");
        if (request.getSession().getAttribute("student") == null) {
            return "redirect:login.jsp";
        } else {
            Student student = (Student) request.getSession().getAttribute("student");
            model.addAttribute("student", student);
            return "stu/updateStuPass";
        }
    }

    /**
     * 学生修改密码控制器
     * @param model
     * @param newSpassword
     * @return
     */
    @RequestMapping(path = "/updateStuPass")
    public String updateStuPass(Model model, String newSpassword){
        System.out.println("学生修改自己密码");
        if (request.getSession().getAttribute("student") == null) {
            return "redirect:login.jsp";
        } else {
            try {
                Student student = (Student) request.getSession().getAttribute("student");
                int i = stuService.updateStuPass(student.getSno(), newSpassword);
                if (i == 1) {
                    System.out.println("修改成功，重新登录");
                    return "forward:updateStuPassPage";
                } else {
                    System.out.println("修改失败");
                    return "forward:updateStuPassPage";
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("老师修改自己密码异常,回到主页");
                return "forward:updateStuPassPage";
            }
        }
    }

}
