package analyser.model;

import javafx.beans.property.StringProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;


public class FileNames {

	private final StringProperty FileName;		// 2011/08/10 09:46:59.607825
    private final LongProperty FileSize;			// 1.026539	
    private final StringProperty FilePath;			// 1.026539	
	
   
    /**
     * Default constructor.
     */
    public FileNames() {
        this(null,0,null);
    }
    
    /**
     * Constructor with some initial data.
     * 
     * @param FileName
     * @param Size
     * @param Path
     */
    public FileNames(String FileName, long FileSize, String FilePath) {
        this.FileName = new SimpleStringProperty(FileName);
        this.FileSize = new SimpleLongProperty(FileSize);
        this.FilePath = new SimpleStringProperty(FilePath);
        
        //Get more info from File
    }
    
    public String getFileName() {
        return  FileName.get();
    }
    
    public String getFilePath() {
        return  FilePath.get();
    }
    
    public long getFileSize() {
        return  FileSize.get();
    }

    public void setFileName(String  fileNames) {
        this.FileName.set(fileNames);
    }
    
    public void setFilePath(String  filePath) {
        this.FilePath.set(filePath);
    }
    
    public void setFileSize(Long  fileSize) {
        this.FileSize.set(fileSize);
    }
    
   

    public StringProperty FileNameProperty() {
        return FileName;
    }
    
    public LongProperty FileSizeProperty() {
        return FileSize;
    }
    
    public StringProperty FilePathProperty() {
        return FilePath;
    }
	
}
