package com.snapshare.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.snapshare.web.service.BoardTagService;
import com.snapshare.web.service.TagService;
import com.snapshare.web.vo.TagVo;

import lombok.extern.slf4j.Slf4j;

/**
 * BoardTag 컨트롤러
 */

@Slf4j
@Controller
@RequestMapping("/tag") 
public class BoardTagController {
	
	@Autowired
	private BoardTagService boardTagService;
	private TagService tagService;
	
	/**
	 * 생성된 태그목록 조회 
	 */
	@GetMapping("/list")
	public String listBoard(Model model) {
		List<TagVo> tagList = tagService.listTag();
		model.addAttribute("tagList", tagList);
		return ""; //어드민의 태그 리스트 조회 jsp로 이동
	}
	
	/**
	 * 게시물에 태그 추가 메소드
	 */
	@Transactional
	@PostMapping("/add")
	@ResponseBody
    public String addTagToBoard(@RequestParam("boardId") int boardId,
    							@RequestParam("tagName") String tagName,
    							RedirectAttributes redirectAttributes) {
        try {
            int result = boardTagService.addTagToBoard(boardId, tagName);
            if (result > 0) {
            	redirectAttributes.addAttribute("boardId", boardId);
                return "redirect:/board/create"; // 태그 추가 성공
            } else {
            	log.info("이미 추가된 태그 오류");
            	redirectAttributes.addFlashAttribute("error", "이미 추가된 태그입니다.");
                return "redirect:/board/create";
            }
        } catch (Exception e) {
        	log.info("태그 추가 중 오류 발생");
            return "redirect:/board/create";
        }
    }
	
	/**
	 * 게시물에서 태그 삭제 메소드
	 */
	@PostMapping("/delete")
	public String deleteTagFromBoard(@RequestParam("boardId") int boardId,
									 @RequestParam("tagId") int tagId,
									 RedirectAttributes redirectAttributes) {
		try {
			int result = boardTagService.deleteTagFromBoard(boardId, tagId);
			if (result > 0) {
				log.info("태그 삭제 완료");
				redirectAttributes.addAttribute("boardId", boardId);
                return "redirect:/board/create";
            } else {
            	return "redirect:/board/create";
            }
		} catch(Exception e) {
			log.info("태그 추가 중 오류 발생");
			return "redirect:/board/create";
		}
	}
}