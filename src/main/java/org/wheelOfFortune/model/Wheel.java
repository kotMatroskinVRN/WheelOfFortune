package org.wheelOfFortune.model;

import org.wheelOfFortune.model.Sector;
import org.wheelOfFortune.model.SectorSet;

import java.util.EnumSet;

public class Wheel {

    private final int sectorAmount;
    private final int sectorSize;

    private final EnumSet<SectorSet> sectors ;

    public Wheel() {
        sectors = EnumSet.allOf(SectorSet.class);

        sectorAmount = sectors.size();
        sectorSize   = 360 / sectorAmount;
    }

    public Sector getSector(int angle){
        int number = angle/sectorSize;
        int arrayNumber = number%sectorAmount;
//        if( arrayNumber == sectors.size()) {
//            arrayNumber =0;
//        }
        System.out.println(sectors);
        return SectorSet.values()[arrayNumber].getSector();
    }

    public int getSectorAmount() {
        return sectorAmount;
    }

    public int getSectorSize() {
        return sectorSize;
    }
}
