<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/Inquiry.css">
<script src="/resources/js/Inquiry.js"></script>
<title>관리자 페이지</title>
</head>
<body>
    <!-- 상단 컨테이너 -->
    <div class="header">
        <h1 class="header-title">관리자 페이지</h1>
    </div>

    <!-- 문의 섹션 -->
    <section class="inquiries">
        <div class="container">
            <div class="section-header">
                <h2 class="section-title">문의 내역</h2>
                <form action="/Logout" method="get" class="logout-form">
                    <button type="submit" class="logout-button">로그아웃</button>
                </form>
            </div>
            <table class="inquiry-table">
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>회사명 또는 이름</th>
                        <th>연락처</th>
                        <th>이메일</th>
                        <th>문의 유형</th>
                        <th>문의 내용</th>
                        <th>첨부파일</th>
                        <th>작성일</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="inquiry" items="${inquiries}">
                        <tr>
                            <td>${inquiry.id}</td>
                            <td>${inquiry.name}</td>
                            <td>${inquiry.contact}</td>
                            <td>${inquiry.email}</td>
                            <td>${inquiry.inquiry_type}</td>
                            <td>${inquiry.message}</td>
                            <td>
                                <c:if test="${not empty inquiry.attachment_path}">
                                    <a href="/uploads/${inquiry.attachment_path}" target="_blank">첨부파일</a>
                                </c:if>
                                <c:if test="${empty inquiry.attachment_path}">
                                    -
                                </c:if>
                            </td>
                            <td>${inquiry.createdAt}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </section>

    <!-- 푸터 -->
    <div class="footer">
        <video autoplay muted loop id="bottom_video">
            <source src="/resources/video/37071-413208360_tiny.mp4" type="video/mp4">
        </video>
    </div>
</body>
</html>