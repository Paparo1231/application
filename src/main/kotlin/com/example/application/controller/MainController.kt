package com.example.application.controller

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView

@RestController
@RequestMapping(
    "/main", produces =
    [MediaType.APPLICATION_JSON_VALUE]
)
class MainController {

    @GetMapping("index")
    fun index(): ModelAndView {
        return ModelAndView("index")
    }

    @GetMapping("choosing")
    fun choosingRole(): ModelAndView {
        return ModelAndView("choosing_role")
    }

    @GetMapping("auth")
    fun authorize(): ModelAndView {
        return ModelAndView("authorize")
    }
}
