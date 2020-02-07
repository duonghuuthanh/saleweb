<%-- 
    Document   : header
    Created on : Jan 22, 2020, 9:01:17 PM
    Author     : duonghuuthanh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="header-area">
    <div class="container">
        <div class="row">
            <div class="col-md-7">
                <div class="user-menu">
                    <ul>
                        <c:choose>
                            <c:when test="${pageContext.request.userPrincipal.name == null}">
                               <li>
                                    <a href="<spring:url value="/register" />">
                                        <i class="fa fa-check"></i> 
                                        <spring:message code="message.register" />
                                    </a>
                                </li>
                                <li>
                                    <a href="<spring:url value="/login" />">
                                        <i class="fa fa-user"></i> 
                                        <spring:message code="message.login" />
                                    </a>
                                </li> 
                            </c:when>
                            <c:when test="${pageContext.request.userPrincipal.name != null}">
                                <li>
                                    <a href="#"><i class="fa fa-user"></i>
                                        <spring:message code="message.welcome" /> 
                                        ${pageContext.request.userPrincipal.name}
                                    </a>
                                </li>
                                <li>
                                    <a href="<spring:url value="/logout" />">
                                        <i class="fa fa-sign-out"></i>
                                        <spring:message code="message.logout" />
                                    </a>
                                </li>
                            </c:when>
                        </c:choose>
                    </ul>
                </div>
            </div>
            <div class="col-md-5">
                <form action="<spring:url value="/" />">
                    <div class="row">
                        <div class="col-md-12 form-group">
                            <input name="kw" value="${kw}" class="form-control" 
                                   placeholder="Nhập từ khoá tìm kiếm..." />
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>        
</div> 

<div class="site-branding-area">
    <div class="container">
        <div class="row">
            <div class="col-sm-3">
                <div class="logo">
                    <h1><a href="<spring:url value="/" />"><img src="<spring:url value="/images/logo.png" />"></a></h1>
                </div>
            </div>
            <div class="col-sm-6">
                <h1 class="text-center"></h1>
            </div>
            <div class="col-sm-3">
                <div class="shopping-item">
                    <a href="<spring:url value="/cart" />">Giỏ hàng <span class="cart-amunt"></span> <i class="fa fa-shopping-cart"></i> 
                        <span class="product-count">${cartCount}</span>
                    </a>
                </div>
            </div>
        </div>
    </div>
</div> 