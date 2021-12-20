package com.application.bcp.exchangecurrency.business;

import com.application.bcp.exchangecurrency.model.api.exchangecurrency.request.ExchangeCurrencyRequest;
import com.application.bcp.exchangecurrency.model.api.exchangecurrency.response.ExchangeCurrencyResponse;
import io.reactivex.Single;

/**
 * Interface getExchangeCurrency.
 * @author  Joaquin Melgarejo Muñoz
 */
public interface ExchangeCurrencyService {

    Single<ExchangeCurrencyResponse> getExchangeCurrency(ExchangeCurrencyRequest request);
}
