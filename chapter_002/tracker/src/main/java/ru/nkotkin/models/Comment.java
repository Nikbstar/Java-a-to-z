package ru.nkotkin.models;

/**
 * Created by nkotkin on 1/22/17.
 */
public class Comment {
    /**
     * Comment.
     */
    private String comment;

    /**
     * Constructor.
     * @param commentArg set comment.
     */
    public Comment(String commentArg) {
        this.comment = commentArg;
    }

    /**
     * Getter coment.
     * @return comment.
     */
    public final String getComment() {
        return comment;
    }
}
