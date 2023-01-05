package ProjectGUI;

import java.awt.Font;

public class Function_Format {
	private GUI gui;
	private Font font;

	public Function_Format(FunctionFormatBuilder builder) {
		this.gui = builder.gui;
		this.font = builder.font;
	}

	public void wordWrap() {
		// word_wrap functionality, on off statements controlled
		if (gui.wordWrapOn == false) {
			gui.wordWrapOn = true;
			gui.textArea.setLineWrap(true);
			gui.textArea.setWrapStyleWord(true);
			gui.iWrap.setText("Word Wrap: On");
		} else if (gui.wordWrapOn == true) {
			gui.wordWrapOn = false;
			gui.textArea.setLineWrap(false);
			gui.textArea.setWrapStyleWord(false);
			gui.iWrap.setText("Word Wrap: Off");
		}
	}

	public void setFontType(String fontType) {
		font = new Font(fontType, font.getStyle(), font.getSize());
		gui.textArea.setFont(font);
	}

	public void setFontSize(int fontSize) {
		font = new Font(font.getName(), font.getStyle(), fontSize);
		gui.textArea.setFont(font);
	}

}