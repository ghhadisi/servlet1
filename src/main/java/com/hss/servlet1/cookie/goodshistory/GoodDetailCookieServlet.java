package com.hss.servlet1.cookie.goodshistory;

import com.hss.servlet1.utils.CookieUtil;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoodDetailCookieServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取到当前用户准备浏览的ID
        String id = request.getParameter("id");
        Cookie[] cookies = request.getCookies();
        Cookie cookie = CookieUtil.findCookie(cookies, "history");
        if (cookie==null) {
            Cookie cook = new Cookie("history", id);
//			response.sendRedirect("product_info.html");
            cook.setMaxAge(60*60*24*7);
//			cook.setPath("/demo1");
            response.addCookie(cook);
        }else{
            String id2 = cookie.getValue();
            cookie.setValue(id+"#"+id2);
            cookie.setMaxAge(60*60*24*7);
//			cookie.setPath("/demo1");
            response.addCookie(cookie);
        }
        response.sendRedirect("product_info.htm");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
