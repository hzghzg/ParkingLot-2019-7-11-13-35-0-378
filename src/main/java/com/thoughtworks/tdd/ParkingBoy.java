package com.thoughtworks.tdd;

public class ParkingBoy {

    ParkingLot parkingLot=new ParkingLot();

    public Ticket parkingCar(Car car) {
        return parkingLot.setCar(car);
    }

    public Car fetchCarByTicket(Ticket ticket) {
        return parkingLot.getCarByTicket(ticket);
    }

    public String showMessage() {
        return "Unrecognized parking ticket";
    }
}
