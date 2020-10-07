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
     * Количество c дополнительным разрядом
     */
    const val COLUMN_QUANTITY_DAL = "QUANTITY_DAL"

    /**
     * Регистрационный номер раздела справки 2
     */
    const val COLUMN_INFORM_F2_REG_ID = "INFORM_F2_REG_ID"

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