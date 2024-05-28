package com.fiapfood.order.application.core.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payment{
    @Schema(description = "Método de pagamento", example = "Cartão de crédito")
    @NotBlank(message = "O método de pagamento não pode estar em branco")
    private String method;

    @Schema(description = "Status do pagamento", example = "PENDENTE")
    @NotNull(message = "O status do pagamento não pode ser nulo")
    private PaymentEnum status;

    @Schema(description = "Detalhes adicionais do pagamento", example = "Transação pendente")
    private String details;
}
