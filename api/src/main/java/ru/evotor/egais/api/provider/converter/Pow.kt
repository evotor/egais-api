package ru.evotor.egais.api.provider.converter

import java.math.BigDecimal

internal object Pow {

    private const val MAX_PERCENT_PRECISION = 2
    private const val MAX_MONEY_PRECISION = 2
    private const val MAX_QUANTITY_PRECISION = 3
    private const val MAX_QUANTITY_PRECISION_DAL = 4
    private const val MAX_ALCOHOL_BY_VOLUME_PRECISION = 3
    private const val MAX_TARE_VOLUME_PRECISION = 3

    val PERCENT_POW = BigDecimal(100).setScale(MAX_PERCENT_PRECISION)

    val MONEY_POW = BigDecimal(100).setScale(MAX_MONEY_PRECISION)

    val QUANTITY_POW = BigDecimal(1000).setScale(MAX_QUANTITY_PRECISION)

    val QUANTITY_POW_DAL = BigDecimal(10000).setScale(MAX_QUANTITY_PRECISION_DAL)

    val ALCOHOL_BY_VOLUME_POW = BigDecimal(1000).setScale(MAX_ALCOHOL_BY_VOLUME_PRECISION)

    val TARE_VOLUME_POW = BigDecimal(1000).setScale(MAX_TARE_VOLUME_PRECISION)
}