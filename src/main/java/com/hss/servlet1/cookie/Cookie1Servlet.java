package com.hss.servlet1.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Cookie1Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        //Cookie的简单使用。

        //cookie 发送给客户端，并且保存在客户端上的一份小数据

        response.setContentType("text/html;charset=utf-8");
        /*
         * 方法参数要什么就给什么。 对象
         *
         * 创建对象的几种手法
         *
         * 1. 直接new
         *
         * 2. 单例模式  | 提供静态方法
         *
         * 3. 工厂模式构建  stu
         *
         * StuFactory  StuBuilder
         */
        //发送cookie给客户端
        Cookie cookie = new Cookie("aa", "bb");
        //给响应，添加一个cookie

        response.addCookie(cookie);
        response.getWriter().write("请求成功了");
        //获取客户端带过来的cookie
        Cookie[] cookies = req.getCookies();
        if(cookies != null){
            for (Cookie c : cookies) {
                String cookieName = c.getName();
                String cookieValue = c.getValue();
                System.out.println(cookieName + " = "+ cookieValue);
            }
        }

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
