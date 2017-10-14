<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <title>更新图书</title>
     <style type="text/css">
    .h2{
        position:relative;
        left:250px;
        margin-top:100px;
    }
    .text{
        width:200px;
        height:30px;
        font-size:16px;
    }
    .submit{
            position:relative;
            width:50px;
            left:300px;
            top:100px;
    }
    .name{
         width:50px;
         height:30px;
         font-size:16px;
    }
    </style>
    <script type="text/javascript">
          function Validate(){
        	  var reg = new RegExp("^[0-9]*$");
        	  var date = document.getElementById("publishDate");
        	  if(!reg.test(date.value))
        	  {
        		  alert("日期需输入数字！");
        		  return false;
        	  }
        	  
        	  var regPrice = new RegExp("^[0-9]*\.?[0-9]*$");
        	  var price = document.getElementById("price");
        	  if(!regPrice.test(price.value))
        		  {
        		  alert("价格输入整数或小数！");
        		  return false;
        		  }
        	  else
        		  return true;
        	  
          }
    </script>
</head>
<body>
<h2 class="h2"><%= java.net.URLDecoder.decode(request.getQueryString(),"UTF-8").substring(
    		java.net.URLDecoder.decode(request.getQueryString(),"UTF-8").indexOf("=")+1,
    		java.net.URLDecoder.decode(request.getQueryString(),"UTF-8").indexOf("&"))%>信息更新：</h2>
    <center>
    <form action="UpdateAction" method = "get" onsubmit="return Validate();">
         
         <table>
             <tr>
                <td class = "name">书号</td>
                <td><input name="isbn" type="text" value = "<%=java.net.URLDecoder.decode(request.getQueryString(),"UTF-8").substring(java.net.URLDecoder.
                				decode(request.getQueryString(),"UTF-8").lastIndexOf("=")+1)%>" readonly class="text"></td>
                <td>* 不可以修改</td>
                
             </tr>  
             <tr></tr>
             
             <tr>
                <td class = "name">作者</td>
                <td><input name="author" type="text" maxlength="50" class="text"></td>
             </tr>  
             <tr></tr> 
             
             <tr>
                <td class = "name">出版社</td>
                <td><input name="publisher" type="text" maxlength="45" class="text"></td>
             </tr>
             <tr></tr>
             
             <tr>
                <td class = "name">出版日期</td>
                <td><input name="publishDate" id = "publishDate" type="text" maxlength="6" class="text"></td>
                <td>*格式如200809</td>
             </tr>
             <tr></tr>
             
             <tr>
                <td class = "name">价格</td>
                <td><input name="price" id="price" type="text" class="text"></td>
                <td>*格式如20.3</td>
             </tr>
             <tr></tr>
             <tr>
                <td><input value="提交" type = "submit" class="submit"></td>
             </tr>
         </table>
         
    </form>
    </center>
    <center>
         <p>注：不需要修改的内容不用填</p>
    </center>
</body>
</html>