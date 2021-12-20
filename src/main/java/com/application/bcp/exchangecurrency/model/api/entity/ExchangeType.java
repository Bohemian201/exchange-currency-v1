package com.application.bcp.exchangecurrency.model.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Repository ExchangeType to read TB_EXCHANGE.
 * @author  Joaquin Melgarejo Muñoz
 */
@Entity(name = "tb_exchange")
@Getter
@Setter
@Table(name = "TB_EXCHANGE")
public class ExchangeType {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    private String id;

    @Column(name = "CURRENCY_TYPE")
    private String currencyType;

    @Column(name = "CURRENCY_TYPE_DESCRIPTION")
    private String currencyTypeDescription;

    @Column(name = "CURRENCY_EXCHANGE_RATE")
    private BigDecimal currencyExchangeRate;
}
