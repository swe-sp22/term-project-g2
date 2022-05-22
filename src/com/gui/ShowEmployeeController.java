package com.gui;

import com.jdbc.dao.EmployeeDao;
import com.jdbc.dao.MemberDaoImplementation;
import com.jdbc.model.Employee;
import com.jdbc.model.Member;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ShowEmployeeController implements IControlledScreen, Initializable {

    @FXML
    private TableColumn<Employee, Integer> EID;

    @FXML
    private TableColumn<Employee, String> address;

    @FXML
    private TableColumn<Employee, LocalDate> dob;

    @FXML
    private TableView<Employee> employees;

    @FXML
    private TableColumn<Employee, String> name;

    @FXML
    private TableColumn<Employee, String> role;

    @FXML
    private TableColumn<Employee, String> salary;

    @FXML
    private TableColumn<Employee, String> phone_no;
    @FXML
    private Button deleteButton;

    ScreensController mycontroller;



    public void setScreenParent(ScreensController screenParent){
        mycontroller = screenParent;
    };
    public void gotoMainScreen(ActionEvent actionEvent) {
        mycontroller.setScreen(Main.mainScreenName);
    }

    public void initialize(URL location, ResourceBundle resources) {
        display();
    }

    public void display(){
        // TODO: Fixes the need to restart the program on employee update
        // The problem is that all the scenes are loaded only at the beginnening of the program

        EmployeeDao employeeDao = new EmployeeDao();
        EID.setCellValueFactory(new PropertyValueFactory<>("EID"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        phone_no.setCellValueFactory(new PropertyValueFactory<>("phone_no"));
        role.setCellValueFactory(new PropertyValueFactory<>("role"));
        salary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        dob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        ObservableList<Employee> employeeObservableList= null;
        try {
            employeeObservableList = FXCollections.observableArrayList(employeeDao.getAllEmployees());
        } catch (SQLException e) {
            System.out.println("eih ely7asa;");
        }
        System.out.println(employeeObservableList);
        System.out.println("here");
        employees.setItems(employeeObservableList);
    }

    public void deleteEmployee(ActionEvent actionEvent) throws SQLException {
        Employee employee = (Employee) employees.getSelectionModel().getSelectedItem();
        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.delete(employee.getEID());
        System.out.println(employee.getName() + "--> Deleted");
    }

}
