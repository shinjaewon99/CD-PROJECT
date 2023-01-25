/*package com.study.nsuBoard.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import com.study.nsuBoard.entity.Board;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository{
    private final EntityManager em;

    public void save(Board board){
        em.persist(board);
    }

    public List<Board> findAll(BoardSearch boardSearch){
        return em.createQuery("select b from Board b join b.student s" +
                " where b.name =: name ", Board.class)
                .setParameter("name", boardSearch.getBoardName())
                .getResultList();
    }
}*/




package com.study.nsuBoard.repository;


import com.study.nsuBoard.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {


    Page<Board> findByTitleContaining(String searchKeyword, Pageable pageable);
    // 연관관계
    //  Student student = new Student();
    //        board.setStudent(student);
    //        em.persist(board);
}
