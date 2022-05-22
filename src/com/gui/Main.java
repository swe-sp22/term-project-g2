package com.gui;

import com.jdbc.dao.MemberDaoImplementation;
import com.jdbc.util.DatabaseConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;

public class Main extends Application {
    public static String loginScreenName = "loginScreen";
    public static String loginScreenFile = "login.fxml";
    public static String mainScreenName = "mainScreen";
    public static String mainScreenFile = "mainScreen.fxml";
    public static String addMemberScreenName = "addMemberScreen";
    public static String addMemberScreenFile = "addMember.fxml";
    public static String showMembersScreenName = "showMembersScreen";
    public static String showMembersScreenFile = "showMembers.fxml";
    public static String addEmployeeScreenName = "AddEmployee";
    public static String addEmployeeScreenFile = "AddEmployee.fxml";
    public static String editMemberScreenName = "editMember";
    public static String editMemberScreenFile = "editMember.fxml";
    public static String showEmployeeScreenName = "showEmployee";
    public static String showEmployeeScreenFile = "showEmployee.fxml";
    public static String editEmployeeScreenName = "editEmployee";
    public static String editEmployeeScreenFile = "editEmployee.fxml";

    @Override
    public void start(Stage primaryStage) throws Exception {
        ScreensController mainContainer = new ScreensController();
        mainContainer.loadScreen(Main.loginScreenName,Main.loginScreenFile);
        mainContainer.loadScreen(Main.mainScreenName,Main.mainScreenFile);
        mainContainer.loadScreen(Main.addMemberScreenName,Main.addMemberScreenFile);
        mainContainer.loadScreen(Main.showMembersScreenName,Main.showMembersScreenFile);
        mainContainer.loadScreen(Main.addEmployeeScreenName,Main.addEmployeeScreenFile);
        mainContainer.loadScreen(Main.editMemberScreenName,Main.editMemberScreenFile);
        mainContainer.loadScreen(Main.showEmployeeScreenName,Main.showEmployeeScreenFile);
        mainContainer.loadScreen(Main.editEmployeeScreenName,Main.editEmployeeScreenFile);

        mainContainer.setScreen(Main.loginScreenName);

        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root, 1920,1080);
        primaryStage.setTitle("Gym Management System");
        primaryStage.setMaximized(true);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) { launch(args);}
}