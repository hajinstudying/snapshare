<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="now" value="<%= new java.util.Date() %>" />

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>boardList.jsp</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/board.css' />?v=${now}" />
    <style>
        @charset "UTF-8";
        body, html {
            margin: 0;
            padding: 0;
            font-family: 'Arial', sans-serif;
            background-color: #f0f2f5;
            overflow-x: hidden;
        }
        .container {
            display: flex;
            flex-wrap: wrap;
            min-height: 100vh;
            width: 100%;
        }
        .sidebar {
            width: 250px;
            background-color: #ff4081;
            color: white;
            display: flex;
            flex-direction: column;
            align-items: center;
            padding: 20px;
            transform: translateX(-250px);
            animation: slideIn 0.5s forwards;
            z-index: 10;
        }
        @keyframes slideIn {
            to {
                transform: translateX(0);
            }
        }
        .sidebar h2 {
            margin: 20px 0;
            font-size: 24px;
            transition: color 0.3s ease;
        }
        .sidebar nav {
            width: 100%;
        }
        .sidebar nav a {
            display: block;
            color: white;
            padding: 10px 15px;
            text-decoration: none;
            font-weight: bold;
            transition: background-color 0.3s ease, transform 0.3s ease;
        }
        .sidebar nav a:hover {
            background-color: #ff3366;
            transform: translateX(10px);
        }
        .main-content {
            flex-grow: 1;
            display: flex;
            flex-direction: column;
            transform: translateY(100vh);
            animation: contentSlideUp 0.5s 0.5s forwards;
            padding: 20px;
        }
        @keyframes contentSlideUp {
            to {
                transform: translateY(0);
            }
        }
        .top-bar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 20px;
            background-color: #fff;
            border-bottom: 1px solid #ddd;
        }
        .top-bar .user-profile {
            display: flex;
            align-items: center;
            margin-left: auto;
        }
        .top-bar .user-profile img {
            width: 40px;
            height: 40px;
            border-radius: 50%;
            margin-right: 10px;
            transition: transform 0.3s ease;
        }
        .top-bar .user-profile img:hover {
            transform: scale(1.1);
        }
        .top-bar .user-profile span {
            font-weight: bold;
            opacity: 0;
            animation: fadeIn 0.5s 1s forwards;
        }
        @keyframes fadeIn {
            to {
                opacity: 1;
            }
        }
        .dashboard {
            padding: 20px;
            background-color: #f0f2f5;
            flex-grow: 1;
            transform: translateY(100vh);
            animation: dashboardSlideUp 0.5s 0.5s forwards;
        }
        @keyframes dashboardSlideUp {
            to {
                transform: translateY(0);
            }
        }
        .dashboard h3 {
            margin-top: 0;
            font-size: 24px;
            animation: fadeIn 0.5s 1s forwards;
        }
        .dashboard .search-form {
            display: flex;
            justify-content: flex-end;
            margin-bottom: 20px;
        }
        .dashboard .search-form input[type="text"] {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-right: 10px;
            animation: fadeIn 0.5s 1s forwards;
        }
        .dashboard .search-form input[type="submit"] {
            padding: 10px 20px;
            background-color: #ff4081;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease, box-shadow 0.3s ease;
            animation: fadeIn 0.5s 1s forwards;
        }
        .dashboard .search-form input[type="submit"]:hover {
            background-color: #ff3366;
            box-shadow: 0 0 10px rgba(255, 51, 102, 0.5);
        }
        .dashboard table {
            width: 100%;
            border-collapse: collapse;
            background-color: #fff;
            border-radius: 5px;
            overflow: hidden;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            transition: transform 0.3s ease;
            animation: fadeIn 0.5s 1s forwards;
        }
        .dashboard table:hover {
            transform: translateY(-5px);
        }
        .dashboard table th, .dashboard table td {
            padding: 15px;
            border: 1px solid #ddd;
            text-align: left;
        }
        .dashboard table th {
            background-color: #f9f9f9;
            font-weight: bold;
        }
        .dashboard table caption {
            caption-side: top;
            font-size: 1.5em;
            margin-bottom: 10px;
        }
        .dashboard .reply-indent {
            padding-left: 20px;
        }
        .dashboard .create-post {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #ff4081;
            color: white;
            border: none;
            border-radius: 5px;
            text-decoration: none;
            transition: background-color 0.3s ease, transform 0.3s ease;
            animation: fadeIn 0.5s 1s forwards;
        }
        .dashboard .create-post:hover {
            background-color: #ff3366;
            transform: translateY(-5px);
        }
        @media (max-width: 768px) {
            .sidebar {
                width: 100%;
                transform: translateY(-250px);
                animation: slideDown 0.5s forwards;
            }
            @keyframes slideDown {
                to {
                    transform: translateY(0);
                }
            }
            .main-content {
                padding: 10px;
            }
        }
        @media (max-width: 480px) {
            .top-bar {
                flex-direction: column;
                align-items: flex-start;
            }
            .top-bar .user-profile {
                justify-content: space-between;
                width: 100%;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="sidebar">
            <h2>SNAPSHARE</h2>
            <nav>
                <a href="<c:url value='/logout' />">Logout</a>
            </nav>
        </div>
        <div class="main-content">
            <div class="top-bar">
                <div class="user-profile">
                    <span>ADMIN</span>
                </div>
            </div>
            <div class="dashboard">
                <form action="<c:url value='/board/list'/>" method="get" class="search-form">
                    <input type="text" name="keyword" placeholder="검색어 입력" />
                    <input type="submit" value="검색" />
                </form>
                
                <c:if test="${empty boardList}">
                    <p>게시물이 존재하지 않습니다.</p>
                </c:if>
                
                <c:if test="${not empty boardList}">
                    <table>
                        <caption>게시판 목록</caption>
                        <colgroup>
                            <col width="100" />
                            <col width="500" />
                            <col width="80" />
                            <col width="200" />
                            <col width="80" />
                        </colgroup>
                        <thead>
                            <tr>
                                <th>게시물</th>
                                <th>제목</th>
                                <th>작성자</th>
                                <th>작성일자</th>
                                <th>조회수</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="board" items="${boardList}" varStatus="idx">
                                <tr>
                                    <td><c:out value="${idx.count}"/></td>
                                    <td>
                                        <c:if test="${board.replyIndent > 0}">
                                            <span class="reply-indent">
                                                <img src="<c:url value='/resources/image/reply_icon.gif'/>" />
                                            </span>
                                        </c:if>
                                        <a href="<c:url value='/board/detail/${board.bno}'/>">
                                            <c:out value="${board.title}"/>
                                        </a>
                                    </td>
                                    <td><c:out value="${board.memberId}"/></td>
                                    <td><fmt:formatDate value="${board.regDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                                    <td><c:out value="${board.hitNo}"/></td>
                                </tr>
                            </c:forEach>
                            <tr>
                                <td align="center" colspan="5">${page_navigator}</td>
                            </tr>
                        </tbody>
                    </table>
                </c:if>
                <br>
                <a href="<c:url value='/board/create'/>" class="create-post">게시물 작성</a>
            </div>
        </div>
    </div>
</body>
</html>
