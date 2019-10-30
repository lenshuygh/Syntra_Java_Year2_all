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
        return scanner.nextLine();
    }

    @Override
    public Action getUserAction() {
        final String userInput = this.getUserInput();
        try {
            if (userInput.toUpperCase().contains("EDIT")){
                Action.EDIT.setPayload(getNumberAtInputEnd(userInput,"EDIT"));
                return Action.EDIT;
            }else if (userInput.toUpperCase().contains("HELP")){
                return Action.HELP;
            }else if (userInput.toUpperCase().contains("EXIT")){
                return Action.EXIT;
            }else if (userInput.toUpperCase().contains("LIST")){
                return Action.LIST;
            }else if (userInput.toUpperCase().contains("ADD")){
                return Action.ADD;
            }else if (userInput.toUpperCase().contains("REMOVE")){
                Action.REMOVE.setPayload(getNumberAtInputEnd(userInput,"REMOVE"));
                return Action.REMOVE;
            }
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException exception) {
            throw new InvalidActionException(String.format("Invalid action: %s", userInput), exception);
        }
    }

    private int getNumberAtInputEnd(String userInput,String actionString) {
        return Integer.parseInt(userInput.toUpperCase().replace(actionString,"").trim());
    }

    @Override
    public Priority getPriority() {
        final String userInput = this.getUserInput();
        try {
            switch (userInput.toUpperCase()){
                case "LOW": return Priority.LOW;
                case "NORMAL": return Priority.NORMAL;
                case "HIGH": return Priority.HIGH;
            }
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException iae) {
            throw new InvalidPriorityException(String.format("Invalid priority: %s", userInput), iae);
        }
    }

    @Override
    public Confirmation getConfirmation() {
        final String userInput = this.getUserInput();
        try {
            if(userInput.toUpperCase().equals("YES")){
                return Confirmation.YES;
            }else if(userInput.toUpperCase().equals("NO")) {
                return Confirmation.NO;
            }
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException iae) {
            throw new InvalidConfirmationException(String.format("Invalid confirmation: %s", userInput), iae);
        }
    }
}
