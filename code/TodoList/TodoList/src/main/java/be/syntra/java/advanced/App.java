package be.syntra.java.advanced;

import be.syntra.java.advanced.controller.ConsoleController;
import be.syntra.java.advanced.controller.Controller;
import be.syntra.java.advanced.model.TodoList;
import be.syntra.java.advanced.model.TodoListApp;
import be.syntra.java.advanced.view.ConsoleView;
import be.syntra.java.advanced.view.View;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        View view = new ConsoleView();
        Controller controller = new ConsoleController(new Scanner(System.in));
        TodoList todoList = new TodoList();

        TodoListApp app = new TodoListApp(todoList, view, controller);
        app.start();
    }
}
