package com.study.nsuBoard.repository;

import com.study.nsuBoard.entity.BoardEntity;
import com.study.nsuBoard.entity.CommentEntitiy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntitiy, Long> {
    List<CommentEntitiy> findAllByBoardOrderByIdDesc(BoardEntity boardEntity);

}
