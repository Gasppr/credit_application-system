package me.dio.credit.application.system.controller

import me.dio.credit.application.system.dto.CustomerDto
import me.dio.credit.application.system.dto.CustomerUpdateDto
import me.dio.credit.application.system.dto.CustomerView
import me.dio.credit.application.system.entity.Customer
import me.dio.credit.application.system.service.impl.CustomerService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/customers")
class CustomerResource(
    private val customerService : CustomerService
) {

    @PostMapping
    fun saveCustomer(@RequestBody customertDto : CustomerDto) : String {
        val saveCustomer = this.customerService.save(customertDto.toEntity())

        return "Customer ${saveCustomer.email} saved!"
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id : Long) : CustomerView {
        val customer : Customer = this.customerService.findById(id)
        return CustomerView(customer)
    }

    @DeleteMapping("/{id}")
    fun deleteCustomer(@PathVariable id : Long) = this.customerService.delete(id)



    @PatchMapping
    fun updateCustomer(@RequestParam(value = "customerId") id : Long, @RequestBody customerUpdateTo : CustomerUpdateDto): CustomerView{

        val customer : Customer = this.customerService.findById(id)
        val customerToUpdate : Customer = customerUpdateTo.toEntity(customer)
        val customerUpdated : Customer = this.customerService.save(customerToUpdate)
        return CustomerView(customerUpdated)
    }


}