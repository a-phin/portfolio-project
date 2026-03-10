

/**
 * {@code SongSelectorKernel} enhanced with secondary methods.
 *
 * @param <S>
 *            type of {@code SongSelectorKernel} domain (song) entries
 * @param <C>
 *            type of {@code SongSelectorKernel} range (constant) entries
 */
public interface SongSelector<S, C> extends SongSelectorKernel<S, C> {

    /**
     * A SongSelector entry (song-constant pair.) The only ways to obtain a
     * SongSelector entry are from the iterator and {@code SongSelector}'s
     * {@code remove} methods.
     *
     * @param <S>
     *            type of {@code SongSelectorKernel} domain (song) entries
     * @param <C>
     *            type of {@code SongSelectorKernel} range (constant) entries
     * @mathmodel type Entry is modeled by (song: S, constant: C)
     * @initially <pre>
     * (S song, C constant):
     *  ensures
     *   this = (song, constant)
     * </pre>
     */
    interface Entry<S, C> {
        /**
         * Returns this {@code Entry}'s song.
         *
         * @return the song
         * @aliases reference returned by {@code song}
         */
        S song();

        /**
         * Return this {@code Entry}'s constant.
         *
         * @return the constant
         * @aliases reference returned by {@code constant}
         */
        C constant();
    }

    /**
     * Combines {@code sl} with {@code this}.
     *
     * @param sl
     *            the {@code SongSelector} to be combined with {@code this}
     * @updates this
     * @clears sl
     * @requires DOMAIN(this) intersection DOMAIN(sl) = {}
     * @ensures this = #this union #sl
     */
    void combineSongList(SongSelector<S, C> sl);

    /**
     * Returns a new object with the same dynamic type as {@code this} with
     * songs with a constant of {@code constant}.
     *
     * @param constant
     *            the constant whose associated songs are to be reported
     * @return {@code SongSelector} with songs that have {@code constant}
     * @requires constant is in RANGE(this)
     * @ensures showSongs = #showSongs union {song, constant}
     */
    SongSelector<S, C> showSongs(C constant);

    /**
     * Sorts {@code this} according to the ordering provided by the compare
     * method from {@code order}.
     *
     * @param order
     *            ordering by which to sort the songs
     * @updates this
     * @requires IS_TOTAL_PREORDER([relation computed by order.compare method])
     * @ensures <pre>
     * perms(this, #this) and
     * IS_SORTED(this, [relation computed by order.compare method])
     * </pre>
     */
    void sortBySongName(Comparator<S> order);

    /**
     * Sorts {@code this} according to the ordering provided by the compare
     * method from {@code order}.
     *
     * @param order
     *            ordering by which to sort the constants
     * @updates this
     * @requires IS_TOTAL_PREORDER([relation computed by order.compare] method)
     * @ensures <pre>
     * perms(this, #this) and
     * IS_SORTED(this, [relation computed by order.compare method])
     * </pre>
     */
    void sortByConstant(Comparator<C> order);

    /**
     * Reports if there is an entry in {@code this} whose second component is
     * {@code constant}.
     *
     * @param constant
     *            the constant to be checked
     * @return true iff there is a pair in {@code this} whose second component
     *         is {@code constant}
     * @ensures hasConstant = (constant is in RANGE(this))
     */
    boolean hasConstant(C constant);

    /**
     * Replaces the constant associated with {@code song}.
     *
     * @param song
     *            the song whose constant is replaced
     * @param oldConstant
     *            the constant associated with {@code song} to be replaced
     * @param newConstant
     *            the constant replacing {@code oldConstant}
     * @aliases reference {@code constant}
     * @updates this
     * @requires song is in DOMAIN(this)
     * @ensures <pre>
     * this = (#this \ {(song, newConstant)}) union {(song, oldConstant)}
     * and (song, newConstant) is in #this
     * </pre>
     */
    void replaceConstant(S song, C oldConstant, C newConstant);
}
