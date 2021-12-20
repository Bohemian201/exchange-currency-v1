package com.application.bcp.exchangecurrency.model.api.exchangecurrency.response;


import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * POJO ExchangeCurrencyResponse.
 * @author  Joaquin Melgarejo Muñoz
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeCurrencyResponse {


    @ApiModelProperty(
            name = "baseCurrency",
            value = "Informaci&oacuten inicial del monto a transformar.",
            dataType = "BaseCurrency"
    )
    private BaseCurrency baseCurrency;


    @ApiModelProperty(
            name = "transformCurrency",
            value = "Informaci&oacuten final del monto transformado.",
            dataType = "BaseCurrency"
    )
    private TransformCurrency transformCurrency;

}
