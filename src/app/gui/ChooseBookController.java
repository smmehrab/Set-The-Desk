package app.gui;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import app.gui.FindBookController.*;
import javafx.stage.Stage;

public class ChooseBookController {

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
    private Button book1;

    @FXML
    private Button book2;

    @FXML
    private Button book3;

    @FXML
    private Button book4;

    @FXML
    private Button book5;

    @FXML
    private Button book6;

    @FXML
    private Button book7;

    @FXML
    private Button book8;

    @FXML
    private Button book9;

    @FXML
    private Button book10;

    @FXML
    void handleClicksOnChooseBook(ActionEvent event) throws Exception {
        handleDashboard(event);

        if(event.getSource() == book1){
            showPopup();
        }
        else if(event.getSource() == book2){
            showPopup();
        }
        else if(event.getSource() == book3){
            showPopup();
        }
        else if(event.getSource() == book4){
            showPopup();
        }
        else if(event.getSource() == book5){
            showPopup();
        }
        else if(event.getSource() == book6){
            showPopup();
        }
        else if(event.getSource() == book7){
            showPopup();
        }
        else if(event.getSource() == book8){
            showPopup();
        }
        else if(event.getSource() == book9){
            showPopup();
        }

    }



    @FXML
    void initialize() throws Exception {
        String bookNames = FindBookController.getBookNames();
        String[] str = bookNames.split("#",10);

        book1.setText(str[0]);
        book2.setText(str[1]);
        book3.setText(str[2]);
        book4.setText(str[3]);
        book5.setText(str[4]);
        book6.setText(str[5]);
        book7.setText(str[6]);
        book8.setText(str[7]);
        book9.setText(str[8]);
        book10.setText(str[9]);

        if(book1.getText().equals("")) book1.setDisable(true);
        if(book2.getText().equals("")) book2.setDisable(true);
        if(book3.getText().equals("")) book3.setDisable(true);
        if(book4.getText().equals("")) book4.setDisable(true);
        if(book5.getText().equals("")) book5.setDisable(true);
        if(book6.getText().equals("")) book6.setDisable(true);
        if(book7.getText().equals("")) book7.setDisable(true);
        if(book8.getText().equals("")) book8.setDisable(true);
        if(book9.getText().equals("")) book9.setDisable(true);
        if(book10.getText().equals("")) book10.setDisable(true);
    }

    private void showPopup(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("BookSeatPopup.fxml"));

            Scene scene = new Scene(fxmlLoader.load(), 600, 226);
            Stage stage = new Stage();
            stage.setTitle("Confirmation Box");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
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
