package model;

public class GroupBooking extends Booking {
    // gives 10% discount for group bookings
    private double discountRate = 0.10; // 10% group discount

    // constructor
    public GroupBooking(String bookingId, String fullName, String phoneNumber, String address,
                        String gender, String email, String packageId, String bookingDate,
                        String status, String specialRequirements, int numberOfPeople, double totalPrice) {
        // call the superclass constructor
        super(bookingId, fullName, phoneNumber, address, gender, email,
                packageId, bookingDate, status, specialRequirements, numberOfPeople);
        // set total price directly
        this.totalPrice = totalPrice;
    }

    // overrides the abstract method
    @Override
    public double calculateTotalPrice(double basePrice) {
        // calculate full price
        double gross = basePrice * numberOfPeople;

        this.totalPrice = gross - (gross * discountRate);
        return totalPrice;
    }
}
