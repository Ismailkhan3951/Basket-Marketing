<%@ taglib prefix="c" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<c:url value="/resource/images" var="img"/>
<c:url value="/resource/css" var="css"/>
<c:url value="/resource/js" var="js"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Basket Marketing</title>
<link rel="stylesheet" href="${css}/bootstrap.min.css">
  <script src="${js}/jquery.min.js"></script>
  <script src="${js}/bootstrap.min.js"></script>
<link rel="icon" href="${img}/logo.png">

<style>
.navbar,
.navbar li
{
	  background-color:#C93;

}
table, th, td {
    border: 1px solid black;
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
    background-color: #333;
}
.navbar-nav li a{
	color:#FFF;
	font-weight:bold;
	}


<html xml:lang="en-gb" lang="en-gb"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<meta name="description" content="HTML  slider.  Responsive, mobile, full screen, retina-ready, touch-friendly. Remarkable CSS3 animations and designs. Non jQuery"><link rel="stylesheet" href="./HTML Slideshow - Fancy CSS-only slideshow_files/styles.min.css" type="text/css">
<style type="text/css">
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
			<center><h3>Supplier Form</h3></center>
			<c:url value="/Add_Supplier" var="s"/>
			<form:form action="${s}" method="POST" commandName="supplier" class="container" style="width:40%">
				<div class="form-group">
					<label for="S_id">Supplier ID:</label>
					<form:input type="text" class="form-control" path="S_id" placeholder="Enter Supplier ID number"/>
				</div>
				<div class="form-group">
					<label for="name">Name:</label>
					<form:input type="text" class="form-control" path="S_name" placeholder="Enter the Supplier name"/>
				</div>
				<div class="form-group">
					<label for="add">Location:</label>
					<form:input type="text" class="form-control" path="S_location" placeholder="Enter the location"/>
				</div>
				<div class="form-group">
					<label for="mob">Phone no:</label>
					<form:input type="text" class="form-control" path="Ph_no" placeholder="Enter Phone number"/>
				</div>
				
					<!--Code for button.-->
<!-- 					<a href="submit.html" data-toggle="tooltip" title="prace to Success"><button type="button"  -->
<!-- 					class="btn btn-primary" value="save">Submit</button></a> -->
					<input type="submit" class="btn btn-primary" value="save"/>
 				</form:form> 
				</div>
				<center>
<table>
  <tr>
    <th >Id</th>
    <th >Name</th> 
    <th >Location</th>
	<th >Ph_no</th> 
	<th >Edit/Delete</th> 
	 	
  </tr>
  <c1:forEach items="${suppliers}" var="S">
   <tr>
    <td>${S.getS_id()}</td>
    <td>${S.getS_name()}</td>
    <td>${S.getS_location()}</td>
    <td>${S.getPh_no()}</td>
     
   
	<td>
	  <a href="<c:url value="/edit_Supplier/${S.getS_id()}"/>" class="btn btn-primary">Edit</a>
	  <a href="<c:url value="/delete_Supplier/${S.getS_id()}"/>"  class="btn btn-primary">Delete</a>
	</td>
  </tr>
  </c1:forEach>
  
</table>
</center>
</html>				
		
	