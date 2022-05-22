package com.gui;

import com.jdbc.dao.MemberDaoImplementation;
import com.jdbc.model.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class editMember implements IControlledScreen {
    @FXML
    private TextField searchText;
    @FXML
    private TextField nameField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField MTField;
    @FXML
    private TextField EID;
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
    private Member member = null;

    public void setScreenParent(ScreensController screenParent){
        mycontroller = screenParent;
    }
    public void gotoMainScreen(ActionEvent actionEvent) {
        mycontroller.setScreen(Main.mainScreenName);
    }

    @FXML
    public void searchMember(ActionEvent actionEvent) throws SQLException {
        MemberDaoImplementation memberDao = new MemberDaoImplementation();
        member = memberDao.getMember(Integer.parseInt(searchText.getText()));
        if( member == null){
            //Member NOT FOUND
            MIDnotfound.setVisible(true);

            EditLabel.setVisible(false);
            nameField.setVisible(false);
            phoneField.setVisible(false);
            MTField.setVisible(false);
            EID.setVisible(false);
            date.setVisible(false);
            saveMember.setVisible(false);
            savedsuccess.setVisible(false);
            saveerror.setVisible(false);
            emptyerror.setVisible(false);
        }else{
            MIDnotfound.setVisible(false);
            EditLabel.setVisible(true);
            nameField.setVisible(true);
            nameField.setText(member.getName());
            phoneField.setVisible(true);
            phoneField.setText(member.getPhone_no());
            MTField.setVisible(true);
            MTField.setText(Integer.toString(member.getMSID()));
            EID.setVisible(true);
            EID.setText(Integer.toString(member.getEID()));
            date.setVisible(true);
            date.setValue(member.getDob());
            saveMember.setVisible(true);
            savedsuccess.setVisible(false);
            saveerror.setVisible(false);
            emptyerror.setVisible(false);
        }

    }

    @FXML
    public void saveMember(ActionEvent actionEvent) throws SQLException {
        MemberDaoImplementation memberDao = new MemberDaoImplementation();
        try {
            member.setName(nameField.getText());
            member.setPhone_no(phoneField.getText());
            member.setDob(date.getValue());
            member.setMSID(Integer.parseInt(MTField.getText()));
            member.setEID(Integer.parseInt(EID.getText()));
        }catch (NumberFormatException e){
            savedsuccess.setVisible(false);
            saveerror.setVisible(false);
            emptyerror.setVisible(true);
        }

        try {
            int f = memberDao.update(member);
            if(f == 1){
                //Saved Successfully
                emptyerror.setVisible(false);
                saveerror.setVisible(false);
                savedsuccess.setVisible(true);
                mycontroller.unloadScreen(Main.showMembersScreenName);
                mycontroller.loadScreen(Main.showMembersScreenName, Main.showMembersScreenFile);

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

