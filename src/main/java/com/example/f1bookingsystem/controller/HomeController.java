package com.example.f1bookingsystem.controller;

import com.example.f1bookingsystem.model.RaceEvent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/events")
    public String events(Model model, HttpSession session) {

        List<RaceEvent> races = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("data/events.txt"));

            String line;

            while((line = reader.readLine()) != null){

                String[] parts = line.split(",");

                races.add(new RaceEvent(parts[0], parts[1], parts[2]));
            }

            reader.close();

        } catch(Exception e){
            e.printStackTrace();
        }

        model.addAttribute("races", races);

        Boolean admin = (Boolean) session.getAttribute("admin");
        model.addAttribute("admin", admin);

        return "events";
    }
    @GetMapping("/addEvent")
    public String addEvent() {
        return "add-event";
    }

}