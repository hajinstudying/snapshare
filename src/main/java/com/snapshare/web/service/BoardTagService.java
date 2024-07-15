package com.snapshare.web.service;

import java.util.List;

import com.snapshare.web.vo.TagVo;

/**
 * BoardTagService 인터페이스
 */
public interface BoardTagService {

	/**
	 * 해당 게시물에 달린 태그 조회 추상메소드
	 * @param boardId 조회할 게시물의 ID
	 * @return 게시물에 달린 태그 목록
	 */
	public List<TagVo> getTagsByBoardId(int boardId);
	
	/**
	 * 해당 게시물에 태그 추가 추상메소드
	 * @param boardId 태그를 추가할 게시물의 ID
	 * @param tagName 추가할 태그의 태그명
	 * @return 추가된 행의 수
	 */
	public int addTagToBoard(int boardId, String tagName);
	
	/**
	 * 해당 게시물의 태그 삭제 추상메소드
	 * @param boardId 태그를 삭제할 게시물의 ID
	 * @param tagId 삭제할 태그의 ID
	 * @return 삭제된 행의 수
	 */
	public int deleteTagFromBoard(int boardId, int tagId);
}
