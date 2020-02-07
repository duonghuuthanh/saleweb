<%-- 
    Document   : detail
    Created on : Jan 22, 2020, 9:35:20 PM
    Author     : duonghuuthanh
--%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="product-big-title-area">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="product-bit-title text-center">
                    <h2 class="text-uppercase">${product.name}</h2>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-md-5">
            <div class="product-f-image">
                <img src="<spring:url value="${product.image}" />" alt="">
                <div class="product-hover">
                    <a href="#" class="add-to-cart-link"><i class="fa fa-shopping-cart"></i> Thêm vào giỏ</a>
                </div>
            </div>
        </div>
                
        <div class="col-md-7">
            
            <ul class="list-group">
                <li class="list-group-item">Giá: ${product.price} VNĐ</li>
                <li class="list-group-item">Nhà sản xuất: ${product.manufacturer}</li>
                <li class="list-group-item">Thông tin khác: ${product.description}</li>
            </ul>
            <div>
                <a href="javascript:;" onclick="addCart(${product.id})" 
                   class="btn btn-danger">
                    <i class="fa fa-shopping-cart"></i> 
                    Thêm vào giỏ
                </a>
            </div>
        </div>
    </div>
</div>
