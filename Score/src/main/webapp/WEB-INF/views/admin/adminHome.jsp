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
<title>adminHome</title>

<link rel="stylesheet" href="/score/resources/css/main-section.css">
</head>
<body>
	<div class="container container-main">
		<div class="main">
			adminHome
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