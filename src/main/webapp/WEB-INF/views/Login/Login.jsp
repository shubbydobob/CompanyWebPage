<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/Login.css">
<title>관리자 로그인 페이지</title>
</head>
<body>
	<div class="background-image">
		<div class="container">
			<div class="titleArea">
				<h2>관리자 로그인</h2>
			</div>
			<div class="loginForm">
				<form action="/Login" method="post">
					<div id="adminLabel">
						<label for="admin">아이디:</label>
					</div>
					<div id="admin">
						<input type="text" id="admin" name="admin" required>
					</div>
					<div id="passwordLabel">
						<label for="password">비밀번호:</label>
					</div>
					<div id="password">
						<input type="password" id="password" name="password" required>
					</div>
					<div id="button">
						<button type="submit">로그인</button>
					</div>
				</form>
			</div>
		</div>
</body>
</html>