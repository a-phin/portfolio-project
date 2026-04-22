import java.util.Iterator;
import java.util.NoSuchElementException;

import components.list.List;
import components.list.List1L;

/**
 * {@code SongSelector} represented as a {@link List} with implementations of
 * primary methods.
 *
 * @correspondence this = [value of $this]
 */
public class SongSelector1 extends SongSelectorSecondary {

    /*
     * Private members --------------------------------------------------------
     */

    /**
     * Representation of {@code this}.
     */
    private List<Song> rep;

    /**
     * Creator of initial representation.
     */
    private void createNewRep() {
        this.rep = new List1L<Song>();
    }

    /*
     * Constructors -----------------------------------------------------------
     */

    /**
     * No-argument constructor.
     */
    public List1L() {
        this.createNewRep();
    }

    /*
     * Standard methods -------------------------------------------------------
     */

    @SuppressWarnings("unchecked")
    @Override
    public final List<Song> newInstance() {
        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    @Override
    public final void clear() {
        this.createNewRep();
    }

    @Override
    public final void transferFrom(List<Song> source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";

        List1L<Song> localSource = (List1L<Song>) source;
        this.rep = localSource.rep;
        localSource.createNewRep();
    }

    /*
     * Kernel methods ---------------------------------------------------------
     */

    @Override
    public final void insert(Song s) {
        assert s != null : "Violation of: s is not null";
        this.rep.addRightFront(s);
    }

    @Override
    public final Song remove(Song s) {
        assert s != null : "Violation of: s is not null";
        // TODO - fill in body
        return null;
    }

    @Override
    public final Song removeAny() {
        // TODO - fill in body
        return null;
    }

    @Override
    public final boolean containsSong(Song s) {
        assert s != null : "Violation of: song is not null";
        // TODO - fill in body
        return true;
    }

    @Override
    public final int size() {
        return this.rep.leftLength() + this.rep.rightLength();
    }

    @Override
    public final Iterator<Song> iterator() {
        return new SongSelector1LIterator();
    }

    /**
     * Implementation of {@code Iterator} interface for {@code SongSelector1}.
     */
    public final class SongSelector1Iterator implements Iterator<Song> {

        /**
         * Representation iterator.
         */
        private final Iterator<Song> iterator;

        /**
         * No-argument constructor.
         */
        private SongSelector1Iterator() {
            this.iterator = SongSelector1.this.rep.iterator();
        }

        @Override
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override
        public Song next() {
            assert this.hasNext() : "Violation of: ~this.unseen /= <>";
            if (!this.hasNext()) {
                /*
                 * Exception is supposed to be throw in this case, but with
                 * assertion-checking enabled it cannot happen because of assert
                 * above.
                 */
                throw new NoSuchElementException();
            }
            return this.iterator.next();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException(
                    "remove operation not supported");
        }

    }

}
