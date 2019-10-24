package be.syntra.java.advanced.model;

import be.syntra.java.advanced.controller.Controller;
import be.syntra.java.advanced.exceptions.InvalidActionException;
import be.syntra.java.advanced.exceptions.InvalidConfirmationException;
import be.syntra.java.advanced.exceptions.InvalidPriorityException;
import be.syntra.java.advanced.view.View;

import java.util.Arrays;

public class TodoListApp {
    private final View view;
    private final Controller controller;
    private final TodoList todoList;

    public TodoListApp(TodoList todoList, View view, Controller controller) {
        this.todoList = todoList;
        this.view = view;
        this.controller = controller;
    }

    public void start() {
        this.view.showHelp();
        this._start();
    }

    private void _start() {
        Action action = null;
        do {
            try {
                action = this.controller.getUserAction();
                switch (action) {
                    case ADD:
                        this.addTodoItem();
                        break;
                    case REMOVE:
                        this.removeTodoItem(action.getPayload());
                        break;
                    case EDIT:
                        this.editTodoItem(action.getPayload());
                        break;
                    case LIST:
                        view.displayList(todoList.getTodoList());
                        break;
                    case HELP:
                        view.showHelp();
                        break;
                }
            } catch (InvalidActionException e) {
                view.showError(e.getMessage());
            }
        } while (action != Action.EXIT);
    }

    private void addTodoItem() {
        // TODO impl
    }

    private TodoItem createTodoItem() throws InvalidPriorityException {
        // TODO impl
        return null;
    }

    private void removeTodoItem(int itemIndex) {
        // TODO impl
    }

    private void editTodoItem(int itemIndex) {
        // TODO impl
    }
}
