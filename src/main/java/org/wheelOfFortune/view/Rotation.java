package org.wheelOfFortune.view;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class Rotation {

    private final RotateTransition rotateTransition;
    private final int angle = 0;

    Rotation(Node node , int toAngle  ){
        rotateTransition = new RotateTransition();

        rotateTransition.setNode(node);
//        rotateTransition.setDuration(Duration.seconds( toAngle/360));
//        rotateTransition.setByAngle(toAngle);
        rotateTransition.setByAngle(-1*toAngle);
        rotateTransition.setInterpolator(Interpolator.LINEAR);

//        System.out.printf("from: %-6.0f , to: %-6.0f\n" ,
//                rotateTransition.getFromAngle()%360 ,
//                rotateTransition.getToAngle()%360
//        );

        rotateTransition.setOnFinished((ae) -> {

            System.out.println(rotateTransition.getAxis());


        });

    }

    public void action(){
        rotateTransition.play();
    }
}
