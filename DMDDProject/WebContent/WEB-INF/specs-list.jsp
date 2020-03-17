<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<style><%@include file="/WEB-INF/specsliststyle.css"%></style>
	<title>SAS Dental Clinic</title>
</head>
<body>
<header>
<img src="<c:url value='C:\DMDDProject\apache-tomcat-8.5.47\webapps\ROOT\DMDDImage.png'/>">
</header>
	<center>
		<h1>SPECIALIZATION INFORMATION</h1>
        <h2>
            &nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;
            <a href="home">HOME</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="newspec">Add New Specialization</a>
        	&nbsp;&nbsp;&nbsp;
        	
        	
        	
        	
        	
        	
        </h2>
	</center>
    <div align="center">
    <fieldset>
        <table border="1" cellpadding="5">
            <caption><h2>List of Users</h2></caption>
            <tr>
                <th>Dentist's Specialization Number</th>
                <th>Dentist's Specialization Name</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="dentist" items="${listDentist}">
                <tr>
                    <td><legend><c:out value="${dentist.specializationno}" /></legend></td>
                    <td><legend><c:out value="${dentist.specializationName}" /></legend></td>
                    <td>
                    	<a href="editspecs?specializationno=<c:out value='${dentist.specializationno}' />">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="deletespecs?specializationno=<c:out value='${dentist.specializationno}' />">Delete</a>     
                    	&nbsp;&nbsp;&nbsp;&nbsp;               	
                    </td>
                </tr>
            </c:forEach>
           
        </table>
         </fieldset>
    </div>	
</body>
</html>
