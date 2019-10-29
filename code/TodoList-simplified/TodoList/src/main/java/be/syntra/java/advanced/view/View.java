package be.syntra.java.advanced.view;

import be.syntra.java.advanced.model.Priority;
import be.syntra.java.advanced.model.TodoItem;

import java.util.List;

public interface View {
    void showHelp();
    void displayList(List<TodoItem> todoList);
    void askForDescription();
    void askForPriority(List<Priority> priorities);

    void showError(String errorMessage);

    void confirmRemoveItem(TodoItem item);
    void confirmEditItem(TodoItem item);

    void confirmItemAdded();
    void confirmItemEdited();
    void confirmItemRemoved();
}
