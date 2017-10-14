<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>图书详情</title>
    <style type="text/css">
    .title{
    position:relative;
    top:70px;
    width:500px;
    height:50px;
    }
    .button{
    position:relative;
    top:100px;
    left:600px;
    }
    </style>
</head>
<body>
    <center>
        <table class ="title" style = "text-align:center;">
            <tr class="title">
                <td style="font-weight:bold;">书名</td>
                <td style="font-weight:bold;">ISBN</td>
                <td style="font-weight:bold;">出版社</td>
                <td style="font-weight:bold;">出版日期</td>
                <td style="font-weight:bold;">价格</td>
            </tr>
            <s:iterator value = "#request.book" id = "book" status="status">
            <tr>
                <td>${Title}</td>
                <td>${ISBN}</td>
                <td>${Publisher }</td>
                <td>${PublishDate }</td>
                <td>${Price}</td>
            </tr>
            </s:iterator>
            <tr class = "title">
                <td style="font-weight:bold;">作者</td>
                <td style="font-weight:bold;">年龄</td>
                <td style="font-weight:bold;">国籍</td>
            </tr>
            <s:iterator value = "#request.author" id = "author" status="status">
            <tr>
                <td>${name}</td>
                <td>${age }</td>
                <td>${country }</td>
            </tr>
            </s:iterator>
 
        </table>
    </center>
    <input class= "button" type = "button" value = "返回首页" onclick="window.location.href='Home.jsp'">
</body>
</html>