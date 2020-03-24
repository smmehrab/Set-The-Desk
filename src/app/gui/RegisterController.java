package app.gui;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.*;
import javafx.stage.*;
import javafx.fxml.FXMLLoader;

public class RegisterController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    // Buttons
    @FXML
    private Button registerBtn;
    @FXML
    private Button backBtn;

    // TextFields
    @FXML
    private TextField fullnameTxt;
    @FXML
    private TextField usernameTxt;
    @FXML
    private PasswordField passTxt;
    @FXML
    private PasswordField confirmPassTxt;
    @FXML
    private TextField emailTxt;
    @FXML
    private TextField mobileTxt;
    @FXML
    private TextField ageTxt;

    // Labels
    @FXML
    private Label fullnameLabel;
    @FXML
    private Label usernameLabel;
    @FXML
    private Label passLabel;
    @FXML
    private Label confirmPassLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label mobileLabel;
    @FXML
    private Label genderLabel;
    @FXML
    private Label ageLabel;

    // ToggleGroup
    @FXML
    private ToggleGroup chooseGender;

    // RadioButtons
    @FXML
    private RadioButton ifMaleBtn;
    @FXML
    private RadioButton ifFemaleBtn;
    @FXML
    private RadioButton ifOthersBtn;

    // Strings
    private String fullname;
    private String username;
    private String pass;
    private String confirmPass;
    private String email;
    private String mobile;
    private String gender;
    private String age;

    @FXML
    void initialize() {


    }

    @FXML
    void handleClicksOnRegister(ActionEvent event) throws IOException {
        if(event.getSource() == registerBtn){
            readInputs();

            Socket s = new Socket("localhost", 8000);
            String message = "Register/" + username + "#" + pass + "#" + confirmPass + "#" + fullname
                                + "#" + email + "#" + mobile + "#" + gender + "#" + age;

            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            dos.writeUTF(message);
            dos.flush();
            String received = dis.readUTF();
            System.out.println(received);



            if(received.equals("true")) {
                Parent homeParent = FXMLLoader.load(getClass().getResource("Home.fxml"));
                Scene homeScene = new Scene(homeParent);

                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(homeScene);
                window.show();
            }
        }

        else if(event.getSource() == backBtn){
            Parent registerParent = FXMLLoader.load(getClass().getResource("Login.fxml"));
            Scene registerScene = new Scene(registerParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(registerScene);
            window.show();
        }
    }

    @FXML
    void setGender(ActionEvent event) {
        if(this.chooseGender.getSelectedToggle().equals(this.ifMaleBtn))
            gender = "Male";
        else if(this.chooseGender.getSelectedToggle().equals(this.ifFemaleBtn))
            gender = "Female";
        else if(this.chooseGender.getSelectedToggle().equals(this.ifOthersBtn))
            gender = "Others";
    }

    void readInputs(){
        this.fullname = fullnameTxt.getText();
        this.username = usernameTxt.getText();
        this.pass = passTxt.getText();
        this.confirmPass = confirmPassTxt.getText();
        this.email = emailTxt.getText();
        this.mobile = mobileTxt.getText();
        this.age = ageTxt.getText();
    }

}


