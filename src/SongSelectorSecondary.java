/**
 * Layered implementations of secondary methods for {@code SongSelector}.
 *
 * @param <Song>
 *            type of {@code Song} songs
 */
public abstract class SongSelectorSecondary<Song extends Comparable<Song>>
        implements SongSelector<Song> {

    /*
     * Protected members ------------------------------------------------------
     */

    // /**
    //  * Straightforward implementation of {@code Entry} interface.
    //  *
    //  * @param <S>
    //  *            type of {@code Entry} first entry ({@code SongSelector} song
    //  *            entry)
    //  * @param <C>
    //  *            type of {@code Entry} second entry ({@code SongSelector}
    //  *            constant entry)
    //  */
    // protected static final class SongEntry<S, C>
    //         implements SongSelector.Entry<S, C> {

    //     /**
    //      * The song.
    //      */
    //     private final S song;
    //     /**
    //      * The constant.
    //      */
    //     private final C constant;

    //     /**
    //      * Constructor.
    //      *
    //      * @param song
    //      *            the song
    //      * @param constant
    //      *            the constant
    //      */
    //     public SongEntry(S song, C constant) {
    //         this.song = song;
    //         this.constant = constant;
    //     }

    //     @Override
    //     public S song() {
    //         return this.song;
    //     }

    //     @Override
    //     public C constant() {
    //         return this.constant;
    //     }
    // }

    // /**
    //  * Compare {@code S}s in lexicographic order.
    //  *
    //  * @param <S>
    //  *            type of {@code SongSelector} domain (song) entries
    //  */
    // protected static final class SongLT<S extends Comparable<S>>
    //         implements Comparator<S> {
    //     @Override
    //     public int compare(S o1, S o2) {
    //         return o1.compareTo(o2);
    //     }
    // }

    // /**
    //  * Compare {@code S}s in lexicographic order.
    //  *
    //  * @param <C>
    //  *            type of {@code SongSelector} range (constant) entries
    //  */
    // protected static final class ConstantLT<C extends Comparable<C>>
    //         implements Comparator<C> {
    //     @Override
    //     public int compare(C o1, C o2) {
    //         return o1.compareTo(o2);
    //     }
    // }

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
        if (!(obj instanceof SongSelector<?>)) {
            return false;
        }
        SongSelector<?> ss = (SongSelector<?>) obj;
        if (this.size() != ss.size()) {
            return false;
        }
        return true;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public int hashCode() {
        return this.hashCode();
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("<");
        for (Song s : this) {
            result.append(s.song() + ", " + s.constant());
        }
        result.append(">");
        return result.toString();
    }

    /*
     * Other non-kernel methods -----------------------------------------------
     */

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void combineSongList(SongSelector<Song> sl) {
        for (Song s : sl) {
            this.insert(s);
        }
        sl.clear();
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public SongSelector<Song> showSongs(int constant) {
        SongSelector<Song> songsWithConstant = this.newInstance();
        for (Song s : this) {
            if (s.constant() == constant) {
                songsWithConstant.insert(s);
            }
        }
        return songsWithConstant;
    }

    // TODO: this deletes all your songs
    // You will have aliasing if you put them back first
    private List customSort(Comparator c) {
        List<Entry<S, C>> songs = new ArrayList<>();
        while (this.size() > 0) {
            songs.add(this.removeAny());
        }
        songs.sort(c);
        return songs;
    }

    // // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    // @Override
    // public void sortBySongName(SongOrder order) {
    //     assert order != null : "Violation of: order is not null";
    //     if (this.size() != 0) {
    //         Comparator<S> ci = new ConstantLT<S>();
    //         Iterator<Entry<S, C>> it = this.iterator();
    //         Entry<S, C> entry = it.next();
    //         while (it.hasNext()) {
    //             Entry<S, C> nextEntry = it.next();
    //             if (order.equals(SongOrder.ATOZ)) {
    //                 if (ci.compare(entry.song(), nextEntry.song()) < 0) {
    //                     entry = nextEntry;
    //                 }
    //             } else {
    //                 if (ci.compare(entry.song(), nextEntry.song()) > 0) {
    //                     entry = nextEntry;
    //                 }
    //             }
    //         }
    //         Entry<S, C> removedEntry = this.remove(entry.song(),
    //                 entry.constant());
    //         this.sortBySongName(order);
    //         this.insert(removedEntry.song(), removedEntry.constant());
    //     }
    // }

    // // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    // @Override
    // public void sortByConstant(ConstantOrder order) {
    //     assert order != null : "Violation of: order is not null";

    //     if (this.size() != 0) {
    //         Comparator<C> ci = new ConstantLT<C>();
    //         Iterator<Entry<S, C>> it = this.iterator();
    //         Entry<S, C> entry = it.next();
    //         while (it.hasNext()) {
    //             Entry<S, C> nextEntry = it.next();
    //             if (order.equals(ConstantOrder.LOWESTTOHIGHEST)) {
    //                 if (ci.compare(entry.constant(),
    //                         nextEntry.constant()) < 0) {
    //                     entry = nextEntry;
    //                 }
    //             } else {
    //                 if (ci.compare(entry.constant(),
    //                         nextEntry.constant()) > 0) {
    //                     entry = nextEntry;
    //                 }
    //             }
    //         }
    //         Entry<S, C> removedEntry = this.remove(entry.song(),
    //                 entry.constant());
    //         this.sortByConstant(order);
    //         this.insert(removedEntry.song(), removedEntry.constant());
    //     }
    // }

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
        entry.constant() = constant;
        this.insert(entry);
    }
}
