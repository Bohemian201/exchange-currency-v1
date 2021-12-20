package com.application.bcp.exchangecurrency.utils;

import java.math.BigDecimal;

import static com.application.bcp.exchangecurrency.utils.constants.Constants.AMOUNT_ROUNDING_MODE;
import static com.application.bcp.exchangecurrency.utils.constants.Constants.DECIMALS;

/**
 * Utilitario AmountUtils.
 *
 * @author Joaquin Melgarejo Muñoz
 */
public class AmountUtils {

    /**
     * Method round.
     * Redondea el valor de un numero con hasta 4 decimales.
     *
     * @param amount BigDecimal
     * @return BigDecimal
     */
    public static BigDecimal round(BigDecimal amount) {
        if (amount == null) {
            return null;
        }
        return amount.setScale(DECIMALS, AMOUNT_ROUNDING_MODE);
    }
}
