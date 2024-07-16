package com.snapshare.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.snapshare.web.service.BookmarkService;
import com.snapshare.web.vo.BookmarkVo;

@Controller
@RequestMapping("/bookmark")
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
        return "bookmark/list";
    }

    @PostMapping("/create")
    public String createBookmark(@ModelAttribute BookmarkVo bookmarkVo) {
        bookmarkService.insertBookmark(bookmarkVo);
        return "redirect:/bookmark/list";
    }

    @PostMapping("/update")
    public String updateBoardBookmarkCount(@RequestParam("memberId") String memberId,
                                           @RequestParam("boardId") int boardId) {
        bookmarkService.updateBoardBookmarkCount(memberId, boardId);
        return "redirect:/bookmark/list";
    }

    @PostMapping("/delete")
    public String deleteBookmark(@RequestParam("bookmarkId") int bookmarkId) {
        bookmarkService.deleteBookmark(bookmarkId);
        return "redirect:/bookmark/list";
    }
}
