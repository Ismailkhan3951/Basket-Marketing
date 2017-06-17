<%@ taglib prefix="c" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <c:url value="/resource/images" var="img"/>
<c:url value="/resource/css" var="css"/>
<c:url value="/resource/js" var="js"/>

<%--  <%@ include file= "header.jsp"%>  --%>
<%--  <%@ include file= "nav.jsp"%> --%>
<!--
Lower Header Section 
--><body >


<!--
Navigation Bar Section 
-->

			
		
<!-- 
Body Section 
-->
			

	<%@ include file="index.jsp" %>
	
	<div class="span11">

	<div class="col-md-12  col-sm-12  col-xs-8 "
	style="background: #fff; padding: 30px;">

	<div class="col-md-6 col-sm-6 col-xs-12">
		<h3 class="text-center">Billing Address</h3>

		<hr>
			<div class="col-xs-6 col-sm-6 col-md-6">
			<div class="form-group">
				<form:input type="text" path="user.email_id"  class="form-control input-sm"					
				placeholder="Emailid" disabled="true"/> 
			</div>
		</div>
		<div class="col-xs-6 col-sm-6 col-md-6">
			<div class="form-group">
				<form:input type="number" name="mono" path="user.Ph_no" disabled="true"
			class="form-control input-sm" placeholder="Mobile no"/>
			</div>
		</div>
		

		<div class="col-xs-12 col-sm-12 col-md-12">
			<div class="form-group">
				<form:input class="form-control" path="user.location" disabled="true"
					placeholder="House name and number"/>                                                
                                            
			</div>
		</div>

		<div class="col-xs-12 col-sm-4 col-md-4">
			<div class="form-group">
				<form:input type="text" name="country" disabled="true"
			class="form-control input-sm" placeholder="country" path="user.country" /> 
			</div>
		</div>
		<div class="col-xs-12 col-sm-4 col-md-4">
			<div class="form-group">
				<form:input type="text" name="city" disabled="true"
 					class="form-control input-sm" placeholder="city" path="user.city"/> 
			</div>
<!-- 		</div> -->
<!-- 		<div class="col-xs-12 col-sm-4 col-md-4"> -->
<!-- 			<div class="form-group"> -->
<%-- 				<form:input type="text" name="pincode" disabled="true" --%>
<%-- 					class="form-control input-sm" placeholder="pincode" path="billingAddress.Pincode" /> --%>
<!-- 			</div> -->
<!-- 		</div> -->
		<input class="coupon_question" type="checkbox" name="coupon_question"
			value="1"> <span class="item-text">Check Shipping
			address</span>
	</div>


	<div class="col-md-6 shipping col-sm-6 col-xs-12">
		<h3 class="text-center">shipping Address</h3>

		<hr>
	<c:url value="/orderConfirm" var="a"/>
		<form:form action="${a}" method="post" commandName="shipingAddress">
		
	
<!-- 		<div class="col-xs-6 col-sm-6 col-md-6"> -->
<!-- 			<div class="form-group"> -->
<%-- 				<form:input type="text"  id="first_name" --%>
<%-- 					class="form-control input-sm" placeholder="First Name" path="Ship_name"/> --%>
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 		<div class="col-xs-6 col-sm-6 col-md-6"> -->
<!-- 			<div class="form-group"> -->
<%-- 				<form:input type="text" name="last_name" id="last_name" --%>
<%-- 					class="form-control input-sm" placeholder="Last Name" path="lastname"/> --%>
<!-- 			</div> -->
<!-- 		</div> -->

<!-- 		<div class="col-xs-6 col-sm-6 col-md-6"> -->
<!-- 			<div class="form-group"> -->
<%-- 				<form:input type="text" name="first_name" id="first_name" --%>
<%-- 					class="form-control input-sm" placeholder="Email id" path="email"/> --%>
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 		<div class="col-xs-6 col-sm-6 col-md-6"> -->
<!-- 			<div class="form-group"> -->
<%-- 				<form:input type="text" name="Mobile_no"  --%>
<%-- 					class="form-control input-sm" placeholder="Mobile no" path="mono"/> --%>
<!-- 			</div> -->
<!-- 		</div> -->

		<div class="col-xs-12 col-sm-12 col-md-12">
			<div class="form-group">
				<form:input type="text" class="form-control" path="Ship_houseno"/>                                                
                                           
			</div>
		</div>

		<div class="col-xs-12 col-sm-4 col-md-4">
			<div class="form-group">
				<form:input type="text"
					class="form-control input-sm" placeholder="country" path="Ship_country"/>
			</div>
		</div>
		<div class="col-xs-12 col-sm-4 col-md-4">
			<div class="form-group">
				<form:input type="text" 
					class="form-control input-sm" placeholder="city" path="Ship_city"/>
			</div>
		</div>
		<div class="col-xs-12 col-sm-4 col-md-4">
			<div class="form-group">
				<form:input type="text"
					class="form-control input-sm" placeholder="pincode" path="Ship_pincode" />
			</div>
		</div>
	</div>
	<div class="col-md-12">
		<input type="submit" class="btn btn-primary pull-right" value="Continue">
	</div>
   </form:form>
</div>
</div></div>
<!--
Footer
-->

<!-- /container -->

<div class="copyright">
<div class="container">
	
	<span>Copyright &copy; 2013<br> bootstrap ecommerce shopping template</span>
</div>
</div>
<a href="#" class="gotop"><i class="icon-double-angle-up"></i></a>
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="assets/js/jquery.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="assets/js/jquery.easing-1.3.min.js"></script>
    <script src="assets/js/jquery.scrollTo-1.4.3.1-min.js"></script>
    <script src="assets/js/shop.js"></script>
  </body>
</html>
