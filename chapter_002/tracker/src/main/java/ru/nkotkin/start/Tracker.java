package ru.nkotkin.start;

import ru.nkotkin.models.Item;

import java.util.Random;

/**
 * Created by Nikolay Kotkin on 21.11.2016.
 *
 * Реализовать класс Tracker. Класс трекер - это обертка над массивом.
 * Для удобного использования в остальном коде проекта.
 * 1. В классе должно быть поле private Item[] items
 * 2. Данный класс используется, как хранилище для заявок.
 * 3. В нем должны быть методы: добавление, редактирования,
 *      удаления, получения списка всех заявок и списка по фильтру.
 * Item add(Item);
 * void update(Item); - метод должен заменить ячейку в массиве.
 *      найти ячейку надо по циклу сравнивая getId.
 *      Обязательно принимать один параметр Item. а не список полей.
 * void delete(Item);
 * Item[] findAll();
 * Item[] findByName(String key);
 * Item findById(String id);
 * Каждый метод должен работать с массивом this.items
 * На каждый метод должен быть написан тест.
 * Здесь не должно быть системы ввода вывода -
 *      ни каких System.in System.out.println.
 *      Задание будет отклоняться. если в коде будут System.in или System.out.
 * Проверьте - эти пункты обязательно.
 */
final class Tracker {

    /**
     * Items limit.
     */
    private static final int ITEMS_LIMIT = 10;
    /**
     * Random num for item id.
     */
    private static final Random RN = new Random();

    /**
     * Items list.
     */
    private Item[] items = new Item[ITEMS_LIMIT];

    /**
     * id for item.
     */
    private static int itemId = 1;

    /**
     * Default constructor.
     */
    Tracker() {
    }

    /**
     * Add item in tracker.
     * @param itemArg - new item
     */
    public void add(Item itemArg) {
        itemArg.setId(this.generateId());
        for (int iterator = 0; iterator != this.items.length; iterator++) {
            if (this.items[iterator] == null) {
                this.items[iterator] = itemArg;
                break;
            }
        }
    }

    /**
     * Update item.
     * @param itemArg item
     */
    public void update(Item itemArg) {
        for (int iterator = 0; iterator != this.items.length; iterator++) {
            if (this.items[iterator] != null && this.items[iterator].getId() == itemArg.getId()) {
                this.items[iterator] = itemArg;
                break;
            }
        }
    }

    /**
     * Delete item.
     * @param itemArg - item for deleting
     */
    public void delete(Item itemArg) {
        for (int iterator = 0; iterator != this.items.length; iterator++) {
            if (this.items[iterator] != null && this.items[iterator].getId() == itemArg.getId()) {
                    this.items[iterator] = null;
                break;
            }
        }
    }

    /**
     * Find all items.
     * @return Array with all created item's.
     */
    public Item[] findAll() {
        Item[] result = new Item[this.items.length];
        for (int iterator = 0; iterator != this.items.length; iterator++) {
            result[iterator] = this.items[iterator];
        }
        return result;
    }

    /**
     * nimber of items.
     * @return number of items.
     */
    public int getItemsNum() {
        int result = 0;
        for (Item item : this.findAll()) {
            if (item != null) {
                result++;
            }
        }
        return result;
    }

    /**
     * Find items filter by name.
     * @param nameFilter - Filter by name
     * @return array of items
     */
    public Item[] findByName(String nameFilter) {
        int resultIterator = 0;
        Item[] result = new Item[this.items.length];

        for (int iterator = 0; iterator != this.items.length; iterator++) {
            if (this.items[iterator] != null && this.contains(this.items[iterator].getName(), nameFilter)) {
                result[resultIterator++] = this.items[iterator];
            }
        }
        return result;
    }

    /**
     * Find item by id.
     * @param id - item id
     * @return found item
     */
    public Item findById(int id) {
        Item result = null;
        for (Item item : this.items) {
            if (item != null && item.getId() == id) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Generate item id.
     * @return item id
     */
    private int generateId() {
        return Tracker.itemId++; //Math.abs((int) System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * check contains.
     * @param origin - Original string
     * @param sub - sub string
     * @return boolean true if sub string is sub for original
     */
    private boolean contains(String origin, String sub) {
        /**
         * result.
         */
        boolean result = false;
        /**
         * array for origin string.
         */
        char[] originArr = new char[origin.length()];
        /**
         * array for sub string.
         */
        char[] subArr = new char[sub.length()];
        /**
         * iterator for origin array.
         */
        int originIterator;
        /**
         * iterator for sub array.
         */
        int subIterator;

        originArr = strToCharArray(origin);
        subArr = strToCharArray(sub);
        for (originIterator = 0; originIterator != originArr.length - subArr.length + 1; originIterator++) {
            if (result) {
                break;
            }
            for (subIterator = 0;
                 subIterator != subArr.length && originIterator + subIterator != originArr.length;
                 subIterator++) {
                if (originArr[originIterator + subIterator] == subArr[subIterator]) {
                    result = true;
                } else {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * string to char array.
     * @param str - string
     * @return array of chars
     */
    private char[] strToCharArray(String str) {

        /**
         * array of chars.
         */
        char[] resultArr = new char[str.length()];

        for (int iterator = 0; iterator != resultArr.length; iterator++) {
            resultArr[iterator] = str.charAt(iterator);
        }

        return resultArr;
    }

}
