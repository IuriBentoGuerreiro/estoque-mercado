package com.iuri.estoquemercado.controller;

import com.iuri.estoquemercado.dto.ProductRequest;
import com.iuri.estoquemercado.dto.ProductResponse;
import com.iuri.estoquemercado.dto.ProductStockUpdate;
import com.iuri.estoquemercado.model.Product;
import com.iuri.estoquemercado.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "produto")
@RestController
@RequestMapping("/products")
public class ProdutoController {

    @Autowired
    private ProductService productService;

    @PostMapping
    @Operation(summary = "save")
    public ResponseEntity<ProductResponse> saveProduct(@Valid @RequestBody ProductRequest productRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body
                (ProductResponse.convert(productService.saveProduct(productRequest)));
    }

    @Operation(summary = "get by id")
    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable Integer id) {
        return ProductResponse.convert(productService.getProductById(id));
    }

    @Operation(summary = "list")
    @GetMapping
    public ResponseEntity<List<ProductResponse>> listAllProducts() {
        return ResponseEntity.ok().body(productService.listAllProducts());
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

    @Operation(summary = "update stock")
    @PutMapping("/{id}/product")
    public ResponseEntity<ProductResponse> updateStock(@PathVariable Integer id, @Valid
    @RequestBody ProductStockUpdate stockUpdate) {
        ProductResponse productResponse = productService.updateStock(id, stockUpdate);
        return ResponseEntity.status(HttpStatus.CREATED).body(productResponse);
    }
}