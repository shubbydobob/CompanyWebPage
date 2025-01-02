<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/home.css">
</head>
<body>
	<div class="container">
		<!-- Header -->
		<div class="header">
			<div class="header-left">
				<h1 class="logo"></h1>
				<h1 class="logo-text">
					<a href="/home">시연이 아부지 회사 홈페이지</a>
				</h1>
			</div>
			<div class="header-right">
				<nav class="navigation">
					<ul class="navbar">
						<li><a href="/home#about">회사 소개</a></li>
						<li><a href="/home#Gallery">제품 제작 및 시공</a></li>
						<li><a href="/Board">견적 문의</a></li>
					</ul>
				</nav>
			</div>
		</div>

		<!-- Slider Section -->
		<div class="slider">
			<div class="slides">
				<div class="slide"
					style="background-image: url('/resources/images/welding-6733134_640.jpg');">
					<h2>MAINFURNIS METAL</h2>
					<p>기술 그 이상의 도전</p>
				</div>
				<div class="slide"
					style="background-image: url('/resources/images/metal-4147079_640.jpg');">
					<h2>STAINLESS CORPORATION</h2>
					<p>최고의 품질과 서비스</p>
				</div>
				<div class="slide"
					style="background-image: url('/resources/images/welding-2369044_640.jpg');">
					<h2>PRECISION AND DURABILITY</h2>
					<p>모든 프로젝트에 최고의 정밀함</p>
				</div>
			</div>
			<div class="navigation-buttons">
				<button onclick="prevSlide()">&#10094;</button>
				<button onclick="nextSlide()">&#10095;</button>
			</div>
		</div>
	</div>
	<script src="/resources/js/home.js"></script>
</body>
</html>