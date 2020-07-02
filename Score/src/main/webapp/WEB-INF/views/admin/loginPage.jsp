<%@page import="com.score.domain.vo.UserVO"%>
<%@page import="org.springframework.http.HttpRequest"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="../base/header.jsp" />
<head>
<meta charset="UTF-8">
<title>admin</title>

<link rel="stylesheet" href="/score/resources/css/main-section.css">
</head>
<body>
	<div class="container container-main">
		<div class="main">
			<form action="/score/admin/login" method="post" id="adminLogin">
				아이디 : <input type="text" name="adminUserID"><br /> 
				비밀번호 : <input type="password" name="adminUserPassword"><br /> 
				<input type="button" value="로그인" onclick="submit();"> 
				<input type="button" value="취소" onclick="cancle();">
			</form>
		</div>
	</div>
	<script>
		function cancle() {
			location.href = '/score';
		}
		function submit() {
			$('#adminLogin').submit();
		}
	</script>
</body>
<jsp:include page="../base/footer.jsp" />
</html>