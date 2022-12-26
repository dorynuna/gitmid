<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header Menu</title>
</head>
<body>

	<!-- Header Area Start -->
	<header class="header-area clearfix">
		<!-- Close Icon -->
		<div class="nav-close">
			<i class="fa fa-close" aria-hidden="true"></i>
		</div>
		<!-- Logo 누르면 홈가게해놓음-->
		<div class="logo">
			<a href="main.do"><img src="img/core-img/logo.png" alt=""></a>
		</div>
		<!-- Amado Nav 왼쪽에 뜰 메인 메뉴 -->
		<nav class="amado-nav">
			<ul>
				<li><a class="menuLink" href="main.do">홈</a></li>
				<li><a href="shop.html">책</a></li>
				<li><a href="product-details.html">장바구니</a></li>
				<c:if test="${empty mId }">
					<li><a class="menuLink" href="memberLoginForm.do">로그인</a></li>
				</c:if>

				<c:if test="${not empty mId }">
					<li><a class="menuLink" href="memberLogout.do">로그아웃</a></li>
				</c:if>
					<c:if test="${empty mId }">
					<li><a class="menuLink" href="memberJoinForm.do">회원가입</a></li>
				</c:if>
				<li><a href="checkout.html">공지사항</a></li>
			</ul>
		</nav>
		<!-- Button Group -->
		<div class="amado-btn-group mt-30 mb-100">
			<a href="#" class="btn amado-btn mb-15">할인쿠폰</a> <a href="#"
				class="btn amado-btn active">이번주신상</a>
		</div>
		<!-- Cart Menu -->
		<div class="cart-fav-search mb-100">
			<a href="cart.html" class="cart-nav"><img
				src="img/core-img/cart.png" alt=""> 장바구니 <span>(0)</span></a> <a
				href="#" class="fav-nav"><img src="img/core-img/favorites.png"
				alt=""> 위시리스트</a> <a href="#" class="search-nav"><img
				src="img/core-img/search.png" alt=""> 검색</a>
		</div>
		<!-- Social Button -->
		<div class="social-info d-flex justify-content-between">
			<a href="#"><i class="fa fa-pinterest" aria-hidden="true"></i></a> <a
				href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a> <a
				href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a> <a
				href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
		</div>
	</header>
	<!-- Header Area End -->

</body>
</html>