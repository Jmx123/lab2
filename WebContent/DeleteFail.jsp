<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <title>删除失败</title>
     <style type="text/css">
     .text{
          position:relative;
          top:100px;
          font-size:24px;
     }
     .error{
          position:relative;
          top:90px;
          font-size:20px;
     }
     .button{
          position:relative;
          top:120px;
          left:500px;
     }
     </style>
</head>
<body>
     <center>
     <h3 class="text">删除失败</h3>
     <p class="error">错误原因：<%=(String)request.getParameter("error") %></p>
     </center>
     <input type = "button" value = "返回首页" class="button" onclick="window.location.href='Home.jsp'">
</body>
</html>