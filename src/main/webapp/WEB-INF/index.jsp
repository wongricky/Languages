<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Languages Home Page</title>
</head>
<body>
	<h1 style="text-align:center;">All Languages</h1>
	<div class="tableWrapper">
		<table style="margin:0px auto;">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Creator</th>
					<th>Version</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${languages}" var="lang">
				<tr>
					<td><c:out value="${lang.id}"/></td>
					<td><a href="/languages/${lang.id}"><c:out value="${lang.name}"/></a></td>
					<td><c:out value="${lang.creator}"/></td>
					<td><c:out value="${lang.currentVersion}"/></td>
					<td><a href="/languages/${lang.id}/edit">edit</a>
					<form action="languages/${lang.id}" method="post">
						<input type="hidden" name="_method" value="delete">
						<input type="submit" value="delete">
					</form>
					</td>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<br/><br/>
	<div class="newBook" style="text-align:center;">
	<h1 style="text-align:center;">Enter New Language</h1>
	<form:form action="/languages" method="post" modelAttribute="language">
		<p>
			<form:label path="name">Name</form:label>
			<form:errors path="name"/>
			<form:input path ="name"/>
		</p>
		<p>
			<form:label path="creator">Creator</form:label>
			<form:errors path="creator"/>
			<form:input path="creator"/>
		</p>
		<p>
			<form:label path="currentVersion">Current Version</form:label>
			<form:errors path="currentVersion"/>
			<form:input path="currentVersion"/>
		</p>
		<input type="submit" value="Create!" style="align:center;"/>
	</form:form>
	</div>
</body>
</html>