package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.db.model

data class User(
    var uid: Int = 0,
    var firstName: String,
    var lastName: String,
    var email: String,
    var picture: String = "",
)