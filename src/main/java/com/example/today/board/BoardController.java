package com.example.today.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("boards")
    public String findAll(Model model){
        model.addAttribute("boards",boardService.findAll());
        return "boards";
    }

    @GetMapping("{title}")
    public String findByTitle(Model model, @PathVariable("title") String title){
        model.addAttribute("board",boardService.findByTitle(title));
        return "details";
    }

    @GetMapping("new")
    public String dispBoardForm(Model model){
        model.addAttribute("board",new BoardDto());
        return "newBoard";
    }

    @PostMapping("new")
    public String insertBoard(Model model, BoardDto boardDto, RedirectAttributes attributes){
        boardService.save(boardDto);
        attributes.addFlashAttribute("message","일지 추가 완료하였습니다.");
        return "redirect:/";
    }

}
