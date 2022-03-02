package org.wheelOfFortune.view;


import javafx.geometry.Dimension2D;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.text.Font;
import org.wheelOfFortune.model.Wheel;

import java.util.HashSet;
import java.util.Set;


public class WheelView extends ImageView {

    private final int DIAMETER = 600;
    private final int RADIUS = DIAMETER /2;
    private final int MARGIN = 3 ;

    private final GraphicsContext graphicsContext;
    private final Canvas canvas;
    private final Wheel wheel;

    private int angle = 0;

    WheelView(Wheel wheel){
        super();
        canvas = new Canvas();
        canvas.setHeight(DIAMETER+2*MARGIN);
        canvas.setWidth(DIAMETER+2*MARGIN);
        graphicsContext = canvas.getGraphicsContext2D();
        this.wheel = wheel;



    }

    public void init(){
        graphicsContext.setFill(Color.AQUA);
        graphicsContext.setStroke(Color.BLACK);
        graphicsContext.setLineWidth(MARGIN);
        graphicsContext.fillOval(MARGIN,MARGIN,DIAMETER,DIAMETER);
        graphicsContext.strokeOval(MARGIN  , MARGIN ,DIAMETER,DIAMETER);

        makeSectors( wheel.getSectorAmount() );
        makeLabels(wheel);
        graphicsContext.setFill(Color.TRANSPARENT);
        graphicsContext.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        SnapshotParameters sp = new SnapshotParameters();
        sp.setFill(Color.TRANSPARENT);
        int x = (int) canvas.getWidth();
        int y = (int) canvas.getHeight();
        WritableImage wheelSnapshot = new WritableImage(  x ,  y );
        canvas.snapshot(sp , wheelSnapshot);

        setImage(wheelSnapshot);
    }

    public void rotate(int toAngle ){

        this.angle += toAngle;

        Rotation rotation = new Rotation(this , toAngle );
        rotation.action();

    }

    private Dimension2D getCenter(){
        return new Dimension2D( RADIUS+MARGIN , RADIUS+MARGIN ) ;
    }

    private Dimension2D getOnRingPoint(int angle){
        double radianAngle = Math.toRadians(angle) ;
        double x =  RADIUS * Math.cos(radianAngle) ;
        double y =  RADIUS * Math.sin(radianAngle) ;

        return new Dimension2D(getCenter().getWidth() +  x , getCenter().getWidth() +  y );
    }

    private void makeSectors(  int number ){

        graphicsContext.setFill(Color.GRAY);
        graphicsContext.setLineWidth(MARGIN);
        graphicsContext.setLineCap(StrokeLineCap.ROUND);

        Dimension2D from = getCenter();

        for(Integer angle : getSetOfAngles(number)){


            Dimension2D to   = getOnRingPoint(angle);
            graphicsContext.strokeLine( from.getWidth(), from.getHeight() , to.getWidth(), to.getHeight());

        }

    }

    private void makeLabels(Wheel wheel){


        for(Integer angle : getSetOfAngles( wheel.getSectorAmount() )){
            int textAngle = angle - ( 180 / wheel.getSectorAmount());
            Dimension2D onRing = getOnRingPoint( textAngle );

            int x = (int) (   ( onRing.getWidth()   - getCenter().getWidth()  ) * 0.5);
            int y = (int) (   ( onRing.getHeight()  - getCenter().getHeight() ) * 0.5);

            graphicsContext.setFont(new Font(24));
            graphicsContext.save();
            graphicsContext.translate(getCenter().getWidth() + x , getCenter().getHeight() +  y);
            graphicsContext.rotate(textAngle);
            graphicsContext.strokeText(wheel.getSector(angle).toString(),  0 , 0 );
//            graphicsContext.strokeText(wheel.getSector(angle+ wheel.getSectorSize()).toString(),  0 , 0 );
            graphicsContext.restore();


        }
    }



    private Set<Integer> getSetOfAngles(int number){
        Set<Integer> result = new HashSet<>();
        int size = 360 / number;

        for(int i=0; i< number ; i++){
            result.add(i*size);
        }
        return result;
    }

}
