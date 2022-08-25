package com.example.onecard

data class Card(
    val type: CardType,
    val num: Int
)

enum class CardType {
    Heart, Diamond, Spade, Club
}