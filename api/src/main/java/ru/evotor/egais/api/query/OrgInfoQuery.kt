package ru.evotor.egais.api.query

import ru.evotor.egais.api.model.dictionary.OrgInfo
import ru.evotor.egais.api.model.dictionary.OrgInfoAddress
import ru.evotor.egais.api.model.dictionary.WBTypeUsed
import ru.evotor.egais.api.provider.dictionary.OrgInfoContract
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder

/**
 * Класс для формирования запроса на получение информации об организациях
 */
class OrgInfoQuery : FilterBuilder<OrgInfoQuery, OrgInfoQuery.SortOrder, OrgInfo>(OrgInfoContract.URI) {

    /**
     * Тип организации (Юридическое лицо/Индивидуальный предприниматель/Иностранец (исключая таможенный союз)/Таможенный союз)
     */
    @JvmField
    val type = addFieldFilter<OrgInfo.Type?>(OrgInfoContract.COLUMN_TYPE)

    /**
     * Код организации
     */
    @JvmField
    val clientRegId = addFieldFilter<String>(OrgInfoContract.COLUMN_CLIENT_REG_ID)

    /**
     * Наименование организации полное (в верхнем регистре)
     */
    @JvmField
    val fullName = addFieldFilter<String, String>(OrgInfoContract.COLUMN_FULL_NAME_UPPER_CASE, {
        it.toUpperCase()
    })

    /**
     * Наименование организации краткое (в верхнем регистре)
     */
    @JvmField
    val shortName = addFieldFilter<String?, String?>(OrgInfoContract.COLUMN_SHORT_NAME_UPPER_CASE, {
        it?.toUpperCase()
    })

    /**
     * ИНН
     */
    @JvmField
    val inn = addFieldFilter<String?>(OrgInfoContract.COLUMN_INN)

    /**
     * КПП
     */
    @JvmField
    val kpp = addFieldFilter<String?>(OrgInfoContract.COLUMN_KPP)

    /**
     * УНП для респ.Беларусь
     */
    @JvmField
    val unp = addFieldFilter<String?>(OrgInfoContract.COLUMN_UNP)

    /**
     * РНН(БИН/ИИН) для респ.Казахстан
     */
    @JvmField
    val rnn = addFieldFilter<String?>(OrgInfoContract.COLUMN_RNN)

    /**
     * Статус: действующая или удалена
     */
    @JvmField
    val state = addFieldFilter<String?>(OrgInfoContract.COLUMN_STATE)

    /**
     * Версия протокола для накладных: 1, 2 или 3
     */
    @JvmField
    val versionWB = addFieldFilter<WBTypeUsed?>(OrgInfoContract.COLUMN_VERSION_WB)

    override val currentQuery: OrgInfoQuery
        get() = this

    /**
     * Класс для сортировки полей в результе запроса
     */
    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        /**
         * Тип организации (Юридическое лицо/Индивидуальный предприниматель/Иностранец (исключая таможенный союз)/Таможенный союз)
         */
        @JvmField
        val type = addFieldSorter(OrgInfoContract.COLUMN_TYPE)

        /**
         * Код организации
         */
        @JvmField
        val clientRegId = addFieldSorter(OrgInfoContract.COLUMN_CLIENT_REG_ID)

        /**
         * Наименование организации полное (в верхнем регистре)
         */
        @JvmField
        val fullName = addFieldSorter(OrgInfoContract.COLUMN_FULL_NAME_UPPER_CASE)

        /**
         * Наименование организации краткое (в верхнем регистре)
         */
        @JvmField
        val shortName = addFieldSorter(OrgInfoContract.COLUMN_SHORT_NAME_UPPER_CASE)

        /**
         * ИНН
         */
        @JvmField
        val inn = addFieldSorter(OrgInfoContract.COLUMN_INN)

        /**
         * КПП
         */
        @JvmField
        val kpp = addFieldSorter(OrgInfoContract.COLUMN_KPP)

        /**
         * УНП для респ.Беларусь
         */
        @JvmField
        val unp = addFieldSorter(OrgInfoContract.COLUMN_UNP)

        /**
         * РНН(БИН/ИИН) для респ.Казахстан
         */
        @JvmField
        val rnn = addFieldSorter(OrgInfoContract.COLUMN_RNN)

        /**
         * Статус: действующая или удалена
         */
        @JvmField
        val state = addFieldSorter(OrgInfoContract.COLUMN_STATE)

        /**
         * Версия протокола для накладных: 1, 2 или 3
         */
        @JvmField
        val versionWB = addFieldSorter(OrgInfoContract.COLUMN_VERSION_WB)

        override val currentSortOrder: SortOrder
            get() = this

    }

    override fun getValue(cursor: Cursor<OrgInfo>): OrgInfo {
        return createOrgInfo(cursor)
    }

    private fun createOrgInfo(cursor: android.database.Cursor): OrgInfo {
        val columnIndexType = cursor.getColumnIndex(OrgInfoContract.COLUMN_TYPE)
        val columnIndexClientRegId = cursor.getColumnIndex(OrgInfoContract.COLUMN_CLIENT_REG_ID)
        val columnIndexFullName = cursor.getColumnIndex(OrgInfoContract.COLUMN_FULL_NAME)
        val columnIndexShortName = cursor.getColumnIndex(OrgInfoContract.COLUMN_SHORT_NAME)
        val columnIndexInn = cursor.getColumnIndex(OrgInfoContract.COLUMN_INN)
        val columnIndexKpp = cursor.getColumnIndex(OrgInfoContract.COLUMN_KPP)
        val columnIndexUnp = cursor.getColumnIndex(OrgInfoContract.COLUMN_UNP)
        val columnIndexRnn = cursor.getColumnIndex(OrgInfoContract.COLUMN_RNN)
        val columnIndexState = cursor.getColumnIndex(OrgInfoContract.COLUMN_STATE)
        val columnIndexVersionWb = cursor.getColumnIndex(OrgInfoContract.COLUMN_VERSION_WB)

        return OrgInfo(
                cursor.getString(columnIndexType)?.let { OrgInfo.Type.valueOf(it) },
                cursor.getString(columnIndexClientRegId),
                cursor.getString(columnIndexFullName),
                cursor.getString(columnIndexShortName),
                cursor.getString(columnIndexInn),
                cursor.getString(columnIndexKpp),
                cursor.getString(columnIndexUnp),
                cursor.getString(columnIndexRnn),
                createOrgAddress(cursor),
                cursor.getString(columnIndexState),
                cursor.getString(columnIndexVersionWb)?.let { WBTypeUsed.valueOf(it) }
        )
    }

    private fun createOrgAddress(cursor: android.database.Cursor): OrgInfoAddress? {
        val country = cursor.getString(cursor.getColumnIndex(OrgInfoContract.COLUMN_ADDRESS_COUNTRY))
        val index = cursor.getString(cursor.getColumnIndex(OrgInfoContract.COLUMN_ADDRESS_INDEX))
        val regionCode = cursor.getString(cursor.getColumnIndex(OrgInfoContract.COLUMN_ADDRESS_REGION_CODE))
        val area = cursor.getString(cursor.getColumnIndex(OrgInfoContract.COLUMN_ADDRESS_AREA))
        val city = cursor.getString(cursor.getColumnIndex(OrgInfoContract.COLUMN_ADDRESS_CITY))
        val place = cursor.getString(cursor.getColumnIndex(OrgInfoContract.COLUMN_ADDRESS_PLACE))
        val street = cursor.getString(cursor.getColumnIndex(OrgInfoContract.COLUMN_ADDRESS_STREET))
        val house = cursor.getString(cursor.getColumnIndex(OrgInfoContract.COLUMN_ADDRESS_HOUSE))
        val building = cursor.getString(cursor.getColumnIndex(OrgInfoContract.COLUMN_ADDRESS_BUILDING))
        val liter = cursor.getString(cursor.getColumnIndex(OrgInfoContract.COLUMN_ADDRESS_LITER))
        val description = cursor.getString(cursor.getColumnIndex(OrgInfoContract.COLUMN_ADDRESS_DESCRIPTION))

        return if (country != null || index != null || regionCode != null || area != null
                || city != null || place != null || street != null || house != null
                || building != null || liter != null || description != null)
            OrgInfoAddress(
                    country,
                    index,
                    regionCode,
                    area,
                    city,
                    place,
                    street,
                    house,
                    building,
                    liter,
                    description)
        else
            null
    }
}