<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <title>添加失败</title>
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
     }
     </style>
</head>
<body>
     <center>
          <h1 class="text" align="center">添加失败</h1>
          <p class="error">错误原因：<%=(String)request.getParameter("error") %></p>
     
          <input type = "button" value = "返回首页" class="button" onclick="window.location.href='Home.jsp'">
          <input class="button" type = "button" value = "重新添加" onclick="window.location.href='InsertBook.jsp'">
     </center>
</body>
</html>