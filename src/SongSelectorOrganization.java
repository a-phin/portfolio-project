import java.util.Comparator;

import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.songselector.Song;
import components.songselector.SongSelector;
import components.songselector.SongSelector1;
import components.songselector.SongSelectorSecondary.TitleSort;

/**
 * Use case demonstration 2 of the SongSelector component; combines
 * SongSelectors, filters SongSelector songs, and sorts songs.
 *
 * @author Angelina Phin
 */
public final class SongSelectorOrganization {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private SongSelectorOrganization() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        /*
         * Open output stream.
         */
        SimpleWriter out = new SimpleWriter1L();
        /*
         * Declare 2 new SongSelector objects.
         */
        SongSelector menu1 = new SongSelector1();
        SongSelector menu2 = new SongSelector1();
        /*
         * Create an array of constant integer values.
         */
        final int[] constants = { 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
        final int three = 3;
        final int four = 4;
        final int seven = 7;
        final int eight = 8;
        final int eleven = 11;
        /*
         * Ten songs inserted to the SongSelector object.
         */
        Song startOver = new Song("START OVER", constants[seven]);
        menu2.insert(startOver);
        /*
         * Declaring new songs directly in the insert method to reduce number of
         * lines of code (for my sanity).
         */
        menu1.insert(new Song("Bubee", constants[2]));
        menu1.insert(new Song("Poppy", constants[three]));
        menu2.insert(new Song("Neutron Star Collision", constants[seven]));
        menu1.insert(new Song("Break It to Me", constants[eight]));
        menu1.insert(new Song("Numb", constants[four]));
        menu1.insert(new Song("Crawling", constants[eleven]));
        menu2.insert(new Song("Howling", constants[seven]));
        menu2.insert(new Song("Sticker", constants[seven]));
        menu2.insert(new Song("Into the Sun", constants[seven]));
        /*
         * Output current menu sizes and song entries.
         */
        out.println("Menu 1 size: " + menu1.size());
        out.println(menu1.toString());
        out.println("Menu 2 size: " + menu2.size());
        out.println(menu2.toString());
        /*
         * combineSongList demo; combines menu2 SongSelector with menu1.
         */
        menu1.combineSongList(menu2);
        /*
         * Output current menu sizes.
         */
        out.println("Menu 1 size: " + menu1.size());
        out.println(menu1.toString());
        out.println("Menu 2 size: " + menu2.size());
        out.println(menu2.toString());
        /*
         * Filter SongSelector songs to show songs with constant 10.
         */
        SongSelector constant10 = menu1.showSongs(constants[seven]);
        /*
         * Output filtered menu size and song entries.
         */
        out.println("Menu w/ Constant 10 Songs size: " + constant10.size());
        out.println(constant10.toString());
        /*
         * Sort filtered songs in reverse alphabetical order.
         */
        Comparator<Song> order = new TitleSort();
        constant10.sort(order, true);
        /*
         * Print the filtered SongSelector in reverse order.
         */
        out.println(constant10.toString());
        /*
         * Close output stream.
         */
        out.close();
    }

}
