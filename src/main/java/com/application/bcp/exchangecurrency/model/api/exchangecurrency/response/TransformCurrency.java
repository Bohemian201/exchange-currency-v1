package com.application.bcp.exchangecurrency.model.api.exchangecurrency.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.math.BigDecimal;

/**
 * POJO TransformCurrency.
 * @author  Joaquin Melgarejo Muñoz
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransformCurrency {

    @ApiModelProperty(
            name = "lastCurrencyType",
            value = "C&oacutedigo de la m%oacuteneda destino.",
            dataType = "String",
            example = "DOL"
    )
    private String transformCode;

    @ApiModelProperty(
            name = "transformAmount",
            value = "Monto transformado al tipo de cambio solicitado.",
            dataType = "BigDecimal",
            example = "2500.56"
    )
    private BigDecimal transformAmount;

    @ApiModelProperty(
            name = "exchangeRate",
            value = "Valor del tipo de cambio.",
            dataType = "BigDecimal",
            example = "3.56"
    )
    private BigDecimal exchangeRate;
}
