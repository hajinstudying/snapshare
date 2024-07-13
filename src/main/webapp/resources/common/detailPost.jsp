<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="detailPost-container">

	<div class="post-box">
		<!-- 테스트용 이미지 -->
		<img id="clickImage" src="<c:url value='/resources/image/10.jpg'/>" />

		<div class="info-box">
			<div class="post-menu">
				<div class="share-button"><a href=#><i class="fa-solid fa-arrow-up-from-bracket"></a></i></div> <!-- 공유 버튼 -->
				<div class="more-button"><a href=#><i class="fa-solid fa-ellipsis"></i></a></div> <!-- 더보기 버튼 -->
			</div>
			<div class="post-title">
				<h1>Title</h1>
			</div>
			<div class="reply-container">
			<div class="user-info">
				<p>User1</p>
			</div>
			<div class="reply">
				<h4>댓글</h4>
			</div>
			<div class="reply-box">이 화면은 평소엔 안보이다가 이미지 클릭하면 뜸 (아직 구현안함)</div>
			<div class="reply-box">댓글입니다.</div>
			<div class="reply-box">댓글입니다.</div>
			<div class="reply-box">댓글입니다.</div>
			<div class="reply-box">댓글입니다.</div>
			<div class="reply-box">댓글입니다.</div>
			<div class="reply-box">댓글입니다.</div>
			<div class="reply-box">댓글입니다.</div>
			</div>
			
			<div class="reply-insert">
			<hr>
			<div class="reply-menu"><h3>어떠셨나요?</h3></div>
			<div class="input-box">
			<input type="text" />
			</div>
			</div>
		</div>
	</div>
</div>

<div class="more">
	<h3>더 찾아보기</h3>
</div>