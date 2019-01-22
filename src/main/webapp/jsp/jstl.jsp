<%@ page import="com.hss.servlet1.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: acerdeepin
  Date: 19-1-22
  Time: 下午2:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- 声明一个对象name， 对象的值 zhangsan , 存储到了page（默认） ， 指定是session -->
<c:set var="name" value="zhangsan" scope="session"></c:set>
${sessionScope.name}

<br>----------------------<br>
<c:set var="age" value="18"></c:set>

<c:if test="${age > 26}" var="flag" scope="session">
    年龄大于了26岁...
</c:if>
<c:if test="${ age <= 26 }">
    年龄小于了26岁...
</c:if>

flag = ${flag}
<br>----------------------<br>
从1 开始遍历到10 ，得到的结果 ，赋值给 i ,并且会存储到page域中， step , 增幅为2，
<c:forEach begin="1" end="10" var="i" items="1">
    ${i}
</c:forEach>
<br>----------------------<br>

<%
    List list =new ArrayList();

    list.add(new User("zhangsan",18));
    list.add(new User("lisi",28));
    list.add(new User("wagnwu",38));
    list.add(new User("maliu",48));
    list.add(new User("qianqi",58));

    pageContext.setAttribute("list", list);
%>
<c:forEach var="u" items="${list}">

    ${u.name} ------${u.age}
</c:forEach>
</body>
</html>
