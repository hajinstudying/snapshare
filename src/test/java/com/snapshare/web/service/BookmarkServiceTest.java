package com.snapshare.web.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.snapshare.web.vo.BookmarkVo;

import lombok.extern.slf4j.Slf4j;

/**
 * 단위테스트
 * - SpringJUnit4ClassRunner 의존성이 안들어오는 경우 pom.xml에 spring-test 확인할것.
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Slf4j	// import lombok.extern.slf4j.Slf4j;
public class BookmarkServiceTest {
	 
	// BookmarkService 인터페이스 의존성 주입
	// 인터페이스 타입으로 의존성 주입했지만 실제로는 그 자식인 BookmarkServiceImpl 주입됨.
	@Autowired
	private BookmarkService bookmarkService;
	
	@Test @Ignore
	public void testBookmarkService() {
		assertNotNull(bookmarkService);
		log.info("bookmarkService 인터페이스 : " + bookmarkService); // BookmarkServiceImpl@7063686f
	}
	
	@Test @Ignore
	public void testGetBookmark() {
		int bookmarkId = 1;
		BookmarkVo bookmarkVo = bookmarkService.getBookmark(bookmarkId);
		assertNotNull(bookmarkVo);
		log.info("서비스에서 조회한 getBookmark() : " + bookmarkVo);
	}
	
	@Test @Ignore
	public void testListBookmark() {
		assertTrue(bookmarkService.listBookmark().size() > 0);
		List<BookmarkVo> bookmarkList = bookmarkService.listBookmark();
		bookmarkList.forEach(bookmark -> log.info(bookmark.toString()));		
	}
	
	@Test @Ignore
	public void testCreateBookmark() {
		 // 저장할 객체 생성
		 BookmarkVo bookmarkVo = new BookmarkVo();
		 bookmarkVo.setMemberId("java");
		 bookmarkVo.setBoardId(1);
		 
		 // 객체 저장
		 int result = bookmarkService.createBookmark(bookmarkVo);
		 assertTrue(result > 0);
		 log.info("저장된 행수 : " + result);		
	}
	 
	@Test
	public void testCreateBookmarkSelectKey() {
		// 저장할 객체 생성
		BookmarkVo bookmarkVo = new BookmarkVo();
		bookmarkVo.setMemberId("java");
		bookmarkVo.setBoardId(1);
		
		// 객체 저장
		int result = bookmarkService.createBookmark(bookmarkVo);
		assertTrue(result > 0);
		log.info("저장된 행수 : " + result);
	}
	
	@Test @Ignore
	public void testDeleteBookmark() {
		int bookmarkId = 1;	// 삭제할 bookmarkId, DB에 있는 번호
		 
		// 객체 삭제
		int result = bookmarkService.deleteBookmark(bookmarkId);
		assertTrue(result > 0);
		log.info("삭제된 행수 : " + result);
	}	
	
}
