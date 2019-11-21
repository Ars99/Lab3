<%@ page import="DAO.DAOpassword" %>
<%@ page import="Entities.LoginPasswordEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: ars
  Date: 18.11.2019
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of users</title>
</head>
<body>
<%
    DAOpassword dao = new DAOpassword();
    List<LoginPasswordEntity> users = dao.findAll();
    for(LoginPasswordEntity user : users){
        out.println(user.getLogin() + "\n");
    }
%>
</body>
</html>
