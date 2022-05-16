package com.gui;

import javafx.fxml.FXML;

public class mainScreenController implements IControlledScreen {

    ScreensController mycontroller;

    public void setScreenParent(ScreensController screenParent){
        mycontroller = screenParent;
    }

    @FXML
    private void gotoLoginScreen(javafx.event.ActionEvent actionEvent){
        mycontroller.setScreen(Main.loginScreenName);
    }
}
