package com.snapshare.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snapshare.web.mapper.BoardMapperInterface;
import com.snapshare.web.mapper.BoardTagMapperInterface;
import com.snapshare.web.mapper.TagMapperInterface;
import com.snapshare.web.vo.BoardTagVo;
import com.snapshare.web.vo.BoardVo;
import com.snapshare.web.vo.TagVo;

import lombok.extern.slf4j.Slf4j;

/**
 * 게시물 서비스 클래스
 */

@Slf4j
@Service
public class BoardSerivceImpl implements BoardService {

	@Autowired
	private BoardMapperInterface boardMapper;
	@Autowired
	private TagMapperInterface tagMapper;
	@Autowired
	private BoardTagMapperInterface boardTagMapper;
	
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
	public int createBoard(BoardVo boardVo, String tags) {
		log.info("boardServiceImpl의 createBoard()");
		
		// 게시물 등록
		boardMapper.createBoardSelectKey(boardVo);
		log.info("등록한 boardVo" + boardVo);
	    
		// 태그 처리
        if (tags != null && !tags.isEmpty()) {
            String[] tagArray = tags.split(",");
            for (String tagName : tagArray) {
                tagName = tagName.trim();
                if (!tagName.isEmpty()) {
                    // 태그 존재 여부 확인 및 생성
                    TagVo tagVo = tagMapper.getTag(tagName);
                    if (tagVo == null) {
                        // 태그가 존재하지 않으면 생성
                        tagVo = new TagVo();
                        tagVo.setTagName(tagName);
                        tagMapper.createTagSelectKey(tagVo); // 태그 생성
                        log.info("생성된 tagVo :" + tagVo);
                    }
                    
                    // 게시물과 태그 연결
                    BoardTagVo boardTagVo = new BoardTagVo();
                    boardTagVo.setBoardId(boardVo.getBoardId());
                    boardTagVo.setTagId(tagVo.getTagId());
                    int taggingResult = boardTagMapper.addTagToBoard(boardTagVo);
                    log.info("일. taggingResult : " + taggingResult);
                    log.info("이. boardVo.getBoardId() : " + boardVo.getBoardId());
                    if(taggingResult > 0) {
                    	log.info("boardTagVo : " + boardTagVo.toString());
                    } else {
                    	log.warn("태그 연결 실패, boardTagVo : " + boardTagVo.toString());
                    }
                }
            }
        }
		
		return boardVo.getBoardId();
	}
	
	/**
	 * 게시물 삭제 메소드
	 */
	@Override
	public int deleteBoard(int boardId) {
		return boardMapper.deleteBoard(boardId);
	}

}
