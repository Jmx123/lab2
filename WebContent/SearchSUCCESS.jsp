<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>搜索结果</title>
    <style type="text/css">
    .button{
            position:relative;
            left:900px;
            top:50px;
    }
    </style>
</head>
<body>
    <h1 class="ta_01" align="center">查询结果</h1>
    <center>
    <table style = "text-align:center;">
        <s:iterator value = "#request.bookList" id = "bookList" status="status">
        <tr>
           <td style="text-align:center;font-weight:bold;FONT-SIZE:16pt;HEIGHT:50px;">图书  </td>
           <td><a href="ShowBookAction.action?isbn=<%=java.net.URLEncoder.encode((String)request.getAttribute("ISBN"),"UTF-8")%>" style="text-decoration:none;"><s:property value = "#bookList.Title"/></a></td>
           
           <td><a href="UpdateBook.jsp?book=<%=java.net.URLEncoder.encode((String)request.getAttribute("Title"),"UTF-8")%>
                        &ISBN=<%=java.net.URLEncoder.encode((String)request.getAttribute("ISBN"),"UTF-8")%>" style="text-decoration:none;">更新图书</a></td>
           <td><a href="DeleteBookAction.action?isbn=<%=java.net.URLEncoder.encode((String)request.getAttribute("ISBN"),"UTF-8")%>" style="text-decoration:none;" onclick="return confirm('确认删除？');">删除图书</a></td>
           
        </tr>
        <tr>
           <td style="text-align:center;font-weight:bold;FONT-SIZE:16pt;HEIGHT:40px;">作者</td>
           <td><s:property value = "#bookList.Author"/></td>
           <td></td>
        </tr>
        <tr>
           <td style="text-align:center;font-weight:bold;FONT-SIZE:16pt;HEIGHT:40px;">出版社</td>
           <td><s:property value = "#bookList.Publisher"/></td>
        </tr>
        <tr>
           <td style="text-align:center;font-weight:bold;FONT-SIZE:16pt;HEIGHT:40px;">出版日期</td>
           <td><s:property value = "#bookList.PublishDate"/></td>
        </tr>
        <tr></tr>
        <tr></tr>
        
        </s:iterator>
    
    </table>
    </center>
    <div class = "button"><input type = "button" value = "返回首页" onclick="window.location.href='Home.jsp'"></div>
     
</body>
</html>