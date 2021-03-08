package com.project.main.test;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.main.entities.Booking;
import com.project.main.services.ActiveBookingService;

@SpringBootTest
class ActiveBookingTest {

	@Autowired
	ActiveBookingService activeBookingService;
	
	@Test
	void testViewActiveBookings() {
		List<Booking> bookings =  activeBookingService.viewActiveBookings();
		System.out.println(bookings);
	}
	
//	@Test
	void testViewActiveBookingByBookingDate() {
		List<Booking> bookings =  activeBookingService.viewActiveBookingByBookingDate(LocalDate.of(2021, 03, 04));
		System.out.println(bookings);
	}
	
//	@Test
	void testViewActiveBookingBetweenDates() {
		List<Booking> bookings =  activeBookingService.viewActiveBookingBetweenDates(LocalDate.of(2021, 03, 04),LocalDate.of(2021, 03, 06));
		System.out.println(bookings);
	}

}
