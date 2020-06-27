<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html><html lang="en">
	<jsp:include page="../base/header.jsp"/>
<head>
	<meta charset="UTF-8">
	<title>UserRegister</title>
	
	<link rel="stylesheet" href="/score/resources/css/User/UserRegister.css">
</head>
	<body>
		<div class="container container-main">
			<div class="main">
				<a href="/score/User/registerNomal">일반 사용자 회원가입</a><br/>
				<a href="/score/User/registerBus">기업용 회원가입</a>
			</div>
		</div>
		<script>
		</script>
	</body>
	<jsp:include page="../base/footer.jsp"/>
</html>
