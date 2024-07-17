<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<c:set var="now" value="<%= new java.util.Date() %>" />
<html>
<head>
	<title>ShapShare</title>
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/board.css' />?v=${now}" />
	<script src="https://kit.fontawesome.com/6e1082867c.js" crossorigin="anonymous"></script> <!-- 아이콘 -->
	<script src="<c:url value='/resources/js/bookmarkCreate.js' />"></script>

	<!-- jQuery -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- 자바스크립트 파일 추가 -->
    <script src="<c:url value='/resources/js/bookmarkCreate.js' />"></script>
</head>
<body>
	<jsp:include page="/resources/common/header.jsp" />
<jsp:include page="/resources/common/detailPost.jsp" />
	<!-- 임시로 만들어둠 나중에 c:forEach로 반복문돌림 -->
	<!-- <div id="detailPost"></div> -->
    <div class="container">
    		<c:forEach items="${boardList}" var="board" varStatus="i">
			<div class="box">
				<!-- 북마크 버튼 -->
				<div class="bookmark-button">
					<a href="<c:url value='/bookmark/create' />" class="bookmark-link" data-board-id="${bookmark.boardId}" data-member-id="${bookmark.memberId}">
						<i class="fa-solid fa-bookmark"></i>
					</a>
				</div>

			<img id="clickImage" src="${filePath}/${board.fileName}" />
			<%-- <div class="info"><img src="<c:url value='/resources/image/user.jpeg'/>"><p>사용자</p></div> --%>
			<div class="download-button"><a href=#><i class="fa-solid fa-download"></i></a></div> <!-- 다운로드 버튼 -->
			<div class="share-button"><a href=#><i class="fa-solid fa-arrow-up-from-bracket"></a></i></div> <!-- 공유 버튼 -->
			<div class="more-button"><a href=#><i class="fa-solid fa-ellipsis"></i></a></div> <!-- 더보기 버튼 -->
			</div>
			</c:forEach>
	</div>
</body>
</html>