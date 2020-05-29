package com.bemobi.test.bemobitest.domain

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal
import java.time.LocalDateTime

const val TTL = "1588285962993"

data class TransformedDto (val productId: String, val amount: BigDecimal, val status: IntegrationStatus, val createdAt: LocalDateTime, val ttl: String = TTL)

enum class IntegrationStatus{

    @SerializedName("active")
    ACTIVE,
    @SerializedName("inactive")
    INACTIVE
}