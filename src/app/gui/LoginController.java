package app.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javax.xml.crypto.Data;
import java.net.*;

public class LoginController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    // Labels
    @FXML
    private Label titleLabel;
    @FXML
    private Label orLabel;

    // Icons
    @FXML
    private ImageView usernameIcon;
    @FXML
    private ImageView passwordIcon;

    // TextFields
    @FXML
    private TextField usernameTxt;
    @FXML
    private PasswordField passwordTxt;

    // Buttons
    @FXML
    private Button loginBtn;
    @FXML
    private Button toRegisterBtn;

    // Strings
    private String username;
    private String pass;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void handleClicksOnLogin(ActionEvent event) throws Exception {
        if(event.getSource() == loginBtn){
            readInputs();

            Socket s = new Socket("localhost", 8000);
            String message = "Login/" + username + "#" + pass;
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

        else if(event.getSource() == toRegisterBtn){
                Parent registerParent = FXMLLoader.load(getClass().getResource("Register.fxml"));
                Scene registerScene = new Scene(registerParent);

                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(registerScene);
                window.show();
        }

    }

    private void readInputs(){
        this.username = usernameTxt.getText();
        this.pass = passwordTxt.getText();
    }



}
