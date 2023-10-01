<%@page import="jakarta.servlet.http.HttpSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<body>

    <%
    	response.sendRedirect(request.getContextPath() + "/home");
    %>

    
</body>
</html>