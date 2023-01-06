package ProjectGUI;

public class CommandFactory {
	public Command getCommand(String commandType, FunctionFile func){
	      if(commandType == null){
	         return null;
	      }		
	      if(commandType.equalsIgnoreCase("New")){
	         return new NewFile(func);
	         
	      } else if(commandType.equalsIgnoreCase("Exit")){
	         return new ExitFile(func);
	         
	      } else if(commandType.equalsIgnoreCase("Save As")){
	         return new SaveAsFile(func);
	      }
	      else if(commandType.equalsIgnoreCase("Save")){
		         return new SaveFile(func);
		     }
	      else if(commandType.equalsIgnoreCase("Undo")){
		         return new UndoFile(func);
		     }
	      else if(commandType.equalsIgnoreCase("Redo")){
		         return new RedoFile(func);
		     }
	      else if(commandType.equalsIgnoreCase("Open")){
		         return new OpenFile(func);
		     }
	      else if(commandType.equalsIgnoreCase("Exit")){
		         return new ExitFile(func);
		     }
	      
	      return null;
	   }
}




