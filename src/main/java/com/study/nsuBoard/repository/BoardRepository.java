package com.study.nsuBoard.repository;


import com.study.nsuBoard.entity.BoardEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {


    Page<BoardEntity> findByTitleContaining(String searchKeyword, Pageable pageable);
}
