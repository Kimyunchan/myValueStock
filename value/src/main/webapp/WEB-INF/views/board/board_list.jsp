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
			<th>제목</th>
			<th>내용</th>
			<th>작성자</th>
			<th>작성시간</th>
		</thead>
		<tbody>
			<c:forEach var = "item" items = "${list}">
			<tr>
				<input type = "hidden" value = "${item.id}" />
				<td>${item.title}</td>
				<td>${item.content} <strong>${item.replyCounts}</strong></td>
				<td>${item.authorId}</td>
				<td>${item.createDatetime}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<button type = "button" id ="create">게시물 등록하기</button>
	<form id = "createForm" action = "/board/create" method = "get">
	</form>
	<form id = "detailForm" action = "/board/list" method = "get">
	</form>
</body>
<script type = "text/javascript">
	var createButton = document.getElementById("create");
	createButton.onclick = (event) => {
		event.preventDefault();
		document.getElementById("createForm").submit();
	}
	
	var tbody = document.getElementsByTagName("tbody");
	var getDetails = tbody[0].getElementsByTagName("tr");
	
	for(detail of getDetails){
		detail.addEventListener('click', function() {
	        // 이벤트의 기본 동작을 방지합니다.
	        event.preventDefault();

	        // detailForm 요소를 찾습니다.
	        var detailForm = document.getElementById("detailForm");
	        
	        // 클릭된 행의 ID를 가져옵니다. 여기서는 tr 요소의 첫 번째 자식 td에서 값을 가져옵니다.
	        //var id = this.querySelector('td').textContent.trim();
	        
	        // 클릭된 행의 ID를 가져옵니다. 여기서는 tr 요소의 첫 번째 자식 td에서 값을 가져옵니다.
	        var id = this.querySelector('input').value;
	        
	        // 폼의 action URL을 설정합니다.
	        detailForm.action = '/board/list/' + id;
	        
	        // 폼을 제출합니다.
	        detailForm.submit();
	    });	
	}
</script>
</html>