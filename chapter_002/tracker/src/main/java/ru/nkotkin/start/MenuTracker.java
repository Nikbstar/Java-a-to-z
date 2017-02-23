package ru.nkotkin.start;

import ru.nkotkin.models.Bug;
import ru.nkotkin.models.Comment;
import ru.nkotkin.models.Item;
import ru.nkotkin.models.Task;

/**
 * Edit items class.
 */
class EditItem extends BaseAction {

    /**
     * Constructor.
     *
     * @param nameArg name of action.
     */
    EditItem(String nameArg) {
        super(nameArg);
    }

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
            Item newItem = null;
            String name = inputArg.ask(String.format("Please, enter new name (%s): ", item.getName()));
            String description = inputArg.ask(String.format("Please, enter new description (%s): ",
                                              item.getDescription()));
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
     * array of menu's keys.
     */
    private int[] range = {ID_ADD_ITEM, ID_SHOW_ITEMS, ID_EDIT_ITEM, ID_DELETE_ITEMS, ID_FIND_BY_NAME, ID_ADD_COMMENT};

    /**
     * Item task.
     */
    private static final int ITEM_TASK = 1;

    /**
     * Item bug.
     */
    private static final int ITEM_BUG = 2;

    /**
     * menu position.
     */
    private int menuPosition = 0;

    /**
     * array of item's keys.
     */
    private int[] rangeItems = {ITEM_TASK, ITEM_BUG};

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
        this.actions[ID_ADD_ITEM] = this.new AddItem("Add the new item."); // Inner class
        this.menuPosition++;
        this.actions[ID_SHOW_ITEMS] = new MenuTracker.ShowItems("Show all items."); // Static class
        this.menuPosition++;
        this.actions[ID_EDIT_ITEM] = new EditItem("Edit the item."); // Class in class
        this.menuPosition++;
        this.actions[ID_DELETE_ITEMS] = this.new DeleteItem("Delete the item.");
        this.menuPosition++;
        this.actions[ID_FIND_BY_NAME] = this.new FindByName("Find items by name.");
        this.menuPosition++;
    }

    /**
     * Add menu.
     * @param action menu.
     */
    public void addAction(UserAction action) {
        this.actions[this.menuPosition++] = action; // Anonim class in StartUI
    }

    /**
     * getter for range.
     * @return range's array.
     */
    public final int[] getRange() {
        return this.range;
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
    private class AddItem extends BaseAction {

        /**
         * Constructor.
         *
         * @param nameArg name of action.
         */
        AddItem(String nameArg) {
            super(nameArg);
        }

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
            int type = inputArg.ask("Please, select item type (1 - Task, 2 - Bug): ", rangeItems);
            if (type == ITEM_TASK) {
                String name = inputArg.ask("Please, enter the task's name: ");
                String desc = inputArg.ask("Please, enter the task's desc: ");
                trackerArg.add(new Task(name, desc, System.currentTimeMillis()));
            } else if (type == ITEM_BUG) {
                String name = inputArg.ask("Please, enter the bug's name: ");
                String desc = inputArg.ask("Please, enter the bug's desc: ");
                trackerArg.add(new Bug(name, desc, System.currentTimeMillis()));
            }
        }

    }

    /**
     * Delete item menu.
     */
    private class DeleteItem extends BaseAction {

        /**
         * Constructor.
         *
         * @param nameArg name of action.
         */
        DeleteItem(String nameArg) {
            super(nameArg);
        }

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
                System.out.printf("Item %s deleted!\n", item.getName());
                trackerArg.delete(item);
            }
        }

    }

    /**
     * Find by name.
     */
    private class FindByName extends BaseAction {

        /**
         * Constructor.
         *
         * @param nameArg name of action.
         */
        FindByName(String nameArg) {
            super(nameArg);
        }

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
            if (trackerArg.getItemsNum() == 0) {
                System.out.println("No items in tracker!");
            } else {
                String name = inputArg.ask("Please, enter item name: ");
                int itemsNum = 0;
                for (int iterator = 0; iterator != trackerArg.findByName(name).length; iterator++) {
                    if (trackerArg.findByName(name)[iterator] != null) {
                        MenuTracker.printItem(trackerArg.findByName(name)[iterator]);
                        itemsNum++;
                    }
                }
                System.out.printf("Items found: %d\n", itemsNum);
            }
        }

    }

    /**
     * printing item.
     * @param itemArg found item.
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
    private static class ShowItems extends BaseAction {

        /**
         * Constructor.
         *
         * @param nameArg name of action.
         */
        ShowItems(String nameArg) {
            super(nameArg);
        }

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
            if (trackerArg.getItemsNum() == 0) {
                System.out.println("No items in tracker!");
            } else {
                for (int iterator = 0; iterator != trackerArg.findAll().length; iterator++) {
                    if (trackerArg.findAll()[iterator] != null) {
                        MenuTracker.printItem(trackerArg.findAll()[iterator]);
                    }
                }
            }
        }

    }

}
