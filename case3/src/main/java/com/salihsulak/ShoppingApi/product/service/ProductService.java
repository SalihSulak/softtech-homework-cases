package com.salihsulak.ShoppingApi.product.service;

import com.salihsulak.ShoppingApi.product.converter.ProductMapper;
import com.salihsulak.ShoppingApi.product.dto.ProductDto;
import com.salihsulak.ShoppingApi.product.entity.Product;
import com.salihsulak.ShoppingApi.product.service.entityservice.ProductEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductEntityService productEntityService;

    public void save(ProductDto productDto){
        Product product = ProductMapper.INSTANCE.convertToProduct(productDto);
        productEntityService.save(product);
    }

    public List<ProductDto> listAll(){
        return ProductMapper.INSTANCE.convertToProductDtoList(productEntityService.listProduct());
    }
    public ProductDto findById(UUID id){
        Product product = productEntityService.findById(id);
        return ProductMapper.INSTANCE.convertToProductDto(product);
    }
    public boolean deleteById(UUID id){
        return productEntityService.deleteById(id);
    }
    public void updatePriceById(BigDecimal price, UUID id){
        productEntityService.updatePriceById(price, id);
    }
}
