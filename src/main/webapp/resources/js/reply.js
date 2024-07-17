$(document).ready(function() {
            loadReplyList(); // 페이지 로드 시 댓글 목록을 가져옴
        });
        
        // 댓글 목록을 불러오는 함수
        function loadReplyList() {
            $.ajax({
                url: '/api/reply/list',
                type: 'GET',
                success: function(data) {
                    var replyListDiv = $('#replyList');
                    replyListDiv.empty(); // 기존 목록 비우기
                    
                    $.each(data, function(index, reply) {
                        var replyHtml = '<div>';
                        replyHtml += '<p>작성자: ' + reply.memberId + '</p>';
                        replyHtml += '<p>내용: ' + reply.content + '</p>';
                        replyHtml += '<button onclick="editReply(' + reply.replyId + ')">수정</button>';
                        replyHtml += '<button onclick="deleteReply(' + reply.replyId + ')">삭제</button>';
                        replyHtml += '</div>';
                        replyListDiv.append(replyHtml);
                    });
                }
            });
        }
        
        // 댓글 생성 함수
        function createReply() {
            var title = $('#title').val();
            var memberId = $('#memberId').val();
            var content = $('#content').val();
            
            var data = {
                title: title,
                memberId: memberId,
                content: content
            };
            
            $.ajax({
                url: '/api/reply/create',
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify(data),
                success: function() {
                    loadReplyList(); // 생성 후 목록 새로고침
                    clearForm(); // 폼 초기화
                }
            });
        }
        
        // 댓글 수정 함수
        function editReply(replyId) {
            // 수정 로직 구현
        }
        
        // 댓글 삭제 함수
        function deleteReply(replyId) {
            $.ajax({
                url: '/api/reply/delete?replyId=' + replyId,
                type: 'DELETE',
                success: function() {
                    loadReplyList(); // 삭제 후 목록 새로고침
                }
            });
        }
        
        // 폼 초기화 함수
        function clearForm() {
            $('#title').val('');
            $('#content').val('');
        }