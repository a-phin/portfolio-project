import java.util.Comparator;
import java.util.Iterator;

/**
 * Layered implementations of secondary methods for {@code SongSelector}.
 *
 * @param <S>
 *            type of {@code SongSelector} domain (song) entries
 * @param <C>
 *            type of {@code SongSelector} range (constant) entries
 */
public abstract class SongSelectorSecondary<S extends Comparable<S>, C extends Comparable<C>>
        implements SongSelector<S, C> {

    /*
     * Protected members ------------------------------------------------------
     */

    /**
     * Straightforward implementation of {@code Entry} interface.
     *
     * @param <S>
     *            type of {@code Entry} first entry ({@code SongSelector} song
     *            entry)
     * @param <C>
     *            type of {@code Entry} second entry ({@code SongSelector}
     *            constant entry)
     */
    protected static final class SongEntry<S, C>
            implements SongSelector.Entry<S, C> {

        /**
         * The song.
         */
        private final S song;
        /**
         * The constant.
         */
        private final C constant;

        /**
         * Constructor.
         *
         * @param song
         *            the song
         * @param constant
         *            the constant
         */
        public SongEntry(S song, C constant) {
            this.song = song;
            this.constant = constant;
        }

        @Override
        public S song() {
            return this.song;
        }

        @Override
        public C constant() {
            return this.constant;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (!(obj instanceof Entry<?, ?>)) {
                return false;
            }
            Entry<?, ?> entry = (Entry<?, ?>) obj;
            return this.song.equals(entry.song())
                    && this.constant.equals(entry.constant());
        }

        @Override
        public int hashCode() {
            return this.song.hashCode() + this.constant.hashCode();
        }

        @Override
        public String toString() {
            return this.song + " (" + this.constant + ") ";
        }
    }

    /**
     * Compare {@code S}s in lexicographic order.
     *
     * @param <S>
     *            type of {@code SongSelector} domain (song) entries
     */
    protected static final class SongLT<S extends Comparable<S>>
            implements Comparator<S> {
        @Override
        public int compare(S o1, S o2) {
            return o1.compareTo(o2);
        }
    }

    /**
     * Compare {@code S}s in lexicographic order.
     *
     * @param <C>
     *            type of {@code SongSelector} range (constant) entries
     */
    protected static final class ConstantLT<C extends Comparable<C>>
            implements Comparator<C> {
        @Override
        public int compare(C o1, C o2) {
            return o1.compareTo(o2);
        }
    }

    /*
     * Other non-kernel methods -----------------------------------------------
     */

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void combineSongList(SongSelector<S, C> sl) {
        for (Entry<S, C> entry : sl) {
            this.insert(entry.song(), entry.constant());
        }
        sl.clear();
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public SongSelector<S, C> showSongs(C constant) {
        assert constant != null : "Violation of: constant is not null";
        SongSelector<S, C> songsWithConstant = this.newInstance();
        for (Entry<S, C> entry : this) {
            if (entry.constant().equals(constant)) {
                songsWithConstant.insert(entry.song(), entry.constant());
            }
        }
        return songsWithConstant;
    }

    /*
     * I'm ngl the sorting methods genuinely have to be the worst methods I
     * tried to implement here. Pondered and researched for about 4+ hours what
     * I lowkey wanted to do lmao.
     *
     * Had to use enums instead of comparator parameters to restrict the sorting
     * choices which was the best decision I made, no idea what I was gonna do
     * with a comparator parameter passed and I cba making comparators when I
     * demo it in the main method for P6.
     *
     * Revisiting this when I work on Part 5 -- work and midterms are frying me
     * this week.
     */

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void sortBySongName(SongOrder order) {
        assert order != null : "Violation of: order is not null";
        if (this.size() != 0) {
            Comparator<S> ci = new ConstantLT<S>();
            Iterator<Entry<S, C>> it = this.iterator();
            Entry<S, C> entry = it.next();
            while (it.hasNext()) {
                Entry<S, C> nextEntry = it.next();
                if (order.equals(SongOrder.ATOZ)) {
                    if (ci.compare(entry.song(), nextEntry.song()) < 0) {
                        entry = nextEntry;
                    }
                } else {
                    if (ci.compare(entry.song(), nextEntry.song()) > 0) {
                        entry = nextEntry;
                    }
                }
            }
            Entry<S, C> removedEntry = this.remove(entry.song(),
                    entry.constant());
            this.sortBySongName(order);
            this.insert(removedEntry.song(), removedEntry.constant());
        }
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void sortByConstant(ConstantOrder order) {
        assert order != null : "Violation of: order is not null";

        if (this.size() != 0) {
            Comparator<C> ci = new ConstantLT<C>();
            Iterator<Entry<S, C>> it = this.iterator();
            Entry<S, C> entry = it.next();
            while (it.hasNext()) {
                Entry<S, C> nextEntry = it.next();
                if (order.equals(ConstantOrder.LOWESTTOHIGHEST)) {
                    if (ci.compare(entry.constant(),
                            nextEntry.constant()) < 0) {
                        entry = nextEntry;
                    }
                } else {
                    if (ci.compare(entry.constant(),
                            nextEntry.constant()) > 0) {
                        entry = nextEntry;
                    }
                }
            }
            Entry<S, C> removedEntry = this.remove(entry.song(),
                    entry.constant());
            this.sortByConstant(order);
            this.insert(removedEntry.song(), removedEntry.constant());
        }
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public boolean hasConstant(C constant) {
        boolean containsConstant = false;
        for (Entry<S, C> entry : this) {
            if (entry.constant().equals(constant)) {
                containsConstant = true;
            }
        }
        return containsConstant;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void replaceConstant(S song, C oldConstant, C newConstant) {
        assert song != null : "Violation of: song is not null";
        assert oldConstant != null : "Violation of: oldConstant is not null";
        assert newConstant != null : "Violation of: newConstant is not null";

        Entry<S, C> entry = this.remove(song, oldConstant);
        this.insert(entry.song(), newConstant);
    }
}
