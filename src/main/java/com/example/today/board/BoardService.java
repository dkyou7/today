package com.example.today.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    // 비즈니스 로직.
    public List<Board> findAll(){
        return boardRepository.findAll();
    }

    public void save(BoardDto boardDto) {
        Board board = BoardDto.toEntity(boardDto);
        boardRepository.save(board);
    }

    public Board findById(Long id) {
        return boardRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
