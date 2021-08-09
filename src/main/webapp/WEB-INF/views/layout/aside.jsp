    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    <%@ taglib prefix="f" uri="http://java.sun.com/jstl/fmt_rt" %>
        <c:set var="cart" value="${sessionScope['scopedTarget.cartSession']}"/>
        <div class="panel panel-default">
        <div class="panel-heading">SHOPPING CART</div>
        <div class="panel-body">
        <img id="cart-img-js" src='<c:url value="/resources/img/shopping-cart.png"/>' class="col-sm-5">
        <ul class="col-sm-7">
        <li><b id="cart-cnt">${cart.count}</b> mặt hàng</li>
        <li><b id="cart-amt">${cart.amount} VND</b> </li>
        <li>
        <a href="/cart/view">Xem giỏ hàng</a>
        </li>
        </ul>
        </div>
        </div>


        <div class="panel panel-default">
        <div class="panel-heading">TÌM KIẾM</div>
        <div class="panel-body">
        <form action="/product/list-by-keywords" method="post">
        <input value="${param.keywords}" name="keywords" class="form-control" placeholder="key">
        </form>
        </div>
        </div>

        <div class="panel panel-default">
        <div class="panel-heading">Danh MỤC</div>
        <div class="list-group">
        <c:forEach var="c" items="${catalog}">
            <a href="/product/list-by-catalog/${c.catalogId}" class="list-group-item">${c.name}</a>

        </c:forEach>
        </div>
        </div>

        <div class="panel panel-default">
        <div class="panel-heading">ĐẶC BIỆT</div>
        <div class="list-group">
        <a href="/product/spec/0" class="list-group-item">Hàng mới</a>
        <a href="/product/spec/1" class="list-group-item">Hàng bán chạy</a>
        <a href="/product/spec/2" class="list-group-item">Hàng yêu thích</a>
        <a href="/product/spec/3" class="list-group-item">Hàng giảm giá</a>
        </div>
        </div>

        <style id="cartcss">

        </style>

