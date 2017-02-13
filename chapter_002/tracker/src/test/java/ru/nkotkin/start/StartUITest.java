/**
 * Используя класс StubInput написать JUnit тесты эмулирующие поведение пользователя.
 * То есть за счет статических данных, пользователь выбирает пункты меню.
 * Вводить данные, выводить данные, и выходит из приложение.
 * Отличие данного задания от первого в том.
 * Что все данные мы заносим в программу.
 * А в первом задание пользователь вводит их с консоли.
 */
package ru.nkotkin.start;

import org.junit.Test;
import ru.nkotkin.models.Bug;
import ru.nkotkin.models.Task;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by nkotkin on 1/15/17.
 */
public class StartUITest {

    /**
     * whenUserAddNewTaskThenAppAddNewTask.
     * @throws Exception exception
     */
    @Test
    public final void whenUserAddNewTaskThenAppAddNewTask() throws Exception {
        Tracker tracker = new Tracker();
        String[] answers = {"0", "1", "First task", "Desctription for first task", // Add task
                            "y"}; // Exit
        Input input = new StubInput(answers);
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("First task"));
    }

    /**
     * whenUserEditTaskThenAppEditThat.
     * @throws Exception exception
     */
    @Test
    public final void whenUserEditBugThenAppEditThat() throws Exception {
        Tracker tracker = new Tracker();
        tracker.add(new Bug("First bug", "Desctription for bug", System.currentTimeMillis()));
        String id = String.format("%d", tracker.findAll()[0].getId());
        String[] answers = {"2", id, "Edit bug", "Edit description", // Edit task name
                            "y"}; // Exit
        Input input = new StubInput(answers);
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("Edit bug"));
    }

    /**
     * whenUserDeleteTaskThenTaskIsNull.
     * @throws Exception exception
     */
    @Test
    public final void whenUserDeleteTaskThenTaskIsNull() throws Exception {
        Tracker tracker = new Tracker();
        tracker.add(new Task("First task", "Desctription for task", System.currentTimeMillis()));
        String id = String.format("%d", tracker.findAll()[0].getId()); // List all items
        String[] answers = {"3", id, // Delete task
                            "y"}; // Exit
        Input input = new StubInput(answers);
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0] == null, is(true));
    }

    /**
     * whenUserFindTaskByNameAndAddCommentThenTheyAdded.
     * @throws Exception exception
     */
    @Test
    public final void whenUserFindTaskByNameAndAddCommentThenTheyAdded() throws Exception {
        Tracker tracker = new Tracker();
        tracker.add(new Task("First task", "Desctription for task", System.currentTimeMillis()));
        String id = String.format("%d", tracker.findByName("First")[0].getId()); // Find by name
        String[] answers = {"5", id, "First comment", // Add comment
                            "y"}; // Exit
        Input input = new StubInput(answers);
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName("First")[0].getComment()[0].getComment(), is("First comment"));
    }

}
