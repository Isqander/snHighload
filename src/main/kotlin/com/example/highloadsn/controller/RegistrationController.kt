package com.example.highloadsn.controller

import com.example.highloadsn.dto.UserDTO
import com.example.highloadsn.service.UserService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/registration")
class RegistrationController(private val userService: UserService) {
    @ModelAttribute("user")
    fun userRegistrationDto(): UserDTO {
        return UserDTO()
    }

    @GetMapping
    fun showRegistrationForm(): String {
        return "registration"
    }

    @PostMapping
    fun registerUserAccount(@ModelAttribute("user") registrationDto: UserDTO): String {
        userService.create(registrationDto)
        return "redirect:/registration?success"
    }
}