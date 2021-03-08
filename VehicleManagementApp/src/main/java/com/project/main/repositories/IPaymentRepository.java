package com.project.main.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.main.entities.Payment;
import com.project.main.entities.Vehicle;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Integer>{
	public List<Payment> findBookingByVehicle(Vehicle vehicle);
	
	public Payment findPaymentById(int paymentId);
	
}
