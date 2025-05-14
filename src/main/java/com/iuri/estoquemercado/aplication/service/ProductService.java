package com.iuri.estoquemercado.aplication.service;

import com.iuri.estoquemercado.aplication.dto.ProductRequest;
import com.iuri.estoquemercado.aplication.dto.ProductResponse;
import com.iuri.estoquemercado.aplication.dto.filter.ProductFilter;
import com.iuri.estoquemercado.domain.model.Product;
import com.iuri.estoquemercado.infrastructure.repository.ProductRepository;
import com.querydsl.core.BooleanBuilder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductResponse saveProduct(ProductRequest productRequest){
        Product product = productRepository.save(Product.builder()
                        .name(productRequest.getName())
                        .description(productRequest.getDescription())
                        .stockQuantity(productRequest.getStockQuantity())
                        .price(productRequest.getPrice())
                        .isActive(true)
                .build());

        return ProductResponse.convert(product);
    }

    public Product getProductById(Integer id){
        return productRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("Recurso não encontrado")
        );
    }

    public Page<Product> listAllProducts(ProductFilter filter, Pageable pageable){
        BooleanBuilder predicate = filter.toPredicate();
        return productRepository.findAll(predicate, pageable);
    }

    public Product updateProductById(Integer id, ProductRequest productRequest){
        Product saveProduct = getProductById(id);
        BeanUtils.copyProperties(productRequest, saveProduct, "id");
        return productRepository.save(saveProduct);
    }

    public void deleteProduct(Integer id){
        productRepository.deleteById(id);
    }
}