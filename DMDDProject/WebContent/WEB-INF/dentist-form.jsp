<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<style><%@include file="/WEB-INF/dentistformstyle.css"%></style>
	<title>SAS Dental Clinic</title>
	<script type="text/javascript">
	function checkforblank() {
		var x=e.which||e.keycode;
		if((x>=48 && x<=57)) || x==8 || (x>=35 && x<=40) || x==46)
		if(document.getElementById('fname').value == "") 
			return true;
			else
			return false;
		
	}
	</script>
</head>
<body>
<header>
<img src="<c:url value='C:\DMDDProject\apache-tomcat-8.5.47\webapps\ROOT\DMDDImage.png'/>">
</header>
	<center>
		<h1>DENTIST INFORMATION</h1>
        <h2>
            &nbsp;&nbsp;&nbsp;
        	<a href="home">HOME</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">List All Dentists</a>
        	&nbsp;&nbsp;&nbsp;
        </h2>
	</center>
    <div align="center">
		<c:if test="${dentist != null}">
			<form action="update" method="post" >
        </c:if>
        <c:if test="${dentist == null}">
			<form action="insert" method="post">
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
        		<legend>
        			<input type="hidden" name="id" value="<c:out value='${dentist.id}' />" />
        		</legend>
        		</c:if>            
            <tr>
                <th>Dentist's First Name : </th>
                <td><legend>
                	<input type="text" name="firstName" size="45" id="fname"
                			value="<c:out value='${dentist.firstName}' />"
                		/>
                		</legend>
                </td>
                
            </tr>
             <tr>
             
                <th>Dentist's Last Name : </th>
                <td><legend>
                	<input type="text" name="lastName" size="45"
                			value="<c:out value='${dentist.lastName}' />"
                		/>
                		 </legend>
                </td>
               
            </tr>
            <tr>
            
                <th>User Email : </th>
                <td><legend>
                	<input type="text" name="email" size="45" placeholder="example@example.com"
                			value="<c:out value='${dentist.email}' />"
                	
                	/>
                	</legend>
                </td>
                
            </tr>
            <tr>
            
                <th>Contact : </th>
                <td><legend>
                	<input type="text" placeholder="example: +6462555288" name="contact" size="45"
                			value="<c:out value='${dentist.contact}' />"
                	
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
