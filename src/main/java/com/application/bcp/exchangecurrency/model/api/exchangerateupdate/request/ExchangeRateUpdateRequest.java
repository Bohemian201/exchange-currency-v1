package com.application.bcp.exchangecurrency.model.api.exchangerateupdate.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * POJO ExchangeRateUpdateRequest.
 * @author  Joaquin Melgarejo Muñoz
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeRateUpdateRequest {


    @NotNull(message = "{exception.updateRate.currencyType.null}")
    @Size(min = 3, max = 3, message = "{exception.updateRate.currencyType.size}")
    @ApiModelProperty(
            name = "currencyType",
            value = "Divisa",
            dataType = "String",
            example = "PEN"
    )
    private String currencyType;

    @NotNull(message = "{exception.updateRate.exchangeRate.null}")
    @ApiModelProperty(
            name = "exchangeRate",
            value = "Nuevo monto del valor del tipo de cambio.",
            dataType = "BigDecimal",
            example = "3.560"
    )
    private BigDecimal exchangeRate;
}
