<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%-- now : 현재 시간의 시분초를 now 변수에 세팅 --%>
<c:set var="now" value="<%=new java.util.Date()%>" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardList.jsp</title>
<%-- <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/board.css' />?v=${now}" /> --%>
<style>
.container1 {
	display: flex;
	border-radius: 30px;
	width: 1061px;
	margin: 20px auto;
	/* box-shadow: 0 0 6px rgba(0, 0, 0, 0.1); */
	box-shadow: rgba(0, 0, 0, 0.1) 0px 1px 20px 0px;
}

.menu-box a {
	display: flex;
	justify-content: center;
	align-items: center;
}

.img-box {
	width: 50%;
	height: auto;
}

.img-box img {
	width: 100%;
	height: auto;
	border-radius: 30px 0 0 30px;
}

.info-container {
	display: flex;
	flex-direction: column;
	justify-content: space-between;
	width: 50%;
	height: auto;
}

.menu-box, .reply-box {
	background-color: #f1f1f1;
	padding: 10px;
	width: 100%;
	text-align: center;
}

.new-container {
	flex-grow: 1;
	height: 100%;
	display: flex;
	flex-direction: column;
	justify-content: space-between;
	/* position: relative; */
}

.menu-box {
	display: flex;
	justify-content: flex-start; /* Align items to the left */
	align-items: center; /* Center items vertically */
	height: 90px;
	position: sticky;
	top: 0;
	align-self: flex-start;
	z-index: 1;
	padding: 0 0 0 20px;
	background-color: white;
	border-radius: 0 30px 0 0;
}

.more-btn, .share-btn {
	transition: background-color 0.3s ease;
	border-radius: 50%;
	width: 50px;
	height: 50px;
	display: flex;
	justify-content: center;
	align-items: center;
	text-align: center;
	margin-right: 10px;
}

.menu-box a {
	display: inline-block;
	color: black;
	text-decoration: none;
	width: 100%;
	height: 100%;
}

.menu-box .share-btn:hover, .menu-box .more-btn:hover {
	background-color: #f0f0f0;
}

.scroll-container {
	overflow: auto;
	max-height: 100vh;
}

.reply {
	margin-bottom: 15px;
}

.reply-insert {
	border-top: 1px solid #E9E9E9;
	background-color: white;
	border-radius: 0 0 30px 0;
	position: sticky;
	bottom: 0;
	padding: 0;
	text-align: center;
}

.reply-insert-box {
	padding: 10px 20px 20px 20px;
}

.reply-insert .input-box {
	width: 100%;
	height: 50px;
	border: 2.5px solid;
	border-color: #E9E9E9;
	border-radius: 30px;
}

.input-box input {
	width: 100%;
	height: 100%;
	border-radius: 30px;
	border-width: 0;
	padding: 0 0 0 20px;
}

.more {
	display: flex;
	justify-content: center; /* 가로 중앙 정렬 */
	align-items: center; /* 세로 중앙 정렬 */
	width: 100%;
	padding: 0 100px;
	margin-top: 40px;
	margin-bottom: 16px;
}

.ccc {
	padding: 20px 0 0 20px;
}

.ccc h3 {
	float: left;
}

.back {
	position: absolute;
	top: 110px;
	left: 20px;
}

.aa {
	height: 100%;
}

/* 태그 스타일 */
/* .tagBox{
	display:flex;
}
.tag{
	background-color: #e0e0e0;
	font-color:#333333;
	padding: 5px;
	border: none;
	border-radius: 30px;
	margin-right: 3px;
} */
</style>
<script src="https://cdn.jsdelivr.net/npm/@yaireo/tagify"></script>
<link href="https://unpkg.com/@yaireo/tagify/dist/tagify.css"
	rel="stylesheet" type="text/css" />
</head>

<body>
	<c:if test="${not empty message}">
		<script>
			alert('${message}');
		</script>
	</c:if>

	<div>
	<div class="container1">
		<div class="back">
			<i class="fa-solid fa-arrow-left-long" id="backButton"> 뒤로가기</i>
		</div>
		<div class="img-box">
			<img src="<c:url value='${filePath }/${fileName }'/>" />
		</div>
		<div class="info-container">
			<div class="new-container">
				<div class="menu-box">
					<div class="share-btn">
						<a href="#"><i class="fa-solid fa-arrow-up-from-bracket"></i></a>
					</div>
					<div class="more-btn">
						<a href="#"><i class="fa-solid fa-ellipsis"></i></a>
					</div>
				</div>
				<div class="aa">
					<div class="scroll-container">
						<!-- 태그를 표시할 요소 -->
						<div id="tagBox"></div>
						<div class="user-infoBox">
							<h3>
								<c:out value="${memberId }" />
							</h3>
						</div>
						<h4 style="margin-bottom: 20px;">댓글</h4>
						<div class="reply">댓글입니다.</div>
						<div class="reply">댓글입니다.</div>
						<div class="reply">댓글입니다.</div>
						<div class="reply">댓글입니다.</div>
						<div class="reply">댓글입니다.</div>
						<div class="reply">댓글입니다.</div>
						<div class="reply">댓글입니다.</div>
						<div class="reply">댓글입니다.</div>
						<div class="reply">댓글입니다.</div>
					</div>
				</div>
			</div>
			<div class="reply-insert">
				<div class="ccc" style="height: 60px;">
					<h3>어떠셨나요?</h3>
				</div>
				<div class="reply-insert-box">
					<div class="input-box">
						<input />
					</div>
				</div>
			</div>

		</div>
		<div class="more">
			<h3>더 찾아보기</h3>
		</div>
	</div>
	</div>
	<script>
		$(document).ready(function() {
			$('#backButton').click(function() {
				$('.a1').hide();
				$('html, body').animate({
					scrollTop : 0
				}, 'fast');
			});

			// 태그가 들어갈 곳
			var tagBox = $('#tagBox');

			// 서버에서 전달받은 tagNamesStr을 배열로 전환
			let tagNamesStr = "${tagNamesStr}";
			 if(tagNamesStr && tagNamesStr.trim() !== "") {
				let tagNames = tagNamesStr.split(',');
				//각 태그를 span태그로 붙임
				tagNames.forEach(function(tagName) {
				    tagBox.append('<span class="tag">' + tagName.trim() + '</span>');
				});				
			}
		});
	</script>
</body>
</html>
