<%@ taglib prefix="c" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core"%>
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
<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="validator.js"></script>
<script src="contact.js"></script>
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
</head>

<body>
<nav class="navbar">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span> 
      </button>
     <div class="navbar-header">
      <a class="navbar-brand" href="#"><img src="${img}/logo.png" alt="BasketMarketing" class="" style="max-height:25px;"/> </a>
    </div>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
	<c1:if test="${pageContext.request.userPrincipal.name!=null }">
	<security:authorize access="hasRole('ROLE_ADMIN')">
      <li class="active"><a href="<c:url value="/"/>">Home</a></li>
        <li><a href="<c:url value="/product"/>">Add Product</a></li>
		<li><a href="<c:url value="/supplier"/>">Supplier</a></li>
		<li><a href="<c:url value="/category"/>">Category</a></li>
		</security:authorize>
		</c1:if>
		<li><form class="navbar-form navbar-left">
      <div class="form-group">
        <input type="text" class="form-control" placeholder="Search">
      </div>
      <button type="submit" class="btn btn-default">Submit</button>
    </form>
	
    </li>
	
    </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="<c:url value="/all_Products"/>"> All Products </a> </li>
        <li><a href="<c:url value="/viewcart"/>"> View Cart </a> </li>
        <c1:if test="${pageContext.request.userPrincipal.name==null}">
        <li><a href="<c:url value="/signup"/>"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
        </c1:if>
        <c1:if test="${pageContext.request.userPrincipal.name==null}">
        <li><a href="<c:url value="/login"/>"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        </c1:if>
        <c1:if test="${pageContext.request.userPrincipal.name!=null}">
      <ul class="nav navbar-nav navbar-right">
      <li><a href="<c:url value="/j_spring_security_logout"/>"><span class="glyphicon glyphicon-user"></span> Logout</a></li>
        </ul>
        </c1:if>
      </ul>
    </div>
  </div>
</nav>
<div class="container"> 
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="${img}/1.jpg" alt="fruits" style="width:100%;">
      </div>

      <div class="item">
        <img src="${img}/2.jpg" alt="fruits" style="width:100%;">
      </div>
    
      <div class="item">
        <img src="${img}/3.jpg" alt="fruits" style="width:100%;">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>
  

</body>
</html>
