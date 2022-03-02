package com.salihsulak.ShoppingApi.product.controller;

import com.salihsulak.ShoppingApi.generic.dto.RestResponse;
import com.salihsulak.ShoppingApi.product.dto.ProductDto;
import com.salihsulak.ShoppingApi.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("products")
public class ProductController {

    private final ProductService productService;

    @PostMapping()
    public ResponseEntity<ProductDto> save(@RequestBody ProductDto productDto){
        productService.save(productDto);
        return ResponseEntity.ok(productDto);
    }
    @GetMapping()
    public ResponseEntity<List<ProductDto>> listAllProducts(){
        return ResponseEntity.ok(productService.listAll());
    }
    @GetMapping("{productId}")
    public ResponseEntity<RestResponse<ProductDto>> findProductById(@PathVariable UUID productId){
        return ResponseEntity.ok(RestResponse.of(productService.findById(productId)));
    }
    @DeleteMapping("{productId}")
    public ResponseEntity<RestResponse<Boolean>> deleteById(@PathVariable UUID productId){
        return ResponseEntity.ok(RestResponse.of(productService.deleteById(productId)));
    }
    @PatchMapping("{productId}")
    public ResponseEntity<RestResponse<Void>> updatePriceById(@PathVariable UUID productId, @RequestParam(name = "price") BigDecimal price){
        productService.updatePriceById(price, productId);
        return ResponseEntity.ok(RestResponse.empty());
    }
}
