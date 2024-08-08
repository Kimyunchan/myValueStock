<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 수정</title>
</head>
<body>
	<form id = "form" method = "post" action = "/board/update">
		<input type = "hidden" name = "id" value = "${boardDTO.id}">
		제목 : <input type = "text" name = "title" value = "${boardDTO.title}">
		<br/>
		내용 : <textarea name = "content" >${boardDTO.content}</textarea>
		<br/>
		작성자id : <input type = "text" name = "authorId" value = "${boardDTO.authorId}">
		<br/>
		<button type = "submit" id ="submit">수정</button>
	</form>
</body>
</html>