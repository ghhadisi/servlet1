<%--
  Created by IntelliJ IDEA.
  User: ssdeepin
  Date: 19-1-21
  Time: 下午11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  errorPage="error.jsp"  isELIgnored="false" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>

<%=request.getParameter("address")

%>
取出四个作用域中的值<br>
<%=pageContext.getAttribute("name")%>
<%=request.getAttribute("name")%>
<%=session.getAttribute("name")%>
<%=application.getAttribute("name")%>

<br> el 表达式 <br>
${name}
${param.address}
</body>
</html>
