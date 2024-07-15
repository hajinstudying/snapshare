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

import com.snapshare.web.mapper.BookmarkMapperInterface;
import com.snapshare.web.vo.BookmarkVo;

import lombok.extern.slf4j.Slf4j;

/**
 * 단위테스트
 * - SpringJUnit4ClassRunner 의존성이 안들어오는 경우 pom.xml에 spring-test 확인할것.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Slf4j
public class BookmarkMapperTest {
	 
	@Autowired
	private DataSource dataSource;
	@Autowired
	private BookmarkMapperInterface bookmarkMapper;
	
	@Test //@Ignore
	public void testDataSource() {
		try(Connection conn = dataSource.getConnection()){
			assertNotNull(conn);
			System.out.println("획득한 커넥션 : " + conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 매퍼 인터페이스의 의존성 주입이 정상적으로 되는지 확인하는 테스트 메소드
	 */
	@Test @Ignore
	public void testBookmarkMapper() {
		assertNotNull(bookmarkMapper);		
		log.info("bookmarkMapper 객체 : " + bookmarkMapper);
	}

	// 북마크 상세보기 테스트
	@Test @Ignore
	public void testGetBookmark() {
		int bookmarkId = 1; // 실제 북마크 ID
		BookmarkVo bookmarkVo = bookmarkMapper.getBookmark(bookmarkId);
		log.info("북마크 : " + bookmarkVo);
	}
	 
	// 북마크 목록보기 테스트
	@Test @Ignore
	public void testListBookmark() {
		List<BookmarkVo> bookmarkList = bookmarkMapper.listBookmark();
		assertNotNull(bookmarkList);
		assertTrue(bookmarkList.size() > 0);
		bookmarkList.forEach(bookmark -> System.out.println(bookmark));
	}
	 
	// 북마크 등록 테스트
	@Test @Ignore
	public void testCreateBookmark() {
		// 저장할 객체 생성
		BookmarkVo bookmarkVo = new BookmarkVo();
		bookmarkVo.setMemberId("java");
		bookmarkVo.setBoardId(1);
		 
		// 객체 저장
		int result = bookmarkMapper.createBookmark(bookmarkVo);
		assertTrue(result > 0);
		log.info("저장된 행수 : " + result);
	}
	 
	// 북마크 수정 테스트
	@Test @Ignore
	public void testUpdateBookmark() {
		// 수정할 객체 생성
		BookmarkVo bookmarkVo = new BookmarkVo();
		bookmarkVo.setBookmarkId(1);	// 실제로 DB에 있는 bookmarkId
		bookmarkVo.setMemberId("java");
		bookmarkVo.setBoardId(2);
		 
		// 객체 수정
		int result = bookmarkMapper.updateBookmark(bookmarkVo);
		assertTrue(result > 0);
		log.info("수정된 행수 : " + result);
	}
	 
	// 북마크 삭제 테스트
	@Test @Ignore
	public void testDeleteBookmark() {
		int bookmarkId = 1;	// 삭제할 bookmarkId, DB에 있는 번호
		 
		// 객체 삭제
		int result = bookmarkMapper.deleteBookmark(bookmarkId);
		assertTrue(result > 0);
		log.info("삭제된 행수 : " + result);
	}
}
