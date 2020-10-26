package com.cabServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.cabInvoiceGenrator.CabRide;
import com.cabInvoiceGenrator.InvoiceService;
import com.cabInvoiceGenrator.InvoiceSummary;
import com.cabInvoiceGenrator.Ride;
import com.cabInvoiceGenrator.RideRepository;

public class InvoiceServiceTest {
	static InvoiceService invoiceService = null;
	static Ride[] rides = null;
	static RideRepository rideRepository = new RideRepository();
	static InvoiceSummary expectedInvoiceSummary = null;

	@BeforeAll
	public static void setUp() {
		invoiceService = new InvoiceService();
		rides = new Ride[] { new Ride(CabRide.NORMAL, 3.0, 10), new Ride(CabRide.PREMIUM, 1.0, 5) };
		expectedInvoiceSummary = new InvoiceSummary(2, 65);
	}

	@Test
	public void givenDifferentRides_shouldReturnInvoiceSummary() {
		InvoiceSummary invoiceSummary = invoiceService.calculateFare(rides);
		assertEquals(expectedInvoiceSummary, invoiceSummary);
	}

	@Test
	public void givenUserIdAndRides_ShouldReturnInvoiceSummary() {
		String userId = "abc@d.com";
		rideRepository.addRides(userId, rides);
		invoiceService.setRideRepository(rideRepository);
		InvoiceSummary invoiceSummary = invoiceService.getInvoiceSummary(userId);
		assertEquals(expectedInvoiceSummary, invoiceSummary);
	}
}
