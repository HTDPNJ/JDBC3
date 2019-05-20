package com.hfut.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtil {
    private static String driver;
    private static String url;
    private static String usrname;
    private static String password;
    static{
        Properties p=new Properties();
        InputStream is=JdbcUtil.class.getResourceAsStream("/db.properties");
        try {
            //加载属性配置文件
            p.load(is);
            //获取参数
            driver=p.getProperty("driver");
            url=p.getProperty("url");
            usrname=p.getProperty("username");
            password=p.getProperty("password");
            //加载驱动
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //获取Connection对象
    public static Connection getConnection() throws SQLException {
        Connection conn=null;
        conn= DriverManager.getConnection(url,usrname,password);
        return conn;
    }

    //获取封装PreparedStatement对象
    public static PreparedStatement getPreparedStatement(String sql,Connection conn) throws SQLException {
        PreparedStatement ps=conn.prepareStatement(sql);
        return ps;
    }

    public static  Statement getStatement(Connection conn) throws SQLException {
        Statement stmt=null;
        stmt=conn.createStatement();
        return stmt;
    }

    //关闭资源
    public static void closeAll(ResultSet rs,Statement stmt,Connection conn){
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //封装DML
    public static int executeDML(String sql,Object...objs) throws SQLException {
        Connection conn=getConnection();
        PreparedStatement ps=getPreparedStatement(sql,conn);
        for(int i=0;i<objs.length;i++){
            ps.setObject(i+1,objs[i]);
        }
        int i=ps.executeUpdate();
        JdbcUtil.closeAll(null,ps,conn);
        return i;
    }

}
