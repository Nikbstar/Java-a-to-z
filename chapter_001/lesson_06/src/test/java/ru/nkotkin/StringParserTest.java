package ru.nkotkin;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Tests for StringParser.java.
 */
public class StringParserTest {

    /**
     * inicialize.
     */
    private StringParser strParser;

    /**
     * inicialize.
     */
    @Before
    public final void inicialize() {
        strParser = new StringParser();
    }

    /**
     * whenSubStringInCenterThenReturnTrue.
     */
    @Test
    public final void whenSubStringInCenterThenReturnTrue() {
        /**
        * original string.
        */
        String origin = "One two three";
        /**
        * sub string.
        */
        String sub = "two";

        assertThat(strParser.contains(origin, sub), is(true));
    }

    /**
     * whenSubStringInStartThenReturnTrue.
     */
    @Test
    public final void whenSubStringInStartThenReturnTrue() {
        /**
        * original string.
        */
        String origin = "two three";
        /**
        * sub string.
        */
        String sub = "two";

        assertThat(strParser.contains(origin, sub), is(true));
    }

    /**
     * whenSubStringInEndThenReturnTrue.
     */
    @Test
    public final void whenSubStringInEndThenReturnTrue() {
        /**
        * original string.
        */
        String origin = "One two";
        /**
        * sub string.
        */
        String sub = "two";

        assertThat(strParser.contains(origin, sub), is(true));
    }

    /**
     * whenSubStringInEndThenReturnTrue.
     */
    @Test
    public final void whenOriginStringEqualSubStringThenReturnTrue() {
        /**
        * original string.
        */
        String origin = "two";
        /**
        * sub string.
        */
        String sub = "two";

        assertThat(strParser.contains(origin, sub), is(true));
    }

    /**
     * whenNoSubStringThenReturnFalse.
     */
    @Test
    public final void whenNoSubStringThenReturnFalse() {
        /**
        * original string.
        */
        String origin = "One twe three";
        /**
        * sub string.
        */
        String sub = "two";

        assertThat(strParser.contains(origin, sub), is(false));
    }

}
