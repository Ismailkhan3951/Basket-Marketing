<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<c:url value="/resource/images" var="img"/>
</head>
<body>
<img src="${img}/p1.jpg" alt="FRUITS Icon" style="width:328px;height:228px;">
<button type="button" class="btn btn-warning">Add To Cart</button>
</body>
</html>