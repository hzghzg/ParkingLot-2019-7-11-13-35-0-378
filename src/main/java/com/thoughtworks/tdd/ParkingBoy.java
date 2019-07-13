package com.thoughtworks.tdd;

public class ParkingBoy {

    ParkingLot parkingLot=new ParkingLot();

    public Ticket parkingCar(Car car) {
        parkingLot.setCar(car);
        return new Ticket();
    }

    public Car fetchCar(Ticket ticket) {
        return parkingLot.getCar();
    }
}
