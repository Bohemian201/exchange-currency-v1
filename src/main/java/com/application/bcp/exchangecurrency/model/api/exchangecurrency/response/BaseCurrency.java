package com.application.bcp.exchangecurrency.model.api.exchangecurrency.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.math.BigDecimal;

/**
 * POJO BaseCurrency.
 * @author  Joaquin Melgarejo Muñoz
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseCurrency {

    @ApiModelProperty(
            name = "code",
            value = "C&oacutedigo de la m%oacuteneda origen.",
            dataType = "String",
            example = "PEN"
    )
    private String baseCode;

    @ApiModelProperty(
            name = "baseAmount",
            value = "Monto inicial.",
            dataType = "BigDecimal",
            example = "1000.56"
    )
    private BigDecimal baseAmount;
}
