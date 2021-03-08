package com.project.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.main.entities.Payment;
import com.project.main.entities.Vehicle;
import com.project.main.repositories.IBookingRepository;
import com.project.main.repositories.IPaymentRepository;
import com.project.main.services.PaymentService;

@RestController
@RequestMapping(path = "/api/v1")
public class PaymentController {
	@Autowired
	IPaymentRepository paymentRepository;
	@Autowired
	IBookingRepository bookingRepository;
	
	@Autowired
	PaymentService paymentService;
	
	@PostMapping("/payments")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Payment addPayment(@RequestBody Payment p) {
		return paymentService.addPayment(p);
	}
	
	@DeleteMapping("/payments/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void cancelPayment(@PathVariable("id") int id) {
	paymentService.cancelPayment(id);
	}
	
	@GetMapping("/payments")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Payment> viewPayments(){
		return paymentService.viewPayments();
	}

	@GetMapping("/paymentByVehicle/{vehicle}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Payment> findBookingByVehicle(@PathVariable("vehicle") Vehicle vehicle) {
	return paymentService.findBookingByVehicle(vehicle);
	}
}