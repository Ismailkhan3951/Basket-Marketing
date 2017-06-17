<%@ taglib prefix="c" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<c:url value="/resource/images" var="img"/>
<c:url value="/resource/css" var="css"/>
<c:url value="/resource/js" var="js"/>


<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Basket Marketing</title>
<link rel="icon" href="${img}/logo.png">
<link rel="stylesheet" href="${css}/bootstrap.min.css">
<link rel="stylesheet" href="${css}/styles.min.css" type="text/css">

  <script src="${js}/jquery.min.js"></script>
  <script src="${js}/bootstrap.min.js"></script>
<link rel="stylehseet" href="${css}/Patanjali_style.css">

<style>
.navbar,
.navbar li
{
	  background-color:#C93;

}
.navbar-inverse .navbar-nav>.active>a, .navbar-inverse .navbar-nav>.active>a:focus
{
    background-color:#C93;

}
img.round{
border-radius:50%
}
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    
}
.navbar-nav li a{
	color:#FFF;
	font-weight:bold;
	}



#rt-showcase.slider-container { background: #F5F6F8; }
.slider-container {
    padding-top: 20px;
}
.slider-container .csslider1 {
    position: relative;
    display: block;
    margin: 0 auto !important;
}
body,html
{
  background-color:white;
}
</style>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>


<%@ include file="index.jsp" %>

  <body>
  
  <br>
  <br>
  <div>
  <c1:forEach var="pro" items="${products}">
  <a class="zoomTool" href="<c:url value="/addtocart/${pro.getP_id()} "/>" title="add to cart"><span class="icon-shopping-cart"></span></a>
	<a href="#" class="tag"></a>
	<a href="<c:url value="/viewpro/${pro.getP_id() }"/>" title="quick view">
<br>
	<img src="${img }/${pro.getP_id() }.jpg" alt="bootstrap-ring"></a>
	<h3>${pro.getP_name() }  &nbsp; &nbsp; &nbsp; ${pro.getP_price() }</h3>
	<div>
	<a style="color:#b38008" href="<c:url value="/addtocart/${pro.getP_id()}"/>">
	<button type="button">
	<i class="fa fa-shopping-cart"></i>
	</button>
	</a>
	</div>
	</c1:forEach>
	</div>
	</body>
	