<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="now" value="<%= new java.util.Date() %>" />

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Board Create</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <!-- Tagify CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tagify/4.0.0/tagify.css">
    <!-- Custom CSS -->
    <style>
        .container {
            margin-top: 50px;
        }
        .image-preview {
            max-width: 100%;
            height: 300px; /* 이미지 미리보기 영역 높이 설정 */
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 5px;
            background-color: #f0f0f0;
            transition: background-color 0.5s ease; /* 배경색 전환 애니메이션 */
        }
        .image-preview img {
            max-width: 100%;
            max-height: 100%;
            display: none;
            transition: background-color 3s ease; /* 배경색 전환 시간을 3초로 설정 */
        }
        .form-label {
            text-align: center; /* 라벨 텍스트 중앙 정렬 */
        }

    </style>
</head>
<body>
<jsp:include page="/resources/common/header.jsp" />
    <div class="container">
        <div class="row">
            <!-- Image Preview Section -->
            <div class="col-md-6">
                <div id="image-preview" class="image-preview">
                    <img id="image-preview-img" src="#" alt="Image Preview">
                </div>
            </div>
            <!-- 업로드 & 태그 -->
            <div class="col-md-6">
                <form>
                    <div class="form-group text-center mb-3">
					  <label for="formFile" class="form-label">이미지 올리기</label>
					</div>
					<div class="form-group col-9 mx-auto mb-3">  
					  <input class="form-control image-upload" type="file" id="formFile">
					</div>
                    <div class="form-group col-9 mx-auto mb-3">
                        <input class="form-control" name="tags" id="tags" placeholder="태그 추가하기">
                    </div>
                    <div class="d-grid gap-2 col-6 mx-auto mt-5">
                    	<button type="submit" class="btn btn-secondary">공유하기</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
    <!-- Tagify JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tagify/4.0.0/tagify.min.js"></script>
    <!-- Custom JS -->
    <script>
$(document).ready(function() {
    var colorChangeInterval;

    function startColorChange() {
        colorChangeInterval = setInterval(changeColor, 5000); // 5초마다 색상 변경
    }

    function stopColorChange() {
        clearInterval(colorChangeInterval);
    }

    function changeColor() {
        var newColor = getRandomColor();
        $('#image-preview').css('background-color', newColor);
    }

    function getRandomColor() {
        return 'hsl(' + Math.random() * 360 + ', 100%, 75%)';
    }

    // 초기 색상 설정
    $('.image-preview').css('background-color', getRandomColor());
    startColorChange();

    $(".image-upload").change(function() {
        var input = this;
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function(e) {
                $('#image-preview-img').attr('src', e.target.result).show();
                $('#image-preview').css('background', 'none');
                stopColorChange();
            }
            reader.readAsDataURL(input.files[0]);
        } else {
            $('#image-preview-img').hide();
            $('#image-preview').css('background-color', getRandomColor());
            startColorChange();
        }
    });

    // Tagify 초기화
    var input = document.querySelector('input[name=tags]');
    new Tagify(input);
});
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>