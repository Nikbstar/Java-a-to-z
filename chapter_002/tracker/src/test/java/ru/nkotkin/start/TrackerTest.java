package ru.nkotkin.start;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Nikolay Kotkin on 28.11.2016.
 */
public class TrackerTest {
    /**
     * whenThen.
     * @throws Exception any
     */
    @Test
    public void whenThen() throws Exception {
        assertThat(5, is(5));
    }

}
