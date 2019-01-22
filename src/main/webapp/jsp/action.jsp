<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: ssdeepin
  Date: 19-1-21
  Time: 下午11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <title>Title</title>
  </head>
  <body>
  <%--
	<jsp:include page=""></jsp:include>
	<jsp:param value="" name=""/>
	<jsp:forward page=""></jsp:forward> --%>

  这是jsp_action的页面.
  <%-- <jsp:include page="other02.jsp"></jsp:include> --%>



  <%-- <jsp:forward page="other02.jsp"></jsp:forward>
  等同于以下代码 --%>

  <%--
    //请求转发
    //request.getRequestDispatcher("other02.jsp").forward(request, response);
  --%>
<%--
//重定向 2次请求
	response.sendRedirect("other04.jsp");
--%>



  <%

    List<String> list = new ArrayList<>();
    pageContext.setAttribute("name", "page");
    request.setAttribute("name","request");
    session.setAttribute("name", "session");
    application.setAttribute("name", "application");
  %>
  取出四个作用域中的值<br>
  <%=pageContext.getAttribute("name")%>
  <%=request.getAttribute("name")%>
  <%=session.getAttribute("name")%>
  <%=application.getAttribute("name")%>




  <jsp:forward page="second.jsp">
    <jsp:param value="beijing" name="address"/>
  </jsp:forward>
  </body>
</html>
<%@ include file="../index.jsp"%>