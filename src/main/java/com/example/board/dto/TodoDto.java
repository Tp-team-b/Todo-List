package com.example.board.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TodoDto {

    private String content;

    private boolean isDone;

    private String dueDate;

}
