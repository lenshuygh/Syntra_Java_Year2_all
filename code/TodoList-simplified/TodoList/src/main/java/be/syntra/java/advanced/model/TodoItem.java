package be.syntra.java.advanced.model;

import java.util.Objects;

public class TodoItem implements Comparable<TodoItem>{
    private final String description;
    private final Priority priority;

    public TodoItem(String description, Priority priority) {
        this.description = description;
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public Priority getPriority() {
        return priority;
    }

    @Override
    public int compareTo(TodoItem o) {
        return this.priority.compareTo(o.getPriority());
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", description, priority);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoItem todoItem = (TodoItem) o;
        return Objects.equals(description, todoItem.description) &&
                priority == todoItem.priority;
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, priority);
    }
}
