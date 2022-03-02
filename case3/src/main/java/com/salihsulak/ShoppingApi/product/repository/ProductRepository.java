package com.salihsulak.ShoppingApi.product.repository;

import com.salihsulak.ShoppingApi.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    @Transactional
    @Modifying
    @Query("update Product p set p.price = ?1 where p.id = ?2")
    void updatePriceById(BigDecimal price, UUID id);

    @Query("select p.name from Product p where p.id=?1")
    String findProductNameById(UUID id);

}
