package me.dio.credit.application.system.dto

import me.dio.credit.application.system.entity.Customer
import java.math.BigDecimal

data class CustomerUpdateDto(
    val firstName : String,
    val lastName : String,
    val income : String,
    val zipCode : String,
    val street : String
) {
    fun toEntity(customer : Customer): Customer {
        customer.firstName = this.firstName
        customer.lastName = this.lastName
        customer.income = BigDecimal(this.income)
        customer.address.zipCode= this.zipCode
        customer.address.street = this.street
        return customer
    }

}
