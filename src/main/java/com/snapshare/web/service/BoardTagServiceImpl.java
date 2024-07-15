package com.snapshare.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snapshare.web.mapper.BoardMapperInterface;
import com.snapshare.web.mapper.BoardTagMapperInterface;
import com.snapshare.web.mapper.TagMapperInterface;
import com.snapshare.web.vo.TagVo;

import lombok.extern.slf4j.Slf4j;

/**
 * 보드태그 서비스 클래스 
 */

@Slf4j
@Service
public class BoardTagServiceImpl implements BoardTagService {
	
	@Autowired
	private BoardMapperInterface boardMapper;
	private TagMapperInterface tagMapper;
	private BoardTagMapperInterface boardTagMapper;
	
	
	/**
	 * 게시물에 등록된 태그 목록 조회 메소드
	 */
	@Override
	public List<TagVo> getTagsByBoardId(int boardId) {
		return boardTagMapper.getTagsByBoardId(boardId);
	}
	
	/**
	 * 게시물에 태그 추가 메소드
	 * - 해당 게시물에 이미 같은 태그가 추가되었는지 확인하는 절차 필요
	 * - 태그 테이블에 해당 tagName이 없다면 태그도 추가
	 * - boardTagMapper의 addTagToBoard()와는 달리 tagName을 파라미터로 받음
	 */
	@Transactional
	@Override
	public int addTagToBoard(int boardId, String tagName) {
		
	    // 태그 이름을 사용하여 태그를 조회
	    TagVo tagVo = tagMapper.getTag(tagName);
	    
	    if (tagVo == null) {
	        // 조회된 태그가 없으면 새로운 태그 생성
	        tagVo = new TagVo();
	        tagVo.setTagName(tagName);
	        int tagId = tagMapper.createTagSelectKey(tagVo);
	        tagVo.setTagName(tagName);
	        log.info("새로운 태그 등록 완료. tagVo: " + tagVo.toString());
	    }

	    // 이미 같은 태그가 추가되었는지 확인하는 로직 추가
	    List<TagVo> existingTags = boardTagMapper.getTagsByBoardId(boardId);
	    for (TagVo existingTag : existingTags) {
	        if (existingTag.getTagId() == tagVo.getTagId()) {
	            // 이미 해당 태그가 게시물에 추가되어 있는 경우
	            log.warn("이미 같은 태그가 추가되었습니다. boardId: " + boardId + ", tagId: " + tagVo.getTagId());
	            return 0;
	        }
	    }
	    
	    // 게시물에 태그 등록
	    int result = boardTagMapper.addTagToBoard(boardId, tagVo.getTagId());
	    if (result > 0) {
	        log.info("게시물에 태그 추가 완료. boardId: " + boardId + ", tagId: " + tagVo.getTagId());
	    } else {
	        log.error("게시물에 태그 추가 실패. boardId: " + boardId + ", tagId: " + tagVo.getTagId());
	    }
	    return result;
	}

	/**
	 * 게시물에서 태그 삭제 메소드
	 * - 해당 태그를 등록한 게시물이 없더라도 태그는 삭제하지 않음 
	 */
	@Transactional
	@Override
	public int deleteTagFromBoard(int boardId, int tagId) {
		return boardTagMapper.deleteTagFromBoard(boardId, tagId);
	}

}
