package ProjectGUI;

interface wordWARPing {
    void wrapWord(GUI gui);
    }

    class doWrap implements wordWARPing{

        @Override
        public void wrapWord(GUI gui) {
            gui.wordWrapOn = true;
            gui.textArea.setLineWrap(true);
            gui.textArea.setWrapStyleWord(true);
            gui.iWrap.setText("Word Wrap: On");
        }

    }
    class dontWrap implements wordWARPing{

        @Override
        public void wrapWord(GUI gui) {
            gui.wordWrapOn = false;
            gui.textArea.setLineWrap(false);
            gui.textArea.setWrapStyleWord(false);
            gui.iWrap.setText("Word Wrap: Off");
        }
    }

