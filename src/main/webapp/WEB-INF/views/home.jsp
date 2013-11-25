<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	swagger4spring-web example!
</h1>

<p>
    <a href="<c:url value="/documentation/"/>">View API documentation</a>
</p>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
