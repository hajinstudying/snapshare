package com.snapshare.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snapshare.web.repository.BoardMapperInterface;
import com.snapshare.web.vo.BoardVo;

import lombok.extern.slf4j.Slf4j;

/**
 * 게시물 서비스 클래스
 */

@Slf4j
@Service
public class BoardSerivceImpl implements BoardService {

	@Autowired
	private BoardMapperInterface boardMapper;
	
	/**
	 * 게시물 상세 조회 메소드
	 * - 조회수 증가 메소드를 트랜잭션으로 실행
	 */
	@Override
	@Transactional
	public BoardVo getBoard(int boardId) {
		boardMapper.incrementHitNo(boardId);
		return boardMapper.getBoard(boardId);
	}

	/**
	 * 게시물 목록 조회 메소드
	 */
	@Override
	public List<BoardVo> listBoard() {
		return boardMapper.listBoard();
	}

	/**
	 * 게시물 등록 메소드
	 */
	@Override
	@Transactional
	public int createBoard(BoardVo boardVo) {
		int result = boardMapper.createBoardSelectKey(boardVo);
		log.info("등록한 게시물의 boardId : " + boardVo.getBoardId());
		return result;
	}
	
	/**
	 * 게시물 삭제 메소드
	 */
	@Override
	public int deleteBoard(int boardId) {
		return boardMapper.deleteBoard(boardId);
	}

}
