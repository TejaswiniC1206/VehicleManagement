package com.project.main.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.main.entities.Booking;
import com.project.main.entities.Customer;
import com.project.main.entities.Driver;
import com.project.main.entities.Payment;
import com.project.main.entities.Vehicle;
import com.project.main.exceptions.PaymentException;
import com.project.main.services.PaymentService;

@SpringBootTest
public class PaymentTest {

	Payment payment;
	Customer customer;
	Driver driver;
	Vehicle vehicle;
	Booking booking;

	
	@Autowired
	PaymentService paymentService;
	
	@BeforeEach
	void setUp() {
		customer = new Customer("Test","one","test@gmail.com", "9876543210", "#23,Bangalore");
		driver = new Driver("Raj","Sharma","#45,Bangalore","12345672","raj@gmail.com","FG2303");
		vehicle = new Vehicle("KA05828", driver, "Car", "SUV", "Bangalore", "---", 4, 35.00, 1000);
		booking = new Booking(customer, vehicle, LocalDate.of(2021, 03, 05), LocalDate.of(2021, 03, 06), "----", 5000, 200);
	}
	
	//@Test
	void testAddPayment() throws PaymentException {
		Payment payment = new Payment("Online", LocalDate.of(2021, 05, 20),booking,"Paid");
		Payment p = paymentService.addPayment(payment);
		System.out.println(p);
		}
	
	@Test
	void testRemovePayment() {
		paymentService.cancelPayment(32);
	}
	
	@Test
	void testViewPayment() {
		Payment payment = paymentService.viewPayment(40);
		System.out.println(payment);
	}
	
	
	@Test
	void testViewAllPayment() {
		List<Payment> payment = paymentService.viewAllPayment("Car");
		System.out.println(payment);
	}
	
	@Test
	void testViewPayments() {
		List<Payment> payments = paymentService.viewPayments();
		System.out.println(payments);
		assertEquals(5, payments.size());
	}
	
}
