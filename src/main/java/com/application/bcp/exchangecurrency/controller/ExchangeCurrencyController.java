package com.application.bcp.exchangecurrency.controller;

import com.application.bcp.exchangecurrency.business.ExchangeCurrencyService;
import com.application.bcp.exchangecurrency.model.api.exchangecurrency.request.ExchangeCurrencyRequest;
import com.application.bcp.exchangecurrency.model.api.exchangecurrency.response.ExchangeCurrencyResponse;
import io.reactivex.Single;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Controller ExchangeCurrencyController.
 *
 * @author Joaquin Melgarejo Muñoz
 */
@RestController
@Validated
@RequestMapping(value = "/exchange-currency/v1")
public class ExchangeCurrencyController {

    @Autowired
    private ExchangeCurrencyService exchangeCurrencyService;

    public ExchangeCurrencyController(ExchangeCurrencyService exchangeCurrencyService) {
        this.exchangeCurrencyService = exchangeCurrencyService;
    }

    @PostMapping(
            value = "/transform",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @ApiOperation(
            value = "Transforma un monto a un tipo de divisa",
            produces = MediaType.APPLICATION_JSON_VALUE,
            response = ExchangeCurrencyResponse.class,
            httpMethod = "POST"
    )
    @ApiResponses({
            @ApiResponse(code = 200,
                    message = "Se obtuvo el monto transformado al tipo de cambio solicitado",
                    response = ExchangeCurrencyResponse.class),
            @ApiResponse(code = 500,
                    message = "Error",
                    response = Exception.class),
    })
    public Single<ExchangeCurrencyResponse> getCurrencyExchange(@Valid @RequestBody ExchangeCurrencyRequest request) {
        return exchangeCurrencyService.getExchangeCurrency(request);
    }

}
