package com.study.nsuBoard.service;


import com.study.nsuBoard.dto.CommentDto;
import com.study.nsuBoard.entity.Board;
import com.study.nsuBoard.entity.Comment;
import com.study.nsuBoard.repository.BoardRepository;
import com.study.nsuBoard.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class CommentService {

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    public Long save(CommentDto commentDto) {
        Optional<Board> optionalBoard = boardRepository.findById(commentDto.getBoardId());
        Board board = optionalBoard.get();
        Comment comment = Comment.toSaveEntity(commentDto, board);

        return commentRepository.save(comment).getId();

    }

    public List<CommentDto> findAll(Integer boardId) {

        Board board = boardRepository.findById(boardId).get();
        List<Comment> allByBoardOrderByIdDesc =
                commentRepository.findAllByBoardOrderByIdDesc(board);
        List<CommentDto> commentDtoList = new ArrayList<>();
        for (Comment comment : allByBoardOrderByIdDesc) {
            CommentDto commentDto = CommentDto.toCommnetDto(comment);
            commentDtoList.add(commentDto);
        }
        return commentDtoList;
    }
}
