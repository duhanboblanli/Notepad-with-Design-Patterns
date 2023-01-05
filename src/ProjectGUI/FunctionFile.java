package ProjectGUI;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;


public class FunctionFile implements Functions{
	
	GUI gui;
	FileDataOperations FileData = FileDataOperations.getInstance();
	// fields of information needed to save or open files
	
	
	// integration between Function File and GUI classes
	public FunctionFile(GUI gui) {
		FileDataOperations.getInstance();
		this.gui = gui;
	}
	
	// creates new text file with empty lines
	@Override
	public void newFile() {
		gui.textArea.setText("");
		gui.window.setTitle("New");
		FileData.SetNullFileNameAndAdress();
		
	}
	
	// open file and read file line by line
	@Override
	public void open() {
		FileDialog fd = new FileDialog(gui.window,"Open",FileDialog.LOAD);
		fd.setVisible(true);
		
		if(fd.getFile() != null) {
			FileData.SetFileNameAndAdress(fd.getFile(), fd.getDirectory());
			gui.window.setTitle(FileData.currentFileName);
		}
		
		try {
			
			// a class which reads text from a character-input stream
			// you need to address to read a file, fileAdress + fileName used for key
			BufferedReader br = new BufferedReader(new FileReader(FileData.currentFileAdress + FileData.currentFileName));
			gui.textArea.setText(" ");
			
			String line = null;
			
			// reads a line of text, if line not null then go on
			while((line = br.readLine()) != null ) {
				// appends the given text to the end of the document
				gui.textArea.append(line + "\n");
			}
			
			br.close();
			
		}catch(Exception e) {
			System.out.print("File Can't Open!");
		}
		
	}
	
	// update text file on window frame
	@Override
	public void save() {
		if(FileData.currentFileName == null) {
			saveAs();
		}
		else {
			try {
				//fileAdress + fileName used for key
				FileWriter fw = new FileWriter(FileData.currentFileAdress + FileData.currentFileName);
				fw.write(gui.textArea.getText());
				gui.window.setTitle(FileData.currentFileName);
				fw.close();
			}
			catch(Exception e) {
				System.out.print("SOMETHING WRONG");
			}
		}
	}
	
	// save file with given directory and fileName
	@Override
	public void saveAs() {
		FileDialog fd = new FileDialog(gui.window,"Save",FileDialog.SAVE);
		fd.setVisible(true);
		
		if(fd.getFile() != null) {
			FileData.SetFileNameAndAdress(fd.getFile(), fd.getDirectory());
			gui.window.setTitle(FileData.currentFileName);
		}
		
		try {
			//fileAdress + fileName used for key
			FileWriter fw = new FileWriter(FileData.currentFileAdress + FileData.currentFileName);
			fw.write(gui.textArea.getText());
			fw.close();
			
		}catch(Exception e) {
			System.out.print("SOMETHING WRONG");
		}
		
	}
	
	@Override
	public void exit() {
		System.exit(0);
	}
	
	@Override
	public void undo() {
		gui.um.undo();
	}
	
	@Override
	public void redo() {
		gui.um.redo();
	}

}
