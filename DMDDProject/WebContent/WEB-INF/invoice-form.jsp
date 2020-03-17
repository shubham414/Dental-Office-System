<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<style><%@include file="/WEB-INF/specsformstyle.css"%></style>
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
        	<a href="listinvoice">List Invoice</a>
        	
        </h2>
	</center>
    <div align="center">
			<form action="updateinvoice" method="post">
        <fieldset>
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		
            	</h2>
            </caption>
        		            
            <tr>
                <th>Appointment ID : </th>
                <td>
                <legend>
                	<input type="text" name="Appointment_ID" size="45" placeholder="example: 007"
                			value="<c:out value='${invoice.Appointment_ID}' />"
                		/>
                		</legend>
                </td>
            </tr>
             
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Save" />
            	</td>
            </tr>
        </table>
        </fieldset>
        </form>
    </div>	
</body>
</html>
