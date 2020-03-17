<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<%-- <link href="/WEB-INF/style.css" rel="stylesheet" type="text/css" /> --%>
	<style><%@include file="/WEB-INF/style.css"%></style>
	<title>ADMINISTRATION CONTROL PANEL</title>
</head>
<body>
<header>
<img src="<c:url value='C:\DMDDProject\apache-tomcat-8.5.47\webapps\ROOT\DMDDImage.png'/>"> 


</header>
	<center>
		<h1>ADMIN Control Panel</h1>
        <h2>
        	<a href="list">DENTISTS </a>
        	&nbsp;&nbsp;&nbsp;
        	<br>
        	<a href="listspecs">SPECIALIZATION </a>
        	&nbsp;&nbsp;&nbsp;
        	<br>
        	<a href="showinvoiceform">GENERATE INVOICE </a>
        	&nbsp;&nbsp;&nbsp;
        	<br>
           
            
        	
        </h2>
	</center>
   	
</body>
</html>
