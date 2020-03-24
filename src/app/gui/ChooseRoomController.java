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
import app.gui.ChooseLibraryController.*;

public class ChooseRoomController {

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
    private Button room1;
    @FXML
    private Button room2;
    @FXML
    private Button room3;
    @FXML
    private Button room4;
    @FXML
    private Button room5;
    @FXML
    private Button room6;
    @FXML
    private Button room7;
    @FXML
    private Button room8;
    @FXML
    private Button room9;

    private static String seatString = "";



    @FXML
    void initialize() throws IOException {
        String input = ChooseLibraryController.getRoomString();
        String[] str = input.split("#",9);

        room1.setText(str[0]);
        if(str[0].equals("Add Room")) room1.setDisable(true);

        room2.setText(str[1]);
        if(str[1].equals("Add Room")) room2.setDisable(true);

        room3.setText(str[2]);
        if(str[2].equals("Add Room")) room3.setDisable(true);

        room4.setText(str[3]);
        if(str[3].equals("Add Room")) room4.setDisable(true);

        room5.setText(str[4]);
        if(str[4].equals("Add Room")) room5.setDisable(true);

        room6.setText(str[5]);
        if(str[5].equals("Add Room")) room6.setDisable(true);

        room7.setText(str[6]);
        if(str[6].equals("Add Room")) room7.setDisable(true);

        room8.setText(str[7]);
        if(str[7].equals("Add Room")) room8.setDisable(true);

        room9.setText(str[8]);
        if(str[8].equals("Add Room")) room9.setDisable(true);
    }

    @FXML
    void handleClicksOnChooseRoom(ActionEvent event) throws Exception {
        handleDashboard(event);
        handleRoomButtons(event);
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

    private void handleRoomButtons(ActionEvent event) throws Exception{
        if(event.getSource() == room1){
            Socket s = new Socket("localhost", 8000);
            String command = "GetSeatList/" + room1.getText();

            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());

            dos.writeUTF(command);
            dos.flush();

            seatString = dis.readUTF();
            System.out.println(seatString);

            Parent chooseSeatParent = FXMLLoader.load(getClass().getResource("ChooseSeat.fxml"));
            Scene chooseSeatScene = new Scene(chooseSeatParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(chooseSeatScene);
            window.show();
        }

        else if(event.getSource()==room2){
            Socket s = new Socket("localhost", 8000);
            String command = "GetSeatList/" + room2.getText();

            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());

            dos.writeUTF(command);
            dos.flush();

            seatString = dis.readUTF();
            System.out.println(seatString);

            Parent chooseSeatParent = FXMLLoader.load(getClass().getResource("ChooseSeat.fxml"));
            Scene chooseSeatScene = new Scene(chooseSeatParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(chooseSeatScene);
            window.show();
        }

        else if(event.getSource()==room3){
            Socket s = new Socket("localhost", 8000);
            String command = "GetSeatList/" + room3.getText();

            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());

            dos.writeUTF(command);
            dos.flush();

            seatString = dis.readUTF();
            System.out.println(seatString);

            Parent chooseSeatParent = FXMLLoader.load(getClass().getResource("ChooseSeat.fxml"));
            Scene chooseSeatScene = new Scene(chooseSeatParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(chooseSeatScene);
            window.show();
        }

        else if(event.getSource()==room4){
            Socket s = new Socket("localhost", 8000);
            String command = "GetSeatList/" + room4.getText();

            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());

            dos.writeUTF(command);
            dos.flush();

            seatString = dis.readUTF();
            System.out.println(seatString);

            Parent chooseSeatParent = FXMLLoader.load(getClass().getResource("ChooseSeat.fxml"));
            Scene chooseSeatScene = new Scene(chooseSeatParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(chooseSeatScene);
            window.show();
        }

        else if(event.getSource()==room5){
            Socket s = new Socket("localhost", 8000);
            String command = "GetSeatList/" + room5.getText();

            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());

            dos.writeUTF(command);
            dos.flush();

            seatString = dis.readUTF();
            System.out.println(seatString);

            Parent chooseSeatParent = FXMLLoader.load(getClass().getResource("ChooseSeat.fxml"));
            Scene chooseSeatScene = new Scene(chooseSeatParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(chooseSeatScene);
            window.show();
        }

        else if(event.getSource()==room6){
            Socket s = new Socket("localhost", 8000);
            String command = "GetSeatList/" + room6.getText();

            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());

            dos.writeUTF(command);
            dos.flush();

            seatString = dis.readUTF();
            System.out.println(seatString);

            Parent chooseSeatParent = FXMLLoader.load(getClass().getResource("ChooseSeat.fxml"));
            Scene chooseSeatScene = new Scene(chooseSeatParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(chooseSeatScene);
            window.show();
        }

        else if(event.getSource()==room7){
            Socket s = new Socket("localhost", 8000);
            String command = "GetSeatList/" + room7.getText();

            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());

            dos.writeUTF(command);
            dos.flush();

            seatString = dis.readUTF();
            System.out.println(seatString);

            Parent chooseSeatParent = FXMLLoader.load(getClass().getResource("ChooseSeat.fxml"));
            Scene chooseSeatScene = new Scene(chooseSeatParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(chooseSeatScene);
            window.show();
        }

        else if(event.getSource()==room8){
            Socket s = new Socket("localhost", 8000);
            String command = "GetSeatList/" + room8.getText();

            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());

            dos.writeUTF(command);
            dos.flush();

            seatString = dis.readUTF();
            System.out.println(seatString);

            Parent chooseSeatParent = FXMLLoader.load(getClass().getResource("ChooseSeat.fxml"));
            Scene chooseSeatScene = new Scene(chooseSeatParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(chooseSeatScene);
            window.show();
        }

        else if(event.getSource()==room9){
            Socket s = new Socket("localhost", 8000);
            String command = "GetSeatList/" + room9.getText();

            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());

            dos.writeUTF(command);
            dos.flush();

            seatString = dis.readUTF();
            System.out.println(seatString);

            Parent chooseSeatParent = FXMLLoader.load(getClass().getResource("ChooseSeat.fxml"));
            Scene chooseSeatScene = new Scene(chooseSeatParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(chooseSeatScene);
            window.show();
        }
    }

    public static String getSeatString(){
        return seatString;
    }

}
