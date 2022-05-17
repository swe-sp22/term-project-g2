package com.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.awt.*;

public class mainScreenController implements IControlledScreen {

    ScreensController mycontroller;


    public void setScreenParent(ScreensController screenParent){
        mycontroller = screenParent;
    }

    @FXML
    private void gotoLoginScreen(javafx.event.ActionEvent actionEvent){
        mycontroller.setScreen(Main.loginScreenName);
    }

    @FXML
    public void gotoAddMemberScreen(javafx.event.ActionEvent actionEvent) {
        mycontroller.setScreen(Main.addMemberScreenName);
    }

    public void gotoShowMembers(ActionEvent actionEvent) {
       mycontroller.setScreen(Main.showMembersScreenName);
    }
}
