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
        return bookmarkMapper.getBookmark(bookmarkId);
    }

    @Override
    public List<BookmarkVo> listBookmark() {
        return bookmarkMapper.listBookmark();
    }

    @Override
    @Transactional
    public int createBookmark(String memberId, int boardId) {
        // 북마크 생성 및 board 테이블의 북마크 조회수 업데이트
        bookmarkMapper.createBookmark(memberId, boardId); // 북마크 추가
        return bookmarkMapper.updateBoardBookmarkCount(boardId); // board 테이블의 북마크 조회수 업데이트
    }

    @Override
    public int deleteBookmark(int bookmarkId) {
        return bookmarkMapper.deleteBookmark(bookmarkId);
    }

    @Override
    public int createBookmarkSelectKey(BookmarkVo bookmarkVo) {
        return bookmarkMapper.createBookmarkSelectKey(bookmarkVo);
    }

    @Override
    public int updateBoardBookmarkCount(int boardId) {
        return bookmarkMapper.updateBoardBookmarkCount(boardId);
    }
}
