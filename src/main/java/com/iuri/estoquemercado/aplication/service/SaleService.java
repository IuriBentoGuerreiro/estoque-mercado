package com.iuri.estoquemercado.aplication.service;

import com.iuri.estoquemercado.aplication.dto.SaleItemRequest;
import com.iuri.estoquemercado.aplication.dto.SaleRequest;
import com.iuri.estoquemercado.aplication.dto.filter.SaleFilter;
import com.iuri.estoquemercado.domain.model.Product;
import com.iuri.estoquemercado.domain.model.Sale;
import com.iuri.estoquemercado.domain.model.SaleItem;
import com.iuri.estoquemercado.infrastructure.repository.SaleRepository;
import com.querydsl.core.BooleanBuilder;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ProductService productService;

    @Transactional
    public Sale saveSale(SaleRequest saleRequest) {
        Sale sale = Sale.builder()
                .clientName(saleRequest.getClientName())
                .saleDate(LocalDateTime.now())
                .items(new ArrayList<>())
                .build();

        for (SaleItemRequest itemRequest : saleRequest.getSaleItems()) {
            Product product = productService.getProductById(itemRequest.getProductId());

            SaleItem saleItem = SaleItem.builder()
                    .product(product)
                    .sale(sale)
                    .quantity(itemRequest.getQuantity())
                    .build();

            sale.addItem(saleItem);
        }

        return saleRepository.save(sale);
    }

    public Page<Sale> listAllSales(SaleFilter filter, Pageable pageable) {
        BooleanBuilder predicate = filter.toPredicate();
        return saleRepository.findAll(predicate, pageable);
    }

    public Sale getSaleById(Integer id) {
        return saleRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Recurso não encontrado")
        );
    }

    @Transactional
    public void deleteSale(Integer id) {
        saleRepository.deleteById(id);
    }

    private void reduceStock(Integer idProduct, int quantity) {
        Product product = productService.getProductById(idProduct);
        product.setStockQuantity(product.getStockQuantity() - quantity);
    }
}