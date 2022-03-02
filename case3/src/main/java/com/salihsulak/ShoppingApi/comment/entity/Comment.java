package com.salihsulak.ShoppingApi.comment.entity;

import com.salihsulak.ShoppingApi.product.entity.Product;
import com.salihsulak.ShoppingApi.user.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "product_id" ,nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_id" ,nullable = false)
    private User user;

}
