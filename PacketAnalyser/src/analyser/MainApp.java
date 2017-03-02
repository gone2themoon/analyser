package analyser;

	import javafx.application.Application;
	import javafx.collections.FXCollections;
	import javafx.collections.ObservableList;
	import javafx.stage.Stage;
	import javafx.fxml.FXMLLoader;
	import javafx.scene.Scene;
	import javafx.scene.control.Alert;
	import javafx.scene.control.Alert.AlertType;
	import javafx.scene.layout.AnchorPane;
	import javafx.scene.layout.BorderPane;
	
	import java.io.*;
	import java.io.File;
	import java.util.logging.Level;
	import java.util.logging.Logger;
	import java.util.prefs.Preferences;

import analyser.model.FileNames;
import analyser.model.Packet;
	import analyser.util.FileRead;
	import analyser.util.ReadStringFromFile;
	import analyser.view.PacketOverviewController;

	
	public class MainApp extends Application{
		
		private Stage primaryStage;
	    private BorderPane rootLayout;
	    
	    /**
	     * The data as an observable list of Packets.
	     */
	    private ObservableList<Packet> packetData = FXCollections.observableArrayList();
	    
	    /**
	     * The data as an observable list of FileNames.
	     */
	    private ObservableList<FileNames> fileNameData = FXCollections.observableArrayList();

	    /**
	     * Constructor
	     */
	    public MainApp() {
	        // Add some sample data
	    //	fileNameData.add(new FileNames("ReadMe.txt", 0, null));
	    //	fileNameData.add(new FileNames("ReadasdMe.txt"));
	    //	fileNameData.add(new FileNames("ReaasddMe.txt"));
	    //	fileNameData.add(new FileNames("RedfdadMe.txt"));
	    //	fileNameData.add(new FileNames("RecvbadMe.txt"));
	    //	fileNameData.add(new FileNames("ReasdadMe.txt"));
	    	
	    	
	  //  	packetData.add(new Packet("2013/08/10 09:46:59.607825", "1.026539"));
	  //  	packetData.add(new Packet("2041/08/10 09:47:59.607825", "2.026539"));
	  //  	packetData.add(new Packet("2051/08/10 09:48:59.607825", "3.026539"));
	  //  	packetData.add(new Packet("2061/08/10 09:49:59.607825", "4.026539"));
	  //  	packetData.add(new Packet("2071/08/10 09:41:59.607825", "5.026539"));
	  //  	packetData.add(new Packet("2017/08/10 09:42:59.607825", "6.026539"));
	  // 	packetData.add(new Packet("2016/08/10 09:43:59.607825", "7.026539"));
	  //  	packetData.add(new Packet("2013/08/10 09:44:59.607825", "8.026539"));
	  //  	packetData.add(new Packet("2012/08/10 09:45:59.607825", "9.026539"));
	    }

	    /**
	     * Returns the data as an observable list of Persons. 
	     * @return
	     */
	    //public ObservableList<Packet> getPacketData() {
	    //    return packetData;
	        
	    public ObservableList<FileNames> getFileNamesData() {
		        return fileNameData;
	    }

	    public void start(Stage primaryStage) {
	        this.primaryStage = primaryStage;
	        this.primaryStage.setTitle("Analyser");
	    
	        initRootLayout();
	        showPacketOverview();
	        
	    }

	    public static void main(String[] args) {
			// TODO Auto-generated method stub
			launch(args);
			//FileRead.main(args);
			//**ReadStringFromFile readStringFromFile = new ReadStringFromFile();
			//ReadStringFromFile.main(args);		
		}
	
	    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	    public void showPacketOverview() {
        try {
            // Load Packet overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/PacketOverview.fxml"));
            AnchorPane packetOverview = (AnchorPane) loader.load();

            // Set Packet Overview into the center of root layout.
            rootLayout.setCenter(packetOverview);
            
         // Give the controller access to the main app.
            PacketOverviewController controller = loader.getController();
            controller.setMainApp(this);

            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	    
	    public void showPacketAnalysis() {
	        try {
	            // Load Packet overview.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(MainApp.class.getResource("view/PacketAnalysis.fxml"));
	            AnchorPane packetAnalysis = (AnchorPane) loader.load();

	            // Set Packet Overview into the center of root layout.
	            rootLayout.setCenter(packetAnalysis);
	            
	         // Give the controller access to the main app.
	         //   PacketOverviewController controller = loader.getController();
	         //   controller.setMainApp(this);

	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	
	    public Stage getPrimaryStage() {
        return primaryStage;
	    }
        
	    /**
         * Loads Packet data from the specified file. The current packet data will
         * be replaced.
         * 
         * @param file
         */
        public void loadPacketDataFromFile(File file) {
            try {
                           
                // Save the file path to the registry.
                setPacketFilePath(file);
                
                // Add File Name to the List - FileNameColumns
                fileNameData.add(new FileNames(file.getName(),file.length(),file.getPath()));
                System.out.println(file.getName());
                System.out.println(file.length());
                System.out.println(file.getPath());
                
                //fileNameData.add("one");
                
            } catch (Exception e) { // catches ANY exception
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Could not load data");
                alert.setContentText("Could not load data from file:\n" + file.getPath());

                alert.showAndWait();
            }
        }
        
        /**
         * Returns the Packet file preference, i.e. the file that was last opened.
         * The preference is read from the OS specific registry. If no such
         * preference can be found, null is returned.
         * 
         * @return
         */
        public File getPacketFilePath() {
            Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
            String filePath = prefs.get("filePath", null);
            if (filePath != null) {
                return new File(filePath);
            } else {
                return null;
            }
        }
        
        /**
         * Sets the file path of the currently loaded file. The path is persisted in
         * the OS specific registry.
         * 
         * @param file the file or null to remove the path
         */
	    public void setPacketFilePath(File file) {
	        Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
	        if (file != null) {
	            prefs.put("filePath", file.getPath());

	            // Update the stage title.
	            primaryStage.setTitle("Analyse - " + file.getName());
	        } else {
	            prefs.remove("filePath");

	            // Update the stage title.
	            primaryStage.setTitle("AddressApp");
	        }
	    }
	    
	    public static String humanReadableByteCount(long bytes, boolean si) {
		    int unit = si ? 1000 : 1024;
		    if (bytes < unit) return bytes + " B";
		    int exp = (int) (Math.log(bytes) / Math.log(unit));
		    String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp-1) + (si ? "" : "i");
		    return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
		}

}
