import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Layered implementations of secondary methods for {@code SongSelector}.
 */
public abstract class SongSelectorSecondary implements SongSelector {

    /*
     * Private members --------------------------------------------------------
     */

    /**
     * Helper method to sort songs.
     *
     * @param c
     *            the comparator to sort by
     * @param reverseOrder
     *            indicates if ArrayList should be in reverse order
     * @return a sorted ArrayList of all songs removed from {@code this}
     */
    private List<Song> customSort(Comparator<Song> c, boolean reverseOrder) {
        List<Song> songs = new ArrayList<>();
        while (this.size() > 0) {
            songs.add(this.removeAny());
        }
        songs.sort(c);
        if (reverseOrder) {
            Collections.reverse(songs);
        }
        return songs;
    }

    /*
     * Protected members ------------------------------------------------------
     */

    /**
     * Compare {@code Song} titles in lexicographic order.
     */
    protected static final class TitleSort implements Comparator<Song> {
        @Override
        public int compare(Song o1, Song o2) {
            return o1.title().compareToIgnoreCase(o2.title());
        }
    }

    /**
     * Compare {@code Song} constants in lexicographic order.
     */
    protected static final class ConstantSort implements Comparator<Song> {
        @Override
        public int compare(Song o1, Song o2) {
            return Integer.compare(o1.constant(), o2.constant());
        }
    }

    /*
     * Common methods (from Object) -------------------------------------------
     */

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof SongSelector)) {
            return false;
        }
        SongSelector ss = (SongSelector) obj;
        if (this.size() != ss.size()) {
            return false;
        }
        for (Song s : this) {
            if (!ss.containsSong(s)) {
                return false;
            }
        }
        return true;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public int hashCode() {
        int value = 0;
        for (Song s : this) {
            value += s.hashCode();
        }
        return value;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("<");
        for (Song s : this) {
            result.append(" (" + s.title() + ", " + s.constant() + ") ");
        }
        result.append(">");
        return result.toString();
    }

    /*
     * Other non-kernel methods -----------------------------------------------
     */

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void combineSongList(SongSelector sl) {
        for (Song s : sl) {
            this.insert(s);
        }
        sl.clear();
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public SongSelector showSongs(int constant) {
        SongSelector songsWithConstant = this.newInstance();
        for (Song s : this) {
            if (s.constant() == constant) {
                songsWithConstant.insert(s);
            }
        }
        return songsWithConstant;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void sort(Comparator<Song> order, boolean inReverseOrder) {
        assert order != null : "Violation of: order is not null";

        List<Song> sortedSongs = this.customSort(order, inReverseOrder);
        for (Song s : sortedSongs) {
            this.insert(s);
        }
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public boolean hasConstant(int constant) {
        boolean containsConstant = false;
        while (!containsConstant) {
            for (Song s : this) {
                if (s.constant() == constant) {
                    containsConstant = true;
                }
            }
        }
        return containsConstant;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void replaceConstant(Song s, int constant) {
        assert s != null : "Violation of: s is not null";
        assert constant > 0 : "Violation of: constant is greater than 0";
        assert constant != s
                .constant() : "Violation of: constant is not equal to current constant";

        Song entry = this.remove(s);
        Song sng = new Song(entry.title(), constant);
        this.insert(sng);
    }
}