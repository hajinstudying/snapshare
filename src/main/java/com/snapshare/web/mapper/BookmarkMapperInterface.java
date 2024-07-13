package com.snapshare.web.mapper;

import java.util.List;

import com.snapshare.web.vo.BookmarkVo;

public interface BookmarkMapperInterface {
	public BookmarkVo getBookmark(int bookmarkId);
	public List<BookmarkVo> listBookmark();
	public int addBookmark(BookmarkVo boardVo);
	public int updateBookmark(BookmarkVo boardVo);
	public int deleteBookmark(int bno);
	public int createBookmarkSelectKey(BookmarkVo boardVo);
}
