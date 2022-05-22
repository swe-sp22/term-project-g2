package com.gui;

import com.jdbc.dao.EmployeeDao;
import com.jdbc.dao.MemberDaoImplementation;
import com.jdbc.dao.MembershipTypeDao;
import com.jdbc.model.Employee;
import com.jdbc.model.Member;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class addMemberController implements IControlledScreen {
    @FXML
    private TextField addMemberName;
    @FXML
    private TextField addMemberPhone;
    @FXML
    private DatePicker addMemberDOB;
    @FXML
    private ComboBox MembershipType;
    @FXML
    private ComboBox EmployeeName;
    @FXML
    private Label Success;
    @FXML
    private Label Error;

    @FXML
    private void initialize() throws SQLException {
        EmployeeDao employeeDao = new EmployeeDao();
        MembershipTypeDao membershiptypedao = new MembershipTypeDao();

        ObservableList<String> employeeList = FXCollections.observableList(employeeDao.getAllEmployeesNames());
        EmployeeName.setItems(employeeList);

        ObservableList<String> mtList = FXCollections.observableList(membershiptypedao.getAllMembershipTypes());
        MembershipType.setItems(mtList);

    }

    ScreensController mycontroller;

    public void setScreenParent(ScreensController screenParent){
        mycontroller = screenParent;
    }

    public void addMemberToDB(ActionEvent actionEvent) throws SQLException {
        System.out.println("added");
        //TODO: Add logic
        EmployeeDao employeeDao = new EmployeeDao();
        MembershipTypeDao membershiptypedao = new MembershipTypeDao();
        MemberDaoImplementation memberdao = new MemberDaoImplementation();

        int EID = employeeDao.getEmployeeId(EmployeeName.getValue().toString());
        int MTID = membershiptypedao.getMembershipTypeId(MembershipType.getValue().toString());
        Member newMember = new Member(addMemberName.getText(), addMemberPhone.getText(),addMemberDOB.getValue(), MTID, EID);

        int value = memberdao.add(newMember);
        mycontroller.unloadScreen(Main.showMembersScreenName);
        mycontroller.loadScreen(Main.showMembersScreenName, Main.showMembersScreenFile);
        System.out.println(value);
        if (value == 1){
            Success.setVisible(true);

        }else {
            Error.setVisible(true);
        }
    }

    public void gotoMainScreen(ActionEvent actionEvent) {
        mycontroller.setScreen(Main.mainScreenName);
    }
}
