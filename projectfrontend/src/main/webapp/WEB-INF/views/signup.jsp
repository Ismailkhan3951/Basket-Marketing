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
<link rel="icon" href="${img}/logo.png">
<link rel="stylesheet" href="${css}/bootstrap.min.css">
  <script src="${js}/jquery.min.js"></script>
  <script src="${js}/bootstrap.min.js"></script>

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

<body>

<div class="container">
  <h3>Sign up on basketmarketing</h3>
 
      <div class="modal-content">
     
        </div>
        <div class="modal-body" style="padding:40px 50px;">
         <c:url value="/Add_User" var="us"/>
         <form:form action="${us}" method="POST" commandName="user" role="form">
         <div class="form-group">
              <label>Id</label>                             
              <form:input type="text" class="form-control" path="User_id" placeholder="UserId"/>						
            </div>
		   <div class="form-group">
              <label>Name</label>                             
              <form:input type="text" class="form-control" path="Name" placeholder="First name |Lastname"/>						
            </div>																																
            <div class="form-group">																								
              <label > E-mail</label>									
              <form:input type="text" class="form-control" path="email_id" placeholder="Enter Your E-mail"/>										
            </div>
            <div class="form-group">																								
              <label > Location</label>									
              <form:input type="text" class="form-control" path="location" placeholder="Enter Your Loation"/>										
            </div>
            <div class="form-group">																								
              <label >City</label>									
              <form:input type="text" class="form-control" path="city" placeholder="Enter Your City"/>										
            </div>
            <div class="form-group">																								
              <label >Country</label>									
              <form:input type="text" class="form-control" path="country" placeholder="Enter Your Countyr"/>										
            </div>
            <div class="form-group">
              <label> Password</label>                             
              <form:input type="password" class="form-control" path="Password" placeholder="Enter Your Password"/>						
            </div>	
			 <div class="form-group">
              <label>Re-Enter Password</label>                             
              <input type="password" class="form-control" placeholder="Re-Enter Your Password">						
            </div>	
            <div class="form-group">
              <label> Phone Number</label>                             
              <form:input type="text" class="form-control" path="Ph_no" placeholder="Enter Your Phone number"/>						
            </div>
           
              <button  value="save" type="login" class="btn  btn-primary"><span class="icon icon-navigating-right">
              </span>SIGNUP</button>
<!-- 			<input type="submit" value="save"/> -->
          </form:form>
        

          <p>alredy a member? <a href="login.html">Login</a></p>
          
        
      </div>
      
    </div>
  </div> 
</div>
 

</body>
</html>
