package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParkingBoyTest {

    @Test
    public void should_return_car_when_fetch_car_given_has_tickets(){

        //given
        Car car=new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket=parkingBoy.parkingCar(car);

        //when
        Car fetchCar=parkingBoy.fetchCar(ticket);

        //then
        Assertions.assertSame(car,fetchCar);
    }

}
