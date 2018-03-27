package ru.evotor.egais.api.provider.converter

import org.apache.commons.lang3.StringUtils
import java.util.ArrayList

internal object MarkListConverter {
    private const val SEPARATOR = ","

    fun toMarkList(markListString: String?): List<String> {
        return markListString?.let {
            StringUtils.split(markListString, SEPARATOR)?.toList()
        } ?: ArrayList<String>()
    }

    fun toString(markList: List<String>): String? {
        return StringUtils.join(markList, SEPARATOR)
    }
}
