package ru.nkotkin.start;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import ru.nkotkin.models.Bug;
import ru.nkotkin.models.Item;
import ru.nkotkin.models.Task;

/**
 * Created by Nikolay Kotkin on 28.11.2016.
 */
public class TrackerTest {

    /**
     * Create tracker.
     */
    private Tracker tracker;
    /**
     * Create item.
     */
    private Item firstTask;
    /**
     * NAME_FILTER.
     */
    private static final String NAME_FILTER = "bug";

    /**
     * initialize.
     */
    @Before
    public final void initialize() {
        tracker = new Tracker();
        firstTask = new Task("First task", "Task for testing", 1L);
        tracker.add(firstTask);
    }

    /**
     * whenAddNewItemThenItMustBeAdded.
     * @throws Exception any
     */
    @Test
    public final void whenAddNewItemThenItMustBeAdded() throws Exception {
        assertThat(firstTask, is(tracker.findAll()[0]));
    }

    /**
     * whenEditFirstTaskThenItChangeOnTmp.
     * @throws Exception any
     */
    @Test
    public final void whenEditFirstTaskThenItChangeOnTmp() throws Exception {
        Item tmp = new Task("Edit name", "Edit description", 1L);
        tmp.setId(firstTask.getId());
        tracker.update(tmp);
        assertThat(tmp, is(tracker.findAll()[0]));
    }

    /**
     * whenDeleteFirstTaskThenSecondTaskWillReplaseIt.
     * @throws Exception any
     */
    @Test
    public final void whenDeleteFirstTaskThenItWillBeNull() throws Exception {
        tracker.delete(firstTask);
        assertThat(null, is(tracker.findAll()[0]));
    }

    /**
     * whenSetFilterByBugThenGetArrayWithBugs.
     * @throws Exception any
     */
    @Test
    public final void whenSetFilterByBugThenGetArrayWithBugs() throws Exception {
        Item secondTask = new Task("Second task", "Task for testing", 1L);
        Item firstBug = new Bug("First bug", "Bug for testing", 1L);
        tracker.add(secondTask);
        tracker.add(firstBug);
        assertThat(firstBug, is(tracker.findByName(NAME_FILTER)[0]));
    }

}
