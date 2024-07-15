package com.snapshare.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.snapshare.web.vo.BookmarkVo;

public interface BookmarkMapperInterface {
    BookmarkVo getBookmark(@Param("bookmarkId") int bookmarkId);
    List<BookmarkVo> listBookmark();
    int createBookmarkSelectKey(@Param("memberId") String memberId, @Param("boardId") int boardId);
    int deleteBookmark(@Param("bookmarkId") int bookmarkId);
    int createBookmarkSelectKey(BookmarkVo bookmarkVo);
    int updateBoardBookmarkCount(@Param("boardId") int boardId);
}
