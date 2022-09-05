package com.example.repository.impl;

import com.example.model.Vehicle;
import com.example.repository.IVehicleRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepository implements IVehicleRepository {
    private static List<Vehicle> vehicleList = new ArrayList<>();

    static {
        vehicleList.add(new Vehicle("Máy bay"));
        vehicleList.add(new Vehicle("Tàu Thuyền"));
        vehicleList.add(new Vehicle("Ô Tô"));
        vehicleList.add(new Vehicle("Khác"));
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicleList;
    }
}
