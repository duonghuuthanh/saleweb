<%-- 
    Document   : login
    Created on : Jan 23, 2020, 3:39:24 PM
    Author     : duonghuuthanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
    <h1 class="text-center text-uppercase">
        <spring:message code="user.login" />
    </h1>
    <c:if test="${param.error != null}">
    <div class="alert alert-danger">
        <p><spring:message code="user.login.error1" /></p>
    </div>    
    </c:if>
    <c:if test="${param.accessDenied != null}">
    <div class="alert alert-danger">
        <p><spring:message code="user.login.error2" /></p>
    </div>    
    </c:if>
    <spring:url value="/login" var="action" />
    <form action="${action}" method="post" >
        <div class="form-group">
            <label for="usernameId">
                <spring:message code="user.username" />
            </label>
            <input name="username" id="usernameId" class="form-control" />
        </div>
        <div class="form-group">
            <label for="passwordId">
                <spring:message code="user.password" />
            </label>
            <input id="passwordId" name="password" 
                   class="form-control" type="password" />
        </div>
        <div class="form-group">
            <button class="pull-right" type="submit">
                <spring:message code="user.login" />
            </button>
        </div>
    </form>
</div>
