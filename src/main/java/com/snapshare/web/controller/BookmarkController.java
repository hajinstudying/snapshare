package com.snapshare.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @ResponseBody
    public ResponseEntity<Map<String, Object>> createBookmark(@RequestBody Map<String, Object> payload) {
        int boardId = (int) payload.get("boardId");
        String memberId = (String) payload.get("memberId");
        log.info("게시판 ID: " + boardId + ", 회원 ID: " + memberId);
        
        int result = bookmarkService.insertBookmark(new BookmarkVo(boardId, memberId));
        log.info("북마크 삽입 결과: " + result);
        
        Map<String, Object> response = new HashMap<>();
        if (result > 0) {
            response.put("success", true);
        } else {
            response.put("success", false);
        }
        return ResponseEntity.ok(response);
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
