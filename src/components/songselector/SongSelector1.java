package components.songselector;

import java.util.Iterator;
import java.util.NoSuchElementException;

import components.sequence.Sequence;
import components.sequence.Sequence1L;

/**
 * {@code SongSelector} represented as a {@link Sequence} with implementations
 * of primary methods.
 *
 * @convention for all s: Song where (s is in $this.rep), s.constant() > 0
 * @correspondence this = [value of $this]
 */
public class SongSelector1 extends SongSelectorSecondary {

    /*
     * Private members --------------------------------------------------------
     */

    /**
     * Representation of {@code this}.
     */
    private Sequence<Song> rep;

    /**
     * Creator of initial representation.
     */
    private void createNewRep() {
        this.rep = new Sequence1L<Song>();
    }

    /*
     * Constructors -----------------------------------------------------------
     */

    /**
     * No-argument constructor.
     */
    public SongSelector1() {
        this.createNewRep();
    }

    /*
     * Standard methods -------------------------------------------------------
     */

    @Override
    public final SongSelector newInstance() {
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
    public final void transferFrom(SongSelector source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";

        SongSelector1 localSource = (SongSelector1) source;
        this.rep = localSource.rep;
        localSource.createNewRep();
    }

    /*
     * Kernel methods ---------------------------------------------------------
     */

    @Override
    public final void insert(Song s) {
        assert s != null : "Violation of: s is not null";
        assert !this.containsSong(s) : "Violation of: s is not in this";
        this.rep.add(this.rep.length(), s);
    }

    @Override
    public final Song remove(Song s) {
        assert s != null : "Violation of: s is not null";
        assert this.containsSong(s) : "Violation of: s is in this";
        int index = 0;
        while (!this.rep.entry(index).equals(s)) {
            index++;
        }
        return this.rep.remove(index);
    }

    @Override
    public final Song removeAny() {
        assert this.size() > 0 : "Violation of: |this| > 0";
        return this.rep.remove(0);
    }

    @Override
    public final boolean containsSong(Song s) {
        assert s != null : "Violation of: song is not null";
        boolean containsSong = false;
        int index = 0;
        while (!containsSong && index < this.rep.length()) {
            if (this.rep.entry(index).equals(s)) {
                containsSong = true;
            }
            index++;
        }
        return containsSong;
    }

    @Override
    public final int size() {
        return this.rep.length();
    }

    @Override
    public final Iterator<Song> iterator() {
        return new SongSelector1Iterator();
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
