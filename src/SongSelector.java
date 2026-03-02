import java.util.ArrayList;

import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Minimum viable product of a component that models a rhythm game song
 * selection menu.
 *
 * @author Angelina Phin
 */
public final class SongSelector {

    /*
     * Declare ArrayLists to store song names and constant values associated
     * with songs. When retrieving a song and its associated constant, they will
     * have the same indice as if the song and the constant were a pair (e.g. in
     * a Map).
     */

    /**
     * Private variable that stores song names in a String ArrayList.
     */
    private ArrayList<String> songs;
    /**
     * Private variable that stores constant values in an int ArrayList.
     */
    private ArrayList<Integer> constants;

    /**
     * Constructor. Modeled as ArrayList rather than arrays ([]) to avoid
     * limiting the size of the <{@code SongSelector}.
     */
    public SongSelector() {
        this.songs = new ArrayList<String>();
        this.constants = new ArrayList<Integer>();
    }

    // /**
    //  * Getter method to retrieve song list. (MVP only, will not be included in
    //  * final product)
    //  */
    // public ArrayList<String> getSongList() {
    //     return this.songs;
    // }

    // /**
    //  * Getter method to retrieve constant list. (MVP only, will not be included in
    //  * final product)
    //  */
    // public ArrayList<Integer> getConstantList() {
    //     return this.constants;
    // }

    /**
     * Kernel Method -- Inserts a song's beatmap/chart to the song select
     * collection.
     *
     * @param songName
     *            song name to insert to the collection
     * @param constant
     *            the difficulty of the song's beatmap/chart
     * @param songCollection
     *            the song list to add the song name to
     * @param constCollection
     *            the song's constant list to add the constant value into
     * @updates collection
     * @requires songName /= null and 0 < constant <= 15
     */
    public static void insert(String songName, int constant,
            ArrayList<String> songCollection,
            ArrayList<Integer> constCollection) {
        final int maxConstant = 15; // Variable to avoid magic number warning
        assert songName != null : "Violation of: songName is not null";
        assert constant > 0 : "Violation of: constant is greater than 0";
        assert constant <= maxConstant : "Violation of: constant is at most 15";

        // Adds the song name and constant to their respective collections.
        songCollection.add(songName);
        constCollection.add(constant);
    }

    /**
     * Kernel Method -- Reports whether there is an entry in the song select
     * menu contains {@code songName}.
     *
     * @param songName
     *            the song name to look for
     * @param songCollection
     *            the song list to search the song name
     * @return whether the song name exists in the collection
     */
    public static boolean containsSong(String songName,
            ArrayList<String> songCollection) {
        /*
         * Checks ArrayList to determine if the song name is in the song
         * collection.
         */
        return songCollection.contains(songName);
    }

    /**
     * Kernel Method -- Removes the entry whose key is the song name and returns
     * it.
     *
     * @param song
     *            the song to remove along with its beatmap
     * @param constant
     *            the constant of the song's beatmap, if there are multiple
     *            entries of the same song name
     * @param songList
     *            the song list to search the song name for
     * @param constList
     *            the constant to search the constant to be removed from the
     *            list
     * @return the song entry removed from the song selection menu
     */
    public static String remove(String song, int constant,
            ArrayList<String> songList, ArrayList<Integer> constList) {
        assert song != null : "Violation of: song is not null";
        assert constant > 0 : "Violation of: constant is greater than 0";
        assert constant <= 15 : "Violation of: constant is at most 15";

        return constList.remove(songList.indexOf(song)) + ", "
                + songList.remove(song);
    }

    // /**
    //  * Combines {@code list2} with {@code list1}.
    //  *
    //  * @param songList1
    //  *            the song list menu to add entries into
    //  * @param songList2
    //  *            the song list menu whose entries will be combined into
    //  *            {@code songList1}
    //  * @param constList1
    //  *            the constant list to add entries into
    //  * @param constList2
    //  *            the constant list whose entries will be combined into
    //  *            {@code constList1}
    //  * @updates songList1, constList1
    //  * @clears songList2, constList2
    //  */
    // public static void combineSongList(ArrayList<String> songList1,
    //         ArrayList<String> songList2, ArrayList<Integer> constList1,
    //         ArrayList<Integer> constList2) {
    //     songList1.addAll(songList2);
    //     songList2.clear();
    //     constList1.addAll(constList2);
    //     constList2.clear();
    // }

    /**
     * Secondary Method -- Replaces the constant associated with song.
     *
     * @param song
     *            the song to search for
     * @param constant
     *            the new constant to update the song to
     * @param songCollection
     *            the song list to search for when calling containsSong
     * @param constCollection
     *            the constant list to replace the song's old value with
     *            {@code constant}
     */
    public static void replaceConstant(String song, int constant,
            ArrayList<String> songCollection,
            ArrayList<Integer> constCollection) {
        /*
         * Checks if the song exists in the song collection; if true, retrieves
         * index of the song in {@code SongCollection} to replace the constant
         * value in {@code constCollection}.
         */
        if (containsSong(song, songCollection)) {
            int index = songCollection.indexOf(song);
            constCollection.set(index, constant);
        }
        /*
         * Might not check if the song exists, probably might use an asserts
         * statement(?) or add a requires clause to ensure the song already
         * exists.
         */
    }

    /**
     * Secondary Method -- returns a new Map with the same dynamic type as
     * {@code Map} with songs with a value of {@code int}.
     *
     * @param songList
     *            the song list to search entries with a constant {@code int}
     * @param constList
     *            the constant list to remove values from
     * @param constant
     *            the difficulty of a song/songs
     * @return the map "filtered" with constant {@code int}
     */
    public static ArrayList<String> showSongs(ArrayList<String> songList,
            ArrayList<Integer> constList, int constant) {

        ArrayList<String> songsWithConstant = new ArrayList<String>();
        for (int i = 0; i < constList.size(); i++) {
            if (constList.get(i) == constant) {
                songsWithConstant.add(songList.get(i));
            }
        }
        return songsWithConstant;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        /*
         * Open I/O streams.
         */
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        /*
         * Declare new SongSelector objected, component temporarily modeled as
         * two separate ArrayLists than pairs for MVP.
         */
        SongSelector demoMenu = new SongSelector();
        // Maximum number of songs to be added to the song selection menu.
        final int maxSongs = 3;
        /*
         * Demonstration of the SongSelect insert kernel method.
         */
        for (int i = 0; i < maxSongs; i++) {
            out.print("Enter a song name: ");
            String newSong = in.nextLine();
            out.print("Enter a chart constant for the song: ");
            int constant = in.nextInteger();
            insert(newSong, constant, demoMenu.songs, demoMenu.constants);
        }
        /*
         * Demonstration of the SongSelect remove kernel method.
         */
        out.print("Type the song to remove from the menu: ");
        String song = in.nextLine();
        out.print("Type the constant value for the song: ");
        int constant = in.nextInteger();
        String songEntry = remove(song, constant, demoMenu.songs,
                demoMenu.constants);
        /*
         * Demonstration of the SongSelect containsSong kernel method.
         */
        out.print("Type the song you want to check in the collection for: ");
        song = in.nextLine();
        boolean songExists = containsSong(song, demoMenu.songs);
        out.print("Song exists? " + songExists);
        /*
         * Demonstration of the SongSelect showSongs method.
         */
        ArrayList<String> constantSongList = showSongs(demoMenu.songs,
                demoMenu.constants, constant);
        // /*
        //  * Demonstration of the SongSelect combineSongList method.
        //  */
        // combineSongList(demoMenu, constantSongList);
        /*
         * Demonstration of the SongSelect replaceConstant method.
         */
        replaceConstant("Hello", 2, demoMenu.songs, demoMenu.constants);
        /*
         * Close I/O streams.
         */
        in.close();
        out.close();
    }
}