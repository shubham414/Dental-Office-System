<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<style><%@include file="/WEB-INF/dentistliststyle.css"%></style>
	<title>SAS Dental Clinic</title>
</head>
<body>
<header>
<img src="<c:url value='C:\DMDDProject\apache-tomcat-8.5.47\webapps\ROOT\DMDDImage.png'/>">
</header>
	<center>
		<h1>DENTIST INFORMATION</h1>
        <h2>
            &nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;
            <a href="home">HOME</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="newark">Add New Dentist</a>
        	&nbsp;&nbsp;&nbsp;
        	
        </h2>
	</center>
    <div align="center">
    <fieldset>
        <table border="1" cellpadding="5">
            <caption><h2>List of Users</h2></caption>
            <tr>
                <th>Dentist's ID</th>
                <th>Dentist's First Name</th>
                <th>Dentist's Last Name</th>
                <th>Dentist's Email</th>
                <th>Dentist's Contact</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="dentist" items="${listDentist}">
                <tr>
                    <td><legend><c:out value="${dentist.id}" /></legend></td>
                    <td><legend><c:out value="${dentist.firstName}" /></legend></td>
                    <td><legend><c:out value="${dentist.lastName}" /></legend></td>
                    <td><legend><c:out value="${dentist.email}" /></legend></td>
                    <td><legend><c:out value="${dentist.contact}" /></legend></td>
                    <td>
                    	<a href="edit?id=<c:out value='${dentist.id}' />">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="delete?id=<c:out value='${dentist.id}' />">Delete</a>     
                    	&nbsp;&nbsp;&nbsp;&nbsp;               	
                    </td>
                </tr>
            </c:forEach>
            </fieldset>
        </table>
    </div>	
</body>
</html>
