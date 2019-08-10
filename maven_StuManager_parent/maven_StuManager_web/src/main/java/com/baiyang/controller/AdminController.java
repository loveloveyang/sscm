package com.baiyang.controller;

import com.baiyang.domain.Admin;
import com.baiyang.domain.Page;
import com.baiyang.domain.Student;
import com.baiyang.domain.Teacher;
import com.baiyang.service.AdminService;
import com.baiyang.service.StuService;
import com.baiyang.service.TeaService;
import com.baiyang.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller("adminController")
public class AdminController {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private AdminService adminService;
    @Autowired
    private TeaService teaService;
    @Autowired
    private StuService stuService;
    /**
     * 管理员主页页面
     *
     * @return
     */
    @RequestMapping(path = "/adminPage")
    public String adminPage() {
        System.out.println("管理员页面");
        if (request.getSession().getAttribute("admin") == null) {
            return "redirect:login.jsp";
        } else {
            Admin admin = (Admin) request.getSession().getAttribute("admin");
            return "admin/admin";
        }
    }

    /**
     * 管理员修改自己密码页面
     *
     * @param model
     * @return
     */
    @RequestMapping(path = "/updateAdminPassPage")
    public String updateAdminPassPage(Model model) {
        System.out.println("管理员修改自己密码页面");
        if (request.getSession().getAttribute("admin") == null) {
            return "redirect:login.jsp";
        } else {
            Admin admin = (Admin) request.getSession().getAttribute("admin");
            model.addAttribute("admin", admin);
            return "admin/updateAdminPass";
        }
    }

    /**
     * 管理员修改自己密码控制器
     *
     * @param model
     * @param newApassword
     * @return
     */
    @RequestMapping(path = "/updateAdminPass")
    public String updateAdminPass(Model model, String newApassword) {
        System.out.println("管理员修改自己密码");
        if (request.getSession().getAttribute("admin") == null) {
            return "redirect:login.jsp";
        } else {
            try {
                Admin admin = (Admin) request.getSession().getAttribute("admin");
                int i = adminService.updateAdminPass(admin.getAno(), newApassword);
                if (i == 1) {
                    System.out.println("修改成功，重新登录");
                    return "redirect:login.jsp";
                } else {
                    System.out.println("修改失败");
                    return "forward:updateAdminPassPage";
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("老师修改自己密码异常,回到主页");
                return "forward:updateAdminPassPage";
            }

        }
    }

    /**
     * 管理员身份信息
     * @return
     */
    @RequestMapping(path = "/adminInfo")
    public String adminInfo(Model model){
        System.out.println("管理员身份信息页面");
        if (request.getSession().getAttribute("admin") == null) {
            return "redirect:login.jsp";
        } else {
            try {
                Admin admin = (Admin) request.getSession().getAttribute("admin");
                Admin adminInfo = adminService.findAdminByTno(admin.getAno());
                model.addAttribute("admin", adminInfo);
                return "admin/adminInfo";
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("查找管理员信息异常,回到主页");
                return "forward:adminPage";
            }
        }
    }

    /**
     * 管理员添加老师页面控制器
     */
    @RequestMapping(path = "/insertTeaPage")
    public String insertTeaPage() {
        if (request.getSession().getAttribute("admin") == null) {
            return "redirect:login.jsp";
        } else {
            return "admin/InsertTea";
        }
    }

    /**
     * 管理员添加老师的控制器
     */
    @RequestMapping(path = "/insertTea")
    public String insertTea(Teacher teacher) {
        if (request.getSession().getAttribute("admin") == null) {
            return "redirect:login.jsp";
        } else {
            try {
                int result = teaService.savaTea(teacher);
                if (result == 1) {
                    System.out.println("添加成功");
                    return "forward:insertTeaPage";
                } else {
                    System.out.println("添加失败");
                    return "forward:insertTeaPage";
                }
            } catch (Exception e) {
                System.out.println("添加老师异常，重新添加");
                e.printStackTrace();
                return "forward:insertTeaPage";
            }
        }
    }

    /**
     * 管理员查找所有老师
     * @param model
     * @return
     */
    @RequestMapping(path = "/selectTeaPage")
    public String selectTeaPage(Model model){
        if (request.getSession().getAttribute("admin") == null) {
            return "redirect:login.jsp";
        } else {
            try {
                int pageNum = PageUtil.getTargetPage(request);
                int pageSize = PageUtil.getPageSize(request);
                Page page = new Page(pageSize, pageNum);
                List<Teacher> teachers = teaService.findAllTea(page, pageNum, pageSize);
                model.addAttribute("page", page);
                model.addAttribute("teachers", teachers);
                return "admin/selectTea";
            } catch (Exception e) {
                System.out.println("查找所有老师异常");
                e.printStackTrace();
                return "forward:adminPage";

            }
        }
    }
    /**
     * 管理员进入更新老师的界面
     * @param model
     * @return
     */
    @RequestMapping(path = "/updateTeaPage")
    public String updateTeaPage(Model model,String tno){
        if (request.getSession().getAttribute("admin") == null) {
            return "redirect:login.jsp";
        } else {
            try {
                int tno1 = Integer.parseInt(tno);
                Teacher teachers = teaService.findTeaByTno(tno1);
                model.addAttribute("teachers", teachers);
                if (teachers != null) {
                    System.out.println("查找老师成功");
                    return "admin/updateTea";
                } else {
                    System.out.println("查找老师失败");
                    return "forward:selectTeaPage";
                }
            } catch (Exception e) {
                System.out.println("查找学生异常");
                e.printStackTrace();
                return "forward:selectTeaPage";
            }
        }
    }

    /**
     * 管理员添加老师控制器
     * @param teacher
     * @return
     */
    @RequestMapping(path = "/updateTea")
    public String updateTea(Teacher teacher){
        if (request.getSession().getAttribute("admin") == null) {
            return "redirect:login.jsp";
        } else {
            try {
                int result = teaService.updateTea(teacher);
                if (result == 1) {
                    System.out.println("更新学生成功");
                    return "forward:updateTeaPage";
                } else {
                    System.out.println("更新学生失败");
                    return "forward:updateTeaPage";
                }
            } catch (Exception e) {
                System.out.println("更新学生异常");
                e.printStackTrace();
                return "forward:updateTeaPage";
            }
        }
    }

    /**
     * 管理员删除老师控制器
     */
    @RequestMapping(path = "/deleteTea")
    public String deleteTea(String tno) {
        if (request.getSession().getAttribute("admin") == null) {
            return "redirect:login.jsp";
        } else {
            try {
                int tno1 = Integer.parseInt(tno);
                int result = teaService.deleteTea(tno1);
                if (result == 1) {
                    System.out.println("删除成功");
                    return "forward:selectTeaPage";
                } else {
                    System.out.println("删除失败");
                    return "forward:selectTeaPage";
                }
            } catch (Exception e) {
                System.out.println("删除异常");
                e.printStackTrace();
                return "forward:selectTeaPage";
            }
        }
    }
    /**
     * 管理员进入学生添加页面控制器
     */
    @RequestMapping(path = "/insertStuPageAdmin")
    public String insertStuPageAdmin() {
        if (request.getSession().getAttribute("admin") == null) {
            return "redirect:login.jsp";
        } else {
            return "admin/InsertStu";
        }
    }
    /**
     * 老师添加学生的控制器
     */
    @RequestMapping(path = "/insertStuAdmin")
    public String insertStuAdmin(Student student) {
        if (request.getSession().getAttribute("admin") == null) {
            return "redirect:login.jsp";
        } else {
            try {
                int result = stuService.savaStu(student);
                if (result == 1) {
                    System.out.println("添加成功");
                    return "forward:insertStuPageAdmin";
                } else {
                    System.out.println("添加失败");
                    return "forward:insertStuPageAdmin";
                }
            } catch (Exception e) {
                System.out.println("添加学生异常，重新添加");
                e.printStackTrace();
                return "forward:insertStuPageAdmin";
            }
        }
    }
    /**
     * 管理员进入学生管理页面
     *
     * @return
     */
    @RequestMapping(path = "/selectStuPageAdmin")
    public String selectStuPageAdmin(Model model) {
        if (request.getSession().getAttribute("admin") == null) {
            return "redirect:login.jsp";
        } else {
            try {
                int pageNum = PageUtil.getTargetPage(request);
                int pageSize = PageUtil.getPageSize(request);
                Page page = new Page(pageSize, pageNum);
                List<Student> students = stuService.findALLStudent1(page, pageNum, pageSize);
                model.addAttribute("page", page);
                model.addAttribute("students", students);
               /* model.addAttribute("MaxScredit", Student.MaxScore);
                model.addAttribute("MinScredit", Student.MinScore);*/
                return "admin/selectStu";
            } catch (Exception e) {
                System.out.println("查找所有学生异常");
                e.printStackTrace();
                return "forward:admin/admin.jsp";

            }
        }

    }
    /**
     * 管理员进去学生更新页面控制器
     */
    @RequestMapping(path = "/updateStuPageAdmin")
    public String updateStuPageAdmin(String sno, Model model) {
        if (request.getSession().getAttribute("admin") == null) {
            return "redirect:login.jsp";
        } else {
            try {
                int sno1 = Integer.parseInt(sno);
                Student students = stuService.findStuBySno(sno1);
                model.addAttribute("students", students);
                if (students != null) {
                    System.out.println("查找学生成功");
                    return "admin/updateStu";
                } else {
                    System.out.println("查找学生失败");
                    return "forward:selectStuPageAdmin";
                }
            } catch (Exception e) {
                System.out.println("查找学生异常");
                e.printStackTrace();
                return "forward:selectStuPageAdmin";
            }
        }
    }
    /**
     * 管理员对学生更新控制器
     */
    @RequestMapping(path = "/updateStuAdmin")
    public String updateStuAdmin(Student student) {
        if (request.getSession().getAttribute("admin") == null) {
            return "redirect:login.jsp";
        } else {
            try {
                int result = stuService.updateStu(student);
                if (result == 1) {
                    System.out.println("更新学生成功");
                    return "forward:updateStuPageAdmin";
                } else {
                    System.out.println("更新学生失败");
                    return "forward:updateStuPageAdmin";
                }
            } catch (Exception e) {
                System.out.println("更新学生异常");
                e.printStackTrace();
                return "forward:updateStuPageAdmin";
            }
        }
    }
    /**
     * 管理员删除学生信息控制器
     */
    @RequestMapping(path = "/deleteStuAdmin")
    public String deleteStuAdmin(String sno) {
        if (request.getSession().getAttribute("admin") == null) {
            return "redirect:login.jsp";
        } else {
            try {
                int sno1 = Integer.parseInt(sno);
                int result = stuService.deleteStu(sno1);
                if (result == 1) {
                    System.out.println("删除成功");
                    return "forward:selectStuPageAdmin";
                } else {
                    System.out.println("删除失败");
                    return "forward:selectStuPageAdmin";
                }
            } catch (Exception e) {
                System.out.println("删除异常");
                e.printStackTrace();
                return "forward:selectStuPageAdmin";
            }
        }
    }
}
