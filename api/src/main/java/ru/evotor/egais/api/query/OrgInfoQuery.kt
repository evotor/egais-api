package ru.evotor.egais.api.query

import ru.evotor.egais.api.model.dictionary.OrgInfo
import ru.evotor.egais.api.model.dictionary.OrgInfoAddress
import ru.evotor.egais.api.model.dictionary.WBTypeUsed
import ru.evotor.egais.api.provider.dictionary.OrgInfoContract
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder

class OrgInfoQuery : FilterBuilder<OrgInfoQuery, OrgInfoQuery.SortOrder, OrgInfo>(OrgInfoContract.URI) {

    @JvmField
    val type = addFieldFilter<OrgInfo.Type?>(OrgInfoContract.COLUMN_TYPE)
    @JvmField
    val clientRegId = addFieldFilter<String>(OrgInfoContract.COLUMN_CLIENT_REG_ID)
    @JvmField
    val fullName = addFieldFilter<String>(OrgInfoContract.COLUMN_FULL_NAME)
    @JvmField
    val shortName = addFieldFilter<String?>(OrgInfoContract.COLUMN_SHORT_NAME)
    @JvmField
    val inn = addFieldFilter<String?>(OrgInfoContract.COLUMN_INN)
    @JvmField
    val kpp = addFieldFilter<String?>(OrgInfoContract.COLUMN_KPP)
    @JvmField
    val unp = addFieldFilter<String?>(OrgInfoContract.COLUMN_UNP)
    @JvmField
    val rnn = addFieldFilter<String?>(OrgInfoContract.COLUMN_RNN)
    @JvmField
    val state = addFieldFilter<String?>(OrgInfoContract.COLUMN_STATE)
    @JvmField
    val versionWB = addFieldFilter<WBTypeUsed?>(OrgInfoContract.COLUMN_VERSION_WB)

    override val currentQuery: OrgInfoQuery
        get() = this

    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        @JvmField
        val type = addFieldSorter(OrgInfoContract.COLUMN_TYPE)
        @JvmField
        val clientRegId = addFieldSorter(OrgInfoContract.COLUMN_CLIENT_REG_ID)
        @JvmField
        val fullName = addFieldSorter(OrgInfoContract.COLUMN_FULL_NAME)
        @JvmField
        val shortName = addFieldSorter(OrgInfoContract.COLUMN_SHORT_NAME)
        @JvmField
        val inn = addFieldSorter(OrgInfoContract.COLUMN_INN)
        @JvmField
        val kpp = addFieldSorter(OrgInfoContract.COLUMN_KPP)
        @JvmField
        val unp = addFieldSorter(OrgInfoContract.COLUMN_UNP)
        @JvmField
        val rnn = addFieldSorter(OrgInfoContract.COLUMN_RNN)
        @JvmField
        val state = addFieldSorter(OrgInfoContract.COLUMN_STATE)
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
                OrgInfo.Type.valueOf(cursor.getString(columnIndexType)),
                cursor.getString(columnIndexClientRegId),
                cursor.getString(columnIndexFullName),
                cursor.getString(columnIndexShortName),
                cursor.getString(columnIndexInn),
                cursor.getString(columnIndexKpp),
                cursor.getString(columnIndexUnp),
                cursor.getString(columnIndexRnn),
                createOrgAddress(cursor),
                cursor.getString(columnIndexState),
                WBTypeUsed.valueOf(cursor.getString(columnIndexVersionWb))
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