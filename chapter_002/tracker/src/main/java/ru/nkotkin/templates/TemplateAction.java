package ru.nkotkin.templates;

/**
 * Created by nkotkin on 2/23/17.
 */
public abstract class TemplateAction {

    /**
     * Constructor for abstract class.
     * @param name name.
     */
    public TemplateAction(String name) {
    }

    /**
     * start method.
     */
    abstract void start();

    /**
     * finish method.
     */
    abstract void finish();

    /**
     * work method.
     */
    public void work() {
        this.start();
        this.finish();
    }

    /**
     * mine method.
     * @param args mine args.
     */
    public static void main(String[] args) {
        new TemplateAction("Name") {

            /**
             * start method.
             */
            @Override
            void start() {
            }

            /**
             * finish method.
             */
            @Override
            void finish() {
            }
        };
        //new CopyAction();
    }

}
