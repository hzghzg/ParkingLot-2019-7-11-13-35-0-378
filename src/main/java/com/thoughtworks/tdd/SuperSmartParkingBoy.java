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
        for (int i = 1; i <=this.parkingLots.size() ; i++) {
            float currentRate=(float)this.parkingLots.get(i).getCars().size()/(this.parkingLots.get(i).getCapacity());
            if(currentRate>lessRate){
                lessNumber=i;
                lessRate=currentRate;
            }
            else if(currentRate==lessRate){
                Integer currentSize=this.parkingLots.get(i).getCars().size();
                Integer lessSize=this.parkingLots.get(lessNumber).getCars().size();
                lessNumber=currentSize>lessSize?lessNumber:i;
            }

        }
        Ticket ticket=this.parkingLots.get(lessNumber).setCar(car);
        return ticket;
    }
}
