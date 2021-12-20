package com.application.bcp.exchangecurrency.repository;

import com.application.bcp.exchangecurrency.model.api.entity.ExchangeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;


@Repository
@Transactional(readOnly = true)
public interface ExchangeCurrencyRepository extends JpaRepository<ExchangeType, Long> {

    @Query("SELECT te FROM tb_exchange te WHERE te.currencyType = :currencyType")
    ExchangeType findExchangeType(@Param("currencyType") String currencyType);

    @Modifying
    @Query("UPDATE tb_exchange te "
            + "SET  te.currencyExchangeRate =:currencyExchangeRate "
            + "WHERE te.currencyType = :currencyType")
    void updateExchangeRate(
            @Param("currencyType") String currencyType,
            @Param("currencyExchangeRate") BigDecimal currencyExchangeRate);

}
