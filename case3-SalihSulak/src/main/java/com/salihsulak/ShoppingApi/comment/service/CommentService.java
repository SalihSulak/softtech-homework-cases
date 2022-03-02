package com.salihsulak.ShoppingApi.comment.service;

import com.salihsulak.ShoppingApi.comment.converter.CommentConverter;
import com.salihsulak.ShoppingApi.comment.dto.CommentDto;
import com.salihsulak.ShoppingApi.comment.entity.Comment;
import com.salihsulak.ShoppingApi.comment.enums.CommentErrorMessage;
import com.salihsulak.ShoppingApi.comment.exception.ProductHasNotCommented;
import com.salihsulak.ShoppingApi.comment.exception.UserHasNotCommented;
import com.salihsulak.ShoppingApi.comment.service.entityservice.CommentEntityService;
import com.salihsulak.ShoppingApi.generic.exceptions.GenericBusinessException;
import com.salihsulak.ShoppingApi.product.entity.Product;
import com.salihsulak.ShoppingApi.product.enums.ProductErrorMessage;
import com.salihsulak.ShoppingApi.product.service.entityservice.ProductEntityService;
import com.salihsulak.ShoppingApi.user.entity.User;
import com.salihsulak.ShoppingApi.user.enums.UserErrorMessage;
import com.salihsulak.ShoppingApi.user.service.entityservice.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentEntityService commentEntityService;
    private final ProductEntityService productEntityService;
    private final UserEntityService userEntityService;

    public CommentDto save(CommentDto commentDto){
        Comment comment = createCommentObject(commentDto);
        commentEntityService.save(comment);
        return commentDto;
    }

    public List<CommentDto> listCommentsWithFilter(UUID userId, UUID productId){
        if(userId!=null&&productId!=null){
            throw new GenericBusinessException(CommentErrorMessage.FILL_JUST_ONE_INPUT);
        }
        else {
            if (userId != null)
                return findByUserId(userId);
            else if (productId != null)
                return findByProductId(productId);
            else
                throw new GenericBusinessException(CommentErrorMessage.NOT_FOUND);
        }

    }
    public void deleteCommentById(UUID id){
        commentEntityService.deleteCommentById(id);
    }

    private List<CommentDto> findByUserId(UUID id){
        if(userEntityService.userExistById(id)) {
            String username = userEntityService.findUsernameById(id);
            List<Comment> comments = commentEntityService.findCommentsByUser(id);
            if(comments.isEmpty())
                throw new UserHasNotCommented(username);
            else
                return CommentConverter.convertToCommentDtoList(comments);
        }
        else
            throw new GenericBusinessException(UserErrorMessage.USER_NOT_FOUND);
    }

    private List<CommentDto> findByProductId(UUID id){
        if(productEntityService.productExistById(id)) {
            String productName = productEntityService.findProductNameById(id);
            List<Comment> comments = commentEntityService.findCommentsByProduct(id);
            if(comments.isEmpty())
                throw new ProductHasNotCommented(productName);
            return CommentConverter.convertToCommentDtoList(comments);
        }
        else
            throw new GenericBusinessException(ProductErrorMessage.PRODUCT_NOT_FOUND);
    }

    private Comment createCommentObject(CommentDto commentDto){
        Product product = productEntityService.findById(commentDto.getProductId());
        User user = userEntityService.findById(commentDto.getUserId());
        Comment comment = new Comment();
        comment.setContent(commentDto.getContent());
        comment.setProduct(product);
        comment.setUser(user);
        return comment;
    }
}
