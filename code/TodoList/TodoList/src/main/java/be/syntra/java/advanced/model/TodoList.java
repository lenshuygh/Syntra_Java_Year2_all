package be.syntra.java.advanced.model;

import java.util.*;
import java.util.stream.Collectors;

public class TodoList {
    private final Set<TodoItem> todoList;

    public TodoList() {
        this.todoList = new HashSet<>();
    }

    void addItem(TodoItem item) {
        todoList.add(item);
    }

    List<TodoItem> getTodoList() {
        return todoList.stream()
                .sorted(Comparator.comparing(TodoItem::getPriority))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    void removeItem(TodoItem item) {
        todoList.remove(item);
    }

    TodoItem getItem(int itemIndex) {
        return getSortedList().get(itemIndex);
    }

    private List<TodoItem> getSortedList(){
        return todoList.stream()
                .sorted(Comparator.comparing(TodoItem::getPriority))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

    }
}
