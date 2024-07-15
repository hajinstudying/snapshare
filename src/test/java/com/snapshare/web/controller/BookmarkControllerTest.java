package com.snapshare.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.snapshare.web.service.BookmarkService;
import com.snapshare.web.vo.BookmarkVo;

/**
 * 웹 어플리케이션 컨텍스트를 사용하겠다. 즉, 웹 어플리케이션의 설정파일을 사용하겠다.
 * 컨트롤러와 같은 웹 계층을 테스트할 때 사용한다.
 * 컨트롤러 통합 테스트의 필요성
 * - 실제 데이터베이스나 다른 외부 시스템에 접근하지 않고도 개발이 정상적으로 잘되었는지 검증해볼수있다.
 * - 서블릿 컨테이너를 구동하지 않고 마치 사용자가 실제로 요청을 한것과 같은 효과를 얻을 수 있다.
 *   서블릿 컨테이너는 구동하는 시간도 많이걸린다. 테스트 시간을 훨씬 단축해준다.
 * - 이 테스트를 통해서 개발자가 파라미터를 알맞은 타입을 정의했는지, 순서는 맞는지 등의
 *   다양한 테스트를 할수 있다.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"
})
@WebAppConfiguration // 웹 어플레케이션 설정 파일을 사용하겠다
public class BookmarkControllerTest {

	// @Mock : 목 객체를 생성한다. 목은 가짜 객체로 실제 객체와 같은 동작을 한다.
	@Mock
	private BookmarkService service;

	// WebApplicationContext : 웹 어플리케이션의 설정파일을 사용할 수 있게 해준다.a
	// @WebAppConfiguration 어노테이션을 사용하면 사용할 수 있다.
	@Autowired
	private WebApplicationContext wac;

	// 가짜 mvc 객체로 역할은 컨트롤러 테스트를 위한 가짜 mvc 객체를 생성한다.
	// 이걸 생성하면 컨트롤러를 테스트할 수 있다.
	private MockMvc mockMvc;

	// @InjectMocks : 테스트 대상이 되는 객체에 목 객체를 주입한다. 서블릿 컨테이너를 실행하지 않아도 테스트 가능
	// HomeController 객체에 목 객체를 주입한다. 이 구문을 생략하면 목 객체가 주입되지 않는다.
	@InjectMocks
	private BookmarkController bookmarkController;
	
	@Before // 먼저 실행되어서 목 객체 초기화
	public void setup() {
		MockitoAnnotations.initMocks(this); // 목 객체를 초기화한다.
		this.mockMvc = MockMvcBuilders.standaloneSetup(bookmarkController).build(); // 가짜 mvc 객체를 생성한다.
	}

	// 북마크 내용 보기 메소드 테스트
	@Test 
	public void testGetBookmark() throws Exception {
	    // given: 대전제 - service.getBookmark(1)이라는 요청을 하게 되면
	    // 그러면 응답으로 bookmarkVo 객체가 돌아올 것이다.
	    BookmarkVo bookmarkVo = new BookmarkVo(1, "test", 1);
	    Mockito.when(service.getBookmark(1)).thenReturn(bookmarkVo);
	    
	    // when
	    // get방식으로 "/getBookmark"라는 요청을 하면서 파라미터로 /getBookmark?bookmarkId=1 을 전달하겠다.
	    this.mockMvc.perform(get("/getBookmark").param("bookmarkId", "1"))	
	    
	    // then
	    .andExpect(status().isOk())		// 응답 상태가 200인지 확인한다.
	    .andExpect(view().name("board/boardDetail"))	// boardDetail.jsp로 이동하는지 확인한다.
	    .andExpect(model().attributeExists("bookmarkVo"))	// model에 bookmarkVo이 있는지 확인한다.
	    .andExpect(model().attribute("bookmarkVo", bookmarkVo));
	}

	
	// 북마크 목록 테스트
	@Test @Ignore
	public void testListBookmark() throws Exception{
		// given : 대전제 - service.listBookmark() 이라는 요청을 하게 되면
		// 그러면 응답으로 bookmarkList 객체가 돌아올 것이다.
		BookmarkVo bookmarkVo1 = new BookmarkVo(1, "java", 1);
		List<BookmarkVo> bookmarkList = new ArrayList<>();
		bookmarkList.add(bookmarkVo1);
		
		Mockito.when(service.listBookmark()).thenReturn(bookmarkList);
		
		// when
		// get방식으로 "/listBookmark"라는 요청을 한다.
		this.mockMvc.perform(get("/bookmark/list"))	
		
		// then
		.andExpect(status().isOk())		// 응답 상태가 200인지 확인한다.
		.andExpect(view().name("board/boardList"))	// boardDetail.jsp로 이동하는지 확인한다.
		.andExpect(model().attributeExists("listBookmark"))	// model에 bookmarkList이 있는지 확인한다.
		.andExpect(model().attribute("listBookmark", bookmarkList));
	}
	
	/**
	 * 컨트롤러에 주입되어 있는 서비스 레이어의 특정 메소드를 테스트한다.
	 * - service.createBookmark() 메소드 테스트
	 */
	@Test @Ignore
    public void testcreateBookmarkSelectKey() throws Exception {
        // Given: 테스트를 위한 전제 조건을 설정한다.
        // BookmarkVo 객체를 생성하고, service.createBookmark 메서드가 호출될 때 1을 반환하도록 설정.
        BookmarkVo bookmarkVo = new BookmarkVo(0, "java", 1);
        Mockito.when(service.createBookmarkSelectKey(Mockito.any(BookmarkVo.class))).thenReturn(1);

        // When: /createBookmark라는 요청을 보내는 행동을 함.
        // 요청 시, BookmarkVo 객체의 memberId, boardId 파라미터를 함께 전달한다.
        mockMvc.perform(post("/bookmark/create")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("memberId", bookmarkVo.getMemberId())
                .param("boardId", String.valueOf(bookmarkVo.getBoardId())))
        
        // Then: When에서 수행한 행동의 결과를 검증. 기대한 결과가 실제로 발생했는지 확인.
        // 그리고 리다이렉트되는 URL이 "/bookmark/list"인지 확인한다.
        .andExpect(status().is3xxRedirection())
        .andExpect(redirectedUrl("/bookmark/list")); // 북마크 목록요청
    }
	
	// 삭제 메소드 테스트
    @Test @Ignore
    public void testDeleteBookmark() throws Exception{
     // given
     int bookmarkId = 1;
     Mockito.when(service.deleteBookmark(bookmarkId)).thenReturn(1);
     
     // when
     mockMvc.perform(post("/bookmark/delete")
           .contentType(MediaType.APPLICATION_FORM_URLENCODED)
           .param("bookmarkId", String.valueOf(bookmarkId)))
     // then
     // is3xxRedirection() : 응답이 3xx 인지 확인한다. 
     // 메소드가 반환하는 jsp 페이지가 없어요. 대신 다른 컨트롤러를 호출한다.
     .andExpect(status().is3xxRedirection())      
     .andExpect(redirectedUrl("/bookmark/list"));
  }
}
