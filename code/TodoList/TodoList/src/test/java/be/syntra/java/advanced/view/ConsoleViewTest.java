package be.syntra.java.advanced.view;

import be.syntra.java.advanced.model.Priority;
import be.syntra.java.advanced.model.TodoItem;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class ConsoleViewTest {
    private ConsoleView consoleView;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    void setUp() {
        consoleView = new ConsoleView();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    void testCanShowHelp() {
        // given

        // when
        consoleView.showHelp();

        //then
        final String expected = "• list\n"
                + "• add\n"
                + "• remove <number>\n"
                + "• edit <number>\n"
                + "• help\n"
                + "• exit\n";
        Assertions.assertEquals(expected, outContent.toString());
    }

    @Test
    void testCanShowEmptyList() {
        // given

        // when
        consoleView.displayList(Collections.emptyList());

        // then
        Assertions.assertEquals("You have no todo's!\n", outContent.toString());
    }

    @Test
    void testCanShowList() {
        // given
        final List<TodoItem> todoList = Arrays.asList(
                new TodoItem("First item", Priority.HIGH),
                new TodoItem("Second item", Priority.NORMAL)
        );

        // when
        consoleView.displayList(todoList);

        // then
        final String expected = "TODO:\n\t1. First item (HIGH)\n\t2. Second item (NORMAL)\n";
        Assertions.assertEquals(expected, outContent.toString());
    }

    @Test
    void testCanAskForDescription() {
        // given

        // when
        consoleView.askForDescription();

        // then
        Assertions.assertEquals("Enter description: ", outContent.toString());
    }

    @Test
    void testCanAskForPriority() {
        // given
        final List<Priority> priorities = Arrays.asList(Priority.NORMAL, Priority.HIGH);

        // when
        consoleView.askForPriority(priorities);

        // then
        final String expected = "Enter priority (NORMAL, HIGH): ";
        Assertions.assertEquals(expected, outContent.toString());
    }

    @Test
    void testCanShowError() {
        // given

        // when
        consoleView.showError("Error message");

        // then
        Assertions.assertEquals("Error message\n", errContent.toString());
    }

    @Test
    void testConfirmAdded() {
        // given

        // when
        consoleView.confirmItemAdded();

        // then
        Assertions.assertEquals("Item added!\n", outContent.toString());
    }

    @Test
    void testConfirmRemove() {
        // given
        TodoItem item = new TodoItem("Description", Priority.LOW);

        // when
        consoleView.confirmRemoveItem(item);

        // then
        final String expected = String.format("Are you sure you want to remove \"%s\"?\n", item);
        Assertions.assertEquals(expected, outContent.toString());
    }

    @Test
    void testConfirmEdit() {
        // given
        TodoItem item = new TodoItem("Description", Priority.LOW);

        // when
        consoleView.confirmEditItem(item);

        // then
        final String expected = String.format("Are you sure you want to edit \"%s\"?\n", item);
        Assertions.assertEquals(expected, outContent.toString());
    }

    @Test
    void testConfirmItemEdited() {
        // given

        // when
        consoleView.confirmItemEdited();

        // then
        Assertions.assertEquals("Item edited!\n", outContent.toString());
    }

    @Test
    void testConfirmItemRemoved() {
        // given

        // when
        consoleView.confirmItemRemoved();

        // then
        Assertions.assertEquals("Item removed!\n", outContent.toString());
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
}
