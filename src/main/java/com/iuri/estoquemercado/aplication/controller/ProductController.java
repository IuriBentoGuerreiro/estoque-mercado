package com.iuri.estoquemercado.aplication.controller;

import com.iuri.estoquemercado.aplication.dto.ProductRequest;
import com.iuri.estoquemercado.aplication.dto.ProductResponse;
import com.iuri.estoquemercado.aplication.dto.filter.ProductFilter;
import com.iuri.estoquemercado.aplication.service.ProductService;
import com.iuri.estoquemercado.domain.model.Product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Product")
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    @Operation(summary = "save")
    public ResponseEntity<ProductResponse> saveProduct(@Valid @RequestBody ProductRequest productRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.saveProduct(productRequest));
    }

    @Operation(summary = "get by id")
    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable Integer id) {
        return ProductResponse.convert(productService.getProductById(id));
    }

    @Operation(summary = "list")
    @GetMapping
    public ResponseEntity<Page<Product>> listAllProducts(ProductFilter filter, Pageable pageable) {
        return ResponseEntity.ok(productService.listAllProducts(filter, pageable));
    }

    @Operation(summary = "update")
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProductById(@PathVariable Integer id, @Valid
    @RequestBody ProductRequest productRequest) {
        Product product = productService.updateProductById(id, productRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(ProductResponse.convert(product));
    }

    @Operation(summary = "delete")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
    }
}