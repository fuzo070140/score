<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html><html lang="en">
	<jsp:include page="../base/header.jsp"/>
<head>
	<meta charset="UTF-8">
	<title>ChangeEmail</title>
	
	<link rel="stylesheet" href="/score/resources/css/User/UserLogin.css">
</head>
	<body>
		<div class="container container-main">
			<div class="main">
				<form action="/score/User/ChangeEmail" method="post">
					기존 이메일 : <input type="text" name="userEmail"><br/>
					기존 이메일 코드확인 : <input type="text" name="userEmailCode"><br/>
					변경할 이메일 : <input type="text" name="userEmail2"><br/>
					변경할 이메일 코드확인 : <input type="text" name="userEmailCode2"><br/>
					<input type="submit" value="이메일 변경">
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