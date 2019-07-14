package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class ParkingBoyTest {

    @Test
    public void should_return_car_when_fetch_car_given_has_tickets(){

        //given
        Car car=new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket=parkingBoy.parkingCar(car);

        //when
        Car fetchCar=parkingBoy.fetchCarByTicket(ticket);

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
        Car fetchCar=parkingBoy.fetchCarByTicket(ticket);
        Car fetchCar1=parkingBoy.fetchCarByTicket(ticket1);

        //then
        Assertions.assertSame(car,fetchCar);
        Assertions.assertSame(car1,fetchCar1);
    }

    @Test
    public void should_return_null_when_fetch_car_given_has_fake_ticket(){

        //given
        Car car=new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket=parkingBoy.parkingCar(car);
        Ticket fakeTicket=new Ticket();

        //when
        Car fetchCar=parkingBoy.fetchCarByTicket(fakeTicket);
        //then
        Assertions.assertSame(null,fetchCar);
    }

    @Test
    public void should_return_null_when_fetch_car_given_has_null_ticket(){

        //given
        Car car=new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket=parkingBoy.parkingCar(car);

        //when
        Car fetchCar=parkingBoy.fetchCarByTicket(null);

        //then
        Assertions.assertSame(null,fetchCar);
    }

    @Test
    public void should_return_null_when_fetch_car_given_has_used_ticket(){

        //given
        Car car=new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket=parkingBoy.parkingCar(car);

        //when
        Car fetchCar=parkingBoy.fetchCarByTicket(ticket);
        Car fetchCar1=parkingBoy.fetchCarByTicket(ticket);

        //then
        Assertions.assertSame(null,fetchCar1);
    }

    @Test
    public void should_return_null_when_parking_car_given_full_position_parkingLot(){

        //given
        Car car=new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        for (int i = 0; i < 10; i++) {
            parkingBoy.parkingCar(new Car());
        }

        //when
        Ticket ticket=parkingBoy.parkingCar(car);


        //then
        Assertions.assertSame(null,ticket);
    }

    @Test
    public void should_return_errorMessage_when_parking_car_given_has_fake_ticket(){

        //given
        Car car=new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket=parkingBoy.parkingCar(car);
        Ticket fakeTicket=new Ticket();

        //when
        Car fetchCar=parkingBoy.fetchCarByTicket(fakeTicket);

        //then
        Assertions.assertSame(null,fetchCar);
        Assertions.assertSame("Unrecognized parking ticket",parkingBoy.showMessage());
    }

    @Test
    public void should_return_errorMessage_when_parking_car_given_has_used_ticket(){

        //given
        Car car=new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket=parkingBoy.parkingCar(car);

        //when
        Car fetchCar=parkingBoy.fetchCarByTicket(ticket);
        Car fetchCar1=parkingBoy.fetchCarByTicket(ticket);

        //then
        Assertions.assertSame(null,fetchCar1);
        Assertions.assertSame("Unrecognized parking ticket",parkingBoy.showMessage());
    }

    @Test
    public void should_return_errorMessage_when_fetch_car_given_has_null_ticket(){

        //given
        Car car=new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket=parkingBoy.parkingCar(car);

        //when
        Car fetchCar=parkingBoy.fetchCarByTicket(null);

        //then
        Assertions.assertSame(null,fetchCar);
        Assertions.assertSame("Please provide your parking ticket.",parkingBoy.showMessage());
    }

    @Test
    public void should_return_errorMessage_when_parking_car_given_full_position_parkingLot(){

        //given
        Car car=new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        for (int i = 0; i < 10; i++) {
            parkingBoy.parkingCar(new Car());
        }

        //when
        Ticket ticket=parkingBoy.parkingCar(car);

        //then
        Assertions.assertSame("Not enough position.",parkingBoy.showMessage());
    }

    @Test
    public void should_return_second_parkingLot_number_when_first_parkingLot_full_given_has_car(){

        //given
        Map<Integer,ParkingLot> parkingLots=new HashMap<>();
        parkingLots.put(1,new ParkingLot(1));
        parkingLots.put(2,new ParkingLot(2));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        for (int i = 0; i <10 ; i++) {
            parkingBoy.parkingCar(new Car());
        }
        Car car=new Car();

        //when
        Ticket ticket=parkingBoy.parkingCar(car);
        Integer number = ticket.getParkingLotNumber();

        //then
        Assertions.assertSame(2,number);
    }

    @Test
    public void should_return_more_empty_position_parkingLot_number_when_parking_car_given_has_car(){

        //given
        Map<Integer,ParkingLot> parkingLots=new HashMap<>();
        parkingLots.put(1,new ParkingLot(1));
        parkingLots.put(2,new ParkingLot(2));
        SmartParkingBoy smartParkingBoy=new SmartParkingBoy(parkingLots);
        for (int i = 0; i <5 ; i++) {
            smartParkingBoy.parkingCar(new Car());
        }
        for (int i = 0; i <4 ; i++) {
            smartParkingBoy.parkingCar(new Car());
        }
        Car car=new Car();

        //when
        Ticket ticket=smartParkingBoy.parkingCar(car);
        Integer number = ticket.getParkingLotNumber();

        //then
        Assertions.assertSame(2,number);
    }

    @Test
    public void should_return_larger_rate_parkingLot_number_when_parking_car_given_has_car(){

        //given
        Map<Integer,ParkingLot> parkingLots=new HashMap<>();
        parkingLots.put(1,new ParkingLot(1,10));
        parkingLots.put(2,new ParkingLot(2,15));
        SuperSmartParkingBoy superSmartParkingBoy=new SuperSmartParkingBoy(parkingLots);
        for (int i = 0; i <5 ; i++) {
            superSmartParkingBoy.parkingCar(new Car());
        }
        for (int i = 0; i <4 ; i++) {
            superSmartParkingBoy.parkingCar(new Car());
        }
        Car car=new Car();

        //when
        Ticket ticket=superSmartParkingBoy.parkingCar(car);
        Integer number = ticket.getParkingLotNumber();

        //then
        Assertions.assertSame(2,number);
    }


}
