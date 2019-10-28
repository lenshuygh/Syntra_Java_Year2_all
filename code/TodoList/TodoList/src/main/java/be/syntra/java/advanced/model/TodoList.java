package be.syntra.java.advanced.model;

import java.util.*;

public class TodoList {
    private final Set<TodoItem> todoList;

    public TodoList() {
        this.todoList = new HashSet<>();
    }

    void addItem(TodoItem item) {
        todoList.add(item);
    }

    List<TodoItem> getTodoList() {
        /*// TODO impl
        return Collections.emptyList();*/
        return List.copyOf(todoList);
    }

    void removeItem(TodoItem item) {
        todoList.remove(item);
    }

    TodoItem getItem(int itemIndex) {
        return todoList.stream().findFirst().get();
    }
}
