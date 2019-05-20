package com.hfut.preparedStatementImpl;

import com.hfut.pojo.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl {
    //查询用户信息
    public User getUserInfo(String uname,String upwd) throws ClassNotFoundException, SQLException {
        User u=null;
        //1、加载驱动类
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //2、获取数据库连接对象
        Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
        //3 获取sql命令对象
        String sql="select * from user2 where uname=? and upwd=?";
        PreparedStatement ps=conn.prepareStatement(sql);

        //给占位符赋值
        ps.setString(1,uname);
        ps.setString(2,upwd);

        //5 指定sql命令
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            u=new User();
            u.setUnum(rs.getInt("UNUM"));
            u.setUname(rs.getString("UNAME"));
            u.setUpwd(rs.getString("UPWD"));
        }
        //关闭资源
        rs.close();
        ps.close();
        conn.close();
        return u;
    }
}
