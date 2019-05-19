<%--
  Created by IntelliJ IDEA.
  User: 张三丰
  Date: 2019/5/18
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@  taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">


</head>
<body>
<h1>用户管理</h1>
<shiro:hasPermission name="user:add">
    <A href="${pageContext.request.contextPath}/user/add.do">添加用户</A>
</shiro:hasPermission>


<hr>
<shiro:hasPermission name="user:del">
    <A href="${pageContext.request.contextPath}/user/del.do">删除用户</A>
</shiro:hasPermission>

<hr>
<shiro:hasPermission name="user:update">
    <A href="${pageContext.request.contextPath}/user/update.do">修改用户</A>
</shiro:hasPermission>

<hr>
<shiro:hasPermission name="user:search">
    <A href="${pageContext.request.contextPath}/user/search.do">查询用户</A>
</shiro:hasPermission>
</body>
</html>
