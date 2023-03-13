package com.example.morefx;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

//Three event types to look out for...
//Action Event
//Mouse Event
//Key Event
public class mouseFollow extends Pane implements EventHandler<MouseEvent>
{
    //The circle we will use to track the mouse.
    private Circle c;
    //The frame for our area of interest.
    private Rectangle r;
    private Pane Interact;
    public mouseFollow()
    {
        //Set the preferred size of our widget.
        //The interactable pane will be 250, by 250.
        Interact = new Pane();
        Interact.setPrefSize(250,250);
        Interact.setMaxHeight(250);
        Interact.setMaxWidth(250);
        //Our widgets pane will be 270 x 270 to allow for a border.
        this.setPrefHeight(270);
        this.setPrefHeight(270);
        //The interact pane will be placed at 10,10.
        Interact.setLayoutX(10);
        Interact.setLayoutY(10);
        //Create the circle and place it in the center.
        //This will be the pane that the circle will interact with.
        //Create Frame.
        r = new Rectangle();
        r.setLayoutX(5);
        r.setLayoutY(5);
        r.setWidth(260);
        r.setHeight(260);
        r.setStrokeWidth((10));
        r.setFill((Color.TRANSPARENT));
        r.setStroke(Color.BLACK);
        //this.getChildren().add(r);

        c = new Circle();
        c.setRadius(50);
        c.setCenterX(125);
        c.setCenterY(125);

        //Add The cricle to our Pane.
        Interact.getChildren().add(c);
        //It is very importat I add INTERACT LAST.
        //Otherwise, the frame will block the mouse inputs.
        //I could also use r.setMouseTransparent(true); in situations where the rectanlge
        //had to be added after the circle.
        this.getChildren().add(Interact);

        //Set mouse callbacks for this widget.
        //Notice that Interact will trigger the events.
        //HOWEVER, this (our widget) will handle the events.
        this.Interact.setOnMouseClicked(this);
        this.Interact.setOnMouseMoved(this);

    }


    @Override
    public void handle(MouseEvent t) {
        System.out.println("The source is "+t.getSource());
        System.out.println("The event is "+t.getEventType());
        if(t.getEventType() == MouseEvent.MOUSE_MOVED)
        {
            c.setCenterX(t.getX());
            c.setCenterY(t.getY());
        }
        if(t.getEventType() == MouseEvent.MOUSE_CLICKED)
        {
            c.setFill(Color.BLUE);
        }
    }

}

