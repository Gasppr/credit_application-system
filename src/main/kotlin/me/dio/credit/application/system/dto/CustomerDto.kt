package me.dio.credit.application.system.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.dio.credit.application.system.entity.Address
import me.dio.credit.application.system.entity.Customer
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal


data class CustomerDto(
   @field:NotEmpty(message = "Input Invalid") val firstName : String,
   @field:NotEmpty(message = "Input Invalid") val lastName : String,
   @field:NotEmpty(message = "Input Invalid")
   @field:CPF(message = "This Invalid CPF") val cpf : String,
   @field:NotNull(message = "Input Invalid") val income : BigDecimal,
   @field:Email(message = "Invalid Email")
   @field:NotEmpty(message = "Input Invalid") val email : String,
   @field:NotEmpty(message = "Input Invalid") val password : String,
   @field:NotEmpty(message = "Input Invalid") val zipCode : String,
   @field:NotEmpty(message = "Input Invalid") val street : String
) {

    fun toEntity(): Customer =
         Customer(
            firstName = this.firstName,
            lastName = this.lastName,
            cpf = this.cpf,
            income = this.income,
            email = this.email,
            password = this.password,
            address = Address(
                zipCode = this.zipCode,
                street = this.street
            ))


}