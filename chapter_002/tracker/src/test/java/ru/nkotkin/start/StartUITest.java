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

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by nkotkin on 1/15/17.
 */
public class StartUITest {

    /**
     * whenUserAddNewTask.
     * @throws Exception exception
     */
    @Test
    public final void whenUserAddNewTask() throws Exception {
        Tracker tracker = new Tracker();
        String[] answers = {"1", "1", "First task", "Desctription for first task", "0"};
        Input input = new StubInput(answers);
        new StartUI(input, tracker).mineMenu();
        //assertThat(tracker.findAll()[0].getName(), is("First task"));
    }
}
