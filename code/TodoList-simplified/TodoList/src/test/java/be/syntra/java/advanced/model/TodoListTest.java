package be.syntra.java.advanced.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class TodoListTest {

    private TodoList todoList;

    @BeforeEach
    void setUp() {
        todoList = new TodoList();
    }

    @Test
    void testCanAddTodoItem() {
        // given
        todoList.addItem(new TodoItem("Description", Priority.NORMAL));

        // when
        List<TodoItem> todoItems = todoList.getTodoList();

        // then
        Assertions.assertEquals(Collections.singletonList(new TodoItem("Description", Priority.NORMAL)), todoItems);
    }

    @Test
    void testTodoListIsSorted() {
        // given
        final TodoItem normalItem = new TodoItem("Normal Priority", Priority.NORMAL);
        final TodoItem lowItem = new TodoItem("Low Priority", Priority.LOW);
        final TodoItem highItem = new TodoItem("High Priority", Priority.HIGH);

        // when
        todoList.addItem(normalItem);
        todoList.addItem(lowItem);
        todoList.addItem(highItem);

        // then
        Assertions.assertEquals(Arrays.asList(highItem, normalItem, lowItem), todoList.getTodoList());
    }

    @Test
    void testCanRemoveItem() {
        // given
        final TodoItem firstItem = new TodoItem("First item", Priority.NORMAL);
        final TodoItem secondItem = new TodoItem("Second item", Priority.NORMAL);
        todoList.addItem(firstItem);
        todoList.addItem(secondItem);

        // when
        todoList.removeItem(firstItem);

        // then
        Assertions.assertEquals(Collections.singletonList(secondItem), todoList.getTodoList());
    }

    @Test
    void testCanGetSingleItem() {
        // given
        final TodoItem firstItem = new TodoItem("First item", Priority.HIGH);
        final TodoItem secondItem = new TodoItem("Second item", Priority.NORMAL);
        todoList.addItem(firstItem);
        todoList.addItem(secondItem);

        // when
        final TodoItem item = todoList.getItem(0);

        // then
        Assertions.assertEquals(firstItem, item);
    }
}
