package ru.evotor.egais.api.provider.actchargeon

import android.net.Uri

internal object ActChargeOnPositionContract {

    @JvmField
    val PATH = "ActChargeOnPosition"

    @JvmField
    val URI = Uri.withAppendedPath(ActChargeOnContract.BASE_URI, PATH)

    /**
     * Уникальный идентификатор позиции акта
     */
    const val COLUMN_UUID = "UUID"

    /**
     * Идентификатор акта постановки, содержащего позицию
     */
    const val COLUMN_ACT_CHARGE_ON_UUID = "ACT_CHARGE_ON_UUID"

    /**
     * Идентификатор позиции внутри накладной
     */
    const val COLUMN_IDENTITY = "IDENTITY"

    /**
     * Количество
     */
    const val COLUMN_QUANTITY = "QUANTITY"

    /**
     * Алкокод информации о продукции
     */
    const val COLUMN_PRODUCT_INFO_ALC_CODE = "PRODUCT_INFO_ALC_CODE"

    /**
     * Список считанных кодов марок
     */
    const val COLUMN_MARK_LIST = "MARK_LIST"

    /**
     * Справка 1: Количество
     */
    const val COLUMN_INFORMF1_QUANTITY = "INFORMF1_QUANTITY"

    /**
     * Справка 1: Дата розлива продукции
     */
    const val COLUMN_INFORMF1_BOTTLING_DATE = "INFORMF1_BOTTLING_DATE"

    /**
     * Справка 1: Номер ТТН
     */
    const val COLUMN_INFORMF1_TTN_NUMBER = "INFORMF1_TTN_NUMBER"

    /**
     * Справка 1: Дата накладной
     */
    const val COLUMN_INFORMF1_TTN_DATE = "INFORMF1_TTN_DATE"

    /**
     * Справка 1: Номер подтверждения о фиксации в ЕГАИС
     */
    const val COLUMN_INFORMF1_EGAIS_FIX_NUMBER = "INFORMF1_EGAIS_FIX_NUMBER"

    /**
     * Справка 1: Дата подтверждения о фиксации в ЕГАИС
     */
    const val COLUMN_INFORMF1_EGAIS_FIX_DATE = "INFORMF1_EGAIS_FIX_DATE"
}