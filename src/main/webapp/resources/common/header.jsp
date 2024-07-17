<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/header.css' />?v=${now}" />
	<header class="header">
	 <div class="login">
            <a class="create" href="<c:url value='/board/create'/>">만들기</a>
            <a class="home" href="<c:url value='/bookmark/list'/>">북마크</a>
            <a class="home" href="<c:url value='/login'/>">로그인</a>
        </div>
        
        <div class="search-box">
            <i class="fa-solid fa-magnifying-glass"></i>
            <input type="text" placeholder="검색어를 입력하세요">
        </div>
       <div class="logo">
            <a href="#">SNAPSHARE</a>
        </div>
    </header>
    <script>
    document.addEventListener('DOMContentLoaded', function() {
        const searchBox = document.querySelector('.search-box');
        const searchInput = searchBox.querySelector('input');

        searchInput.addEventListener('focus', function() {
            searchBox.classList.add('active');
        });

        searchInput.addEventListener('blur', function() {
            searchBox.classList.remove('active');
        });
    });

    </script>
	