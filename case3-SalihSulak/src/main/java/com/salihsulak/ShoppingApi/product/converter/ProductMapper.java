package com.salihsulak.ShoppingApi.product.converter;

import com.salihsulak.ShoppingApi.product.dto.ProductDto;
import com.salihsulak.ShoppingApi.product.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product convertToProduct(ProductDto productDto);

    List<ProductDto> convertToProductDtoList(List<Product> productList);

    ProductDto convertToProductDto(Product product);
}
