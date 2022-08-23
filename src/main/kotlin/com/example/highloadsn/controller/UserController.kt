package com.example.highloadsn.controller

import com.example.highloadsn.dto.NameSurname
import com.example.highloadsn.dto.UserDTO
import com.example.highloadsn.model.Interest
import com.example.highloadsn.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService
) {
    @GetMapping
    fun getAll(): ResponseEntity<List<UserDTO>> = ResponseEntity.ok(userService.getAll())

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<UserDTO> = ResponseEntity.ok(userService.getById(id))

    @PostMapping("/register")
    fun create(@RequestBody userDto: UserDTO): ResponseEntity<Any> {
        return ResponseEntity.ok(userService.create(userDto))
    }

    @PostMapping("/addInterest/{userId}")
    fun addInterest(@PathVariable userId: Long, @RequestBody interest: Interest): ResponseEntity<Any> {
        return ResponseEntity.ok(userService.addInterestToUser(userId, interest))
    }

    @PostMapping("/findByNameSurnamePart")
    fun findByNameSurnamePart(@RequestBody nameSurname: NameSurname): ResponseEntity<List<UserDTO>> {
        return ResponseEntity.ok(userService.findByNameSurnamePart(nameSurname))
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody userDto: UserDTO): ResponseEntity<Any> {
        userService.update(id, userDto)
        return ResponseEntity.ok().build()
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Any> {
        userService.delete(id)
        return ResponseEntity.ok().build()
    }

    @GetMapping("/generate/{quantity}")
    fun generateData(@PathVariable quantity: Long): ResponseEntity<Any>{
        userService.generateData(quantity)
        return ResponseEntity.ok().build()
    }
}