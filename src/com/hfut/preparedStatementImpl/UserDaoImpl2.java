package com.hfut.preparedStatementImpl;

import com.hfut.pojo.User;
import com.hfut.util.JdbcUtil;

import java.sql.*;

public class UserDaoImpl2 {
    //查询用户信息
    public User getUserInfo(String uname,String upwd) throws ClassNotFoundException, SQLException {
        User u=null;

        Connection conn= JdbcUtil.getConnection();
        //3 获取sql命令对象
        String sql="select * from user2 where uname=? and upwd=?";
        PreparedStatement ps=JdbcUtil.getPreparedStatement(conn,sql);

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
       JdbcUtil.closeAll(rs,ps,conn);
        return u;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDaoImpl2 ue=new UserDaoImpl2();
        User u=ue.getUserInfo("张三","123456");
        System.out.println(u);
    }
}
