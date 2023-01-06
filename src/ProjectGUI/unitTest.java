package ProjectGUI;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class unitTest {
    GUI gui = new GUI();
    CommandFactory cf = new CommandFactory();
    FunctionFile functionFile = new FunctionFile(gui);

    @Test
    public void testSaveAsCommand() {

        Command saveAs = new SaveAsFile(functionFile);
        Command sACommand = cf.getCommand("Save As", functionFile);

        assertEquals(saveAs.getClass(), sACommand.getClass());

    }

    @Test
    public void testNewCommand() {

        Command newCommand = new NewFile(functionFile);
        Command newCommandFromFactory = cf.getCommand("New", functionFile);

        assertEquals(newCommand.getClass(), newCommandFromFactory.getClass());
    }

    @Test
    public void testSaveCommand() {

        Command saveCommand = new SaveFile(functionFile);
        Command saveCommandFromFactory = cf.getCommand("Save", functionFile);

        assertEquals(saveCommand.getClass(), saveCommandFromFactory.getClass());
    }

    @Test
    public void testUndoCommand() {

        Command undoCommand = new UndoFile(functionFile);
        Command undoCommandFromFactory = cf.getCommand("Undo", functionFile);

        assertEquals(undoCommand.getClass(), undoCommandFromFactory.getClass());
    }

    @Test
    public void testRedoCommand() {

        Command redoCommand = new RedoFile(functionFile);
        Command redoCommandFromFactory = cf.getCommand("Redo", functionFile);

        assertEquals(redoCommand.getClass(), redoCommandFromFactory.getClass());
    }

    @Test
    public void testOpenCommand() {

        Command openCommand = new OpenFile(functionFile);
        Command openCommandFromFactory = cf.getCommand("Open", functionFile);

        assertEquals(openCommand.getClass(), openCommandFromFactory.getClass());
    }

    @Test
    public void testExitCommand() {

        Command exitFile = new ExitFile(functionFile);
        Command exitCommand = cf.getCommand("Exit", functionFile);

        assertEquals(exitFile.getClass(), exitCommand.getClass());
    }




}