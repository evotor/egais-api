package ru.evotor.egais.api.provider.dictionary

import android.net.Uri
import ru.evotor.egais.api.provider.api.DictionaryApi

object ProductInfoContract {
    @JvmField
    val PATH = "ProductInfo"
    @JvmField
    val URI = Uri.withAppendedPath(DictionaryApi.BASE_URI, PATH)

    /**
     * Тип продукции (АП | ССП | ССНП | Спирт). Не может быть null.
     *
     * Возможные значения:
     * - AP - алкогольная продукция (АП)
     * - SSP - спиртосодержащая пищевая продукция (ССП)
     * - SSNP - спиртосодержащая непищевая продукция (ССНП)
     * - SPIRT - Спирт
     *
     * Тип: STRING
     */
    const val COLUMN_TYPE = "TYPE"

    /**
     * Наименование продукции полное. Не может быть null
     *
     * Тип: STRING
     */
    const val COLUMN_FULL_NAME = "FULL_NAME"

    /**
     * Наименование продукции краткое. Может быть null
     *
     * Тип: STRING
     */
    const val COLUMN_SHORT_NAME = "SHORT_NAME"

    /**
     * Код продукции согласно ЕГАИС. Не может быть null
     *
     * Тип: STRING
     */
    const val COLUMN_ALC_CODE = "ALC_CODE"

    /**
     * Емкость упаковки продукции согласно ЕГАИС. Может быть null
     *
     * Тип: STRING
     */
    const val COLUMN_CAPACITY = "CAPACITY"

    /**
     * Содержание этилового спирта, %. Может быть null
     *
     * Тип: STRING
     */
    const val COLUMN_ALC_VOLUME = "ALC_VOLUME"

    /**
     * Производитель. Может быть null
     *
     * Тип: STRING
     */
    const val COLUMN_PRODUCER_CLIENT_REG_ID = "PRODUCER_CLIENT_REG_ID"

    /**
     * Импортер. Может быть null
     *
     * Тип: STRING
     */
    const val COLUMN_IMPORTER_CLIENT_REG_ID = "IMPORTER_CLIENT_REG_ID"

    /**
     * Код вида продукции. Не может быть null
     *
     * Тип: STRING
     */
    const val COLUMN_PRODUCT_V_CODE = "PRODUCT_V_CODE"

}