package ProjectGUI;

import java.awt.Font;

public class Function_Format {
	private GUI gui;
	private Font font;

	private Function_Format(FunctionFormatBuilder builder) {
		this.gui = builder.gui;
		this.font = builder.font;

	}

	public static class FunctionFormatBuilder {
		private GUI gui;
		private Font font;

		public FunctionFormatBuilder(GUI gui) {
			this.gui = gui;
		}

		public FunctionFormatBuilder setFontType(String fontType) {
			if (font == null) {
				font = new Font(fontType, Font.PLAIN, 14);
			} else {
				font = new Font(fontType, font.getStyle(), font.getSize());
			}
			return this;
		}
		public Function_Format build() {
			return new Function_Format(this);
		}

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

	// Other methods go here
}