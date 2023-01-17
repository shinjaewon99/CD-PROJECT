/*
package com.study.nsuBoard.dto;


import com.study.nsuBoard.entity.Comment;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class CommentDto extends Comment {

    private Long id;
    private String commentWriter;
    private String commentContents;
    private Integer boardId;
    private LocalDateTime commentSavedTime;

    public static CommentDto toCommnetDto(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setCommentWriter(comment.getCommentWriter());
        commentDto.setCommentContents(comment.getCommentContents());
        commentDto.setCommentSavedTime(comment.getCreatedTime());
        commentDto.setBoardId(comment.getBoard().getId());

        return commentDto;
    }
}
*/
