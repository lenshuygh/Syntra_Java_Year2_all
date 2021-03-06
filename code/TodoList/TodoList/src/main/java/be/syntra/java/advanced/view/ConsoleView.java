package be.syntra.java.advanced.view;

import be.syntra.java.advanced.exceptions.InvalidActionException;
import be.syntra.java.advanced.model.Priority;
import be.syntra.java.advanced.model.TodoItem;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ConsoleView implements View {
    @Override
    public void showHelp() {
        System.out.print("• list\n"
                + "• add\n"
                + "• remove <number>\n"
                + "• edit <number>\n"
                + "• help\n"
                + "• exit\n");
    }

    @Override
    public void displayList(List<TodoItem> todoList) {
        if(todoList.size() > 0) {
            System.out.printf("TODO:\n");
            for (int i = 0; i < todoList.size(); i++) {
                System.out.printf("\t"+(i+1)+". "+ todoList.get(i).getDescription() +" (" + todoList.get(i).getPriority()+ ")\n");
            }
        }else{
            System.out.print("You have no todo's!\n");
        }
    }

    @Override
    public void askForDescription() {
        System.out.print("Enter description: ");
    }

    @Override
    public void askForPriority(List<Priority> priorities) {
        System.out.print("Enter priority (NORMAL, HIGH): ");
    }

    @Override
    public void showError(String errorMessage) {
        System.err.println(errorMessage);
    }

    @Override
    public void confirmRemoveItem(TodoItem item) {
        System.out.printf("Are you sure you want to remove \"%s\"?\n", item);
    }

    @Override
    public void confirmEditItem(TodoItem item) {
        System.out.printf("Are you sure you want to edit \"%s\"?\n", item);
    }

    @Override
    public void confirmItemAdded() {
        System.out.print("Item added!\n");
    }

    @Override
    public void confirmItemEdited() {
        System.out.print("Item edited!\n");
    }

    @Override
    public void confirmItemRemoved() {
        System.out.print("Item removed!\n");
    }
}
