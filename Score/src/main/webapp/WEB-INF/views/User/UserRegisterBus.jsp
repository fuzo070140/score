<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="../base/header.jsp" />
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<head>
<meta charset="UTF-8">
<title>UserRegister</title>

</head>
<body>
	<div class="container container-main">
		<div class="page-header">
			<div class="col-md-6 col-md-offset-3">
				<h3>기업용 회원가입</h3>
			</div>
		</div>
		<div class="col-sm-6 col-md-offset-3">
			<form action="/score/User/register" method="post" enctype="multipart/form-data" id="registerForm">
				<input type="hidden" name="userCategory" value="bus" id="userCategory">
				<label for="userID">아이디</label>	
				<div class="form-group">
					<input type="text" class="form-control" id="userID" placeholder="아이디를 입력해 주세요" name="userID" autocomplete="username" style="width: 60%; display: inline;">
					<button type="button" class="btn btn-primary" id="userIDCheckBtn">아이디 중복확인</button>
				</div>
				<label for="userPassWord">비밀번호</label>
				<div class="form-group">
					 <input type="password" class="form-control" id="userPassWord" placeholder="비밀번호를 입력해주세요" name="userPassWord" autocomplete="new-password">
				</div>
				<label for="userPassWordFin">비밀번호 확인</label>
				<div class="form-group">
					 <input type="password" class="form-control" id="userPassWordFin" placeholder="비밀번호 확인을 위해 다시한번  입력해주세요" autocomplete="current-password">
				</div>
				<label for="userNickName">닉네임</label>
				<div class="form-group">
					<input type="text" class="form-control" id="userNickName" placeholder="닉네임을 입력해주세요" name="userNickName" style="width: 60%; display: inline;">
					<button type="button" class="btn btn-primary" id="userNickNameCheckBtn">닉네임 중복확인</button>
				</div>
				<label for="userCompanyName">기업명</label>
				<div class="form-group">
					 <input type="text" class="form-control" id="userCompanyName" placeholder="기업명을 입력해주세요" name="userCompanyName">
				</div>
				<label for="userCompanyNumber">사업자 등록번호</label>
				<div class="form-group">
					 <input type="text" class="form-control" id="userCompanyNumber" placeholder="사업자 번호를 입력해주세요" name="userCompanyNumber">
				</div>
				<label for="userCompanyAddress">사업자 주소</label>
				<div class="form-group">
					<input class="form-control" style="width: 60%; display: inline;" placeholder="우편번호" name="addr1" id="addr1" type="text" readonly="readonly">
					<button type="button" class="btn btn-primary" onclick="execPostCode();">
						<i class="fa fa-search"></i> 우편번호 찾기
					</button>
				</div>
				<div class="form-group">
					<input class="form-control" style="top: 5px;" placeholder="도로명 주소 또는 지번 주소" name="addr2" id="addr2" type="text" readonly="readonly" />
				</div>
				<div class="form-group">
					<input class="form-control" placeholder="상세주소" name="addr3" id="addr3" type="text" />
				</div>
				<label for="userManager">담당자</label>
				<div class="form-group">
					 <input type="text" class="form-control" id="userManager" placeholder="담당자 성함을 입력해주세요" name="userManager">
				</div>
				<label for="userManagerPhone">담당자 연락처</label>
				<div class="form-group">
					 <input type="text" class="form-control" id="userManagerPhone" placeholder="담당자 연락처를 입력해주세요" name="userManagerPhone">
				</div>
				<label for="userEmail">담당자 이메일</label>
				<div class="form-group">
					 <input type="text" class="form-control" id="userEmail" placeholder="담당자 이메일을 입력해주세요" name="userEmail" style="width: 60%; display: inline;">
					<button type="button" class="btn btn-primary" id="emailCheckBtn">이메일 인증번호 발송</button>
				</div>
				<label for="emailCode">인증번호</label>
				<div class="form-group">
					 <input type="text" class="form-control" id="emailCode" placeholder="인증번호를 입력해주세요" style="width: 60%; display: inline;">
					<button type="button" class="btn btn-primary" id="emailAuthBtn">이메일 인증번호 확인</button>
				</div>
				<label for="userIntro">기업소개</label>
				<div class="form-group">
					 <input type="text" class="form-control" id="userIntro" placeholder="기업소개를 해주세요" name="userIntro">
				</div>
				<label for="gameImg">썸네일</label>
				<div class="form-group">
					 <input type="file" class="" id="gameImg" name="file" placeholder="기업이미지를 넣어주세요 필수는 아닙니다" name="userThumbImg">
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
		function register() {
			$("#registerForm").submit();
		}
		function execPostCode() {
			new daum.Postcode({
				oncomplete : function(data) {
					// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

					// 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
					// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
					var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
					var extraRoadAddr = ''; // 도로명 조합형 주소 변수

					// 법정동명이 있을 경우 추가한다. (법정리는 제외)
					// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
					if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
						extraRoadAddr += data.bname;
					}
					// 건물명이 있고, 공동주택일 경우 추가한다.
					if (data.buildingName !== '' && data.apartment === 'Y') {
						extraRoadAddr += (extraRoadAddr !== '' ? ', '
								+ data.buildingName : data.buildingName);
					}
					// 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
					if (extraRoadAddr !== '') {
						extraRoadAddr = ' (' + extraRoadAddr + ')';
					}
					// 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
					if (fullRoadAddr !== '') {
						fullRoadAddr += extraRoadAddr;
					}

					// 우편번호와 주소 정보를 해당 필드에 넣는다.
					console.log(data.zonecode);
					console.log(fullRoadAddr);

					$("[name=addr1]").val(data.zonecode);
					$("[name=addr1]").attr('readonly', true);
					$("[name=addr2]").val(fullRoadAddr);
					$("[name=addr2]").attr('readonly', true);

					/* document.getElementById('signUpUserPostNo').value = data.zonecode; //5자리 새우편번호 사용
					document.getElementById('signUpUserCompanyAddress').value = fullRoadAddr;
					document.getElementById('signUpUserCompanyAddressDetail').value = data.jibunAddress; */
				}
			}).open();
		}
	</script>
</body>
<jsp:include page="../base/footer.jsp" />
</html>
