package com.snapshare.web.service;

import java.util.List;

import com.snapshare.web.vo.BoardVo;


/**
 * BoardService 인터페이스
 */
public interface BoardService {
	
	// 게시물 상세보기 추상메소드 (매퍼메소드)
	public BoardVo getBoard(int boardId);
	// 게시물 목록보기 추상메소드
	public List<BoardVo> listBoard();
	// 게시물 등록 추상메소드
	public int createBoard(BoardVo boardVo);
	// 게시물 삭제 추상메소드
	public int deleteBoard(int boardId);
}