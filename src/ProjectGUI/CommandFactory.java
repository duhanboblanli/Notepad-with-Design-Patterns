package ProjectGUI;

public class CommandFactory {
	
	
	public Command getCommand(String shapeType, FunctionFile func){
	      if(shapeType == null){
	         return null;
	      }		
	      if(shapeType.equalsIgnoreCase("New")){
	         return new NewFile(func);
	         
	      } else if(shapeType.equalsIgnoreCase("Exit")){
	         return new ExitFile(func);
	         
	      } else if(shapeType.equalsIgnoreCase("Save As")){
	         return new SaveAsFile(func);
	      }
	      else if(shapeType.equalsIgnoreCase("Save")){
		         return new SaveFile(func);
		     }
	      else if(shapeType.equalsIgnoreCase("Undo")){
		         return new UndoFile(func);
		     }
	      else if(shapeType.equalsIgnoreCase("Redo")){
		         return new RedoFile(func);
		     }
	      else if(shapeType.equalsIgnoreCase("Open")){
		         return new OpenFile(func);
		     }
	      else if(shapeType.equalsIgnoreCase("Exit")){
		         return new ExitFile(func);
		     }
	      
	      return null;
	   }
	
}
