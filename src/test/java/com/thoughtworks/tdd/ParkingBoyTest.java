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

    @Test
    public void should_return_cars_when_fetch_car_given_has_ticket(){

        //given
        Car car=new Car();
        Car car1 = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket=parkingBoy.parkingCar(car);
        Ticket ticket1=parkingBoy.parkingCar(car1);


        //when
        Car fetchCar=parkingBoy.fetchCar(ticket);
        Car fetchCar1=parkingBoy.fetchCar(ticket1);

        //then
        Assertions.assertSame(car,fetchCar);
        Assertions.assertSame(car1,fetchCar1);
    }

}
