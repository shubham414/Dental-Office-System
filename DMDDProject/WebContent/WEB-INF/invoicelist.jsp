<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<style><%@include file="/WEB-INF/specsliststyle.css"%></style>
	<title>SAS Dental Clinic</title>
</head>
<body>
	<center>
		<h1>INVOICE INFORMATION</h1>
        <h2>
            &nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp; 
        	<a href="home">HOME</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="showinvoiceform">Show Invoice Form</a>
        	&nbsp;&nbsp;&nbsp;
        	
        	
        	
        	
        </h2>
	</center>
    <div align="center">
    <fieldset>
        <table border="1" cellpadding="5">
            <caption><h2>List of Invoices</h2></caption>
            <tr>
                <th>Invoice ID</th>
                <th>Amount</th>
                <th>Date</th>
                <th>Appointment ID</th>
            </tr>
            <c:forEach var="invoice" items="${listUser}">
                <tr>
                    <td><legend><c:out value="${invoice.id}" /></legend></td>
                    <td><legend><c:out value="${invoice.amount}" /></legend></td>
                    <td><legend><c:out value="${invoice.date}" /></legend></td>
                    <td><legend><c:out value="${invoice.appointment_ID}" /></legend></td>
                </tr>
            </c:forEach>
        </table>
        </fieldset>
    </div>	
</body>
</html>