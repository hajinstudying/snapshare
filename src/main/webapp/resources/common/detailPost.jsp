<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <div class="post-container">
    <div class="img-box">
        <img src="<c:url value='/resources/image/12.jpg'/>">
    </div>
    <div class="box1">
    <div class="reply-container">
        <div class="post-menu">
        <div class="menu-icon">
        	<div class="share-button">
                        <a href="#"><i class="fa-solid fa-arrow-up-from-bracket"></i></a>
                    </div>
                    <div class="more-button">
                        <a href="#"><i class="fa-solid fa-ellipsis"></i></a>
                    </div>
        	</div>
        </div>
        <div class="scrollable-content">
        <div class="user-info">
        <div class="user">
        사용자1
        </div>
        </div>
        
        <div class="aa"><p>댓글</p></div>
        
        
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
        <div class="reply-box">댓글입니다.</div>
	</div>
	</div>
	
	<div class="insert-box">
	<hr>
	<div class="reply-insert">
	
	<div class="ccc"style="height: 60px"><h3>어떠셨나요?</h3></div>
	<div class="reply-insert-box">
	<div class="input-box">
	<input />
	</div>
	</div>
	</div>
	
	</div>
	</div>
	
</div> --%>

<%-- <style>  
    .container1 {  
        display: flex;  
        width: 1061px;  
        border-radius: 30px;  
        box-shadow: 0 0 6px rgba(0, 0, 0, 0.1);  
    }  
    .image {  
        flex: 1;  
        background-color: #ddd;  
        height: auto; /* 이미지의 높이에 맞게 */  
        max-height: 100%; /* 이미지가 컨테이너를 넘어가지 않도록 */  
    }  
    .comments-section {  
        flex: 1;  
        display: flex;  
        flex-direction: column;  
        align-items: stretch; /* 자식 요소의 높이를 부모 요소에 맞게 늘림 */  
    }  
    .menu-bar {  
        position: sticky;  
        top: 0;  
        background-color: #fff;  
        height: 90px;  
        border-radius: 30px;  
        z-index: 10;  
    }  
    .comments {  
        flex: 1;  
        overflow: auto;  
        background-color: #f1f1f1;  
        padding: 10px;  
    }  
    .comment-input {  
        position: sticky;  
        bottom: 0;  
        background-color: #fff;  
        z-index: 10;  
        height: 130px;  
        border-radius: 0 0 0 30px;  
    }  
    .reply {  
    	height: 50px;
        margin-bottom: 10px;  
    }  
</style>  

<div class="container1">  
    <div class="image">  
        <!-- 이미지가 들어갈 곳 -->  
        <img id="mainImage" src="<c:url value='/resources/image/14.jpg'/>" alt="이미지" style="width: 100%; height: auto;">  
    </div>  
    <div class="comments-section">  
        <div class="menu-bar">  
            <!-- 메뉴바가 들어갈 곳 -->  
            메뉴바  
        </div>  
        <div class="comments">  
            <div class="reply">댓글입니다.</div>
            <div class="reply">댓글입니다.</div>
            <div class="reply">댓글입니다.</div>
            <div class="reply">댓글입니다.</div>
            <div class="reply">댓글입니다.</div>
            <div class="reply">댓글입니다.</div>
            <div class="reply">댓글입니다.</div>
        </div>  
        <div class="comment-input">  
            <!-- 댓글 입력창이 들어갈 곳 -->  
            댓글 입력창  
        </div>  
    </div>  
</div>  

<script>  
    window.addEventListener('DOMContentLoaded', () => {  
        adjustContainerHeight();  
    });  

    function adjustContainerHeight() {  
        const imageElement = document.getElementById('mainImage');  
        imageElement.addEventListener('load', function() {  
            const imageHeight = imageElement.clientHeight;  
            document.querySelector('.container1').style.height = `${imageHeight}px`;  
            document.querySelector('.comments-section').style.height = `calc(100% - 90px - 130px)`;  
        });  
    }  
</script>  --%>

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
  	justify-content:center; 
    align-items : center;
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

.more-btn,
.share-btn {
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

.menu-box .share-btn:hover,
.menu-box .more-btn:hover {
  background-color: #f0f0f0;
}

  .scroll-container {
    overflow: auto;
    
    padding: 0 0 0 20px;
    background-color: #fff;
    flex-grow: 1;
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
</style>

<div class="container1">
  <div class="img-box">
    <img src="<c:url value='/resources/image/14.jpg'/>">
  </div>
  <div class="info-container">
    <div class="new-container">
      <div class="menu-box">
        <div class="share-btn"><a href="#"><i class="fa-solid fa-arrow-up-from-bracket"></i></a></div>
        <div class="more-btn"><a href="#"><i class="fa-solid fa-ellipsis"></i></a></div>
      </div>
      <div class="scroll-container">
      	<div class="user-infoBox"><p>사용자1</p></div>
      	<h4 style="margin-bottom:20px;">댓글</h4>
        <div class="reply">댓글입니다.</div>
        <div class="reply">댓글입니다.</div>
        <div class="reply">댓글입니다.</div>
      </div>
    </div>
    <div class="reply-insert">
      <div class="ccc"style="height: 60px;"><h3>어떠셨나요?</h3></div>
	<div class="reply-insert-box">
	<div class="input-box">
	<input />
	</div>
	</div>
    </div>
  </div>
</div>

<div class="more"><h3>더 찾아보기</h3></div>
