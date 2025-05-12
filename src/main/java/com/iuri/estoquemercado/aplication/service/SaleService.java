package com.iuri.estoquemercado.aplication.service;

import com.iuri.estoquemercado.aplication.dto.SaleRequest;
import com.iuri.estoquemercado.aplication.dto.SaleResponse;
import com.iuri.estoquemercado.domain.model.Sale;
import com.iuri.estoquemercado.domain.model.Product;
import com.iuri.estoquemercado.infrastructure.repository.SaleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.math.BigDecimal;
import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ProductService productService;

    @Transactional
    public SaleResponse saveSale(SaleRequest saleRequest){
        Sale sale = saleRepository.save(Sale.builder()
                        .product(productService.getProductById(saleRequest.getIdProduct()))
                        .quantity(saleRequest.getQuantity())
                        .totalPrice(totalPrice(Sale.convert(saleRequest), saleRequest.getIdProduct()))
                        .client(saleRequest.getClient())
                .build());
        reduceStock(saleRequest.getIdProduct(), saleRequest.getQuantity());
        return SaleResponse.convert(sale);
    }

    public List<SaleResponse> listAllSales(){
        return saleRepository.findAll().stream().map(
                SaleResponse::convert).toList();
    }

    public Sale getSaleById(Integer id){
        return saleRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Recurso não encontrado")
        );
    }

    @Transactional
    public void deleteSale(Integer id){
        returnStock(id);
        saleRepository.deleteById(id);
    }

    private BigDecimal totalPrice(Sale sale, Integer idProduct){
        Product product = productService.getProductById(idProduct);
        BigDecimal quantity = BigDecimal.valueOf(sale.getQuantity());
        BigDecimal totalPrice = quantity.multiply(product.getPrice());
        sale.setTotalPrice(totalPrice);
        return  totalPrice;
    }

    private void reduceStock(Integer idProduct, int quantity){
        Product product = productService.getProductById(idProduct);
        product.setStockQuantity(product.getStockQuantity() - quantity);
    }

    private void returnStock(Integer id){
        Sale sale = getSaleById(id);
        Product product = sale.getProduct();
        product.setStockQuantity(product.getStockQuantity() + sale.getQuantity());
    }
}