package ru.nkotkin.start;

import ru.nkotkin.models.Bug;
import ru.nkotkin.models.Comment;
import ru.nkotkin.models.Item;
import ru.nkotkin.models.Task;

/**
 * Edit items class.
 */
class EditItem implements UserAction {

    /**
     * Key of menu action.
     *
     * @return int key.
     */
    @Override
    public int key() {
        return 2;
    }

    /**
     * Perfomens basic action.
     *
     * @param inputArg   input type.
     * @param trackerArg tracker
     */
    @Override
    public void execute(Input inputArg, Tracker trackerArg) {
        String id = inputArg.ask("Please, input item id: ");
        Item item = trackerArg.findById(Integer.valueOf(id));
        Item newItem = null;
        String name = inputArg.ask(String.format("Please, enter new name (%s): ", item.getName()));
        if (name.equals("")) {
            name = item.getName();
        }
        String description = inputArg.ask(String.format("Please, enter new description (%s): ", item.getDescription()));
        if (description.equals("")) {
            description = item.getDescription();
        }
        if (!item.equals(null)) {
            if (item instanceof Bug) {
                newItem = new Bug(name, description, item.getCreate());
            } else if (item instanceof Task) {
                newItem = new Task(name, description, item.getCreate());
            }
            newItem.setId(item.getId());
            trackerArg.update(newItem);
            newItem.setComments(item.getComment());
        }
    }

    /**
     * info about action.
     *
     * @return info string.
     */
    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "Edit the item.");
    }

}

/**
 * Created by nkotkin on 2/5/17.
 */
public class MenuTracker {

    /**
     * Menu list num.
     */
    private static final int MENU_NUM = 6;

    /**
     * Add menu num.
     */
    private static final int ID_ADD_ITEM = 0;

    /**
     * Show items num.
     */
    private static final int ID_SHOW_ITEMS = 1;

    /**
     * Edit item num.
     */
    private static final int ID_EDIT_ITEM = 2;

    /**
     * Delete item num.
     */
    private static final int ID_DELETE_ITEMS = 3;

    /**
     * Find my name num.
     */
    private static final int ID_FIND_BY_NAME = 4;

    /**
     * Add comment num.
     */
    private static final int ID_ADD_COMMENT = 5;

    /**
     * input type.
     */
    private Input input;
    /**
     * tracker type.
     */
    private Tracker tracker;
    /**
     * Array of actions.
     */
    private UserAction[] actions = new UserAction[MENU_NUM];

    /**
     * Constructor.
     * @param inputArg input type.
     * @param trackerArg tracker type.
     */
    public MenuTracker(Input inputArg, Tracker trackerArg) {
        this.input = inputArg;
        this.tracker = trackerArg;
    }

    /**
     * initialization.
     */
    public final void fillAction() {
        this.actions[ID_ADD_ITEM] = this.new AddItem(); // Inner class
        this.actions[ID_SHOW_ITEMS] = new MenuTracker.ShowItems(); // Static class
        this.actions[ID_EDIT_ITEM] = new EditItem(); // Class in class
        this.actions[ID_DELETE_ITEMS] = this.new DeleteItem();
        this.actions[ID_FIND_BY_NAME] = this.new FindByName();
        this.actions[ID_ADD_COMMENT] = this.new AddComment();
    }

    /**
     * Select menu.
     * @param key - menu key.
     */
    public final void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    /**
     * Show main menu.
     */
    public final void show() {
        for (UserAction action : actions) {
            if (action != null) {
                System.out.printf("%s\n", action.info());
            }
        }
    }

    /**
     * Add item menu.
     */
    private class AddItem implements UserAction {

        /**
         * Key of menu action.
         * @return int key 0 for add menu.
         */
        @Override
        public int key() {
            return ID_ADD_ITEM;
        }

        /**
         * Perfomens basic action.
         *
         * @param inputArg   input type.
         * @param trackerArg tracker
         */
        @Override
        public void execute(Input inputArg, Tracker trackerArg) {
            String type = inputArg.ask("Please, select item type (1 - Task, 2 - Bug): ");
            if (type.equals("1")) {
                String name = inputArg.ask("Please, enter the task's name: ");
                String desc = inputArg.ask("Please, enter the task's desc: ");
                trackerArg.add(new Task(name, desc, System.currentTimeMillis()));
            } else if (type.equals("2")) {
                String name = inputArg.ask("Please, enter the bug's name: ");
                String desc = inputArg.ask("Please, enter the bug's desc: ");
                trackerArg.add(new Bug(name, desc, System.currentTimeMillis()));
            }
        }

        /**
         * info about action.
         *
         * @return info string.
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Add the new item.");
        }
    }

    /**
     * Delete item menu.
     */
    private class DeleteItem implements UserAction {

        /**
         * Key of menu action.
         *
         * @return int key.
         */
        @Override
        public int key() {
            return ID_DELETE_ITEMS;
        }

        /**
         * Perfomens basic action.
         *
         * @param inputArg   input type.
         * @param trackerArg tracker
         */
        @Override
        public void execute(Input inputArg, Tracker trackerArg) {
            String id = inputArg.ask("Please, input item id: ");
            Item item = trackerArg.findById(Integer.valueOf(id));
            trackerArg.delete(item);
        }

        /**
         * info about action.
         *
         * @return info string.
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Delete the item.");
        }
    }

    /**
     * Add comment to item.
     */
    private class AddComment implements UserAction {

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
            String id = inputArg.ask("Please, input item id: ");
            Item item = trackerArg.findById(Integer.valueOf(id));
            String comment = inputArg.ask("Enter comment: ");
            item.addComment(new Comment(comment));
        }

        /**
         * info about action.
         *
         * @return info string.
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Add comment to the item.");
        }
    }

    /**
     * Find by name.
     */
    private class FindByName implements UserAction {

        /**
         * Key of menu action.
         *
         * @return int key.
         */
        @Override
        public int key() {
            return ID_FIND_BY_NAME;
        }

        /**
         * Perfomens basic action.
         *
         * @param inputArg   input type.
         * @param trackerArg tracker
         */
        @Override
        public void execute(Input inputArg, Tracker trackerArg) {
            String name = inputArg.ask("Please, enter item name: ");
            for (int iterator = 0; iterator != trackerArg.findByName(name).length; iterator++) {
                if (trackerArg.findByName(name)[iterator] != null) {
                    MenuTracker.printItem(trackerArg.findByName(name)[iterator]);
                }
            }
        }

        /**
         * info about action.
         *
         * @return info string.
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find items by name.");
        }

    }

    /**
     * printing item.
     * @param itemArg finded item.
     */
    private static void printItem(Item itemArg) {
        int commentIndex = 1;
        if (itemArg instanceof Bug) {
            System.out.print(((Bug) itemArg).toString());
        } else if (itemArg instanceof Task) {
            System.out.print(((Task) itemArg).toString());
        }
        for (Comment comment : itemArg.getComment()) {
            if (comment != null) {
                System.out.printf("\t\tComment %d: %s\n", commentIndex++, comment.getComment());
            }
        }
        System.out.println();
    }

    /**
     * show item list.
     */
    private static class ShowItems implements UserAction {

        /**
         * Key of menu action.
         *
         * @return int key.
         */
        @Override
        public int key() {
            return ID_SHOW_ITEMS;
        }

        /**
         * Perfomens basic action.
         *
         * @param inputArg   input type.
         * @param trackerArg tracker
         */
        @Override
        public void execute(Input inputArg, Tracker trackerArg) {
            for (int iterator = 0; iterator != trackerArg.findAll().length; iterator++) {
                if (trackerArg.findAll()[iterator] != null) {
                    MenuTracker.printItem(trackerArg.findAll()[iterator]);
                }
            }
        }

        /**
         * info about action.
         *
         * @return info string.
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Show all items.");
        }

    }

}
