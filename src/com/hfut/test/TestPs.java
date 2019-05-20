package com.hfut.test;

import com.hfut.pojo.User;
import com.hfut.preparedStatementImpl.UserDaoImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class TestPs {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner sc=new Scanner(System.in);
        String uname=sc.nextLine();
        String upwd=sc.nextLine();
        UserDaoImpl ud=new UserDaoImpl();
        User u=ud.getUserInfo(uname,upwd);
        if(u!=null)
            System.out.println("用户登录成功");
        else
            System.out.println("用户名或密码错误，请重新登陆");
    }
}
