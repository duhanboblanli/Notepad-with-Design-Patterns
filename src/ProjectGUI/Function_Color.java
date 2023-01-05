package ProjectGUI;

import java.awt.Color;

public class Function_Color {
	
	GUI gui;
	
	public Function_Color(GUI gui) {
		this.gui= gui;
	}
	
	public void changeColor(String color) {
		
		switch(color) {
		case "White":
			gui.ChangeTextAndBackColor(Color.white, Color.white, Color.black);
			break;
		case "Black":
			gui.ChangeTextAndBackColor(Color.black, Color.black, Color.white);
			break;
		case "Blue":
			gui.ChangeTextAndBackColor(new Color(28,186,186), new Color(28,186,186), Color.white);
			break;
		}
	}

}
