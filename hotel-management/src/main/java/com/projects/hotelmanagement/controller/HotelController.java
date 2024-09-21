package com.projects.hotelmanagement.controller;


import com.projects.hotelmanagement.entity.Hotel;
import com.projects.hotelmanagement.service.HotelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/add")
    public Hotel addHotel(@Valid @RequestBody Hotel hotel){
        return hotelService.addHotel(hotel);

    }

    @GetMapping("/get/{id}")
    public Hotel getHotelById(@PathVariable("id") Long hotelId){
        return hotelService.getHotelById(hotelId);
    }

    @PutMapping("/update/{id}")
    public Hotel updateHotel(@PathVariable("id") Long hotelId, @RequestBody Hotel hotel){
        return hotelService.updateHotelById(hotelId, hotel);
    }

    @GetMapping("/get/name/{name}")
    public Hotel getHotelByName(@PathVariable("name") String hotelName){
        return hotelService.getHotelByName(hotelName);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteHotel(@PathVariable("id") Long hotelId){
        return hotelService.deleteHotelById(hotelId);
    }


}
