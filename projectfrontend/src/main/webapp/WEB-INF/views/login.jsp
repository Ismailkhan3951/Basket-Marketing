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
<title>BasketMarketing</title>
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
  <h3>Login To Your Account</h3>
  <!-- Trigger the modal with a button -->
 <!-- <button type="button" class="btn btn-default btn-lg" id="myBtn">Login</button>-->

  <!-- Modal -->
 <!-- <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">-->
    
      <!-- Modal content-->
      <div class="modal-content">
       <!-- <div class="modal-header" style="padding:35px 50px;">-->
        <!--  <button type="button" class="close"data-dismiss="modal">&times;</button>
          <h4><span class="glyphicon glyphicon-lock"></span> Login</h4>-->
        </div>
        <div class="modal-body" style="padding:40px 50px;">
        <c1:url value="/j_spring_security_check" var="a"/>
        
          <form:form role="form" action="${a}" method="post">
            <div class="form-group">
              <label for="usrname"><span class="glyphicon glyphicon-user"></span> Username</label>                             
              <input type="text" class="form-control" id="usrname" name="j_username" placeholder="Enter Your Registered E-mail">						
            </div>																																
            <div class="form-group">																								
              <label for="psw"><span class="glyphicon glyphicon-eye-open"></span> Password</label>									
              <input type="password" class="form-control" id="psw" name="j_password" placeholder="Enter Your Password">										
            </div>
            <div class="checkbox">
              <label><input type="checkbox" value="" checked>Remember me</label>
            </div>
              <button type="login" class="btn btn-primary"><span class="icon icon-navigating-right"></span>LOGIN</button>
          </form:form>
        
       <!-- <div class="modal-footer"> -->
         <!-- <button type="submit" class="btn btn-primary pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>-->
          <p>new to BasketMarketing? <a href="signup.html">Sign Up</a></p>
          <p><a href="#">Forgot Password?</a></p>
        
      </div>
      
    </div>
  </div> 
</div>
 
<!--<script>
$(document).ready(function(){
    $("#myBtn").click(function(){
        $("#myModal").modal();
    });
});
</script>-->

</body>
</html>
