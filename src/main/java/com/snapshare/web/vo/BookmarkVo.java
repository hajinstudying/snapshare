package com.snapshare.web.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 북마크 도메인 클래스 
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BookmarkVo {
    
	private int bookmarkId;  // 북마크id
    private String memberId; // 회원id
    private int boardId;     // 게시물id
    
    public BookmarkVo(int boardId, String memberId) {
		this.memberId = memberId;
		this.boardId = boardId;
	}
}