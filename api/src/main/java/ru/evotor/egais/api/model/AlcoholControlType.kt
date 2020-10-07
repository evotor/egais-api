package ru.evotor.egais.api.model

enum class AlcoholControlType {

    /**
     * использовать УТМ, требовать чтения марки
     */
    USE_UTM,

    /**
     * не использовать УТМ и не требовать чтения марки
     */
    NO_CONTROL
}