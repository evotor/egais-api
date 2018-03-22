package ru.evotor.egais.api.provider.dictionary

import android.net.Uri

internal object OrgInfoContract {
    val PATH = "OrgInfo"
    val URI = Uri.withAppendedPath(DictionaryContract.BASE_URI, PATH)

    /**
     * Код организации.
     */
    const val COLUMN_CLIENT_REG_ID = "CLIENT_REG_ID"

    /**
     * Тип организации.
     */
    const val COLUMN_TYPE = "TYPE"

    /**
     * Наименование организации полное.
     */
    const val COLUMN_FULL_NAME = "FULL_NAME"

    /**
     * Наименование организации краткое.
     */
    const val COLUMN_SHORT_NAME = "SHORT_NAME"

    /**
     * ИНН.
     */
    const val COLUMN_INN = "INN"

    /**
     * КПП.
     */
    const val COLUMN_KPP = "KPP"

    /**
     * УНП для респ.Беларусь.
     */
    const val COLUMN_UNP = "UNP"

    /**
     * РНН(БИН/ИИН) для респ.Казахстан.
     */
    const val COLUMN_RNN = "RNN"

    /**
     * Статус: действующая или удалена.
     */
    const val COLUMN_STATE = "STATE"

    /**
     * Версия протокола для накладных: 1, 2 или 3.
     */
    const val COLUMN_VERSION_WB = "VERSION_WB"

}