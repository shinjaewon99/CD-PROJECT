package com.study.nsuBoard.entity;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.time.LocalDateTime;

import static javax.persistence.FetchType.*;

@Entity
@Getter
@Setter
public class Comment extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @Column
    private String commentWriter;

    @Column
    private String commentContents;


    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "board_id")
    private Board board;


    public static Comment toSaveEntity(Comment commentDto, Board board) {
        Comment comment = new Comment();
        comment.setCommentWriter(commentDto.getCommentWriter());
        comment.setCommentContents(commentDto.getCommentContents());
        comment.setBoard(board);
        return comment;
    }
}
