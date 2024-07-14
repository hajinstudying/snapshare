package com.snapshare.web.repository;

import java.util.List;

import com.snapshare.web.vo.BookmarkVo;

public interface BoardMapperInterface {
	public BookmarkVo getBookmark(int bookmarkId);
	public List<BookmarkVo> listBookmark();                   
	public int createBookmark(BookmarkVo boardVo);           
	public int updateBookmark(BookmarkVo boardVo);
	public int deleteBookmark(int bno);
	public int createBookmarkSelectKey(BookmarkVo boardVo);                            
                                   
}
                                               