package ru.nkotkin.start;

import ru.nkotkin.models.Bug;
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
 */
public class StartUI {

    /**
     * Private constructor.
     */
    private StartUI() {
    }
    /**
     * Starter.
     * @param args - command line args
     */
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        tracker.add(new Task("First task", "Task for testing", 1L));
        tracker.add(new Task("Second task", "Task for testing", 1L));
        tracker.add(new Bug("First bug", "Bug for testing", 1L));
        for (Item item : tracker.getItems()) {
            if (item != null) {
                System.out.printf("%s - %s\n", item.getId(), item.getName());
            }
        }
    }
}
