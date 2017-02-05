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

//import static org.hamcrest.core.Is.is;
//import static org.junit.Assert.assertThat;

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
//        String[] answers = {"1", "1", "First task", "Desctription for first task", // Add task
//                "0"}; // Exit
//        Input input = new StubInput(answers);
//        new StartUI(input, tracker).mainMenu();
//        assertThat(tracker.findAll()[0].getName(), is("First task"));
    }

//    /**
//     * whenUserEditTaskThenAppEditThat.
//     * @throws Exception exception
//     */
//    @Test
//    public final void whenUserEditBugThenAppEditThat() throws Exception {
//        Tracker tracker = new Tracker();
//        String[] answers = {"1", "2", "First bug", "Desctription for first bug", // Add task
//                "2", "1", "1", "Edit bug", "", // Edit task name
//                "0"}; // Exit
//        Input input = new StubInput(answers);
//        new StartUI(input, tracker).mainMenu();
//        assertThat(tracker.findAll()[0].getName(), is("Edit bug"));
//    }
//
//    /**
//     * whenUserDeleteTaskThenTaskIsNull.
//     * @throws Exception exception
//     */
//    @Test
//    public final void whenUserDeleteTaskThenTaskIsNull() throws Exception {
//        Tracker tracker = new Tracker();
//        String[] answers = {"1", "1", "First task", "Desctription for first task", // Add task
//                "2", "1", "2", // Delete task
//                "0"}; // Exit
//        Input input = new StubInput(answers);
//        new StartUI(input, tracker).mainMenu();
//        assertThat(tracker.findAll()[0] == null, is(true));
//    }
//
//    /**
//     * whenUserFindTaskByNameAndAddCommentThenTheyAdded.
//     * @throws Exception exception
//     */
//    @Test
//    public final void whenUserFindTaskByNameAndAddCommentThenTheyAdded() throws Exception {
//        Tracker tracker = new Tracker();
//        String[] answers = {"1", "1", "First task", "Desctription for first task", // Add task
//                "3", "First", "1", // Find by name
//                "3", "First comment", "0", // Add comment
//                "0"}; // Exit
//        Input input = new StubInput(answers);
//        new StartUI(input, tracker).mainMenu();
//        assertThat(tracker.findAll()[0].getComment()[0].getComment(), is("First comment"));
//    }

}
