<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 내용</title>
</head>
<body>
	<form id = "updateForm" method = "get" action = "/board/update">
		<input type = "hidden" name = "id" readOnly value = "${boardDTO.id}">
		제목 : <input type = "text" name = "title" readOnly value = "${boardDTO.title}">
		<br/>
		내용 : <textarea name = "content" readOnly >${boardDTO.content}</textarea>
		<br/>
		작성자id : <input type = "text" name = "authorId" readOnly value = "${boardDTO.authorId}">
		<br/>
		<button type = "submit" id ="submit">수정</button>
	</form>
	<form id = "deleteForm" method = "get" action ="/board/delete/${boardDTO.id}">
		<button type = "submit" id ="submit">삭제</button>
	</form>
	
	<p>댓글</p>
	<table>
		<thead>
			<th>내용</th>
			<th>작성자</th>
			<th>작성시간</th>
			<th></th>
			<th></th>
		</thead>
		<tbody>
			<c:forEach var = "item" items = "${replyList}">
			<tr>
				<form id = "replyForm${item.replyId}">
					<input type = "hidden" name = "boardId" value = "${boardDTO.id}" />
					<input type = "hidden" name = "replyId" value = "${item.replyId}" />
					<td><textarea name = "content" readonly>${item.content}</textarea></td>
					<td><input type = "text" name = "authorId" value ="${item.authorId}" readonly/></td>
					<td><input type = "text" name = "createDatetime" value ="${item.createDatetime}" readonly/></td>
					<td><button type ="button" name = "btnChangeUpdate" id = "btnChangeUpdate${item.replyId}">수정</button>
					<button type ="button" name = "btnRUpdate" id = "btnRUpdate${item.replyId}">등록</button></td>
					<td><button type ="button" name = "btnRDelete">삭제</button></td>
				</form>
			</tr>
			</c:forEach>
			<form id = "replyCForm">
				<input type = "hidden" name = "boardId" value = "${boardDTO.id}" />
				<input type = "hidden" name = "replyId" value = "0">
				<input type = "hidden" name = "authorId" value = "1">
				<tr>
					<td><textarea name = "content"></textarea></td>
					<td></td>
					<td></td>
					<td><button type ="button" id = "btnRCreate">댓글등록</button></td>
					<td></td>
				</tr>
			</form>
		</tbody>
	</table>
	<script type = "text/javascript">
	
		var btnChangeUpdate = document.getElementsByName("btnChangeUpdate");
		
		for(let btnCU of btnChangeUpdate){
			
			btnCU.addEventListener("click",function(e){
				
				console.log(btnCU);
				
				event.preventDefault();
				
				btnCU.parentNode.parentNode.childNodes[7].childNodes[0].readOnly = false;
				var id = btnCU.parentNode.parentNode.childNodes[5].value;
				
				document.getElementById("btnRUpdate"+id).style.display = "block";
				document.getElementById("btnChangeUpdate"+id).style.display = "none";
				
			})
		}
	
	
		var btnRUpdate = document.getElementsByName("btnRUpdate");
		
		for(let btnRU of btnRUpdate){
						
			btnRU.addEventListener("click",function(e){
				
				event.preventDefault();
				
				var id = btnRU.parentNode.parentNode.childNodes[5].value;
				
				var replyForm = document.getElementById("replyForm"+id);
				
				replyForm.method = "post";
				replyForm.action = "/reply/update";
				replyForm.submit();
				
			})
		}
		
		var btnRDelete = document.getElementsByName("btnRDelete");
		
		for(let btnRD of btnRDelete){
			btnRD.addEventListener("click",function(e){
				
				event.preventDefault();
				
				var id = btnRD.parentNode.parentNode.childNodes[5].value
				
				var replyForm = document.getElementById("replyForm"+id);
				
				replyForm.method = "post";
				replyForm.action = "/reply/delete";
				replyForm.submit();
				
			})
		}

		var btnRCreate = document.getElementById("btnRCreate");
		
		btnRCreate.addEventListener("click",function(){
				
				event.preventDefault();
				
				var replyForm = document.getElementById("replyCForm");
				
				replyForm.method = "post";
				replyForm.action = "/reply/create";
				replyForm.submit();
				
		})
		
	</script>
</body>
</html>