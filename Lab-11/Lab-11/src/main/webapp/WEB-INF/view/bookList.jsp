<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Books currently in the shop</title>
</head>

<body>
<div>
	<h1>Books currently in the shop</h1>
	<table>
		<thead>
		<tr>
			<th scope="col">Title</th>
			<th scope="col">Author</th>
			<th scope="col">Price</th>
			<th scope="col">ISBN</th>
			<th scope="col">Operation</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="book" items="${books}">
			<tr>
				<td>${book.title}</td>
				<td>${book.author}</td>
				<td>${book.price}</td>
				<td>${book.ISBN}</td>
				<td><a href="books/${book.id}">Edit</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>

	<a href="books/add"> Add a Book</a>
</div>
</body>

</html>