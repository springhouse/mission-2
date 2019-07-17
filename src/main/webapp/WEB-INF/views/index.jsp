<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>
    <p>csrf param: ${_csrf.parameterName}</p>
    <p>csrf token: ${_csrf.token}</p>

    <a href="/ajaxlogin">로그인</a>
    <a href="/register">회원가입</a>
    <div>
        <a href="/adminpage">관리자</a>
        <a href="/userpage">사용자</a>
    </div>
</body>
</html>
