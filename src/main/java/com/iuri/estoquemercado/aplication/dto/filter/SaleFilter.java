package com.iuri.estoquemercado.aplication.dto.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iuri.estoquemercado.infrastructure.predicate.SalePredicate;
import com.querydsl.core.BooleanBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleFilter {

    private String clientName;
    private LocalDate startDate;
    private LocalDate endDate;

    @JsonIgnore
    public BooleanBuilder toPredicate() {
        LocalDateTime startDateAndTime = null;
        LocalDateTime endDateAndTime = null;

        if (this.startDate != null) {
            startDateAndTime = this.startDate.atStartOfDay();
        }

        if (this.endDate != null) {
            endDateAndTime = this.endDate.atTime(23, 59, 59, 999999999);
        }

        return new SalePredicate()
                .withClientName(this.clientName)
                .withDateRange(startDateAndTime, endDateAndTime)
                .build();
    }
}
