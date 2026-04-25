package components.songselector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
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
     * Public members ------------------------------------------------------
     */

    /**
     * Compare {@code Song} titles in lexicographic order.
     */
    public static final class TitleSort implements Comparator<Song> {
        @Override
        public int compare(Song o1, Song o2) {
            return o1.title().compareToIgnoreCase(o2.title());
        }
    }

    /**
     * Compare {@code Song} constants in lexicographic order.
     */
    public static final class ConstantSort implements Comparator<Song> {
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
        Iterator<Song> it = this.iterator();
        boolean containsConstant = false;
        while (!containsConstant && it.hasNext()) {
            Song s = it.next();
            if (s.constant() == constant) {
                containsConstant = true;
            }
        }
        return containsConstant;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public Song replaceConstant(String title, int oldConstant,
            int newConstant) {
        assert title != null : "Violation of: title is not null";
        assert newConstant > 0 : "Violation of: constant is greater than 0";
        assert newConstant != oldConstant : "Violation of: newConstant is not equal to oldConstant";

        Iterator<Song> it = this.iterator();
        // Initialize
        Song s = new Song("", 0);
        boolean songFound = false;
        while (!songFound && it.hasNext()) {
            s = it.next();
            if (s.title().equals(title) && s.constant() == oldConstant) {
                songFound = true;
            }
        }
        Song entry = this.remove(s);
        this.insert(new Song(entry.title(), newConstant));
        return entry;
    }
}
