<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html><html lang="en">
	<jsp:include page="../base/header.jsp"/>
<head>
	<title>GameInsert</title>
	
	<link rel="stylesheet" href="/score/resources/css/game/GameInsert.css">
	<script type="text/javascript" src="/score/resources/js/jquery-3.3.1.min.js"></script>
</head>
	<body>
		<div class="container container-main">
			<div class="main">
				<form action="/score/Game/insert" method="post" id="formInsert" enctype="multipart/form-data">
					<input type="hidden" name="userNickName"value="${sessionScope.vo.userNickName }">
					<input type="hidden" name="userNumber"value="${sessionScope.vo.userNumber }"> 
					게임 제목 : <input type="text"name="gameTitle" ><br /> 
					게임 개발사 : <input type="text"name="gameDeveloper"><br /> 
					게임 유통사 : <input type="text"name="gameDistributor"><br /> 
					게임 플랫폼 : <input type="text"name="gamePlatform"><br /> 
					게임 지원상태 : <input type="text"name="gameSupportStatus"><br /> 
					게임 장르 : <input type="text"name="gameGenre"><br /> 
					게임 연령제한 : <input type="text"name="gameAgeGroup"><br />
					<div class="inputimg">
						<label for="gdsImg">이미지</label>
						<input type="file" id="gameImg" name="file"/>
						<div class="select_img"><img src=""></div>
					</div>
					<input type="button" value="추가"onclick="insert();"><br /> 
					<input type="button" value="취소"onclick="cancle();">
				</form>
			</div>
		</div>
	<script>
		function cancle() {
			location.href = '/score/Game';
		}
		function insert() {
			var userNickName = $('[name="userNickName"]').val();
		
			//로그인 확인
			//세션 유저의 닉네임 불러옴(고유) -> null 일경우 alert(회원가입 유도) -> 로그인 페이지 이동 -> End
			//세션 유저의 닉네임 불러옴(고유) -> null 아닐경우 게시글 작성 -> End
			if (!userNickName) {
				alert("로그인이 필요한 기능입니다");
			} else {
				//게시글 작성 여부 확인
				$('#formInsert').submit();
			}
		}
		$("#gameImg").change(function(){
			if(this.files && this.files[0]) {
				var reader = new FileReader;
				reader.onload = function(data) {
					$(".select_img img").attr("src", data.target.result).width(500);
				}
				reader.readAsDataURL(this.files[0]);
			}
		});
		/* 이미지 ㅡ https://kuzuro.blogspot.com/2018/10/11.html */ 
	</script>
	</body>
	<jsp:include page="/WEB-INF/views/base/footer.jsp"/>
</html>
