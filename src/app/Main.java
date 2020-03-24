package app;

import app.library.Library;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import app.books.Book;
import app.library.Library;
import app.seats.Seat;
import app.users.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage window) throws Exception {
        runGui(window);
    }


    public static void main(String[] args) {
        launch(args);
    }

    private void runGui(Stage window) throws Exception{
        Parent loginParent = FXMLLoader.load(getClass().getResource("gui/Login.fxml"));
        window.setTitle("Set The Desk");
        window.setScene(new Scene(loginParent));
        window.show();
    }
}

/*
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Library lib = new Library("Central Library");

    }
}
 */