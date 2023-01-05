package ProjectGUI;

import java.awt.*;

public class FunctionFormatBuilder {  // builder takes resource gui,font font goes to Funct_format
    public GUI gui;
    public Font font;
    public FunctionFormatBuilder(GUI gui) {
        this.gui = gui;
    }
    public FunctionFormatBuilder setFontType(String fontType) {  // to Change fontType
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