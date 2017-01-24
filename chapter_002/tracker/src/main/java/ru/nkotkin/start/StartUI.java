package ru.nkotkin.start;

import ru.nkotkin.models.Bug;
import ru.nkotkin.models.Comment;
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
     * Menu string.
     */
    private String menu = "";

    /**
     * Menu select string.
     */
    private String menuSelect = "";

    /**
     * Clean screen.
     */
    private static final String CLEAN = "\n\n\n\n\n\n\n\n\n\n";

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
     * check that string is int.
     * @param arg value to check
     * @return true if is int
     * @throws NumberFormatException exeption
     */
    private boolean isInt(String arg) throws NumberFormatException {
        try {
            Integer.parseInt(arg);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Head of menu.
     */
    private void menuHead() {
        System.out.printf("%s%s\n\n", CLEAN, this.sysMsg);
        this.sysMsg = "";
    }

    /**
     * Mine menu.
     */
    private void mineMenu() {
        this.menu = String.format("%s%s%s%s%s%s",
                "Menu:\n",
                "1. Create item\n",
                "2. Items list\n",
                "3. Find item by name\n",
                "0. Exit\n",
                "Select an action [0-3]: ");
        do {
            this.menuHead();
            this.menuSelect = this.input.ask(this.menu);
        } while (!(this.menuSelect.equals("1") || this.menuSelect.equals("2")
                || this.menuSelect.equals("3") || this.menuSelect.equals("0")));

        if (this.menuSelect.equals("1")) {
            this.addMenu();
        } else if (this.menuSelect.equals("2")) {
            this.listMenu();
        } else if (this.menuSelect.equals("3")) {
            this.findMenu();
        } else {
            System.exit(0);
        }
    }

    /**
     * Add menu.
     */
    private void addMenu() {
        String name;
        String description;
        this.menu = String.format("%s%s%s%s",
                "1. Task\n",
                "2. Bug\n",
                "0. Back to menu\n",
                "Select an action [0-2]:");
        do {
            this.menuHead();
            this.menuSelect = this.input.ask(this.menu);
        } while (!(this.menuSelect.equals("1") || this.menuSelect.equals("2") || this.menuSelect.equals("0")));
        if (this.menuSelect.equals("1")) {
            do {
                name = this.input.ask("Enter the Task name: ");
            } while (name.equals(""));
            do {
                description = this.input.ask("Enter Task description: ");
            } while (description.equals(""));
            this.tracker.add(new Task(name, description, System.currentTimeMillis()));
            this.sysMsg = String.format("Task %s created!", name);
        } else if (this.menuSelect.equals("2")) {
            do {
                name = this.input.ask("Enter the Bug name: ");
            } while (name.equals(""));
            do {
                description = this.input.ask("Enter Bug description: ");
            } while (description.equals(""));
            this.tracker.add(new Bug(name, description, System.currentTimeMillis()));
            this.sysMsg = String.format("Bug %s created!", name);
        } else {
            this.mineMenu();
        }
        this.mineMenu();
    }

    /**
     * edit item menu.
     * @param item item
     */
    private void editMenu(Item item) {
        Item newItem = null;
        String name = this.input.ask(String.format("Enter new item name (%s): ", item.getName()));
        if (name.equals("")) {
            name = item.getName();
        }
        String description = this.input.ask(String.format("Enter new item description (%s): ", item.getDescription()));
        if (description.equals("")) {
            description = item.getDescription();
        }
        if (item instanceof Bug) {
            newItem = new Bug(name, description, item.getCreate());
        } else if (item instanceof Task) {
            newItem = new Task(name, description, item.getCreate());
        }
        newItem.setId(item.getId());
        this.tracker.update(newItem);
        newItem.setComments(item.getComment());
        this.sysMsg = String.format("Item %s updated!", item.getName());
        this.mineMenu();
    }

    /**
     * Show menu selected item.
     * @param item - selected item.
     */
    private void selectItem(Item item) {
        this.menu = String.format("\n%s%s%s%s%s",
                "1. Edit\n",
                "2. Delete\n",
                "3. Add comment\n",
                "0. Back to menu\n",
                "Select an action [0-3]:");
        do {
            this.menuHead();
            System.out.println(item.toString());
            for (Comment comment : item.getComment()) {
                int iterator = 1;
                if (comment != null) {
                    System.out.printf("\t\tComment %d: %s\n", iterator++, comment.getComment());
                }
            }
            this.menuSelect = this.input.ask(this.menu);
        } while (!(this.menuSelect.equals("1") || this.menuSelect.equals("2")
                || this.menuSelect.equals("3") || this.menuSelect.equals("0")));
        if (this.menuSelect.equals("1")) {
            this.editMenu(item);
        } else if (this.menuSelect.equals("2")) {
            this.sysMsg = String.format("Item %s deleted.", item.getName());
            this.tracker.delete(item);
            this.mineMenu();
        } else if (this.menuSelect.equals("3")) {
            String comment;
            do {
                comment = this.input.ask("Enter comment: ");
            } while (comment.equals(""));
            item.addComment(new Comment(comment));
            this.sysMsg = String.format("To %s added new comment!", item.getName());
            this.selectItem(item);
        } else {
            this.mineMenu();
        }
    }

    /**
     * list menu.
     */
    private void listMenu() {
        int iterator;
        int check = 0;
        this.menuHead();
        System.out.println("ItemsList:");
        for (iterator = 0; iterator != this.tracker.findAll().length; iterator++) {
            if (this.tracker.findAll()[iterator] != null) {
                System.out.printf("%d - %s", iterator + 1, this.tracker.findAll()[iterator].toString());
                check++;
            }
        }
        do {
            this.menuSelect = this.input.ask("Enter item id (0 - back to menu): ");
        } while (!this.isInt(this.menuSelect)
                || Integer.parseInt(this.menuSelect) < 0
                || Integer.parseInt(this.menuSelect) > check);
        if (this.menuSelect.equals("0")) {
            this.mineMenu();
        } else {
            this.selectItem(this.tracker.findAll()[Integer.parseInt(this.menuSelect) - 1]);
        }
    }

    /**
     * Find by name menu.
     */
    private void findMenu() {
        int iterator;
        int check = 0;
        String name = this.input.ask("Enter item name: ");
        if (name.equals("")) {
            this.listMenu();
        } else {
            this.sysMsg = String.format("Finding by item name: %s", name);
            this.menuHead();
            System.out.println("ItemsList:");
            for (iterator = 0; iterator != this.tracker.findByName(name).length; iterator++) {
                if (this.tracker.findByName(name)[iterator] != null) {
                    System.out.printf("%d - %s", iterator + 1, this.tracker.findByName(name)[iterator].toString());
                    check++;
                }
            }
            do {
                this.menuSelect = this.input.ask("Enter item id (0 - back to menu): ");
            } while (!this.isInt(this.menuSelect)
                    || Integer.parseInt(this.menuSelect) < 0
                    || Integer.parseInt(this.menuSelect) > check);
            if (this.menuSelect.equals("0")) {
                this.mineMenu();
            } else {
                this.selectItem(this.tracker.findByName(name)[Integer.parseInt(this.menuSelect) - 1]);
            }
        }
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
