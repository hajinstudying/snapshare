package com.snapshare.web.vo;

/**
 * 댓글 도메인 클래스
 * - 기존과 다르게 하나의 게시물 안에 들어가는 댓글들이므로 따로 뺐습니다. 
 */
public class Reply {
	
	private int replyId; 	 // 댓글id
	private int boardId; 	 // 게시물id
	private String memberId; // 회원id
	private int replyGroup;  // 게시물 그룹
	private int replyOrder;  // 그룹내 정렬순서
	private int replyIndent; // 들여쓰기
}
