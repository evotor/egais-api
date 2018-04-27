package ru.evotor.egais.api.provider.converter

import org.apache.commons.lang3.time.DateFormatUtils
import org.apache.commons.lang3.time.DateUtils
import java.util.*

internal object DateConverter {
    private const val DATE_DB_FORMAT = "yyyy-MM-dd HH:mm:ss"

    @JvmStatic
    fun toNullableDate(date: String?): Date? {
        return date?.let { DateUtils.parseDate(it, DateConverter.DATE_DB_FORMAT) }
    }

    @JvmStatic
    fun toNullableString(date: Date?): String? {
        return date?.let { DateFormatUtils.format(date, DATE_DB_FORMAT, Locale.US) }
    }

    @JvmStatic
    fun toDate(date: String): Date {
        return DateUtils.parseDate(date, DateConverter.DATE_DB_FORMAT)
    }

    @JvmStatic
    fun toString(date: Date): String {
        return DateFormatUtils.format(date, DATE_DB_FORMAT, Locale.US)
    }
}