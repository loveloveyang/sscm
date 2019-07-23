package com.baiyang.daoImpl;

import com.baiyang.domain.Student;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl {
    @Test
    public void testDB(){
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql:///testmybatis","root","root");
            ps= connection.prepareStatement("select * from student");
            rs = ps.executeQuery();
            List<Student> list=new ArrayList<>();
            while(rs.next()){
                Student stu=new Student();
                stu.setSno(rs.getInt("SNo"));
                stu.setSname(rs.getString("Sname"));
                stu.setSpassword(rs.getString("Spassword"));
                stu.setSclass(rs.getString("Sclass"));
                stu.setSsex(rs.getString("Ssex"));
                list.add(stu);
            }
            for(Student s:list){
                System.out.println(s);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                rs.close();
                ps.close();
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }


        }

    }
}
