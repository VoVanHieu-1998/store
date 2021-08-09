
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jstl/fmt_rt" %>
<jsp:useBean id="myUtils" class="com.store.utils.MyUtils"/>
<div class="row">
    <div class="col-sm-5 text-center">
        <img class="detail-img"  src="<c:url value='/resources/${product.getImageArr()[0]}'/>" alt="">
    </div>
    <div class="col-sm-7">
        <ul class="detail-info">
            <li>${product.name}</li>
            <li><strong id="price" value-price="${item.price}"
                        class="d-inline-block mb-2 price"
                        style="font-size: 20px; color: #5A88C9">${myUtils.convertToVndCurrency(product.price)}
            </strong></li>
            <li><f:formatNumber value="${product.giamgia}" type="percent"/> </li>
        </ul>
    </div>

</div>
<hr/>
<%--Thông số--%>
<div class="panel-group" id="accordion">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h4 class="panel-title text-center">
                <a data-toggle="collapse" data-parent="#accordion" href="#collapseTS">
                    Thông số kỹ thuật</a>
            </h4>
        </div>
        <div id="collapseTS" class="panel-collapse collapse in">
            <div class="panel-body">
                <table class="table table-borderless">
                    <c:forEach var="specdetail" items="${spec.specDetails}">

                        <tr>
                            <td>${specdetail.name} :</td>
                            <td>${specdetail.value}</td>
                        </tr>

                    </c:forEach>

                </table>
            </div>
        </div>
    </div>
</div>
<hr/>
<%--Cùng loại--%>
<div class="panel-group" id="accordion">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h4 class="panel-title text-center">
                <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">
                    HÀNG CÙNG LOẠI</a>
            </h4>
        </div>
        <div id="collapse1" class="panel-collapse collapse in">
            <div class="panel-body">
                <table class="table table-borderless">
                    <c:forEach var="c" items="${productSet}">
                        <div class="col-md-4">
                            <div class="thumbnail">
                                <a href="/product/detail/${c.productId}">
                                    <img class="img-product" src='<c:url value="/resources/${c.getImageArr()[0]}" /> ' alt="Lights">
                                </a>
                                <div class="caption">
                                    <p>${c.name}</p>
                                </div>


                            </div>
                        </div>
                    </c:forEach>

                </table>
            </div>
        </div>
    </div>
</div>
<hr/>
<%--Yêu thích--%>
<div class="panel-group" id="accordion">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h4 class="panel-title text-center">
                <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">
                    HÀNG YÊU THÍCH</a>
            </h4>
        </div>
        <div id="collapse2" class="panel-collapse collapse in">
            <div class="panel-body">
                <table class="table table-borderless">
                    <c:forEach var="c" items="${favo}">
                        <div class="col-md-4">
                            <div class="thumbnail">
                                <a href="/product/detail/${c.productId}">
                                    <img class="img-product" src='<c:url value="/resources/${c.getImageArr()[0]}" /> ' alt="Lights">
                                </a>
                                <div class="caption">
                                    <p>${c.name}</p>
                                </div>


                            </div>
                        </div>
                    </c:forEach>

                </table>
            </div>
        </div>
    </div>
</div>
<hr/>
<%--Đã xem--%>
<div class="panel-group" id="accordion">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h4 class="panel-title text-center">
                <a data-toggle="collapse" data-parent="#accordion" href="#collapse3">
                    HÀNG ĐÃ XEM</a>
            </h4>
        </div>
        <div id="collapse3" class="panel-collapse collapse in">
            <div class="panel-body">
                <table class="table table-borderless">
                    <c:forEach var="c" items="${views}">
                        <div class="col-md-4">
                            <div class="thumbnail">
                                <a href="/product/detail/${c.productId}">
                                    <img class="img-product" src='<c:url value="/resources/${c.getImageArr()[0]}" /> ' alt="Lights">
                                </a>
                                <div class="caption">
                                    <p>${c.name}</p>
                                </div>


                            </div>
                        </div>
                    </c:forEach>

                </table>
            </div>
        </div>
    </div>
</div>