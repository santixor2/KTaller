package com.santig.ktaller.features.home.domain.model
data class Order(
    val id: Int = 0,
    val clientName: String = "",
    val device: String = "",
    val price: String = "",
    val description: String = "",
    val createdAt: Long = 0,
    val status: String = "",
    val save : Boolean = false
)
