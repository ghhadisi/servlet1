<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.hss.servlet1.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: acerdeepin
  Date: 19-1-22
  Time: 下午2:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" errorPage="error.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    pageContext.setAttribute("name", "page");
    request.setAttribute("name", "request");
    session.setAttribute("name", "session");
    application.setAttribute("name", "application");
%>
<br>使用EL表达式取出作用域中的值<br>
<br>直接指定说了，到这个作用域里面去找这个name<br>
${pageScope.name}
${sessionScope.name}
${requestScope.name}
${applicationScope.name}

<br>使用EL表达式取出name<br>
<br>//先从page里面找，没有去request找，去session，去application <br>
${name}

<br>-----------------------------<br>

<%
    String [] a = {"aa","bb","cc","dd"};
    pageContext.setAttribute("array", a);
%>

使用EL表达式取出作用域中数组的值<br>
${array[0]}, ${array[1]}, ${array[2]},${array[5]}
<br>-------------集合数据----------------<br>

<%
    List<String> list = new ArrayList<>();
    list.add("11");
    list.add("22");
    list.add("33");
    list.add("44");
    //pageContext.setAttribute("li", list);
    session.setAttribute("list", list);
%>
使用EL表达式取出作用域中集合的值<br>
${list[0]},${list[1] },${list[2] },${list[7]}
<br>-------------Map数据----------------<br>

<%
 Map<String,String> map = new HashMap<>();
    map.put("name", "zhangsna");
    map.put("age","18");
    map.put("address","北京..");
    map.put("address.aa","深圳..");

    application.setAttribute("map",map);
%>

使用EL表达式取出作用域中Map的值<br>
${applicationScope.map.name}, ${applicationScope.map.address}, ${applicationScope.map['address.aa']}


<br>------------------对象---------------------------<br>
<%
    User user = new User();
    user.name = "zhangsan";
    user.age = 23;
    pageContext.setAttribute("user",user);
%>


${pageScope.user.name}, ${pageScope.user.age}

${a > b }, ${a gt b}
${empty pageScope.user}
</body>
</html>
