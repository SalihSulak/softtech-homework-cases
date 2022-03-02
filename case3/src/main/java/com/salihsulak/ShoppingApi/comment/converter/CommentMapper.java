package com.salihsulak.ShoppingApi.comment.converter;

import com.salihsulak.ShoppingApi.comment.dto.CommentDto;
import com.salihsulak.ShoppingApi.comment.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    Comment convertToComment(CommentDto commentDto);
}
