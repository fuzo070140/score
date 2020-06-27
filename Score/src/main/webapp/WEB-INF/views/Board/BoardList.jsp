<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="../base/header.jsp" />
<head>
<meta charset="UTF-8">
<title>BoardList</title>

<link rel="stylesheet" href="/score/resources/css/Board/board-list.css">
</head>
<body>
	<div class="container container-main">
		<!-- <div class="main"> -->
		<table class="table table-hover">
			<thead>
				<tr class="table-active">
					<th scope="row">번호</th>
					<td>제목</td>
					<td>작성자</td>
					<td>작성일</td>
					<td>조회수</td>
				</tr>
			</thead>
			<c:forEach items="${list}" var="BoardVO">
				<tbody>
					<tr class="table-dark" onclick="boardRead(${BoardVO.boardNumber })">
						<th scope="row">${BoardVO.boardNumber }</th>
						<td><a id="boardReadTagA${BoardVO.boardNumber }" href='/score/Board/readPage${pageMaker.makeSearch(pageMaker.cri.page)}&boardNumber=${BoardVO.boardNumber}'>${BoardVO.boardTitle }</a>[${BoardVO.boardReplyPoint}]</td>
						<td>${BoardVO.userNickName }</td>
						<td>${BoardVO.boardRegDate }</td>
						<td>${BoardVO.boardViewPoint }</td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
		<ul class="pagination">
			<c:if test="${pageMaker.prev}">
				<li class="page-item"><a class="page-link"
					href="${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
			</c:if>
			<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
				<li class="page-item <c:out value="${pageMaker.cri.page == idx?'active':'시발아'}"/>">
					<a href="${pageMaker.makeSearch(idx)}" class="page-link">${idx}</a>
				</li>
			</c:forEach>
			<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
				<li class="page-item"><a class="page-link"
					href="${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
			</c:if>
		</ul>
		<a href="/score/Board/insert" class="btn btn-primary btn-lg">게시글 작성</a>
	</div>
	<script>
		//이동시 navbar 선택 변경
		$(document).ready(function() {
			$('a.page_main').removeClass("active");
			$('a.page_board').addClass("active");
		});
		
		//리스트 tr누르면 이동함
		function boardRead(boardNumber) {
			var href = $("#boardReadTagA"+boardNumber).attr("href");
			location.href = href;
		}
	</script>
</body>
<jsp:include page="/WEB-INF/views/base/footer.jsp" />
</html>