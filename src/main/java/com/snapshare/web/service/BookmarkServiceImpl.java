package com.snapshare.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snapshare.web.mapper.BookmarkMapperInterface;
import com.snapshare.web.vo.BookmarkVo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookmarkServiceImpl implements BookmarkService{

	// 멤버 매퍼 인터페이스
//	@Autowired
//	private MemberMapperInterface memberMapper;
	
	@Autowired
	private BookmarkMapperInterface bookmarkMapper;
	
	@Override
	public BookmarkVo getBookmark(int bookmarkId) {
		BookmarkVo bookmarkVo = bookmarkMapper.getBookmark(bookmarkId);
		return bookmarkVo;
	}

	@Override
	public List<BookmarkVo> listBookmark() {
		return bookmarkMapper.listBookmark();
	}

	@Override
	@Transactional
	public int addBookmark(BookmarkVo bookmarkVo) {
		return bookmarkMapper.addBookmark(bookmarkVo);
	}

	@Override
	public int updateBookmark(BookmarkVo bookmarkVo) {
		return bookmarkMapper.updateBookmark(bookmarkVo);
	}

	@Override
	public int deleteBookmark(int bookmarkId) {
		return bookmarkMapper.deleteBookmark(bookmarkVo);
	}

	@Override
	public BookmarkVo getBookmark(int bookmarkId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookmarkVo> listBookmark() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addBookmark(BookmarkVo bookmarkVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBookmark(BookmarkVo bookmarkVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBookmark(int bookmarkId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int createBookmarkSelectKey(BookmarkVo boardVo) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
