<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="../base/header.jsp" />
<head>
<meta charset="UTF-8">
<title>BoardReadPage</title>

<link rel="stylesheet" href="/score/resources/css/Board/board-list.css">
<script type="text/javascript"
	src="/score/resources/ckeditor/ckeditor.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
<!-- https://nowonbun.tistory.com/566 [명월 일지] -->
</head>
<body>
	<div class="container container-main">
		<div class="main">
			<input type="hidden" value="${sessionScope.vo.userNickName }"
				class="session_userNickName" /> <input type="hidden"
				value="${sessionScope.vo.userNumber }" class="session_userNumber" />
			<input type="hidden" value="${vo.boardNumber}" name="boardNumber"
				class="boardNumber" />
			<div class="form-group">
				<div class="input-group-prepend">
					<span class="input-group-text">제목</span> <input type="text"
						class="form-control" readonly="readonly" name="boardTitle"
						value="${vo.boardTitle }"
						style="margin-left: -1px; border-radius: 0px 5px 5px 0px">
				</div>
			</div>
			<textarea class="form-control" id="ck_editor" name="boardContent">${vo.boardContent }</textarea>
			<br>
			<c:choose>
				<c:when test="${sessionScope.vo.userNickName eq vo.userNickName}">
					<div class="container"
						style="display: inline-block; text-align: center;">
						<a href="/score/Board/modify?boardNumber=${vo.boardNumber }"
							class="btn btn-primary btn-lg submit_btn">게시글 수정</a> <a
							href="/score/Board/delete?boardNumber=${vo.boardNumber }"
							class="btn btn-primary btn-lg submit_btn">게시글 삭제</a>
					</div>
				</c:when>
			</c:choose>

			<div class="comment">
				<button class="comment_AllList btn btn-primary btn-lg">댓글
					전체보기</button>
				<c:choose>
					<c:when test="${not empty sessionScope.vo.userNickName}">
						<div class="jumbotron"
							style="padding: 8px 8px; margin-bottom: 4px;">
							<div class="container">
								<div style="display: inline;">${sessionScope.vo.userNickName}</div>
								<div style="float: right;"></div>
							</div>
							<hr class="my-4"
								style="margin-bottom: 4px !important; margin-top: 4px !important;">
							<div class="input-group-prepend">
								<span class="input-group-text">내용</span>
								<textarea class="form-control commentContent"
									id="exampleTextarea" rows="3" name="commentContent"
									placeholder="댓글내용을 작성해주세요."
									style="margin-left: -1px; border-radius: 0px 5px 5px 0px">
						                </textarea>
							</div>
							<hr class="my-4"
								style="margin-bottom: 4px !important; margin-top: 4px !important;">
							<div class="container"
								style="text-align: right; display: inline-block;">
								<input type="button" value="댓글작성" id="comment_insert"
									class="btn btn-primary btn-lg">
							</div>
						</div>
					</c:when>
				</c:choose>
				<div class="comment_list"></div>
			</div>
		</div>
	</div>
	<script>
	CKEDITOR.replace( 'ck_editor', {
		width:'100%',
		height: '800px' ,
  		startupFocus:false,
  			on : {
   				instanceReady : function(evt) {
	    			evt.editor.setReadOnly( true );
    			}
  			}
	});
	//null체크
	function isEmpty(str){
	        
        if(typeof str == "undefined" || str == null || str == "")
            return true;
        else
            return false ;
    }

		var boardNumber = $(".boardNumber").val();
		var userNumber = $(".session_userNumber").val();
		//이동시 navbar 선택 변경
		$(document).ready(function(){
			$('a.page_main').removeClass("active");
			$('a.page_board').addClass("active");
		});
		$(document).ready(function(){
			//댓글 exampleTextarea 초기화
			$("#exampleTextarea").val('');
				
			//기본으로 5개 댓글리스트 출력
			getcommentBaseList(5);
			
			$(".comment_AllList").click(function(){
				getcommentBaseList(1);
			});
			//댓글리스트 commentPoint 는 리스트 불러올 갯수 기본 5개 5이외의 숫자로보내면 전체

		});
		
		
		
		function getcommentBaseList(commentPoint) {
			//댓글생성
			//https://m.blog.naver.com/mikong22/221395112676
			//해당 함수 ajax 동기화설정
			$.ajaxSetup({
			  async: false
			});
			
			$.getJSON("/score/comment/list/" + boardNumber + "/" + commentPoint, function(data) {
				var str = "";
				$.each(data, function(i, item){
					var Fdate = new Date(item.commentRegDate);
					var date = moment(Fdate).format('YYYY/MM/DD HH:mm:ss');
					str += "<div class='jumbotron jum"+item.commentNumber+"' style='padding: 8px 8px;margin-bottom: 4px;'>";
					str += "<div class='container'>";
					str += "<div style='display: inline;' class='lead'>"+ item.userNickName +"</div>";
					str += "<div style='float: right;'>"+ date +"</div>";
					str += "</div>";
					str += "<hr class='my-4' style='margin-bottom: 4px !important; margin-top: 4px !important;'>";
					str += "<p style='margin:0px;padding-left:16px;padding-right:16px;' id='commentContent"+item.commentNumber+"'>"+ item.commentContent +"</p>";
					str += "<hr class='my-4' style='margin-bottom: 4px !important; margin-top: 4px !important;'>";
					str += "<div class='container' style='text-align: right;display: inline-block;'>";
						if(isEmpty(userNumber) == false){
							str += "<input type='button' value='답글' id='comment_recomment"+item.commentNumber+"' class='btn btn-primary btn-lg' role='button' style='margin:1px;' onclick='comment_recomment("+item.commentNumber+");'/>";
							if(item.userNumber == $(".session_userNumber").val()){
								str += "<input type='button' value='수정' id='comment_modify"+item.commentNumber+"' class='btn btn-primary btn-lg' role='button' style='margin:1px;' onclick='comment_modify("+item.commentNumber+");'/>";
								str += "<input type='button' value='삭제' id='comment_delete"+item.commentNumber+"' class='btn btn-primary btn-lg' role='button' style='margin:1px;' onclick='comment_delete("+item.commentNumber+","+item.boardNumber+");'/>";
							}
						}
					str += "</div></div>";
				});
				$(".comment_list").html(str);
				$.each(data, function(i, item){
					$.getJSON("/score/comment/relist/"+item.commentNumber, function(redata) {
						var restr = "";
							$.each(redata, function(i, reitem){
								console.log(redata);
								var Fdate = new Date(reitem.reCommentRegDate);
								var date = moment(Fdate).format('YYYY/MM/DD HH:mm:ss');
								restr += "<div class='jumbotron rejum"+reitem.commentNumber+"' style='padding: 8px 8px;margin-bottom: 4px;margin-left:160px;'>";
								restr += "<div class='container'>";
								restr += "<div style='display: inline;' class='lead'>"+reitem.userNickName+"</div>";
								restr += "<div style='float: right;'>"+ date +"</div>";
								restr += "</div>";
								restr += "<hr class='my-4' style='margin-bottom: 4px !important; margin-top: 4px !important;'>";
								restr += "<p style='margin:0px;padding-left:16px;padding-right:16px;' id='reCommentContent"+reitem.reCommentNumber+"'>"+reitem.reCommentContent+"</p>";
								restr += "<hr class='my-4' style='margin-bottom: 4px !important; margin-top: 4px !important;'>";
								restr += "<div class='container' style='text-align: right;display: inline-block;'>";
								if(reitem.userNumber == $(".session_userNumber").val()){
									restr += "<input type='button' value='수정' id='recomment_modify"+reitem.reCommentNumber+"' class='btn btn-primary btn-lg' role='button' style='margin:1px;' onclick='recomment_modify("+reitem.reCommentNumber+");'/>";
									restr += "<input type='button' value='삭제' id='recomment_delete"+reitem.reCommentNumber+"' class='btn btn-primary btn-lg' role='button' style='margin:1px;' onclick='recomment_delete("+reitem.reCommentNumber+");'/>";
								}
								restr += "</div>";
								restr += "</div>";
								
							});
						$(".jum"+item.commentNumber).after(restr);
					});
				});
			})
		};
		
		//댓글달기
		$("#comment_insert").click(function(){
			var userNickName = $(".session_userNickName").val();
			var userNumber = $(".session_userNumber").val();
			var commentContent = $(".commentContent").val();
			
			$.ajax({
				type : 'post',
				url : '/score/comment/insert',
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "POST"
				},
				dataType : 'text',
				data : JSON.stringify({
					userNickName : userNickName,
					userNumber : userNumber,
					commentContent : commentContent,
					boardNumber : boardNumber
				}),
				success : function(result) {
					if(result == "SUCCESS") {
						history.go(0);
					}
				}
			});
		});
		//댓글삭제
		function comment_delete(commentNumber,boardNumber){
			$.ajax({
				type : 'post',
				url : '/score/comment/delete',
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "POST"
				},
				dataType : 'text',
				data : JSON.stringify({
					commentNumber : commentNumber,
					boardNumber : boardNumber,
				}),
				success : function(result) {
					if(result == "SUCCESS") {
						history.go(0);
					}
				}
			});
		}
		//수정폼 만들기
		function comment_modify(commentNumber){
			//공백제거 https://ithub.tistory.com/156
			var commentContent = ($("#commentContent" + commentNumber).text().replace(/(\s*)/g,""));
			
			//입력 폼생성
			var str = "";
			str +="<div class='input-group-prepend'>";
			str +="<span class='input-group-text'>내용</span>";
			str +="<textarea class='form-control commentContent' id='exampleTextarea' rows='3' name='commentContent' placeholder='수정할내용.' style='margin-left: -1px; border-radius: 0px 5px 5px 0px '>"+commentContent+"</textarea>";
			str +="</div>";
			//입력폼 주입
			$("#commentContent" + commentNumber).html(str);
			$("#commentContent" + commentNumber).css("padding-left","0px");
			$("#commentContent" + commentNumber).css("padding-right","0px");
			//수정버튼 함수 변경,수정버튼 포커스 아웃
			$("#comment_modify"+commentNumber).attr("onclick","comment_modifyFinal("+ commentNumber+");");
			$("#comment_modify"+commentNumber).blur();
			$("#comment_delete"+commentNumber).replaceWith("");
		}
		//댓글 수정
		function comment_modifyFinal(commentNumber){
			var commentContent = $("#commentContent" + commentNumber + " div textarea").val();
			$.ajax({
				type : 'post',
				url : '/score/comment/update',
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "POST"
				},
				dataType : 'text',
				data : JSON.stringify({
					commentNumber : commentNumber,
					commentContent : commentContent,
				}),
				success : function(result) {
					if(result == "SUCCESS") {
						history.go(0);
					}
				}
			});
		}
		//답글 폼생성
		function comment_recomment(commentNumber){
			//답글 버튼 다시누를수 없게하기
			$("#comment_recomment"+commentNumber).attr('disabled', true);
			var str = "";
			str += "<div class='jumbotron jum"+commentNumber+"' style='padding: 8px 8px;margin-bottom: 4px;margin-left:160px;'>";
			str += "<div class='container'>";
			str += "<div style='display: inline;'>${sessionScope.vo.userNickName}</div>";
			str += "<div style='float: right;'></div>";
			str += "</div>";
			str += "<hr class='my-4' style='margin-bottom: 4px !important; margin-top: 4px !important;'>";
			str += "<div class='input-group-prepend'>";
			str += "<span class='input-group-text'>내용</span>";
			str += "<textarea class='form-control recommentContent' id='recommentContent"+commentNumber+"' rows='3' name='recommentContent"+commentNumber+"' placeholder='답글내용을 작성해주세요.' style='margin-left: -1px; border-radius: 0px 5px 5px 0px '>";
			str += "</textarea>";
			str += "</div>";
			str += "<hr class='my-4' style='margin-bottom: 4px !important; margin-top: 4px !important;'>";
			str += "<div class='container' style='text-align: right;display: inline-block;'>";
			str += "<input type='button' value='답글작성' id='comment_recommentFinal"+commentNumber+"' class='btn btn-primary btn-lg' onclick='comment_recommentFinal("+commentNumber+")'>";
			str += "</div>";
			str += "</div>";
			$(".jum"+commentNumber).after(str);
		}
		//답글 생성
		function comment_recommentFinal(commentNumber){
			var reCommentContent = $("#recommentContent"+commentNumber).val();
			var userNickName = $(".session_userNickName").val();
			var userNumber = $(".session_userNumber").val();
			var boardNumber = $(".boardNumber").val(); 
 			$.ajax({
				type : 'post',
				url : '/score/comment/reinsert/' + boardNumber,
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "POST"
				},
				dataType : 'text',
				data : JSON.stringify({
					commentNumber : commentNumber,
					userNickName : userNickName,
					userNumber : userNumber,
					reCommentContent : reCommentContent,
				}),
				success : function(result) {
					if(result == "SUCCESS") {
						history.go(0);
					}
				}
			});
		}
		//답글삭제
		function recomment_delete(reCommentNumber){
			var boardNumber = $(".boardNumber").val();
			$.ajax({
				type : 'post',
				url : '/score/comment/redelete/' + boardNumber,
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "POST"
				},
				dataType : 'text',
				data : JSON.stringify({
					reCommentNumber : reCommentNumber,
				}),
				success : function(result) {
					if(result == "SUCCESS") {
						history.go(0);
					}
				}
			});
		}
		//답글수정
		function recomment_modify(reCommentNumber){
			//공백제거 https://ithub.tistory.com/156
			var reCommentContent = ($("#reCommentContent" + reCommentNumber).text().replace(/(\s*)/g,""));
			
			//입력 폼생성
			var str = "";
			str +="<div class='input-group-prepend'>";
			str +="<span class='input-group-text'>내용</span>";
			str +="<textarea class='form-control reCommentContent' id='exampleTextarea' rows='3' name='reCommentContent' placeholder='수정할내용.' style='margin-left: -1px; border-radius: 0px 5px 5px 0px '>"+reCommentContent+"</textarea>";
			str +="</div>";
			
			//입력폼 주입
			$("#reCommentContent" + reCommentNumber).html(str);
			$("#reCommentContent" + reCommentNumber).css("padding-left","0px");
			$("#reCommentContent" + reCommentNumber).css("padding-right","0px");
			//수정버튼 함수 변경,수정버튼 포커스 아웃
			$("#recomment_modify"+reCommentNumber).attr("onclick","recomment_modifyFinal("+ reCommentNumber +");");
			$("#recomment_modify"+reCommentNumber).blur();
			$("#recomment_delete"+reCommentNumber).replaceWith("");
		}
		function recomment_modifyFinal(reCommentNumber){
			var reCommentContent = $("#reCommentContent" + reCommentNumber + " div textarea").val();
			
			$.ajax({
				type : 'post',
				url : '/score/comment/reupdate',
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "POST"
				},
				dataType : 'text',
				data : JSON.stringify({
					reCommentNumber : reCommentNumber,
					reCommentContent : reCommentContent,
				}),
				success : function(result) {
					if(result == "SUCCESS") {
						history.go(0);
					}
				}
			});
		}
	</script>
</body>
<jsp:include page="../base/footer.jsp" />
</html>
