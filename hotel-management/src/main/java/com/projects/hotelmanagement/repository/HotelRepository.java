package com.projects.hotelmanagement.repository;

import com.projects.hotelmanagement.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    public Hotel findByName(String hotelName);
}
