
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<h2>Login</h2>
<h4>${message}</h4>
<form action="/user/login" method="post">
    <div class="form-group">
        <lable>Username</lable>
        <input name="username" type="text" class="form-control" value="${username}">
    </div>
    <div class="form-group">
        <lable>Password</lable>
        <input name="password" type="text" class="form-control" value="${password}">
    </div>
    <div class="form-group">
        <div class="form-control">
            <input name="rm" type="checkbox">
            <lable>Remember me</lable>
        </div>
    </div>
    <div class="form-group">
        <button class="btn btn-default">Login</button>
    </div>
</form>
