package ru.evotor.egais.api.query

import ru.evotor.egais.api.model.ClientSetting
import ru.evotor.egais.api.provider.client_settings.ClientSettingsContract
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder

class ClientSettingsQuery : FilterBuilder<ClientSettingsQuery, ClientSettingsQuery.SortOrder,
        ClientSetting>(ClientSettingsContract.URI) {

    @JvmField
    val settingName = addFieldFilter<String>(ClientSettingsContract.COLUMN_SETTING_NAME)

    override val currentQuery: ClientSettingsQuery
        get() = this

    override fun getValue(cursor: Cursor<ClientSetting>): ClientSetting {
        val fsRarId = cursor.getColumnIndex(COLUMN_FSRAR_ID)

        return ClientSetting(cursor.getString(fsRarId))
    }

    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {
        override val currentSortOrder: SortOrder
            get() = this
    }

    companion object {
        const val COLUMN_FSRAR_ID = "FSRAR_ID"
    }
}