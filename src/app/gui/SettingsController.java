package app.gui;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class SettingsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button profileBtn;

    @FXML
    private Button borrowBookBtn;

    @FXML
    private Button bookSeatBtn;

    @FXML
    private Button historyBtn;

    @FXML
    private Button settingsBtn;

    @FXML
    private Button logoutBtn;

    @FXML
    private Button homeBtn;

    @FXML
    private Label promptTitleLabel;

    @FXML
    private Label homeTitleLabel;

    @FXML
    void initialize() {
    }

    @FXML
    private void handleClicksOnSettings(ActionEvent event) throws Exception {
        handleDashboard(event);
    }

    private void handleDashboard(ActionEvent event) throws Exception{
        if(event.getSource() == homeBtn){
            Parent homeParent = FXMLLoader.load(getClass().getResource("Home.fxml"));
            Scene homeScene = new Scene(homeParent);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(homeScene);
            window.show();
        }

        else if(event.getSource() == profileBtn){
            Parent homeParent = FXMLLoader.load(getClass().getResource("Profile.fxml"));
            Scene homeScene = new Scene(homeParent);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(homeScene);
            window.show();
        }

        else if(event.getSource() == borrowBookBtn){
            Parent registerParent = FXMLLoader.load(getClass().getResource("ChooseLibraryForBorrowBooks.fxml"));
            Scene registerScene = new Scene(registerParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(registerScene);
            window.show();
        }

        else if(event.getSource() == bookSeatBtn){
            Parent registerParent = FXMLLoader.load(getClass().getResource("ChooseLibrary.fxml"));
            Scene registerScene = new Scene(registerParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(registerScene);
            window.show();
        }

        else if(event.getSource() == historyBtn){
            Parent registerParent = FXMLLoader.load(getClass().getResource("History.fxml"));
            Scene registerScene = new Scene(registerParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(registerScene);
            window.show();
        }

        else if(event.getSource() == settingsBtn){
            Parent registerParent = FXMLLoader.load(getClass().getResource("Settings.fxml"));
            Scene registerScene = new Scene(registerParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(registerScene);
            window.show();
        }

        else if(event.getSource() == logoutBtn){

            Socket s = new Socket("localhost", 8000);
            String message = "Logout";

            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            dos.writeUTF(message);
            dos.flush();

            Parent login = FXMLLoader.load(getClass().getResource("Login.fxml"));
            Scene loginScene = new Scene(login);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(loginScene);
            window.show();
        }
    }

}
