package com.study.nsuBoard.dto;


import com.study.nsuBoard.entity.CommentEntitiy;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class CommentEntitiyDto extends CommentEntitiy {

    private Long id;
    private String commentWriter;
    private String commentContents;
    private Integer boardId;
    private LocalDateTime commentSavedTime;

    public static CommentEntitiyDto toCommnetDto(CommentEntitiy commentEntitiy) {
        CommentEntitiyDto commentDto = new CommentEntitiyDto();
        commentDto.setId(commentEntitiy.getId());
        commentDto.setCommentWriter(commentEntitiy.getCommentWriter());
        commentDto.setCommentContents(commentEntitiy.getCommentContents());
        commentDto.setCommentSavedTime(commentEntitiy.getCreatedTime());
        commentDto.setBoardId(commentEntitiy.getBoardEntity().getId());

        return commentDto;
    }
}
