package org.wheelOfFortune.model;

public class Logic {

    private final Wheel wheel;
    private final Rotator rotator;
    private int angle;
    private int currentAngle;

    public Logic(){

          wheel = new Wheel();
        rotator = new Rotator();

        angle = wheel.getSectorSize();
        currentAngle = angle;

    }

    public void action(){


        angle = currentAngle + rotator.rotate();
//        angle = previousAngle + 45;
//        angle =  50;
        currentAngle += angle;
        normalizeCurrentAngle();

    }

    public Sector getSector(){

        return wheel.getSector(currentAngle);
    }

    public int getAngle() {
        return angle;
    }

    public int getSectorAmount(){
        return wheel.getSectorAmount();
    }

    public Wheel getWheel() {
        return wheel;
    }

    public int getCurrentAngle() {
        return currentAngle;
    }

    private void normalizeCurrentAngle(){
        if(currentAngle >360){
            currentAngle = currentAngle %360;
        }
    }
}
