package com.study.nsuBoard.repository;

import com.study.nsuBoard.entity.Board;
import com.study.nsuBoard.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    List<CommentEntity> findAllByBoardOrderByIdDesc(Board board);

}
