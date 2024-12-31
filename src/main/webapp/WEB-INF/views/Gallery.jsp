<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/Gallery.css">
</head>
<body>
 <h1>갤러리</h1>
    <!-- 관리자만 업로드 버튼 표시 -->
    <c:if test="${isAdmin}">
        <a href="upload.jsp" class="upload-button">이미지 업로드</a>
    </c:if>

    <!-- 갤러리 이미지 목록 -->
    <div class="gallery-grid">
        <c:forEach var="image" items="${images}">
            <div class="gallery-item">
                <img src="${image.imageUrl}" alt="Gallery Image">
                <p>${image.description}</p>
            </div>
        </c:forEach>
    </div>
</body>
</html>