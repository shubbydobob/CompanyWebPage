<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>시연이 아부지 홈페이지</title>
<link rel="stylesheet" href="/resources/css/home.css">
</head>
<body>
	<div class="container">
		<!-- Header -->
		<div class="header">
			<div class="header-left">
				<h1 class="logo"></h1>
				<h1 class="logo-text">
					<a href=>시연이 아부지 회사 홈페이지</a>
				</h1>
			</div>
			<div class="header-right">
				<nav class="navigation">
					<ul class="navbar">
						<li><a href="#about">회사 소개</a></li>
						<li><a href="#Gallery">제품 제작 및 시공</a></li>
						<li><a href="#contact">견적 문의</a></li>
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

		<!-- About Section -->
		<section id="about" class="about">
			<div class="container">
				<h1>About Us</h1>
				<h2>우일금속은 고객과의 신뢰를 최우선으로 합니다.</h2>
			</div>
		</section>

		<!-- Services Section -->
		<section id="services" class="services">
			<div class="container">
				<h2>Our Services</h2>
				<p>아래 섹션을 클릭하여 원하는 서비스를 탐색하세요.</p>
				<div class="service-grid">
					<div class="service-item" onclick="showImageGallery()">
						<h3>제품 제작 및 시공</h3>
					</div>
					<div class="service-item" onclick="goToInquiryPage()">
						<h3>견적 문의</h3>
					</div>
				</div>
			</div>
		</section>
		<section id="Gallery" class="gallery-section">
			<h1>갤러리</h1>
			<div id="galleryGrid" class="gallery-grid"></div>
			<!-- 동적으로 여기에 추가 -->
		</section>
		<!-- Footer Section -->
		<footer class="footer">
			<div class="map">
				<iframe src="https://www.google.com/maps/" allowfullscreen=""></iframe>
			</div>
			<div class="info">
				<ul>
					<li><span>TEL:</span> 070-8808-2951</li>
					<li><span>FAX:</span> 031-573-1945</li>
					<li><span>E-MAIL:</span> mainfurnis@daum.net</li>
					<li><span>ADDRESS:</span> 경기도 남양주시 진접읍 부마로 86 메인퍼니스</li>
					<li><span>OPEN - CLOSE:</span> 평일 09:00 - 17:00 (주말 및 공휴일 휴무)</li>
				</ul>
				<!--  
					<div class="social">
						<a href="#" target="_blank">📘</a> <a href="#" target="_blank">📸</a>
						<a href="#" target="_blank">👍</a>
					</div>
					-->
			</div>
		</footer>
		<div class="copyright">
			<p>&copy; 2019 MAIN FURNIS. ALL RIGHTS RESERVED.</p>
		</div>
	</div>
<script src="/resources/js/home.js"></script>	
</body>
</html>
