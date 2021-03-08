package com.project.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.main.entities.Booking;
import com.project.main.entities.Payment;
import com.project.main.entities.Vehicle;
import com.project.main.exceptions.PaymentException;
import com.project.main.exceptions.PaymentNotFoundException;
import com.project.main.repositories.IBookingRepository;
import com.project.main.repositories.IPaymentRepository;

@Service
public class PaymentService {
	@Autowired
	IPaymentRepository paymentRepository;
	
	@Autowired
	IBookingRepository bookingRepository;
	
	
	//@Override
	public Payment addPayment(Payment p)  {
		Payment payment = paymentRepository.findPaymentById(p.getPaymentId());		
		if(payment == null){
			paymentRepository.save(p);
		}else
			throw new PaymentException("Payment "+ p.getPaymentId()  + " already exists.");
		return payment;
	}
	
//	@Override
	public Payment cancelPayment(int id) {
		Optional<Payment> payment = paymentRepository.findById(id);
		if(payment.isEmpty()){
			throw new PaymentNotFoundException("Payment with id " +id +" not found");
 		}
		Payment p = payment.get(); 
		List<Booking> booking = bookingRepository.findByPayment(p);
		if(!(booking.isEmpty())) {
			throw new PaymentException("Payment with boooking cannot be deleted");
		}
		paymentRepository.delete(p);	
		return p;
	}
	
	//@Override
	public List<Payment> viewPayments()
	{	
		List<Payment> payments = paymentRepository.findAll();
		if(payments.isEmpty()) {
			throw new PaymentNotFoundException("No payments found");
		}
		return payments;
	}
	
// @Override

	public List<Payment> findBookingByVehicle(Vehicle vehicle) {
		// TODO Auto-generated method stub
	   List<Payment> payments = paymentRepository.findBookingByVehicle(vehicle);
		if(payments.isEmpty()){
			throw new PaymentNotFoundException("Payment not found");
		}
		return payments;
	}
	

}
