<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page isELIgnored="false"%>
    <%@page import="routes.RoutePaths" %>
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
            <a href="group_study" class="btn-normal">Group Study</a>
            <a href="share_material" class="btn-normal">Share Material</a>
            <a href="profile" class="btn-normal">Profile</a>
            <a href="logout" class="btn-normal">Logout</a>
        </div>
        <div class="clr"></div>
    </header>

    <main>
        <div class="profile-section">
            <div class="nameplate">
                <div class="names">
                    <h1>${user.getName() }</h1>
                    <span>${user.getRank() }</span>
                </div>
                <div class="score">
                    <span>Influence: ${user.getInfluence() }</span>
                </div>
            </div>
            <div class="info">
                <span> Email : </span> ${ user.getEmail()} <br>
                <span>Institute: </span> ${user.getInstitute()} <br>
                <span>Level: </span> ${user.getLevelString() }
            </div>
        </div>
    </main>
    
   
    
</body>
</html>