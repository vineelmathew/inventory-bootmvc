<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="v" %>

<!DOCTYPE html>
<html>
<head>
<title>SUPPLIERS LIST</title>
</head>
<body>
<h1 align="center">SUPPLIERS LIST</h1>
<table border="5px solid black" width="50%">
 <tr>
    <th>ID</th>
    <th>SUPPLIERS NAME</th>
  </tr>
<v:forEach items="${suppliers}" var="supplier">

<tr align="center">
    <td><v:out value="${supplier.id}"/></td>
    <td><v:out value="${supplier.name}"/></td>
</v:forEach>
  </tr>
</table>
</html>