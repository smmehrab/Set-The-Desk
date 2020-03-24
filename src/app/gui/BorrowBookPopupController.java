package app.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BorrowBookPopupController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button confirmBtn;

    @FXML
    private Button cancelBtn;

    @FXML
    void handleClicksOnBorrowBookPopup(ActionEvent event) {
        if(event.getSource()==cancelBtn){
            Stage stage = (Stage) cancelBtn.getScene().getWindow();
            stage.close();
        }

        else if(event.getSource()==confirmBtn){
            Stage stage = (Stage) confirmBtn.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    void initialize() {
    }
}
