package ProjectGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class GUI implements ActionListener {

	// used to edit jFrame window(e.g. adding a button)
	public JFrame window;
	// multi-line area that displays plain text
	public JTextArea textArea;
	// to add scrolling functionality on window frame
	public JScrollPane scrollPane;
	// to add wrap functionality on format menu
	boolean wordWrapOn = false;
	// to add topMenuBar
	public JMenuBar menuBar;
	public JMenu fileMenu , menuEdit, menuFormat, menuColor;
	// these items can be added to topMenuBar
	public JMenuItem itemNew, itemOpen, itemSave, itemSaveAs, itemExit;
	// edit menu items
	public JMenuItem iUndo, iRedo;
	// format menu
	JMenuItem iWrap,iFontArial,iFontCSMS,iFontSize8,iFontSize12,iFontSize16,iFontSize20,iFontSize24,iFontSize28;
	JMenu menuFont,menuFontSize;
	// color menu
	JMenuItem iColor1,iColor2,iColor3;

	Function_Format format = new Function_Format.FunctionFormatBuilder(this)
			.setFontType("Arial")
			.build();

	// integration between Function File class and GUI classes
	FunctionFile funcs = new FunctionFile(this);
	// // integration between Function Format class and GUI classes
	Command openCommand = new OpenFile(funcs);
	Command newCommand = new NewFile(funcs);
	Command exitCommand = new ExitFile(funcs);
	Command SaveAsCommand = new SaveAsFile(funcs);
	Command SaveCommand = new SaveFile(funcs);
	Command UndoCommand = new UndoFile(funcs);
	Command RedoCommand = new RedoFile(funcs);

	CommandButton button = new CommandButton(openCommand,newCommand,SaveCommand,SaveAsCommand,exitCommand,UndoCommand,RedoCommand);
	UndoManager um = new UndoManager();
	
	Function_Color color = new Function_Color(this);
	public static void main(String[] args) {
		new GUI();
	}

	// empty constructor method
	public GUI() {

		createWindow();
		createTextArea();
		createMenuBar();
		createFileMenu();
		createEditMenu();
		createFormatMenu();
		createColorMenu();
		color.changeColor("Blue");
		
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

		//undoManager() functionality added to textArea
		textArea.getDocument().addUndoableEditListener(
				new UndoableEditListener() {
					@Override
					public void undoableEditHappened(UndoableEditEvent e) {
						um.addEdit(e.getEdit());
					}
				});

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

	public void createEditMenu() {
		iUndo = new JMenuItem("Undo");
		iUndo.addActionListener(this);
		iUndo.setActionCommand("Undo");
		menuEdit.add(iUndo);

		iRedo = new JMenuItem("Redo");
		iRedo.addActionListener(this);
		iRedo.setActionCommand("Redo");
		menuEdit.add(iRedo);
	}

	public void createFormatMenu() {
		iWrap = new JMenuItem("Word Wrap: Off");
		iWrap.addActionListener(this);
		iWrap.setActionCommand("Word Wrap");
		menuFormat.add(iWrap);

		menuFont = new JMenu("Font");
		menuFormat.add(menuFont);

		iFontArial = new JMenuItem("Arial");
		iFontArial.addActionListener(this);
		iFontArial.setActionCommand("Arial");
		menuFont.add(iFontArial);

		iFontCSMS = new JMenuItem("Comic Sans MS");
		iFontCSMS.addActionListener(this);
		iFontCSMS.setActionCommand("Comic Sans MS");
		menuFont.add(iFontCSMS);

		menuFontSize = new JMenu("Font Size");
		menuFormat.add(menuFontSize);

		iFontSize8 = new JMenuItem("8");
		iFontSize8.addActionListener(this);
		iFontSize8.setActionCommand("size8");
		menuFontSize.add(iFontSize8);

		iFontSize12 = new JMenuItem("12");
		iFontSize12.addActionListener(this);
		iFontSize12.setActionCommand("size12");
		menuFontSize.add(iFontSize12);

		iFontSize16 = new JMenuItem("16");
		iFontSize16.addActionListener(this);
		iFontSize16.setActionCommand("size16");
		menuFontSize.add(iFontSize16);

		iFontSize20 = new JMenuItem("20");
		iFontSize20.addActionListener(this);
		iFontSize20.setActionCommand("size20");
		menuFontSize.add(iFontSize20);

		iFontSize24 = new JMenuItem("24");
		iFontSize24.addActionListener(this);
		iFontSize24.setActionCommand("size24");
		menuFontSize.add(iFontSize24);

		iFontSize28 = new JMenuItem("28");
		iFontSize28.addActionListener(this);
		iFontSize28.setActionCommand("size28");
		menuFontSize.add(iFontSize28);
	}
	
	public void createColorMenu() {
		
		iColor1 = new JMenuItem("White");
		iColor1.addActionListener(this);
		iColor1.setActionCommand("White");
		menuColor.add(iColor1);
		
		iColor2 = new JMenuItem("Black");
		iColor2.addActionListener(this);
		iColor2.setActionCommand("Black");
		menuColor.add(iColor2);
		
		iColor3 = new JMenuItem("Blue");
		iColor3.addActionListener(this);
		iColor3.setActionCommand("Blue");
		menuColor.add(iColor3);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		switch(command) {

			case "New" : button.NewFile();; break;
			case "Open" : button.OpenFile();; break;
			case "Save As" : button.SaveAsFile(); break;
			case "Save" : button.SaveFile(); break;
			case "Exit" : button.ExitFile(); break;
			case "Undo": button.UndoFile(); break;
			case "Redo": button.RedoFile(); break;
			// function format instance --> format
			case "Word Wrap": format.wordWrap(); break;
			case "Arial": format.setFontType(command);break;
			case "Comic Sans MS": format.setFontType(command);break;
			case "size8" : format.setFontSize(8); break;
			case "size12" : format.setFontSize(12); break;
			case "size16" : format.setFontSize(16); break;
			case "size20" : format.setFontSize(20); break;
			case "size24" : format.setFontSize(24); break;
			case "size28" : format.setFontSize(28); break;
			case "White": color.changeColor(command);break;
			case "Black": color.changeColor(command);break;
			case "Blue": color.changeColor(command);break;

			
			

		}
	}


}