package ru.nkotkin;

/**
 * Создать программу проверяющую,
 * что строка sub является подстрокой origin.
 * boolean contains(String origin, String sub).
 * Нельзя использовать String.indexOf String.contains.
 * Нужно преобразовать строку в массив символов и проверить.
 */
public class StringParser {

    /**
     * check contains.
     * @param origin - Original string
     * @param sub - sub string
     * @return boolean true if sub string is sub for original
     */
    public final boolean contains(final String origin, final String sub) {
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
    private char[] strToCharArray(final String str) {
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
