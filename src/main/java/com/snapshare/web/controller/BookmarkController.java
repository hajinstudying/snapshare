package com.snapshare.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.snapshare.web.service.BookmarkService;
import com.snapshare.web.vo.BookmarkVo;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/bookmark")
@Slf4j
public class BookmarkController {

    private final BookmarkService bookmarkService;

    @Autowired
    public BookmarkController(BookmarkService bookmarkService) {
        this.bookmarkService = bookmarkService;
    }

    @GetMapping("/detail")
    public String getBookmark(@RequestParam("bookmarkId") int bookmarkId, Model model) {
        BookmarkVo bookmarkVo = bookmarkService.getBookmark(bookmarkId);
        model.addAttribute("bookmarkVo", bookmarkVo);
        return "redirect:/board/detail?boardId=" + bookmarkVo.getBoardId();
    }

    @GetMapping("/list")
    public String listBookmarks(Model model) {
        List<BookmarkVo> bookmarkList = bookmarkService.listBookmark();
        model.addAttribute("bookmarkList", bookmarkList);
        return "bookmark/bookmarklist";
    }

    @PostMapping("/create")
    public String insertBookmark(@RequestParam("boardId") Integer boardId, @RequestParam("memberId") String memberId) {
        try {
            // 요청 데이터 검증
            if (boardId == null || memberId == null || memberId.isEmpty()) {
                log.info("북마크 생성 실패: boardId 또는 memberId가 유효하지 않습니다.");
                return "redirect:/login";
            }

            log.info("북마크 추가 요청 - boardId: {}, memberId: {}", boardId, memberId);

            // BookmarkVo 객체 생성
            BookmarkVo bookmarkVo = new BookmarkVo();
            bookmarkVo.setBoardId(boardId);
            bookmarkVo.setMemberId(memberId);

            // 북마크 생성 서비스 호출
            int result = bookmarkService.insertBookmark(bookmarkVo);

            if (result > 0) {
                log.info("북마크가 추가되었습니다 - boardId: {}, memberId: {}", boardId, memberId);
                return "redirect:/bookmark/list";
            } else {
                log.warn("북마크 추가 실패 - boardId: {}, memberId: {}", boardId, memberId);
                return "redirect:/home";
            }
        } catch (Exception e) {
            log.error("북마크 추가 중 오류 발생", e);
            return "redirect:/home";
        }
    }
    @PostMapping("/update")
    public String updateBoardBookmarkCount(@RequestParam("memberId") String memberId,
                                           @RequestParam("boardId") int boardId) {
        bookmarkService.updateBoardBookmarkCount(memberId, boardId);
        return "redirect:/bookmark/bookmarklist";
    }

    @PostMapping("/delete")
    public String deleteBookmark(@RequestParam("bookmarkId") int bookmarkId) {
        bookmarkService.deleteBookmark(bookmarkId);
        return "redirect:/bookmark/bookmarklist";
    }
}