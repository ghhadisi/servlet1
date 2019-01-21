package com.hss.servlet1.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class SessionCartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");
        //1. 获取要添加到购物车的商品id
        int id = Integer.parseInt(req.getParameter("id")); // 0 - 1- 2 -3 -4
        String [] names = {"Iphone7","小米6","三星Note8","魅族7" , "华为9"};
        //取到id对应的商品名称
        String name = names[id];


        //2. 获取购物车存放东西的session  Map<String , Integer>  iphoen7 3
        //把一个map对象存放到session里面去，并且保证只存一次。
        Map<String, Integer> map = (Map<String, Integer>) req.getSession().getAttribute("cart");
        //session里面没有存放过任何东西。
        if(map == null){
            map = new LinkedHashMap<String , Integer>();
            req.getSession().setAttribute("cart", map);
        }


        //3. 判断购物车里面有没有该商品
        if(map.containsKey(name)){
            //在原来的值基础上  + 1
            map.put(name, map.get(name) + 1 );
        }else{
            //没有购买过该商品，当前数量为1 。
            map.put(name, 1);
        }

        String sId  = req.getSession().getId();
        Cookie cookie = new Cookie("JSESSIONID", sId);
        cookie.setMaxAge(60*60*24*7);


        resp.addCookie(cookie);

        //4. 输出界面。（跳转）
        resp.getWriter().write("<a href='product_list.jsp'><h3>继续购物</h3></a><br>");
        resp.getWriter().write("<a href='cart.jsp'><h3>去购物车结算</h3></a>");
    }
}
