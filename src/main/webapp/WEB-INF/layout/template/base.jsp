<%-- 
    Document   : base
    Created on : Jan 22, 2020, 3:36:59 PM
    Author     : duonghuuthanh
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><tiles:insertAttribute name="title" /></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="<spring:url value="/css/style.css" />">
    <link rel="stylesheet" href="<spring:url value="/css/responsive.css" />">
  </head>
  <body>
   
    <tiles:insertAttribute name="header" />
    
    <tiles:insertAttribute name="content" />
    
    <tiles:insertAttribute name="footer" />
   
    <script src="https://code.jquery.com/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <script src="<spring:url value="/js/jquery.sticky.js" />"></script>
    <script src="<spring:url value="/js/jquery.easing.1.3.min.js" />"></script>
    <script src="<spring:url value="/js/main.js" />"></script>
    <script src="<spring:url value="/js/cart.js" />"></script>
  </body>
</html>
