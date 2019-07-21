package com.thoughtworks.tdd;

import java.util.HashMap;
import java.util.Map;

public class ParkingBoy {

    public static final int MAXCAPACITY = 10;
    protected Map<Integer,ParkingLot> parkingLots=new HashMap<>();
    protected String message;

    public ParkingBoy() {
        parkingLots.put(1,new ParkingLot(1));
    }

    public ParkingBoy(Map<Integer, ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket parkingCar(Car car) {
        for (int i=1;i<=parkingLots.size();i++) {
            if(parkingLots.get(i).getCars().size()==MAXCAPACITY&&i==parkingLots.size()) message= "Not enough position.";
            if(parkingLots.get(i).getCars().size()==MAXCAPACITY)continue;
            else return parkingLots.get(i).setCar(car);
        }
        return null;
    }

    public Car fetchCarByTicket(Ticket ticket) {
        if(ticket==null){
            message="Please provide your parking ticket.";
            return null;
        }
        if(ticket.getParkingLotNumber()==null){
            message= "Unrecognized parking ticket";
            return null;
        }
        Car car=parkingLots.get(ticket.getParkingLotNumber()).getCarByTicket(ticket);
        if(car==null)message= "Unrecognized parking ticket";
        return car;
    }

    public String showMessage() {
        return message;
    }

}
