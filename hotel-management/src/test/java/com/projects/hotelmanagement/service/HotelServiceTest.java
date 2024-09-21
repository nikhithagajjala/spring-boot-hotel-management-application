package com.projects.hotelmanagement.service;

import com.projects.hotelmanagement.entity.Hotel;
import com.projects.hotelmanagement.repository.HotelRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HotelServiceTest {

    @Autowired
    private HotelService hotelService;

    @MockBean
    private HotelRepository hotelRepository;

    @BeforeEach
    void setUp() {
        Hotel hotel =
                Hotel.builder()
                        .id(1L)
                        .name("quality-inn")
                        .address("san antonio")
                        .build();
        Mockito.when(hotelRepository.findByName("quality-inn")).thenReturn(hotel);

    }

    @Test
    @DisplayName("Get data based on valid Hotel name")
    public void whenValidHotelNameThenHotelShouldFound(){
        String hotelName = "quality-inn";
        Hotel hotel = hotelService.getHotelByName(hotelName);
        assertEquals(hotelName, hotel.getName());
    }

}