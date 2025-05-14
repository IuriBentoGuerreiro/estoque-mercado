package com.iuri.estoquemercado.infrastructure.predicate;

import com.iuri.estoquemercado.domain.model.QSale;
import com.querydsl.core.BooleanBuilder;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;

public class SalePredicate {

    private final QSale sale = QSale.sale;
    private final BooleanBuilder builder;

    public SalePredicate() {
        this.builder = new BooleanBuilder();
    }

    public SalePredicate withClientName(String customerName) {
        if (!StringUtils.isEmpty(customerName)) {
            builder.and(sale.clientName.likeIgnoreCase("%" + customerName + "%"));
        }
        return this;
    }

    public SalePredicate withDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        if (startDate != null && endDate != null) {
            builder.and(sale.saleDate.between(startDate, endDate));
        } else if (startDate != null) {
            builder.and(sale.saleDate.goe(startDate));
        } else if (endDate != null) {
            builder.and(sale.saleDate.loe(endDate));
        }
        return this;
    }

    public BooleanBuilder build() {
        return builder;
    }
}
