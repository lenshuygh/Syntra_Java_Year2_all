package be.syntra.java.advanced.model;

import be.syntra.java.advanced.controller.Controller;
import be.syntra.java.advanced.view.View;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

class TodoListAppTest {

    private TodoListApp todoListApp;
    private TodoList todoList;
    private ViewMock view;
    private ControllerStub controller;

    @BeforeEach
    void setUp() {
        todoList = new TodoList();
        view = new ViewMock();
        controller = new ControllerStub();
        todoListApp = new TodoListApp(todoList, view, controller);
    }

    @Test
    void testShowsHelpOnStartup() {
        // given
        controller.setActions(Action.EXIT);

        // when
        todoListApp.start();

        // then
        Assertions.assertTrue(view.showHelpHasBeenCalled());
    }

    @Test
    void testAddItem() {
        // given
        controller.setActions(Action.ADD, Action.EXIT);
        controller.setInput("Test");
        controller.setPriority(Priority.NORMAL);

        // when
        todoListApp.start();

        // then
        Assertions.assertEquals(new TodoItem("Test", Priority.NORMAL), todoList.getItem(0));
        Assertions.assertTrue(view.confirmItemAddedHasBeenCalled());
        Assertions.assertTrue(view.displayListHasBeenCalled());
    }

    @Test
    void testRemoveItem() {
        // given
        todoList.addItem(new TodoItem("Test", Priority.NORMAL));
        final Action removeAction = Action.REMOVE;
        removeAction.setPayload(1);
        controller.setActions(removeAction, Action.EXIT);
        controller.setConfirmation(Confirmation.YES);

        // when
        todoListApp.start();

        // then
        Assertions.assertTrue(todoList.getTodoList().isEmpty());
        Assertions.assertTrue(view.confirmRemoveItemHasBeenCalled());
        Assertions.assertTrue(view.confirmItemRemovedHasBeenCalled());
    }

    @Test
    void testEditItem() {
        // given
        todoList.addItem(new TodoItem("Test", Priority.NORMAL));
        final Action editAction = Action.EDIT;
        editAction.setPayload(1);
        controller.setActions(editAction, Action.EXIT);
        controller.setConfirmation(Confirmation.YES);

        controller.setInput("New item");
        controller.setPriority(Priority.HIGH);

        // when
        todoListApp.start();

        // then
        Assertions.assertEquals(
                Collections.singletonList(new TodoItem("New item", Priority.HIGH)),
                todoList.getTodoList()
        );
        Assertions.assertTrue(view.confirmEditItemHasBeenCalled());
        Assertions.assertTrue(view.confirmItemEditedHasBeenCalled());
        Assertions.assertTrue(view.displayListHasBeenCalled());
    }

    @Test
    void testListItems() {
        // given
        controller.setActions(Action.LIST, Action.EXIT);

        // when
        todoListApp.start();

        // then
        Assertions.assertTrue(view.displayListHasBeenCalled());
    }

    @Test
    void testShowHelp() {
        // given
        controller.setActions(Action.HELP, Action.EXIT);

        // when
        todoListApp.start();

        // then
        Assertions.assertTrue(view.showHelpHasBeenCalled());
    }

    @Test
    void testRemoveDoesNotThrowIndexOutOfBoundsException() {
        // given
        final Action removeAction = Action.REMOVE;
        removeAction.setPayload(3);
        controller.setActions(removeAction, Action.EXIT);

        // when - then
        Assertions.assertDoesNotThrow(todoListApp::start);
    }

    @Test
    void testEditDoesNotThrowIndexOutOfBoundsException() {
        // given
        final Action editAction = Action.EDIT;
        editAction.setPayload(3);
        controller.setActions(editAction, Action.EXIT);

        // when - then
        Assertions.assertDoesNotThrow(todoListApp::start);
    }

    private static class ViewMock implements View {
        private int showHelpCalledCount = 0;
        private int displayListCalledCount = 0;
        private int askForDescriptionCalledCount = 0;
        private int askForPriorityCalledCount = 0;
        private int showErrorCalledCount = 0;
        private int confirmRemoveItemCalledCount = 0;
        private int confirmEditItemCalledCount = 0;
        private int confirmItemAddedCalledCount = 0;
        private int confirmItemEditedCalledCount = 0;
        private int confirmItemRemovedCalledCount = 0;

        @Override
        public void showHelp() {
            showHelpCalledCount++;
        }

        boolean showHelpHasBeenCalled() {
            return showHelpCalledCount > 0;
        }

        @Override
        public void displayList(List<TodoItem> todoList) {
            displayListCalledCount++;
        }

        boolean displayListHasBeenCalled() {
            return displayListCalledCount > 0;
        }

        @Override
        public void askForDescription() {
            askForDescriptionCalledCount++;
        }

        public boolean askForDescriptionHasBeenCalled() {
            return askForDescriptionCalledCount > 0;
        }

        @Override
        public void askForPriority(List<Priority> priorities) {
            askForPriorityCalledCount++;
        }

        public boolean askForPriorityHasBeenCalled() {
            return askForPriorityCalledCount > 0;
        }

        @Override
        public void showError(String errorMessage) {
            showErrorCalledCount++;
        }

        public boolean showErrorHasBeenCalled() {
            return showErrorCalledCount > 0;
        }

        @Override
        public void confirmRemoveItem(TodoItem item) {
            confirmRemoveItemCalledCount++;
        }

        boolean confirmRemoveItemHasBeenCalled() {
            return confirmRemoveItemCalledCount > 0;
        }

        @Override
        public void confirmEditItem(TodoItem item) {
            confirmEditItemCalledCount++;
        }

        boolean confirmEditItemHasBeenCalled() {
            return confirmEditItemCalledCount > 0;
        }

        @Override
        public void confirmItemAdded() {
            confirmItemAddedCalledCount++;
        }

        boolean confirmItemAddedHasBeenCalled() {
            return confirmItemAddedCalledCount > 0;
        }

        @Override
        public void confirmItemEdited() {
            confirmItemEditedCalledCount++;
        }

        boolean confirmItemEditedHasBeenCalled() {
            return confirmItemEditedCalledCount > 0;
        }

        @Override
        public void confirmItemRemoved() {
            confirmItemRemovedCalledCount++;
        }

        boolean confirmItemRemovedHasBeenCalled() {
            return confirmItemRemovedCalledCount > 0;
        }
    }

    private static class ControllerStub implements Controller {
        private final Queue<Action> actions;
        private Priority priority;
        private Confirmation confirmation;
        private String input;

        ControllerStub() {
            actions = new LinkedList<>();
            priority = null;
            confirmation = null;
            input = null;
        }

        void setActions(Action... actions) {
            this.actions.addAll(Arrays.asList(actions));
        }

        void setInput(String input) {
            this.input = input;
        }

        @Override
        public String getUserInput() {
            return input;
        }

        @Override
        public Action getUserAction() {
            return actions.remove();
        }

        @Override
        public Priority getPriority() {
            return priority;
        }

        void setPriority(Priority priority) {
            this.priority = priority;
        }

        @Override
        public Confirmation getConfirmation() {
            return confirmation;
        }

        void setConfirmation(Confirmation confirmation) {
            this.confirmation = confirmation;
        }
    }
}
