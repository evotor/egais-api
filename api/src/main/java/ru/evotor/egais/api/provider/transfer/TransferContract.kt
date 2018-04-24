package ru.evotor.egais.api.provider.transfer

import android.net.Uri
import ru.evotor.egais.api.provider.MainContract

internal object TransferContract {
    private const val AUTHORITY = "${MainContract.AUTHORITY_PREFIX}.transfer"

    val BASE_URI = Uri.parse("content://${AUTHORITY}")
}