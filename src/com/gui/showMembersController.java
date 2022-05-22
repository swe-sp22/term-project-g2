package com.gui;

import com.jdbc.dao.EmployeeDao;
import com.jdbc.dao.MemberDaoImplementation;
import com.jdbc.dao.MembershipTypeDao;
import com.jdbc.model.Member;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;

public class showMembersController implements IControlledScreen {
    @FXML
    private TableView memberTable;
    @FXML
    private TableColumn MID;
    @FXML
    private TableColumn name;
    @FXML
    private TableColumn pon;
    @FXML
    private TableColumn dob;
    @FXML
    private TableColumn MT;
    @FXML
    private TableColumn TID;
    @FXML
    private Button deleteButton;
    ScreensController mycontroller;

    @FXML
    private void initialize() throws SQLException {
        MemberDaoImplementation memberdao = new MemberDaoImplementation();
        ObservableList<Member> memberList = FXCollections.observableList(memberdao.getMembers());

        MID.setCellValueFactory(new PropertyValueFactory<>("MID"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        pon.setCellValueFactory(new PropertyValueFactory<>("phone_no"));
        dob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        MT.setCellValueFactory(new PropertyValueFactory<>("MSID"));
        TID.setCellValueFactory(new PropertyValueFactory<>("EID"));
        memberTable.setItems(memberList);
    }

    public void setScreenParent(ScreensController screensController) {
        mycontroller = screensController;
    }

    public void gotoMainScreen(ActionEvent actionEvent) {
        mycontroller.setScreen(Main.mainScreenName);
    }

    public void deleteMember(ActionEvent actionEvent) throws SQLException {
        Member member = (Member) memberTable.getSelectionModel().getSelectedItem();
        MemberDaoImplementation memberdao = new MemberDaoImplementation();
        memberdao.delete(member.getMID());
        System.out.println(member.getName() + "--> Deleted");
    }
}
