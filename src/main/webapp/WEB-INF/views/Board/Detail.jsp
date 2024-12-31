<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/Common/Include.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <div class="board-detail">
        <h1>${post.title}</h1>
        <p><strong>작성자:</strong> ${post.writer}</p>
        <p><strong>작성일:</strong> ${post.createdDate}</p>
        <p><strong>조회수:</strong> ${post.views}</p>
        <hr>
        <div class="content">
            <p>${post.content}</p>
        </div>
        <hr>
        <div class="actions">
            <a href="/Board">목록으로</a>
            <form action="/Board/Delete/${post.id}" method="post" style="display:inline;">
                <button type="submit">삭제</button>
            </form>
        </div>
    </div>
</body>
</html>