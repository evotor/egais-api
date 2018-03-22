package ru.evotor.egais.api.provider.dictionary

import android.net.Uri
import ru.evotor.egais.api.provider.MainContract


internal object DictionaryContract {
    private const val AUTHORITY = "${MainContract.AUTHORITY_PREFIX}.dictionary"

    val BASE_URI = Uri.parse("content://${AUTHORITY}")
}