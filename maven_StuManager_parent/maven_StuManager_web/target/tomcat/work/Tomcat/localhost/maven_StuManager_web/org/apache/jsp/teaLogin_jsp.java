/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-07-26 09:05:17 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class teaLogin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("   <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>学生选课信息管理系统-教师入口</title>\r\n");
      out.write("    <link href=\"style.css\" type=\"text/css\" rel=\"stylesheet\"/>\r\n");
      out.write("\t<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"expires\" content=\"0\">    \r\n");
      out.write("\t<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("\t<meta http-equiv=\"description\" content=\"This is my page\">\r\n");
      out.write("\t<!--\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">\r\n");
      out.write("\t--> \r\n");
      out.write("  </head>\r\n");
      out.write("  <body>\r\n");
      out.write("  <div class=\"login_bg\">\r\n");
      out.write("\t\t\t<div class=\"login_box\">\r\n");
      out.write("\t\t\t\t<div class=\"login_logo\">\r\n");
      out.write("\t\t\t\t\t<img class=\"login_logo_icon\" src=\"img/Slogo.png\" alt=\"\"/>\r\n");
      out.write("\t\t\t\t\t<img class=\"login_logo_text\" src=\"img/StudentSelection.png\" alt=\"\"/>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"login_line\"></div>\r\n");
      out.write("\t\t\t\t<div class=\"login_content\">\r\n");
      out.write("\t\t\t\t\t<h2>学生选课信息管理系统</h2>\r\n");
      out.write("\t\t\t\t\t<p>Student Selection Management System</p>\r\n");
      out.write("\t\t\t\t\t<form action=\"loginUser?type=tea\" method=\"post\" >\r\n");
      out.write("\t\t\t\t\t\t<div class=\"login_input\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" placeholder=\"请输入用户名\" class=\"login_username\" name=\"username\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\t\t\t<div class=\"login_input\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"password\" placeholder=\"请输入密码\" class=\"login_password\"  name=\"password\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t<input class=\"login_btn sure\" type=\"submit\" value=\"登录\">\r\n");
      out.write("\t\t\t\t\t\t\t<input class=\"login_btn cancle\" type=\"button\" value=\"学生入口 \" onclick=\"window.location.href('login.jsp')\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"text\"><p>版权所有 ©2017-2018 学生选课信息系统 保留所有权利</p></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
