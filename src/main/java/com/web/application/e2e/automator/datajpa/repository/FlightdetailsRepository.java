package com.web.application.e2e.automator.datajpa.repository;

import com.web.application.e2e.automator.datajpa.entity.Flightdetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightdetailsRepository extends JpaRepository<Flightdetails, Integer> {
}