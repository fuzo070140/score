<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html><html lang="en">
	<jsp:include page="../base/header.jsp"/>
<head>
	<meta charset="UTF-8">
	<title>BoardModifyPage</title>
	
	<script type="text/javascript" src="/score/resources/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="/score/resources/ckeditor/ckeditor.js"></script>
</head>
	<body>
		<div class="container container-main">
			<div class="main">
				<form action="/score/Board/modify" method="post" id="formmodify">
					<div class="container"  style="display: inline-block;text-align: center;">
					<h2>게시판 수정</h2>
					</div>
					<input type="hidden" name="boardNumber" value="${vo.boardNumber }">
					<div class="form-group">
						<div class="input-group-prepend">
			            	<span class="input-group-text">제목</span>
							<input type="text" class="form-control" name="boardTitle" placeholder="제목을 입력해주세요." style="margin-left: -1px; border-radius: 0px 5px 5px 0px" value="${vo.boardTitle }">
			            </div>
					</div>
					<textarea class="form-control" id="ck_editor" name="boardContent">${vo.boardContent }</textarea>
					<div class="container"  style="display: inline-block;text-align: center;">
						<input type="button" value="수정하기" onclick="modify();" class="btn btn-primary btn-lg submit_btn">
						<input type="button" value="돌아가기" onclick="cancle();" class="btn btn-primary btn-lg submit_btn"/>
					</div>
				</form>
			</div>
		</div>
		<script>
		CKEDITOR.replace('ck_editor', {
			filebrowserUploadUrl:'/score/Board/imageUpload',
			height: '800px' 
		});
		function cancle() {
			location.href = '/score/Board';
		}
		//이동시 navbar 선택 변경
		$(document).ready(function(){
			$('a.page_main').removeClass("active");
			$('a.page_board').addClass("active");
		});
		//null체크
		function isEmpty(str){
		        
	        if(typeof str == "undefined" || str == null || str == "")
	            return true;
	        else
	            return false ;
	    }
		function modify() {
			var boardNumber = $('[name="boardNumber"]').val();
			var boardTitle = $("input[name=boardTitle]").val();
			var boardContent = CKEDITOR.instances.ck_editor.getData();
			//게시글 작성 여부 확인
			if(isEmpty(boardNumber)){
				alert("접근할수 없습니다.");
			}else if(isEmpty(boardTitle)){
				alert("제목을 작성해주세요.");
			}else if(isEmpty(boardContent)){
				alert("내용을 작성해주세요");
			}else{
				$('#formmodify').submit();
			}
		}
	</script>
	</body>
	<jsp:include page="../base/footer.jsp"/>
</html>
