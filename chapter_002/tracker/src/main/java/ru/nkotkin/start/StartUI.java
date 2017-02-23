package ru.nkotkin.start;

import ru.nkotkin.models.Comment;
import ru.nkotkin.models.Item;

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
     * Add comment num.
     */
    private static final int ID_ADD_COMMENT = 5;

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
    public final void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillAction();
        UserAction addComment = new BaseAction("Add comment to the item.") {

            /**
             * Key of menu action.
             *
             * @return int key.
             */
            @Override
            public int key() {
                return ID_ADD_COMMENT;
            }

            /**
             * Perfomens basic action.
             *
             * @param inputArg   input type.
             * @param trackerArg tracker
             */
            @Override
            public void execute(Input inputArg, Tracker trackerArg) {
                if (trackerArg.getItemsNum() == 0) {
                    System.out.println("No items in tracker!");
                } else {
                    int[] items = new int[trackerArg.getItemsNum()];
                    int length = 0;
                    for (int iterator = 0; iterator != trackerArg.findAll().length; iterator++) {
                        if (!(trackerArg.findAll()[iterator] == null)) {
                            items[length++] = trackerArg.findAll()[iterator].getId();
                        }
                    }
                    int id = inputArg.ask("Please, input item id: ", items);
                    Item item = trackerArg.findById(id);
                    String comment = inputArg.ask("Enter comment: ");
                    System.out.printf("Comment added to %s\n", item.getName());
                    item.addComment(new Comment(comment));
                }
            }

        };
        menu.addAction(addComment);
        do {
            menu.show();
            menu.select(input.ask("Select: ", menu.getRange()));
        } while (!"y".equals(this.input.ask("Exit? (y/n): ")));
    }

    /**
     * Starter.
     * @param args - command line args
     */
    public static void main(String[] args) {
        Input input = new ValidateInput();
        new StartUI(input, new Tracker()).init();
    }
}
