package com.cabServiceTest;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.cabInvoiceGenrator.InvoiceGenerator;

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
	
}
