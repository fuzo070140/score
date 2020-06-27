<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html><html lang="en">
	<jsp:include page="../base/header.jsp"/>
<head>
	<meta charset="UTF-8">
	<title>UserMyPage</title>
</head>
<body>
	<div class="container container-main">
		<div class="main">
			아이디 : ${sessionScope.vo.userID }<br/>
			닉네임 : ${sessionScope.vo.userNickName }<br/>
			이메일 : ${sessionScope.vo.userEmail }<br/>
			자기소개 : <input type="text" value="${sessionScope.vo.userIntro }"><br/>
			가입날짜 : ${sessionScope.vo.userRegDate }<br/>
			최근 프로필 수정 날짜 :${sessionScope.vo.userUpdateDate }<br/>
		         유저 리뷰포인트 ${sessionScope.vo.userPoint }<br/>
			유저 게시판포인트${sessionScope.vo.userPointPeople }<br/>
			<img src="/score/resources${vo.userThumbImg }" class="img-rounded" style="height: 64px;width: 64px;"/>
			<a href="/score/User/ChangePW">비밀번호 변경</a> 
			<a href="/score/User/ChangeEmail">이메일 변경</a> 
			<button>프로필 수정</button>
			<br>
			최근활동
			<br>
			게시판
			<br>
			<c:forEach items="${BvoList }" var="list">
				 <a href='/score/Board/readPage?boardNumber=${list.boardNumber}'>${list.boardTitle }</a><br>
			</c:forEach>
			댓글
			<br>
			<c:forEach items="${CvoList }" var="list">
				<a href='/score/Board/readPage?boardNumber=${list.boardNumber}'>${list.commentContent}</a><br>
			</c:forEach>
		</div>
	</div>
</body>
<jsp:include page="../base/footer.jsp"/>
</html>