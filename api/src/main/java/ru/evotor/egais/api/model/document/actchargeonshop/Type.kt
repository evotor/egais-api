package ru.evotor.egais.api.model.document.actchargeonshop

/**
 * @property RESORTING Пересортица. Излишки пересортица
 * @property OVERAGE Излишки. Излишки продукции. В случае обнаружения излишков продукции организация предоставляет в ЕГАИС
 * акт постановки на баланс с указанием основания «Излишки».
 * @property RECEIVED_BEFORE_01_01_2016 Продукция, полученная до 01.01.2016.
 */
enum class Type {
    RESORTING,
    OVERAGE,
    RECEIVED_BEFORE_01_01_2016
}