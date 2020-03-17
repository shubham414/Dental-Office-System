<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style><%@include file="/WEB-INF/loginstyle.css"%></style>
<title>SAS Dental Clinic</title>
</head>
<body>
<header>
<img src="<c:url value='C:\DMDDProject\apache-tomcat-8.5.47\webapps\ROOT\DMDDImage.png'/>">
</header>
 <div align="center">
  <h1>ADMINISTRATOR LOGIN FORM</h1>
  <form action="<%=request.getContextPath()%>/login" method="post">
  <fieldset>
   <table style="with: 100%">
    <tr>
     <td><legend>Administrator Username : </legend></td>
     <td><input type="text" name="username" placeholder="Username" /></td>
    </tr>
    <tr>
     <td><legend>Administrator Password : </legend> </td>
     <td><input type="password" name="password" placeholder="Password" /></td>
    </tr>
   </table>
  </fieldset>
   <input type="submit" value="Submit" formaction="validatekar"/>
  </form>
 </div>
</body>
</html>