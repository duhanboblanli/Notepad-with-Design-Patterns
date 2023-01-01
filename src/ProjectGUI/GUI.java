package ProjectGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.undo.UndoManager;

public class GUI implements ActionListener {
	
	// used to edit jFrame window(e.g. adding a button)
	public JFrame window;
	// multi-line area that displays plain text
	public JTextArea textArea;
	// to add scrolling functionality on window frame 
	public JScrollPane scrollPane;
	// to add topMenuBar
	public JMenuBar menuBar;
	public JMenu fileMenu , menuEdit, menuFormat, menuColor;
	// these items can be added to topMenuBar
	public JMenuItem itemNew, itemOpen, itemSave, itemSaveAs, itemExit;
	
/*	public JMenuItem iUndo, iRedo;
	
	UndoManager um = new UndoManager();*/
	
	// integration between Function File and GUI classes
	FunctionFile funcs = new FunctionFile(this);
	
	Command openCommand = new OpenFile(funcs);
	Command newCommand = new NewFile(funcs);
	Command exitCommand = new ExitFile(funcs);
	Command SaveAsCommand = new SaveAsFile(funcs);
	Command SaveCommand = new SaveFile(funcs);
	
	CommandButton button = new CommandButton(openCommand,newCommand,SaveCommand,SaveAsCommand,exitCommand);
	
	
	public static void main(String[] args) {
		new GUI();
	}
	
	// empty constructor method
	public GUI() {
		
		createWindow();
		createTextArea();
		createMenuBar();
		createFileMenu();
		window.setVisible(true);
	}
	
	public void createWindow() {
		
		window = new JFrame("Notepad");
		window.setSize(800,600);
		// press 'X' button to close window
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void createTextArea() {
		textArea = new JTextArea();
		scrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// clear frame border
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		window.add(scrollPane);
	}
	
	public void createMenuBar() {
		menuBar = new JMenuBar();
		window.setJMenuBar(menuBar);
		
		fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		menuEdit = new JMenu("Edit");
		menuBar.add(menuEdit);

		menuFormat = new JMenu("Format");
		menuBar.add(menuFormat);
		
		menuColor = new JMenu("Color");
		menuBar.add(menuColor);
	}
	
	public void createFileMenu() {
		itemNew = new JMenuItem("New");
		fileMenu.add(itemNew);
		itemNew.addActionListener(this);
		itemNew.setActionCommand("New");
		
		itemOpen = new JMenuItem("Open");
		itemOpen.addActionListener(this);
		itemOpen.setActionCommand("Open");
		fileMenu.add(itemOpen);
		
		itemSave = new JMenuItem("Save");
		itemSave.addActionListener(this);
		itemSave.setActionCommand("Save");
		fileMenu.add(itemSave);
		
		itemSaveAs = new JMenuItem("Save As");
		itemSaveAs.addActionListener(this);
		itemSaveAs.setActionCommand("Save As");
		fileMenu.add(itemSaveAs);
		
		
		itemExit = new JMenuItem("Exit");
		itemExit.addActionListener(this);
		itemExit.setActionCommand("Exit");
		fileMenu.add(itemExit);
	}
	
	/*public void createEditMenu() {
		iUndo = new JMenuItem("Undo");
		iUndo.addActionListener(this);
		iUndo.setActionCommand("iUndo");
		menuEdit.add(iUndo);
		
		iRedo = new JMenuItem("Redo");
		iRedo.addActionListener(this);
		iRedo.setActionCommand("Redo");
		menuEdit.add(iRedo);
	}*/

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		switch(command) {
		 
		case "New" : button.NewFile();; break;  
		case "Open" : button.OpenFile();; break;
		case "Save As" : button.SaveAsFile(); break;
		case "Save" : button.SaveFile(); break;
		case "Exit" : button.ExitFile(); break;
		}
	}
	

}
