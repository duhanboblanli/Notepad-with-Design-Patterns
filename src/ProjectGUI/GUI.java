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

public class GUI implements ActionListener {
	
	// jFrame icerisine buton vs koymamıza yarıyo
	public JFrame window;
	public JTextArea textArea;
	public JScrollPane scrollPane;
	public JMenuBar menuBar;
	public JMenu fileMenu , menuEdit, menuFormat, menuColor;
	public JMenuItem itemNew, itemOpen, itemSave, itemSaveAs, itemExit;
	
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

	public GUI() {
		
	
		createWindow();
		createTextArea();
		createMenuBar();
		createFileMenu();
		window.setVisible(true);
	}
	
	public void createWindow() {
		
		window = new JFrame("notepad");
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void createTextArea() {
		textArea = new JTextArea();
		scrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
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
