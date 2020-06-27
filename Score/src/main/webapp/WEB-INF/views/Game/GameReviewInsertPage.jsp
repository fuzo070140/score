<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html><html lang="en">
	<jsp:include page="../base/header.jsp"/>
<head>
	<meta charset="UTF-8">
	<title>GameReviewInsertPage</title>
	
	<link rel="stylesheet" href="/score/resources/css/game/GameReviewInsertPage.css">
	<script type="text/javascript" src="/score/resources/ckeditor/ckeditor.js"></script>
</head>
	<body>
		<div class="container container-main">
			<div class="container"  style="display: inline-block;text-align: center;">
				<h2>${vo.gameTitle }</h2>
			</div>
			
			<form action="/score/gameReview/insert" name="gameReivewInsert" method="post">
				<input type="hidden" value="${vo.gameNumber }" name="gameNumber">
				<input type="hidden" value="${sessionScope.vo.userNumber }" name="userNumber">
				<input type="hidden" value="${sessionScope.vo.userNickName }" name="userNickName">
				<div class="form-group">
					<div class="input-group-prepend">
		            	<span class="input-group-text">제목</span>
						<input type="text" class="form-control" name="gameReviewTitle" placeholder="제목을 입력해주세요." style="margin-left: -1px; border-radius: 0px 5px 5px 0px ">
		            </div>
				</div>
				<textarea class="form-control" id="ck_editor" name="gameReviewContent"></textarea>
				<label for="customRange2">점수 평가</label>
			  	<font size = 2 id = "slider_value_view">0</font>						  
			  	<input class="slider_range" type="range" min="0" max="100" id="Range" step="10" value="0" name="gameScore"></input>
			  	<div class="container"  style="display: inline-block;text-align: center;">
				  	<button type="button" class="btn btn-primary btn-lg submit_btn">작성 완료</button>					  
				  	<input type="button" value="취소"onclick="cancle();" class="btn btn-primary btn-lg submit_btn">
				</div>
			</form>
				
		</div>
	<script>
	function cancle() {
		location.href = '/score/Board';
	}
     //에디터 설정
	 CKEDITOR.replace('ck_editor', {height: 720});
	 
	 function ShowSliderValue(sVal)
	 {
	 	var obValueView = document.getElementById("slider_value_view");
	 	obValueView.innerHTML = sVal
	 }

	 var RangeSlider = function(){
	 	var range = $('.slider_range');
	     
	 	range.on('input', function(){		
	 		ShowSliderValue(this.value);
	 	});
	 };

	 RangeSlider();
	 
	 $('input[type=range]').on('input', function(){
		    var val = $(this).val();
		    if(val <= 30){
			    $(this).css('background', 'linear-gradient(to right, #FE2E2E 0%, #FE2E2E '+ val +'%, #d5d4d3 ' + val + '%, #d5d4d3 100%)');
		    }
		    if(val >= 31 && val <= 50){
			    $(this).css('background', 'linear-gradient(to right, #FF8000 0%, #FF8000 '+ val +'%, #d5d4d3 ' + val + '%, #d5d4d3 100%)');
		    }
		    if(val >= 51 && val <= 70){
			    $(this).css('background', 'linear-gradient(to right, #D7DF01 0%, #D7DF01 '+ val +'%, #d5d4d3 ' + val + '%, #d5d4d3 100%)');
		    }
		    if(val >= 71 && val <= 90){
			    $(this).css('background', 'linear-gradient(to right, #40FF00 0%, #40FF00 '+ val +'%, #d5d4d3 ' + val + '%, #d5d4d3 100%)');
		    }
		    if(val >= 91 && val <= 100){
			    $(this).css('background', 'linear-gradient(to right, #2E9AFE 0%, #2E9AFE '+ val +'%, #d5d4d3 ' + val + '%, #d5d4d3 100%)');
		    }
    });
	
	//null체크
		function isEmpty(str){
	        
        if(typeof str == "undefined" || str == null || str == "")
            return true;
        else
            return false ;
    }
	
	//submit button 클릭시
	$(".submit_btn").click(function(){
		var gameNumber = $("input[name=gameNumber]").val();
		var userNumber = $("input[name=userNumber]").val();
	 	var userNickName = $("input[name=userNickName]").val();
		var gameScore = $("input[name=gameScore]").val();
		var gameReviewTitle = $("input[name=gameReviewTitle]").val();
		var gameReviewContent = CKEDITOR.instances.ck_editor.getData();
		
		if(isEmpty(gameNumber)){
			alert("접근할수 없습니다.");
		}else if(isEmpty(gameNumber)){
			alert("접근할수 없습니다.");
		}else if(isEmpty(userNumber)){
			alert("로그인이 필요합니다.");
		}else if(isEmpty(userNickName)){
			alert("로그인이 필요합니다.");
		}else if(isEmpty(gameScore)){
			alert("점수 등록이 필요합니다.");
		}else if(isEmpty(gameReviewTitle)){
			alert("제목을 확인해주세요.");
		}else if(isEmpty(gameReviewContent)){
			alert("리뷰를 확인해주세요.");
		}else{
			var gameReivewInsert = document.gameReivewInsert;
			gameReivewInsert.submit();
		}

	});
		 
		
	</script>
	</body>
	<jsp:include page="/WEB-INF/views/base/footer.jsp"/>
</html>
