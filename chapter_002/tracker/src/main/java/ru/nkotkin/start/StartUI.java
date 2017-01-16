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
 * После этого пользователю отображается консольное меню.
 * Список всех действий, которые поддерживаются в системе.
 * Пользователю предлагается выбирать действие, которое он
 * хочет совершить.
 * Когда действие закончено. Пользователю опять отображается
 * меню.В меню должен быть пункт выйти.
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
 * В заявке должна быть следующая информация. Имя. Описание.
 * Дата создания. И список комментариев.
 *
 * Приложение должно собираться в jar и запускаться командой
 * java –jar tracker.jar. Для этого в pom.xml нужно добавить manifect.
 */
public class StartUI {
    /**
     * input type.
     */
    private Input input;
    /**
     * initialization tracker.
     */
    private Tracker tracker = new Tracker();
    /**
     * Clean screen.
     */
    public static final String CLEAN = "\n\n\n\n\n\n\n\n\n\n";

    /**
     * Instantiates a new Start ui.
     *
     * @param argInput the arg input
     */
    public StartUI(Input argInput) {
        this.input = argInput;
    }

    /**
     * Mine menu.
     */
    public void mineMenu() {
        String menu;
        String mineMenu = String.format("%s%s%s%s%s%s%s", CLEAN,
                "Menu:\n",
                "1. Create item\n",
                "2. Items list\n",
                "3. Find item by name\n",
                "0. Exit\n",
                "Select an action [0-3]: ");
        do {
            menu = this.input.ask(mineMenu);
        } while (!(menu.equals("1") || menu.equals("2") || menu.equals("3") || menu.equals("0")));
        if (menu.equals("1")) {
            this.addMenu();
        } else if (menu.equals("2")) {
            this.listMenu();
        } else if (menu.equals("3")) {
            this.findMenu();
        } else {
            System.exit(0);
        }
    }

    /**
     * Find by name menu.
     */
    private void findMenu() {
    }

    /**
     * list menu.
     */
    private void listMenu() {
        System.out.print(CLEAN);
        for (Item item : tracker.findAll()) {
            if (item != null) {
                System.out.printf("%s - %s\n", item.getId(), item.getName());
            }
            this.input.ask("Press any key to continue");
            this.mineMenu();
        }
    }

    /**
     * Add menu.
     */
    private void addMenu() {
        String menu;
        String addMenu = String.format("%s%s%s%s%s", CLEAN,
                "1. Task\n",
                "2. Bug\n",
                "0. Back to menu\n",
                "Select an action [0-2]:");
        do {
            menu = this.input.ask(addMenu);
        } while (!(menu.equals("1") || menu.equals("2") || menu.equals("0")));
        if (menu.equals("1")) {
            String name = this.input.ask("Enter the Task name: ");
            String description = this.input.ask("Enter Task description: ");
            tracker.add(new Task(name, description, System.currentTimeMillis()));
        } else if (menu.equals("2")) {
            String name = this.input.ask("Enter the Bug name: ");
            String description = this.input.ask("Enter Task description: ");
            tracker.add(new Bug(name, description, System.currentTimeMillis()));
        } else {
            this.mineMenu();
        }
        this.mineMenu();
    }
    /**
     * Starter.
     * @param args - command line args
     */
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        new StartUI(input).mineMenu();
    }
}
