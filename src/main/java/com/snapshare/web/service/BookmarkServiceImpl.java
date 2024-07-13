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
public class BookmarkServiceImpl implements BookmarkService {

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
    public int createBookmark(BookmarkVo bookmarkVo) {
        return bookmarkMapper.createBookmark(bookmarkVo);
    }

    @Override
    public int updateBookmark(BookmarkVo bookmarkVo) {
        return bookmarkMapper.updateBookmark(bookmarkVo);
    }

    @Override
    public int deleteBookmark(int bookmarkId) {
        return bookmarkMapper.deleteBookmark(bookmarkId);
    }

    @Override
    public int createBookmarkSelectKey(BookmarkVo bookmarkVo) {
        return bookmarkMapper.createBookmarkSelectKey(bookmarkVo);
    }
}
