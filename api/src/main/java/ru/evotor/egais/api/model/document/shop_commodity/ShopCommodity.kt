package ru.evotor.egais.api.model.document.shop_commodity

import ru.evotor.egais.api.model.document.EgaisDocument
import java.math.BigDecimal
import java.util.*

data class ShopCommodity(
        @JvmField val uuid: UUID,
        @JvmField var quantity: BigDecimal,
        @JvmField var productInfoAlcCode: String
) : EgaisDocument()
