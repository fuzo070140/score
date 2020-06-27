<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html><html lang="en">
	<jsp:include page="../base/header.jsp"/>
<head>
	<meta charset="UTF-8">
	<title>ChangePW</title>
	
	<link rel="stylesheet" href="/score/resources/css/User/UserLogin.css">
</head>
	<body>
		<div class="container container-main">
			<div class="main">
				<form action="/score/User/ChangePW" method="post">
					기존 비밀번호 : <input type="password" name="userPassWord"><br/>
					기존 비밀번호 확인 : <input type="password" name="userPassWord"><br/>
					변경할 비밀번호 : <input type="password" name="userPassWord"><br/>
					변경할 비밀번호 확인 : <input type="password" name="userPassWord"><br/>
					<input type="submit" value="비밀번호 변경">
					<input type="button" value="취소" onclick="cancle();">
				</form>
			</div>
		</div>
		<script>
			function cancle() {
				history.back();
			}
		</script>
	</body>
	<jsp:include page="../base/footer.jsp"/>
</html>