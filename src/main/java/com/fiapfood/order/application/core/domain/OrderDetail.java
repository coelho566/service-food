package com.fiapfood.order.application.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {
    @Schema(description = "Data e hora do pedido", example = "2024-05-27T15:30:00")
    private String dateTime;

    @Schema(description = "Notas adicionais para o pedido", example = "Sem cebola, por favor.")
    private String notes;

    @Schema(description = "Método de entrega do pedido", example = "Retirada no local")
    private String deliveryMethod;
}
