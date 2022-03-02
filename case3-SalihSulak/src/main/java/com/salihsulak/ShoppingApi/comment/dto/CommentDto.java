package com.salihsulak.ShoppingApi.comment.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CommentDto {

    private String content;

    private UUID productId;

    private UUID userId;

}
