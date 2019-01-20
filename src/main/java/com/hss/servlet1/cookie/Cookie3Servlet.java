package com.hss.servlet1.cookie;

import com.hss.servlet1.utils.CookieUtil;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class Cookie3Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        String userName = req.getParameter("username");
        String password = req.getParameter("password");

        if("hss".equals(userName) && "123".equals(password)){
            //获取cookie last-name --- >
            Cookie[] cookies = req.getCookies();

            //从数组里面找出我们想要的cookie
            Cookie cookie = CookieUtil.findCookie(cookies, "last");

            //是第一次登录，没有cookie
            if(cookie == null){

                Cookie c = new Cookie("last", System.currentTimeMillis()+"");
                c.setMaxAge(60*60); //一个小时
                resp.addCookie(c);

                resp.getWriter().write("欢迎您, "+userName);

            }else{
                //1. 去以前的cookie第二次登录，有cookie
                long lastVisitTime = Long.parseLong(cookie.getValue());

                //2. 输出到界面，
                resp.getWriter().write("欢迎您, "+userName +",上次来访时间是："+new Date(lastVisitTime));


                //3. 重置登录的时间
                cookie.setValue(System.currentTimeMillis()+"");
                resp.addCookie(cookie);
            }
        }else{
            resp.getWriter().write("登陆失败 ");
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
