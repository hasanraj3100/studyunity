<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="routes.RoutePaths" %>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
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
            <a href="login" class="btn-normal">Login</a>
            <a href="register" class="btn-normal">Register</a>
        </div>
        <div class="clr"></div>
    </header>

    <main>
        <div class="registration-section">
            <div class="regbox">
                <h1>Create an account</h1>
                <form action="<% out.println(request.getContextPath() + "/register"); %>" method="post">
                	<div class="error-section">
                		<p>${errortext} </p>
                	</div>
                    <label for="fullname">Full Name:</label><br>
                    <input type="text" id="fullname" name="fullname"><br>
                    <label for="email">Email:</label><br>
                    <input type="email" id="email" name="email"><br>
                    <label for="institute">Institute:</label><br>
                    <input type="text" id="institute" name="institute"><br>
                    <label for="level">Level:</label><br>
                    <select id="level" name="level">
                    <option value="1">School</option>
                    <option value="2">High School</option>
                    <option value="3">College</option>
                    <option value="4">University</option>
                    </select><br><br>
                    <label for="username">Username:</label><br>
                    <input type="text" name="username" id=""><br>
                    <label for="password">Password:</label><br>
                    <input type="password" id="password" name="password"><br><br>
                    <button type="submit">Register</button>
                </form> 
            </div>
        </div>
    </main>
</body>
</html>