package com.snapshare.web.mapper;

import java.util.List;

import com.snapshare.web.vo.BoardTagVo;
import com.snapshare.web.vo.TagVo;

/**
 * 게시물과 태그를 연결하는 보드태그 매퍼 인터페이스 
 */
public interface BoardTagMapperInterface {
	
	/**
	 * 해당 게시물에 달린 태그 조회 추상메소드
	 * @param boardId 조회할 게시물의 ID
	 * @return 게시물에 달린 태그 목록
	 */
	public List<TagVo> getTagsByBoardId(int boardId);
	
	/**
	 * 해당 게시물에 태그 추가 추상메소드
	 * @param boardId 태그를 추가할 게시물의 ID
	 * @param tagId 추가할 태그의 태그ID
	 * @return 추가된 행의 수
	 */
	public int addTagToBoard(BoardTagVo boardTagVo);
	
	
	/**
	 * 해당 게시물의 태그 삭제 추상메소드
	 * @param boardId 태그를 삭제할 게시물의 ID
	 * @param tagId 삭제할 태그의 ID
	 * @return 삭제된 행의 수
	 */
	public int deleteTagFromBoard(int boardId, int tagId);
}
