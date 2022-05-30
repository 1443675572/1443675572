<%@page contentType="text/html; utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width ,user-scalable=no , initialize">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Title</title>
</head>
<body>
    <h1>系统主页</h1>
<ul>
    <shiro:hasAnyRoles name="user,admin">
        <li><a href="#">用户管理</a>
            <ul>
                <shiro:hasPermission name="user:add:*">
                    <li><a href="">添加用户</a></li>
                </shiro:hasPermission>
                <shiro:hasPermission name="user:del:*">
                    <li><a href="">删除用户</a></li>
                </shiro:hasPermission>
                <shiro:hasPermission name="superAdmin:update:*">
                    <li><a href="">修改用户</a></li>
                </shiro:hasPermission>
                <shiro:hasPermission name="user:*:*">
                    <li><a href="">查询用户</a></li>
                </shiro:hasPermission>
            </ul>
        </li>
    </shiro:hasAnyRoles>
    <shiro:hasRole name="admin">
        <li><a href="#">商品管理</a></li>
        <li><a href="#">订单管理</a></li>
        <li><a href="#">物流管理</a></li>
    </shiro:hasRole>


</ul>
    <a href="${pageContext.request.contextPath}/user/loginOut">退出</a>
</body>
</html>