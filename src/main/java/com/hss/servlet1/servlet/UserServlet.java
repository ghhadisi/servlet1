package com.hss.servlet1.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends BaseServlet {



    public String login(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        String dispatcher = null;
        dispatcher = "/jsp/second.jsp";
        return dispatcher;
    }

    public String add(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        String dispatcher = null;
        dispatcher = "/jsp/three.jsp";
        return dispatcher;
    }
}
