package com.snapshare.web.service;

import java.util.List;

import com.snapshare.web.vo.BookmarkVo;

public interface BookmarkService {
    public BookmarkVo getBookmark(int bookmarkId);
    public List<BookmarkVo> listBookmark();
    public int deleteBookmark(int bookmarkId);
    public int createBookmarkSelectKey(BookmarkVo bookmarkVo);
    
    // 북마크 추가 메소드
    public int createBookmark(String memberId, int boardId);
    
    // 게시글의 북마크 조회수 업데이트 메소드
    public int updateBoardBookmarkCount(int boardId);
}

