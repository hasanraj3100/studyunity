<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page isELIgnored="false"%>
    <%@page import="routes.RoutePaths" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Study Unity</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

    <header>
        <div class="logo">
            <a href="<% out.println(request.getContextPath() + "/"); %>">
            <img src="images/logo.png" alt="">
            </a>
        </div>
        <div class="menusection">
     
            <a href="${RoutePaths.getPath("login") }" class="btn-normal">Login</a>
            <a href="${RoutePaths.getPath("register") }" class="btn-normal">Register</a>
        </div>
        <div class="clr"></div>
    </header>

    <main>
        <div class="banner">
            <img src="images/banner.jpg">
        </div>
    </main>
    
    
    
</body>
</html>