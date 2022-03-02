package org.wheelOfFortune.view;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.wheelOfFortune.contoller.Controller;
import org.wheelOfFortune.model.Logic;

public class GUI extends Application {

//    private static Controller controller;

//    public GUI(Controller controller){
//        GUI.controller = controller;
//    }

    @Override
    public void start(Stage stage) {

        Logic logic = new Logic();
        Controller controller = new Controller(logic);

        BorderPane borderPane = new BorderPane();
        Label label = new Label("test");
        Button button = new Button("Rotate");
        WheelView wheelView = new WheelView(controller.getWheel());
        wheelView.init();


        Scene scene = new Scene(borderPane);

        stage.setScene(scene);
        stage.setTitle("GUI");
        stage.setHeight(820);
        stage.setWidth(820);

        label.setFont(new Font(30));

        borderPane.setTop( label);
        borderPane.setBottom( button);
        borderPane.setCenter(wheelView);



        BorderPane.setAlignment(button, Pos.CENTER);
        BorderPane.setAlignment(label, Pos.CENTER);



        button.setOnAction((ae) -> {
            controller.action();

            wheelView.rotate(controller.getAngle() );

            label.setText(controller.getSector().toString());


        });



        stage.show();

    }

    public void init( String[] args ){

        launch(args);

    }
}
