<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
	<header class="header">
	 <div class="login">
            <a class="create" href="#">만들기</a>
            <a class="home" href="#">홈</a>
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
	