package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Main;

import java.io.File;
import java.io.IOException;

public class FileConverterController {
    private Main  main = new Main();
    private String importFile;
    private String exportFile;

    @FXML
    private Label fileConverterLabel;

    @FXML
    private Button chooseFileButton;

    @FXML
    private Button convertButton;

    @FXML
    private Button saveFileButton;

    @FXML
    private TextField chooseFileTF;

    @FXML
    private TextField saveFileTF;


    @FXML
    void chooseFile(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        Stage stage = (Stage) chooseFileTF.getScene().getWindow();

        fileChooser.setTitle(("Copy from File"));
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Alle Dateien","*.csv","*.dst","*.ost"),
                new FileChooser.ExtensionFilter(".csv","*.csv"),
                new FileChooser.ExtensionFilter(".dst","*.dst"),
                new FileChooser.ExtensionFilter(".ost","*.ost"));

        File selectedFileFrom = fileChooser.showOpenDialog(stage);
        chooseFileTF.setText(selectedFileFrom.getName());
        importFile = chooseFileTF.getText();
        if(chooseFileTF.getText().endsWith(".csv")){

            System.out.println();
            main.setLesenSchreiben(true);
        }
    }

    @FXML
    void convertFile(ActionEvent event) throws IOException, ClassNotFoundException {
        if(chooseFileTF.getText().endsWith(".csv") || saveFileTF.getText().endsWith(".csv")){
            main.showTrennzeichenStage(main.getPrimaryStage(),main);
        }else{
            main.convert(chooseFileTF.getText(),saveFileTF.getText(),null,null);
        }
    }


    @FXML
    void saveFile(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        Stage stage = (Stage) chooseFileTF.getScene().getWindow();

        fileChooser.setTitle(("Copy to File"));
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter(".csv","*.csv"),
                new FileChooser.ExtensionFilter(".dst","*.dst"),
                new FileChooser.ExtensionFilter(".ost","*.ost"));

        File selectedFileTo = fileChooser.showSaveDialog(stage);
        saveFileTF.setText(selectedFileTo.getName());
        exportFile = saveFileTF.getText();
        if(saveFileTF.getText().endsWith(".csv")){
            main.setLesenSchreiben(false);
        }
    }

    public void setMain(Main main)

    {
        this.main = main;
    }

    public String getImportFile() {
        return importFile;
    }

    public String getExportFile() {
        return exportFile;
    }


}
