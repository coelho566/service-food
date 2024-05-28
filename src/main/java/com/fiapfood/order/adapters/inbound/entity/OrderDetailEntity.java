package com.fiapfood.order.adapters.inbound.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailEntity {

    private String dateTime;
    private String notes;
    private String deliveryMethod;
}
