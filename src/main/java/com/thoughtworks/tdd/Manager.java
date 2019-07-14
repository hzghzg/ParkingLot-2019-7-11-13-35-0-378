package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Manager extends ParkingBoy{

    private Map<String,ParkingBoy> managerList = new HashMap<>();

    public Manager(Map<String,ParkingBoy> managerList, Map<Integer, ParkingLot> parkingLots) {
        this.managerList=managerList;
        this.parkingLots=parkingLots;
    }

    public ParkingBoy specify(String name) {
        ParkingBoy specifyBoy=null;
        for (Map.Entry<String,ParkingBoy> entry:managerList.entrySet()){
            if(name==entry.getKey()){
                return  entry.getValue();
            }
        }
        return specifyBoy;
    }

    public String showMessage(){
        for (Map.Entry<String,ParkingBoy> entry:managerList.entrySet()){
            if(entry.getValue()!=null&&entry.getValue().message!=""){
                return entry.getValue().message;
            }
        }
        return null;
    }

}
