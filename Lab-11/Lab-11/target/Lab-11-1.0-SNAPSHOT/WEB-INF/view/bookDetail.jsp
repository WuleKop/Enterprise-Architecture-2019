<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>${msg} a Car</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/bootstrap.min.css"/>">
</head>

<body>
<div class="container">
	<c:if test="${msg == 'Update'}">
		<d action="../books/${book.id}" method="post">
	</c:if>
	<c:if test="${msg == 'Add'}">
		<form action="../cars" method="post">
	</c:if>
	<table>
		<tr>
			<td>Title:</td>
			<td><input type="text" name="title" value="${book.title}" /> </td>
		</tr>
		<tr>
			<td>Author:</td>
			<td><input type="text" name="author" value="${book.author}" /> </td>
		</tr>
		<tr>
			<td>Price:</td>
			<td><input type="text" name="price" value="${book.price}" /> </td>
		</tr>
		<tr>
			<td>ISBN:</td>
			<td><input type="text" name="ISBN" value="${book.ISBN}" /> </td>
		</tr>
	</table>
	<input type="submit" />
	</form>
	<c:if test="${msg == 'Update'}">
		<form action="delete?bookId=${book.id}" method="post">
			<button type="submit">Delete</button>
		</form>
	</c:if>
</div>
</body>

</html>