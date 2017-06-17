<%@ taglib prefix="c" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <c:url value="/resource/images" var="img"/>
<c:url value="/resource/css" var="css"/>
<c:url value="/resource/js" var="js"/>

<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="validator.js"></script>
<script src="contact.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <br><br>
  <center>${msg}</center>

	<div class="row">
	<div class="span12">
	<div class="well well-small">
		<h1>Check Out <small class="pull-right"> ${items} Items are in the cart </small></h1>
	<hr class="soften"/>	
<%@ include file="index.jsp" %>
	<table class="table table-bordered table-condensed">
              <thead>
                <tr>
                  <th>IMAGE</th>
                  <th>NAME</th>
				  <th>PRICE</th>
                  <th>Remove/Buy now</th>
                  <th>Total</th>	
				</tr>
              </thead>
              <tbody>
                 <c1:forEach items="${cartItems}" var="ci">
      <tr>
        <td><img src="<c:url value='/resource/images/${ci.getProduct().getP_id()}.jpg'/>",width=50px, height=20px></td>
        <td>${ci.getProduct().getP_name()}</td>
        <td>${ci.getProduct().getP_price()}</td>
<%--         <td>${pro.getProduct().getDes()}</td> --%>
        <td><a href="<c:url value='/Remove/${ci.getCartItems_id()}'/>" class="btn btn-info"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Remove</a>/<a href="<c:url value='/Buy/${ci.getProduct().getP_id()}/${ci.getCartItems_id()}'/>" class="btn btn-danger"><i class="fa fa-trash" aria-hidden="true"></i> Buy now</a>
        </td>
      </tr>
      </c1:forEach>
                </tbody>

  </table>
  <center>Total price=${gtotal}</center>
<center> <a href="<c:url value='/Removeall'/>" class="btn btn-info"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Remove All</a>/<a href="<c1:url value='/Buyall/${ci.getProduct().getP_id()}'/>" class="btn btn-danger"><i class="fa fa-trash" aria-hidden="true"></i> Buy All </a>
  </center></div>
				
</body>
</html>



