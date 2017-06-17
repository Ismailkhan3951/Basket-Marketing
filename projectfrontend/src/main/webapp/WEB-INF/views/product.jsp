<%@ taglib prefix="c" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core"%>


<html xml:lang="en-gb"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<meta name="description" content="HTML  slider.  Responsive, mobile, full screen, retina-ready, touch-friendly. Remarkable CSS3 animations and designs. Non jQuery"><link rel="stylesheet" href="./HTML Slideshow - Fancy CSS-only slideshow_files/styles.min.css" type="text/css">


<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Basket Marketing</title>
<link rel="icon" href="${img}/logo.png">

<link rel="stylesheet" href="${css}/bootstrap.min.css">
  <script src="${js}/jquery.min.js"></script>
  <script src="${js}/bootstrap.min.js"></script>
  
<c:url value="/resource/images" var="img"/>
<c:url value="/resource/css" var="css"/>
<c:url value="/resource/js" var="js"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.navbar,
.navbar li
{
	  background-color:#C93;

}
table, th, td {
    border: 1px solid black;
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
    background-color: #333;
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
<%@ include file="index.jsp" %>
<div class="container">
			<center><h3>Product Form</h3></center>
			<c:url value="/Add_Product" var="p"/>
			<form:form action="${p}" method="POST" commandName="product" enctype="multipart/form-data" class="container" style="width:40%">
				<div class="form-group">
					<label for="name">Product ID:</label>
					<form:input type="text" class="form-control" path="P_id" placeholder="Enter product ID "/>
				</div>
				<div class="form-group">
					<label for="name">Name:</label>
					<form:input type="text" class="form-control" path="P_name" placeholder="Enter the product name"/>
				</div>
				<div class="form-group">
					<label for="add">Price:</label>
					<form:input type="number" class="form-control" path="P_price" placeholder="Enter the product cost"/>
				</div>
				<div class="form-group">
					<label for="mob">Quantity:</label>
					<form:input type="number" class="form-control" path="P_quantity" placeholder="Enter the number of products"/>
				</div>
				<div class="form-group">
					<label for="email">Description:</label>
					<form:input type="text" class="form-control" path="P_description" placeholder="Describe about product"/>
				</div>
				<div>
				<label for="category">Category</label></td>
<%-- 				<form:options items="${categories}" /> --%>
						<form:select path="category.Cat_id" multiple="false">
						<c1:forEach var="c" items="${categories}">
							<form:option value="${c.getCat_id()}"  label ="${c.getCat_name()}" /> 
						</c1:forEach>
						</form:select>
						
						<label for="supplier">Supplier</label></td>
<%-- 				<form:options items="${categories}" /> --%>
						<form:select path="supplier.S_id" multiple="false">
						<c1:forEach var="s" items="${suppliers}">
							<form:option value="${s.getS_id()}"  label ="${s.getS_name()}" /> 
						</c1:forEach>
						</form:select>
				</div>
<!-- 				<div class="form-group"> -->
<!-- 					<label for="pass">Supplier ID:</label> -->
<%-- 					<form:input type="password" class="form-control" path="S_id" placeholder="Enter the Supplier ID"/> --%>
<!-- 				</div> -->
<!-- 				<div class="form-group"> -->
<!-- 					<label for="pass">Category ID:</label> -->
<%-- 					<form:input type="password" class="form-control" path="cat_id" placeholder="Enter the Category ID"/> --%>
<!-- 				</div> -->
<!-- 					Code for button. -->
					
<!-- 			<a href="#" data-toggle="tooltip" title="prace to Success"> -->
<!-- 			<button type="submit" class="btn btn-primary" value="save">Submit</button></a> -->
			
				<form:input path="pimg" type="file" name="pimg" value="upload file"/>
			
					<input type="submit" class="btn btn-primary" value="save"/>
				</form:form>
					<center>
		<table style:width="100%">
  <tr>
    <th>ProductId</th>
    <th>Name</th> 
	<th>price</th> 
	<th>quantity</th>
	<th>description</th>
	<th>image</th>
	<th>Edit/Delete</th>
  </tr>
  <c1:forEach items="${products}" var="P">
   <tr>
    <td>${P.getP_id()}</td>
    <td>${P.getP_name()}</td> 
    <td>${P.getP_price()}</td>
    <td>${P.getP_quantity()}</td>
    <td>${P.getP_description()}</td>
    <td>
    <img src="${img}/${P.getP_id()}.jpg",width=5px,height=20px" >
    </td>
    
	<td>	
	  <a href="<c:url value="/edit_Product/${P.getP_id()}"/>" class="btn btn-primary">Edit</a>
	  <a href="<c:url value="/delete_Product/${P.getP_id()}"/>"  class="btn btn-primary" >Delete</a>
	</td>
  </tr>
  </c1:forEach>
</table></center>
		</div>
</html>		