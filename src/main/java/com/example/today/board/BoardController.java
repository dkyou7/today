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
        return "board/boards";
    }
    @GetMapping("{id}")
    public String findById(Model model,@PathVariable("id") Long id){
        model.addAttribute("board",boardService.findById(id));
        return "board/details";
    }

    @GetMapping("new")
    public String dispBoardForm(Model model){
        model.addAttribute("boardForm",new BoardDto());
        return "board/newBoard";
    }

    @PostMapping("new")
    public String insertBoard(Model model, BoardDto boardDto, RedirectAttributes attributes){
        boardService.save(boardDto);
        attributes.addFlashAttribute("message","일지 추가 완료하였습니다.");
        return "redirect:/";
    }

}
