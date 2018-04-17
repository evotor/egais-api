package ru.evotor.egais.api.provider.dictionary

import android.net.Uri

internal object ProductInfoContract {
    val PATH = "ProductInfo"
    val URI = Uri.withAppendedPath(DictionaryContract.BASE_URI, PATH)

    /**
     * Тип продукции (АП | ССП | ССНП | Спирт).
     */
    const val COLUMN_TYPE = "TYPE"

    /**
     * Наименование продукции полное.
     */
    const val COLUMN_FULL_NAME = "FULL_NAME"

    /**
     * Наименование продукции полное (в верхнем регистре)
     */
    const val COLUMN_FULL_NAME_UPPER_CASE = "FULL_NAME_UPPER_CASE"

    /**
     * Наименование продукции краткое
     */
    const val COLUMN_SHORT_NAME = "SHORT_NAME"

    /**
     * Наименование продукции краткое (в верхнем регистре)
     */
    const val COLUMN_SHORT_NAME_UPPER_CASE = "SHORT_NAME_UPPER_CASE"

    /**
     * Код продукции согласно ЕГАИС.
     */
    const val COLUMN_ALC_CODE = "ALC_CODE"

    /**
     * Емкость упаковки продукции согласно ЕГАИС.
     */
    const val COLUMN_CAPACITY = "CAPACITY"

    /**
     * Содержание этилового спирта, %.
     */
    const val COLUMN_ALC_VOLUME = "ALC_VOLUME"

    /**
     * Производитель.
     */
    const val COLUMN_PRODUCER_CLIENT_REG_ID = "PRODUCER_CLIENT_REG_ID"

    /**
     * Импортер.
     */
    const val COLUMN_IMPORTER_CLIENT_REG_ID = "IMPORTER_CLIENT_REG_ID"

    /**
     * Код вида продукции.
     */
    const val COLUMN_PRODUCT_V_CODE = "PRODUCT_V_CODE"

}