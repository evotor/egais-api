package ru.evotor.egais.api.provider.actwtiteoff

import android.net.Uri

internal object ActWriteOffShopPositionContract {
    @JvmField
    val PATH = "ActWriteOffShopPosition"

    @JvmField
    val URI = Uri.withAppendedPath(ActWriteOffShopContract.BASE_URI, PATH)

    /**
     * Уникальный идентификатор позиции акта списания из магазина
     */
    const val COLUMN_UUID = "UUID"

    /**
     * Уникальный идентификатор акта списания из магазина
     */
    const val COLUMN_ACT_WRITE_OFF_SHOP_UUID = "ACT_WRITE_OFF_SHOP_UUID"

    /**
     * Идентификатор позиции акта списания из магазина (клиентский, к заполнению необязательный)
     */
    const val COLUMN_IDENTITY = "IDENTITY"

    /**
     * Количество
     */
    const val COLUMN_QUANTITY = "QUANTITY"

    /**
     * Количество c дополнительным разрядом
     */
    const val COLUMN_QUANTITY_DAL = "QUANTITY_DAL"

    /**
     * Информация о марках в формате JSON
     */
    const val COLUMN_INFORM_F2_MARK_INFO_JSON = "INFORM_F2_MARK_INFO_JSON"

    /**
     * Алкокод информации о продукции
     */
    const val COLUMN_PRODUCT_INFO_ALC_CODE = "PRODUCT_INFO_ALC_CODE"

    /**
     * Перечень считанных кодов марок
     */
    const val COLUMN_MARK_LIST = "MARK_LIST"

    /**
     * Сумма продажи. Обязательно для заполнения при причине списания "Реализация"
     */
    const val COLUMN_SUM_SALE = "SUM_SALE"
}