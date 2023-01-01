package ProjectGUI;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;

public class SaveAsFile implements Command {
	
	Functions function;
	
	public SaveAsFile(Functions function){
		this.function = function;
	}
	
	@Override
	public void execute() {
		function.saveAs();
	}
	

}
