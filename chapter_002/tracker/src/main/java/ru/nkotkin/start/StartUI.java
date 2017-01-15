package ru.nkotkin.start;

import ru.nkotkin.models.Item;
import ru.nkotkin.models.Task;

/**
 * Created by nkotkin on 15.1.17.
 *
 * Описание общей задачи.
 * 1. Необходимо создать программу учета заявок.
 * 2. Работать приложение должно в консоли.
 * 3. Клиент запускают программу java –jar tracker.jar.
 * 4. В консоли отображается приветствие и описание программы.
 * После этого пользователю отображается консольное меню. Список всех действий, которые поддерживаются в системе.
 * Пользователю предлагается выбирать действие, которое он хочет совершить.
 * Когда действие закончено. Пользователю опять отображается меню. В меню должен быть пункт выйти.
 *
 * Всю разработку необходимо разбить на этапы.
 * Приложение должно осуществлять следующие действия.
 * Добавление новой заявки
 * Редактирования заявки.
 * Удаления заявки.
 * Отображение списка всех заявок.
 * Отображения заявок с условием фильтра.
 * Добавлять к заявки комментарий.
 *
 * В заявке должна быть следующая информация. Имя. Описание. Дата создания. И список комментариев.
 *
 * Приложение должно собираться в jar и запускаться командой java –jar tracker.jar.
 * Для этого в pom.xml нужно добавить manifect.
 */
public class StartUI {
    /**
     * input type.
     */
    private Input input;


    /**
     * Instantiates a new Start ui.
     *
     * @param argInput the arg input
     */
    public StartUI(Input argInput) {
        this.input = argInput;
    }


    /**
     * Init.
     */
    public void init() {
        Tracker tracker = new Tracker();

        String name = input.ask("Please, enter the Task's name: ");

        tracker.add(new Task(name, "Task for testing", 1L));
        for (Item item : tracker.findAll()) {
            if (item != null) {
                System.out.printf("%s - %s\n", item.getId(), item.getName());
            }
        }
    }

    /**
     * Starter.
     * @param args - command line args
     */
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        new StartUI(input).init();
    }
}