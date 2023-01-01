package ProjectGUI;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;

public class ExitFile implements Command {
	
	Functions function;
	
	public ExitFile(Functions function){
		this.function = function;
	}
	
	@Override
	public void execute() {
		function.exit();
	}
	

}
