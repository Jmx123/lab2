<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>查询结果</title>
    <style>
    .h1{
        position:relative;
        margin-top:100px;
    }
     .text{
        width:80px;
        height:30px;
        font-size:16px;
    }
    .submit{
            position:relative;
            left:400px;
            top:90px;
            width:50px;
    }
    </style>
</head>
<body>
    <center>
         <h1 class="h1">未查询到结果</h1>
         <table>
             <tr>
                <td><input type = "button" value = "添加图书" onclick="window.location.href='InsertBook.jsp'"></td>
             </tr>
         </table>
    </center>
</body>
</html>