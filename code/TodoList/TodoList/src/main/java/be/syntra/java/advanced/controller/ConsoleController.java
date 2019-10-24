package be.syntra.java.advanced.controller;

import be.syntra.java.advanced.exceptions.InvalidActionException;
import be.syntra.java.advanced.exceptions.InvalidConfirmationException;
import be.syntra.java.advanced.exceptions.InvalidPriorityException;
import be.syntra.java.advanced.model.Action;
import be.syntra.java.advanced.model.Confirmation;
import be.syntra.java.advanced.model.Priority;

import java.util.Scanner;

public class ConsoleController implements Controller {

    private final Scanner scanner;

    public ConsoleController(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getUserInput() {
        // TODO impl
        return null;
    }

    @Override
    public Action getUserAction() {
        final String userInput = this.getUserInput();
        try {
            // TODO impl
            return null;
        } catch (IllegalArgumentException exception) {
            throw new InvalidActionException(String.format("Invalid action: %s", userInput), exception);
        }
    }

    @Override
    public Priority getPriority() {
        final String userInput = this.getUserInput();
        try {
            // TODO impl
            return null;
        } catch (IllegalArgumentException iae) {
            throw new InvalidPriorityException(String.format("Invalid priority: %s", userInput), iae);
        }
    }

    @Override
    public Confirmation getConfirmation() {
        final String userInput = this.getUserInput();
        try {
            // TODO impl
            return null;
        } catch (IllegalArgumentException iae) {
            throw new InvalidConfirmationException(String.format("Invalid confirmation: %s", userInput), iae);
        }
    }
}
