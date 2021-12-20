package com.application.bcp.exchangecurrency.controller;

import com.application.bcp.exchangecurrency.business.ExchangeRateUpdateService;
import com.application.bcp.exchangecurrency.model.api.exchangerateupdate.request.ExchangeRateUpdateRequest;
import io.reactivex.Single;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Controller ExchangeRateUpdateController.
 * @author  Joaquin Melgarejo Muñoz
 */
@RestController
@RequestMapping(value = "/exchange-currency/v1")
public class ExchangeRateUpdateController {

    private ExchangeRateUpdateService exchangeRateUpdateService;

    public ExchangeRateUpdateController(ExchangeRateUpdateService exchangeRateUpdateService) {
        this.exchangeRateUpdateService = exchangeRateUpdateService;
    }

    @PostMapping(
            value = "/update-rate",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @ApiOperation(
            value = "Actualiza un tipo de cambio",
            produces = MediaType.APPLICATION_JSON_VALUE,
            response = Boolean.class,
            httpMethod = "POST"
    )
    @ApiResponses({
            @ApiResponse(code = 200,
                    message = "Se actualizo el tipo de cambio.",
                    response = Boolean.class),
            @ApiResponse(code = 500,
                    message = "Error",
                    response = Exception.class),
    })
    public Single<Boolean> getCurrencyExchange(@Valid @RequestBody ExchangeRateUpdateRequest request) {
        return Single.just(exchangeRateUpdateService.updateExchangeRate(request));
    }
}
