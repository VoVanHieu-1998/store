<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<jsp:useBean id="myUtils" class="com.store.utils.MyUtils"/>
<h2>Cart view</h2>
<table class="table">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
        <th>GiamGia</th>
        <th>Quantity</th>
        <th>Amount</th>
        <th>Amount</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach var="i" items="${sessionScope['scopedTarget.cartSession'].items}">
            <tr data-id = "${i.productId}" data-price = ${myUtils.convertPriceToInt(i.price)}>
                <td>${i.productId}</td>
                <td>${i.name}</td>
                <td>${myUtils.convertToVndCurrency(i.price)}</td>
                <td>${myUtils.convertToVndCurrency(i.promotionPrice)}</td>
                <td><input type="number" value="${i.quantity}" min="1" style="width: 70px"></td>
                <td class="amt">${i.quantity * (myUtils.convertPriceToInt(i.price))}</td>
                <td>
                    <button class="btn btn-sm btn-warning btn-cart-remove">
                        <i class="glyphicon glyphicon-trash"></i>
                    </button>
                </td>
            </tr>
        </c:forEach>
    </tbody>

</table>
<button class="btn btn-sm btn-danger btn-clear-cart">Clear</button>
<button class="btn btn-sm btn-info">Continue</button>
<button class="btn btn-sm btn-success">Checkout</button>
