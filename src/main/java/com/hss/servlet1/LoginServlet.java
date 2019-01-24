package com.hss.servlet1;

import com.sun.net.httpserver.HttpsServer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        if (userName.equals("hss") && password.equals("123")){
//response.getWriter().write("登录成功");
			/*
			 * 早期的写法：
			 * response.setStatus(302);
			response.setHeader("Location", "login_success.html");*/

            //重定向写法： 重新定位方向  /根目录  2次请求不限制
            response.sendRedirect("login_success.html");


            //请求转发的写法： 1次请求  项目内转发
//			request.getRequestDispatcher("login_success.html").forward(request, response);
        }else {
            response.getWriter().write("登录失败");

        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}

