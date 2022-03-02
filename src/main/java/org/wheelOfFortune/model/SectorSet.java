package org.wheelOfFortune.model;

import org.wheelOfFortune.model.Sector;

public enum SectorSet {

    ZERO("Ноль"),
    PRIZE("Приз"),
    BANKRUPT("Банкрот"),
    LUCK("Удача"),
//    N750("750"),
//    N500("500"),
//    N250("250"),
//    N1000("1000"),
//    N600("ШыШоТ"),
//    N1("1"),
//    N3("3"),
//    N5("5"),
    ;

    private final Sector sector;

    SectorSet(String name){
        sector = new Sector(name);
    }

    public Sector getSector(){
        return sector;
    }
}
