package com.baiyang.controller;

import com.baiyang.domain.QueryResult;
import com.baiyang.domain.Teacher;
import com.baiyang.service.CouService;
import com.baiyang.service.QueryService;
import com.baiyang.service.StuService;
import com.baiyang.service.TeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller("queryController")
public class QueryController {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private QueryService queryService;
    @Autowired
    private CouService couService;
    @Autowired
    private StuService stuService;
    @Autowired
    private TeaService teaService;
    /**
     * 老师进入选课信息页面
     *
     * @return
     */
    @RequestMapping(path = "/queryPage")
    public String queryPage() {
        return "tea/Query";
    }

    /**
     * 老师进去课程查询界面
     * @return
     */
    @RequestMapping(path = "/courseQueryPage")
    public String courseQueryPage(){
        return "tea/courseQuery";
    }

    /**
     * 老师进去学生查询界面
     * @return
     */
    @RequestMapping(path = "/studentQueryPage")
    public String studentQueryPage(){
        return "tea/studentQuery";
    }
    /**
     * 管理员进入老师查询界面
     * @return
     */
    @RequestMapping(path = "/teacherQueryPage")
    public String teacherQueryPage(){
        return "admin/teacherQuery";
    }
    /**
     * 管理员进入课程查询界面
     */
    @RequestMapping(path = "/courseQueryPageAdmin")
    public String courseQueryPageAdmin(){
        return "admin/courseQuery";
    }
    /**
     * 管理员进入学生查询界面
     */
    @RequestMapping(path = "/studentQueryPageAdmin")
    public String studentQueryPageAdmin(){
        return "admin/studentQuery";
    }
    /**
     * 老师查询选课信息控制器
     */
    @RequestMapping(path = "/query")
    public String query(@RequestParam(name = "queryKey") String queryKey, @RequestParam(name = "choiceType") String choiceType
            , Model model) {
        //判断是老师还是管理员 true是管理员
        boolean flag=false;
        Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
        if (teacher==null||teacher.equals("")){
            flag=true;
        }
        try {

            int choiceResult = Integer.parseInt(choiceType);
            List<QueryResult> queryResults = new ArrayList<QueryResult>();
            switch (choiceResult) {
                case 1:
                    queryResults = queryService.findAllByCno(Integer.parseInt(queryKey));
                    break;
                case 2:
                    queryResults = queryService.findAllBySname(queryKey);
                    break;
                case 3:
                    queryResults = queryService.findAllBySclass(queryKey);
                    break;
                case 4:
                    queryResults = queryService.findAllByCno(Integer.parseInt(queryKey));
                    break;
                case 5:
                    queryResults = queryService.findAllByCname(queryKey);
                    break;
                case 6:
                    queryResults = queryService.findAllByRoom(queryKey);
                    break;
                default:
                    System.out.println("错误，请重试！");
                    break;
            }
            model.addAttribute("queryResults", queryResults);
            if (flag){
                return "forward:queryPageAdmin";
            }else {
                return "forward:queryPage";
            }

        } catch (Exception e) {
            System.out.println("查询异常");
            e.printStackTrace();
            return "forward:queryPage";
        }
    }
    /**
     * 查询课程控制器
     * @param queryKey
     * @param choiceType
     * @param model
     * @return
     */
    @RequestMapping(path = "/courseQuery")
    public String courseQuery(@RequestParam(name = "queryKey") String queryKey, @RequestParam(name = "choiceType") String choiceType
            , Model model) {
        //判断是老师还是管理员 true是管理员
        boolean flag=false;
        Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
        if (teacher==null||teacher.equals("")){
            flag=true;
        }
        try {
            int choiceResult = Integer.parseInt(choiceType);
            List<QueryResult> queryResults = new ArrayList<QueryResult>();
            switch (choiceResult) {
                case 1:
                    queryResults = couService.findCouByCno1(Integer.parseInt(queryKey));
                    break;
                case 2:
                    queryResults = couService.findCouByCname(queryKey);
                    break;
                case 3:
                    queryResults = couService.findCouByCcredit(Double.parseDouble(queryKey));
                    break;
                case 4:
                    queryResults = couService.findCouByCclassroom(queryKey);
                    break;
                default:
                    System.out.println("错误，请重试！");
                    break;
            }
            model.addAttribute("queryResults", queryResults);
            if(flag){
                return "forward:courseQueryPageAdmin";
            }else {
                return "forward:courseQueryPage";
            }
        } catch (Exception e) {
            System.out.println("查询异常");
            e.printStackTrace();
            return "forward:selectCouPage";
        }

    }
    /**
     * 老师查询选课学生控制器
     * @param queryKey
     * @param choiceType
     * @param model
     * @return
     */
    @RequestMapping(path = "/studentQuery")
    public String studentQuery(@RequestParam(name = "queryKey") String queryKey, @RequestParam(name = "choiceType") String choiceType
            , Model model) {
        try {

            int choiceResult = Integer.parseInt(choiceType);
            List<QueryResult> queryResults = new ArrayList<QueryResult>();
            switch (choiceResult) {
                case 1:
                    queryResults = stuService.findStuBySno1(Integer.parseInt(queryKey));
                    break;
                case 2:
                    queryResults = stuService.findStuBySname(queryKey);
                    break;
                case 3:
                    queryResults = stuService.findStuBySclass(queryKey);
                    break;
                case 4:
                    queryResults = stuService.findStuBySsex(queryKey);
                    break;
                default:
                    System.out.println("错误，请重试！");
                    break;
            }
            model.addAttribute("queryResults", queryResults);
            return "forward:studentQueryPage";

        } catch (Exception e) {
            System.out.println("查询异常");
            e.printStackTrace();
            return "forward:selectStuPage";
        }

    }
    /**
     * 管理员查询选课学生控制器
     * @param queryKey
     * @param choiceType
     * @param model
     * @return
     */
    @RequestMapping(path = "/studentQueryAdmin")
    public String studentQueryAdmin(@RequestParam(name = "queryKey") String queryKey, @RequestParam(name = "choiceType") String choiceType
            , Model model) {
        try {

            int choiceResult = Integer.parseInt(choiceType);
            List<QueryResult> queryResults = new ArrayList<QueryResult>();
            switch (choiceResult) {
                case 1:
                    queryResults = stuService.findStuBySno2(Integer.parseInt(queryKey));
                    break;
                case 2:
                    queryResults = stuService.findStuBySname2(queryKey);
                    break;
                case 3:
                    queryResults = stuService.findStuBySclass2(queryKey);
                    break;
                case 4:
                    queryResults = stuService.findStuBySsex2(queryKey);
                    break;
                default:
                    System.out.println("错误，请重试！");
                    break;
            }
            model.addAttribute("queryResults", queryResults);
            return "forward:studentQueryPageAdmin";
        } catch (Exception e) {
            System.out.println("查询异常");
            e.printStackTrace();
            return "forward:selectStuPageAdmin";
        }

    }
    /**
     * 查询老师控制器
     * @param queryKey
     * @param choiceType
     * @param model
     * @return
     */
    @RequestMapping(path = "/teacherQuery")
    public String teacherQuery(@RequestParam(name = "queryKey") String queryKey, @RequestParam(name = "choiceType") String choiceType
            , Model model) {
        try {

            int choiceResult = Integer.parseInt(choiceType);
            List<QueryResult> queryResults = new ArrayList<QueryResult>();
            switch (choiceResult) {
                case 1:
                    queryResults = teaService.findAllTeaByTno(Integer.parseInt(queryKey));
                    break;
                case 2:
                    queryResults = teaService.findAllTeaByTname(queryKey);
                    break;
                case 3:
                    queryResults = teaService.findAllTeaByTcollege(queryKey);
                    break;
                case 4:
                    queryResults = teaService.findAllTeaByTsex(queryKey);
                    break;
                default:
                    System.out.println("错误，请重试！");
                    break;
            }
            model.addAttribute("queryResults", queryResults);
            return "forward:teacherQueryPage";
        } catch (Exception e) {
            System.out.println("查询异常");
            e.printStackTrace();
            return "forward:selectTeaPage";
        }

    }
    /**
     * 管理员进入选课信息页面
     *
     * @return
     */
    @RequestMapping(path = "/queryPageAdmin")
    public String queryPageAdmin() {
        return "admin/Query";
    }
}
