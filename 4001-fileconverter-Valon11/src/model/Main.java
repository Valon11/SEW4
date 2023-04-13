package model;

import controller.FileConverterController;
import controller.TrennzeichenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Main extends Application {
    private Stage primaryStage;
    private FileConverterController fileConverterController;
    private TrennzeichenController trennzeichenController;
    private String leseTrennzeichen;
    private String schreibeTrennzeichen;
    private boolean lesenSchreiben;
    private CSVReader csvReader;



    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        showFileConverterStage(this.primaryStage,this);
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void showFileConverterStage(Stage primaryStage,Main main) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("../view/fileConverter.fxml"));
        Parent root = fxmlLoader.load();

        fileConverterController = fxmlLoader.getController();
        fileConverterController.setMain(main);

        primaryStage.setTitle("File Converter");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void showTrennzeichenStage(Stage primaryStage,Main main) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("../view/trennzeichen.fxml"));
        Parent root = fxmlLoader.load();

        trennzeichenController = fxmlLoader.getController();
        trennzeichenController.setMain(main);

        Stage stage = new Stage();
        stage.setTitle("Trennzeichenfenster");
        stage.setScene(new Scene(root));

        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(primaryStage);

        stage.showAndWait();
    }

    public void convert(String importFile, String exportFile,String leseTrennzeichen,String schreibenTrennzeichen) throws IOException, ClassNotFoundException {
        HashMap<Integer, Schueler> schuelerHashMap;
        BinaryReader binaryReader= new BinaryReader();
        ObjectStreamReader objectReaderWriter= new ObjectStreamReader();
        csvReader= new CSVReader(leseTrennzeichen);
        CSVWriter csvWriter= new CSVWriter(schreibenTrennzeichen);
        BinaryWriter binaryWriter= new BinaryWriter();
        ObjectStreamWriter objectStreamWriter= new ObjectStreamWriter();

        if (importFile.endsWith(".csv")){
            schuelerHashMap = csvReader.read(importFile);
        } else if (importFile.endsWith(".dst")){
            schuelerHashMap= binaryReader.read(importFile);
        } else {
            schuelerHashMap = objectReaderWriter.read(importFile);
        }

        if (exportFile.endsWith(".csv")){
            csvWriter.write(schuelerHashMap, exportFile);
        } else if (exportFile.endsWith(".dst")){
            binaryWriter.write(schuelerHashMap, exportFile);
        } else {
            objectStreamWriter.write(schuelerHashMap, exportFile);
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public FileConverterController getFileConverterController() {
        return fileConverterController;
    }

    public TrennzeichenController getTrennzeichenController() {
        return trennzeichenController;
    }

    public String getLeseTrennzeichen() {
        return leseTrennzeichen;
    }

    public String getSchreibeTrennzeichen() {
        return schreibeTrennzeichen;
    }

    public void setLeseTrennzeichen(String leseTrennzeichen) {
        this.leseTrennzeichen = leseTrennzeichen;
    }

    public void setSchreibeTrennzeichen(String schreibeTrennzeichen) {
        this.schreibeTrennzeichen = schreibeTrennzeichen;
    }


    public CSVReader getCsvReader() {
        return csvReader;
    }

    public boolean isLesenSchreiben() {
        return lesenSchreiben;
    }

    public void setLesenSchreiben(boolean lesenSchreiben) {
        this.lesenSchreiben = lesenSchreiben;
    }

    public String getTrennzeichen(String file) throws IOException {
        String s;
        String trennzeichen = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            bufferedReader.readLine();
            s = bufferedReader.readLine();

            for (int i = 0; s.charAt(i) <= 57 && s.charAt(i) >= 48; i++) {
                trennzeichen = String.valueOf(s.charAt(i+1));

            }
        }
        return trennzeichen;
    }
}
