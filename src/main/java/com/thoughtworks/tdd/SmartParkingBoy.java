package com.thoughtworks.tdd;

import java.util.Map;

public class SmartParkingBoy extends ParkingBoy{

    public SmartParkingBoy(Map<Integer, ParkingLot> parkingLots) {
        this.parkingLots=parkingLots;
    }

    @Override
    public Ticket parkingCar(Car car) {
        Integer lessNumber=1;
        Integer lessSize=10;
        for (int i = 1; i <=this.parkingLots.size() ; i++) {
            lessNumber=this.parkingLots.get(i).getCars().size()<lessSize?i:lessNumber;
            lessSize=this.parkingLots.get(lessNumber).getCars().size();
        }
        Ticket ticket=this.parkingLots.get(lessNumber).setCar(car);
        return ticket;
    }
}
