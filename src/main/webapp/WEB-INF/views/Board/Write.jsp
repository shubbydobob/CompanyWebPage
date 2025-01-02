<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/Common/Include.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>견적문의 작성</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<style>
body.board-page {
	margin: 0 !important;
	max-width: 1400px !important;
	margin-left: auto !important;
	margin-right: auto !important;
	font-family: Arial, sans-serif !important;
	line-height: 1.6 !important;
}

.write-container {
	max-width: 900px;
	margin: 50px auto;
	padding: 20px;
	background-color: #f9f9f9;
	border-radius: 8px;
	box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}

.form-label {
	font-weight: bold;
}

.captcha-container {
	display: flex;
	align-items: center;
	justify-content: space-between;
}

.submit-buttons {
	display: flex;
	justify-content: flex-end;
	gap: 10px;
}
</style>
</head>
<body class="board-page">
	<div class="write-container">
		<h2 class="text-center mb-4">견적문의 작성</h2>
		<form action="/Board/Write" method="post">
			<!-- 이름 -->
			<div class="mb-3">
				<label for="name" class="form-label">이름</label> <input type="text"
					class="form-control" id="name" name="writer" required>
			</div>

			<!-- 비밀번호 -->
			<div class="mb-3">
				<label for="password" class="form-label">비밀번호</label> <input
					type="password" class="form-control" id="password" name="password"
					required>
			</div>
			<!-- 연락처 -->
			<div class="mb-3">
				<label for="contact" class="form-label">연락처</label> <input
					type="text" class="form-control" id="contact" name="contact"
					required>
			</div>
			<!-- 이메일 -->
			<div class="mb-3">
				<label for="email" class="form-label">E-mail</label> <input
					type="email" class="form-control" id="email" name="email" required>
			</div>

			<!-- 분류 -->
			<div class="mb-3">
				<label for="category" class="form-label">분류</label> <select
					class="form-select" id="category" name="category" required>
					<option value="" disabled selected>선택하세요</option>
					<option value="general">일반 문의</option>
					<option value="technical">기술 문의</option>
					<option value="pricing">가격 문의</option>
				</select>
			</div>

			<!-- 제목 -->
			<div class="mb-3">
				<label for="title" class="form-label">제목</label> <input type="text"
					class="form-control" id="title" name="title" required>
			</div>

			<!-- 내용 -->
			<div class="mb-3">
				<label for="content" class="form-label">내용</label>
				<textarea class="form-control" id="content" name="content" rows="5"
					required></textarea>
			</div>

			<!-- 파일 첨부 -->
			<div class="mb-3">
				<label for="file" class="form-label">파일 첨부</label> <input
					type="file" class="form-control" id="file" name="file"> <small
					class="form-text text-muted">첨부 가능한 파일: 이미지, PDF, 문서 파일</small>
			</div>

			<!-- CAPTCHA -->
			<div class="mb-3">
				<label class="form-label">CAPTCHA</label>
				<div class="captcha-container d-flex align-items-center">
					<!-- CAPTCHA 이미지 -->
					<img src="/Board/captcha" alt="Captcha" class="me-3"
						onclick="this.src='/Board/captcha?' + Math.random();"
						style="cursor: pointer;">
					<!-- CAPTCHA 입력 필드 -->
					<input type="text" class="form-control" id="captcha" name="captcha"
						placeholder="자동등록방지 숫자 입력" required>
				</div>
				<small class="form-text text-muted">이미지를 클릭하면 새로고침됩니다.</small>
			</div>

			<!-- 제출 버튼 -->
			<div class="submit-buttons">
				<button type="submit" class="btn btn-primary">작성완료</button>
				<button type="button" class="btn btn-secondary"
					onclick="window.history.back();">취소</button>
			</div>
		</form>
	</div>
</body>
</html>