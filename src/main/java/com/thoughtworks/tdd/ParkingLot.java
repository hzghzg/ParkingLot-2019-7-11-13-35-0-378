package com.thoughtworks.tdd;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private Map<Ticket,Car> cars=new HashMap<>();

    public Ticket setCar(Car car) {
        Ticket ticket = new Ticket();
        cars.put(ticket,car);
        return ticket;
    }

    public Car getCarByTicket(Ticket ticket) {
        return cars.remove(ticket);
    }


}
