package com.snapshare.web.mapper;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.snapshare.web.vo.BookmarkVo;

import lombok.extern.slf4j.Slf4j;

/**
 * 북마크 매퍼 테스트 클래스
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/spring/root-context.xml"
})
public class BookmarkMapperTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private BookmarkMapperInterface bookmarkMapper;

    @Test @Ignore
    public void testDataSource() {
        try (Connection conn = dataSource.getConnection()) {
            assertNotNull(conn);
            System.out.println("획득한 커넥션 : " + conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test @Ignore
    public void testBookmarkMapper() {
        assertNotNull(bookmarkMapper);
        log.info("bookmarkMapper 객체 : " + bookmarkMapper);
    }

    /**
     * 북마크 조회 테스트 메소드
     */
    @Test @Ignore
    public void testGetBookmark() {
        int bookmarkId = 1; // 조회할 북마크 ID
        BookmarkVo bookmarkVo = bookmarkMapper.getBookmark(bookmarkId);
        log.info("조회된 북마크 : " + bookmarkVo);
        assertNotNull(bookmarkVo);
    }

    /**
     * 북마크 목록 조회 테스트 메소드
     */
    @Test @Ignore
    public void testListBookmark() {
        List<BookmarkVo> bookmarkList = bookmarkMapper.listBookmark();
        assertNotNull(bookmarkList);
        assertTrue(bookmarkList.size() > 0);
        bookmarkList.forEach(bookmark -> log.info("북마크 : " + bookmark));
    }

    /**
     * 북마크 등록 테스트 메소드
     */
    @Test //@Ignore
    public void testcreateBookmarkSelectKey() {
        String memberId = "test"; // 회원 ID
        int boardId = 12; // 게시판 ID

        // 북마크 생성
        int result = bookmarkMapper.createBookmarkSelectKey(memberId, boardId);
        assertTrue(result > 0);
        log.info("북마크 생성 결과 : " + result);

        // 생성된 북마크 정보 조회
        BookmarkVo createdBookmark = bookmarkMapper.getBookmark(result);
        assertNotNull(createdBookmark);
        log.info("생성된 북마크 정보 : " + createdBookmark);
    }

    /**
     * 북마크 삭제 테스트 메소드
     */
    @Test @Ignore
    public void testDeleteBookmark() {
        int bookmarkId = 1; // 삭제할 북마크 ID

        // 북마크 삭제
        int result = bookmarkMapper.deleteBookmark(bookmarkId);
        assertTrue(result > 0);
        log.info("북마크 삭제 결과 : " + result);
    }

    /**
     * 북마크 등록 및 조회수 업데이트 테스트 메소드
     */
    @Test
    @Ignore
    public void testCreateBookmarkAndIncrementCount() {
        String memberId = "test"; // 회원 ID
        int boardId = 1; // 게시판 ID

        // 북마크 생성
        int createdBookmarkId = bookmarkMapper.createBookmarkSelectKey(memberId, boardId);
        assertTrue(createdBookmarkId > 0);

        // 생성된 북마크 조회
        BookmarkVo createdBookmark = bookmarkMapper.getBookmark(createdBookmarkId);
        assertNotNull(createdBookmark);
        log.info("생성된 북마크 정보 : " + createdBookmark);

        // 게시판의 북마크 조회수 업데이트
        int updateCountResult = bookmarkMapper.updateBoardBookmarkCount(boardId);
        assertTrue(updateCountResult > 0);
        log.info("게시판 북마크 조회수 업데이트 결과 : " + updateCountResult);
    }
}
