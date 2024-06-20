package com.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.reservation.model.Reservation;
import com.reservation.repository.ReservationRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // Enables CORS requests from http://localhost:4200
public class ReservationController {
	
	@Autowired
    private ReservationRepository reservationRepository;

	@GetMapping("/reservations")
	public List<Reservation> getAllReservations() {
		return reservationRepository.findAll();
	}
	
	@PostMapping("/confirm")
    public Reservation confirmReservation(@RequestBody Reservation reservation) {
        return reservationRepository.save(reservation);
    }
	
	@DeleteMapping("/deleteReservations")
	public void deleteReservations() {
		reservationRepository.deleteAll();
	}

}
