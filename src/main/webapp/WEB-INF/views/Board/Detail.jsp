<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/Common/Include.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
/* 게시글 상세 스타일 */
.board-detail {
	background-color: #fff;
	width: 80%;
	max-width: 1200px;
	margin: 50px auto;
	padding: 30px;
	border-radius: 8px;
	box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
}

/* 제목 */
.board-detail h1 {
	font-size: 2rem;
	color: #333;
	margin-bottom: 15px;
}

/* 정보 (작성자, 작성일, 조회수) */
.board-detail p {
	font-size: 1rem;
	color: #666;
	margin-bottom: 8px;
}

/* 구분선 */
.board-detail hr {
	border: 0;
	border-top: 1px solid #ddd;
	margin: 20px 0;
}

/* 내용 */
.board-detail .content {
	font-size: 1.2rem;
	color: #444;
	line-height: 1.6;
	margin-bottom: 20px;
}

/* 액션 버튼 */
.board-detail .actions {
	display: flex;
	justify-content: space-between;
	align-items: center;
}

/* 목록, 삭제 버튼 스타일 */
.board-detail .actions a, .board-detail .actions button {
	padding: 10px 20px;
	font-size: 1rem;
	color: #fff;
	background-color: #007bff;
	border: none;
	border-radius: 5px;
	text-decoration: none;
	cursor: pointer;
	transition: background-color 0.3s ease;
}

/* 버튼 hover 효과 */
.board-detail .actions a:hover, .board-detail .actions button:hover {
	background-color: #0056b3;
}

/* 삭제 버튼 */
.board-detail .actions button {
	background-color: #d9534f;
}

.board-detail .actions button:hover {
	background-color: #c9302c;
}

#responseForm {
	margin-top: 20px;
	padding: 10px;
	background-color: #f9f9f9;
	border: 1px solid #ddd;
	border-radius: 5px;
}

textarea {
	width: 100%;
	height: 100px;
	padding: 10px;
	border-radius: 5px;
	border: 1px solid #ccc;
	margin-bottom: 10px;
}

button[type="submit"] {
	padding: 10px 20px;
	background-color: #4CAF50;
	color: white;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

button[type="submit"]:hover {
	background-color: #45a049;
}

.comment-section {
	margin-top: 30px;
}

.comment {
	background-color: #f9f9f9;
	border: 1px solid #ddd;
	padding: 15px;
	border-radius: 5px;
	margin-bottom: 10px;
}

.comment .author {
	font-weight: bold;
	color: #333;
}

.comment .content {
	margin-top: 10px;
	font-size: 1rem;
	color: #555;
}
</style>
</head>
<body>
	<div class="board-detail">
		<h1>${post.title}</h1>
		<p>
			<strong>번호:</strong> ${post.id}
		</p>
		<p>
			<strong>작성자:</strong> ${post.writer}
		</p>
		<p>
			<strong>작성일:</strong> ${post.createdDate}
		</p>
		<p>
			<strong>조회수:</strong> ${post.views}
		</p>
		<p>
			<strong>분류:</strong> ${post.category}
		</p>
		<p>
			<strong>연락처:</strong> ${post.contact}
		</p>
		<p>
			<strong>내용:</strong>
		<div class="content">
			<p>${post.content}</p>
		</div>
		<hr>
		<div class="actions">
			<a href="/Board">목록으로</a>
			<form action="/Board/Delete/${post.id}" method="post"
				style="display: inline;">
				<button type="submit" onclick="return confirm('게시글을 삭제하시겠습니까?');">삭제</button>
			</form>
		</div>
	</div>
	<!-- 댓글 작성 폼 -->
	<div id="responseForm">
		<h3>댓글 작성</h3>
		<form action="/Board/Detail/${post.id}/addComment" method="post">
			<textarea name="content" placeholder="댓글을 작성하세요"></textarea>
			<button type="submit">댓글 달기</button>
		</form>
	</div>

	<!-- 댓글 목록 -->
	<div class="comment-section">
		<h3>댓글</h3>
		<c:forEach var="comment" items="${comments}">
			<div class="comment">
				<div class="author">${comment.author}</div>
				<div class="content">${comment.content}</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>