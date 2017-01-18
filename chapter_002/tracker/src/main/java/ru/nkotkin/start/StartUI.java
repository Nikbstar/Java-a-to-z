package ru.nkotkin.start;

import ru.nkotkin.models.Bug;
import ru.nkotkin.models.Item;
import ru.nkotkin.models.Task;

import java.text.SimpleDateFormat;

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
 *
 * Используя класс ConsoleInput в классе StartUI обеспечить
 * полноценную работу всего приложения. Пользователю должно
 * отображаться меню. Он может выйти из приложения и выполнять
 * все действия описанные в первом задании.
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
     * System message.
     */
    private String sysMsg = "";

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
        String mineMenu = String.format("%s%s\n\n%s%s%s%s%s%s", CLEAN, sysMsg,
                "Menu:\n",
                "1. Create item\n",
                "2. Items list\n",
                "3. Find item by name\n",
                "0. Exit\n",
                "Select an action [0-3]: ");
        sysMsg = "";
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
     * Add menu.
     */
    private void addMenu() {
        String menu;
        String addMenu = String.format("%s%s\n\n%s%s%s%s", CLEAN, sysMsg,
                "1. Task\n",
                "2. Bug\n",
                "0. Back to menu\n",
                "Select an action [0-2]:");
        sysMsg = "";
        do {
            menu = this.input.ask(addMenu);
        } while (!(menu.equals("1") || menu.equals("2") || menu.equals("0")));
        if (menu.equals("1")) {
            String name = this.input.ask("Enter the Task name: ");
            String description = this.input.ask("Enter Task description: ");
            tracker.add(new Task(name, description, System.currentTimeMillis()));
            sysMsg = "Task created!";
        } else if (menu.equals("2")) {
            String name = this.input.ask("Enter the Bug name: ");
            String description = this.input.ask("Enter Bug description: ");
            tracker.add(new Bug(name, description, System.currentTimeMillis()));
            sysMsg = "Bug created!";
        } else {
            this.mineMenu();
        }
        this.mineMenu();
    }

    /**
     * list menu.
     */
    private void listMenu() {
        String itemType = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        System.out.printf("%s%s\n\n%s", CLEAN, sysMsg, "ItemsList:\n");
        System.out.println("Create date\t\t\t| Item\t| Name\t\t| Description");
        for (Item item : tracker.findAll()) {
            if (item != null) {
                if (item instanceof Bug) {
                    itemType = "Bug";
                } else if (item instanceof Task) {
                    itemType = "Task";
                }
                System.out.printf("%s\t| %s\t| %s\t\t| %s\n", dateFormat.format(item.getCreate()),
                        itemType, item.getName(), item.getDescription());
            }
        }
        this.input.ask("Press any key to continue");
        this.mineMenu();
    }

    /**
     * Find by name menu.
     */
    private void findMenu() {
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
