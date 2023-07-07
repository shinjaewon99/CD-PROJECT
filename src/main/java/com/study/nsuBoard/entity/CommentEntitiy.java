package com.study.nsuBoard.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
public class CommentEntitiy extends Base {

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
    private BoardEntity boardEntity;


    public static CommentEntitiy toSaveEntity(CommentEntitiy commentEntitiyDto, BoardEntity boardEntity) {
        CommentEntitiy commentEntitiy = new CommentEntitiy();
        commentEntitiy.setCommentWriter(commentEntitiyDto.getCommentWriter());
        commentEntitiy.setCommentContents(commentEntitiyDto.getCommentContents());
        commentEntitiy.setBoardEntity(boardEntity);
        return commentEntitiy;
    }
}
