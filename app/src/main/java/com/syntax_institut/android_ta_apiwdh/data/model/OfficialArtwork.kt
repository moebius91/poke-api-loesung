package com.syntax_institut.android_ta_apiwdh.data.model

import com.squareup.moshi.Json

data class OfficialArtwork(
    @Json(name = "front_default")
    val frontDefault: String
)
