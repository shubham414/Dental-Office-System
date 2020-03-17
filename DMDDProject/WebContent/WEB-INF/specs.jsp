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
        	<a href="listspecs">List All Specializations</a>
        	
        </h2>
	</center>
    <div align="center">
		<c:if test="${dentist != null}">
			<form action="updatespecs" method="post">
        </c:if>
        <c:if test="${dentist == null}">
			<form action="insertspec" method="post">
        </c:if>
        <fieldset>
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		<c:if test="${dentist != null}">
            			Edit Dentist Data
            		</c:if>
            		<c:if test="${dentist == null}">
            			Add New Dentist
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${dentist != null}">
        			<input type="hidden" name="id" value="<c:out value='${dentist.id}' />" />
        		</c:if>            
            <tr>
                <th>Specialization Number : </th>
                <td>
                <legend>
                	<input type="text" name="specializationno" size="45" placeholder="example: 007"
                			value="<c:out value='${dentist.specializationno}' />"
                		/>
                		</legend>
                </td>
            </tr>
             <tr>
                <th>Specialization Name : </th>
                <td>
                <legend>
                
                	<input type="text" name="specializationName" size="45"
                			value="<c:out value='${dentist.specializationName}' />"
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
