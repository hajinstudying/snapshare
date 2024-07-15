<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="now" value="<%= new java.util.Date() %>" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/style.css'/>?v=${now}" />
<link rel="stylesheet" type="text/css" href="<c:url value='/css/productInsertForm.css'/>?v=${now}" />
<%-- <script src='<c:url value="/ckeditor/config.js" />'></script> --%>
</head>
<body>
   <%-- 헤더부분 include 액션 태그 사용, c:url 사용금지, 경로 직접 지정해야함. --%>
   <div class="container">
        <main>
                <h3 id="insert-title">상품 등록</h3>
                <form action="<c:url value='/board/create'/>" method="post" enctype="multipart/form-data">
                    <div>
                        <label for="fileName">이미지 첨부</label>
                        <input type="file" id="file" name="file">
                    </div>
                    <input type="hidden" name="memberId" value="test">
                    <div>
                        <input type="submit" value="저장">
                        <input type="reset" value="다시쓰기">
                    </div>
                </form>
     
        </main>
    </div>
</body>
</html>
