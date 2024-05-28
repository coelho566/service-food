package com.fiapfood.order.adapters.inbound.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TotalEntity {

    private Double subtotal;
    private Double taxes;
    private Double discount;
    private Double finalTotal;
}
