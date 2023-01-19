package com.study.nsuBoard.controller;


import com.study.nsuBoard.dto.CommentDto;
import com.study.nsuBoard.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/comment")

public class CommentController {
    private final CommentService commentService;

    @PostMapping("/save")
    public ResponseEntity save(@ModelAttribute CommentDto commentDto) {
        Long saveResult = commentService.save(commentDto);


        List<CommentDto> commentDtoList = commentService.findAll(commentDto.getBoardId());
        return new ResponseEntity<>(commentDtoList, HttpStatus.OK);


    }


}
