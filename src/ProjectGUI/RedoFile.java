package ProjectGUI;

public class RedoFile implements Command {
	
	Functions function;
	
	public RedoFile(Functions function){
		this.function = function;
	}
	
	@Override
	public void execute() {
		function.redo();
	}
	

}
