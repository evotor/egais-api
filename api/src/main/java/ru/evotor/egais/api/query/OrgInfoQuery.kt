package ru.evotor.egais.api.query

import ru.evotor.egais.api.DictionaryApi
import ru.evotor.egais.api.model.dictionary.OrgInfo
import ru.evotor.egais.api.model.dictionary.WBTypeUsed
import ru.evotor.egais.api.provider.dictionary.OrgInfoContract
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder

class OrgInfoQuery : FilterBuilder<OrgInfoQuery, OrgInfoQuery.SortOrder, OrgInfo>(OrgInfoContract.URI) {

    val type = addFieldFilter<OrgInfo.Type?>(OrgInfoContract.COLUMN_TYPE)
    val clientRegId = addFieldFilter<String>(OrgInfoContract.COLUMN_CLIENT_REG_ID)
    val fullName = addFieldFilter<String>(OrgInfoContract.COLUMN_FULL_NAME)
    val shortName = addFieldFilter<String?>(OrgInfoContract.COLUMN_SHORT_NAME)
    val inn = addFieldFilter<String?>(OrgInfoContract.COLUMN_INN)
    val kpp = addFieldFilter<String?>(OrgInfoContract.COLUMN_KPP)
    val unp = addFieldFilter<String?>(OrgInfoContract.COLUMN_UNP)
    val rnn = addFieldFilter<String?>(OrgInfoContract.COLUMN_RNN)
    val state = addFieldFilter<String?>(OrgInfoContract.COLUMN_STATE)
    val versionWB = addFieldFilter<WBTypeUsed?>(OrgInfoContract.COLUMN_VERSION_WB)

    override val currentQuery: OrgInfoQuery
        get() = this

    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        val type = addFieldSorter(OrgInfoContract.COLUMN_TYPE)
        val clientRegId = addFieldSorter(OrgInfoContract.COLUMN_CLIENT_REG_ID)
        val fullName = addFieldSorter(OrgInfoContract.COLUMN_FULL_NAME)
        val shortName = addFieldSorter(OrgInfoContract.COLUMN_SHORT_NAME)
        val inn = addFieldSorter(OrgInfoContract.COLUMN_INN)
        val kpp = addFieldSorter(OrgInfoContract.COLUMN_KPP)
        val unp = addFieldSorter(OrgInfoContract.COLUMN_UNP)
        val rnn = addFieldSorter(OrgInfoContract.COLUMN_RNN)
        val state = addFieldSorter(OrgInfoContract.COLUMN_STATE)
        val versionWB = addFieldSorter(OrgInfoContract.COLUMN_VERSION_WB)

        override val currentSortOrder: SortOrder
            get() = this

    }

    override fun getValue(cursor: Cursor<OrgInfo>): OrgInfo {
        return DictionaryApi.createOrgInfo(cursor)
    }

}