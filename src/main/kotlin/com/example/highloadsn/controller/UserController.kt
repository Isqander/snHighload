package com.example.highloadsn.controller

import com.example.highloadsn.dto.UserDTO
import com.example.highloadsn.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService
) {
    @GetMapping
    fun getAll(): List<UserDTO> = userService.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): UserDTO = userService.getById(id)

    @PostMapping
    fun create(@RequestBody userDto: UserDTO) {
        userService.create(userDto)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody userDto: UserDTO) {
        userService.update(id, userDto)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long){
        userService.delete(id)
    }
}