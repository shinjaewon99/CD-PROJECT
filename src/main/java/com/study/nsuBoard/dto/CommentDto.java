package com.study.nsuBoard.dto;


import com.study.nsuBoard.entity.CommentEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class CommentDto extends CommentEntity {

    private Long id;
    private String commentWriter;
    private String commentContents;
    private Integer boardId;
    private LocalDateTime commentSavedTime;

    public static CommentDto toCommnetDto(CommentEntity commentEntity) {
        CommentDto commentDto = new CommentDto();
        commentDto.setId(commentEntity.getId());
        commentDto.setCommentWriter(commentEntity.getCommentWriter());
        commentDto.setCommentContents(commentEntity.getCommentContents());
        commentDto.setCommentSavedTime(commentEntity.getCreatedTime());
        commentDto.setBoardId(commentEntity.getBoard().getId());

        return commentDto;
    }
}
