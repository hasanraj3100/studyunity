<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
    <%@page isELIgnored="false"%>
    <%@page import="controllers.UserController" %>
    <%@page import="models.User" %>
    
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
        <div class="search-results">
            <div class="search-area">
                <div class="search-info">
                    <h1>${totalpost } Notes Found For "${topic }"</h1>

                </div>
               <hr>
                
                <c:forEach var="post" items="${posts }">
                <div class="search-item">
                    <a href="viewnote?id=${post.getId() }"><h2>${post.getTitle() }</h2></a>
                    <span class="name">	
                    	${post.getUserName()}
                     </span>
                    <span class="date">${post.getDate() }</span>
                    <span class="level-info">Level: ${post.getLevelString() }</span>
                    <div class="reaction-section">
                        <span class="upvote">Upvote ${post.getUpvotes() }</span>
                        <span class="downvote">Downvote ${post.getDownvotes() }</span>
                    </div>
                </div>
                </c:forEach>
                
                
            </div>
        </div>
    </main>
    
    ${totalpage } f

    <footer>
        <div class="pagination-section">
            <div class="pagination">
                <a href="#">&laquo;</a>
                <c:forEach var="pageNo" begin="1" end="${totalpage }">
                	<a href="#">${pageNo }</a>
                </c:forEach>
                <a href="#">&raquo;</a>
              </div>
        </div>
    </footer>
</body>
</html>