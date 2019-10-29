package be.syntra.java.advanced.view;

import be.syntra.java.advanced.model.Priority;
import be.syntra.java.advanced.model.TodoItem;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ConsoleView implements View {
    @Override
    public void showHelp() {
        // TODO impl
    }

    @Override
    public void displayList(List<TodoItem> todoList) {
        // TODO impl
    }

    @Override
    public void askForDescription() {
        // TODO impl
    }

    @Override
    public void askForPriority(List<Priority> priorities) {
        // TODO impl
    }

    @Override
    public void showError(String errorMessage) {
        // TODO impl
    }

    @Override
    public void confirmRemoveItem(TodoItem item) {
        // TODO impl
    }

    @Override
    public void confirmEditItem(TodoItem item) {
        // TODO impl
    }

    @Override
    public void confirmItemAdded() {
        // TODO impl
    }

    @Override
    public void confirmItemEdited() {
        // TODO impl
    }

    @Override
    public void confirmItemRemoved() {
        // TODO impl
    }
}
