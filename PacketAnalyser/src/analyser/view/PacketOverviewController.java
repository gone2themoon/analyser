package analyser.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;

import analyser.MainApp;
import analyser.model.FileNames;
import analyser.model.Packet;



public class PacketOverviewController {

	@FXML
    private TableView<Packet> packetTable;
	
	@FXML
    private TableView<FileNames> fileNamesTable;
   
    @FXML
    private TableColumn<FileNames, String> fileNameColumn;
    
    @FXML
    private Label fileSize;
    @FXML
    private Label filePath;
    @FXML
    private Label fileName;
    
    /**
     * Opens a FileChooser to let the user select a Packet File to load.
     */
    @FXML
    private void handleOpen() {
        FileChooser fileChooser = new FileChooser();

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "Txt files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show open file dialog
        File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());

        // Pass file to loadPacketDataFromFile if not Null
        if (file != null) {
        	mainApp.loadPacketDataFromFile(file);
        }
    }
    
    //
    @FXML
    private void handleAnalyse() {
    	 
    	 
    	 int selectedIndex = fileNamesTable.getSelectionModel().getSelectedIndex();
         if (selectedIndex >= 0) {
        	 System.out.println("Send Selected file to be analysed: " + "filenamehere");
        	 System.out.println(fileNamesTable.getSelectionModel());
        	 mainApp.showPacketAnalysis();
         } else {
             // Nothing selected.
             Alert alert = new Alert(AlertType.WARNING);
             alert.initOwner(mainApp.getPrimaryStage());
             alert.setTitle("No Selection");
             alert.setHeaderText("No Packet File Selected");
             alert.setContentText("Please select a Packet File in the table.");

             alert.showAndWait();
             
        }
         
    }
        
    
    //
    

    /**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private void handleDelete() {
        int selectedIndex = fileNamesTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            fileNamesTable.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Packet File Selected");
            alert.setContentText("Please select a Packet File in the table.");

            alert.showAndWait();
        }
    }
    
    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public PacketOverviewController() {
    }
    
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the FileName table with single Column.
        fileNameColumn.setCellValueFactory(cellData -> cellData.getValue().FileNameProperty());
        
        // Clear File details.
        showFileDetails(null);
        
        // Listen for selection changes and show the person details when changed.
        fileNamesTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showFileDetails(newValue));
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        fileNamesTable.setItems(mainApp.getFileNamesData());
    }

    private void showFileDetails(FileNames fileNames) {
        if (fileNames != null) {
            // Fill the labels with info from the FileName object.
        	fileSize.setText(MainApp.humanReadableByteCount(fileNames.getFileSize(), true));
        	filePath.setText(fileNames.getFilePath());
        	fileName.setText(fileNames.getFileName());
      
        } else {
            // FileName is null, remove all the text.
        	fileSize.setText("");
        	filePath.setText("");
            fileName.setText("");
           
        }
    }

	

    
    
}
