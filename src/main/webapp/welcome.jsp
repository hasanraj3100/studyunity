<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page isELIgnored="false"%>
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
            <a href="group_study" class="btn-normal">Group Study</a>
            <a href="share_material" class="btn-normal">Share Material</a>
            <a href="profile" class="btn-normal">Profile</a>
            <a href="logout" class="btn-normal">Logout</a>
        </div>
        <div class="clr"></div>
    </header>

    <main>
        <div class="main-section">
            <div class="search-section">
                
                <form action="search" method="GET">
                    <h1>Search Material</h1>
                    <div class="form-group">
                        <label for="topicName">Name of the Topic:</label>
                        <input type="text" id="topicName" name="topicName" required>
                    </div>
                    <div class="form-group">
                        <label for="level">Level:</label>
                        <select id="level" name="level" required>
                            <option value="1">School</option>
                            <option value="2">High School</option>
                            <option value="3">College</option>
                            <option value="4">University</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <button type="submit">Search</button>
                    </div>
                </form>
            </div>
            <div class="right-wing">
                <div class="overview">
                    <div>
                        <h1>Welcome, <br> ${user.getName()}</h1>
                        <p class="rank">Your Rank: ${user.getRank() }</p>
                        <p class="score">Your Influence: ${user.getInfluence()}</p>
                    </div>
                </div>
                
            </div>
            <div class="clr"></div>
        </div>
    </main>


    
</body>
</html>