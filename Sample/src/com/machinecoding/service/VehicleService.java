package com.machinecoding.service;

import com.machinecoding.entity.Reservation;
import com.machinecoding.entity.User;
import com.machinecoding.entity.Vehicle;
import com.machinecoding.repository.VehicleAccessRepository;
import com.machinecoding.types.VehicleType;

import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VehicleService {

    VehicleAccessRepository vehicleAccessRepository;

    public int bookVehicle (VehicleType type, Date startDate, int duration, User user) {
        // fetch vehicles with type=type status=active
        TemporalUnit t = null;
//        LocalDateTime endTime = startTime.plus(duration, t);
        Date dueDate = null;
        List<Vehicle> vehicles = new ArrayList<>();

        Vehicle bookedVehicle = null;
        try {
            vehicles = vehicleAccessRepository.findByType(type);
            if (vehicles.size() <= 0) {
                System.out.println("Vehicle not available for booking");
                return -1;
            }
            for (Vehicle vehicle : vehicles) {
                List<Reservation> listOfReservations = vehicleAccessRepository.getVehicleByBarcode(vehicle.getBarcode());
                for (Reservation curr : listOfReservations) {
                    if (curr.getReturnTime().compareTo(startDate) >= 0 || dueDate.compareTo(curr.getStartTime()) < 0) {
                        bookedVehicle = vehicle;
                        break;
                    }
                }
                /// 10-2
            }
        } catch (Exception e) {

        }
        if (bookedVehicle == null) {
            System.out.println("Vehicle not available for booking");
            return -1;
        }
        try {
            vehicleAccessRepository.confirmRegistration(bookedVehicle.getBarcode(), startDate, dueDate, user.getEmailId(), false);
        } catch (Exception e) {

        }
        bookedVehicle.setParkingStall(null);
        return 0;
    }

    public int returnVehicle (Reservation reservation) {
        // make vehicle available again and status as open
        reservation.setReturnTime(new Date());
        reservation.setStatus(true);
        return 0;
    }

    public double calculateAmountToBePaid (Reservation reservation) {
        double totalCost = reservation.getVehicleType().getPrice();
        double totalHours = Math.ceil((reservation.getReturnTime().getTime() - reservation.getStartTime().getTime()) / (1000*60*60));
        return totalCost*totalHours;
    }

    public String checkStatus (Vehicle vehicle) {
        // get status of vehicle
        StringBuilder listOfBookings = new StringBuilder();
        List<Reservation> activeBookingsForCurrVehicle = vehicleAccessRepository.getVehicleByBarcode(vehicle.getBarcode());
        if (activeBookingsForCurrVehicle.size() == 0) {
            return vehicle.getParkingStall().toString();
        } else {
            for (Reservation current : activeBookingsForCurrVehicle) {
                listOfBookings.append(current.toString());
                listOfBookings.append('\n');
            }
        }
        return listOfBookings.toString();
    }
}
