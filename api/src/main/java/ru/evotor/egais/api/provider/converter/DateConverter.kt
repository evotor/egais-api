package ru.evotor.egais.api.provider.converter

import org.apache.commons.lang3.time.DateFormatUtils
import java.util.*

internal object DateConverter {
    @JvmStatic
    fun toNullableDate(date: String?): Date? {
        return date?.let { Date(it) }
    }

    @JvmStatic
    fun toNullableString(date: Date?): String? {
        return date?.let { DateFormatUtils.format(date, "yyyy-MM-dd'T'HH:mm:ss.S", Locale.US) }
    }
    @JvmStatic
    fun toDate(date: String): Date {
        return Date(date)
    }

    @JvmStatic
    fun toString(date: Date): String {
        return DateFormatUtils.format(date, "yyyy-MM-dd'T'HH:mm:ss.S", Locale.US)
    }
}