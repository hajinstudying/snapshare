$(document).ready(function() {
    // 보드 이미지 클릭 이벤트 핸들러
    $('.board-image').on('click', function(event) {
        event.preventDefault(); // 기본 링크 동작을 막음

        var boardId = $(this).data('board-id'); // 클릭된 이미지의 데이터 속성에서 boardId 가져옴

        console.log('boardId:', boardId); // boardId 값 확인

        // AJAX 요청
        $.ajax({
            type: 'GET', // GET 메소드 사용
            url: '/bookmark/detail', // 보드 상세 페이지 URL
            data: {
                boardId: boardId // 전송할 데이터 (보드 ID)
            },
            success: function(response) {
                // 서버에서 성공적으로 응답을 받으면 이벤트를 처리
                console.log('서버 응답:', response);
                // 예를 들어, 이후에 추가적인 로직을 구현할 수 있습니다 (응답을 이용한 화면 업데이트 등)
                // 보드 상세 페이지로 이동하려면 주석 처리된 코드를 사용할 수 있습니다.
                // window.location.href = '/board/detail?boardId=' + boardId;
            },
            error: function(xhr, status, error) {
                // 오류 처리
                console.error('서버 요청 중 오류 발생:', error);
                alert('보드 상세 페이지를 불러오는 데 실패했습니다.');
            }
        });
    });
});
