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

@Controller
@RequestMapping("/bookmark")
@Slf4j
public class BookmarkController {
	
	@Autowired
	private BookmarkService bookmarkService;
	
	/**
	 * 북마크 상세 보기 메소드
	 */
	@GetMapping("/detail")
	public String getBookmark(@RequestParam("bookmarkId") int bookmarkId, Model model) {
		log.info("BookmarkController getBookmark");

		BookmarkVo bookmarkVo = bookmarkService.getBookmark(bookmarkId);
		model.addAttribute("bookmarkVo", bookmarkVo);
		return "bookmark/bookmarkDetail"; // 반환할 JSP 이름
	}
	
	/**
	 * 북마크 목록 보기 메소드
	 */
	@GetMapping("/list")
	public String listBookmark(Model model) {
		log.info("BookmarkController listBookmark");

		List<BookmarkVo> listBookmark = bookmarkService.listBookmark();
		model.addAttribute("listBookmark", listBookmark);
		return "bookmark/bookmarkList"; // 반환할 JSP 이름
	}
	
	/**
	 * 북마크 등록 폼 제공(get 방식)
	 */
	@GetMapping("/create")
	public String createBookmark(HttpSession session, RedirectAttributes redirectAttributes, Model model) {
		// 세션에서 사용자 정보 조회
		MemberVo memberVo = (MemberVo) session.getAttribute("memberVo");
		if (memberVo == null) {
			return "redirect:/login";
		}
		model.addAttribute("bookmarkVo", new BookmarkVo());
		return "bookmark/bookmarkCreate";
	}
	
	/**
	 * 북마크 등록 메소드(post 방식)
	 */
	@PostMapping("/create")
	public String createBookmark(@ModelAttribute("bookmarkVo") BookmarkVo bookmarkVo, HttpSession session) {
		// 세션에서 사용자 정보 조회
		MemberVo memberVo = (MemberVo) session.getAttribute("memberVo");
		if (memberVo == null) {
			return "redirect:/login";
		}
		// 세션에서 조회한 사용자를 작성자로 설정
		bookmarkVo.setMemberId(memberVo.getMemberId());

		bookmarkService.createBookmarkSelectKey(bookmarkVo); // 선택 키를 사용하는 메서드 호출
		return "redirect:/bookmark/list";	// 목록 요청(listBookmark() 호출)
	}

	/**
	 * 북마크 수정 폼 제공(get 방식)
	 */
	@GetMapping("/update")
	public String updateBookmark(@RequestParam("bookmarkId") int bookmarkId, Model model, HttpSession session) {
		// 세션에서 사용자 정보 조회
		MemberVo memberVo = (MemberVo) session.getAttribute("memberVo");
		if (memberVo == null) {
			return "redirect:/login";
		}
		BookmarkVo bookmarkVo = bookmarkService.getBookmark(bookmarkId);
		model.addAttribute("bookmarkVo", bookmarkVo); // 화면에 보여줄 북마크를 모델에 저장
		return "bookmark/bookmarkUpdate";
	}
	
	/**
	 * 북마크 수정 메소드(post 방식)
	 */
	@PostMapping("/update")
	public String updateBookmark(@ModelAttribute("bookmarkVo") BookmarkVo bookmarkVo, HttpSession session) {
		// 세션에서 사용자 정보 조회
		MemberVo memberVo = (MemberVo) session.getAttribute("memberVo");
		if (memberVo == null) {
			return "redirect:/login";
		}
		// 세션에서 조회한 사용자를 작성자로 설정
		bookmarkVo.setMemberId(memberVo.getMemberId());

		bookmarkService.updateBookmark(bookmarkVo);
		return "redirect:/bookmark/list";	// 목록 요청(listBookmark() 호출)
	}
	
	/**
	 * 북마크 삭제 메소드
	 */
	@PostMapping("/delete")
	public String deleteBookmark(@RequestParam("bookmarkId") int bookmarkId) {
		bookmarkService.deleteBookmark(bookmarkId);
		return "redirect:/bookmark/list";	// 목록 요청(listBookmark() 호출)
	}
}
