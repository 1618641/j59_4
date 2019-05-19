<%@ page language="java" isELIgnored="false" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">


  </head>
  
  <body style="margin: 0px">
		<table width="100%" height="100%" border="1">
            <Tr style="height: 20%">
                <Td colspan="2">
                    欢迎你,【<B style="color: red">${username}</b>】
                    <a href="logout.do">退出登录</a>
                </Td>
            </Tr>
			<Tr>
				<Td width="20%" VALIGN="top" align="center">
					<Br>
					菜单
					<Br>
                    <c:forEach items="${list}" var="k">
                        <A href="${k.url}">${k.NAME}</A><Br>
                    </c:forEach>

				</Td>
				<Td>
					欢迎光临...
				</Td>
			</Tr>
		</table>
  </body>
</html>
