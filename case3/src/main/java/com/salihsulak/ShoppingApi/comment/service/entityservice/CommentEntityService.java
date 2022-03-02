package com.salihsulak.ShoppingApi.comment.service.entityservice;


import com.salihsulak.ShoppingApi.comment.entity.Comment;
import com.salihsulak.ShoppingApi.comment.enums.CommentErrorMessage;
import com.salihsulak.ShoppingApi.comment.repository.CommentRepository;
import com.salihsulak.ShoppingApi.generic.exceptions.GenericBusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommentEntityService {

    private final CommentRepository commentRepository;

    public Comment save(Comment comment){
        try {
            commentRepository.save(comment);
        }
        catch (Exception e){
            throw new GenericBusinessException(CommentErrorMessage.SAVE_FAILED);
        }
        return comment;
    }
    public List<Comment> findCommentsByUser(UUID id){

        return commentRepository.findByUser_Id(id);

    }
    public List<Comment> findCommentsByProduct(UUID id){

        return commentRepository.findByProduct_Id(id);
    }

    public void deleteCommentById(UUID id){
        if(commentRepository.existsById(id))
            commentRepository.deleteById(id);
        else
            throw new GenericBusinessException(CommentErrorMessage.NOT_FOUND);
    }

}
