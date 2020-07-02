<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="../base/header.jsp" />
<head>
<meta charset="UTF-8">
<title>UserRegister</title>

</head>
<body>
	<div class="container container-main">
		<div class="page-header">
			<div class="col-md-6 col-md-offset-3">
				<h3>회원가입</h3>
			</div>
		</div>
		<div class="col-sm-6 col-md-offset-3">
			<form action="/score/User/register" method="post" enctype="multipart/form-data" id="registerForm">
				<input type="hidden" name="userCategory" value="nomal" id="userCategory">
				<div class="form-group">
					<label for="userID">아이디</label> <input type="text" class="form-control" id="userID" placeholder="아이디를 입력해 주세요" name="userID" autocomplete="username">
					<button type="button" class="btn btn-primary" id="userIDCheckBtn">아이디 중복확인</button>
				</div>
				<div class="form-group">
					<label for="userPassWord">비밀번호</label> <input type="password" class="form-control" id="userPassWord" placeholder="비밀번호를 입력해주세요" name="userPassWord" autocomplete="new-password">
				</div>
				<div class="form-group">
					<label for="userPassWordFin">비밀번호 확인</label> <input type="password" class="form-control" id="userPassWordFin" placeholder="비밀번호 확인을 위해 다시한번  입력해주세요" autocomplete="current-password">
				</div>
				<div class="form-group">
					<label for="userNickName">닉네임</label> <input type="text" class="form-control" id="userNickName" placeholder="닉네임을 입력해주세요" name="userNickName">
					<button type="button" class="btn btn-primary" id="userNickNameCheckBtn">닉네임 중복확인</button>
				</div>
				<div class="form-group">
					<label for="userEmail">이메일</label> <input type="text" class="form-control" id="userEmail" placeholder="이메일을 입력해주세요" name="userEmail">
					<button type="button" class="btn btn-primary" id="emailCheckBtn">이메일 인증번호 발송</button>
				</div>
				<div class="form-group">
					<label for="emailCode">인증번호</label> <input type="text" class="form-control" id="emailCode" placeholder="인증번호를 입력해주세요">
					<button type="button" class="btn btn-primary" id="emailAuthBtn">이메일 인증번호 확인</button>
				</div>
				<div class="form-group">
					<label for="userIntro">유저소개</label> <input type="text" class="form-control" id="userIntro" placeholder="자기소개를 해주세요" name="userIntro">
				</div>
				<div class="form-group">
					<label for="gameImg">썸네일</label> <input type="file" class="" id="gameImg" name="file" placeholder="썸네일을 넣어주세요 필수는 아닙니다" name="userThumbImg">
					<div class="select_img">
						<img src="">
					</div>
				</div>
				<div class="form-group">
					<div data-toggle="buttons">
						<label class="btn btn-primary active"> <span class="fa fa-check"></span> <input id="agree" type="checkbox" autocomplete="off" checked>
						</label> <a href="#">이용약관</a>에 동의합니다.
					</div>
				</div>
				<div class="form-group text-center">
					<button type="button" class="btn btn-primary" onclick="register();">
						회원가입<i class="fa fa-check spaceLeft"></i>
					</button>
					<button type="button" class="btn btn-warning" onclick="cancle()">
						가입취소<i class="fa fa-times spaceLeft"></i>
					</button>
				</div>
			</form>
		</div>
	</div>
	<script>
		function isEmpty(str) {
			if (typeof str == "undefined" || str == null || str == "")
				return true;
			else
				return false;
		}
		function register() {
			var userID = $("#userID").val();
			var userPassWord = $("#userPassWord").val();
			var userPassWordFin = $("#userPassWordFin").val();
			var userNickName = $("#userNickName").val();
			var userEmail = $("#userEmail").val();
			
			$("#registerForm").submit();

			if (isEmpty(userID)) {
				alert("아이디를 확인해주세요");
			} else if (isEmpty(userPassWord)) {
				alert("비밀번호를 확인해주세요");
			} else if (isEmpty(userPassWordFin)) {
				alert("비밀번호를 확인해주세요");
			} else if (isEmpty(userNickName)) {
				alert("닉네임을 확인해주세요");
			} else if (isEmpty(userEmail)) {
				alert("이메일을 확인해주세요");
			} else if (isEmpty($("#userID").attr("readonly"))) {
				alert("아이디 중복확인이 필요합니다.");
			} else if (isEmpty($("#userNickName").attr("readonly"))) {
				alert("닉네임 중복확인이 필요합니다.");
			} else if (isEmpty($("#userEmail").attr("readonly"))) {
				alert("이메일 인증번호를 발송하고 확인해주세요.");
			} else if (isEmpty($("#emailCode").attr("readonly"))) {
				alert("이메일 인증번호를 확인해주세요.");
			} else {
				if (userPassWord === userPassWordFin) {
					$("#registerForm").submit();
				} else {
					alert("비밀번호를 확인해주세요");
				}
			}
		}
		function cancle() {
			location.href = '/score';
		}

		//아이디 중복확인
		$("#userIDCheckBtn").click(function(event) {
			var userID = $("#userID").val();
			if (isEmpty(userID)) {
				alert("아이디를 입력해주세요");
			} else {
				$.ajax({
					type : 'get',
					url : '/score/User/idCheck',
					headers : {
						"Content-Type" : "application/json",
						"X-HTTP-Method-Override" : "GET"
					},
					dataType : 'text',
					data : {
						userID : userID
					},
					success : function(result) {
						if (result == 'succ') {
							alert("확인되었습니다.");
							$("#userID").attr("readonly", true);
						} else if (result == 'fail') {
							alert("이미 사용중입니다.");
						}
					}
				});
			}
		});
		//이메일 인증 번호 발송
		$("#emailCheckBtn").click(function(event) {
			var userEmail = $("#userEmail").val();
			$.ajax({
				type : 'post',
				url : '/score/User/mailCheck',
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "POST"
				},
				dataType : 'text',
				data : JSON.stringify({
					userEmail : userEmail
				}),
				success : function(result) {
					if (result == 'succ') {
						alert("발송 완료했습니다.");
						$("#userEmail").attr("readonly", true);
					} else if (result == 'fail') {
						alert("이메일 주소를 확인해주세요.");
					}
				}
			});
		});

		//이메일 인증 번호 확인
		$("#emailAuthBtn").click(function(event) {
			var code = $("#emailCode").val();
			$.ajax({
				type : 'get',
				url : '/score/User/codeCheck',
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "GET"
				},
				dataType : 'text',
				data : {
					code : code
				},
				success : function(result) {
					if (result == 'succ') {
						alert("확인되었습니다.");
						$("#emailCode").attr("readonly", true);
					} else if (result == 'fail') {
						alert("인증번호가 틀립니다.");
					}
				}
			});
		});

		//userNickName 중복확인
		$("#userNickNameCheckBtn").click(function(event) {
			var userNickName = $("#userNickName").val();
			$.ajax({
				type : 'get',
				url : '/score/User/nickNameCheck',
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "GET"
				},
				dataType : 'text',
				data : {
					userNickName : userNickName
				},
				success : function(result) {
					if (result == 'succ') {
						alert("확인되었습니다.");
						$("#userNickName").attr("readonly", true);
					} else if (result == 'fail') {
						alert("이미 사용중입니다.");
					}
				}
			});
		});
		$("#gameImg").change(
				function() {
					if (this.files && this.files[0]) {
						var reader = new FileReader;
						reader.onload = function(data) {
							$(".select_img img")
									.attr("src", data.target.result).width(64)
									.hegiht(64);
						}
						reader.readAsDataURL(this.files[0]);
					}
				});
		/* 이미지 ㅡ https://kuzuro.blogspot.com/2018/10/11.html */
	</script>
</body>
<jsp:include page="../base/footer.jsp" />
</html>
