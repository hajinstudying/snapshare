package com.snapshare.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	// 업로드 파일 경로 읽어오기 WEB-INF/config/file.properties
	@Value("${file.path}")
	private String filePath;

	@Autowired
	private BoardService boardService;
	
	/**
	 * 게시물 내용 보기 메소드
	 * - boardService.getBoard(boardId)에서 트랜잭션으로 조회수 증가 처리됨
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
		return "home";
	}
	
	/**
	 * 게시물 등록 폼 제공 메소드
	 */
	@GetMapping("/create")
	public String createBoard(Model model) {	
		model.addAttribute("boardVo", new BoardVo());
		return "board/boardCreate";
	}
	
	/**
	 * 게시물 등록 메소드 (Post)
	 * - 폼에서는 이미지파일을 "file"이라는 name으로 보내야한다.
	 * - 저장되는 이미지파일명은 uniqueFileName이다.
	 */
	@PostMapping("/create")
	public String createBoard(HttpSession session,
							  @RequestParam("file") MultipartFile file,
	                          @RequestParam("tagList") String tagList,
	                          RedirectAttributes redirectAttributes) {
		
		log.info("boardController의 createBoard()");
		
		//세션에서 memberId 가져오기
		MemberVo memberVo = (MemberVo) session.getAttribute("memberVo");
		String memberId = memberVo.getMemberId();
		log.info("세션에서 가져온 memberId" + memberId);
		
	    // 파일 업로드 처리
		BoardVo boardVo = new BoardVo();
	    if (!file.isEmpty()) {
	        try {
	        	
	            String fileRealName = file.getOriginalFilename();
	            String fileNameWithoutExtension = fileRealName.substring(0, fileRealName.lastIndexOf("."));
	            String fileExtension = fileRealName.substring(fileRealName.lastIndexOf("."));
	            
	            // 파일 업로드 경로 설정 (상대 경로 사용 예시. 원래 절대경로로 해야함)
	            String uploadPath = filePath;
	            File uploadDir = new File(uploadPath);
	            if (!uploadDir.exists()) {
	                uploadDir.mkdirs();
	            }

	            // 중복 파일명 처리
	            String uuid = UUID.randomUUID().toString();  // 하이픈으로 연결되는 랜덤문자열 발행
	            String[] uuids = uuid.toString().split("-"); // 하이픈을 구분자로 배열로 저장
	    		String randomStr = uuids[0]; // 너무 길어서 0번째 인덱스만 사용
	            String uniqueFileName = fileNameWithoutExtension + "_" + randomStr + fileExtension;
	            log.info("저장되는 파일명 : " + uniqueFileName); // 원래파일명_랜덤문자열.확장자
	            
	            // 파일 저장
	            File saveFile = new File(uploadDir, uniqueFileName); 
	            file.transferTo(saveFile);
	            
	            // 고유 파일명을 boardVo에 설정
	            boardVo.setFileName(uniqueFileName);
	            boardVo.setMemberId(memberId);
	            
	            // 게시물 생성
	            boardService.createBoard(boardVo, tagList);
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
		
		// 해당 글의 작성자 정보 조회를 위한 게시물 조회
	    BoardVo boardVo = boardService.getBoard(boardId);
		// 게시물이 존재하지 않는 경우 처리
	    if (boardVo == null) {
	        redirectAttributes.addFlashAttribute("error", "존재하지 않는 게시물입니다.");
	        return "redirect:/board/list";
	    }
		// 작성자와 로그인 아이디가 다를 경우
		if(!boardVo.getMemberId().equals(memberVo.getMemberId())) {
			redirectAttributes.addFlashAttribute("error", "작성자가 아니면 삭제할 수 없습니다.");
			return  "redirect:/board/detail?boardId=" + boardId;
		}
		 // 작성자와 일치할 경우 게시물 삭제
		boardService.deleteBoard(boardId);			
		return "redirect:/board/list";
	}	
}