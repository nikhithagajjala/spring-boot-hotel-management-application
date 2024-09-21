package com.projects.hotelmanagement.repository;

import com.projects.hotelmanagement.entity.Hotel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class HotelRepositoryTest {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach()
    void setUp(){
        Hotel hotel =
                Hotel.builder()
                        .name("hyatt")
                        .address("chicago")
                        .build();

        testEntityManager.persist(hotel);
    }

    @Test
    public void whenFindByIdThenShouldReturnHotel(){
        Hotel hotel = hotelRepository.findById(1L).get();
        assertEquals("hyatt", hotel.getName());
    }

}