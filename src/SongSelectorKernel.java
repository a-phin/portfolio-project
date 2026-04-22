import components.standard.Standard;

/**
 * Song selector kernel component with primary methods. (Note: by package-wide
 * convention, all references are non-null.)
 */
public interface SongSelectorKernel
        extends Standard<SongSelector>, Iterable<Song> {

    /**
     * Inserts {@code s} to this.
     *
     * @param s
     *            the song to be inserted
     * @aliases references {@code s}
     * @updates this
     * @ensures this = #this union {s}
     */
    void insert(Song s);

    /**
     * Removes the {@code song} and returns it.
     *
     * @param s
     *            the song to be removed
     * @return the song removed
     * @updates this
     * @requires song is in this
     * @ensures <pre>
     * this = #this \ {s} and
     * remove = s
     * </pre>
     */
    Song remove(Song s);

    /**
     * Removes and returns an arbitrary element from {@code this}.
     *
     * @return the song removed from {@code this}
     * @updates this
     * @requires |this| > 0
     * @ensures <pre>
     * removeAny is in #this and
     * this = #this \ {removeAny}
     * </pre>
     */
    Song removeAny();

    /**
     * Reports whether {@code s} is in {@code this}.
     *
     * @param s
     *            the song to look for
     * @return true iff song is in {@code this}
     * @ensures containsSong = (song is in this)
     */
    boolean containsSong(Song s);

    /**
     * Reports size of {@code this}.
     *
     * @return the number of songs in {@code this}
     * @ensures size = |this|
     */
    int size();

}
