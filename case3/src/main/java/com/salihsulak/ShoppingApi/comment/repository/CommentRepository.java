package com.salihsulak.ShoppingApi.comment.repository;

import com.salihsulak.ShoppingApi.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, UUID> {
    List<Comment> findByUser_Id(UUID id);

    List<Comment> findByProduct_Id(UUID id);

}
