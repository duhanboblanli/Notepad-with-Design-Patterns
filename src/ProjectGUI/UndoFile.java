package ProjectGUI;

public class UndoFile implements Command {
	
	Functions function;
	
	public UndoFile(Functions function){
		this.function = function;
	}
	
	@Override
	public void execute() {
		function.undo();
	}
	

}
