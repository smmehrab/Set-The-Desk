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
import javafx.stage.Stage;

import javax.print.attribute.standard.MediaSize;

public class FindBookController {

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
    private Button a;

    @FXML
    private Button b;

    @FXML
    private Button c;

    @FXML
    private Button d;

    @FXML
    private Button e;

    @FXML
    private Button f;

    @FXML
    private Button g;

    @FXML
    private Button h;

    @FXML
    private Button i;

    @FXML
    private Button j;

    @FXML
    private Button k;

    @FXML
    private Button l;

    @FXML
    private Button m;

    @FXML
    private Button n;

    @FXML
    private Button o;

    @FXML
    private Button p;

    @FXML
    private Button q;

    @FXML
    private Button r;

    @FXML
    private Button s;

    @FXML
    private Button t;

    @FXML
    private Button w;

    @FXML
    private Button x;

    @FXML
    private Button y;

    @FXML
    private Button z;

    @FXML
    private Button others;

    private static String bookNames = "";

    @FXML
    void initialize() {

    }

    @FXML
    void handleClicksOnFindBook(ActionEvent event) throws Exception {
        handleDashboard(event);
        handleAlphabetButtons(event);
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

    private void handleAlphabetButtons(ActionEvent event) throws Exception{
        if(event.getSource()== a){
            Socket s = new Socket("localhost", 8000);
            String command =  "A";

            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());

            dos.writeUTF(command);
            dos.flush();

            bookNames = dis.readUTF();
            System.out.println(bookNames);

            Parent chooseSeatParent = FXMLLoader.load(getClass().getResource("ChooseBook.fxml"));
            Scene chooseSeatScene = new Scene(chooseSeatParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(chooseSeatScene);
            window.show();
        }

        else if(event.getSource()== b){
            Socket s = new Socket("localhost", 8000);
            String command =  "B";

            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());

            dos.writeUTF(command);
            dos.flush();

            bookNames = dis.readUTF();
            System.out.println(bookNames);

            Parent chooseSeatParent = FXMLLoader.load(getClass().getResource("ChooseBook.fxml"));
            Scene chooseSeatScene = new Scene(chooseSeatParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(chooseSeatScene);
            window.show();
        }

        else if(event.getSource()== c){
            Socket s = new Socket("localhost", 8000);
            String command =  "C";

            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());

            dos.writeUTF(command);
            dos.flush();

            bookNames = dis.readUTF();
            System.out.println(bookNames);

            Parent chooseSeatParent = FXMLLoader.load(getClass().getResource("ChooseBook.fxml"));
            Scene chooseSeatScene = new Scene(chooseSeatParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(chooseSeatScene);
            window.show();
        }

        else if(event.getSource()== d){
            Socket s = new Socket("localhost", 8000);
            String command =  "D";

            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());

            dos.writeUTF(command);
            dos.flush();

            bookNames = dis.readUTF();
            System.out.println(bookNames);

            Parent chooseSeatParent = FXMLLoader.load(getClass().getResource("ChooseBook.fxml"));
            Scene chooseSeatScene = new Scene(chooseSeatParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(chooseSeatScene);
            window.show();
        }

        else if(event.getSource()== e){
            Socket s = new Socket("localhost", 8000);
            String command =  "E";

            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());

            dos.writeUTF(command);
            dos.flush();

            bookNames = dis.readUTF();
            System.out.println(bookNames);

            Parent chooseSeatParent = FXMLLoader.load(getClass().getResource("ChooseBook.fxml"));
            Scene chooseSeatScene = new Scene(chooseSeatParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(chooseSeatScene);
            window.show();
        }

        else if(event.getSource()== f){
            Socket s = new Socket("localhost", 8000);
            String command =  "F";

            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());

            dos.writeUTF(command);
            dos.flush();

            bookNames = dis.readUTF();
            System.out.println(bookNames);

            Parent chooseSeatParent = FXMLLoader.load(getClass().getResource("ChooseBook.fxml"));
            Scene chooseSeatScene = new Scene(chooseSeatParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(chooseSeatScene);
            window.show();
        }

        else if(event.getSource()== g){
            Socket s = new Socket("localhost", 8000);
            String command =  "G";

            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());

            dos.writeUTF(command);
            dos.flush();

            bookNames = dis.readUTF();
            System.out.println(bookNames);

            Parent chooseSeatParent = FXMLLoader.load(getClass().getResource("ChooseBook.fxml"));
            Scene chooseSeatScene = new Scene(chooseSeatParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(chooseSeatScene);
            window.show();
        }

        else if(event.getSource()== h){
            Socket s = new Socket("localhost", 8000);
            String command =  "H";

            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());

            dos.writeUTF(command);
            dos.flush();

            bookNames = dis.readUTF();
            System.out.println(bookNames);

            Parent chooseSeatParent = FXMLLoader.load(getClass().getResource("ChooseBook.fxml"));
            Scene chooseSeatScene = new Scene(chooseSeatParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(chooseSeatScene);
            window.show();
        }

        else if(event.getSource()== i){
            Socket s = new Socket("localhost", 8000);
            String command =  "I";

            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());

            dos.writeUTF(command);
            dos.flush();

            bookNames = dis.readUTF();
            System.out.println(bookNames);

            Parent chooseSeatParent = FXMLLoader.load(getClass().getResource("ChooseBook.fxml"));
            Scene chooseSeatScene = new Scene(chooseSeatParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(chooseSeatScene);
            window.show();
        }

        else if(event.getSource()== j){
            Socket s = new Socket("localhost", 8000);
            String command =  "J";

            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());

            dos.writeUTF(command);
            dos.flush();

            bookNames = dis.readUTF();
            System.out.println(bookNames);

            Parent chooseSeatParent = FXMLLoader.load(getClass().getResource("ChooseBook.fxml"));
            Scene chooseSeatScene = new Scene(chooseSeatParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(chooseSeatScene);
            window.show();
        }

        else if(event.getSource()== k){
            Socket s = new Socket("localhost", 8000);
            String command =  "K";

            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());

            dos.writeUTF(command);
            dos.flush();

            bookNames = dis.readUTF();
            System.out.println(bookNames);

            Parent chooseSeatParent = FXMLLoader.load(getClass().getResource("ChooseBook.fxml"));
            Scene chooseSeatScene = new Scene(chooseSeatParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(chooseSeatScene);
            window.show();
        }

        else if(event.getSource()== l){
            Socket s = new Socket("localhost", 8000);
            String command =  "L";

            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());

            dos.writeUTF(command);
            dos.flush();

            bookNames = dis.readUTF();
            System.out.println(bookNames);

            Parent chooseSeatParent = FXMLLoader.load(getClass().getResource("ChooseBook.fxml"));
            Scene chooseSeatScene = new Scene(chooseSeatParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(chooseSeatScene);
            window.show();
        }

        else if(event.getSource()== m){
            Socket s = new Socket("localhost", 8000);
            String command =  "M";

            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());

            dos.writeUTF(command);
            dos.flush();

            bookNames = dis.readUTF();
            System.out.println(bookNames);

            Parent chooseSeatParent = FXMLLoader.load(getClass().getResource("ChooseBook.fxml"));
            Scene chooseSeatScene = new Scene(chooseSeatParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(chooseSeatScene);
            window.show();
        }

        else if(event.getSource()== n){
            Socket s = new Socket("localhost", 8000);
            String command =  "N";

            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());

            dos.writeUTF(command);
            dos.flush();

            bookNames = dis.readUTF();
            System.out.println(bookNames);

            Parent chooseSeatParent = FXMLLoader.load(getClass().getResource("ChooseBook.fxml"));
            Scene chooseSeatScene = new Scene(chooseSeatParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(chooseSeatScene);
            window.show();
        }

        else if(event.getSource()== o){
            Socket s = new Socket("localhost", 8000);
            String command =  "O";

            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());

            dos.writeUTF(command);
            dos.flush();

            bookNames = dis.readUTF();
            System.out.println(bookNames);

            Parent chooseSeatParent = FXMLLoader.load(getClass().getResource("ChooseBook.fxml"));
            Scene chooseSeatScene = new Scene(chooseSeatParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(chooseSeatScene);
            window.show();
        }


        else if(event.getSource()== p){
            Socket s = new Socket("localhost", 8000);
            String command =  "P";

            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());

            dos.writeUTF(command);
            dos.flush();

            bookNames = dis.readUTF();
            System.out.println(bookNames);

            Parent chooseSeatParent = FXMLLoader.load(getClass().getResource("ChooseBook.fxml"));
            Scene chooseSeatScene = new Scene(chooseSeatParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(chooseSeatScene);
            window.show();
        }

        else if(event.getSource()== q){
            Socket s = new Socket("localhost", 8000);
            String command =  "Q";

            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());

            dos.writeUTF(command);
            dos.flush();

            bookNames = dis.readUTF();
            System.out.println(bookNames);

            Parent chooseSeatParent = FXMLLoader.load(getClass().getResource("ChooseBook.fxml"));
            Scene chooseSeatScene = new Scene(chooseSeatParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(chooseSeatScene);
            window.show();
        }

        else if(event.getSource()== r){
            Socket s = new Socket("localhost", 8000);
            String command =  "R";

            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());

            dos.writeUTF(command);
            dos.flush();

            bookNames = dis.readUTF();
            System.out.println(bookNames);

            Parent chooseSeatParent = FXMLLoader.load(getClass().getResource("ChooseBook.fxml"));
            Scene chooseSeatScene = new Scene(chooseSeatParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(chooseSeatScene);
            window.show();
        }

        else if(event.getSource()== s){
            Socket s = new Socket("localhost", 8000);
            String command =  "S";

            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());

            dos.writeUTF(command);
            dos.flush();

            bookNames = dis.readUTF();
            System.out.println(bookNames);

            Parent chooseSeatParent = FXMLLoader.load(getClass().getResource("ChooseBook.fxml"));
            Scene chooseSeatScene = new Scene(chooseSeatParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(chooseSeatScene);
            window.show();
        }

        else if(event.getSource()== t){
            Socket s = new Socket("localhost", 8000);
            String command =  "T";

            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());

            dos.writeUTF(command);
            dos.flush();

            bookNames = dis.readUTF();
            System.out.println(bookNames);

            Parent chooseSeatParent = FXMLLoader.load(getClass().getResource("ChooseBook.fxml"));
            Scene chooseSeatScene = new Scene(chooseSeatParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(chooseSeatScene);
            window.show();
        }

        else if(event.getSource()== w){
            Socket s = new Socket("localhost", 8000);
            String command =  "W";

            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());

            dos.writeUTF(command);
            dos.flush();

            bookNames = dis.readUTF();
            System.out.println(bookNames);

            Parent chooseSeatParent = FXMLLoader.load(getClass().getResource("ChooseBook.fxml"));
            Scene chooseSeatScene = new Scene(chooseSeatParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(chooseSeatScene);
            window.show();
        }

        else if(event.getSource()== x){
            Socket s = new Socket("localhost", 8000);
            String command =  "X";

            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());

            dos.writeUTF(command);
            dos.flush();

            bookNames = dis.readUTF();
            System.out.println(bookNames);

            Parent chooseSeatParent = FXMLLoader.load(getClass().getResource("ChooseBook.fxml"));
            Scene chooseSeatScene = new Scene(chooseSeatParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(chooseSeatScene);
            window.show();
        }

        else if(event.getSource()== y){
            Socket s = new Socket("localhost", 8000);
            String command =  "Y";

            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());

            dos.writeUTF(command);
            dos.flush();

            bookNames = dis.readUTF();
            System.out.println(bookNames);

            Parent chooseSeatParent = FXMLLoader.load(getClass().getResource("ChooseBook.fxml"));
            Scene chooseSeatScene = new Scene(chooseSeatParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(chooseSeatScene);
            window.show();
        }

        else if(event.getSource()== z){
            Socket s = new Socket("localhost", 8000);
            String command =  "Z";

            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());

            dos.writeUTF(command);
            dos.flush();

            bookNames = dis.readUTF();
            System.out.println(bookNames);

            Parent chooseSeatParent = FXMLLoader.load(getClass().getResource("ChooseBook.fxml"));
            Scene chooseSeatScene = new Scene(chooseSeatParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(chooseSeatScene);
            window.show();
        }

        else if(event.getSource()== others){
            Socket s = new Socket("localhost", 8000);
            String command =  "*";

            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());

            dos.writeUTF(command);
            dos.flush();

            bookNames = dis.readUTF();
            System.out.println(bookNames);

            Parent chooseSeatParent = FXMLLoader.load(getClass().getResource("ChooseBook.fxml"));
            Scene chooseSeatScene = new Scene(chooseSeatParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(chooseSeatScene);
            window.show();
        }
    }

    public static String getBookNames(){
        return bookNames;
    }
}
