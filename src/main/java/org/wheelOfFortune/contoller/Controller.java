package org.wheelOfFortune.contoller;

import org.wheelOfFortune.model.Logic;
import org.wheelOfFortune.model.Sector;
import org.wheelOfFortune.model.Wheel;

public class Controller {

    private final Logic logic;

    public Controller(Logic logic) {
        this.logic = logic;
    }


    public void action(){

        logic.action();
        Sector sector = logic.getSector();
        int angle = logic.getAngle();
        int lefOver = angle%360;

        System.out.printf( "%-7d%-7d%s\n" , angle , lefOver , sector  );


    }

    public Wheel getWheel(){
        return logic.getWheel();
    }

    public int getAngle(){
        return logic.getAngle();
    }
    public int getCurrentAngle(){
        return logic.getCurrentAngle();
    };

    public Sector getSector(){
        return logic.getSector();
    }

}
