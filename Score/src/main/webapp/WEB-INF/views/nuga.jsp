<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
	<meta charset="UTF-8">
	<title>title</title>
	<link rel="stylesheet" href="/score/resources/css/nuga.css">
</head>
<body>
		<div class="wrap">
		<jsp:include page="base/header.jsp"/>
			<div class="container">
				<div class="column-left">
					<div class="left-section">
						<iframe width="100%" height="100%" src="https://www.youtube.com/embed/RIzTjx498-E" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
					</div>
				</div>
				<div class="column-right">
					<div class="right-section">
						<c:choose>
							<c:when test="${empty sessionScope.vo }">
								<a href="/score/User/login">로그인</a>
								<a href="/score/User/register">회원가입하기</a>
							</c:when>
							<c:when test="${not empty sessionScope.vo }">
								${sessionScope.vo.userID }님 환영합니다.
								<a href="/score/User/logout">로그아웃</a>
							</c:when>
						</c:choose>
					</div>
					<div class="right-section2">
					123
					</div>
				</div>
				<div class="column-bottom">
					<div class="bottom-section-left">
						123
					</div>
					<div class="bottom-section-right">
						123
					</div>
				</div>
			</div>
		<jsp:include page="base/footer.jsp"/>
	</div>
</body>
</html>