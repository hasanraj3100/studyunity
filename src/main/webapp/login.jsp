<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
            <a href="" class="btn-normal">Login</a>
            <a href="" class="btn-normal">Register</a>
        </div>
        <div class="clr"></div>
    </header>

    <main>
        <div class="login-section">
            
            <form action="<%out.println(request.getContextPath() + "/login" );%>" method="post">
                <h1>Login to your account</h1>
                <label for="username">Username:</label><br>
                <input type="text" id="username" name="username"><br>
                <label for="password">Password:</label><br>
                <input type="password" id="password" name="password"><br><br>
                <div class="error-section">
                	<p> ${errortext} </p>
                </div>
                <button type="submit">Login</button>
            </form>
        </div>
    </main>
</body>
</html>