package com.application.bcp.exchangecurrency.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * POJO ValidationError.
 * @author  Joaquin Melgarejo Muñoz
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ValidationError {
    String field;
    String message;
}
