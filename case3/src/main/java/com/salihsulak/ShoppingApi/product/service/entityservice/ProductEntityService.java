package com.salihsulak.ShoppingApi.product.service.entityservice;

import com.salihsulak.ShoppingApi.generic.exceptions.GenericBusinessException;
import com.salihsulak.ShoppingApi.product.entity.Product;
import com.salihsulak.ShoppingApi.product.enums.ProductErrorMessage;
import com.salihsulak.ShoppingApi.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductEntityService {

    private final ProductRepository productRepository;

    public void save(Product product) {
        try {
            productRepository.save(product);
        }
        catch (Exception e) {
            throw new GenericBusinessException(ProductErrorMessage.PRODUCT_SAVE_FAIL);
        }
    }

    public List<Product> listProduct(){
        return productRepository.findAll();
    }

    public Product findById(UUID id){
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent())
            return product.get();
        else
            throw new GenericBusinessException(ProductErrorMessage.PRODUCT_NOT_FOUND);
    }
    public boolean deleteById(UUID id){
        if (productRepository.existsById(id))
            productRepository.deleteById(id);
        else
            throw new GenericBusinessException(ProductErrorMessage.PRODUCT_NOT_FOUND);
        return true;
    }

    public void updatePriceById(BigDecimal price, UUID id){
        productRepository.updatePriceById(price, id);
    }

    public boolean productExistById(UUID id){return productRepository.existsById(id);}

    public String findProductNameById(UUID id){return productRepository.findProductNameById(id);}
}
