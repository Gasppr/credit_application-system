package me.dio.credit.application.system.dto

import me.dio.credit.application.system.entity.Address
import me.dio.credit.application.system.entity.Customer
import java.math.BigDecimal


data class CustomerDto(
    val firstName : String,
    val lastName : String,
    val cpf : String,
    val income : String,
    val email : String,
    val password : String,
    val zipCode : String,
    val street : String
) {

    fun toEntity(): Customer =
         Customer(
            firstName = this.firstName,
            lastName = this.lastName,
            cpf = this.cpf,
            income = BigDecimal(this.income),
            email = this.email,
            password = this.password,
            address = Address(
                zipCode = this.zipCode,
                street = this.street
            ))


}