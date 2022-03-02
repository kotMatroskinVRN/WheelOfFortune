package org.wheelOfFortune.contoller;

import org.wheelOfFortune.model.Logic;
import org.wheelOfFortune.model.Sector;

public class GUIcontroller {

    private final Logic logic;

    public GUIcontroller(Logic logic) {
        this.logic = logic;
    }

    public void init(){}

    public void action(){

        logic.action();
        Sector sector = logic.getSector();
        int angle = logic.getAngle();
        int lefOver = angle%360;

        System.out.printf( "%-7d%-7d%s\n" , angle , lefOver , sector  );


    }

    public int getAngle(){
        return logic.getAngle();
    }

    public Sector getSector(){
        return logic.getSector();
    }

}
