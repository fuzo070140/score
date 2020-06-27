<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html><html lang="en">
	<jsp:include page="../base/header.jsp"/>
<head>
	<meta charset="UTF-8">
	<title>BoardInsert</title>
	
	<link rel="stylesheet" href="/score/resources/css/game/GameInsert.css">
	<script type="text/javascript" src="/score/resources/ckeditor/ckeditor.js"></script>
</head>
	<body>
		<div class="container container-main">
			<div class="container"  style="display: inline-block;text-align: center;">
				<h2>게시판 글쓰기</h2>
			</div>
			<form action="/score/Board/insert" method="post" id="formInsert">
				<input type="hidden" name="userNickName"value="${sessionScope.vo.userNickName }"> 
				<input type="hidden" name="userNumber"value="${sessionScope.vo.userNumber }"> 
				<div class="form-group">
					<div class="input-group-prepend">
		            	<span class="input-group-text">제목</span>
						<input type="text" class="form-control" name="boardTitle" placeholder="제목을 입력해주세요." style="margin-left: -1px; border-radius: 0px 5px 5px 0px ">
		            </div>
				</div>
				<textarea class="form-control" id="ck_editor" name="boardContent"></textarea>
			  	<div class="container"  style="display: inline-block;text-align: center;">
					<input type="button" value="작성"onclick="insert();" class="btn btn-primary btn-lg submit_btn">
					<input type="button" value="취소"onclick="cancle();" class="btn btn-primary btn-lg submit_btn">
				</div>
			</form>
		</div>
	<script>
	CKEDITOR.replace('ck_editor',{filebrowserUploadUrl:'/score/Board/imageUpload'});
	
	//null체크
	function isEmpty(str){
	        
        if(typeof str == "undefined" || str == null || str == "")
            return true;
        else
            return false ;
    }
	//이동시 navbar 선택 변경
	$(document).ready(function(){
		$('a.page_main').removeClass("active");
		$('a.page_board').addClass("active");
	});
	function cancle() {
		location.href = '/score/Board';
	}
	function insert() {
		var userNickName = $('[name="userNickName"]').val();
		var boardTitle = $("input[name=boardTitle]").val();
		var boardContent = CKEDITOR.instances.ck_editor.getData();
		//게시글 작성 여부 확인
		if(isEmpty(userNickName)){
			alert("접근할수 없습니다.");
		}else if(isEmpty(boardTitle)){
			alert("제목을 작성해주세요.");
		}else if(isEmpty(boardContent)){
			alert("내용을 작성해주세요");
		}else{
			$('#formInsert').submit();
		}
	}
	</script>
	</body>
	<jsp:include page="../base/footer.jsp"/>
</html>
