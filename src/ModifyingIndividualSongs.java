import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.songselector.Song;
import components.songselector.SongSelector;
import components.songselector.SongSelector1;

/**
 * Use case demonstration 1 of the SongSelector component; showcases individual
 * songs inserted, removed, modified, and checked for specific songs/constants.
 *
 * @author Angelina Phin
 */
public final class ModifyingIndividualSongs {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private ModifyingIndividualSongs() {
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
         * Declare new SongSelector object.
         */
        SongSelector menu = new SongSelector1();
        // Maximum number of songs to be added to the song selection menu.
        final int maxSongs = 6;
        for (int i = 0; i < maxSongs; i++) {
            out.print("Enter a song name: ");
            String title = in.nextLine();
            out.print("Enter a chart constant for the song: ");
            int constant = in.nextInteger();
            menu.insert(new Song(title, constant));
        }
        /*
         * Demonstration of the SongSelector remove kernel method.
         */
        out.println(
                "From this song list, type the song to remove from the menu: ");
        out.println(menu.toString());
        String song = in.nextLine();
        out.print("Type the constant value for the song: ");
        int constant = in.nextInteger();
        Song songToRemove = new Song(song, constant);
        menu.remove(songToRemove);
        /*
         * Demonstration of the SongSelector removeAny kernel method.
         */
        out.print("Removing a random song: ");
        Song randomSong = menu.removeAny();
        out.println(randomSong.title() + ", " + randomSong.constant());
        out.println("Returning song list...");
        out.println(menu.toString());
        /*
         * Demonstration of the SongSelector containsSong kernel method.
         */
        out.print("Type the song you want to check in the collection for: ");
        String songToFind = in.nextLine();
        out.print("Type the constant value for the song you want to check: ");
        int constantToFind = in.nextInteger();
        boolean songExists = menu
                .containsSong(new Song(songToFind, constantToFind));
        out.print("Song exists? " + songExists);
        /*
         * Close I/O streams.
         */
        in.close();
        out.close();
    }

}
