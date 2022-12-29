package ProjectGUI;

import javax.swing.JFrame;

public class GUI {
	
	// jFrame icerisine buton vs koymamıza yarıyo
	JFrame window;

	public static void main(String[] args) {
		
		new GUI();
		
		
	}
	
	public GUI() {
		createWindow();
		window.setVisible(true);
	}
	
	public void createWindow() {
		
		window = new JFrame("notepad");
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
