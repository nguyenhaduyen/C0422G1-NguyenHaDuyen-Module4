package com.example.model;

public class PaperDeclaration {
    private int id;
    private String name;
    private String yearOfBirth;
    private String gender;
    private String nation;
    private String identify;
    private String vehicle;
    private String vehicleCode;
    private String numberOfSeats;
    private String startDate;
    private String monthStart;
    private String yearStart;
    private String endDate;
    private String monthEnd;
    private String yearEnd;
    private String notification;

    public PaperDeclaration() {

    }

    public PaperDeclaration(int id, String name, String yearOfBirth, String gender, String nation, String identify, String vehicle, String vehicleCode, String numberOfSeats, String startDate, String monthStart, String yearStart, String endDate, String monthEnd, String yearEnd, String notification) {
        this.id = id;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.nation = nation;
        this.identify = identify;
        this.vehicle = vehicle;
        this.vehicleCode = vehicleCode;
        this.numberOfSeats = numberOfSeats;
        this.startDate = startDate;
        this.monthStart = monthStart;
        this.yearStart = yearStart;
        this.endDate = endDate;
        this.monthEnd = monthEnd;
        this.yearEnd = yearEnd;
        this.notification = notification;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getVehicleCode() {
        return vehicleCode;
    }

    public void setVehicleCode(String vehicleCode) {
        this.vehicleCode = vehicleCode;
    }

    public String getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(String numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getMonthStart() {
        return monthStart;
    }

    public void setMonthStart(String monthStart) {
        this.monthStart = monthStart;
    }

    public String getYearStart() {
        return yearStart;
    }

    public void setYearStart(String yearStart) {
        this.yearStart = yearStart;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getMonthEnd() {
        return monthEnd;
    }

    public void setMonthEnd(String monthEnd) {
        this.monthEnd = monthEnd;
    }

    public String getYearEnd() {
        return yearEnd;
    }

    public void setYearEnd(String yearEnd) {
        this.yearEnd = yearEnd;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }
}