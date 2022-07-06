package com.example.highloadsn.controller

import com.example.highloadsn.dto.UserDTO
import com.example.highloadsn.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService
) {
    @GetMapping
    fun getAll(): ResponseEntity<List<UserDTO>> = ResponseEntity.ok(userService.getAll())

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<UserDTO> = ResponseEntity.ok(userService.getById(id))

    @PostMapping
    fun create(@RequestBody userDto: UserDTO) : ResponseEntity<Long> {
        return ResponseEntity.ok(userService.create(userDto))
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody userDto: UserDTO) : ResponseEntity<Any> {
        userService.update(id, userDto)
        return ResponseEntity.ok().build()
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) : ResponseEntity<Any>{
        userService.delete(id)
        return ResponseEntity.ok().build()
    }
}