package com.example.movieera.network

import com.squareup.moshi.Json

data class FirstLevelNetworkResponse(
    val status: String,
    val copyright: String,
    @Json(name = "has_more") val hasMore: Boolean,
    @Json(name = "num_results") val numResults: Int,
    val results: List<Movie>
)

data class Movie(
    @Json(name = "display_title") val displayTitle: String,
    @Json(name = "mpaa_rating") val mpaaRating: String,
    @Json(name = "critics_pick") val criticsPick: Int,
    val byline: String,
    val headline: String,
    @Json(name = "summary_short") val summaryShort: String,
    @Json(name = "publication_date") val publicationDate: String,
    @Json(name = "opening_date") val openingDate: String?,
    @Json(name = "date_updated") val dateUpdated: String,
    val link: Link,
    val multimedia: Multimedia
)

data class Link(
    val type: String,
    val url: String,
    @Json(name = "suggested_link_text") val suggestedLinkText: String
)

data class Multimedia(
    val type: String,
    val src: String,
    val height: Int,
    val width: Int
)

