package app.gui;

import java.io.*;
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

public class ChooseLibraryForBorrowBooksController {

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
    private Button lib1;
    @FXML
    private Button lib2;
    @FXML
    private Button lib3;
    @FXML
    private Button lib4;
    @FXML
    private Button lib5;
    @FXML
    private Button lib6;
    @FXML
    private Button lib7;
    @FXML
    private Button lib8;
    @FXML
    private Button lib9;

    @FXML
    void initialize() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src\\app\\library\\LibraryList.txt"));
        ArrayList<String> lines = new ArrayList<String>();

        String currentLine = br.readLine();
        lib1.setText(currentLine);
        if(currentLine.equals("Add Library")) lib1.setDisable(true);

        currentLine = br.readLine();
        lib2.setText(currentLine);
        if(currentLine.equals("Add Library")) lib2.setDisable(true);

        currentLine = br.readLine();
        lib3.setText(currentLine);
        if(currentLine.equals("Add Library")) lib3.setDisable(true);

        currentLine = br.readLine();
        lib4.setText(currentLine);
        if(currentLine.equals("Add Library")) lib4.setDisable(true);

        currentLine = br.readLine();
        lib5.setText(currentLine);
        if(currentLine.equals("Add Library")) lib5.setDisable(true);

        currentLine = br.readLine();
        lib6.setText(currentLine);
        if(currentLine.equals("Add Library")) lib6.setDisable(true);

        currentLine = br.readLine();
        lib7.setText(currentLine);
        if(currentLine.equals("Add Library")) lib7.setDisable(true);

        currentLine = br.readLine();
        lib8.setText(currentLine);
        if(currentLine.equals("Add Library")) lib8.setDisable(true);

        currentLine = br.readLine();
        lib9.setText(currentLine);
        if(currentLine.equals("Add Library")) lib9.setDisable(true);

        br.close();
    }

    @FXML
    private void handleClicksOnChooseLibrary(ActionEvent event) throws Exception {
        handleDashboard(event);
        handleLibButtons(event);
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

    private void handleLibButtons(ActionEvent event) throws Exception{
        if(event.getSource()==lib1){
            Parent findBookParent = FXMLLoader.load(getClass().getResource("FindBook.fxml"));
            Scene findBookScene = new Scene(findBookParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(findBookScene);
            window.show();
        }

        else if(event.getSource()==lib2){
            Parent findBookParent = FXMLLoader.load(getClass().getResource("FindBook.fxml"));
            Scene findBookScene = new Scene(findBookParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(findBookScene);
            window.show();
        }

        else if(event.getSource()==lib3){
            Parent findBookParent = FXMLLoader.load(getClass().getResource("FindBook.fxml"));
            Scene findBookScene = new Scene(findBookParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(findBookScene);
            window.show();
        }

        else if(event.getSource()==lib4){
            Parent findBookParent = FXMLLoader.load(getClass().getResource("FindBook.fxml"));
            Scene findBookScene = new Scene(findBookParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(findBookScene);
            window.show();
        }

        else if(event.getSource()==lib5){
            Parent findBookParent = FXMLLoader.load(getClass().getResource("FindBook.fxml"));
            Scene findBookScene = new Scene(findBookParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(findBookScene);
            window.show();
        }

        else if(event.getSource()==lib6){
            Parent findBookParent = FXMLLoader.load(getClass().getResource("FindBook.fxml"));
            Scene findBookScene = new Scene(findBookParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(findBookScene);
            window.show();
        }

        else if(event.getSource()==lib7){
            Parent findBookParent = FXMLLoader.load(getClass().getResource("FindBook.fxml"));
            Scene findBookScene = new Scene(findBookParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(findBookScene);
            window.show();
        }

        else if(event.getSource()==lib8){
            Parent findBookParent = FXMLLoader.load(getClass().getResource("FindBook.fxml"));
            Scene findBookScene = new Scene(findBookParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(findBookScene);
            window.show();
        }

        else if(event.getSource()==lib9){
            Parent findBookParent = FXMLLoader.load(getClass().getResource("FindBook.fxml"));
            Scene findBookScene = new Scene(findBookParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(findBookScene);
            window.show();
        }
    }
}
