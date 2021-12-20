package com.application.bcp.exchangecurrency.business.impl;

import com.application.bcp.exchangecurrency.business.ExchangeCurrencyService;
import com.application.bcp.exchangecurrency.model.api.entity.ExchangeType;
import com.application.bcp.exchangecurrency.model.api.exchangecurrency.request.ExchangeCurrencyRequest;
import com.application.bcp.exchangecurrency.model.api.exchangecurrency.response.BaseCurrency;
import com.application.bcp.exchangecurrency.model.api.exchangecurrency.response.ExchangeCurrencyResponse;
import com.application.bcp.exchangecurrency.model.api.exchangecurrency.response.TransformCurrency;
import com.application.bcp.exchangecurrency.repository.ExchangeCurrencyRepository;
import com.application.bcp.exchangecurrency.utils.AmountUtils;
import io.reactivex.Single;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Service Implement ExchangeCurrencyServiceImpl.
 * @author  Joaquin Melgarejo Muñoz
 */
@Service
@Slf4j
public class ExchangeCurrencyServiceImpl implements ExchangeCurrencyService {

    private ExchangeCurrencyRepository repository;

    public ExchangeCurrencyServiceImpl(ExchangeCurrencyRepository repository) {
        this.repository = repository;
    }

    @Override
    public Single<ExchangeCurrencyResponse> getExchangeCurrency(ExchangeCurrencyRequest request) {
        return Single.fromCallable(() -> repository.findExchangeType(request.getTransformCurrency()))
                .doOnError(e -> log.error("Error en el al momento de obtener el tipo de cambio: " + e))
                .map(exchangeType -> ExchangeCurrencyResponse.builder()
                        .baseCurrency(BaseCurrency.builder()
                                .baseCode(request.getBaseCurrency())
                                .baseAmount(AmountUtils.round(request.getAmount()))
                                .build())
                        .transformCurrency(buildTransformCurrency(exchangeType, request))
                        .build());
    }

    /**
     * Method buildTransformCurrency.
     * Obtiene la informacion del monto transformado al tipo de cambio solicitado.
     * @param exchangeType ExchangeType
     * @param request ExchangeCurrencyRequest
     * @return TransformCurrency
     */
    private TransformCurrency buildTransformCurrency(ExchangeType exchangeType, ExchangeCurrencyRequest request) {
        return TransformCurrency.builder()
                .transformCode(exchangeType.getCurrencyType())
                .transformAmount(transformExchangeRate(exchangeType.getCurrencyExchangeRate(), request))
                .exchangeRate(AmountUtils.round(exchangeType.getCurrencyExchangeRate()))
                .build();
    }

    /**
     * Method transformExchangeRate.
     * Obtiene el monto con el tipo de cambio solicitado.
     * @param exchangeRate BigDecimal
     * @param request ExchangeCurrencyRequest
     * @return BigDecimal
     */
    private BigDecimal transformExchangeRate(BigDecimal exchangeRate, ExchangeCurrencyRequest request) {
        return AmountUtils.round(exchangeRate.multiply(request.getAmount()));
    }
}
