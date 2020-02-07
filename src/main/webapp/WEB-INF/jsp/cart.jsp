<%-- 
    Document   : cart
    Created on : Feb 3, 2020, 2:36:25 PM
    Author     : duonghuuthanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<div class="product-big-title-area">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="product-bit-title text-center">
                    <h2 class="text-uppercase">GIỎ HÀNG</h2>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="container">
    <h2 class="text-center">CÁC SẢN PHẨM ĐÃ CHỌN</h2>
    <table class="table table-bordered seleted-products">
        <tr>
            <th>Mã sản phẩm</th>
            <th>Tên sản phẩm</th>
            <th>Đơn giá</th>
            <th>Số lượng</th>
        </tr>
        <c:forEach items="${carts}" var="cart">
        <tr>
            <td>${cart.product.id}</td>
            <td>${cart.product.name}</td>
            <td><fmt:formatNumber type="number" maxFractionDigits="3" 
                              value="${cart.product.price}" />  VNĐ</td>
            <td>${cart.num}</td>
        </tr>
        </c:forEach>
        <tr>
            <td colspan="2" class="text-right">Tổng cộng</td>
            <td colspan="2"><fmt:formatNumber type="number" maxFractionDigits="3" 
                              value="${sum}" /> VNĐ</td>
        </tr>
    </table>
    <div class="pull-right">
        <input type="button" class="btn btn-danger" onclick="pay()"
               value="<spring:message code="cart.pay" />" />
    </div>
</div>
<script>
function pay() {
    if (confirm("Bạn muốn thanh toán?")) {
        $.ajax({
            url: "/saleweb/api/cart/pay",
            type: "POST",
            success: function (data, textStatus, jqXHR) {
                if (data === "")
                    $(".seleted-products").hide("slow");
                else
                    alert("Vui lòng đăng nhập để thanh toán!!!");
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert("Đã có lỗi khi thanh toán!!!");
            }
        });
    }
}
</script>
    
