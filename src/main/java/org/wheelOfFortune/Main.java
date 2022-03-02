package org.wheelOfFortune;

import org.wheelOfFortune.contoller.Controller;
import org.wheelOfFortune.model.Logic;
import org.wheelOfFortune.view.GUI;

public class Main {

    public static void main(String[] args) {

//        Logic logic = new Logic();
//        Controller controller = new Controller(logic);
        GUI gui = new GUI();

        gui.init( args );


    }

}
