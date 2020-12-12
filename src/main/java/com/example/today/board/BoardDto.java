package com.example.today.board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder @AllArgsConstructor @NoArgsConstructor
public class BoardDto {
    private String author;

    private String title;

    private String content;

    private LocalDateTime createdDate;

    public static Board toEntity(BoardDto boardDto) {
        return Board.builder()
                .author(boardDto.getAuthor())
                .title(boardDto.getTitle())
                .content(boardDto.getContent())
                .createdDate(LocalDateTime.now())
                .build();
    }
}
