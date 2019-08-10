package com.baiyang.controller;

import com.baiyang.domain.Course;
import com.baiyang.domain.Page;
import com.baiyang.domain.Student;
import com.baiyang.service.CouService;
import com.baiyang.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.List;

@Controller("courseController")
public class CourseController {
    @Autowired
    private CouService couService;
    @Autowired
    private HttpServletRequest request;

    /**
     * 学生进入choiceCou页面的控制器
     *
     * @param model
     * @return
     */
    @RequestMapping(path = "/choiceCouPage")
    public String choiceCouPage(Model model) {
        if (request.getSession().getAttribute("student") == null) {
            return "redirect:/login.jsp";
        } else {
            try {
                int pageNum = PageUtil.getTargetPage(request);
                int pageSize = PageUtil.getPageSize(request);
                Page page = new Page(pageSize, pageNum);
                List<Course> courses = couService.findAllCou(page, pageNum, pageSize);
                System.out.println("查找课程成功");
                model.addAttribute("page", page);
                model.addAttribute("courses", courses);
                return "stu/choiceCou";
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("查找课程异常，进入主页");
                return "forward:stuHome";
            }
        }
    }

    /**
     * 学生进入showCou页面的控制器
     *
     * @param model
     * @return
     */
    @RequestMapping(path = "/showCouPage")
    public String showCouPage(Model model) {
        if (request.getSession().getAttribute("student") == null) {
            return "redirect:/login.jsp";
        } else {
            Student stu = (Student) request.getSession().getAttribute("student");
            List<Course> courses = couService.findCouBySno(stu.getSno());
            model.addAttribute("courses", courses);
            return "stu/showCou";
        }
    }

    /**
     * 老师进入选课页面控制器
     */
    @RequestMapping(path = "selectCouPage")
    public String selectCouPage(Model model) {
        if (request.getSession().getAttribute("teacher") == null) {
            return "redirect:login.jsp";
        } else {
            try {
                int pageNum = PageUtil.getTargetPage(request);
                int pageSize = PageUtil.getPageSize(request);
                Page page = new Page(pageSize, pageNum);
                List<Course> courses = couService.findAllCou(page, pageNum, pageSize);
                model.addAttribute("page", page);
                model.addAttribute("data", courses);
                return "tea/selectCou";
            } catch (Exception e) {
                e.printStackTrace();
                return "forward:tea/teacher.jsp";
            }
        }
    }

    /**
     * 老师删除课程控制器
     *
     * @return
     */
    @RequestMapping(path = "/deleteCouPage")
    public String deleteCouPage(String cno) {
        if (request.getSession().getAttribute("teacher") == null) {
            return "redirect:login.jsp";
        } else {
            try {
                int result = couService.deleteCou(Integer.parseInt(cno));
                if (result == 1) {
                    System.out.println("删除课程成功");
                    return "forward:selectCouPage";
                } else {
                    System.out.println("删除课程失败");
                    return "selectCouPage";
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("删除课程异常");
                return "forward:tea/teacher.jsp";
            }
        }

    }

    /**
     * 老师添加课程页面控制器
     */
    @RequestMapping(path = "InsertCouPage")
    public String insertCouPage() {
        if (request.getSession().getAttribute("teacher") == null) {
            return "redirect:login.jsp";
        } else {
            return "tea/InsertCou";
        }
    }

    /**
     * 老师添加课程控制器
     */
    @RequestMapping(path = "/insertCou")
    public String insertCou(Course course) {
        if (request.getSession().getAttribute("teacher") == null) {
            return "redirect:login.jsp";
        } else {
            try {
                int result = couService.saveCou(course);
                if (result == 1) {
                    System.out.println("添加课程成功");
                    return "forward:InsertCouPage";
                } else {
                    System.out.println("添加课程失败");
                    return "forward:InsertCouPage";
                }
            } catch (Exception e) {
                System.out.println("添加课程异常");
                return "forward:InsertCouPage";
            }
        }
    }

    /**
     * 老师更新课程页面控制器
     */
    @RequestMapping(path = "updateCouPage")
    public String updateCouPage(String cno, Model model) {
        if (request.getSession().getAttribute("teacher") == null) {
            return "redirect:login.jsp";
        } else {
            try {
                Course course = couService.findCouByCno(Integer.parseInt(cno));
                System.out.println("进入更新课程页面");
                model.addAttribute("course", course);
                return "tea/updateCou";
            } catch (Exception e) {
                System.out.println("根据学号查找课程异常");
                e.printStackTrace();
                return "forward:tea/teacher.jsp";
            }
        }
    }

    /**
     * 老师更新课程控制器
     *
     * @param course
     * @return
     */
    @RequestMapping(path = "/updateCou")
    public String updateCou(Course course) {
        if (request.getSession().getAttribute("teacher") == null) {
            return "redirect:login.jsp";
        } else {
            try {
                int result = couService.updateCou(course);
                if (result == 1) {
                    System.out.println("更新课程成功");
                    return "forward:selectCouPage";
                } else {
                    System.out.println("更新课程失败");
                    return "updateCouPage";
                }
            } catch (Exception e) {
                System.out.println("更新课程异常");
                e.printStackTrace();
                return "forward:tea/teacher.jsp";
            }
        }
    }


    /**
     * 管理员添加课程页面控制器
     */
    @RequestMapping(path = "InsertCouPageAdmin")
    public String InsertCouPageAdmin() {
        if (request.getSession().getAttribute("admin") == null) {
            return "redirect:login.jsp";
        } else {
            return "admin/InsertCou";
        }
    }

    /**
     * 管理员添加课程控制器
     */
    @RequestMapping(path = "/insertCouAdmin")
    public String insertCouAdmin(Course course) {
        if (request.getSession().getAttribute("admin") == null) {
            return "redirect:login.jsp";
        } else {
            try {
                int result = couService.saveCou(course);
                if (result == 1) {
                    System.out.println("添加课程成功");
                    return "forward:InsertCouPageAdmin";
                } else {
                    System.out.println("添加课程失败");
                    return "forward:InsertCouPageAdmin";
                }
            } catch (Exception e) {
                System.out.println("添加课程异常");
                return "forward:InsertCouPageAdmin";
            }
        }
    }

    /**
     * 老师进入选课页面控制器
     */
    @RequestMapping(path = "selectCouPageAdmin")
    public String selectCouPageAdmin(Model model) {
        if (request.getSession().getAttribute("admin") == null) {
            return "redirect:login.jsp";
        } else {
            try {
                int pageNum = PageUtil.getTargetPage(request);
                int pageSize = PageUtil.getPageSize(request);
                Page page = new Page(pageSize, pageNum);
                List<Course> courses = couService.findAllCou(page, pageNum, pageSize);
                model.addAttribute("page", page);
                model.addAttribute("data", courses);
                return "admin/selectCou";
            } catch (Exception e) {
                e.printStackTrace();
                return "forward:admin/admin.jsp";
            }
        }
    }

    /**
     * 老师删除课程控制器
     *
     * @return
     */
    @RequestMapping(path = "/deleteCouPageAdmin")
    public String deleteCouPageAdmin(String cno) {
        if (request.getSession().getAttribute("admin") == null) {
            return "redirect:login.jsp";
        } else {
            try {
                int result = couService.deleteCou(Integer.parseInt(cno));
                if (result == 1) {
                    System.out.println("删除课程成功");
                    return "forward:selectCouPageAdmin";
                } else {
                    System.out.println("删除课程失败");
                    return "forward:selectCouPageAdmin";
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("删除课程异常");
                return "forward:selectCouPageAdmin";
            }
        }

    }

    /**
     * 老师更新课程页面控制器
     */
    @RequestMapping(path = "updateCouPageAdmin")
    public String updateCouPageAdmin(String cno, Model model) {
        if (request.getSession().getAttribute("teacher") == null) {
            return "redirect:login.jsp";
        } else {
            try {
                Course course = couService.findCouByCno(Integer.parseInt(cno));
                System.out.println("进入更新课程页面");
                model.addAttribute("course", course);
                return "admin/updateCou";
            } catch (Exception e) {
                System.out.println("根据学号查找课程异常");
                e.printStackTrace();
                return "forward:tea/teacher.jsp";
            }
        }
    }

    /**
     * 老师更新课程控制器
     *
     * @param course
     * @return
     */
    @RequestMapping(path = "/updateCouAdmin")
    public String updateCouAdmin(Course course) {
        if (request.getSession().getAttribute("teacher") == null) {
            return "redirect:login.jsp";
        } else {
            try {
                int result = couService.updateCou(course);
                if (result == 1) {
                    System.out.println("更新课程成功");
                    return "forward:updateCouPageAdmin";
                } else {
                    System.out.println("更新课程失败");
                    return "forward:updateCouPageAdmin";
                }
            } catch (Exception e) {
                System.out.println("更新课程异常");
                e.printStackTrace();
                return "forward:updateCouPageAdmin";
            }
        }
    }
}
