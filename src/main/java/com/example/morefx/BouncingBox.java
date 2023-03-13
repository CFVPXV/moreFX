package com.example.morefx;

import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

//FlowPane viewer can be created within the FlowPane as well, namely for the play, pause and stop buttons
public class BouncingBox extends FlowPane implements EventHandler<ActionEvent>
{
    private Rectangle r;
    private Rectangle frame;
    private PathTransition p;
    private Pane viewer;
    public BouncingBox()
    {
        //Initialize the viewing pane.
        //Remember this object is a FLow Plane
        viewer = new Pane();
        //Initialize the rectangle for the frame of the viewing pane.
        frame = new Rectangle();
        frame.setWidth(200);
        frame.setHeight(200);
        frame.setFill(Color.TRANSPARENT);
        frame.setStroke(Color.BLACK);
        frame.setStrokeWidth(2);
        //Add frame to viewing pane.
        viewer.getChildren().add(frame);

        //Create the square that we are going to animate.
        r= new Rectangle();
        r.setWidth(10);
        r.setHeight(10);
        r.setLayoutX(20);
        r.setLayoutY(20);
        //Add that to the viewing pane.
        viewer.getChildren().add(r);
        this.getChildren().add(viewer);

        //Create a play button add it to "this" which is the
        //flow pane.
        //This makes it a sibling to the viewing pane.
        Button play = new Button();
        play.setText("Play");
        play.setLayoutX(150);
        play.setOnAction(this);
        this.getChildren().add(play);

        //Create "Stop" button.
        Button stop = new Button();
        stop.setText("Stop");
        stop.setLayoutX(150);
        stop.setLayoutY(40);
        stop.setOnAction(this);
        this.getChildren().add(stop);

        //Create "Pause" button.
        Button pause = new Button();
        pause.setText("Pause");
        pause.setLayoutX(150);
        pause.setLayoutY(80);
        pause.setOnAction(this);
        this.getChildren().add(pause);

        //Set desired width/height of the flow pane (our own widget)
        this.setWidth(200);
        this.setHeight(200);
        this.setPrefHeight(250);
        this.setPrefWidth(210);
        //Create path animation.
        p = new PathTransition(Duration.millis(20000),
                new Line(0,0,170,170),r
        );
        //Allow path to automatically reverse when it gets to the end.
        p.setAutoReverse(true);
        //Play animation twice (once forward, once back)
        p.setCycleCount(2);
        //set animation speed.
        p.setRate(2);
        //p.jumpTo(Duration.seconds(10));
    }

    @Override
    public void handle(ActionEvent t)
    {
        //Probably the easiest way to check the buttons label.
        if(t.getSource().toString().contains("Play"))
        {
            p.play();
        }
        if(t.getSource().toString().contains("Stop"))
        {
            p.stop();
        }
        if(t.getSource().toString().contains("Pause"))
        {
            p.pause();
        }

    }
}