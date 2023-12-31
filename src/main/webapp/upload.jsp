<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        <div class="upload-section">
            <div>
                <h1>Share a class material</h1>
                <form action="share_material" method="post" enctype="multipart/form-data">
                    <label for="title">Title</label>
                    <input type="text" id="title" name="title">
                
                    <label for="textbox">Textbox</label>
                    <input type="text" id="textbox" name="textbox">
                    
                     <select name="level">
                      <option value="1">School</option>
                      <option value="2">High School</option>
                      <option value="3">College</option>
                      <option value="4">University</option>
                    </select>
                
                    <label for="file">File</label>
                    <input type="file" id="file" name="file">
                
                    <label for="level">Level</label>
                   
                
                    <input type="submit" value="Submit">
                  </form>
            </div>
        </div>
    </main>
    
</body>
</html>