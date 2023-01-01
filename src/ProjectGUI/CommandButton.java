package ProjectGUI;

public class CommandButton {
	Command Open;
	Command newCommand;
	Command Save;
	Command SaveAs;
	Command Exit;
	

	public CommandButton(Command openCommand, Command newCommand, Command saveCommand, Command saveAsCommand, Command exitCommand) {
		this.Open = openCommand;
		this.newCommand = newCommand; 
		this.Save = saveCommand;
		this.SaveAs = saveAsCommand;
		this.Exit = exitCommand;
	}

	public void NewFile() {
		newCommand.execute();
	}
	
	public void OpenFile() {
		Open.execute();
	}
	
	public void SaveFile() {
		Save.execute();
	}
	
	public void SaveAsFile() {
		SaveAs.execute();
	}
	
	public void ExitFile() {
		Exit.execute();
	}

}
