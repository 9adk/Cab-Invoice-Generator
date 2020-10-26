package com.cabInvoiceGenrator;

public class InvoiceGenerator {

	private static final double MINIMUM_COST_PER_KILOMETER = 10;
	private static final int COST_PER_TIME = 1;
	private static final double MINIMUM_FARE = 5;

	/**
	 * Calculating fare for a ride
	 * 
	 * @param distance
	 * @param time
	 * @return
	 */
	public double calculateFare(double distance, int time) {
		double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
		if (totalFare < MINIMUM_FARE) {
			return MINIMUM_FARE;
		}
		return totalFare;
	}

	/**
	 * Modified method to get InvoiceSummary for multiple rides
	 * 
	 * @param multipleRides
	 * @return
	 */
	public InvoiceSummary calculateFare(Ride[] multipleRides) {
		double totalFare = 0;
		for (Ride ride : multipleRides) {
			totalFare = totalFare + this.calculateFare(ride.distance, ride.time);
		}
		return new InvoiceSummary(multipleRides.length, totalFare);
	}

}
