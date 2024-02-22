package com.joincoded.bankapi.data

data class User(
    var username: String,
    var password: String,
    var email: String,
    var vehicleType: Array<VehicleType>,
    var vehicleYear: String,
    var vehicleModel: String,
    val token: String?

)

