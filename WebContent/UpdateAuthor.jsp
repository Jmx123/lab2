<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>更改作者信息</title>
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
            left:300px;
            top:100px;
    }
    </style>
    <script type="text/javascript">
          function AgeValidate(){
        	  var reg = new RegExp("^[0-9]*&");
        	  var object = document.getElementById("age");
        	  if(object.value!="" && !reg.test(object.value))
        	  {
        		  alert("年龄需输入数字");
        		  return false;
        	  }
        	  else
        		  return true;
          }
    </script>
</head>

<body>
    <div class = "h2"><h2>请输入以下信息：</h2></div>
    <center>
    <form action="UpdateAuthorAction" method = "get" onsubmit=" return AgeValidate();">
    <table >
        <tr >
            <td style="font-size:16px;">作者</td>
            <td><input name="name" type="text" value = "<%=java.net.URLDecoder.decode(request.getQueryString(),"UTF-8").substring(java.net.URLDecoder.
                				decode(request.getQueryString(),"UTF-8").lastIndexOf("=")+1)%>" readonly class="text"></td>
       </tr>

       <tr>
            <td>年龄</td>
            <td><input name="age" id = "age" type="text" maxlength="3" class="text" ><td>
       </tr>

       <tr>
            <td>国籍</td>
            <td><input name="country" type="text" maxlength="45" class="text"><td>
       </tr>

       <tr>
            <td><input value="提交" type = "submit" class="submit" ></td>
       </tr>
     </table>
     </form>
     </center>
</body>
</html>