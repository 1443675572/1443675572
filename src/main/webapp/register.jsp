<%@page contentType="text/html; utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width ,user-scalable=no , initialize">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Title</title>
</head>
<body>

<h1>用户注册</h1>
<form action="${pageContext.request.contextPath}/user/register " method="post">
    用户名:<input type="text" name="userName"><br/>
    密码:<input type="text" name="passWord"><br/>
    <input type="submit" value="注册">
</form>
<a href="${pageContext.request.contextPath}/user/loginOut">退出</a>

</body>
</html>