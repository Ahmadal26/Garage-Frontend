package com.joincoded.bankapi.model


data class GarageBranch(
    val id: Int, var name: String, var type: Type,
    var address: String, var phone: String,
    var workingHours: String, var location: String,
    var imageURI: Int,
    var favorite: Boolean = false,
    var reviews: String
)
