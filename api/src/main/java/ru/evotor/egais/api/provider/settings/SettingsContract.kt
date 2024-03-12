package ru.evotor.egais.api.provider.settings

import android.net.Uri
import ru.evotor.egais.api.provider.MainContract

internal object SettingsContract {
    private const val AUTHORITY = "${MainContract.AUTHORITY_PREFIX}.settings"
    private const val AUTHORITY_EGAIS_UI = "${MainContract.AUTHORITY_PREFIX_EGAIS_UI}.settings"

    const val ALCOHOL_CONTROL_TYPE_COLUMN_NAME = "ALCOHOL_CONTROL_TYPE"
    const val ALCOHOL_ENABLED_COLUMN_NAME = "ALCOHOL_ENABLED"
    const val LINK_EGAIS_COMMODITY_COLUMN_NAME = "LINK_EGAIS_COMMODITY"
    const val UTM_SYNCHRONIZATION_COLUMN_NAME = "UTM_SYNCHRONIZATION"
    const val CLOUD_SYNCHRONIZATION_COLUMN_NAME = "CLOUD_SYNCHRONIZATION"
    const val BEER_TAPS_ENABLED_COLUMN_NAME = "BEER_TAPS"
    const val EXCISE_ALCOHOL_ON_TAP_ENABLED_COLUMN_NAME = "EXCISE_ALCOHOL_ON_TAP"
    const val ONLINE_CHECK_ENABLED_COLUMN_NAME = "beerTapsSettingsCodesCheckEnabled"
    const val X_API_KEY_COLUMN_NAME = "beerTapsSettingsXApiKey"

    private const val ALCOHOL_ENABLED_PATH = "AlcoholEnabled"
    private const val ALCOHOL_CONTROL_TYPE_PATH = "AlcoholControlType"
    private const val LINK_EGAIS_COMMODITY_PATH = "LinkEgaisCommodity"
    private const val UTM_SYNCHRONIZATION_PATH = "UtmSynchronization"
    private const val CLOUD_SYNCHRONIZATION_PATH = "CloudSynchronization"
    private const val BEER_TAPS_ENABLED_PATH = "BeerTapsEnabled"
    private const val EXCISE_ALCOHOL_ON_TAP_ENABLED_PATH = "ExciseAlcoholOnTapEnabled"
    private const val BEER_TAPS_SETTINGS_CODES_CHECK_ENABLED_PATH= "CodesCheckEnabled"
    private const val BEER_TAPS_SETTINGS_X_API_KEY_PATH = "XAPiKey"

    private val BASE_URI: Uri = Uri.parse("content://$AUTHORITY")
    private val BASE_URI_FROM_EGAIS_UI: Uri = Uri.parse("content://$AUTHORITY_EGAIS_UI")
    val ALCOHOL_CONTROL_TYPE_URI: Uri = Uri.withAppendedPath(BASE_URI, ALCOHOL_CONTROL_TYPE_PATH)
    val ALCOHOL_ENABLED_URI: Uri  = Uri.withAppendedPath(BASE_URI, ALCOHOL_ENABLED_PATH)
    val LINK_EGAIS_COMMODITY_URI: Uri  = Uri.withAppendedPath(BASE_URI, LINK_EGAIS_COMMODITY_PATH)
    val UTM_SYNCHRONIZATION_URI: Uri  = Uri.withAppendedPath(BASE_URI, UTM_SYNCHRONIZATION_PATH)
    val CLOUD_SYNCHRONIZATION_URI: Uri  = Uri.withAppendedPath(BASE_URI, CLOUD_SYNCHRONIZATION_PATH)
    val BEER_TAPS_ENABLED_URI: Uri  = Uri.withAppendedPath(BASE_URI, BEER_TAPS_ENABLED_PATH)
    val EXCISE_ALCOHOL_ON_TAP_ENABLED_URI: Uri  = Uri.withAppendedPath(BASE_URI, EXCISE_ALCOHOL_ON_TAP_ENABLED_PATH)
    val BEER_TAPS_SETTINGS_CODES_CHECK_ENABLED_URI: Uri = Uri.withAppendedPath(BASE_URI_FROM_EGAIS_UI, BEER_TAPS_SETTINGS_CODES_CHECK_ENABLED_PATH)
    val BEER_TAPS_SETTINGS_X_API_KEY_URI: Uri = Uri.withAppendedPath(BASE_URI_FROM_EGAIS_UI, BEER_TAPS_SETTINGS_X_API_KEY_PATH)
}