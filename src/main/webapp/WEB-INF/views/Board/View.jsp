<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/Common/Include.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 입력</title>
<style>

.form-container {
    background-color: #fff;
    padding: 30px;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    width: 400px;
    
    position: absolute;  /* 화면 상에서 절대 위치 설정 */
    top: 65%;            /* 중앙보다 아래로 위치시킴 */
    left: 50%;           /* 가로 중앙 */
    transform: translateX(-50%); /* 정확히 중앙에서 위치시킴 */
    text-align: center;
}

h2 {
    margin-bottom: 20px;
    font-size: 1.8rem;
    color: #333;
}

label {
    font-size: 1rem;
    color: #555;
    margin-bottom: 8px;
    display: block;
}

input[type="password"] {
    width: 100%;
    padding: 10px;
    margin-bottom: 20px;
    border: 1px solid #ddd;
    border-radius: 5px;
    font-size: 1rem;
    color: #555;
}

button[type="submit"] {
    width: 100%;
    padding: 10px;
    background-color: #007bff;
    border: none;
    border-radius: 5px;
    color: #fff;
    font-size: 1rem;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

button[type="submit"]:hover {
    background-color: #0056b3;
}

.error-message {
    color: red;
    font-size: 0.9rem;
    text-align: center;
    margin-top: 20px;
}
</style>
</head>
<body>
	<div class="form-container">
		<h2>비밀번호 입력</h2>
		<form action="/Board/View/${post.id}" method="post">
			<label for="password">비밀번호</label> 
			<input type="password" id="password" name="password" required>
			<button type="submit">확인</button>
		</form>
		<c:if test="${not empty error}">
			<p class="error-message">${error}</p>
		</c:if>
	</div>
</body>
</html>