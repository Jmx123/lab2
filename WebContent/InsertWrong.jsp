<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>添加图书</title>
    <style type="text/css">
    .p{
        position:relative;
        top:100px;
        width:300px;
        height:100px;
        font-size:20px;
    }
    .button{
        position:relative;
        top:30px;
        width:100px;
        height:30px;
    }
    </style>
</head>
<body>
<center>
<p class="p">图书已存在或ISBN输入错误</p>
<input class="button" type = "button" value = "返回首页" onclick="window.location.href='Home.jsp'">
<input class="button" type = "button" value = "重新添加" onclick="window.location.href='InsertBook.jsp'">
</center>
</body>
</html>