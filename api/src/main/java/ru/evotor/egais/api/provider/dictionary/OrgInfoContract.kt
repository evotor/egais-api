package ru.evotor.egais.api.provider.dictionary

import android.net.Uri

internal object OrgInfoContract {
    val PATH = "OrgInfo"
    val URI = Uri.withAppendedPath(DictionaryContract.BASE_URI, PATH)

    /**
     * Код организации
     */
    const val COLUMN_CLIENT_REG_ID = "CLIENT_REG_ID"

    /**
     * Тип организации (Юридическое лицо/Индивидуальный предприниматель/Иностранец (исключая таможенный союз)/Таможенный союз)
     */
    const val COLUMN_TYPE = "TYPE"

    /**
     * Наименование организации полное
     */
    const val COLUMN_FULL_NAME = "FULL_NAME"

    /**
     * Наименование организации полное (в верхнем регистре)
     */
    const val COLUMN_FULL_NAME_UPPER_CASE = "FULL_NAME_UPPER_CASE"

    /**
     * Наименование организации краткое
     */
    const val COLUMN_SHORT_NAME = "SHORT_NAME"

    /**
     * Наименование организации краткое (в верхнем регистре)
     */
    const val COLUMN_SHORT_NAME_UPPER_CASE = "SHORT_NAME_UPPER_CASE"

    /**
     * ИНН
     */
    const val COLUMN_INN = "INN"

    /**
     * КПП
     */
    const val COLUMN_KPP = "KPP"

    /**
     * УНП для респ.Беларусь
     */
    const val COLUMN_UNP = "UNP"

    /**
     * РНН(БИН/ИИН) для респ.Казахстан
     */
    const val COLUMN_RNN = "RNN"

    /**
     * Страна
     */
    const val COLUMN_ADDRESS_COUNTRY = "ADDRESS_COUNTRY"

    /**
     * Индекс
     */
    const val COLUMN_ADDRESS_INDEX = "ADDRESS_INDEX"

    /**
     * Код региона
     */
    const val COLUMN_ADDRESS_REGION_CODE = "ADDRESS_REGION_CODE"

    /**
     * Область
     */
    const val COLUMN_ADDRESS_AREA = "ADDRESS_AREA"

    /**
     * Город
     */
    const val COLUMN_ADDRESS_CITY = "ADDRESS_CITY"

    /**
     * Район
     */
    const val COLUMN_ADDRESS_PLACE = "ADDRESS_PLACE"

    /**
     * Улица
     */
    const val COLUMN_ADDRESS_STREET = "ADDRESS_STREET"

    /**
     * Дом
     */
    const val COLUMN_ADDRESS_HOUSE = "ADDRESS_HOUSE"

    /**
     * Строение
     */
    const val COLUMN_ADDRESS_BUILDING = "ADDRESS_BUILDING"

    /**
     * Литера
     */
    const val COLUMN_ADDRESS_LITER = "ADDRESS_LITER"

    /**
     * Описание
     */
    const val COLUMN_ADDRESS_DESCRIPTION = "ADDRESS_DESCRIPTION"

    /**
     * Статус: действующая или удалена
     */
    const val COLUMN_STATE = "STATE"

    /**
     * Версия протокола для накладных: 1, 2 или 3
     */
    const val COLUMN_VERSION_WB = "VERSION_WB"

}