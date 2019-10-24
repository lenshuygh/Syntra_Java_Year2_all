package be.syntra.java.advanced.controller;

import be.syntra.java.advanced.model.Action;
import be.syntra.java.advanced.model.Confirmation;
import be.syntra.java.advanced.model.Priority;

public interface Controller {
    String getUserInput();
    Action getUserAction();
    Priority getPriority();
    Confirmation getConfirmation();
}
