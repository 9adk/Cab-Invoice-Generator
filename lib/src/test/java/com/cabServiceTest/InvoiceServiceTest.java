package com.cabServiceTest;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.cabInvoiceGenrator.InvoiceGenerator;
import com.cabInvoiceGenrator.InvoiceSummary;
import com.cabInvoiceGenrator.Ride;

public class InvoiceServiceTest {
	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 3.0;
		int time = 5;
		double fare = invoiceGenerator.calculateFare(distance, time);
		assertEquals(35, fare);
	}
	@Test
	public void givenLessDistanceOrTime_ShouldReturnMinFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 0.1;
		int time = 2;
		double fare = invoiceGenerator.calculateFare(distance, time);
		assertEquals(5, fare);
	}
	@Test
	public void givenDifferentRides_shouldReturnInvoiceSummary() {
		Ride[] rides = { new Ride(3.0, 5),
				         new Ride(0.1, 2)
		               };
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		InvoiceSummary invoiceSummary = invoiceGenerator.calculateFare(rides);
		InvoiceSummary excpectedInvoiceSummary = new InvoiceSummary(2, 40.0);
		assertEquals(excpectedInvoiceSummary,invoiceSummary);	
	}
	@Test
	public void givenUserIDAndRides_shouldReturn_InvoiceSummary() {
		String userId = "abc@xyz";
		Ride[] rides = { new Ride(3.0, 5),
		         new Ride(0.1, 2)
              };
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		invoiceGenerator.addRides(userId, rides);
		InvoiceSummary summary = invoiceGenerator.getInvoiceSummary(userId);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 40.0);
		assertEquals(expectedInvoiceSummary, summary);
	}
}