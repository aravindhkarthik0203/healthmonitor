
package com.ak.healthmonitor;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;


public class EditAppointmentFormController implements Initializable{

    @FXML
    private TextField editApp_appointmentID;

    @FXML
    private TextField editApp_fullName;

    @FXML
    private ComboBox<String> editApp_gender;

    @FXML
    private TextField editApp_mobileNumber;

    @FXML
    private TextArea editApp_address;

    @FXML
    private Button editApp_updateBtn;

    @FXML
    private Button editApp_cancelBtn;

    @FXML
    private TextArea editApp_description;

    @FXML
    private TextField editApp_diagnosis;

    @FXML
    private TextField editApp_treatment;

    @FXML
    private ComboBox<String> editApp_doctor;

    @FXML
    private ComboBox<String> editApp_specialized;

    @FXML
    private ComboBox<String> editApp_status;

    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Statement statement;

    private AlertMessage alert = new AlertMessage();

    public void displayFields(){
        editApp_appointmentID.setText(Data.temp_appID);
        editApp_fullName.setText(Data.temp_appName);
        editApp_gender.getSelectionModel().select(Data.temp_appGender);
        editApp_mobileNumber.setText(Data.temp_appMobileNumber);
        editApp_address.setText(Data.temp_appAddress);
        editApp_description.setText(Data.temp_appDescription);
        editApp_diagnosis.setText(Data.temp_appDiagnosis);
        editApp_treatment.setText(Data.temp_appTreatment);
        editApp_doctor.getSelectionModel().select(Data.temp_appDoctor);
        editApp_specialized.getSelectionModel().select(Data.temp_appSpecialized);
        editApp_status.getSelectionModel().select(Data.temp_appStatus);
    }

    public void doctorList(){
        String sql = "SELECT * FROM doctor WHERE delete_date IS NULL";

        connect = Database.connectDB();

        try{
            assert connect != null;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            ObservableList listData = FXCollections.observableArrayList();
            while(result.next()){
                listData.add(result.getString("doctor_id"));
            }

            editApp_doctor.setItems(listData);
            specializedList();
        }catch(Exception e){e.printStackTrace();}
    }

public void specializedList() {
    List<String> specializationL = new ArrayList<>();

    for (String data : Data.specialization) {
        specializationL.add(data);
    }

    ObservableList listData = FXCollections.observableList(specializationL);
    editApp_specialized.setItems(listData);
}

    public void genderList() {
        List<String> genderL = new ArrayList<>();

        for (String data : Data.gender) {
            genderL.add(data);
        }

        ObservableList listData = FXCollections.observableList(genderL);
        editApp_gender.setItems(listData);
    }

    public void statusList() {
        List<String> statusL = new ArrayList<>();

        for (String data : Data.status) {
            statusL.add(data);
        }

        ObservableList listData = FXCollections.observableList(statusL);
        editApp_status.setItems(listData);
    }

    public void updateBtn() {
        connect = Database.connectDB();

        if (editApp_appointmentID.getText().isEmpty()
                || editApp_fullName.getText().isEmpty()
                || editApp_specialized.getSelectionModel().getSelectedItem() == null
                || editApp_gender.getSelectionModel().getSelectedItem() == null
                || editApp_mobileNumber.getText().isEmpty()
                || editApp_address.getText().isEmpty()
                || editApp_status.getSelectionModel().getSelectedItem() == null
                || editApp_doctor.getSelectionModel().getSelectedItem() == null
                || editApp_treatment.getText().isEmpty()
                || editApp_description.getText().isEmpty()
                || editApp_diagnosis.getText().isEmpty()) {
            alert.errorMessage("Please fill all blank fields");
        } else {
            Date date = new Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());

            String updateData;
            if (Data.path == null || "".equals(Data.path)) {
                updateData = "UPDATE appointment SET name = ?, specialized = ?, gender = ?, mobile_number = ?, doctor = ?, "
                        + "address = ?, description = ?, diagnosis = ?, treatment = ?, status = ?, date_modify = ? "
                        + "WHERE appointment_id = ?";
            } else {
                updateData = "UPDATE appointment SET name = ?, specialized = ?, gender = ?, mobile_number = ?, "
                        + "description = ?, diagnosis = ?, treatment = ?, address = ?, doctor = ?, status = ? "
                        + "WHERE appointment_id = ?";
            }

            try {
                if (alert.confirmationMessage("Are you sure you want to update Appointment ID: " + editApp_appointmentID.getText() + "?")) {
                    prepare = connect.prepareStatement(updateData);

                    prepare.setString(1, editApp_fullName.getText());
                    prepare.setString(2, editApp_specialized.getSelectionModel().getSelectedItem());
                    prepare.setString(3, editApp_gender.getSelectionModel().getSelectedItem());
                    prepare.setString(4, editApp_mobileNumber.getText());
                    prepare.setString(5, editApp_doctor.getSelectionModel().getSelectedItem());
                    prepare.setString(6, editApp_address.getText());
                    prepare.setString(7, editApp_description.getText());
                    prepare.setString(8, editApp_diagnosis.getText());
                    prepare.setString(9, editApp_treatment.getText());
                    prepare.setString(10, editApp_status.getSelectionModel().getSelectedItem());

                    if (Data.path == null || "".equals(Data.path)) {
                        prepare.setDate(11, sqlDate);
                        prepare.setString(12, editApp_appointmentID.getText());
                    } else {
                        prepare.setString(11, editApp_appointmentID.getText());
                    }

                    prepare.executeUpdate();
                    alert.successMessage("Appointment updated successfully.");
                } else {
                    alert.errorMessage("Cancelled.");
                }
            } catch (Exception e) {
                e.printStackTrace();
                alert.errorMessage("An error occurred while updating the appointment.");
            } finally {
                try {
                    if (prepare != null) prepare.close();
                    if (connect != null) connect.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        displayAppData();
    }

    public void displayAppData() {
        String sql = "SELECT * FROM appointment WHERE appointment_id = ?";
        connect = Database.connectDB();

        try {
            assert connect != null;
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, editApp_appointmentID.getText());
            result = prepare.executeQuery();

            if (result.next()) {
                editApp_fullName.setText(result.getString("name"));
                editApp_specialized.getSelectionModel().select(result.getString("specialized"));
                editApp_gender.getSelectionModel().select(result.getString("gender"));
                editApp_mobileNumber.setText(result.getString("mobile_number"));
                editApp_address.setText(result.getString("address"));
                editApp_status.getSelectionModel().select(result.getString("status"));
                editApp_doctor.getSelectionModel().select(result.getString("doctor"));
                editApp_treatment.setText(result.getString("treatment"));
                editApp_description.setText(result.getString("description"));
                editApp_diagnosis.setText(result.getString("diagnosis"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null) result.close();
                if (prepare != null) prepare.close();
                if (connect != null) connect.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void setField() {
        editApp_appointmentID.setText(Data.temp_appID);
        editApp_fullName.setText(Data.temp_appName);
        editApp_specialized.getSelectionModel().select(Data.temp_appSpecialized);
        editApp_gender.getSelectionModel().select(Data.temp_appGender);
        editApp_mobileNumber.setText(Data.temp_appMobileNumber);
        editApp_address.setText(Data.temp_appAddress);
        editApp_status.getSelectionModel().select(Data.temp_appStatus);
        editApp_diagnosis.setText(Data.temp_appDiagnosis);
        editApp_description.setText(Data.temp_appDescription);
        editApp_treatment.setText(Data.temp_appTreatment);
        editApp_doctor.getSelectionModel().select(Data.temp_appDoctor);

    }
    public void cancelBtn() {
        displayAppData();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        doctorList();
        genderList();
        statusList();
        specializedList();
        setField();
        cancelBtn();

        displayFields();
    }

}
