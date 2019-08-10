package com.baiyang.controller;

import com.baiyang.domain.Page;
import com.baiyang.domain.Student;
import com.baiyang.domain.Teacher;
import com.baiyang.service.StuService;
import com.baiyang.service.TeaService;
import com.baiyang.util.PageUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller("teaController")
public class TeaController {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private TeaService teaService;
    @Autowired
    private StuService stuService;

    /**
     * 老师主页
     *
     * @return
     */
    @RequestMapping(path = "/teacherPage")
    public String teacherPage() {
        System.out.println("老师页面");
        if (request.getSession().getAttribute("teacher") == null) {
            return "redirect:login.jsp";
        } else {
            Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
            return "tea/teacher";
        }
    }

    /**
     * 老师个人信息页面
     *
     * @param model
     * @return
     */

    @RequestMapping(path = "/teaInfoPage")
    public String teaInfoPage(Model model) {
        System.out.println("老师个人信息页面");
        if (request.getSession().getAttribute("teacher") == null) {
            return "redirect:login.jsp";
        } else {
            try {
                Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
                Teacher tea = teaService.findTeaByTno(teacher.getTno());
                model.addAttribute("tea", tea);
                return "tea/teaInfo";
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("查找老师个人信息异常,回到主页");
                return "forward:teacherPage";
            }
        }
    }

    /**
     * 老师修改自己密码页面
     *
     * @param model
     * @return
     */
    @RequestMapping(path = "/updateTeaPassPage")
    public String updateTeaPassPage(Model model) {
        System.out.println("老师修改自己密码页面");
        if (request.getSession().getAttribute("teacher") == null) {
            return "redirect:login.jsp";
        } else {
            Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
            model.addAttribute("teacher", teacher);
            return "tea/updateTeaPass";
        }
    }

    /**
     * 老师修改自己密码
     *
     * @param model
     * @param newTpassword
     * @return
     */
    @RequestMapping(path = "/updateTeaPass")
    public String updateTeaPass(Model model, String newTpassword) {
        System.out.println("老师修改自己密码");
        if (request.getSession().getAttribute("teacher") == null) {
            return "redirect:login.jsp";
        } else {
            try {
                Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
                int i = teaService.updateTeaPass(teacher.getTno(), newTpassword);
                if (i == 1) {
                    System.out.println("修改成功，重新登录");
                    return "redirect:login.jsp";
                } else {
                    System.out.println("修改失败");
                    return "forward:updateTeaPassPage";
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("老师修改自己密码异常,回到主页");
                return "forward:updateTeaPassPage";
            }

        }
    }

    /**
     * 老师进入学生管理页面
     *
     * @return
     */
    @RequestMapping(path = "/selectStuPage")
    public String selectStuPage(Model model) {
        if (request.getSession().getAttribute("teacher") == null) {
            return "redirect:login.jsp";
        } else {
            try {
                int pageNum = PageUtil.getTargetPage(request);
                int pageSize = PageUtil.getPageSize(request);
                Page page = new Page(pageSize, pageNum);
                List<Student> students = stuService.findALLStudent(page, pageNum, pageSize);
                model.addAttribute("page", page);
                model.addAttribute("students", students);
                return "tea/selectStu";
            } catch (Exception e) {
                System.out.println("查找所有学生异常");
                e.printStackTrace();
                return "forward:tea/teacher.jsp";

            }
        }


    }

    /**
     * 老师进入学生添加页面控制器
     */
    @RequestMapping(path = "/insertStuPage")
    public String insertStuPage() {
        if (request.getSession().getAttribute("teacher") == null) {
            return "redirect:login.jsp";
        } else {
            return "tea/InsertStu";
        }
    }

    /**
     * 老师添加学生的控制器
     */
    @RequestMapping(path = "/insertStu")
    public String insertStu(Student student) {
        if (request.getSession().getAttribute("teacher") == null) {
            return "redirect:login.jsp";
        } else {
            try {
                int result = stuService.savaStu(student);
                if (result == 1) {
                    System.out.println("添加成功");
                    return "forward:selectStuPage";
                } else {
                    System.out.println("添加失败");
                    return "insertStuPage";
                }
            } catch (Exception e) {
                System.out.println("添加学生异常，重新添加");
                e.printStackTrace();
                return "forward:insertStuPage";
            }
        }
    }

    /**
     * 老师进去学生更新页面控制器
     */
    @RequestMapping(path = "/updateStuPage")
    public String updateStuPage(String sno, Model model) {
        if (request.getSession().getAttribute("teacher") == null) {
            return "redirect:login.jsp";
        } else {
            try {
                int sno1 = Integer.parseInt(sno);
                Student students = stuService.findStuBySno(sno1);
                model.addAttribute("students", students);
                if (students != null) {
                    System.out.println("查找学生成功");
                    return "tea/updateStu";
                } else {
                    System.out.println("查找学生失败");
                    return "forward:selectStuPage";
                }
            } catch (Exception e) {
                System.out.println("查找学生异常");
                e.printStackTrace();
                return "forward:selectStuPage";
            }
        }
    }

    /**
     * 老师对学生更新控制器
     */
    @RequestMapping(path = "/updateStu")
    public String updateStu(Student student) {
        if (request.getSession().getAttribute("teacher") == null) {
            return "redirect:login.jsp";
        } else {
            try {
                int result = stuService.updateStu(student);
                if (result == 1) {
                    System.out.println("更新学生成功");
                    return "forward:selectStuPage";
                } else {
                    System.out.println("更新学生失败");
                    return "forward:updateStuPage";
                }
            } catch (Exception e) {
                System.out.println("更新学生异常");
                e.printStackTrace();
                return "forward:updateStuPage";
            }
        }
    }

    /**
     * 老师删除学生信息控制器
     */
    @RequestMapping(path = "/deleteStu")
    public String deleteStu(String sno) {
        if (request.getSession().getAttribute("teacher") == null) {
            return "redirect:login.jsp";
        } else {
            try {
                int sno1 = Integer.parseInt(sno);
                int result = stuService.deleteStu(sno1);
                if (result == 1) {
                    System.out.println("删除成功");
                    return "forward:selectStuPage";
                } else {
                    System.out.println("删除失败");
                    return "forward:selectStuPage";
                }
            } catch (Exception e) {
                System.out.println("删除异常");
                e.printStackTrace();
                return "forward:selectStuPage";
            }
        }
    }

    /**
     * 修改学生选课学分页面
     *
     * @param model
     * @return
     */

    @RequestMapping(path = "/updateScreditPage")
    public String updateScreditPage(Model model) {
        try {
            int pageNum = PageUtil.getTargetPage(request);
            int pageSize = PageUtil.getPageSize(request);
            Page page = new Page(pageSize, pageNum);
            List<Student> students = stuService.findALLStudent2(page, pageNum, pageSize,Student.MinScore);
            model.addAttribute("page", page);
            model.addAttribute("students", students);
            model.addAttribute("MaxScredit", Student.MaxScore);
            model.addAttribute("MinScredit", Student.MinScore);
            return "tea/updateScredit";
        } catch (Exception e) {
            System.out.println("进入修改学分页面异常");
            e.printStackTrace();
            return "teacherPage";
        }
    }

    @RequestMapping(path = "/updateScredit")
    public String updateScredit(@RequestParam(value = "MinScore") String MinScore, @RequestParam(value = "MaxScore") String MaxScore, Model model) {
        try {
            Student.MinScore = Float.parseFloat(MinScore);
            Student.MaxScore = Float.parseFloat(MaxScore);
            return "forward:updateScreditPage";
        } catch (Exception e) {
            System.out.println("修改学分页面异常");
            e.printStackTrace();
            return "forward:updateScreditPage";
        }
    }
}
