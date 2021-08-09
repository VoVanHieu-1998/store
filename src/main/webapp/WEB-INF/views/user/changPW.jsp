
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<h2>Change password</h2>
<h4>${message}</h4>
<form action="/user/changePW" method="post">
    <div class="form-group">
        <lable>Username</lable>
        <input name="username" type="text" class="form-control" >
    </div>
    <div class="form-group">
        <lable>Current Password</lable>
        <input name="password" type="text" class="form-control" >
    </div>
    <div class="form-group">
        <lable>New Password</lable>
        <input name="pw1" type="text" class="form-control" >
    </div>
    <div class="form-group">
        <lable>Confirm New Password</lable>
        <input name="pw2" type="text" class="form-control" >
    </div>
    <div class="form-group">
        <button class="btn btn-default">Change</button>
    </div>
</form>
