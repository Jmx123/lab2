<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <title>更新成功</title>
     <style type="text/css">
    .button{
            position:relative;
    }
    </style>
</head>
<body>
    <h1 align="center">更新成功</h1>
    <center>
    <table>
        <s:iterator value = "#request.bookupdate" id = "bookupdate" status="status">
        <tr>
           <td style="text-align:center;font-weight:bold;FONT-SIZE:15pt;"><p>图书：</p></td>
           <td><s:property value = "#bookupdate.title"/></td>
           
          
        </tr>
        <tr>
           <td style="text-align:center;FONT-SIZE:15pt;"><p>作者：</p></td>
           <td><s:property value = "#bookupdate.author"/></td>
           <td></td>
        </tr>
        <tr>
           <td style="text-align:center;FONT-SIZE:15pt;"><p>出版社：</p></td>
           <td><s:property value = "#bookupdate.publisher"/></td>
        </tr>
        <tr>
           <td style="text-align:center;FONT-SIZE:15pt;"><p>出版日期：</p></td>
           <td><s:property value = "#bookupdate.publishdate"/></td>
        </tr>
        <tr></tr>
        <tr>
           <td style="text-align:center;FONT-SIZE:15pt;"><p>价格：</p></td>
           <td><s:property value = "#bookupdate.Price"/>元</td>
        </tr>
        <tr></tr>
        <tr></tr>
        
        </s:iterator>
    
    </table>
    <div class = "button"><input type = "button" value = "返回首页" onclick="window.location.href='Home.jsp'"></div>
    </center>
</body>
</html>