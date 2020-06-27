<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="../base/header.jsp" />
<head>
<meta charset="UTF-8">
<title>UserLogin</title>

<link rel="stylesheet" href="/score/resources/css/User/UserLogin.css">
</head>
<body>
	<div class="container container-main">
		회원가입에 실패하셨습니다 
		<a href="/score/User/register">회원가입하기</a> 
		<a href="/score">메인화면</a>
	</div>
</body>
<jsp:include page="../base/footer.jsp" />
</html>