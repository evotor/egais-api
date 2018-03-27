package ru.evotor.egais.api.provider.converter

import java.math.BigDecimal

internal object QuantityBigDecimalConverter {

    @JvmStatic
    fun toBigDecimal(value: Long): BigDecimal {
        return BigDecimalConverter.toBigDecimal(value, Pow.QUANTITY_POW)
    }

    @JvmStatic
    fun toLong(value: BigDecimal): Long {
        return BigDecimalConverter.toLong(value, Pow.QUANTITY_POW)
    }
}