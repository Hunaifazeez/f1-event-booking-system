package com.example.f1bookingsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileWriter;
import java.io.IOException;

@Controller
public class BookingController {

    @PostMapping("/bookTicket")
    public String bookTicket(@RequestParam String raceName) {

        try {
            FileWriter writer = new FileWriter("data/bookings.txt", true);
            writer.write(raceName + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/events";
    }
    @PostMapping("/saveEvent")
    public String saveEvent(
            @RequestParam String raceName,
            @RequestParam String location,
            @RequestParam String date) {

        try {
            FileWriter writer = new FileWriter("data/events.txt", true);
            writer.write(raceName + "," + location + "," + date + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/events";
    }
    @PostMapping("/deleteRace")
    public String deleteRace(@RequestParam String raceName) {

        try {

            java.io.File inputFile = new java.io.File("data/events.txt");
            java.io.File tempFile = new java.io.File("data/temp.txt");

            java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(inputFile));
            java.io.BufferedWriter writer = new java.io.BufferedWriter(new java.io.FileWriter(tempFile));

            String line;

            while((line = reader.readLine()) != null){

                if(!line.startsWith(raceName)){
                    writer.write(line + "\n");
                }

            }

            writer.close();
            reader.close();

            inputFile.delete();
            tempFile.renameTo(inputFile);

        } catch(Exception e){
            e.printStackTrace();
        }

        return "redirect:/events";
    }

}