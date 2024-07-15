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

import com.snapshare.web.service.ReplyService;
import com.snapshare.web.vo.MemberVo;
import com.snapshare.web.vo.ReplyVo;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/reply")
@Slf4j
public class ReplyController {
	
	@Autowired
	private ReplyService replyService;
	
	/**
	 * 댓글 상세 보기 메소드
	 */
	@GetMapping("/detail")
	public String getReply(@RequestParam("replyId") int replyId, Model model) {
		log.info("ReplyController getReply");

		ReplyVo replyVo = replyService.getReply(replyId);
		model.addAttribute("replyVo", replyVo);
		return "reply/replyDetail"; // 반환할 JSP 이름
	}
	
	/**
	 * 댓글 목록 보기 메소드
	 */
	@GetMapping("/list")
	public String listReply(Model model) {
		log.info("ReplyController listReply");

		List<ReplyVo> listReply = replyService.listReply();
		model.addAttribute("listReply", listReply);
		return "reply/replyList"; // 반환할 JSP 이름
	}
	
	/**
	 * 댓글 등록 폼 제공(get 방식)
	 */
	@GetMapping("/create")
	public String createReply(HttpSession session, RedirectAttributes redirectAttributes, Model model) {
		// 세션에서 사용자 정보 조회
		MemberVo memberVo = (MemberVo) session.getAttribute("memberVo");
		if (memberVo == null) {
			return "redirect:/reply/list";
		}
		model.addAttribute("replyVo", new ReplyVo());
		return "reply/replyCreate";
	}
	
	/**
	 * 댓글 등록 메소드(post 방식)
	 */
	@PostMapping("/create")
	public String createReply(@ModelAttribute("replyVo") ReplyVo replyVo, HttpSession session) {
		// 세션에서 사용자 정보 조회
		MemberVo memberVo = (MemberVo) session.getAttribute("memberVo");
		if (memberVo == null) {
			return "redirect:/reply/list";
		}
		// 세션에서 조회한 사용자를 작성자로 설정
		replyVo.setMemberId(memberVo.getMemberId());

		replyService.createReplySelectKey(replyVo); // 선택 키를 사용하는 메서드 호출
		return "redirect:/reply/list";	// 목록 요청(listReply() 호출)
	}

	/**
	 * 댓글 수정 폼 제공(get 방식)
	 */
	@GetMapping("/update")
	public String updateReply(@RequestParam("replyId") int replyId, Model model, HttpSession session) {
		// 세션에서 사용자 정보 조회
		MemberVo memberVo = (MemberVo) session.getAttribute("memberVo");
		if (memberVo == null) {
			return "redirect:/reply/list";
		}
		ReplyVo replyVo = replyService.getReply(replyId);
		model.addAttribute("replyVo", replyVo); // 화면에 보여줄 댓글을 모델에 저장
		return "reply/replyUpdate";
	}
	
	/**
	 * 댓글 수정 메소드(post 방식)
	 */
	@PostMapping("/update")
	public String updateReply(@ModelAttribute("replyVo") ReplyVo replyVo, HttpSession session) {
		// 세션에서 사용자 정보 조회
		MemberVo memberVo = (MemberVo) session.getAttribute("memberVo");
		if (memberVo == null) {
			return "redirect:/reply/list";
		}
		// 세션에서 조회한 사용자를 작성자로 설정
		replyVo.setMemberId(memberVo.getMemberId());

		replyService.updateReply(replyVo);
		return "redirect:/reply/list";	// 목록 요청(listReply() 호출)
	}
	
	/**
	 * 댓글 삭제 메소드
	 */
	@PostMapping("/delete")
	public String deleteReply(@RequestParam("replyId") int replyId) {
		replyService.deleteReply(replyId);
		return "redirect:/reply/list";	// 목록 요청(listReply() 호출)
	}
}
