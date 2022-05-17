package com.gui;

import javafx.event.ActionEvent;

public class showMembersController implements IControlledScreen {
    ScreensController mycontroller;

    public void setScreenParent(ScreensController screensController) {
        mycontroller = screensController;
    }

    public void gotoMainScreen(ActionEvent actionEvent) {
        mycontroller.setScreen(Main.mainScreenName);
    }
}
