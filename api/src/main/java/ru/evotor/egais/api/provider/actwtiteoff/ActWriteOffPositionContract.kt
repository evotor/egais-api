package ru.evotor.egais.api.provider.actwtiteoff

import android.net.Uri

internal object ActWriteOffPositionContract {
    @JvmField
    val PATH = "ActWriteOffPosition"

    @JvmField
    val URI = Uri.withAppendedPath(ActWriteOffContract.BASE_URI, PATH)

    /**
     * Уникальный идентификатор позиции акта списания со склада
     */
    const val COLUMN_UUID = "UUID"

    /**
     * Уникальный идентификатор акта списания со склада
     */
    const val COLUMN_ACT_WRITE_OFF_UUID = "ACT_WRITE_OFF_UUID"

    /**
     * Идентификатор позиции акта списания со склада
     */
    const val COLUMN_IDENTITY = "IDENTITY"

    /**
     * Количество
     */
    const val COLUMN_QUANTITY = "QUANTITY"

    /**
     * Регистрационный номер раздела справки Б
     */
    const val COLUMN_INFORM_B_REG_ID = "INFORM_B_REG_ID"

    /**
     * Информация о марках в формате JSON
     */
    const val COLUMN_INFORM_B_MARK_INFO_JSON = "INFORM_B_MARK_INFO_JSON"

    /**
     * Алкокод информации о продукции
     */
    const val COLUMN_PRODUCT_INFO_ALC_CODE = "PRODUCT_INFO_ALC_CODE"

    /**
     * Перечень считанных кодов марок
     */
    const val COLUMN_MARK_LIST = "MARK_LIST"
}