<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="detailPost-container">

	<div class="post-box">
		<!-- post번호 받아와서 이미지 출력 -->
		<img id="clickImage" src="<c:url value='/resources/image/10.jpg'/>" />

		<div class="info-box">
			<div class="post-menu">
				<div class="share-button"><a href=#><i class="fa-solid fa-arrow-up-from-bracket"></a></i></div> <!-- 공유 버튼 -->
				<div class="more-button"><a href=#><i class="fa-solid fa-ellipsis"></i></a></div> <!-- 더보기 버튼 -->
			</div>
			<div class="reply-container">
			<div class="user-info">
				<p>User1</p> <!-- member_id  -->
			</div>
			<div class="reply">
				<h4>댓글</h4>
			</div>
			<!-- post번호로 reply 받아와서 반복문으로 출력 -->
			<div class="reply-box">이 화면은 평소엔 안보이다가 이미지 클릭하면 뜸 (아직 구현안함)</div>
			<div class="reply-box">댓글입니다.</div>
			<div class="reply-box">댓글입니다.</div>
			<div class="reply-box">댓글입니다.</div>
			<div class="reply-box">댓글입니다.</div>
			<div class="reply-box">댓글입니다.</div>
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
			<div class="reply-menu"><h3>댓글 #개</h3></div>
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