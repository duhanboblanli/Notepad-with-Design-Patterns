package ProjectGUI;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;

public class NewFile implements Command {
	
	Functions function;
	
	public NewFile(Functions function){
		this.function = function;
	}
	
	@Override
	public void execute() {
		function.newFile();
	}
	

}