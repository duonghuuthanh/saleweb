<%-- 
    Document   : index
    Created on : Jan 14, 2020, 9:23:42 PM
    Author     : duonghuuthanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="mainmenu-area">
    <div class="container">
        <div class="row">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div> 
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">Trang chủ</a></li>
                    <c:forEach items="${categories}" var="category">
                    <li><a href="<spring:url value="/?cat_id=${category.id}" />">${category.name}</a></li>
                    </c:forEach>
                    <li><a href="#">Liên hệ</a></li>
                </ul>
            </div>  
        </div>
    </div>
</div> 

<div class="container">
    <h2 class="section-title">Danh sách sản phẩm</h2>
    <div class="row">
        <c:forEach items="${products}" var="product">
            <div class="col-md-3 single-product">
                <div class="product-f-image">
                    <img src="<spring:url value="${product.image}" />" alt="">
                    <div class="product-hover">
                        <a href="javascript:;" onclick="addCart(${product.id})" class="add-to-cart-link"><i class="fa fa-shopping-cart"></i> Thêm vào giỏ</a>
                        <a href="<spring:url value="/products/${product.id}" />" class="view-details-link"><i class="fa fa-link"></i> Xem chi tiết</a>
                    </div>
                </div>

                <h2><a href="#">${product.name}</a></h2>

                <div class="product-carousel-price">
                    <ins>${product.price} VNĐ</ins> 
                </div> 
            </div>
        </c:forEach>
    </div>
</div>
<script>
function addCart(productId, productName) {
    $.ajax({
        url: "/saleweb/api/cart",
        type: "POST",
        data: {
            productId: productId,
            num: 1
        },
        success: function (data) {
            var a = $(".product-count").text();
            a = a === "" ? 0:parseInt(a);
            $(".product-count").text(a + 1);
        },
        error: function (jqXHR) {
            alert(jqXHR);
        }
    });
}
</script>

