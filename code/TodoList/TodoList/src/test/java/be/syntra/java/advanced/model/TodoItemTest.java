package be.syntra.java.advanced.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TodoItemTest {
    @Test
    void testCanCreateTodoItem() {
        // given
        TodoItem item = new TodoItem("Description", Priority.NORMAL);

        // when
        final String description = item.getDescription();
        final Priority priority = item.getPriority();

        // then
        Assertions.assertEquals("Description", description);
        Assertions.assertEquals(Priority.NORMAL, priority);
    }

    @Test
    void testCanCompare() {
        // given
        TodoItem normalPriorityTodo = new TodoItem("Description", Priority.NORMAL);
        TodoItem highPriorityTodo = new TodoItem("Description", Priority.HIGH);

        // when
        int compare = normalPriorityTodo.compareTo(highPriorityTodo);

        // then
        Assertions.assertTrue(compare < 0);
    }

    @Test
    void testToString() {
        // given
        final TodoItem item = new TodoItem("Description", Priority.LOW);

        // when
        final String value = item.toString();

        // then
        Assertions.assertEquals("Description (LOW)", value);
    }
}
