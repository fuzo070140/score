<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html><html lang="en">
	<jsp:include page="../base/header.jsp"/>
<head>
	<meta charset="UTF-8">
	<title>GameModifyPage</title>
	
	<script type="text/javascript" src="/score/resources/js/jquery-3.3.1.min.js"></script>
</head>
	<body>
		<div class="container container-main">
			<div class="main">
				<form action="/score/gamereq/insert" method="post" id="formModify" enctype="multipart/form-data">
					<input type="hidden" name="gameNumber" value="${vo.gameNumber }">
					<input type="hidden" name="userNumber" value="${sessionScope.vo.userNumber }">
					<input type="hidden" name="userNickName" value="${sessionScope.vo.userNickName }">
					<input type="hidden" name="gameImg" value="${vo.gameImg }" id="gameImgHidden">
					게임 제목 : <input type="text"name="gameTitle" value="${vo.gameTitle }"><br /> 
					게임 개발사 : <input type="text"name="gameDeveloper" value="${vo.gameDeveloper }"><br /> 
					게임 유통사 : <input type="text"name="gameDistributor" value="${vo.gameDistributor }"><br /> 
					게임 플랫폼 : <input type="text"name="gamePlatform" value="${vo.gamePlatform }"><br /> 
					게임 지원상태 : <input type="text"name="gameSupportStatus" value="${vo.gameSupportStatus }"><br /> 
					게임 장르 : <input type="text"name="gameGenre" value="${vo.gameGenre }"><br /> 
					게임 연령제한 : <input type="text"name="gameAgeGroup" value="${vo.gameAgeGroup }"><br />
					<div class="inputimg">
						<label for="gdsImg">이미지</label>
						<input type="file" id="gameImg" name="file">
						<div class="select_img"><img src="/score/resources${vo.gameImg }" style="width:500px;"></div>
					</div>
					<input type="button" value="수정하기" onclick="modify();"><br /> 
					<input type="button" value="돌아가기" onclick="cancle();" />
				</form>
					</div>
		</div>
		<script>
		function modify() {
			$('#formModify').submit();
		}
		function cancle() {
			location.href = '/score/Game';
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
	<jsp:include page="../base/footer.jsp"/>
</html>
