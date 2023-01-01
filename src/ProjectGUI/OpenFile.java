package ProjectGUI;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;

public class OpenFile implements Command {

	
	@Override
	public void execute() {
	/*	FileDialog fd = new FileDialog(gui.window,"Open",FileDialog.LOAD);
		fd.setVisible(true);
		
		if(fd.getFile() != null) {
			fileName = fd.getFile();
			fileAdress = fd.getDirectory();
			gui.window.setTitle(fileName);
		}
		
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(fileAdress + fileName));
			gui.textArea.setText(" ");
			
			String line = null;
			
			while((line = br.readLine()) != null ) {
				gui.textArea.append(line + "\n");
			}
			
			br.close();
			
		}catch(Exception e) {
			System.out.print("Cant Open");
		}*/
	}

}
