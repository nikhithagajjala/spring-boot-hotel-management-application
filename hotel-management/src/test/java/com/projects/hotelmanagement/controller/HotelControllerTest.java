package com.projects.hotelmanagement.controller;

import com.projects.hotelmanagement.entity.Hotel;
import com.projects.hotelmanagement.service.HotelService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(HotelController.class)
class HotelControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HotelService hotelService;

    private Hotel hotel;

    @BeforeEach
    void setUp() {
        hotel = Hotel.builder()
                .id(1L)
                .name("Marriott")
                .address("Los Angeles")
                .build();

    }

    @Test
    public void whenAddHotelThenSaveAndReturn() throws Exception {
        Hotel inputHotel = Hotel.builder()
                .name("Marriott")
                .address("Los Angeles")
                .build();
        Mockito.when(hotelService.addHotel(inputHotel)).thenReturn(hotel);

        mockMvc.perform(MockMvcRequestBuilders.post("/hotels/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\"name\":\"Marriott\",\n" +
                        "\"address\":\"Los Angeles\"\n" +
                        "}"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void whenFindByIdThenShouldReturnHotel() throws Exception {
        Mockito.when(hotelService.getHotelById(1L)).thenReturn(hotel);

        mockMvc.perform(MockMvcRequestBuilders.get("/hotels/get/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}