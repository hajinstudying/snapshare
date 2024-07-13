package com.snapshare.web.service;

import java.util.List;

import com.snapshare.web.vo.BookmarkVo;

public interface BookmarkService {
	public BookmarkVo getBookmark(int bookmarkId);
	public List<BookmarkVo> listBookmark();
	public int addBookmark(BookmarkVo boardVo);
	public int updateBookmark(BookmarkVo boardVo);
	public int deleteBookmark(int bno);
	public int createBookmarkSelectKey(BookmarkVo boardVo);
}
