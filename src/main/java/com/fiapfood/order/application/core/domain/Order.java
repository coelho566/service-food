package com.fiapfood.order.application.core.domain;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order{
    @Valid
    private Client client;
    @Valid
    @Size(min = 1,message = "Informe algum item")
    private List<Item> items;
    private OrderDetail orderDetail;
    @Valid
    private Total total;
    @Valid
    private Payment payment;
}
