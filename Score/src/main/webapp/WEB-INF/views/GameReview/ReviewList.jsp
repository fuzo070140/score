<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html><html lang="en">
	<jsp:include page="../base/header.jsp"/>
<head>
<head>
	<meta charset="UTF-8">
	<title>GameList</title>
	
	<link rel="stylesheet" href="/score/resources/css/game/GameInsert.css">
</head>
	<body>
		<div class="container container-main">
		
		</div>
	<script>
		//이동시 navbar 선택 변경
		$(document).ready(function(){
			$('a.page_main').removeClass("active");
			$('a.page_review').addClass("active");
		});
	</script>
	</body>
	<jsp:include page="/WEB-INF/views/base/footer.jsp"/>
</html>