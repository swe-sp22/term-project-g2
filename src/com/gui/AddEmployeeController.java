package com.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AddEmployeeController implements IControlledScreen {
    ScreensController mycontroller;

    public void setScreenParent(ScreensController screenParent){
        mycontroller = screenParent;
    }

    public void addEmployeeToDb(ActionEvent actionEvent){

    }
    @FXML
    public void gotoMainScreen(ActionEvent actionEvent) {
        mycontroller.setScreen(Main.mainScreenName);
    }
}
