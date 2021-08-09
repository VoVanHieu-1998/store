
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<h2>Forgot password</h2>
<h4>${message}</h4>
<form action="/user/forgotPW" method="post">
    <div class="form-group">
        <lable>Username</lable>
        <input name="username" type="text" class="form-control" >
    </div>
    <div class="form-group">
        <lable>Email</lable>
        <input name="email" type="text" class="form-control" >
    </div>
    <div class="form-group">
        <button class="btn btn-default">Send</button>
    </div>
</form>
