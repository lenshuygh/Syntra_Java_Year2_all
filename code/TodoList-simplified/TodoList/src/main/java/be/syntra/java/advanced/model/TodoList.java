package be.syntra.java.advanced.model;

import java.util.*;

public class TodoList {
    private final Set<TodoItem> todoList;

    public TodoList() {
        this.todoList = new HashSet<>();
    }

    void addItem(TodoItem item) {
        // TODO impl
    }

    List<TodoItem> getTodoList() {
        // TODO impl
        return Collections.emptyList();
    }

    void removeItem(TodoItem item) {
        // TODO impl
    }

    TodoItem getItem(int itemIndex) {
        // TODO impl
        return null;
    }
}
