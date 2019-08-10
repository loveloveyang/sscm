package com.baiyang.controller;

import com.baiyang.domain.Course;
import com.baiyang.domain.Sc;
import com.baiyang.domain.Student;
import com.baiyang.service.CouService;
import com.baiyang.service.ScService;
import com.baiyang.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller("scController")
public class ScController {
    Student student = null;

    @Autowired
    private ScService scService;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private CouService couService;
    @Autowired
    private StuService stuService;

    /**
     * 添加选课关系，学生选择课程
     * @param choiceCou
     * @return
     */
    @RequestMapping(path = "/insertSc")
    public String insertSc(@RequestParam(value = "choiceCou") String[] choiceCou) {
        if (request.getSession().getAttribute("student") == null) {
            System.out.println("没有登录，请登录");
            return "redirect:login.jsp";
        } else {
            student = (Student) request.getSession().getAttribute("student");
            try {
                Double scredit=0.0;
                int result = 0;
                Sc[] sc = null;
                Double stuScredit = stuService.findScreBySno(student.getSno());
                scredit = stuScredit;
                if (choiceCou == null) {
                    System.out.println("选课失败，接收选择框数组为空");
                    return "forward:choiceCouPage";
                } else {
                    sc = new Sc[choiceCou.length];
                    for (int i = 0; i < choiceCou.length; i++) {
                        sc[i] = new Sc();
                        sc[i].setSno(student.getSno());
                        sc[i].setCno(Integer.parseInt(choiceCou[i]));
                        double scre = couService.findScreByCno(sc[i].getCno());
                        scredit += scre;
                    }

                    System.out.println("最高学分是：" + Student.MaxScore);
                    if (scredit >= Student.MaxScore) {
                        System.out.println("选课超过学分限制，请重新选课");
                        return "forward:choiceCouPage";
                    } else {
                        for (int i = 0; i < sc.length; i++) {
                            result = scService.saveScBySnoCno(sc[i].getSno(), sc[i].getCno());
                        }
                        if (result == 1) {
                            System.out.println("选课成功");
                            return "forward:choiceCouPage";
                        } else {
                            System.out.println("选课失败");
                            return "forward:choiceCouPage";
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("选课失败，请重新选课！！！");
                System.out.println("查看您是否已经选过此课程，请重新选课！");
                e.printStackTrace();
                return "forward:choiceCouPage";
            }
        }
    }

    /**
     * 学生取消选的课
     * @return
     */
    @RequestMapping(path = "/delectSc")
    public String delectSc(String cno){
        if(request.getSession().getAttribute("student")==null&&cno==null){
            return "redirect:login.jsp";
        }else {
            try {
                Student student=(Student) request.getSession().getAttribute("student");
                int result = scService.delectSc(student.getSno(), Integer.parseInt(cno));
                if(result==0){
                    System.out.println("删除课程失败，请重新删除");
                    return "forward:showCouPage";
                }else {
                    System.out.println("删除课程成功");
                    return "forward:showCouPage";
                }

            }catch (Exception e){
                System.out.println("删除课程失败");
                return "forward:showCouPage";
            }

        }
    }



}
