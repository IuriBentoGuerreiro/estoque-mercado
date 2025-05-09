package com.iuri.estoquemercado.service;

import com.iuri.estoquemercado.dto.ProductStockUpdate;
import com.iuri.estoquemercado.dto.ProductRequest;
import com.iuri.estoquemercado.dto.ProductResponse;
import com.iuri.estoquemercado.model.Product;
import com.iuri.estoquemercado.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<ProductResponse> listAllProducts(){
        return productRepository.findAll().stream().map(
                ProductResponse::convert).toList();
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