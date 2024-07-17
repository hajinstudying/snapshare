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
</html>
