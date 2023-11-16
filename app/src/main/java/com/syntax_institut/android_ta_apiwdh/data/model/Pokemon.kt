package com.syntax_institut.android_ta_apiwdh.data.model

data class Pokemon(
    val name: String,
    val url: String = "",
    val sprites: Sprites = Sprites(Other(OfficialArtwork("")))
)