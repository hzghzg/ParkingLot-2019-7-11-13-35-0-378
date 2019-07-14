package com.thoughtworks.tdd;

import java.util.Map;

public class SuperSmartParkingBoy extends ParkingBoy{
    public SuperSmartParkingBoy(Map<Integer, ParkingLot> parkingLots)  {
        this.parkingLots=parkingLots;
    }

    @Override
    public Ticket parkingCar(Car car) {
        Integer lessNumber=1;
        float lessRate=0.00f;
        for (Map.Entry<Integer,ParkingLot> entry : this.parkingLots.entrySet()){
            float currentRate=(float)entry.getValue().getCars().size()/(entry.getValue().getCapacity());
            if(currentRate>lessRate){
                lessNumber=entry.getKey();
                lessRate=currentRate;
            }
            else if(currentRate==lessRate){
                Integer currentSize=entry.getValue().getCars().size();
                Integer lessSize=entry.getValue().getCars().size();
                lessNumber=currentSize>lessSize?lessNumber:entry.getKey();
            }
        }
        Ticket ticket=this.parkingLots.get(lessNumber).setCar(car);
        return ticket;
    }
}
