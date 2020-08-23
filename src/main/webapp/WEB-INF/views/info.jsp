<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<title>Supplier Details</title>
</head>
<body>
<table border="5px solid black" width="50%">
 <tr>
    <th>SUPPLIERS NAME</th>
    <th>SUPPLIER PASSWORD</th>
  </tr>
<h1>Supplier Details </h1>
<td align="center"><c:out value="${suppliers.id}"  /></td>
<td align="center"><c:out value="${suppliers.name}"  /> </td>
<br>
</table>
</body>
</html>