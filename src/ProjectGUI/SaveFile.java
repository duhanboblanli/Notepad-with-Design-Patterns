package ProjectGUI;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;

public class SaveFile implements Command {
	
	Functions function;
	
	public SaveFile(Functions function){
		this.function = function;
	}
	
	@Override
	public void execute() {
		function.save();
	}
	

}
