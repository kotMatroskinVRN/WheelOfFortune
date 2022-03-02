package org.wheelOfFortune.model;

public class Rotator {

    private static final int MAX_ANGLE = 7200;

    public int rotate(){
        return (int) (Math.random() * MAX_ANGLE) + 1;
    }
}
