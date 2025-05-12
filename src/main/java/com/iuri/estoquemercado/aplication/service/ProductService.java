package com.iuri.estoquemercado.aplication.service;

import com.iuri.estoquemercado.aplication.dto.ProductStockUpdate;
import com.iuri.estoquemercado.aplication.dto.ProductRequest;
import com.iuri.estoquemercado.aplication.dto.ProductResponse;
import com.iuri.estoquemercado.domain.model.Product;
import com.iuri.estoquemercado.infrastructure.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(ProductRequest productRequest){
        return productRepository.save(Product.convert(productRequest));
    }

    public Product getProductById(Integer id){
        return productRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("Recurso não encontrado")
        );
    }

    public Page<Product> listAllProducts(Pageable pageable){
        return productRepository.findAll(pageable);
    }

    public Product updateProductById(Integer id, ProductRequest productRequest){
        Product saveProduct = getProductById(id);
        BeanUtils.copyProperties(productRequest, saveProduct, "id");
        return productRepository.save(saveProduct);
    }

    public void deleteProduct(Integer id){
        productRepository.deleteById(id);
    }

    public ProductResponse updateStock(Integer id, ProductStockUpdate stockUpdate){
       Product product = getProductById(id);
       Integer updateQuantity = product.getStockQuantity() + stockUpdate.getStockQuantity();
       product.setStockQuantity(updateQuantity);
       BeanUtils.copyProperties(product, updateQuantity, "id", "name", "price");
       productRepository.save(product);
       return ProductResponse.convert(product);
    }
}