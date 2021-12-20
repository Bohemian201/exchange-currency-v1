package com.application.bcp.exchangecurrency.model.api.exchangecurrency.request;


import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;


/**
 * POJO ExchangeCurrencyRequest.
 * @author  Joaquin Melgarejo Muñoz
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeCurrencyRequest {

    @NotNull(message = "{exception.exchangeCurrency.amount.null}")
    @ApiModelProperty(
            name = "amount",
            value = "Monto de dinero a transformar.",
            dataType = "BigDecimal",
            example = "1000.56"
    )
    private BigDecimal amount;

    @NotNull(message = "{exception.exchangeCurrency.baseCurrency.null}")
    @Size(min = 3, max = 3, message = "{exception.exchangeCurrency.baseCurrency.size}")
    @ApiModelProperty(
            name = "baseCurrency",
            value = "M%oacuteneda origen.",
            dataType = "String",
            example = "PEN"
    )
    private String baseCurrency;

    @NotNull(message = "{exception.exchangeCurrency.transformCurrency.null}")
    @Size(min = 3, max = 3, message = "{exception.exchangeCurrency.transformCurrency.size}")
    @ApiModelProperty(
            name = "transformCurrency",
            value = "M%oacuteneda destino.",
            dataType = "String",
            example = "DOL"
    )
    private String transformCurrency;

}
