
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<jsp:useBean id="myUtils" class="com.store.utils.MyUtils"/>
<c:forEach var="c" items="${productSet}">
    <div class="col-md-4">
        <div class="thumbnail">
            <a href="/product/detail/${c.productId}">
                <img class="img-product" src='<c:url value="/resources/${c.getImageArr()[0]}" /> ' alt="Lights">
            </a>
            <div class="caption" >
                    <p>${c.name}</p>

                <div class="pull-right" data-id =${c.productId}>
                    <button class="btn btn-sm btn-danger btn-cart">
                        <i class="glyphicon glyphicon-shopping-cart"></i>
                    </button>
                    <button class="btn btn-sm btn-warning btn-star">
                        <i class="glyphicon glyphicon-star"></i>
                    </button>
                    <button class="btn btn-sm btn-success btn-open-dialog" data-toggle="modal" data-target="#myModal">
                        <i class="glyphicon glyphicon-envelope"></i>
                    </button>
                </div>
                <p>${myUtils.convertToVndCurrency(c.price)}</p>
            </div>


        </div>
    </div>
</c:forEach>
<jsp:include page="dialog.jsp"/>