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
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/board-original.css' />?v=${now}" />
	<script src="https://kit.fontawesome.com/6e1082867c.js" crossorigin="anonymous"></script> <!-- 아이콘 -->
</head>
<body>
	<jsp:include page="/resources/common/header.jsp" />
<jsp:include page="/resources/common/detailPost.jsp" />
	<!-- 임시로 만들어둠 나중에 c:forEach로 반복문돌림 -->
	<!-- <div id="detailPost"></div> -->
    <div class="container">
    
			<div class="box">
			<div class="bookmark-button"><a href=#><i class="fa-solid fa-bookmark"></i></a></div> <!-- 북마크 버튼 -->
			<img id="clickImage" src="<c:url value='/resources/image/14.jpg'/>" />
			<%-- <div class="info"><img src="<c:url value='/resources/image/user.jpeg'/>"><p>사용자</p></div> --%>
			<div class="download-button"><a href=#><i class="fa-solid fa-download"></i></a></div> <!-- 다운로드 버튼 -->
			<div class="share-button"><a href=#><i class="fa-solid fa-arrow-up-from-bracket"></a></i></div> <!-- 공유 버튼 -->
			<div class="more-button"><a href=#><i class="fa-solid fa-ellipsis"></i></a></div> <!-- 더보기 버튼 -->
			</div>
			
			<div class="box">
			<div class="bookmark-button"><a href=#><i class="fa-solid fa-bookmark"></i></a></div> <!-- 북마크 버튼 -->
			<img src="<c:url value='/resources/image/13.jpg'/>" />
			<%-- <div class="info"><img src="<c:url value='/resources/image/user.jpeg'/>"><p>사용자</p></div> --%>
			<div class="download-button"><a href=#><i class="fa-solid fa-download"></i></a></div> <!-- 다운로드 버튼 -->
			<div class="share-button"><a href=#><i class="fa-solid fa-arrow-up-from-bracket"></a></i></div> <!-- 공유 버튼 -->
			<div class="more-button"><a href=#><i class="fa-solid fa-ellipsis"></i></a></div> <!-- 더보기 버튼 -->
			</div>
			
			<div class="box">
			<div class="bookmark-button"><a href=#><i class="fa-solid fa-bookmark"></i></a></div> <!-- 북마크 버튼 -->
			<img src="<c:url value='/resources/image/7.jpg'/>" />
			<%-- <div class="info"><img src="<c:url value='/resources/image/user.jpeg'/>"><p>사용자</p></div> --%>
			<div class="download-button"><a href=#><i class="fa-solid fa-download"></i></a></div> <!-- 다운로드 버튼 -->
			<div class="share-button"><a href=#><i class="fa-solid fa-arrow-up-from-bracket"></a></i></div> <!-- 공유 버튼 -->
			<div class="more-button"><a href=#><i class="fa-solid fa-ellipsis"></i></a></div> <!-- 더보기 버튼 -->
			</div>	
			
			<div class="box">
			<div class="bookmark-button"><a href=#><i class="fa-solid fa-bookmark"></i></a></div> <!-- 북마크 버튼 -->
			<img src="<c:url value='/resources/image/1.jpg'/>" />
			<%-- <div class="info"><img src="<c:url value='/resources/image/user.jpeg'/>"><p>사용자</p></div> --%>
			<div class="download-button"><a href=#><i class="fa-solid fa-download"></i></a></div> <!-- 다운로드 버튼 -->
			<div class="share-button"><a href=#><i class="fa-solid fa-arrow-up-from-bracket"></a></i></div> <!-- 공유 버튼 -->
			<div class="more-button"><a href=#><i class="fa-solid fa-ellipsis"></i></a></div> <!-- 더보기 버튼 -->
			</div>	
			
			<div class="box">
			<div class="bookmark-button"><a href=#><i class="fa-solid fa-bookmark"></i></a></div> <!-- 북마크 버튼 -->
			<img src="<c:url value='/resources/image/5.jpg'/>" />
			<%-- <div class="info"><img src="<c:url value='/resources/image/user.jpeg'/>"><p>사용자</p></div> --%>
			<div class="download-button"><a href=#><i class="fa-solid fa-download"></i></a></div> <!-- 다운로드 버튼 -->
			<div class="share-button"><a href=#><i class="fa-solid fa-arrow-up-from-bracket"></a></i></div> <!-- 공유 버튼 -->
			<div class="more-button"><a href=#><i class="fa-solid fa-ellipsis"></i></a></div> <!-- 더보기 버튼 -->
			</div>
			
			<div class="box">
			<div class="bookmark-button"><a href=#><i class="fa-solid fa-bookmark"></i></a></div> <!-- 북마크 버튼 -->
			<img src="<c:url value='/resources/image/3.jpg'/>" />
			<%-- <div class="info"><img src="<c:url value='/resources/image/user.jpeg'/>"><p>사용자</p></div> --%>
			<div class="download-button"><a href=#><i class="fa-solid fa-download"></i></a></div> <!-- 다운로드 버튼 -->
			<div class="share-button"><a href=#><i class="fa-solid fa-arrow-up-from-bracket"></a></i></div> <!-- 공유 버튼 -->
			<div class="more-button"><a href=#><i class="fa-solid fa-ellipsis"></i></a></div> <!-- 더보기 버튼 -->
			</div>
			
			<div class="box">
			<div class="bookmark-button"><a href=#><i class="fa-solid fa-bookmark"></i></a></div> <!-- 북마크 버튼 -->
			<img src="<c:url value='/resources/image/6.jpg'/>" />
			<%-- <div class="info"><img src="<c:url value='/resources/image/user.jpeg'/>"><p>사용자</p></div> --%>
			<div class="download-button"><a href=#><i class="fa-solid fa-download"></i></a></div> <!-- 다운로드 버튼 -->
			<div class="share-button"><a href=#><i class="fa-solid fa-arrow-up-from-bracket"></a></i></div> <!-- 공유 버튼 -->
			<div class="more-button"><a href=#><i class="fa-solid fa-ellipsis"></i></a></div> <!-- 더보기 버튼 -->
			</div>
			
			<div class="box">
			<div class="bookmark-button"><a href=#><i class="fa-solid fa-bookmark"></i></a></div> <!-- 북마크 버튼 -->
			<img src="<c:url value='/resources/image/8.jpg'/>" />
			<%-- <div class="info"><img src="<c:url value='/resources/image/user.jpeg'/>"><p>사용자</p></div> --%>
			<div class="download-button"><a href=#><i class="fa-solid fa-download"></i></a></div> <!-- 다운로드 버튼 -->
			<div class="share-button"><a href=#><i class="fa-solid fa-arrow-up-from-bracket"></a></i></div> <!-- 공유 버튼 -->
			<div class="more-button"><a href=#><i class="fa-solid fa-ellipsis"></i></a></div> <!-- 더보기 버튼 -->
			</div>
			
			<div class="box">
			<div class="bookmark-button"><a href=#><i class="fa-solid fa-bookmark"></i></a></div> <!-- 북마크 버튼 -->
			<img src="<c:url value='/resources/image/9.jpg'/>" />
			<%-- <div class="info"><img src="<c:url value='/resources/image/user.jpeg'/>"><p>사용자</p></div> --%>
			<div class="download-button"><a href=#><i class="fa-solid fa-download"></i></a></div> <!-- 다운로드 버튼 -->
			<div class="share-button"><a href=#><i class="fa-solid fa-arrow-up-from-bracket"></a></i></div> <!-- 공유 버튼 -->
			<div class="more-button"><a href=#><i class="fa-solid fa-ellipsis"></i></a></div> <!-- 더보기 버튼 -->
			</div>
			
			<div class="box">
			<div class="bookmark-button"><a href=#><i class="fa-solid fa-bookmark"></i></a></div> <!-- 북마크 버튼 -->
			<img src="<c:url value='/resources/image/10.jpg'/>" />
			<%-- <div class="info"><img src="<c:url value='/resources/image/user.jpeg'/>"><p>사용자</p></div> --%>
			<div class="download-button"><a href=#><i class="fa-solid fa-download"></i></a></div> <!-- 다운로드 버튼 -->
			<div class="share-button"><a href=#><i class="fa-solid fa-arrow-up-from-bracket"></a></i></div> <!-- 공유 버튼 -->
			<div class="more-button"><a href=#><i class="fa-solid fa-ellipsis"></i></a></div> <!-- 더보기 버튼 -->
			</div>
			
			<div class="box">
			<div class="bookmark-button"><a href=#><i class="fa-solid fa-bookmark"></i></a></div> <!-- 북마크 버튼 -->
			<img src="<c:url value='/resources/image/11.jpg'/>" />
			<%-- div class="info"><img src="<c:url value='/resources/image/user.jpeg'/>"><p>사용자</p></div> --%>
			<div class="download-button"><a href=#><i class="fa-solid fa-download"></i></a></div> <!-- 다운로드 버튼 -->
			<div class="share-button"><a href=#><i class="fa-solid fa-arrow-up-from-bracket"></a></i></div> <!-- 공유 버튼 -->
			<div class="more-button"><a href=#><i class="fa-solid fa-ellipsis"></i></a></div> <!-- 더보기 버튼 -->
			</div>
			
			<div class="box">
			<div class="bookmark-button"><a href=#><i class="fa-solid fa-bookmark"></i></a></div> <!-- 북마크 버튼 -->
			<img src="<c:url value='/resources/image/12.jpg'/>" />
			<%-- <div class="info"><img src="<c:url value='/resources/image/user.jpeg'/>"><p>사용자</p></div> --%>
			<div class="download-button"><a href=#><i class="fa-solid fa-download"></i></a></div> <!-- 다운로드 버튼 -->
			<div class="share-button"><a href=#><i class="fa-solid fa-arrow-up-from-bracket"></a></i></div> <!-- 공유 버튼 -->
			<div class="more-button"><a href=#><i class="fa-solid fa-ellipsis"></i></a></div> <!-- 더보기 버튼 -->
			</div>
			
			<div class="box">
			<div class="bookmark-button"><a href=#><i class="fa-solid fa-bookmark"></i></a></div> <!-- 북마크 버튼 -->
			<img src="<c:url value='/resources/image/2.jpg'/>" />
			<%-- <div class="info"><img src="<c:url value='/resources/image/user.jpeg'/>"><p>사용자</p></div> --%>
			<div class="download-button"><a href=#><i class="fa-solid fa-download"></i></a></div> <!-- 다운로드 버튼 -->
			<div class="share-button"><a href=#><i class="fa-solid fa-arrow-up-from-bracket"></a></i></div> <!-- 공유 버튼 -->
			<div class="more-button"><a href=#><i class="fa-solid fa-ellipsis"></i></a></div> <!-- 더보기 버튼 -->
			</div>
			
			<div class="box">
			<div class="bookmark-button"><a href=#><i class="fa-solid fa-bookmark"></i></a></div> <!-- 북마크 버튼 -->
			<img src="<c:url value='/resources/image/4.jpg'/>" />
			<%-- <div class="info"><img src="<c:url value='/resources/image/user.jpeg'/>"><p>사용자</p></div> --%>
			<div class="download-button"><a href=#><i class="fa-solid fa-download"></i></a></div> <!-- 다운로드 버튼 -->
			<div class="share-button"><a href=#><i class="fa-solid fa-arrow-up-from-bracket"></a></i></div> <!-- 공유 버튼 -->
			<div class="more-button"><a href=#><i class="fa-solid fa-ellipsis"></i></a></div> <!-- 더보기 버튼 -->
			</div>
			
			<div class="box">
			<div class="bookmark-button"><a href=#><i class="fa-solid fa-bookmark"></i></a></div> <!-- 북마크 버튼 -->
			<img src="<c:url value='/resources/image/15.jpg'/>" />
			<%-- <div class="info"><img src="<c:url value='/resources/image/user.jpeg'/>"><p>사용자</p></div> --%>
			<div class="download-button"><a href=#><i class="fa-solid fa-download"></i></a></div> <!-- 다운로드 버튼 -->
			<div class="share-button"><a href=#><i class="fa-solid fa-arrow-up-from-bracket"></a></i></div> <!-- 공유 버튼 -->
			<div class="more-button"><a href=#><i class="fa-solid fa-ellipsis"></i></a></div> <!-- 더보기 버튼 -->
			</div>
			
			<div class="box">
			<div class="bookmark-button"><a href=#><i class="fa-solid fa-bookmark"></i></a></div> <!-- 북마크 버튼 -->
			<img src="<c:url value='/resources/image/44.jpg'/>" />
			<%-- <div class="info"><img src="<c:url value='/resources/image/user.jpeg'/>"><p>사용자</p></div> --%>
			<div class="download-button"><a href=#><i class="fa-solid fa-download"></i></a></div> <!-- 다운로드 버튼 -->
			<div class="share-button"><a href=#><i class="fa-solid fa-arrow-up-from-bracket"></a></i></div> <!-- 공유 버튼 -->
			<div class="more-button"><a href=#><i class="fa-solid fa-ellipsis"></i></a></div> <!-- 더보기 버튼 -->
			</div>
	</div>
</body>
</html>
