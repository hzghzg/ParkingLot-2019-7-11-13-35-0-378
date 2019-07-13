package com.thoughtworks.tdd;

public class ParkingBoy {

    ParkingLot parkingLot=new ParkingLot();
    private String message;

    public Ticket parkingCar(Car car) {
        if(parkingLot.getCars().size()==10)message= "Not enough position.";
        return parkingLot.setCar(car);
    }

    public Car fetchCarByTicket(Ticket ticket) {
        Car car=parkingLot.getCarByTicket(ticket);
        if(ticket==null)message="Please provide your parking ticket.";
        else if(car==null)message= "Unrecognized parking ticket";
        return car;
    }

    public String showMessage() {
        return message;
    }

}
