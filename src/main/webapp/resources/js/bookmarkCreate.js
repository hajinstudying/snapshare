$(document).ready(function() {
    $('.bookmark-link').click(function(event) {
        event.preventDefault(); 

        var boardId = $(this).data('board-id');
        var memberId = $(this).data('member-id');
        
        createBookmark(boardId, memberId);
    });
});

function createBookmark(boardId, memberId) {
    $.ajax({
        type: 'POST', 
        url: '/bookmark/create', // 포스트 매핑 엔드포인트 경로
        contentType: 'application/json',
        data: JSON.stringify({
            boardId: boardId,
            memberId: memberId
        }),
        success: function(response) {
            alert('북마크가 추가되었습니다!');
        },
        error: function(xhr, status, error) {
            alert('북마크 추가에 실패했습니다.');
            console.error('Error:', error);
        }
    });
}
