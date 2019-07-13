package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private Map<Ticket,Car> cars=new HashMap<>();

    public Ticket setCar(Car car) {
        Ticket ticket = new Ticket();
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
}
