package com.snapshare.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.snapshare.web.service.BoardService;
import com.snapshare.web.vo.BoardVo;
import com.snapshare.web.vo.MemberVo;

import lombok.extern.slf4j.Slf4j;

/**
 * Board 컨트롤러
 */

@Slf4j
@Controller
@RequestMapping("/board") 
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	/**
	 * 게시물 내용 보기 메소드
	 */
	@GetMapping("/detail")
	public String getBoard(@RequestParam("boardId") int boardId, Model model) {
		BoardVo boardVo = boardService.getBoard(boardId);
		model.addAttribute("boardVo", boardVo);
		return "board/boardDetail";
	}
	
	/**
	 * 게시물 목록 보기 메소드 
	 */
	@GetMapping("/list")
	public String listBoard(Model model) {
		List<BoardVo> boardList = boardService.listBoard();
		model.addAttribute("boardList", boardList);
		return "board/boardList";
	}
	
	/**
	 * 게시물 등록 폼 제공 메소드
	 */
	@GetMapping("/create")
	public String createBoard(HttpSession session,
							  RedirectAttributes redirectAttributes,
							  Model model) {	
		model.addAttribute("boardVo", new BoardVo());
		return "board/boardCreate";
	}
	
	/**
	 * 게시물 등록 메소드 (Post)
	 * - 폼에서는 fileName을 "file"이라는 name으로 보내야합니다.
	 * - 저장되는 이미지파일명은 uniqueFileName입니다.
	 */
	@Transactional
	@PostMapping("/create")
	public String createBoard(@ModelAttribute("boardVo") BoardVo boardVo,
	                          @RequestParam("file") MultipartFile file,
	                          HttpSession session,
	                          RedirectAttributes redirectAttributes) {
		// 로그인 세션 확인
	    MemberVo memberVo = (MemberVo) session.getAttribute("memberVo");
	    if (memberVo == null) {
	        redirectAttributes.addFlashAttribute("error", "회원만 게시물을 작성할 수 있습니다.");
	        return "redirect:/login";
	    }

	    boardVo.setMemberId(memberVo.getMemberId());

	    // 파일 업로드 처리
	    if (!file.isEmpty()) {
	        try {
	            String fileRealName = file.getOriginalFilename();
	            String fileExtension = fileRealName.substring(fileRealName.lastIndexOf("."));
	            
	            // 파일 업로드 경로 설정 (상대 경로 사용 예시)
	            String uploadPath = "/upload";
	            File uploadDir = new File(uploadPath);
	            if (!uploadDir.exists()) {
	                uploadDir.mkdirs();
	            }

	            // 중복 파일명 처리
	            String uuid = UUID.randomUUID().toString();
	            String uniqueFileName = fileRealName + uuid + fileExtension;
	            File saveFile = new File(uploadDir, uniqueFileName);

	            // 파일 저장
	            file.transferTo(saveFile);
	            
	            // 고유 파일명을 boardVo에 설정
	            boardVo.setFileName(uniqueFileName);
	            
	            // 게시물 생성
	            boardService.createBoard(boardVo);
	            return "redirect:/board/list";
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	            redirectAttributes.addFlashAttribute("error", "파일 업로드 실패: " + e.getMessage());
	        }
	    } else {
	        redirectAttributes.addFlashAttribute("error", "파일을 선택해주세요.");
	    }
	    return "redirect:/board/list";
	}
	
	/**
	 * 게시물 삭제 메소드
	 * - 해당 게시물의 작성자(memberId)와 세션의 memberId가 같아야 삭제 가능 
	 */
	@PostMapping("/delete")
	public String deleteBoard(@RequestParam("boardId") int boardId,
							  HttpSession session,
							  RedirectAttributes redirectAttributes) {
		
		// 세션에서 사용자 정보 조회
		MemberVo memberVo = (MemberVo) session.getAttribute("memberVo");
		// 해당 글의 사용자 정보 조회
		String boardWriter = boardService.getBoard(boardId).getMemberId();
		// 작성자와 로그인 아이디가 다를 경우
		if(!boardWriter.equals(memberVo.getMemberId())) {
			redirectAttributes.addFlashAttribute("error", "작성자가 아니면 삭제할 수 없습니다.");
			return "redirect:/board/detail";
		}
		//같을 경우
		boardService.deleteBoard(boardId);			
		return "redirect:/board/list";
	}	
}