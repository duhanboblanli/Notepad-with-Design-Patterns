package ProjectGUI;

import java.awt.Font;

public class FileDataOperations {
	 // Static variable reference of single_instance
    // of type Singleton
    private static FileDataOperations single_instance = null;
  
    // Declaring a variable of type String
    public String currentFileName;
	public String currentFileAdress;
	public String currentColor;
	
	public void SetNullFileNameAndAdress() {
		currentFileName = null;
		currentFileAdress = null;
	}
	
	public void SetFileNameAndAdress(String currentFileName, String currentFileAdress) {
		this.currentFileAdress = currentFileAdress;
		this.currentFileName = currentFileName;
	}
	
  
    // Constructor
    // Here we will be creating private constructor
    // restricted to this class itself
    private FileDataOperations()
    {
        
    }
  
    // Static method
    // Static method to create instance of Singleton class
    public static FileDataOperations getInstance()
    {
        if (single_instance == null)
            single_instance = new FileDataOperations();
  
        return single_instance;
    }

}
