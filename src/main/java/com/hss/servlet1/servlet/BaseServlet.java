package com.hss.servlet1.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service.....");
        //获取客户端提交到服务端的method对应的值
        String md=req.getParameter("method");

        if (null == md || "".equals(md) || md.trim().equals("")) {
            md = "execute";
        }
        //定义变量,存放功能执行完毕之后要转发的路径
        String path=null;
        //获取到当前字节码对象(ServletDemo02.class在内存中对象)
        Class clazz = this.getClass();
        //获取clazz上名称为md方法
        Method method= null;
        try {
            method = clazz.getMethod(md, HttpServletRequest.class, HttpServletResponse.class);
            if (method != null){
                //调用找到的方法
                path=(String)method.invoke(this, req,resp);

                if(null!=path){
                    //服务端的转发
                    req.getRequestDispatcher(path).forward(req, resp);
                }
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    // 默认方法
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return null;
    }
}
