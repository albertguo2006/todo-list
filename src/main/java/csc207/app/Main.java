package csc207.app;

import csc207.todo_list.ToDoList;
import csc207.todo_list.TodoListPanel;

import javax.swing.*;

public class Main {
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread, as is done in main.
     */
    public static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Todo List");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        to_do_list = new ToDoList();

        frame.add(new TodoListPanel(to_do_list));

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::createAndShowGUI);
    }
}
