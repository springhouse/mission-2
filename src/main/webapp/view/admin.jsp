<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags"
prefix="sec"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/xml; charset=UTF-8">
    <title>Insert title here</title>
</head>
<script>
    window.addEventListener('load', function () {
        document.querySelector('#go').addEventListener('click',login)

    });
    function login(){
        var formData = new FormData();
        var id=document.getElementById('id').value;
        var pw=document.getElementById('pw').value;
        formData.append("username",id);
        formData.append("password",pw);

        var xhr = new XMLHttpRequest();
        xhr.open('POST', 'login-processing');
        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xhr.addEventListener('load', customCallback);
        xhr.send(formData);
    }
    function customCallback(e){
        console.log(e)
    }

</script>
<body>
<form>
    <input id="id" type="text">
    <input id="pw" type="password">
</form>
<button id="go">login</button>
<h1>admin page</h1>
<p>principal : <sec:authentication property="principal"/></p>
<a href="/customLogout"></a>
</body>
</html>
