package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {

    private Map<Ticket,Car> cars=new HashMap<>();

    private Integer parkingLotNumber;
    private Integer capacity;

    public ParkingLot(Integer parkingLotNumber) {
        this.parkingLotNumber = parkingLotNumber;
    }

    public ParkingLot(Integer parkingLotNumber, Integer capacity) {
        this.parkingLotNumber = parkingLotNumber;
        this.capacity = capacity;
    }

    public Integer getParkingLotNumber() {
        return parkingLotNumber;
    }

    public Ticket setCar(Car car) {
        Ticket ticket = new Ticket();
        ticket.setParkingLotNumber(this.parkingLotNumber);
        if(cars.size()<10){
            cars.put(ticket,car);
            return ticket;
        }else{
            return null;
        }
    }

    public Car getCarByTicket(Ticket ticket) {
        return cars.remove(ticket);
    }

    public Map<Ticket, Car> getCars() {
        return cars;
    }

    public Integer getCapacity() {
        return capacity;
    }
}
