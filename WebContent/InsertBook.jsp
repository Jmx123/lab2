<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>添加图书</title>
    </head>
    <style>
    .h2{
        position:relative;
        left:250px;
        margin-top:100px;
    }
     .text{
        width:80px;
        height:30px;
        font-size:16px;
    }
    .submit{
            position:relative;
            left:100px;
            top:90px;
            width:50px;
    }
    </style>
    <script type="text/javascript">
          function Validate(){
        	  var reg = new RegExp("^[0-9]{6}$"); //匹配6位数字
        	  var publishdate = document.getElementById("publishdate");
        	  if(publishdate.value=="")
        		  {
        		  alert("信息不能为空！");
        		  return false;
        		  }
        	  else if(!reg.test(publishdate.value))
        	  {
        		  alert("日期需输入6位数字！");
        		  return false;
        	  }
        	  //"^[0-9]+\.?[0-9]*$"
        	  var regPrice = new RegExp("^[0-9]+\.?[0-9]*$");
        	  var price = document.getElementById("price");
        	  
        	  if(price.value=="")
        		  {
        		  alert("信息不能为空！");
        		  return false;
        		  }
        	  else if(!regPrice.test(price.value))
        	  {
        		  alert("价格输入整数或小数！");
        		  return false;
        	  }
        	  
        	  var title = document.getElementById("title");
        	  if(title.value=="")
        		  {
        		  alert("信息不能为空！");
        		  return false;
        		  }
        	  
        	  var isbn = document.getElementById("isbn");
        	  if(isbn.value=="")
        		  {
        		  alert("信息不能为空！");
        		  return false;
        		  }
        	  
        	  var publisher = document.getElementById("publisher");
        	  if(publisher.value=="")
        		  {
        		  alert("信息不能为空！");
        		  return false;
        		  }
        	  
        	  var author = document.getElementById("author");
        	  if(author.value=="")
        		  {
        		  alert("信息不能为空！");
        		  return false;
        		  }
        	  else
        		  {
        		  return true;
        		  }
        	
        	  
        	  
          }
    </script>
<body>
    <h2 class="h2">请输入以下信息(所有信息必须填写)：</h2>
    <form action="InsertBookAction" method = "get" onsubmit="return Validate();">
    <center>
      <table>
         <tr><td class="text">书名</td>
             <td><input name="title" id="title" type="text" maxlength="45"></td>
         </tr>

         <tr>
             <td class="text">ISBN</td>
             <td><input name="isbn" id="isbn" type="text" maxlength="17"><td>
         </tr>

         <tr>
             <td class="text">作者</td>
             <td><input name="author" id="author" type="text" maxlength="50"><td>
         </tr>

         <tr>
             <td class="text">出版社</td>
             <td><input name="publisher" id="publisher" type="text" maxlength="45"><td>
         </tr>

         <tr>
             <td class="text">出版日期</td>
             <td><input name="publishdate" id="publishdate" type="text" maxlength="6"><td>
             <td>*格式如200809</td>
         </tr>

         <tr>
             <td>价格</td>
             <td><input name="price" id="price" type="text" ><td>
             <td>*格式如20.3</td>
         </tr>

       </table>
       <input value="提交" type = "submit" class="submit">
     </center>
     
     </form>
</body>
</html>