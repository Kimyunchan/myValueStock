<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 등록</title>
</head>
<body>
	<form id = "form" method = "post" action = "/board/create">
		<input type = "hidden" name = "id" value = "0">
		제목 : <input type = "text" name = "title">
		<br/>
		내용 : <textarea name = "content"></textarea>
		<br/>
		작성자id : <input type = "text" name = "authorId">
		<br/>
		<button type = "submit" id ="btnSubmit">등록</button>
	</form>
</body>
<script type = "text/javascript">
	btnSubmit = document.getElementById("btnSubmit");
	btnSubmit.onclick = (event) => {
		event.preventDefault();
		document.getElementById("form").submit();
	}
</script>
</html>