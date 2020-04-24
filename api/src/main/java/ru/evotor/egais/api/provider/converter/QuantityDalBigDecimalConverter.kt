package ru.evotor.egais.api.provider.converter

import java.math.BigDecimal

internal object QuantityDalBigDecimalConverter {

    @JvmStatic
    fun toBigDecimal(value: Long): BigDecimal {
        return BigDecimalConverter.toBigDecimal(value, Pow.QUANTITY_POW_DAL)
    }

    @JvmStatic
    fun toLong(value: BigDecimal): Long {
        return BigDecimalConverter.toLong(value, Pow.QUANTITY_POW_DAL)
    }
}
