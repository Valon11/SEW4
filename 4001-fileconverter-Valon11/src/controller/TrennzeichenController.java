package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Main;

import java.io.IOException;

public class TrennzeichenController {
    private Main main;
    private String importField;
    private String exportField;


    @FXML
    private TextField trennzeichenTF;

    @FXML
    private Label trennzeichenLabel;

    @FXML
    private Button confirmButton;

    @FXML
    void confirmTrennzeichen(ActionEvent event) throws IOException, ClassNotFoundException {
        main.setSchreibeTrennzeichen(trennzeichenTF.getText());

        main.convert(main.getFileConverterController().getImportFile(), main.getFileConverterController().getExportFile(),
                main.getTrennzeichen(main.getFileConverterController().getImportFile()), main.getSchreibeTrennzeichen());
        Stage s = (Stage) trennzeichenTF.getScene().getWindow();
        s.close();
    }

    public String getImportField() {
        return importField;
    }

    public void setImportField(String importField) {
        this.importField = importField;
    }

    public String getExportField() {
        return exportField;
    }

    public void setExportField(String exportField) {
        this.exportField = exportField;
    }

    public void setMain(Main main) {
        this.main = main;
    }


}
