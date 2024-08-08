
package com.ak.healthmonitor;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;


public class PatientMainFormController implements Initializable {

    @FXML
    private TableColumn<MonthNutritionData, String> NT_MNT_col_bmi;

    @FXML
    private TableColumn<MonthNutritionData, String> NT_MNT_col_bpressure;

    @FXML
    private TableColumn<MonthNutritionData, String > NT_MNT_col_breakfast;

    @FXML
    private TableColumn<MonthNutritionData, String> NT_WNT_col_action;

    @FXML
    private TableColumn<MonthNutritionData, String> NT_MNT_col_bweight;

    @FXML
    private TableColumn<MonthNutritionData, String> NT_MNT_col_dinner;

    @FXML
    private TableColumn<MonthNutritionData, String> NT_MNT_col_heartrate;

    @FXML
    private TableColumn<MonthNutritionData, String> NT_MNT_col_lunch;

    @FXML
    private TableColumn<MonthNutritionData, String> NT_MNT_col_note;

    @FXML
    private TableColumn<MonthNutritionData, String> NT_MNT_col_snack1;

    @FXML
    private TableColumn<MonthNutritionData, String> NT_MNT_col_snack2;

    @FXML
    private TableColumn<MonthNutritionData, String> NT_MNT_col_week;

    @FXML
    private TableColumn<MonthNutritionData, String > NT_WNT_col_bmi;

    @FXML
    private TableColumn<WeekNutritionData, String> NT_WNT_col_bpressure;

    @FXML
    private TableColumn<WeekNutritionData, String> NT_WNT_col_breakfast;

    @FXML
    private TableColumn<WeekNutritionData, String> NT_WNT_col_bweight;

    @FXML
    private TableColumn<WeekNutritionData, String> NT_WNT_col_day;

    @FXML
    private TableColumn<WeekNutritionData, String> NT_WNT_col_dinner;

    @FXML
    private TableColumn<WeekNutritionData, String> NT_WNT_col_heartrate;

    @FXML
    private TableColumn<WeekNutritionData, String> NT_WNT_col_lunch;

    @FXML
    private TableColumn<WeekNutritionData, String> NT_WNT_col_note;

    @FXML
    private TableColumn<WeekNutritionData, String> NT_WNT_col_snack1;

    @FXML
    private TableColumn<WeekNutritionData, String> NT_WNT_col_snack2;

    @FXML
    private TableView<WeekNutritionData> NTweek_table_view;

    @FXML
    private TableView<MonthNutritionData> NTmonth_table_view;

    @FXML
    private Button NTmonth_btn;

    @FXML
    private AnchorPane NTmonth_table;

    @FXML
    private Button NTweek_btn;

    @FXML
    private AnchorPane NTweek_table;

    @FXML
    private Label HIT_Pbmi;

    @FXML
    private Label HIT_Pbmi_recom;

    @FXML
    private Label HIT_Pbpresure;

    @FXML
    private Label HIT_Pbpresure_recomm;

    @FXML
    private Label HIT_Pbweight;

    @FXML
    private Label HIT_Pbweight_recomm;

    @FXML
    private Label HIT_Pgender;

    @FXML
    private Label HIT_Pheartrate;

    @FXML
    private Label HIT_Pheartrate_recomm;

    @FXML
    private Label HIT_Pname;

    @FXML
    private AnchorPane main_form;

    @FXML
    private TextField HT_ECI_Gurdianname;

    @FXML
    private Button HT_ECI_UpdateBtn;

    @FXML
    private TextArea HT_ECI_address;

    @FXML
    private ComboBox<String> HT_ECI_gender;

    @FXML
    private TextField HT_ECI_mobileNumber;

    @FXML
    private TextField HT_ECI_patientID;


    @FXML
    private Circle top_profile;

    @FXML
    private TextField bpmField;

    @FXML
    private Button bpm_btn;

    @FXML
    private LineChart<?, ?> HMT_chart;

    @FXML
    private TableView<PatientsData> HT_patientHRM_tableView;
    @FXML
    private TableColumn<?, ?> HT_patientHRM_col_dateIn;

    @FXML
    private TableColumn<?, ?> HT_patientHRM_col_description;

    @FXML
    private TableColumn<?, ?> HT_patientHRM_col_diagnosis;

    @FXML
    private TableColumn<?, ?> HT_patientHRM_col_treatment;


//    @FXML
//    private AreaChart<?, ?> HMT_chart;

//    @FXML
//    private LineChart<?, ?> HMT_chart;

//    @FXML
//    private LineChart<Number, Number> heartRateChart;
//
//    private XYChart.Series<Number, Number> series;

//    @FXML
//    private NumberAxis heartRate_Xaxis;
//    @FXML
//    private NumberAxis heartRate_Yaxis;

    @FXML
    private Button health_ECI_btn;

    @FXML
    private AnchorPane health_ECI_form;

    @FXML
    private Button health_FIT_btn;

    @FXML
    private AnchorPane health_FIT_form;

    @FXML
    private Button health_GT_btn;

    @FXML
    private AnchorPane health_GT_form;

    @FXML
    private Button health_HIT_btn;

    @FXML
    private AnchorPane health_HIT_form;

    @FXML
    private Button health_HM_btn;

    @FXML
    private AnchorPane health_HM_form;

    @FXML
    private Button health_HRM_btn;

    @FXML
    private AnchorPane health_HRM_form;

    @FXML
    private Button health_MT_btn;

    @FXML
    private AnchorPane health_MT_form;

    @FXML
    private Button health_NT_btn;

    @FXML
    private AnchorPane health_NT_form;

    @FXML
    private Button health_btn;

    @FXML
    private AnchorPane healthtracking_form;

    @FXML
    private Label top_username;

    @FXML
    private Label date_time;

    @FXML
    private Label current_form;

    @FXML
    private Button logout_btn;

    @FXML
    private Label nav_adminID;

    @FXML
    private Button dashboard_btn;

    @FXML
    private Button doctors_btn;

    @FXML
    private Button appointments_btn;

    @FXML
    private Button profile_btn;

    @FXML
    private AnchorPane home_form;

    @FXML
    private TableView<PatientsData> home_patient_tableView;

    @FXML
    private TableColumn<PatientsData, String> home_patient_col_description;

    @FXML
    private TableColumn<PatientsData, String> home_patient_col_diagnosis;

    @FXML
    private TableColumn<PatientsData, String> home_patient_col_treatment;

    @FXML
    private TableColumn<PatientsData, String> home_patient_col_dateIn;

    @FXML
    private TableColumn<PatientsData, String> home_patient_col_dateDischarge;

    @FXML
    private Circle home_doctor_circle;

    @FXML
    private Label home_doctor_name;

    @FXML
    private Label home_doctor_specialization;

    @FXML
    private Label home_doctor_email;

    @FXML
    private Label home_doctor_mobileNumber;

    @FXML
    private TableView<AppointmentData> home_appointment_tableView;

    @FXML
    private TableColumn<AppointmentData, String> home_appointment_col_appointmenID;

    @FXML
    private TableColumn<AppointmentData, String> home_appointment_col_description;

    @FXML
    private TableColumn<AppointmentData, String> home_appointment_col_diagnosis;

    @FXML
    private TableColumn<AppointmentData, String> home_appointment_col_treatment;

    @FXML
    private TableColumn<AppointmentData, String> home_appointment_col_doctor;

    @FXML
    private TableColumn<AppointmentData, String> home_appointment_col_schedule;

    @FXML
    private AnchorPane doctors_form;

    @FXML
    private ScrollPane doctors_scrollPane;

    @FXML
    private GridPane doctors_gridPane;

    @FXML
    private AnchorPane appointments_form;

    @FXML
    private Label appointment_ad_name;

    @FXML
    private Label appointment_ad_mobileNumber;

    @FXML
    private Label appointment_ad_gender;

    @FXML
    private Label appointment_ad_address;

    @FXML
    private Label appointment_ad_description;

    @FXML
    private Label appointment_ad_doctorName;

    @FXML
    private Label appointment_ad_specialization;

    @FXML
    private Label appointment_ad_schedule;

    @FXML
    private Button appointment_d_confirmBtn;

    @FXML
    private TextArea appointment_d_description;

    @FXML
    private ComboBox<String> appointment_d_doctor;

    @FXML
    private DatePicker appointment_d_schedule;

    @FXML
    private Button appointment_d_clearBtn;

    @FXML
    private AnchorPane profile_form;

    @FXML
    private Circle profile_circle;

    @FXML
    private Button profile_importBtn;

    @FXML
    private Label profile_label_patientID;

    @FXML
    private Label profile_label_name;

    @FXML
    private Label profile_label_mobileNumber;

    @FXML
    private Label profile_label_dateCreated;

    @FXML
    private TextField profile_patientID;

    @FXML
    private TextField profile_name;

    @FXML
    private TextField profile_mobileNumber;

    @FXML
    private ComboBox<String> profile_status;

    @FXML
    private Button profile_updateBtn;

    @FXML
    private TextField profile_password;

    @FXML
    private TextArea profile_address;

    private AlertMessage alert = new AlertMessage();

    private Image image;

    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Statement statement;

    public ObservableList<PatientsData> homePatientGetData() {

        ObservableList<PatientsData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM patient WHERE date_delete IS NULL AND patient_id = " + Data.patient_id;
        connect = Database.connectDB();

        try {
            assert connect != null;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            PatientsData pData;
            while (result.next()) {
//                PatientsData(Integer id, Integer patientID, String description
//            , String diagnosis, String treatment, Date date)
                pData = new PatientsData(result.getInt("id"),
                        result.getInt("patient_id"),
                        result.getString("description"),
                        result.getString("diagnosis"),
                        result.getString("treatment"), result.getDate("date"));

                listData.add(pData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    public ObservableList<PatientsData> homePatientListData;

    public void homePatientDisplayData() {
        homePatientListData = homePatientGetData();

        home_patient_col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        home_patient_col_diagnosis.setCellValueFactory(new PropertyValueFactory<>("diagnosis"));
        home_patient_col_treatment.setCellValueFactory(new PropertyValueFactory<>("treatment"));
        home_patient_col_dateIn.setCellValueFactory(new PropertyValueFactory<>("date"));

        home_patient_tableView.setItems(homePatientListData);
    }

    public ObservableList<AppointmentData> homeAppointmentGetData() {

        ObservableList<AppointmentData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM appointment WHERE date_delete IS NULL AND patient_id = "
                + Data.patient_id;

        connect = Database.connectDB();

        try {
            assert connect != null;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            AppointmentData aData;
            while (result.next()) {
//                AppointmentData(Integer appointmentID, String description,
//            String diagnosis, String treatment, String doctorID, Date schedule)
                aData = new AppointmentData(result.getInt("appointment_id"),
                        result.getString("description"),
                        result.getString("diagnosis"), result.getString("treatment"),
                        result.getString("doctor"), result.getDate("schedule"));

                listData.add(aData);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    public ObservableList<AppointmentData> homeAppointmentListData;

    public void homeAppointmentDisplayData() {
        homeAppointmentListData = homeAppointmentGetData();

        home_appointment_col_appointmenID.setCellValueFactory(new PropertyValueFactory<>("appointmentID"));
        home_appointment_col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        home_appointment_col_diagnosis.setCellValueFactory(new PropertyValueFactory<>("diagnosis"));
        home_appointment_col_treatment.setCellValueFactory(new PropertyValueFactory<>("treatment"));
        home_appointment_col_doctor.setCellValueFactory(new PropertyValueFactory<>("doctor"));
        home_appointment_col_schedule.setCellValueFactory(new PropertyValueFactory<>("schedule"));
        home_appointment_tableView.setItems(homeAppointmentListData);
    }

    public void homeDoctorInfoDisplay() {

        String sql = "SELECT * FROM patient WHERE patient_id = " + Data.patient_id;

        connect = Database.connectDB();

        String tempDoctorID = "";
        try {
            assert connect != null;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                tempDoctorID = result.getString("doctor");
            }

            String checkDoctor = "SELECT * FROM doctor WHERE doctor_id = '"
                    + tempDoctorID + "'";

            statement = connect.createStatement();
            result = statement.executeQuery(checkDoctor);

            if (result.next()) {
                home_doctor_name.setText(result.getString("full_name"));
                home_doctor_specialization.setText(result.getString("specialized"));
                home_doctor_email.setText(result.getString("email"));
                home_doctor_mobileNumber.setText(result.getString("mobile_number"));

                String path = result.getString("image");

                if (path != null) {
                    path = path.replace("\\", "\\\\");

                    image = new Image("File:" + path, 138, 82, false, true);
                    home_doctor_circle.setFill(new ImagePattern(image));
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private final ObservableList<DoctorData> doctorList = FXCollections.observableArrayList();

    public ObservableList<DoctorData> doctorGetData() {

        String sql = "SELECT * FROM doctor WHERE status = 'Active'";

        connect = Database.connectDB();

        ObservableList<DoctorData> listData = FXCollections.observableArrayList();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            DoctorData dData;

            while (result.next()) {
//                DoctorData(Integer id, String doctorID, String fullName, String specialized, String email)
                dData = new DoctorData(result.getInt("id"),
                        result.getString("doctor_id"),
                        result.getString("full_name"),
                        result.getString("specialized"),
                        result.getString("email"),
                        result.getString("image"));

                listData.add(dData);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    public void doctorShowCard() {
        doctorList.clear();
        doctorList.addAll(doctorGetData());

        doctors_gridPane.getChildren().clear();
        doctors_gridPane.getColumnConstraints().clear();
        doctors_gridPane.getRowConstraints().clear();

        int row = 0, column = 0;

        for (int q = 0; q < doctorList.size(); q++) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("DoctorCard.fxml"));
                StackPane stack = loader.load();

                DoctorCardController dController = loader.getController();
                dController.setData(doctorList.get(q));

                if (column == 3) {
                    column = 0;
                    row++;
                }

                doctors_gridPane.add(stack, column++, row);

                GridPane.setMargin(stack, new Insets(15));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void appointmentAppointmentInfoDisplay() {

        String sql = "SELECT * FROM patient WHERE patient_id = " + Data.patient_id;

        connect = Database.connectDB();

        try {
            assert connect != null;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                appointment_ad_name.setText(result.getString("full_name"));
                appointment_ad_mobileNumber.setText(result.getString("mobile_number"));
                appointment_ad_gender.setText(result.getString("gender"));
                appointment_ad_address.setText(result.getString("address"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void appointmentConfirmBtn() {

        if (appointment_d_description.getText().isEmpty()
                || appointment_d_schedule.getValue() == null
                || appointment_d_doctor.getSelectionModel().isEmpty()) {
            alert.errorMessage("Please fill all blank fields");
        } else {

            appointment_ad_description.setText(appointment_d_description.getText());
            appointment_ad_doctorName.setText(appointment_d_doctor.getSelectionModel().getSelectedItem());

            String sql = "SELECT * FROM doctor WHERE doctor_id = '"
                    + appointment_d_doctor.getSelectionModel().getSelectedItem() + "'";

            connect = Database.connectDB();
            String tempSpecialized = "";
            try {
                assert connect != null;
                prepare = connect.prepareStatement(sql);
                result = prepare.executeQuery();

                if (result.next()) {
                    tempSpecialized = result.getString("specialized");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            appointment_ad_specialization.setText(tempSpecialized);
            appointment_ad_schedule.setText(String.valueOf(appointment_d_schedule.getValue()));
        }

    }

    public void appointmentDoctor() {
        String sql = "SELECT * FROM doctor WHERE delete_date IS NULL";
        connect = Database.connectDB();

        try {
            assert connect != null;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            ObservableList listData = FXCollections.observableArrayList();
            while (result.next()) {
                listData.add(result.getString("doctor_id"));
            }

            appointment_d_doctor.setItems(listData);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void appointmentClearBtn() {
        appointment_d_doctor.getSelectionModel().clearSelection();
        appointment_d_description.clear();
        appointment_d_schedule.setValue(null);

        appointment_ad_description.setText("");
        appointment_ad_doctorName.setText("");
        appointment_ad_specialization.setText("");
        appointment_ad_schedule.setText("");
    }

    public void appointmentBookBtn() {
        connect = Database.connectDB();

        if (appointment_ad_description.getText().isEmpty()
                || appointment_d_doctor.getSelectionModel().isEmpty()
                || appointment_ad_specialization.getText().isEmpty()
                || appointment_ad_schedule.getText().isEmpty()) {
            alert.errorMessage("Invalid");
        } else {
            String selectData = "SELECT MAX(appointment_id) FROM appointment";

            int tempAppID = 0;

            try {
                statement = connect.createStatement();
                result = statement.executeQuery(selectData);

                if (result.next()) {
                    tempAppID = result.getInt("MAX(appointment_id)") + 1;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            String insertData = "INSERT INTO appointment (appointment_id, patient_id, name, gender"
                    + ", description, mobile_number, address, date"
                    + ", doctor, specialized, schedule, status) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
            Date date = new Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            try {
                if (alert.confirmationMessage("Are you sure you want to book?")) {
                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, String.valueOf(tempAppID));
                    prepare.setString(2, String.valueOf(Data.patient_id));
                    prepare.setString(3, appointment_ad_name.getText());
                    prepare.setString(4, appointment_ad_gender.getText());
                    prepare.setString(5, appointment_ad_description.getText());
                    prepare.setString(6, appointment_ad_mobileNumber.getText());
                    prepare.setString(7, appointment_ad_address.getText());
                    prepare.setString(8, String.valueOf(appointment_d_schedule.getValue()));
                    prepare.setString(9, appointment_d_doctor.getSelectionModel().getSelectedItem());
                    prepare.setString(10, appointment_ad_specialization.getText());
                    prepare.setString(11, appointment_ad_schedule.getText());
                    prepare.setString(12, "Active");

                    prepare.executeUpdate();

                    alert.successMessage("Successful !");

                    appointmentClearBtn();
                } else {
                    alert.errorMessage("Cancelled.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void profileDisplayFields() {

        String sql = "SELECT * FROM patient WHERE patient_id = " + Data.patient_id;
        connect = Database.connectDB();

        try {
            assert connect != null;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                profile_patientID.setText(result.getString("patient_id"));
                profile_name.setText(result.getString("full_name"));
                profile_mobileNumber.setText(result.getString("mobile_number"));
                profile_status.getSelectionModel().select(result.getString("gender"));
                profile_password.setText(result.getString("password"));
                profile_address.setText(result.getString("address"));

                if (result.getString("image") != null) {
                    String imagePath = "File:" + result.getString("image");
                    image = new Image(imagePath, 137, 95, false, true);
                    profile_circle.setFill(new ImagePattern(image));
                }
                profileDisplayLabels();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void profileDisplayLabels() {
        String sql = "SELECT * FROM patient WHERE patient_id = " + Data.patient_id;
        connect = Database.connectDB();

        try {
            assert connect != null;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                profile_label_patientID.setText(result.getString("patient_id"));
                profile_label_name.setText(result.getString("full_name"));
                profile_label_mobileNumber.setText(result.getString("mobile_number"));
                profile_label_dateCreated.setText(result.getString("date"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void profileDisplayImages() {

        String sql = "SELECT * FROM patient WHERE patient_id = " + Data.patient_id;
        connect = Database.connectDB();

        String tempPath1 = "";
        String tempPath2 = "";

        try {
            assert connect != null;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                tempPath1 = "File:" + result.getString("image");
                tempPath2 = "File:" + result.getString("image");

                if (result.getString("image") != null || "".equals(result.getString("image"))) {
                    image = new Image(tempPath1, 137, 95, false, true);
                    profile_circle.setFill(new ImagePattern(image));
                    image = new Image(tempPath2, 1012, 22, false, true);
                    top_profile.setFill(new ImagePattern(image));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void profileUpdateBtn() {
        connect = Database.connectDB();

        if (profile_patientID.getText().isEmpty()
                || profile_name.getText().isEmpty()
                || profile_mobileNumber.getText().isEmpty()
                || profile_status.getSelectionModel().isEmpty()
                || profile_password.getText().isEmpty()
                || profile_address.getText().isEmpty()) {
            alert.errorMessage("Please fill all blank fields");
        } else {
            if (alert.confirmationMessage("Are you sure you want to Update your Profile?")) {
                if (Data.path == null || "".equals(Data.path)) {
                    String updateData = "UPDATE patient SET "
                            + "full_name = '" + profile_name.getText() + "', mobile_number = '"
                            + profile_mobileNumber.getText() + "', gender = '"
                            + profile_status.getSelectionModel().getSelectedItem() + "', password = '"
                            + profile_password.getText() + "', address = '"
                            + profile_address.getText() + "' WHERE patient_id = " + Data.patient_id;

                    try {
                        prepare = connect.prepareStatement(updateData);
                        prepare.executeUpdate();

                        alert.successMessage("Updated Successfully");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    String path = Data.path;
                    path = path.replace("\\", "\\\\");

                    Path transfer = Paths.get(path);

                    Path copy = Paths.get("D:\\Coding\\IntellliJ IDEA-Workspace\\HealthMonitor\\src\\main\\java\\com\\ak\\healthmonitor\\Directory\\"
                            + Data.patient_id + ".jpg");

                    String copyPath = copy.toAbsolutePath().toString();
                    copyPath = copyPath.replace("\\", "\\\\");

                    String updateData = "UPDATE patient SET "
                            + "full_name = '" + profile_name.getText() + "', mobile_number = '"
                            + profile_mobileNumber.getText() + "', gender = '"
                            + profile_status.getSelectionModel().getSelectedItem() + "', password = '"
                            + profile_password.getText() + "', address = '"
                            + profile_address.getText() + "', image = '"
                            + copyPath + "' WHERE patient_id = " + Data.patient_id;

                    try {
                        prepare = connect.prepareStatement(updateData);
                        prepare.executeUpdate();

                        Files.copy(transfer, copy, StandardCopyOption.REPLACE_EXISTING);

                        alert.successMessage("Updated successfully!");

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else {
                alert.errorMessage("Cancelled.");
            }

        }
        profileDisplayImages();
    }

    public void profileImportBtn() {

        FileChooser open = new FileChooser();
        open.getExtensionFilters().add(new ExtensionFilter("Open Image", "*jpg", "*jpeg", "*png"));

        File file = open.showOpenDialog(profile_importBtn.getScene().getWindow());

        if (file != null) {
            Data.path = file.getAbsolutePath();

            image = new Image(file.toURI().toString(), 137, 95, false, true);
            profile_circle.setFill(new ImagePattern(image));
        }

    }

    public void profileGenderList() {

        List<String> listG = new ArrayList<>();

        for (String data : Data.gender) {
            listG.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(listG);
        profile_status.setItems(listData);

    }

    @FXML
    void logoutBtn(ActionEvent event) {

        try {
            if (alert.confirmationMessage("Are you sure you want to logout?")) {
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("PatientPage.fxml")));
                Stage stage = new Stage();

                stage.setScene(new Scene(root));
                stage.show();

                logout_btn.getScene().getWindow().hide();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void profileInsertImage(ActionEvent event) {

    }

    @FXML
    void switchForm(ActionEvent event) {

        if (event.getSource() == dashboard_btn)
        {
            home_form.setVisible(true);
            doctors_form.setVisible(false);
            appointments_form.setVisible(false);
            healthtracking_form.setVisible(false);
            profile_form.setVisible(false);
        }
        else if (event.getSource() == doctors_btn)
        {
            home_form.setVisible(false);
            doctors_form.setVisible(true);
            appointments_form.setVisible(false);
            healthtracking_form.setVisible(false);
            profile_form.setVisible(false);
        }
        else if (event.getSource() == appointments_btn)
        {
            home_form.setVisible(false);
            doctors_form.setVisible(false);
            appointments_form.setVisible(true);
            healthtracking_form.setVisible(false);
            profile_form.setVisible(false);
        }
        else if(event.getSource()== health_btn)
        {
            home_form.setVisible(false);
            doctors_form.setVisible(false);
            appointments_form.setVisible(false);
            healthtracking_form.setVisible(true);
            profile_form.setVisible(false);

        }
        else if (event.getSource() == profile_btn)
        {
            home_form.setVisible(false);
            doctors_form.setVisible(false);
            appointments_form.setVisible(false);
            healthtracking_form.setVisible(false);
            profile_form.setVisible(true);
        }

    }

    @FXML
    void HT_switchForm(ActionEvent event) {

        if (event.getSource() == health_HM_btn)
        {
            health_HM_form.setVisible(true);
            health_GT_form.setVisible(false);
            health_MT_form.setVisible(false);
            health_FIT_form.setVisible(false);
            health_NT_form.setVisible(false);
            health_HIT_form.setVisible(false);
            health_ECI_form.setVisible(false);
            health_HRM_form.setVisible(false);
        }
        else if (event.getSource() == health_GT_btn)
        {
            health_HM_form.setVisible(false);
            health_GT_form.setVisible(true);
            health_MT_form.setVisible(false);
            health_FIT_form.setVisible(false);
            health_NT_form.setVisible(false);
            health_HIT_form.setVisible(false);
            health_ECI_form.setVisible(false);
            health_HRM_form.setVisible(false);
        }
        else if (event.getSource() == health_MT_btn)
        {
            health_HM_form.setVisible(false);
            health_GT_form.setVisible(false);
            health_MT_form.setVisible(true);
            health_FIT_form.setVisible(false);
            health_NT_form.setVisible(false);
            health_HIT_form.setVisible(false);
            health_ECI_form.setVisible(false);
            health_HRM_form.setVisible(false);
        }
        else if(event.getSource()== health_FIT_btn)
        {
            health_HM_form.setVisible(false);
            health_GT_form.setVisible(false);
            health_MT_form.setVisible(false);
            health_FIT_form.setVisible(true);
            health_NT_form.setVisible(false);
            health_HIT_form.setVisible(false);
            health_ECI_form.setVisible(false);
            health_HRM_form.setVisible(false);

        }
        else if (event.getSource() == health_NT_btn)
        {
            health_HM_form.setVisible(false);
            health_GT_form.setVisible(false);
            health_MT_form.setVisible(false);
            health_FIT_form.setVisible(false);
            health_NT_form.setVisible(true);
            health_HIT_form.setVisible(false);
            health_ECI_form.setVisible(false);
            health_HRM_form.setVisible(false);
        }
        else if (event.getSource() == health_HIT_btn)
        {
            health_HM_form.setVisible(false);
            health_GT_form.setVisible(false);
            health_MT_form.setVisible(false);
            health_FIT_form.setVisible(false);
            health_NT_form.setVisible(false);
            health_HIT_form.setVisible(true);
            health_ECI_form.setVisible(false);
            health_HRM_form.setVisible(false);
        }
        else if (event.getSource() == health_ECI_btn)
        {
            health_HM_form.setVisible(false);
            health_GT_form.setVisible(false);
            health_MT_form.setVisible(false);
            health_FIT_form.setVisible(false);
            health_NT_form.setVisible(false);
            health_HIT_form.setVisible(false);
            health_ECI_form.setVisible(true);
            health_HRM_form.setVisible(false);
        }
        else if (event.getSource() == health_HRM_btn)
        {
            health_HM_form.setVisible(false);
            health_GT_form.setVisible(false);
            health_MT_form.setVisible(false);
            health_FIT_form.setVisible(false);
            health_NT_form.setVisible(false);
            health_HIT_form.setVisible(false);
            health_ECI_form.setVisible(false);
            health_HRM_form.setVisible(true);
        }

    }

    public void displayPatientID(){
        nav_adminID.setText(String.valueOf(Data.patient_id));
    }
    
    public void displayPatient(){
        String sql = "SELECT * FROM patient WHERE patient_id = " + Data.patient_id;
        connect = Database.connectDB();
        
        try{
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            if(result.next()){
                top_username.setText(result.getString("full_name"));
            }
        }catch(Exception e){e.printStackTrace();}
    }
    
    public void runTime() {

        new Thread() {

            public void run() {
                SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
                while (true) {
                    try {

                        Thread.sleep(1000); // 1000 ms = 1s

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    Platform.runLater(() -> {
                        date_time.setText(format.format(new Date()));
                    });
                }
            }
        }.start();

    }

//    @FXML
//    private void handleCalculate()
//    {
//        series = new XYChart.Series<>();
//        try {
//            int bpm = Integer.parseInt(bpmField.getText());
//            series.getData().clear();
//
//            // Simulate heart rate data for 60 seconds
//            for (int i = 0; i < 60; i++) {
//                series.getData().add(new XYChart.Data<>(i, bpm));
//            }
//        } catch (NumberFormatException e) {
//            bpmField.setText("Invalid input");
//        }
//        heartRateChart.getData().add(series);
//    }

//    public void handleCalculate() {
//        heartRateChart.getData().clear();
//
//        String selectData = "SELECT DATE(date) as grouped_date, COUNT(id) FROM doctor WHERE delete_date IS NULL GROUP BY grouped_date ORDER BY grouped_date ASC LIMIT 6;";
//
//        connect = Database.connectDB();
//        XYChart.Series chart = new XYChart.Series<>();
//
//        try {
//            prepare = connect.prepareStatement(selectData);
//            result = prepare.executeQuery();
//
//            while (result.next()) {
//                chart.getData().add(new XYChart.Data<>(result.getString(1), result.getInt(2)));
//            }
//
//            heartRateChart.getData().add(chart);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }

    public void HealtTrackingHMT() {
        HMT_chart.getData().clear();

        String selectData = "SELECT heart_rate, patient_ID FROM healthtracking";

        connect = Database.connectDB();
        XYChart.Series chart = new XYChart.Series<>();

        try {
            prepare = connect.prepareStatement(selectData);
            result = prepare.executeQuery();

            while (result.next()) {
                chart.getData().add(new XYChart.Data<>(result.getString(1), result.getInt(2)));
            }

            HMT_chart.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ObservableList<PatientsData> HTPatientHRMListData;

    public void HTPatientHRMDisplayData() {
        HTPatientHRMListData = homePatientGetData();

        HT_patientHRM_col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        HT_patientHRM_col_diagnosis.setCellValueFactory(new PropertyValueFactory<>("diagnosis"));
        HT_patientHRM_col_treatment.setCellValueFactory(new PropertyValueFactory<>("treatment"));
        HT_patientHRM_col_dateIn.setCellValueFactory(new PropertyValueFactory<>("date"));

        HT_patientHRM_tableView.setItems(HTPatientHRMListData);
    }

//    public void ECIUpdate() {
//        connect = Database.connectDB();
//
//        if (HT_ECI_patientID.getText().isEmpty()
//                || HT_ECI_Gurdianname.getText().isEmpty()
//                || HT_ECI_mobileNumber.getText().isEmpty()
//                || HT_ECI_gender.getSelectionModel().isEmpty()
//                || HT_ECI_address.getText().isEmpty())
//        {
//            alert.errorMessage("Please fill all blank fields");
//        }
//        else
//        {
//            if (alert.confirmationMessage("Are you sure you want to Update your Emergency Contact Integration ?"))
//            {
//                if (Data.path == null || "".equals(Data.path))
//                {
//
//                    String insertData = "INSERT INTO patienteci (patient_id, Gname, gender, mobile, address) VALUES ('"
//                            + HT_ECI_patientID.getText() + "', '"
//                            + HT_ECI_Gurdianname.getText() + "', '"
//                            + HT_ECI_gender.getSelectionModel().getSelectedItem() + "', '"
//                            + HT_ECI_mobileNumber.getText() + "', '"
//                            + HT_ECI_address.getText() + "')";
//
//                    try {
//                        prepare = connect.prepareStatement(insertData);
//                        prepare.executeUpdate();
//
//                        alert.successMessage("Inserted successfully!");
//
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//
//                }
//            } else {
//                alert.errorMessage("Cancelled.");
//            }
//
//        }
//    }

    public void ECIUpdate() {
        Connection connect = null;
        PreparedStatement prepare = null;
        ResultSet rs = null;

        try {
            connect = Database.connectDB();

            if (HT_ECI_patientID.getText().isEmpty()
                    || HT_ECI_Gurdianname.getText().isEmpty()
                    || HT_ECI_mobileNumber.getText().isEmpty()
                    || HT_ECI_gender.getSelectionModel().isEmpty()
                    || HT_ECI_address.getText().isEmpty()) {
                alert.errorMessage("Please fill all blank fields");
                return; // Exit method if any field is empty
            }

            if (!alert.confirmationMessage("Are you sure you want to Update your Emergency Contact Integration?")) {
                alert.errorMessage("Cancelled.");
                return; // Exit method if user cancels update
            }

            String checkData = "SELECT * FROM patienteci WHERE patient_id = ?";
            String updateData = "UPDATE patienteci SET Gname = ?, gender = ?, mobile = ?, address = ? WHERE patient_id = ?";
            String insertData = "INSERT INTO patienteci (patient_id, Gname, gender, mobile, address) VALUES (?, ?, ?, ?, ?)";

            connect.setAutoCommit(false); // Start transaction

            // Check if data exists for the given patient_id
            prepare = connect.prepareStatement(checkData);
            prepare.setString(1, HT_ECI_patientID.getText());
            rs = prepare.executeQuery();

            if (rs.next()) {
                // Data exists, update the existing record
                prepare.close(); // Close previous prepare statement
                prepare = connect.prepareStatement(updateData);
                prepare.setString(1, HT_ECI_Gurdianname.getText());
                prepare.setString(2, HT_ECI_gender.getSelectionModel().getSelectedItem());
                prepare.setString(3, HT_ECI_mobileNumber.getText());
                prepare.setString(4, HT_ECI_address.getText());
                prepare.setString(5, HT_ECI_patientID.getText());

                int updatedRows = prepare.executeUpdate();

                if (updatedRows > 0) {
                    alert.successMessage("Data updated successfully!");
                } else {
                    alert.errorMessage("Update operation failed.");
                }
            } else {
                // Data does not exist, insert new record
                prepare.close(); // Close previous prepare statement
                prepare = connect.prepareStatement(insertData);
                prepare.setString(1, HT_ECI_patientID.getText());
                prepare.setString(2, HT_ECI_Gurdianname.getText());
                prepare.setString(3, HT_ECI_gender.getSelectionModel().getSelectedItem());
                prepare.setString(4, HT_ECI_mobileNumber.getText());
                prepare.setString(5, HT_ECI_address.getText());

                int insertedRows = prepare.executeUpdate();

                if (insertedRows > 0) {
                    alert.successMessage("Data inserted successfully!");
                } else {
                    alert.errorMessage("Insert operation failed.");
                }
            }

            connect.commit(); // Commit transaction
        } catch (Exception e) {
            try {
                if (connect != null) {
                    connect.rollback(); // Rollback transaction on error
                }
            } catch (SQLException rollbackException) {
                rollbackException.printStackTrace();
            }
            e.printStackTrace();
            alert.errorMessage("An error occurred: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (prepare != null) prepare.close();
                if (connect != null) {
                    connect.setAutoCommit(true); // Reset auto-commit mode
                    connect.close();
                }
            } catch (SQLException closeException) {
                closeException.printStackTrace();
            }
        }
    }



    public void health_ECIDisplayFields() {

        String sql = "SELECT * FROM patienteci WHERE patient_id = " + Data.patient_id;
        connect = Database.connectDB();

        try {
            assert connect != null;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                HT_ECI_patientID.setText(result.getString("patient_id"));
                HT_ECI_Gurdianname.setText(result.getString("Gname"));
                HT_ECI_mobileNumber.setText(result.getString("mobile"));
                HT_ECI_gender.getSelectionModel().select(result.getString("gender"));
                HT_ECI_address.setText(result.getString("address"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void HT_ECIGenderList() {

        List<String> listG = new ArrayList<>();

        for (String data : Data.gender) {
            listG.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(listG);
        HT_ECI_gender.setItems(listData);

    }

    public static double calculateBMI(double lweight, double lheight)
    {
        //Convert Cm to meter
        lheight = lheight / 100;
        return lweight / (lheight * lheight);
    }

    public static double calculateHeartRate(double beatsCounted, double seconds)
    {
        // Calculate heart rate in beats per minute
        double heartRate = (beatsCounted / (double) seconds) * 60;
        return heartRate;
    }

    public void HITDisplayLabel()
    {
        String sql = "SELECT * FROM healthtracking WHERE patient_id = " + Data.patient_id;
        Connection connect = Database.connectDB();
        PreparedStatement prepare = null;
        ResultSet result = null;

        try {
            assert connect != null;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                HIT_Pname.setText(result.getString("name"));
                HIT_Pgender.setText(result.getString("gender"));


                double lheight = Double.parseDouble(result.getString("height"));
                double lweight = Double.parseDouble(result.getString("b_weight"));
                double lBmi = calculateBMI(lweight, lheight);

               //IF for BMI

                HIT_Pbmi.setText(result.getString("bmi"));

                if (lBmi >= 18.5 && lBmi <= 24.9)
                {
                    HIT_Pbmi_recom.setText("Your Body Mass Index is Healthy Condition!!");
                } else if (lBmi >= 25 && lBmi <= 29.9) {
                    HIT_Pbmi_recom.setText("Your Body Mass Index is Overweight! Maintain your Diet.");
                } else if (lBmi >= 30) {
                    HIT_Pbmi_recom.setText("Your Body Mass Index is higher than 30. Critical Stage.");
                } else {
                    HIT_Pbmi_recom.setText("Your Body Mass Index is Underweight!!");
                }

                //IF for Body Weight
                HIT_Pbweight.setText(result.getString("b_weight"));

                if (lBmi >= 18.5 && lBmi <= 24.9) {
                    HIT_Pbweight_recomm.setText("Your Body weight is Healthy Condition!!");
                } else if (lBmi >= 25 && lBmi <= 29.9) {
                    HIT_Pbweight_recomm.setText("Your Body weight is Overweight! Maintain your Diet.");
                } else if (lBmi >= 30) {
                    HIT_Pbweight_recomm.setText("Your Body weight is higher than 30. Critical Stage.");
                } else {
                    HIT_Pbweight_recomm.setText("Your Body weight is Underweight!!");
                }


                // Number of seconds during which beats were counted
                double lbeatsecond = 15;

                // Number of beats counted
                double lrate = Double.parseDouble(result.getString("heart_rate"));

                double lheartrate = calculateHeartRate(lrate,lbeatsecond);

                //If For heart rate

                HIT_Pheartrate.setText(result.getString("heart_rate"));

                if (lheartrate >= 60 && lheartrate <= 100)
                {
                    HIT_Pheartrate_recomm.setText("Your heart rate is in the normal range.");
                } else if (lheartrate < 60) {
                    HIT_Pheartrate_recomm.setText("Your heart rate is low (bradycardia).");
                } else {
                    HIT_Pheartrate_recomm.setText("Your heart rate is high (tachycardia).");
                }

                double lbpresure = Double.parseDouble(result.getString("blood_presure"));
                // If for Blood Pressure

                HIT_Pbpresure.setText(result.getString("blood_presure"));

                if (lbpresure < 80)
                {
                    HIT_Pbpresure_recomm.setText("Normal");

                } else if (lbpresure < 140)
                {
                    HIT_Pbpresure_recomm.setText("High Blood Pressure (Hypertension) Stage 1");
                } else if (lbpresure < 180)
                {
                    HIT_Pbpresure_recomm.setText("High Blood Pressure (Hypertension) Stage 2");
                } else
                {
                    HIT_Pbpresure_recomm.setText("Hypertensive Crisis (consult your doctor immediately)");
                }

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

    @FXML
    void NT_switchForm(ActionEvent event)
    {

        if (event.getSource() == NTmonth_btn)
        {
            NTweek_table.setVisible(false);
            NTmonth_table.setVisible(true);
        }
        else if (event.getSource() == NTweek_btn)
        {
            NTweek_table.setVisible(true);
            NTmonth_table.setVisible(false);
        }
    }
    //Nutrition Table

    //Weekly Nutrituion Table View

    public ObservableList<WeekNutritionData> weekNutritionListData;

    public void weeknutritionShowData() {
        weekNutritionListData = weekNutritionGetData();

        NT_WNT_col_day.setCellValueFactory(new PropertyValueFactory<>("day"));
        NT_WNT_col_bmi.setCellValueFactory(new PropertyValueFactory<>("bmi"));
        NT_WNT_col_bweight.setCellValueFactory(new PropertyValueFactory<>("b_weight"));
        NT_WNT_col_heartrate.setCellValueFactory(new PropertyValueFactory<>("heart_rate"));
        NT_WNT_col_bpressure.setCellValueFactory(new PropertyValueFactory<>("blood_presure"));
        NT_WNT_col_breakfast.setCellValueFactory(new PropertyValueFactory<>("breakfast"));
        NT_WNT_col_lunch.setCellValueFactory(new PropertyValueFactory<>("lunch"));
        NT_WNT_col_dinner.setCellValueFactory(new PropertyValueFactory<>("dinner"));
        NT_WNT_col_snack1.setCellValueFactory(new PropertyValueFactory<>("snack1"));
        NT_WNT_col_snack2.setCellValueFactory(new PropertyValueFactory<>("snack2"));
        NT_WNT_col_note.setCellValueFactory(new PropertyValueFactory<>("notes"));

        NTweek_table_view.setItems(weekNutritionListData);
    }

    public ObservableList<WeekNutritionData> weekNutritionGetData() {

        ObservableList<WeekNutritionData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM weeknutritiontable";

        connect = Database.connectDB();

        try {

            assert connect != null;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            WeekNutritionData appData;

            while (result.next()) {

                appData = new WeekNutritionData(result.getInt("id"),
                        result.getString("day"), result.getDouble("bmi"),
                        result.getDouble("b_weight"), result.getDouble("heart_rate"),
                        result.getDouble("blood_presure"), result.getString("breakfast"),
                        result.getString("lunch"), result.getString("dinner"),
                        result.getString("snack1"), result.getString("snack2"),
                        result.getString("notes"));
                // STORE ALL DATA
                listData.add(appData);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    public void weekNutritionSelect()
    {

        WeekNutritionData appData = NTweek_table_view.getSelectionModel().getSelectedItem();
        int num = NTweek_table_view.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        NT_WNT_col_day.setText(appData.getDay());
        NT_WNT_col_bmi.setText(""+appData.getBmi());
        NT_WNT_col_bweight.setText("" + appData.getB_weight());
        NT_WNT_col_bpressure.setText(""+appData.getBlood_presure());
        NT_WNT_col_heartrate.setText("" + appData.getHeart_rate());
        NT_WNT_col_breakfast.setText(appData.getBreakfast());
        NT_WNT_col_lunch.setText(appData.getLunch());
        NT_WNT_col_dinner.setText(appData.getDinner());
        NT_WNT_col_snack1.setText(appData.getSnack1());
        NT_WNT_col_snack2.setText(appData.getSnack2());
        NT_WNT_col_note.setText(appData.getNotes());

    }

    //Monthly Nutrition Table

    public ObservableList<MonthNutritionData> monthNutritionListData;

    public void monthnutritionShowData() {
        monthNutritionListData = monthNutritionGetData();

        NT_MNT_col_week.setCellValueFactory(new PropertyValueFactory<>("week"));
        NT_MNT_col_bmi.setCellValueFactory(new PropertyValueFactory<>("bmi"));
        NT_MNT_col_bweight.setCellValueFactory(new PropertyValueFactory<>("b_weight"));
        NT_MNT_col_heartrate.setCellValueFactory(new PropertyValueFactory<>("heart_rate"));
        NT_MNT_col_bpressure.setCellValueFactory(new PropertyValueFactory<>("blood_presure"));
        NT_MNT_col_breakfast.setCellValueFactory(new PropertyValueFactory<>("breakfast"));
        NT_MNT_col_lunch.setCellValueFactory(new PropertyValueFactory<>("lunch"));
        NT_MNT_col_dinner.setCellValueFactory(new PropertyValueFactory<>("dinner"));
        NT_MNT_col_snack1.setCellValueFactory(new PropertyValueFactory<>("snack1"));
        NT_MNT_col_snack2.setCellValueFactory(new PropertyValueFactory<>("snack2"));
        NT_MNT_col_note.setCellValueFactory(new PropertyValueFactory<>("notes"));

        NTmonth_table_view.setItems(monthNutritionListData);
    }

    public ObservableList<MonthNutritionData> monthNutritionGetData() {

        ObservableList<MonthNutritionData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM monthnutritiontable";

        connect = Database.connectDB();

        try {

            assert connect != null;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            MonthNutritionData appData;

            while (result.next()) {

                appData = new MonthNutritionData(result.getInt("id"),
                        result.getString("week"), result.getDouble("bmi"),
                        result.getDouble("b_weight"), result.getDouble("heart_rate"),
                        result.getDouble("blood_presure"), result.getString("breakfast"),
                        result.getString("lunch"), result.getString("dinner"),
                        result.getString("snack1"), result.getString("snack2"),
                        result.getString("notes"));
                // STORE ALL DATA
                listData.add(appData);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    public void monthNutritionSelect()
    {

        MonthNutritionData appData = (MonthNutritionData) NTmonth_table_view.getSelectionModel().getSelectedItem();
        int num = NTmonth_table_view.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        NT_MNT_col_week.setText(appData.getWeek());
        NT_MNT_col_bmi.setText(""+appData.getBmi());
        NT_MNT_col_bweight.setText("" + appData.getB_weight());
        NT_MNT_col_bpressure.setText(""+appData.getBlood_presure());
        NT_MNT_col_heartrate.setText("" + appData.getHeart_rate());
        NT_MNT_col_breakfast.setText(appData.getBreakfast());
        NT_MNT_col_lunch.setText(appData.getLunch());
        NT_MNT_col_dinner.setText(appData.getDinner());
        NT_MNT_col_snack1.setText(appData.getSnack1());
        NT_MNT_col_snack2.setText(appData.getSnack2());
        NT_MNT_col_note.setText(appData.getNotes());

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        runTime();
        displayPatientID();
        displayPatient();

        homePatientDisplayData();
        homeAppointmentDisplayData();
        homeDoctorInfoDisplay();

        doctorShowCard();

        appointmentAppointmentInfoDisplay();
        appointmentDoctor();

        profileDisplayFields();
        profileGenderList();
        profileDisplayImages();

        HealtTrackingHMT();
        HTPatientHRMDisplayData();
        HT_ECIGenderList();
        health_ECIDisplayFields();
        HITDisplayLabel();

        //Nutritioan Table view
        weeknutritionShowData();
        weekNutritionSelect();
        monthnutritionShowData();
        monthNutritionSelect();
//        handleCalculate();

    }

}
