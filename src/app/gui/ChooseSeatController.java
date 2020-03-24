package app.gui;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import app.gui.ChooseRoomController.*;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ChooseSeatController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button homeBtn;
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
    private Button seat1;
    @FXML
    private Button seat2;
    @FXML
    private Button seat3;
    @FXML
    private Button seat4;
    @FXML
    private Button seat5;
    @FXML
    private Button seat6;
    @FXML
    private Button seat7;
    @FXML
    private Button seat8;
    @FXML
    private Button seat9;
    @FXML
    private Button seat10;
    @FXML
    private Button seat11;
    @FXML
    private Button seat12;
    @FXML
    private Button seat13;
    @FXML
    private Button seat14;
    @FXML
    private Button seat15;
    @FXML
    private Button seat16;
    @FXML
    private Button seat17;
    @FXML
    private Button seat18;
    @FXML
    private Button seat19;
    @FXML
    private Button seat20;
    @FXML
    private Button seat21;
    @FXML
    private Button seat22;
    @FXML
    private Button seat23;
    @FXML
    private Button seat24;
    @FXML
    private Button seat25;
    @FXML
    private Button seat26;
    @FXML
    private Button seat27;
    @FXML
    private Button seat28;
    @FXML
    private Button seat29;
    @FXML
    private Button seat30;
    @FXML
    private Button seat31;
    @FXML
    private Button seat32;
    @FXML
    private Button seat33;
    @FXML
    private Button seat34;
    @FXML
    private Button seat35;
    @FXML
    private Button seat36;



    @FXML
    void initialize() throws IOException {
        String input = ChooseRoomController.getSeatString();
        String[] str = input.split("#",36);

        seat1.setText(str[0]);
        seat2.setText(str[1]);
        seat3.setText(str[2]);
        seat4.setText(str[3]);
        seat5.setText(str[4]);
        seat6.setText(str[5]);
        seat7.setText(str[6]);
        seat8.setText(str[7]);
        seat9.setText(str[8]);

        seat10.setText(str[9]);
        seat11.setText(str[10]);
        seat12.setText(str[11]);
        seat13.setText(str[12]);
        seat14.setText(str[13]);
        seat15.setText(str[14]);
        seat16.setText(str[15]);
        seat17.setText(str[16]);
        seat18.setText(str[17]);
        seat19.setText(str[18]);

        seat20.setText(str[19]);
        seat21.setText(str[20]);
        seat22.setText(str[21]);
        seat23.setText(str[22]);
        seat24.setText(str[23]);
        seat25.setText(str[24]);
        seat26.setText(str[25]);
        seat27.setText(str[26]);

        seat28.setText(str[27]);
        seat29.setText(str[28]);
        seat30.setText(str[29]);
        seat31.setText(str[30]);
        seat32.setText(str[31]);
        seat33.setText(str[32]);
        seat34.setText(str[33]);
        seat35.setText(str[34]);
        seat36.setText(str[35]);
    }

    @FXML
    void handleClicksOnChooseSeat(ActionEvent event) throws Exception{
        handleDashboard(event);
        handleSeatButtons(event);
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
            Parent borrowBookParent = FXMLLoader.load(getClass().getResource("ChooseLibraryForBorrowBooks.fxml"));
            Scene borrowBookScene = new Scene(borrowBookParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(borrowBookScene);
            window.show();
        }

        else if(event.getSource() == bookSeatBtn){
            Parent bookSeatParent = FXMLLoader.load(getClass().getResource("ChooseLibrary.fxml"));
            Scene bookSeatScene = new Scene(bookSeatParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(bookSeatScene);
            window.show();
        }

        else if(event.getSource() == historyBtn){
            Parent historyParent = FXMLLoader.load(getClass().getResource("History.fxml"));
            Scene historyScene = new Scene(historyParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(historyScene);
            window.show();
        }

        else if(event.getSource() == settingsBtn){
            Parent settingsParent = FXMLLoader.load(getClass().getResource("Settings.fxml"));
            Scene settingsScene = new Scene(settingsParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(settingsScene);
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

    private void handleSeatButtons(ActionEvent event) throws Exception{
        if(event.getSource()==seat1){
            showPopup();
        }

        else if(event.getSource()==seat2){
            showPopup();
        }

        else if(event.getSource()==seat3){
            showPopup();
        }

        else if(event.getSource()==seat4){
            showPopup();
        }

        else if(event.getSource()==seat5){
            showPopup();
        }

        else if(event.getSource()==seat6){
            showPopup();
        }

        else if(event.getSource()==seat7){
            showPopup();
        }

        else if(event.getSource()==seat8){
            showPopup();
        }

        else if(event.getSource()==seat9){
            showPopup();
        }

        else if(event.getSource()==seat11){
            showPopup();
        }

        else if(event.getSource()==seat12){
            showPopup();
        }

        else if(event.getSource()==seat13){
            showPopup();
        }

        else if(event.getSource()==seat14){
            showPopup();
        }

        else if(event.getSource()==seat15){
            showPopup();
        }

        else if(event.getSource()==seat16){
            showPopup();
        }

        else if(event.getSource()==seat17){
            showPopup();
        }

        else if(event.getSource()==seat18){
            showPopup();
        }

        else if(event.getSource()==seat19){
            showPopup();
        }

        else if(event.getSource()==seat20){
            showPopup();
        }

        else if(event.getSource()==seat21){
            showPopup();
        }

        else if(event.getSource()==seat22){
            showPopup();
        }

        else if(event.getSource()==seat23){
            showPopup();
        }

        else if(event.getSource()==seat24){
            showPopup();
        }

        else if(event.getSource()==seat25){
            showPopup();
        }

        else if(event.getSource()==seat26){
            showPopup();
        }

        else if(event.getSource()==seat27){
            showPopup();
        }

        else if(event.getSource()==seat28){
            showPopup();
        }

        else if(event.getSource()==seat29){
            showPopup();
        }

        else if(event.getSource()==seat30){
            showPopup();
        }

        else if(event.getSource()==seat31){
            showPopup();
        }

        else if(event.getSource()==seat32){
            showPopup();
        }

        else if(event.getSource()==seat33){
            showPopup();
        }

        else if(event.getSource()==seat34){
            showPopup();
        }

        else if(event.getSource()==seat35){
            showPopup();
        }

        else if(event.getSource()==seat36){
            showPopup();
        }
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

}
