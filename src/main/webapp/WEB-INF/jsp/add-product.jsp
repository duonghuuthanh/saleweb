<%-- 
    Document   : add-product
    Created on : Jan 23, 2020, 4:03:00 PM
    Author     : duonghuuthanh
--%>


<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
    <h1 class="text-center text-uppercase">
        <spring:message code="product.submit" />
    </h1>
    <spring:url value="/products/add" var="action" />
    <form:form action="${action}" modelAttribute="product" 
               method="post" enctype="multipart/form-data" >
        <form:errors path="*" cssClass="alert alert-danger" element="div" />
        
        <div class="form-group">
            <label for="categoryId">
                <spring:message code="product.category" />
            </label>
            <form:select path="category" cssClass="form-control">
                <form:options items="${categories}"  
                              itemLabel="name" 
                              itemValue="id" />
            </form:select>
            <form:errors path="category" cssClass="text-danger" />
        </div>
        <div class="form-group">
            <label for="nameId">
                <spring:message code="product.name" />
            </label>
            <form:input id="nameId" path="name" 
                        cssClass="form-control" />
            <form:errors path="name" cssClass="text-danger" />
        </div>
        <div class="form-group">
            <label for="priceId">
                <spring:message code="product.price" />
            </label>
            <form:input id="priceId" path="price" 
                        cssClass="form-control" />
            <form:errors path="price" cssClass="text-danger" />
        </div>
        <div class="form-group">
            <label for="manufacturerId">
                <spring:message code="product.manufacturer" />
            </label>
            <form:input id="manufacturerId" path="manufacturer" 
                        cssClass="form-control" />
            <form:errors path="manufacturer" cssClass="text-danger" />
        </div>
        <div class="form-group">
            <label for="descriptionId">
                <spring:message code="product.description" />
            </label>
            <form:textarea id="descriptionId" path="description" 
                           cssClass="form-control" />
            <form:errors path="description" cssClass="text-danger" />
        </div>
        <div class="form-group">
            <label for="imgId">
                <spring:message code="product.image" />
            </label>
            <form:input type="file" id="imgId" path="imgFile" 
                        cssClass="form-control" />
            <form:errors path="image" cssClass="text-danger" />
        </div>
        <div class="form-group">
            <form:button class="pull-right">
                <spring:message code="product.submit" />
            </form:button>
        </div>
    </form:form>
</div>
