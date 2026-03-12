package com.example.f1bookingsystem.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String adminPage(){
        return "admin-login";
    }

    @PostMapping("/adminLogin")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session){

        if(username.equals("SLIIT") && password.equals("WD181")){
            session.setAttribute("admin", true);
            return "redirect:/events";
        }

        return "redirect:/admin";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}