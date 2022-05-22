package com.gui;

import com.jdbc.dao.EmployeeDao;
import com.jdbc.dao.MemberDaoImplementation;
import com.jdbc.model.Employee;
import com.jdbc.model.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class editEmployee implements IControlledScreen {
    @FXML
    private TextField searchText;
    @FXML
    private TextField nameField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField Role;
    @FXML
    private TextField Salary;
    @FXML
    private TextField addressField;
    @FXML
    private DatePicker date;
    @FXML
    private Label MIDnotfound;
    @FXML
    private Button saveMember;
    @FXML
    private Label EditLabel;
    @FXML
    private Label saveerror;
    @FXML
    private Label savedsuccess;
    @FXML
    private Label emptyerror;


    ScreensController mycontroller;
    private Employee employee = null;

    public void setScreenParent(ScreensController screenParent){
        mycontroller = screenParent;
    }
    public void gotoMainScreen(ActionEvent actionEvent) {
        mycontroller.setScreen(Main.mainScreenName);
    }

    @FXML
    public void searchMember(ActionEvent actionEvent) throws SQLException {
        EmployeeDao employeedao = new EmployeeDao();
        employee = employeedao.getEmployee(Integer.parseInt(searchText.getText()));
        if( employee == null){
            //Member NOT FOUND
            MIDnotfound.setVisible(true);

            EditLabel.setVisible(false);
            nameField.setVisible(false);
            addressField.setVisible(false);
            phoneField.setVisible(false);
            Role.setVisible(false);
            Salary.setVisible(false);
            date.setVisible(false);
            saveMember.setVisible(false);
            savedsuccess.setVisible(false);
            saveerror.setVisible(false);
            emptyerror.setVisible(false);
        }else{
            MIDnotfound.setVisible(false);
            EditLabel.setVisible(true);
            nameField.setVisible(true);
            nameField.setText(employee.getName());
            addressField.setVisible(true);
            addressField.setText(employee.getAddress());
            phoneField.setVisible(true);
            phoneField.setText(employee.getPhone_no());
            Role.setVisible(true);
            Role.setText(employee.getRole());
            Salary.setVisible(true);
            Salary.setText(employee.getSalary());
            date.setVisible(true);
            date.setValue(employee.getDob());
            saveMember.setVisible(true);
            savedsuccess.setVisible(false);
            saveerror.setVisible(false);
            emptyerror.setVisible(false);
        }

    }

    @FXML
    public void saveMember(ActionEvent actionEvent) throws SQLException {
        EmployeeDao employeedao = new EmployeeDao();
        try {
            employee.setName(nameField.getText());
            employee.setAddress(addressField.getText());
            employee.setPhone_no(phoneField.getText());
            employee.setDob(date.getValue());
            employee.setRole(Role.getText());
            employee.setSalary(Salary.getText());
        }catch (NumberFormatException e){
            savedsuccess.setVisible(false);
            saveerror.setVisible(false);
            emptyerror.setVisible(true);
        }

        try {
            int f = employeedao.update(employee);
            if(f == 1){
                //Saved Successfully
                emptyerror.setVisible(false);
                saveerror.setVisible(false);
                savedsuccess.setVisible(true);
                mycontroller.unloadScreen(Main.showEmployeeScreenName);
                mycontroller.loadScreen(Main.showEmployeeScreenName, Main.showEmployeeScreenFile);

            }
        }catch (SQLIntegrityConstraintViolationException e) {
            emptyerror.setVisible(false);
            savedsuccess.setVisible(false);
            saveerror.setVisible(true);
        }catch (NullPointerException e){
            savedsuccess.setVisible(false);
            saveerror.setVisible(false);
            emptyerror.setVisible(true);
        }

    }
}

