package com.application.bcp.exchangecurrency.business.impl;

import com.application.bcp.exchangecurrency.business.ExchangeRateUpdateService;
import com.application.bcp.exchangecurrency.model.api.exchangerateupdate.request.ExchangeRateUpdateRequest;
import com.application.bcp.exchangecurrency.repository.ExchangeCurrencyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Service Implement ExchangeRateUpdateServiceImpl.
 *
 * @author Joaquin Melgarejo Muñoz
 */
@Service
@Slf4j
public class ExchangeRateUpdateServiceImpl implements ExchangeRateUpdateService {

    private ExchangeCurrencyRepository repository;

    public ExchangeRateUpdateServiceImpl(ExchangeCurrencyRepository repository) {
        this.repository = repository;
    }

    /**
     * Method updateExchangeRate.
     * Actualiza el tipo de cambio de uan divisa.
     * @param request ExchangeRateUpdateRequest
     * @return Boolean
     */
    @Override
    public Boolean updateExchangeRate(ExchangeRateUpdateRequest request) {
        repository.updateExchangeRate(request.getCurrencyType(), request.getExchangeRate());
        return true;

    }
}
