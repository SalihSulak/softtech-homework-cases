package com.salihsulak.ShoppingApi.comment.converter;

import com.salihsulak.ShoppingApi.comment.dto.CommentDto;
import com.salihsulak.ShoppingApi.comment.entity.Comment;

import java.util.ArrayList;
import java.util.List;

public class CommentConverter {

    public static CommentDto convertToCommentDto(Comment comment){

        CommentDto commentDto = new CommentDto();
        commentDto.setContent(comment.getContent());
        commentDto.setProductId(comment.getProduct().getId());
        commentDto.setUserId(comment.getUser().getId());

        return commentDto;
    }

    public static List<CommentDto> convertToCommentDtoList(List<Comment> comments){
        List<CommentDto> commentDtoList = new ArrayList<>();
        comments.forEach(v->commentDtoList.add(convertToCommentDto(v)));
        return commentDtoList;
    }
}
