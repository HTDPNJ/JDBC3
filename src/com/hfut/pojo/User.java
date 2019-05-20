package com.hfut.pojo;

public class User {
    private int unum;
    private String uname;
    private String upwd;

    public User() {
    }

    public User(int unum, String uname, String upwd) {
        this.unum = unum;
        this.uname = uname;
        this.upwd = upwd;
    }

    public int getUnum() {
        return unum;
    }

    public void setUnum(int unum) {
        this.unum = unum;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "unum=" + unum +
                ", uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                '}';
    }
}
