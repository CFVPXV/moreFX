package com.example.morefx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application implements EventHandler<ActionEvent>
{
    //The window is the app window.
    private FlowPane window;
    //The viewer will be the different panels.
    private Pane viewer;
    //The two different panels.
    private mouseFollow panel1;
    private BouncingBox panel2;
    @Override
    public void start(Stage stage) {
        //Instantiate objects.
        panel1 = new mouseFollow();
        panel2 = new BouncingBox();
        viewer = new Pane();
        window = new FlowPane();
        window.setPrefSize(270,300);
        viewer.setPrefSize(270,270);
        Button p1 = new Button();
        p1.setText("Mouse Follow");
        p1.setOnAction(this);
        Button p2 = new Button();
        p2.setText("Animation");
        p2.setOnAction(this);
        //The app panel gets the viewer and the two buttons to change
        //the panel.
        //Notice the two widgets are not actually connected initially
        //to the UI.
        window.getChildren().addAll(viewer, p1,p2);
        Scene myScene = new Scene(window);
        stage.setScene(myScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void handle(ActionEvent t)
    {
        if(t.getSource().toString().contains("Mouse"))
        {
            //If the button contains the work MOUSE child panel1 to Viewer.
            //After clearing existing panels out.
            System.out.println("A");
            viewer.getChildren().clear();
            viewer.getChildren().add(panel1);
        }
        if(t.getSource().toString().contains("Animation"))
        {
            //If the button contains the work MOUSE child panel2 to Viewer.
            //After clearing existing panels out.
            System.out.println("B");
            viewer.getChildren().clear();
            viewer.getChildren().add(panel2);
        }
    }
}