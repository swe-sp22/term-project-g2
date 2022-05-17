package com.gui;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.util.HashMap;

public class ScreensController extends StackPane {
    private HashMap<String, Node> screens = new HashMap<>();

    public ScreensController(){
        super();
    }
    //add the screen to the collection
    public void addScreen(String name, Node screen){
        screens.put(name, screen);
    }
    //returns the node with the appropriate name
    public Node getScreen(String name){
        return screens.get(name);
    }
    public boolean loadScreen(String name, String resource){
        try{
            FXMLLoader myloader = new FXMLLoader(getClass().getResource(resource));
            Parent loadScreen = (Parent) myloader.load();
            IControlledScreen myScreenController = ((IControlledScreen) myloader.getController());
            myScreenController.setScreenParent(this);
            addScreen(name, loadScreen);
            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean setScreen(final String name){
        if (screens.get(name)!=null){
            final DoubleProperty opacity = opacityProperty();
            if(!getChildren().isEmpty()){  //if there is more than one screen
                Timeline fade = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
                        new KeyFrame(new Duration(150), new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                getChildren().remove(0);  //remove the displayed screen
                                getChildren().add(0,screens.get(name));  //add the new screen
                                Timeline fadeIn = new Timeline(
                                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                                        new KeyFrame(new Duration(100), new KeyValue(opacity, 1.0))
                                );
                                fadeIn.play();
                            }
                        }, new KeyValue(opacity,0.0) ));
                fade.play();

            }else{
                setOpacity(0.0);
                getChildren().add(screens.get(name));
                Timeline fadeIn = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                        new KeyFrame(new Duration(150), new KeyValue(opacity, 1.0))
                );
                fadeIn.play();
            }
            return true;
        }else{
            System.out.println("Screen Has not been loaded !!! \n");
            return false;
        }

    }

    public boolean unloadScreen(String name){
        if(screens.remove(name)== null){
            System.out.println("Screen does not Exist !");
            return false;
        }else{
            return true;
        }

    }
}
