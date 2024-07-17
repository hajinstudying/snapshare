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
</head>
<body>
    <jsp:include page="/resources/common/header.jsp" />
<<<<<<< HEAD
    <div class="container">
        <c:forEach var="bookmark" items="${bookmarkedBoards}">
            <div class="box">
                <div class="bookmark-button">
                    <a href="#" data-board-id="${bookmark.boardId}" data-member-id="${bookmark.memberId}" onclick="createBookmark(this)">
                        <i class="fa-solid fa-bookmark"></i>
                    </a>
                </div>
                <%-- <img id="clickImage" src="<c:url value='/resources/image/${bookmark.imageId}.jpg' />" />
                <div class="download-button"><a href="#"><i class="fa-solid fa-download"></i></a></div> <!-- 다운로드 버튼 -->
                <div class="share-button"><a href="#"><i class="fa-solid fa-arrow-up-from-bracket"></i></a></div> <!-- 공유 버튼 -->
                <div class="more-button"><a href="#"><i class="fa-solid fa-ellipsis"></i></a></div> <!-- 더보기 버튼 --> --%>
            </div>
        </c:forEach>
    </div>
    <!-- 자바스크립트 파일 추가 -->
    <script src="<c:url value='/resources/js/bookmark.js' />"></script>
</body>
</html>
=======
</html>
>>>>>>> reply
