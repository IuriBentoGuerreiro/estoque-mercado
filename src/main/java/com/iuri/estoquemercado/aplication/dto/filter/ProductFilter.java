package com.iuri.estoquemercado.aplication.dto.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iuri.estoquemercado.infrastructure.predicate.ProductPredicate;
import com.querydsl.core.BooleanBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductFilter {

    private String productName;

    @JsonIgnore
    public BooleanBuilder toPredicate(){
        return new ProductPredicate()
                .withProductName(productName)
                .builder();
    }
}
