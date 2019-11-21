<%--
  Created by IntelliJ IDEA.
  User: ars
  Date: 17.11.2019
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign up</title>
</head>
<body>
<%
    String msg = "";
    if(!(request.getAttribute("msg") == null)) {
        msg = (String) request.getAttribute("msg");
    }
%>
<%=msg%>
<form action="SignUpServlet" method="post">
<div>
    <label for="login">Login:</label>
    <input id="login" name="login" type="text">
</div>
    <div>
    <label for="password">Password:</label>
    <input id="password" name="password" type="text">
    </div>
    <div>
    <input type="submit" value="submit">
    </div>
</form>
</body>
</html>
