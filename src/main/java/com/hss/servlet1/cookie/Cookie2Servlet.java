package com.hss.servlet1.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Cookie2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //取客户端发送过来的cookie.
        Cookie[] cookies = req.getCookies();
        if(cookies != null){
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName()+" = "+cookie.getValue());
            }
        }


        Cookie cookie = new Cookie("name", "zhangsan");

        //2. 这个cookie的有效期。  默认情况下 ，

        //关闭浏览器后，cookie就没有了。 ---> 针对没有设置cookie的有效期。
        //	expiry： 有效 以秒计算。
        //正值 ： 表示 在这个数字过后，cookie将会失效。
        //负值： 关闭浏览器，那么cookie就失效， 默认值是 -1
        cookie.setMaxAge(60 * 60 * 24 * 7);
        //赋值新的值
        //cookie.setValue(newValue);

        //用于指定只有请求了指定的域名，才会带上该cookie
        cookie.setDomain(".itheima.com");

        //只有访问该域名下的cookieDemo的这个路径地址才会带cookie
        cookie.setPath("/CookieDemo");

        resp.addCookie(cookie);

        Cookie cookie2 = new Cookie("age", "18");
        resp.addCookie(cookie2);

        resp.getWriter().write("hello Cookie...");

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
