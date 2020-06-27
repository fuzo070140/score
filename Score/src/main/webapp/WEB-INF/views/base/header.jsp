<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html><html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
	<title>title</title>
	<!-- Bootstrap -->
	<link href="/score/resources/css/bootstrap-4.4.1/css/bootstrap.min.css" rel="stylesheet">
	
	<link rel="stylesheet" href="/score/resources/css/base.css">
	<link rel="stylesheet" href="/score/resources/css/header.css">
</head><body>
	<nav class="navbar navbar-expand-sm bg-primary navbar-dark"> <!-- 리스트 : 부트스트랩은 모바일 우선이라 화면이 작으면 아래로 쌓아서 내려온다 --> 
		<a class="navbar-brand active page_main" href="/score">메인[로고]</a> 
		
		<div class="login ml-auto navbar-nav">
		<form class="form-inline my-2 my-lg-0">
        	<input class="form-control mr-sm-2" type="text" placeholder="검색" style="width: 880px;">
        	<button class="btn btn-secondary my-2 my-sm-0" type="submit">검색</button>
        </form>
		<ul class="navbar-nav">
			<li class="nav-item">
				<a class="nav-link page_game" href="/score/Game">게임</a> 
			</li> 
			<li class="nav-item">
				<a class="nav-link page_board" href="/score/Board">게시판</a> 
			</li>
			<!-- <li class="nav-item">
				<a class="nav-link page_review" href="/score/gameReview">리뷰</a> 
			</li> -->
			<li class="nav-item">
				<a class="nav-link page_testGame" href="/score/Board">테스트 게임</a> 
			</li>
		</ul>
			<c:choose>
				<c:when test="${empty sessionScope.vo }">
					<a href="/score/User/login" class="nav-link">로그인</a>
				</c:when>
				<c:when test="${not empty sessionScope.vo }">
					<a href="/score/User" class="nav-link active">${sessionScope.vo.userNickName }님</a>
					<a href="/score/User/logout" class="nav-link">로그아웃</a>
					<input type="hidden" value="${sessionScope.vo.userNumber }" name="globalVarUserNumber" class="globalVarUserNumber">
				</c:when>
			</c:choose>
		</div> 
	</nav>
	<div class="container">
		<div class="header">
			
		</div>
	</div>
	<script src="/score/resources/js/jquery-3.4.1.min.js"></script>
</body></html>