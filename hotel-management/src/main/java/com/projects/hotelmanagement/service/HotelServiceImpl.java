package com.projects.hotelmanagement.service;

import com.projects.hotelmanagement.entity.Hotel;
import com.projects.hotelmanagement.repository.HotelRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelServiceImpl implements HotelService{

    private final Logger logger = LoggerFactory.getLogger(HotelServiceImpl.class);

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel addHotel(Hotel hotel) {
        logger.info("hotel details has been added to the database");
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel getHotelById(Long hotelId) {
        return hotelRepository.findById(hotelId).get();
    }

    @Override
    public Hotel updateHotelById(Long hotelId, Hotel hotel) {
        Hotel hotelFromDB = hotelRepository.findById(hotelId).get();

        if(hotel.getAddress() != null && !"".equalsIgnoreCase(hotel.getAddress())){
            hotelFromDB.setAddress(hotel.getAddress());
        }

        if(hotel.getName() != null && !"".equalsIgnoreCase(hotel.getName())){
            hotelFromDB.setName(hotel.getName());
        }
        logger.info("hotel details has been updated to the database");
        return hotelRepository.save(hotelFromDB);
    }

    @Override
    public Hotel getHotelByName(String hotelName) {
        return hotelRepository.findByName(hotelName);
    }

    @Override
    public String deleteHotelById(Long hotelId) {
        hotelRepository.deleteById(hotelId);
        logger.info("hotel with id: {} has been deleted successfully", hotelId);
        return "hotel with id: " + hotelId + " has been deleted successfully";
    }
}
