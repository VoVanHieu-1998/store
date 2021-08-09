
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
enctype="multipart/form-data" dùng để file upload



--%>
<h2>Register</h2>
<h4>${message}</h4>
<form:form action="/user/register" modelAttribute="user" enctype="multipart/form-data">
    <div class="form-group">
        <lable>Username</lable>
        <form:input path="username"  class="form-control"/>
        <p style="color: red"><form:errors path="username" ></form:errors></p>
    </div>
    <div class="form-group">
        <lable>Password</lable>
        <form:input path="password"  class="form-control" />
    </div>
    <div class="form-group">
        <lable>FullName</lable>
        <form:input path="fullName"  class="form-control"/>
    </div>
    <div class="form-group">
        <lable>PhoneNumber</lable>
        <form:input path="phoneNumber"  class="form-control" />
    </div>
    <div class="form-group">
        <lable>Email</lable>
        <form:input path="email"  class="form-control"/>
    </div>
    <div class="form-group">
        <lable>Address</lable>
        <form:input path="address"  class="form-control" />
    </div>
    <div class="form-group">
        <lable>Img</lable>
        <input type="file" name="photoFile">
        <form:hidden path="photo"  class="form-control" />
    </div>


    <div class="form-group">
        <button class="btn btn-default">Register</button>
    </div>
</form:form>
