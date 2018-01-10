package com.mustafaergan.hibernatevalidation.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mustafaergan.hibernatevalidation.entity.User;

@Controller
@RequestMapping("user")
public class UserController {
	
    @GetMapping("/")
    public String showForm() {
        return "user";
    }

    @PostMapping("/")
    public String checkPersonInfo(@Valid User personForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "sucess";
        }
        return "from";
    }
	
	
}
