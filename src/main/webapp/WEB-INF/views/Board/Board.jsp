<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/Common/Include.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/Board.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="board-container container">
    <h1 class="text-center my-4">견적 문의</h1>
    <div class="table-responsive">
        <table class="table table-striped table-hover board-table">
            <thead class="table-primary">
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>글쓴이</th>
                    <th>조회수</th>
                    <th>작성일</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="post" items="${posts}">
                    <tr>
                        <td>${post.id}</td>
                        <td><a href="/Board/View/${post.id}" class="text-decoration-none">${post.title}</a></td>
                        <td>${post.writer}</td>
                        <td>${post.views}</td>
                        <td>${post.createdDate}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="text-end">
        <a href="/Board/Write" class="btn btn-success write-button">글쓰기</a>
    </div>
</div>
</body>
</html>