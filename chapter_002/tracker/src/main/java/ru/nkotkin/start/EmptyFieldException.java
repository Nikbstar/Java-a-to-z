package ru.nkotkin.start;

/**
 * Created by nkotkin on 2/13/17.
 */
public class EmptyFieldException extends RuntimeException {

    /**
     * Empty field exception.
     * @param msg Exception message.
     */
    public EmptyFieldException(String msg) {
        super(msg);
    }

}
