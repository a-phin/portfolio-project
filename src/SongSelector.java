import java.util.Comparator;

/**
 * {@code SongSelectorKernel} enhanced with secondary methods.
 */
public interface SongSelector extends SongSelectorKernel {

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
    void combineSongList(SongSelector sl);

    /**
     * Returns a new object with the same dynamic type as {@code this} with
     * songs with a constant of {@code constant}.
     *
     * @param constant
     *            the constant whose associated songs are to be reported
     * @return {@code SongSelector} with songs that have {@code constant}
     * @ensures showSongs = #showSongs union {song, constant}
     */
    SongSelector showSongs(int constant);

    /**
     * Sorts {@code this} according to the ordering provided by the compare
     * method from {@code order}.
     *
     * @param order
     *            ordering by which to sort the songs
     * @param inReverseOrder
     *            indicates if song selector ordering should be in reverse order
     * @updates this
     * @requires IS_TOTAL_PREORDER([relation computed by order.compare method])
     * @ensures <pre>
     * perms(this, #this) and
     * IS_SORTED(this, [relation computed by order.compare method])
     * </pre>
     */
    void sort(Comparator<Song> order, boolean inReverseOrder);

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
    boolean hasConstant(int constant);

    /**
     * Replaces the constant associated with {@code song}.
     *
     * @param s
     *            the song whose constant is replaced
     * @param constant
     *            the constant replacing the current song constant
     * @aliases reference {@code constant}
     * @updates this
     * @requires title is in this, constant > 0 and constant /= newConstant
     * @ensures <pre>
     * this = (#this \ {(song, newConstant)}) union {(song, oldConstant)}
     * and (song, newConstant) is in #this
     * </pre>
     */
    void replaceConstant(Song s, int constant);

}
