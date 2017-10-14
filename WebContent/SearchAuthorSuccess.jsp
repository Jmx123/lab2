<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>搜索结果</title>
    <style type="text/css">
    .a{
            position:relative;
            left:900px;
            top:50px;
    }
    </style>
</head>
<body>
    <h1 style="text-align:center; font-size:30px; ">查询结果</h1>
    <center>
    <table>
        <s:iterator value = "#request.bookList" id = "bookList" status="status">
        <tr>
           <td style="text-align:center;font-weight:bold;FONT-SIZE:16pt;HEIGHT:50px;"><p>图书：</p></td>
           <td><a href="ShowBookAction.action?isbn=<%=java.net.URLEncoder.encode((String)request.getAttribute("ISBN"),"UTF-8")%>" style="text-decoration:none;"><s:property value = "#bookList.Title"/></a></td>
           
        </tr>
        
        <tr>
           <td style="text-align:center;font-weight:bold;FONT-SIZE:16pt;HEIGHT:50px;"><p>作者：</p></td>
           <td><s:property value = "#bookList.Author"/></td>
           <td><a href="UpdateAuthor.jsp?author=<%=java.net.URLEncoder.encode((String)request.getAttribute("Author"),"UTF-8")%>" style="text-decoration:none;">更新作者信息</a></td>
        </tr>
        <tr><td></td></tr>
        </s:iterator>
        
    </table>
    
    </center>
    
</body>
</html>