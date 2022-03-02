package com.salihsulak.ShoppingApi.comment.controller;

import com.salihsulak.ShoppingApi.comment.dto.CommentDto;
import com.salihsulak.ShoppingApi.comment.service.CommentService;
import com.salihsulak.ShoppingApi.generic.dto.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping()
    public ResponseEntity<RestResponse<CommentDto>> saveComment(@RequestBody CommentDto commentDto){
        return ResponseEntity.ok(RestResponse.of(commentService.save(commentDto)));
    }
    @GetMapping()
    public ResponseEntity<RestResponse<List<CommentDto>>> listCommentsWithFilter(
            @RequestParam(name = "userId" ,required = false)UUID userId, @RequestParam(name = "productId" , required = false) UUID productId){
        return ResponseEntity.ok(RestResponse.of(commentService.listCommentsWithFilter(userId,productId)));
    }

    @DeleteMapping("{commentId}")
    public ResponseEntity<RestResponse<Void>> deleteCommentById(@PathVariable UUID commentId){
        commentService.deleteCommentById(commentId);
        return ResponseEntity.ok(RestResponse.empty());
    }
}
