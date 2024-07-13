package com.snapshare.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.snapshare.web.service.BookmarkService;
import com.snapshare.web.vo.BookmarkVo;
import com.snapshare.web.vo.MemberVo;

import lombok.extern.slf4j.Slf4j;

/**
 * Board 컨트롤러
 * - 클라이언트의 요청을 받는 메소드(핸들러)를 갖고 있는 메소드
 * - 받은 요청을 서비스 레잉어로 전달하는 역할
 * - 서비스로부터 전달받은 쿼리결과를 model에 담고 담은 값을 보여줄 jsp 페이지 이름 리턴
 */
@Controller
@RequestMapping("/bookmark") // 컨트롤러 차원의 URL 연결 문자열 설정
@Slf4j
public class BookmarkController {
	
	@Autowired
	private BookmarkService bookmarkService;
	
	
	@GetMapping("/detail")
	public String getBookmark(@RequestParam("bookmarkId") int bookmarkId, Model model) {
		
		log.info("BookmarkController getBookmark");
		
		BookmarkVo bookmarkVo = bookmarkService.getBookmark(bookmarkId);
		model.addAttribute("bookmarkVo", bookmarkVo);
		return "board/boardDetail"; // jsp 이름
	}
	
	/**
	 * 게시물 목록 보기 메소드
	 */
	@GetMapping("/list")
	public String listBookmark(Model model) {
		log.info("여기는 listBookmark 메소드"); 
		List<BookmarkVo> listBookmark = bookmarkService.listBookmark();
		model.addAttribute("listBookmark", listBookmark);
		return "board/boardList"; // jsp 이름
	}
	
	/*
	 * 게시물 등록 폼 제공(get 방식)
	 */
	@GetMapping("/add")
	public String addBookmark(HttpSession session,
							 RedirectAttributes redirectAttributes,
							 Model model) {
		// 세션에서 사용자 정보 조회
		MemberVo memberVo = (MemberVo)session.getAttribute("memberVo");
		if(memberVo == null) {
			return "redirect:/login";
		}
		model.addAttribute("BookmarkVo", new BookmarkVo());
		return "board/boardCreate";
	}
	
	
	/**
	 * 게시물 등록 메소드(post방식)
	 * @ModelAttribute: 사용자의 입력에 오류가 있을경우 기존의 내용을 그대로 화면으로 다시 전달해준다. 
	 * 이름 재설정 할때 사용(@ModelAttribute ("board") BoardVo boardVo
	 */
	@PostMapping("/add")
	public String addBookmark(@ModelAttribute("bookmarkVo")BookmarkVo bookmarkVo, HttpSession session) {
		
		// 세션에서 사용자 정보 조회
		MemberVo memberVo = (MemberVo)session.getAttribute("memberVo");
		if(memberVo == null) {
			return "redirect:/login";
		}
		// 세션에서 조회한 사용자를 작성자로 설정
		bookmarkVo.setMemberId(memberVo.getMemberId());
		
		bookmarkService.addBookmark(bookmarkVo);
		return "redirect:/board/list";	// 목록 요청(listBoard() 호출)
	}

	/*
	 * 게시물 수정(get 방식)
	 */
	@GetMapping("/update")
	public String updateBookmark(@RequestParam("bookmarkId") int bookmarkId, Model model, HttpSession session) {
		
		// 세션에서 사용자 정보 조회
		MemberVo memberVo = (MemberVo)session.getAttribute("memberVo");
		if(memberVo == null) {
			return "redirect:/login";
		}
		BookmarkVo bookmarkVo = bookmarkService.getBookmark(bookmarkId);
		model.addAttribute("boardVo", bookmarkVo); // 화면에 보여줄 게시물을 mpdel에 저장
		return "board/boardUpdate";
	}
	
	/*
	 * 게시물 수정 메소드(post방식)
	 */
	@PostMapping("/update")
	public String updateBookmark(@ModelAttribute("bookmarkVo")BookmarkVo bookmarkVo, HttpSession session) {
		
		// 세션에서 사용자 정보 조회
		MemberVo memberVo = (MemberVo)session.getAttribute("memberVo");
		if(memberVo == null) {
			return "redirect:/login";
		}
		// 세션에서 조회한 사용자를 작성자로 설정
		bookmarkVo.setMemberId(memberVo.getMemberId());
		
		bookmarkService.updateBookmark(bookmarkVo);
		return "redirect:/board/list";	// 목록 요청(listBoard() 호출)
	}
	
	/*
	 * 게시물 삭제 메소드
	 */
	@PostMapping("/delete")
	public String deleteBookmark(@RequestParam("bookmarkId") int bookmarkId) {
		bookmarkService.deleteBookmark(bookmarkId);
		return "redirect:/board/list";	// 목록 요청(listBoard() 호출)
	}
}
