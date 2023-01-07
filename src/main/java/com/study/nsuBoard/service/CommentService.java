package com.study.nsuBoard.service;


import com.study.nsuBoard.dto.CommentDto;
import com.study.nsuBoard.entity.Board;
import com.study.nsuBoard.entity.CommentEntity;
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
        CommentEntity commentEntity = CommentEntity.toSaveEntity(commentDto, board);

        return commentRepository.save(commentEntity).getId();

    }

    public List<CommentDto> findAll(Integer boardId) {

        Board board = boardRepository.findById(boardId).get();
        List<CommentEntity> allByBoardOrderByIdDesc =
                commentRepository.findAllByBoardOrderByIdDesc(board);
        List<CommentDto> commentDtoList = new ArrayList<>();
        for (CommentEntity commentEntity : allByBoardOrderByIdDesc) {
            CommentDto commentDto = CommentDto.toCommnetDto(commentEntity);
            commentDtoList.add(commentDto);
        }
        return commentDtoList;
    }
}
