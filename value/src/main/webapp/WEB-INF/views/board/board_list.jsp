<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 리스트</title>
</head>
<body>
	<table>
		<thead>
			<th>순번</th>
			<th>내용</th>
			<th>작성자</th>
			<th>작성시간</th>
		</thead>
		<tbody>
			<c:forEach var = "item" items = "${list}">
			<tr>
				<td>${item.id}</td>
				<td>${item.content}</td>
				<td>${item.authorId}</td>
				<td>${item.createDatetime}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<button type = "button" id ="create">게시물 등록</button>
	<form id = "form" action = "/board/create" method = "get">
	</form>
</body>
<script type = "text/javascript">
	createButton = document.getElementById("create");
	form = document.getElementsByNames
	createButton.onclick = (event) => {
		event.preventDefault();
		document.getElementById("form").submit();
	}
</script>
</html>