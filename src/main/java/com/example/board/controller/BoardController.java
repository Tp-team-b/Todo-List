package com.example.board.controller;

import com.example.board.dto.PostDto;
import com.example.board.entity.Board;
import com.example.board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
public class BoardController {

    private final PostRepository postRepository;

    @GetMapping("/post")
    public String getSavePage() {
        return "form";
    }


    @ResponseBody
    @PostMapping("/save")
    public PostDto savePost(PostDto postDto) {
        log.info("post title = {}, post content = {}", postDto.getTitle(), postDto.getContent());
        Board post = new Board();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        Board board = postRepository.save(post);

        PostDto dto = new PostDto();
        dto.setTitle(board.getTitle());
        dto.setContent(board.getContent());
        return dto;
    }
}
