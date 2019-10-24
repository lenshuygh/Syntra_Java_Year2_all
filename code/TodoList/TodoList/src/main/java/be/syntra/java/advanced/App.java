package be.syntra.java.advanced;

import be.syntra.java.advanced.controller.Controller;
import be.syntra.java.advanced.model.TodoList;
import be.syntra.java.advanced.model.TodoListApp;
import be.syntra.java.advanced.view.View;

public class App {
    public static void main(String[] args) {
        // TODO impl
        View view = null;
        Controller controller = null;
        TodoList todoList = null;

        TodoListApp app = new TodoListApp(todoList, view, controller);
        app.start();
    }
}
