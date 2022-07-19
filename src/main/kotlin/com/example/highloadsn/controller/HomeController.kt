package com.example.highloadsn.controller

import com.example.highloadsn.service.UserService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController(
    private val userService: UserService
) {
    @GetMapping("/login")
    fun login(): String {
        return "login"
    }

    @GetMapping("/")
    fun home(): String {
        return "index"
    }

    @GetMapping("/all")
    fun showAll(model: Model): String? {
        model.addAttribute("users", userService.getAll())
        return "list"
    }
}