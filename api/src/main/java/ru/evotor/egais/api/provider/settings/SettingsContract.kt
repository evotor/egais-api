package ru.evotor.egais.api.provider.settings

import android.net.Uri
import ru.evotor.egais.api.provider.MainContract

internal object SettingsContract {
    const val AUTHORITY = "${MainContract.AUTHORITY_PREFIX}.settings"

    const val ALCOHOL_CONTROL_TYPE_COLUMN_NAME = "ALCOHOL_CONTROL_TYPE"
    const val ALCOHOL_ENABLED_COLUMN_NAME = "ALCOHOL_ENABLED"
    const val LINK_EGAIS_COMMODITY_COLUMN_NAME = "LINK_EGAIS_COMMODITY"
    const val UTM_SYNCHRONIZATION_COLUMN_NAME = "UTM_SYNCHRONIZATION"
    const val CLOUD_SYNCHRONIZATION_COLUMN_NAME = "CLOUD_SYNCHRONIZATION"
    const val BEER_TAPS_ENABLED_COLUMN_NAME = "BEER_TAPS"
    const val ONLINE_CHECK_ENABLED_COLUMN_NAME = "ONLINE_CHECK_ENABLED"
    const val X_API_KEY_COLUMN_NAME = "X_API_KEY"

    const val ALCOHOL_ENABLED_PATH = "AlcoholEnabled"
    const val ALCOHOL_CONTROL_TYPE_PATH = "AlcoholControlType"
    const val LINK_EGAIS_COMMODITY_PATH = "LinkEgaisCommodity"
    const val UTM_SYNCHRONIZATION_PATH = "UtmSynchronization"
    const val CLOUD_SYNCHRONIZATION_PATH = "CloudSynchronization"
    const val BEER_TAPS_ENABLED_PATH = "BeerTapsEnabled"
    const val BEER_TAPS_SETTINGS_CODES_CHECK_ENABLED_PATH= "beerTapsSettingsCodesCheckEnabled"
    const val BEER_TAPS_SETTINGS_X_API_KEY_PATH = "beerTapsSettingsXApiKey"

    val BASE_URI = Uri.parse("content://$AUTHORITY")
    val ALCOHOL_CONTROL_TYPE_URI = Uri.withAppendedPath(BASE_URI, ALCOHOL_CONTROL_TYPE_PATH)
    val ALCOHOL_ENABLED_URI = Uri.withAppendedPath(BASE_URI, ALCOHOL_ENABLED_PATH)
    val LINK_EGAIS_COMMODITY_URI = Uri.withAppendedPath(BASE_URI, LINK_EGAIS_COMMODITY_PATH)
    val UTM_SYNCHRONIZATION_URI = Uri.withAppendedPath(BASE_URI, UTM_SYNCHRONIZATION_PATH)
    val CLOUD_SYNCHRONIZATION_URI = Uri.withAppendedPath(BASE_URI, CLOUD_SYNCHRONIZATION_PATH)
    val BEER_TAPS_ENABLED_URI = Uri.withAppendedPath(BASE_URI, BEER_TAPS_ENABLED_PATH)
    val BEER_TAPS_SETTINGS_CODES_CHECK_ENABLED_URI = Uri.withAppendedPath(BASE_URI, BEER_TAPS_SETTINGS_CODES_CHECK_ENABLED_PATH)
    val BEER_TAPS_SETTINGS_X_API_KEY_URI = Uri.withAppendedPath(BASE_URI, BEER_TAPS_SETTINGS_X_API_KEY_PATH)
}