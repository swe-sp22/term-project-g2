package com.gui;

import javafx.event.ActionEvent;

public class addMemberController implements IControlledScreen {

    ScreensController mycontroller;

    public void setScreenParent(ScreensController screenParent){
        mycontroller = screenParent;
    }

    public void addMemberToDB(ActionEvent actionEvent) {
    }

    public void gotoMainScreen(ActionEvent actionEvent) {
        mycontroller.setScreen(Main.mainScreenName);
    }
}
