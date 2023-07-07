package com.study.nsuBoard.service;


import com.study.nsuBoard.dto.CommentEntitiyDto;
import com.study.nsuBoard.entity.BoardEntity;
import com.study.nsuBoard.entity.CommentEntitiy;
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

    public Long save(CommentEntitiyDto commentDto) {
        Optional<BoardEntity> optionalBoard = boardRepository.findById(commentDto.getBoardId());
        BoardEntity boardEntity = optionalBoard.get();
        CommentEntitiy commentEntitiy = CommentEntitiy.toSaveEntity(commentDto, boardEntity);

        return commentRepository.save(commentEntitiy).getId();

    }

    public List<CommentEntitiyDto> findAll(Integer boardId) {

        BoardEntity boardEntity = boardRepository.findById(boardId).get();
        List<CommentEntitiy> allByBoardOrderByIdDesc =
                commentRepository.findAllByBoardOrderByIdDesc(boardEntity);
        List<CommentEntitiyDto> commentDtoList = new ArrayList<>();
        for (CommentEntitiy commentEntitiy : allByBoardOrderByIdDesc) {
            CommentEntitiyDto commentDto = CommentEntitiyDto.toCommnetDto(commentEntitiy);
            commentDtoList.add(commentDto);
        }
        return commentDtoList;
    }
}
