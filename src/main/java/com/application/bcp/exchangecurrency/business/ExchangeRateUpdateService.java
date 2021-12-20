package com.application.bcp.exchangecurrency.business;

import com.application.bcp.exchangecurrency.model.api.exchangerateupdate.request.ExchangeRateUpdateRequest;

/**
 * Interface ExchangeRateUpdateService.
 * @author  Joaquin Melgarejo Muñoz
 */
public interface ExchangeRateUpdateService {

    Boolean updateExchangeRate(ExchangeRateUpdateRequest request);
}
