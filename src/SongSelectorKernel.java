import components.standard.Standard;

/**
 * Song selector kernel component with primary methods. (Note: by package-wide
 * convention, all references are non-null.)
 *
 * @param <S>
 *            type of {@code SongSelectorKernel} domain (song) entries
 * @param <C>
 *            type of {@code SongSelectorKernel} range (constant) entries
 */
public interface SongSelectorKernel<S, C> extends Standard<SongSelector<S, C>>,
        Iterable<SongSelector.Entry<S, C>> {

    /**
     * Inserts the pair ({@code song}, {@code constant}) to this.
     *
     * @param song
     *            the song name to be inserted
     * @param constant
     *            the associated constant value to be inserted
     * @aliases references {@code song, constant}
     * @updates this
     * @ensures this = #this union {(song, constant)}
     */
    void insert(S song, C constant);

    /**
     * Removes the pair ({@code song}, {@code constant}) and returns it.
     *
     * @param song
     *            the song name to be removed
     * @param constant
     *            the associated constant value to be removed
     * @return the entry removed
     * @updates this
     * @requires song is in DOMAIN(this)
     * @ensures <pre>
     * remove.song = song and
     * remove is in #this and
     * this = #this \ {remove}
     * </pre>
     */
    SongSelector.Entry<S, C> remove(S song, C constant);

    /**
     * Reports whether there is an entry in {@code this} whose first component
     * is {code Song}.
     *
     * @param song
     *            the song name to look for
     * @return true iff there is a pair in this whose first component is
     *         {@code song}
     * @ensures containsSong = (song is in DOMAIN(this))
     */
    boolean containsSong(S song);

    /**
     * Reports size of {@code this}.
     *
     * @return the number of songs and its associated constants in {@code this}
     * @ensures size = |this|
     */
    int size();
    
}