package com.test.insourcetake2.model

data class User(
    var firstname: String? = null,
    var lastname: String? = null,
    var email: String? = null,
    var password: String? = null,
    var passwordConfirm: String? = null,
    var phonenumber: Int? = 0,
    var employeenumber: Int? = 0,
    var position: String? = null,
    var companyname: String? = null,
    var linkedin: String? = null
)
