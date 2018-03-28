package ru.evotor.egais.api.provider.converter

import java.math.BigDecimal

internal object BigDecimalConverter {

    @JvmStatic
    fun toBigDecimal(value: Long, pow: BigDecimal): BigDecimal {
        return BigDecimal(value).divide(pow)
    }

    @JvmStatic
    fun toLong(value: BigDecimal, pow: BigDecimal): Long {
        return value.multiply(pow).setScale(0, BigDecimal.ROUND_HALF_UP).toLong()
    }
}