package be.syntra.java.advanced.controller;

import be.syntra.java.advanced.exceptions.InvalidActionException;
import be.syntra.java.advanced.exceptions.InvalidConfirmationException;
import be.syntra.java.advanced.exceptions.InvalidPriorityException;
import be.syntra.java.advanced.model.Action;
import be.syntra.java.advanced.model.Confirmation;
import be.syntra.java.advanced.model.Priority;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

class ConsoleControllerTest {
    @Test
    void testThrowsInvalidActionException() {
        // given
        InputStream in = new ByteArrayInputStream("test".getBytes());
        Scanner scanner = new Scanner(in);
        ConsoleController controller = new ConsoleController(scanner);

        // when / then
        Assertions.assertThrows(InvalidActionException.class, controller::getUserAction);
    }

    @Test
    void testCanGetHelpAction() {
        // given
        InputStream in = new ByteArrayInputStream("help".getBytes());
        Scanner scanner = new Scanner(in);
        ConsoleController controller = new ConsoleController(scanner);

        // when
        Action action = controller.getUserAction();

        // then
        Assertions.assertEquals(Action.HELP, action);
    }

    @Test
    void testCanGetEditAction() {
        // given
        InputStream in = new ByteArrayInputStream("edit 2".getBytes());
        Scanner scanner = new Scanner(in);
        ConsoleController controller = new ConsoleController(scanner);

        // when
        Action action = controller.getUserAction();

        // then
        Assertions.assertEquals(Action.EDIT, action);
        Assertions.assertEquals(2, action.getPayload());
    }

    @Test
    void testThrowsInvalidPriorityException() {
        // given
        InputStream in = new ByteArrayInputStream("test".getBytes());
        Scanner scanner = new Scanner(in);
        ConsoleController controller = new ConsoleController(scanner);

        // when / then
        Assertions.assertThrows(InvalidPriorityException.class, controller::getPriority);
    }

    @Test
    void testCanGetPriority() {
        // given
        InputStream in = new ByteArrayInputStream("low".getBytes());
        Scanner scanner = new Scanner(in);
        ConsoleController controller = new ConsoleController(scanner);

        // when
        Priority priority = controller.getPriority();

        // then
        Assertions.assertEquals(Priority.LOW, priority);
    }

    @Test
    void testThrowsInvalidConfirmationException() {
        // given
        InputStream in = new ByteArrayInputStream("test".getBytes());
        Scanner scanner = new Scanner(in);
        ConsoleController controller = new ConsoleController(scanner);

        // when / then
        Assertions.assertThrows(InvalidConfirmationException.class, controller::getConfirmation);
    }

    @Test
    void testCanGetConfirmation() {
        // given
        InputStream in = new ByteArrayInputStream("yes".getBytes());
        Scanner scanner = new Scanner(in);
        ConsoleController controller = new ConsoleController(scanner);

        // when
        Confirmation confirmation = controller.getConfirmation();

        // then
        Assertions.assertEquals(Confirmation.YES, confirmation);
    }
}
