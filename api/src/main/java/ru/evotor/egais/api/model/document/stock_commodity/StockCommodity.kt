package ru.evotor.egais.api.model.document.stock_commodity

import ru.evotor.egais.api.model.document.EgaisDocument
import java.math.BigDecimal
import java.util.*

data class StockCommodity(
        @JvmField val uuid: UUID,
        @JvmField val informF1RegId: String,
        @JvmField val informF2RegId: String,
        @JvmField var quantity: BigDecimal,
        @JvmField var productInfoAlcCode: String
) : EgaisDocument()
