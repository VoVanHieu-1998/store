
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
    <nav class="navbar navbar-inverse">
    <div class="container-fluid">
    <div class="navbar-header">
    <a class="navbar-brand" href="/">Home</a>
    </div>
    <ul class="nav navbar-nav">
    <li><a href="/about">About Us</a></li>
    <li><a href="/contact">Contact Us</a></li>
    <li><a href="/feedback">FeedBack</a></li>
    <li class="dropdown">
    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Account<span class="caret"></span></a>
<%--    <c:choose>--%>
<%--        <c:when test="${sessionScope.user == null}">--%>
<%--            <ul class="dropdown-menu">--%>
<%--            <li><a href="#">Đăng nhập </a></li>--%>
<%--            <li><a href="#">Đăng ký</a></li>--%>
<%--            <li><a href="#">Quên mật khẩu</a></li>--%>
<%--            </ul>--%>
<%--        </c:when>--%>
<%--        <c:otherwise>--%>
<%--            <ul class="dropdown-menu">--%>
<%--            <li><a href="#">Đăng xuất</a></li>--%>
<%--            <li><a href="#">Đổi mật khẩu</a></li>--%>
<%--            <li><a href="#">Cập nhật tài khoản</a></li>--%>
<%--            <li><a href="#">Đơn hàng</a></li>--%>
<%--            </ul>--%>
<%--        </c:otherwise>--%>
<%--    </c:choose>--%>



    </li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
    <li><a href="#"> Tiếng Việt</a></li>
    <li><a href="#"> English</a></li>
    </ul>
    </div>
    </nav>
