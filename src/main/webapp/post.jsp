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
        <a href="<% out.println(request.getContextPath() + "/"); %>">
            <img src="images/logo.png" alt="">
         </a>
        <div class="menusection">
            <a href="group_study" class="btn-normal">Group Study</a>
            <a href="share_material" class="btn-normal">Share Material</a>
            <a href="profile" class="btn-normal">Profile</a>
            <a href="logout class="btn-normal">Logout</a>
        </div>
        <div class="clr"></div>
    </header>

    <main>
        <div class="file-view-section">
            <div>
                <div style="text-align: center;">
                    <h1>${post.getTitle() }</h1>
                </div>
                <div style="display:flex;justify-content: space-around;width:400px;">
                    <div><span>Author: ${post.getUserName() }</span></div>
                <div><span >Date: ${post.getDate() }</span></div>
                <div><span>Level: ${post.getLevel() }</span></div>
                </div>
                
            </div>
            

        </div>
        <div class="file-view-section">
            <div>
                <div class="textbody">
                   ${post.getBody() }
                </div>
                <div class="downloads">
                    <a href="">Download file 1</a>
                </div>
                <div class="reactions">
                    <form action="Reactions" method="post">
                    	<input type="hidden" value="${post.getId() }" name="postid">
                        <button type="submit" name="upvote" value="upvote">Upvote:${post.getUpvotes()}</button>
                        <button type="submit" name="downvote" value="downvote">Downvote: ${post.getDownvotes()}</button>
                    </form>
                </div>
            </div>
            
        </div>
    </main>
    
</body>
</html>