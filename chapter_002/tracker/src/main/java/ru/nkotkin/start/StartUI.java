package ru.nkotkin.start;

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
    private Tracker tracker;

    /**
     * Instantiates a new Start ui.
     *
     * @param argInput the arg input.
     * @param trackerArg a new tracker
     */
    public StartUI(Input argInput, Tracker trackerArg) {
        this.input = argInput;
        this.tracker = trackerArg;
    }

    /**
     * Mine menu.
     */
    public final void mainMenu() {
        MenuTracker mainMenu = new MenuTracker(this.input, this.tracker);
        mainMenu.fillAction();
        do {
            mainMenu.show();
            int key = Integer.valueOf(input.ask("Select: "));
            mainMenu.select(key);
        } while (!"y".equals(this.input.ask("Exit? (y/N): ")));
    }

    /**
     * Starter.
     * @param args - command line args
     */
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        new StartUI(input, new Tracker()).mainMenu();
    }
}
