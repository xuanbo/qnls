<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>login</title>
</head>
<body>
    <form action="/login" method="post">
        用户名 : <input type="text" name="username"/>
        密码: <input type="password" name="password"/>
        记住我: <input type="checkbox" name="remember-me" value="true">
        <input type="submit" value="登录"/>
    </form>
</body>
</html>