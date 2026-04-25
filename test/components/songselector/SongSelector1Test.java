package components.songselector;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * JUnit test fixture for {@code SongSelector}'s constructor and kernel methods.
 *
 * @author Angelina Phin
 */
public class SongSelector1Test {

    /**
     * Invokes the appropriate {@code SongSelector} for the implementation and
     * returns the result.
     *
     * @return the new SongSelector
     * @ensures constructorTest = {}
     */
    protected final SongSelector constructor() {
        return new SongSelector1();
    }

    /**
     * Creates and returns a {@code SongSelector} of the implementation under
     * test type with the given entries.
     *
     * @param args
     *            the songs for the set
     * @return the constructed SongSelector
     * @requires <pre>
     * [args.length is even] and
     * [each entry in even indices can be parsed as an integer]
     * </pre>
     * @ensures createFromArgs = [entries in args]
     */
    protected SongSelector createFromArgs(String... args) {
        assert args.length % 2 == 0 : "Violation of: args.length is even";
        SongSelector songSelector = new SongSelector1();
        for (int i = 0; i < args.length; i += 2) {
            assert Character.isDigit(args[i + 1].charAt(
                    0)) : "Violation of: entry in even indice can be parsed as an int";
            songSelector
                    .insert(new Song(args[i], Integer.parseInt(args[i + 1])));
        }
        return songSelector;
    }

    /*
     * Constructor test case.
     */

    /**
     * Empty constructor.
     */
    @Test
    public void testConstructorEmpty() {
        /*
         * Set up variables.
         */
        SongSelector ss = new SongSelector1();
        SongSelector ssExpected = this.constructor();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(ssExpected, ss);
    }

    /*
     * insert test cases
     */

    /**
     * insert test case; adding a song to an empty SongSelector.
     */
    @Test
    public void testInsertZero() {
        /*
         * Set up variables.
         */
        SongSelector ss = new SongSelector1();
        SongSelector ssExpected = this.createFromArgs("Apple", "1");
        /*
         * Call method under test.
         */
        Song s = new Song("Apple", 1);
        ss.insert(s);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(ssExpected, ss);
    }

    /**
     * insert test case; adding a song to a SongSelector with one existing song.
     */
    @Test
    public void testInsertOne() {
        /*
         * Set up variables.
         */
        SongSelector ss = this.createFromArgs("Libertas", "10");
        SongSelector ssExpected = this.createFromArgs("Libertas", "10",
                "Modelista", "9");
        final int constant = 9;
        /*
         * Call method under test.
         */
        Song s = new Song("Modelista", constant);
        ss.insert(s);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(ssExpected, ss);
    }

    /**
     * insert test case; adding a song to a SongSelector with many songs.
     */
    @Test
    public void testInsertMany() {
        /*
         * Set up variables.
         */
        SongSelector ss = this.createFromArgs("CHAIN2NITE", "4",
                "My life is mine alone!", "2", "One Step Closer", "7",
                "Melty Rhapsody", "9");
        SongSelector ssExpected = this.createFromArgs("CHAIN2NITE", "4",
                "My life is mine alone!", "2", "One Step Closer", "7",
                "Melty Rhapsody", "9", "Signal", "10");
        final int constant = 10;
        /*
         * Call method under test.
         */
        Song s = new Song("Signal", constant);
        ss.insert(s);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(ssExpected, ss);
    }

    /*
     * remove test cases
     */

    /**
     * remove test case; remove the only existing song in a SongSelector.
     */
    @Test
    public void testRemoveZero() {
        /*
         * Set up variables.
         */
        SongSelector ss = this.createFromArgs("Be There", "9");
        SongSelector ssExpected = this.constructor();
        final int constant = 9;
        /*
         * Call method under test.
         */
        Song sExpected = new Song("Be There", constant);
        Song s = ss.remove(sExpected);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(ssExpected, ss);
    }

    /**
     * remove test case; removes one of two songs from a SongSelector.
     */
    @Test
    public void testRemoveOne() {
        /*
         * Set up variables.
         */
        SongSelector ss = this.createFromArgs("INSPION", "11", "Sairai", "13");
        SongSelector ssExpected = this.createFromArgs("INSPION", "11");
        final int constant = 13;
        /*
         * Call method under test.
         */
        Song sExpected = new Song("Sairai", constant);
        Song s = ss.remove(sExpected);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(ssExpected, ss);
    }

    /**
     * remove test case; removes one of many songs from a SongSelector.
     */
    @Test
    public void testRemoveMany() {
        /*
         * Set up variables.
         */
        SongSelector ss = this.createFromArgs("BOSS", "10", "The 7th Sense",
                "7", "WITHOUT YOU", "9", "TOUCH", "10", "GO", "7", "YESTODAY",
                "8", "Dream In A Dream", "14", "Black on Black", "18");
        SongSelector ssExpected = this.createFromArgs("BOSS", "10",
                "The 7th Sense", "7", "WITHOUT YOU", "9", "TOUCH", "10", "GO",
                "7", "YESTODAY", "8", "Dream In A Dream", "14");
        final int constant = 18;
        /*
         * Call method under test.
         */
        Song sExpected = new Song("Black on Black", constant);
        Song s = ss.remove(sExpected);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(ssExpected, ss);
    }

    /*
     * removeAny test cases
     */

    /**
     * removeAny test case; removes the only existing song arbitrarily from the
     * SongSelector.
     */
    @Test
    public void testRemoveAnyZero() {
        /*
         * Set up variables.
         */
        SongSelector ss = this.createFromArgs("SUNSET WITH YOU", "6");
        SongSelector ssExpected = this.constructor();
        final int sExpectedConstant = 6;
        /*
         * Call method under test.
         */
        Song s = ss.removeAny();
        Song sExpected = new Song("SUNSET WITH YOU", sExpectedConstant);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(ssExpected, ss);
    }

    /**
     * removeAny test case; removes one of two songs arbitrarily from the
     * SongSelector.
     */
    @Test
    public void testRemoveAnyOne() {
        /*
         * Set up variables.
         */
        SongSelector ss = this.createFromArgs("Pinky Up", "8", "Gnarly", "7");
        SongSelector ssExpected = this.createFromArgs("Pinky Up", "8", "Gnarly",
                "7");
        int initialSize = ss.size();
        /*
         * Call method under test.
         */
        Song s = ss.removeAny();
        ssExpected.remove(s);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(ssExpected.size(), initialSize - 1);
        assertEquals(ssExpected, ss);
    }

    /**
     * removeAny test case; removes one of many songs arbitrarily from the
     * SongSelector.
     */
    @Test
    public void testRemoveAnyMany() {
        /*
         * Set up variables.
         */
        SongSelector ss = this.createFromArgs("Underground", "10",
                "Sugar Free Venom", "12", "Magic Clock", "8", "Lettuce", "5",
                "Bow Chika Wow Wow", "9", "Firetruck", "1");
        SongSelector ssExpected = this.createFromArgs("Underground", "10",
                "Sugar Free Venom", "12", "Magic Clock", "8", "Lettuce", "5",
                "Bow Chika Wow Wow", "9", "Firetruck", "1");
        int initialSize = ss.size();
        /*
         * Call method under test.
         */
        Song s = ss.removeAny();
        ssExpected.remove(s);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(ssExpected.size(), initialSize - 1);
        assertEquals(ssExpected, ss);
    }

    /*
     * containsSong test cases
     */

    /**
     * containsSong true test case; expected test return value should be true.
     */
    @Test
    public void testContainsSongTrue() {
        /*
         * Set up variables.
         */
        SongSelector ss = this.createFromArgs("Virtual Self", "5");
        SongSelector ssCopy = this.createFromArgs("Virtual Self", "5");
        final int constant = 5;
        /*
         * Call method under test.
         */
        Song s = new Song("Virtual Self", constant);
        boolean containsSong = ss.containsSong(s);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(true, containsSong);
        assertEquals(ssCopy, ss);
    }

    /**
     * containsSong false test case; expected test return value should be false.
     */
    @Test
    public void testContainsSongFalse() {
        /*
         * Set up variables.
         */
        SongSelector ss = this.createFromArgs("Particle Arts", "8");
        SongSelector ssCopy = this.createFromArgs("Particle Arts", "8");
        final int constant = 7;
        /*
         * Call method under test.
         */
        Song s = new Song("Ghost Voices", constant);
        boolean containsSong = ss.containsSong(s);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(false, containsSong);
        assertEquals(ssCopy, ss);
    }

    /*
     * size test cases
     */

    /**
     * size test case with set size 0.
     */
    @Test
    public void testSizeZero() {
        /*
         * Set up variables.
         */
        SongSelector ss = this.constructor();
        SongSelector ssExpected = this.constructor();
        /*
         * Call method under test.
         */
        int size = ss.size();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(0, size);
        assertEquals(ssExpected, ss);
    }

    /**
     * size test case with set size 1.
     */
    @Test
    public void testSizeOne() {
        /*
         * Set up variables.
         */
        SongSelector ss = this.createFromArgs("Nod Krai", "1");
        SongSelector ssExpected = this.createFromArgs("Nod Krai", "1");
        /*
         * Call method under test.
         */
        int size = ss.size();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(1, size);
        assertEquals(ssExpected, ss);
    }

    /**
     * size test case with set size 6.
     */
    @Test
    public void testSizeMany() {
        /*
         * Set up variables.
         */
        SongSelector ss = this.createFromArgs("ABCD", "4", "POP!", "8", "FANCY",
                "9", "Look at Me", "7", "Strategy", "10", "TT", "15");
        SongSelector ssExpected = this.createFromArgs("ABCD", "4", "POP!", "8",
                "FANCY", "9", "Look at Me", "7", "Strategy", "10", "TT", "15");
        final int sizeExpected = 6;
        /*
         * Call method under test.
         */
        int size = ss.size();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sizeExpected, size);
        assertEquals(ssExpected, ss);
    }
}
