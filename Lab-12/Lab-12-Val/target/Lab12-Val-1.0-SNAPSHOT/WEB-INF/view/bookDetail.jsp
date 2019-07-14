<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>${msg} a Book</title>
</head>

<body>
<div >

	<c:if test="${msg == 'Update'}">
		<form:form action="../books/${book.id}" method="post"/>
	</c:if>
	<c:if test="${msg == 'Add'}">
		<form:form action="../books" method="post"/>
	</c:if>
		<form:form modelAttribute="book" >

	<table>
		<tr>
			<td>Title:</td>
			<td><form:input path="title" /> </td>
			<td><form:errors path="title" cssStyle="color: red" /> </td>
		</tr>
		<tr>
			<td>Author:</td>
			<<td><form:input path="author" /> </td>
			<td><form:errors path="author" cssStyle="color: red"/> </td>
		</tr>
		<tr>
			<td>Price:</td>
			<td><form:input path="price" /> </td>
			<td><form:errors path="price" cssStyle="color: red"/> </td>
		</tr>
		<tr>
			<td>ISBN:</td>
			<td><form:input path="ISBN" /> </td>
			<td><form:errors path="ISBN" cssStyle="color: red" /> </td>
		</tr>
	</table>
	<input type="submit" />
	</form:form>
	<c:if test="${msg == 'Update'}">
		<form action="delete?bookId=${book.id}" method="post">
			<button type="submit">Delete</button>
			<sec:csrfInput />
		</form>
	</c:if>
</div>
</body>

</html>