package ru.evotor.egais.api.provider.converter

import java.math.BigDecimal

internal object MoneyBigDecimalConverter {

    @JvmStatic
    fun toBigDecimal(value: Long): BigDecimal {
        return BigDecimalConverter.toBigDecimal(value, Pow.MONEY_POW)
    }

    @JvmStatic
    fun toLong(value: BigDecimal): Long {
        return BigDecimalConverter.toLong(value, Pow.MONEY_POW)
    }
}