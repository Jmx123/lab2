<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书管理</title>

</head>
<body>
   <div style="margin-top:150px;text-align: center;font-size: 48px;">图书管理</div> 
       

   
        <form action="SearchAction" method="get">
        <center>
        <table style="text-align:center;height:100px;">
             <tr>
              <td><input style = "width:250px;height:30px" name="searchtxt" type="text"></td>
              <td><select style = "width:60px;height:37px" name = "content">
                      <option value = "book">书籍</option>
                      <option value = "author">作者</option>
                  </select>
              </td>
              <td><input style = "width:80px;height:37px" value="搜索" type = "submit"></td>
             </tr>
        </table> 
        </center>
        </form>
     
        
   
</body>
</html>