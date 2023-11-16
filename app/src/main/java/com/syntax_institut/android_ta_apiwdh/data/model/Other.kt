package com.syntax_institut.android_ta_apiwdh.data.model

import com.squareup.moshi.Json

data class Other(
    @Json(name = "official-artwork")
    val officialArtwork: OfficialArtwork
)
