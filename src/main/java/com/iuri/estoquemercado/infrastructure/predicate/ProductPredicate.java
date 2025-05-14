package com.iuri.estoquemercado.infrastructure.predicate;

import com.iuri.estoquemercado.domain.model.QProduct;
import com.querydsl.core.BooleanBuilder;
import org.apache.commons.lang3.StringUtils;

public class ProductPredicate {

    private final QProduct product = QProduct.product;
    private final BooleanBuilder builder;

    public ProductPredicate() {
        this.builder = new BooleanBuilder();
    }

    public ProductPredicate withProductName(String productName) {
        if (!StringUtils.isEmpty(productName)) {
            builder.and(product.name.likeIgnoreCase("%" + productName + "%"));
        }
        return this;
    }

    public BooleanBuilder builder() {
        return builder;
    }
}
