package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;

public class Controller {

    @FXML
    private TextField requestTF;

    @FXML
    private Button submitB;

    @FXML
    private WebView websiteWV;

    @FXML
    void submit(ActionEvent event) {
        websiteWV.getEngine().load(requestTF.getText());
    }

}

