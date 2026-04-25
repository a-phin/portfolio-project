package components.songselector;

import static org.junit.Assert.assertEquals;

import java.util.Comparator;

import org.junit.Test;

import components.songselector.SongSelectorSecondary.ConstantSort;
import components.songselector.SongSelectorSecondary.TitleSort;

/**
 * JUnit test fixture for {@code SongSelector}'s secondary methods.
 *
 * @author Angelina Phin
 */
public class SongSelectorSecondaryTest extends SongSelector1Test {

    /*
     * combineSongList test cases
     */

    /**
     * combineSongList test case; appending an empty SongSelector to an empty
     * SongSelector.
     */
    @Test
    public void testCombineSongListZero() {
        /*
         * Set up variables.
         */
        SongSelector ss = new SongSelector1();
        SongSelector ssAppended = new SongSelector1();
        SongSelector ssExpected = new SongSelector1();
        /*
         * Call method under test.
         */
        ss.combineSongList(ssAppended);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(0, ss.size());
        assertEquals(0, ssAppended.size());
        assertEquals(ssExpected, ss);
    }

    /**
     * combineSongList test case; appending a SongSelector with an existing song
     * to a SongSelector with one existing song.
     */
    @Test
    public void testCombineSongListOne() {
        /*
         * Set up variables.
         */
        SongSelector ss = this.createFromArgs("ARTPOP", "8");
        SongSelector ssAppended = this.createFromArgs("G.U.Y", "9");
        SongSelector ssExpected = this.createFromArgs("ARTPOP", "8", "G.U.Y",
                "9");
        /*
         * Call method under test.
         */
        ss.combineSongList(ssAppended);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(2, ss.size());
        assertEquals(0, ssAppended.size());
        assertEquals(ssExpected, ss);
    }

    /**
     * combineSongList test case; appending a SongSelector with a preexisting
     * songs to a SongSelector also with preexisting songs.
     */
    @Test
    public void testCombineSongListMany() {
        /*
         * Set up variables.
         */
        SongSelector ss = this.createFromArgs("Survive", "6",
                "Bullet Waiting For Me", "9");
        SongSelector ssAppended = this.createFromArgs("Take Me to the Future",
                "11", "Alb", "13");
        SongSelector ssExpected = this.createFromArgs("Survive", "6",
                "Bullet Waiting For Me", "9", "Take Me to the Future", "11",
                "Alb", "13");
        final int ssExpectedSize = 4;
        /*
         * Call method under test.
         */
        ss.combineSongList(ssAppended);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(ssExpectedSize, ss.size());
        assertEquals(0, ssAppended.size());
        assertEquals(ssExpected, ss);
    }

    /*
     * showSongs test cases
     */

    /**
     * showSongs test case; should return a SongSelector with zero songs with
     * the provided constant value.
     */
    @Test
    public void testShowSongsZero() {
        /*
         * Set up variables.
         */
        SongSelector ss = this.createFromArgs("Sizzle", "10", "work", "11",
                "rollerblade", "12");
        SongSelector ssExpected = this.createFromArgs("Sizzle", "10", "work",
                "11", "rollerblade", "12");
        SongSelector ss1Expected = new SongSelector1();
        /*
         * Call method under test.
         */
        SongSelector ss1 = ss.showSongs(1);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(ss1Expected, ss1);
        assertEquals(ssExpected, ss);
    }

    /**
     * showSongs test case; should return a SongSelector with one song with the
     * provided constant value.
     */
    @Test
    public void testShowSongsOne() {
        /*
         * Set up variables.
         */
        SongSelector ss = this.createFromArgs("Stager", "9", "Lethal Voltage",
                "10", "Grievous Lady", "11");
        SongSelector ssExpected = this.createFromArgs("Stager", "9",
                "Lethal Voltage", "10", "Grievous Lady", "11");
        SongSelector ss9Expected = this.createFromArgs("Stager", "9");
        final int constant = 9;
        /*
         * Call method under test.
         */
        SongSelector ss9 = ss.showSongs(constant);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(ss9Expected, ss9);
        assertEquals(ssExpected, ss);
    }

    /**
     * showSongs test case; should return a SongSelector with many songs with
     * the provided constant value.
     */
    @Test
    public void testShowSongsMany() {
        /*
         * Set up variables.
         */
        SongSelector ss = this.createFromArgs("Toxic", "13", "Womanizer", "12",
                "Vulgar", "15", "Oscar Winning Tears.", "12",
                "WHERE IS MY HUSBAND!", "11", "Illegal", "9", "Airtraveler",
                "12", "Donatella", "12");
        SongSelector ssExpected = this.createFromArgs("Toxic", "13",
                "Womanizer", "12", "Vulgar", "15", "Oscar Winning Tears.", "12",
                "WHERE IS MY HUSBAND!", "11", "Illegal", "9", "Airtraveler",
                "12", "Donatella", "12");
        SongSelector ss12Expected = this.createFromArgs("Womanizer", "12",
                "Oscar Winning Tears.", "12", "Airtraveler", "12", "Donatella",
                "12");
        final int constant = 12;
        /*
         * Call method under test.
         */
        SongSelector ss12 = ss.showSongs(constant);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(ss12Expected, ss12);
        assertEquals(ssExpected, ss);
    }

    /*
     * sort test cases
     */

    /**
     * sort test case, sorting the SongSelector in alphabetical order.
     */
    @Test
    public void testSortAToZ() {
        /*
         * Set up variables.
         */
        SongSelector ss = this.createFromArgs("Auxesia", "6", "Phantasia", "5",
                "Alexandrite", "10", "Mirzam", "9", "Empire of Winter", "3",
                "Xeraphinite", "7", "dropdead", "8", "Filament", "9");
        SongSelector ssExpected = this.createFromArgs("Alexandrite", "10",
                "Auxesia", "6", "dropdead", "8", "Empire of Winter", "3",
                "Filament", "9", "Mirzam", "9", "Phantasia", "5",
                "Xeraphinite", "7");
        /*
         * Call method under test.
         */
        Comparator<Song> aToZ = new TitleSort();
        ss.sort(aToZ, false);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(ssExpected, ss);
    }

    /**
     * sort test case, sorting the SongSelector in reverse alphabetical order.
     */
    @Test
    public void testSortZToA() {
        /*
         * Set up variables.
         */
        SongSelector ss = this.createFromArgs("Deep Dive", "9", "Dark Madness",
                "15", "Crimson Fate", "13", "Familiar Craze", "10", "Malstream",
                "11", "V.R.W.", "9");
        SongSelector ssExpected = this.createFromArgs("V.R.W.", "9",
                "Malstream", "11", "Familiar Craze", "10", "Deep Dive", "9",
                "Dark Madness", "15", "Crimson Fate", "13");
        /*
         * Call method under test.
         */
        Comparator<Song> zToA = new TitleSort();
        ss.sort(zToA, false);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(ssExpected, ss);
    }

    /**
     * sort test case, sorting the SongSelector by increasing constant order.
     */
    @Test
    public void testSortIncreasingNumericalOrder() {
        /*
         * Set up variables.
         */
        SongSelector ss = this.createFromArgs("First Snow", "3", "Paper Witch",
                "8", "Coastal Highway", "5", "Blue Rose", "10", "Turbocharger",
                "7", "Vandalism", "13");
        SongSelector ssExpected = this.createFromArgs("First Snow", "3",
                "Coastal Highway", "5", "Turbocharger", "7", "Paper Witch", "8",
                "Blue Rose", "10", "Vandalism", "13");
        /*
         * Call method under test.
         */
        Comparator<Song> increasingOrder = new ConstantSort();
        ss.sort(increasingOrder, true);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(ssExpected, ss);
    }

    /**
     * sort test case, sorting the SongSelector by decreasing constant order.
     */
    @Test
    public void testSortDecreasingNumericalOrder() {
        /*
         * Set up variables.
         */
        SongSelector ss = this.createFromArgs("Body Talk", "3", "Kanata", "1",
                "Fireflies", "9", "Gravity", "8", "Re:Boost", "15",
                "Green Hope", "9", "Under the Same Sky", "6");
        SongSelector ssExpected = this.createFromArgs("Re:Boost", "15",
                "Fireflies", "9", "Green Hope", "9", "Gravity", "8",
                "Under the Same Sky", "6", "Body Talk", "3", "Kanata", "1");
        /*
         * Call method under test.
         */
        Comparator<Song> decreasingOrder = new ConstantSort();
        ss.sort(decreasingOrder, true);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(ssExpected, ss);
    }

    /*
     * hasConstant test cases
     */

    /**
     * hasConstant true test case; expected test return value should be true.
     */
    @Test
    public void testHasConstantTrue() {
        /*
         * Set up variables.
         */
        SongSelector ss = this.createFromArgs("Sound Chimera", "17",
                "Galaxy Collapse", "23", "Yomi Yomi", "15", "Freedom Dive",
                "21");
        SongSelector ssExpected = this.createFromArgs("Sound Chimera", "17",
                "Galaxy Collapse", "23", "Yomi Yomi", "15", "Freedom Dive",
                "21");
        final int constant = 15;
        /*
         * Call method under test.
         */
        boolean hasConstant = ss.hasConstant(constant);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(true, hasConstant);
        assertEquals(ssExpected, ss);
    }

    /**
     * hasConstant false test case; expected test return value should be false.
     */
    @Test
    public void testHasConstantFalse() {
        /*
         * Set up variables.
         */
        SongSelector ss = this.createFromArgs("Hello 2024", "24", "Hello 2021",
                "21", "XI - It Go", "30", "Fallen Symphony", "16", "idplma",
                "20", "N\\uclear Star", "23");
        SongSelector ssExpected = this.createFromArgs("Hello 2024", "24",
                "Hello 2021", "21", "XI - It Go", "30", "Fallen Symphony", "16",
                "idplma", "20", "N\\uclear Star", "23");
        final int constant = 26;
        /*
         * Call method under test.
         */
        boolean hasConstant = ss.hasConstant(constant);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(false, hasConstant);
        assertEquals(ssExpected, ss);
    }

    /*
     * replaceConstant test cases
     */

    /**
     * replaceConstant test case with one Song entry, replacing the only song's
     * constant from 11 to 15.
     */
    @Test
    public void testReplaceConstant11to15() {
        /*
         * Set up variables.
         */
        SongSelector ss = this.createFromArgs("Avantgarde", "13");
        SongSelector ssCopy = this.createFromArgs("Avantgarde", "15");
        final int oldConstant = 13;
        final int newConstant = 15;
        /*
         * Call method under test.
         */
        Song sExpected = new Song("Avantgarde", oldConstant);
        Song s = ss.replaceConstant("Avantgarde", oldConstant, newConstant);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(ssCopy, ss);
    }

    /**
     * replaceConstant test case with two Song entries of the same title,
     * replacing one song's constant from 5 to 6.
     */
    @Test
    public void testReplaceConstantOne() {
        /*
         * Set up variables.
         */
        SongSelector ss = this.createFromArgs("Feral", "5", "Feral", "9");
        SongSelector ssExpected = this.createFromArgs("Feral", "6", "Feral",
                "9");
        final int oldConstant = 5;
        final int newConstant = 6;
        /*
         * Call method under test.
         */
        Song sExpected = new Song("Feral", oldConstant);
        Song s = ss.replaceConstant("Feral", oldConstant, newConstant);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(ssExpected, ss);
    }

    /**
     * replaceConstant test case with multiple Song entries, replacing one
     * song's constant from 18 to 20.
     */
    @Test
    public void testReplaceConstantMany() {
        /*
         * Set up variables.
         */
        SongSelector ss = this.createFromArgs("ENERGY SYNERGY MATRIX", "18",
                "Acquire", "19", "ENERGY SYNERGY MATRIX", "6", "Acquire", "9",
                "ENERGY SYNERGY MATRIX", "11", "Acquire", "12");
        SongSelector ssExpected = this.createFromArgs("ENERGY SYNERGY MATRIX",
                "20", "Acquire", "19", "ENERGY SYNERGY MATRIX", "6", "Acquire",
                "9", "ENERGY SYNERGY MATRIX", "11", "Acquire", "12");
        final int oldConstant = 18;
        final int newConstant = 20;
        /*
         * Call method under test.
         */
        Song sExpected = new Song("ENERGY SYNERGY MATRIX", oldConstant);
        Song s = ss.replaceConstant("ENERGY SYNERGY MATRIX", oldConstant,
                newConstant);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals(ssExpected, ss);
    }
}
