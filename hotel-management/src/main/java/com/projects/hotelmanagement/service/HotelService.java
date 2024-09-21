package com.projects.hotelmanagement.service;

import com.projects.hotelmanagement.entity.Hotel;

public interface HotelService {

   public Hotel addHotel(Hotel hotel);

   public Hotel getHotelById(Long hotelId);

   public Hotel updateHotelById(Long hotelId, Hotel hotel);

   public Hotel getHotelByName(String hotelName);

   public String deleteHotelById(Long hotelId);
}
