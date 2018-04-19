package ru.evotor.egais.api.query

internal fun String.wrapCastToInteger() = "CAST ($this AS INTEGER)"