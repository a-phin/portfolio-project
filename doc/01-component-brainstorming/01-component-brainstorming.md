# Portfolio Part 1: Component Brainstorming

- **Name**: Angelina Phin
- **Dot Number**: phin.5
- **Due Date**: 02/06 @ 1:50 PM EST

## Assignment Overview

The overall goal of the portfolio project is to have you design and implement
your own OSU component. There are no limits to what you choose to design and
implement, but your component must fit within the constraints of our software
sequence discipline. In other words, the component must extend from Standard and
must include both a kernel and a secondary interface.

Because this is a daunting project, we will be providing you with a series of
activities to aid in your design decisions. For example, the point of this
assignment is to help you brainstorm a few possible components and get some
feedback. For each of these components, you will need to specify the high-level
design in terms of the software sequence discipline. In other words, you will
describe a component, select a few kernel methods for your component, and select
a few secondary methods to layer on top of your kernel methods.

You are not required to specify contracts at this time. However, you are welcome
to be as detailed as you'd like. More detail means you will be able to get more
detailed feedback, which may help you decide which component to ultimately
implement.

## Assignment Checklist

To be sure you have completed everything on this assignment, we have littered
this document with TODO comments. You can browse all of them in VSCode by
opening the TODOs window from the sidebar. The icon looks like a tree and will
likely have a large number next to it indicating the number of TODOS. You'll
chip away at that number over the course of the semester. However, if you'd
like to remove this number, you can disable it by removing the following
line from the `settings.json` file:

```json
"todo-tree.general.showActivityBarBadge": true,
```

Which is not to be confused with the following setting that adds the counts
to the tree diagram (you may remove this one as well):

```json
"todo-tree.tree.showCountsInTree": true,
```

## Assignment Learning Objectives

Without learning objectives, there really is no clear reason why a particular
assessment or activity exists. Therefore, to be completely transparent, here is
what we're hoping you will learn through this particular aspect of the portfolio
project. Specifically, students should be able to:

1. Integrate their areas of interest in their personal lives and/or careers with
   their knowledge of software design
2. Determine the achievablility of a software design given time constraints
3. Design high-level software components following the software sequence
   discipline

## Assignment Rubric: 10 Points

Again, to be completely transparent, most of the portfolio project, except the
final submission, is designed as a formative assessment. Formative assessments
are meant to provide ongoing feedback in the learning process. Therefore,
the rubric is designed to assess the learning objectives _directly_ in a way
that is low stakes—meaning you shouldn't have to worry about the grade. Just
do good work.

| Learning Objective                                                                                        | Subcategory                 | Weight | Missing                                                     | Beginning                                                                              | Developing                                                                                     | Meeting                                                                                 |
| --------------------------------------------------------------------------------------------------------- | --------------------------- | ------ | ----------------------------------------------------------- | -------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- |
| Students should be able to identify their values, interests, and/or goals as they relate to their designs | Metacognitive Memory        | 3      | (0) No attempt to summarize values, interests, and/or goals | (1) A brief description of values, interests, and/or goals is provided but lacks depth | (2) A description of values, interests, and/or goals is provided by are not related to designs | (3) A description of values, interests, and/or goals is provided and relates to designs |
| Students should be able to predict the feasibility of their designs                                       | Metacognitive Understanding | 3      | (0) No attempt to design components that are feasible       | (1) At least one component is feasible                                                 | (2) At least two components are feasible                                                       | (3) All three components are feasible                                                   |
| Students should be able to use the OSU discipline in all three designs                                    | Metacognitive Application   | 4      | (0) No attempt to follow the OSU discipline in designs      | (1) At least one design follows the OSU discipline                                     | (3) At least two designs follow the OSU discipline                                             | (4) All three designs follow the OSU discipline                                         |

Below is further rationale/explanation for the rubric items above:

1. Each design must align with your personal values and long-term
   goals. Because the goal of this project is to help your build out a
   portfolio, you really ought to care about what you're designing. We'll give
   you a chance to share your personal values, interests, and long-term goals
   below.
2. Each design must be achievable over the course of a single
   semester. Don't be afraid to design something very small. There is no shame
   in keeping it simple.
3. Each design must fit within the software sequence discipline. In
   other words, your design should expect to inherit from Standard, and it
   should contain both kernel and secondary methods. Also, null and aliasing
   must be avoided, when possible. The methods themselves must also be in
   justifiable locations, such as kernel or secondary.

## Pre-Assignment

> Before you jump in, we want you to take a moment to share your interests
> below. Use this space to talk about your career goals as well as your personal
> hobbies. These will help you clarify your values before you start
> brainstorming. Plus it helps us get to know you better! Feel free to share
> images in this section.

My main interests are music, art and gaming. I typically listen to game soundtracks, anime music, and music you'd probably hear at raves (EDM, Trance, Hardstyle, etc), but I do listen to some rap and Lady Gaga on the side. I'm particularly interested in music composition and production; I've messed around with music notation programs (MuseScore) and MIDI programs (LMMS, Waveform, FL Studio) however I've never completed a single sheet music or song demo in either of those programs lmfao. I used to play piano, violin, and trombone; when I'm home I'll need to relearn piano + I really want to learn drums or guitar/bass.

I'm also into art, mainly 3D modeling (and sometimes digital art). I have a bit of experience with Maya and C4D from a while back, but I mainly work with Blender (fun fact: the first time I used Blender was 2018, yes when I was 10. I was inspired by people making graphics for Roblox gulp). As much as the 3D modeling process is daunting, I enjoy learning new things and how I can combine different tools to make models look really good. Lighting and compositing is my expertise in my opinion. I would show a recent project I did with Blender, but I somehow lost my flash drive over the summer ugh.

These days, I'm invested in playing rhythm games. I enjoy mobile rhythm games (e.g. Arcaea) and I'd love to frequent arcade rhythm games more often (e.g. CHUNITHM, maimai, SDVX) (like abolishing the D&B and putting a Round1 at the Polaris Mall so I don't have to travel 1.5 hours to Dayton). I don't play a lot of PC rhythm games but enjoy them when I have the time (e.g. ADOFAI or the upcoming In Falsus). Although I'm more focused on rhythm games, I'm also open to other game genres, like visual novels or tower defense.

In addition, I enjoy coding and watching Twitch livestreams in my free time. I also enjoy spending time with my family and friends and going out whenever I can, exploring new places.

As a CSE major, I'm interested in exploring the CG/game design (w/ previous 3D modeling experience, I'm interested in rendering and graphics), cybersecurity (I'm lowkey interested in having skillsets in reverse engineering/ethical hacking), and data analytics (I don't know why databases stick out to me) fields. I'm also interested in software engineering, but my 8AM SW1 class last semester kinda ruined it for me lol. One of my career goals is to take on a leadership role and mentor others, because I like to share my knowledge and passion for CS and other interests to help others grow. Another career goal I have is to expand my professional network and "put myself out there"; I have horrendous anxiety trying to get myself out there, and I'm trying to overcome it (I think).

## Assignment

As previously stated, you are tasked with brainstorming 3 possible components.
To aid you in this process, we have provided [some example components][example-components]
that may help you in your brainstorming. All of these components were made at
some point by one of your peers, so you should feel confident that you can
accomplish any of them.

There is no requirement that you use any of the components listed above.
If you want to model something else, go for it! Very common early object
projects usually attempt to model real-world systems like banks, cars,
etc. Make of this whatever seems interesting to you, and keep in mind that
you're just brainstorming right now. You do not have to commit to anything.

**Note**: Sometimes students will already know what they want to design
and will feel forced to make one-off designs for components they'll never
build. If that's you, you may submit three different designs for the same
component (rather than three different components). This will strengthen your
final design because you'll have an opportunity to think about different ways of
organizing the API. As an example, later in the course, you will see a tree
component that doesn't work by accessing the children through aliases but rather
by assembling and disassembling the tree. You will also see a variety of
list-like components that have different ways of manipulating the data. Think
about different ways you might allow a client to manipulate your component.

### Example Component

To help you brainstorm a few components, we've provided an example below of a
component you already know well: NaturalNumber. We highly recommend that you
mirror the formatting as close as possible in your designs. By following this
format, we can be more confident that your designs will be possible.

- Example Component: `NaturalNumber`
  - **Description**:
    - The purpose of this component is to model a non-negative
      integer. Our intent with this design was to keep a simple kernel that
      provides the minimum functionality needed to represent a natural number.
      Then, we provide more complex mathematical operations in the secondary
      interface.
  - **Kernel Methods**:
    - `void multiplyBy10(int k)`: multiplies `this` by 10 and adds `k`
    - `int divideBy10()`: divides `this` by 10 and reports the remainder
    - `boolean isZero()`: reports whether `this` is zero
  - **Secondary Methods**:
    - `void add(NaturalNumber n)`: adds `n` to `this`
    - `void subtract(NaturalNumber n)`: subtracts `n` from `this`
    - `void multiply(NaturalNumber n)`: multiplies `this` by `n`
    - `NaturalNumber divide(NaturalNumber n)`: divides `this` by `n`, returning
      the remainder
    - ...
  - **Additional Considerations** (_note_: "I don't know" is an acceptable
    answer for each of the following questions):
    - Would this component be mutable? Answer and explain:
      - Yes, basically all OSU components have to be mutable as long as they
        inherit from Standard. `clear`, `newInstance`, and `transferFrom` all
        mutate `this`.
    - Would this component rely on any internal classes (e.g., `Map.Pair`)?
      Answer and explain:
      - No. All methods work with integers or other NaturalNumbers.
    - Would this component need any enums or constants (e.g.,
      `Program.Instruction`)? Answer and explain:
      - Yes. NaturalNumber is base 10, and we track that in a constant called
        `RADIX`.
    - Can you implement your secondary methods using your kernel methods?
      Answer, explain, and give at least one example:
      - Yes. The kernel methods `multiplyBy10` and `divideBy10` can be used to
        manipulate our natural number as needed. For example, to implement
        `increment`, we can trim the last digit off with `divideBy10`, add 1 to
        it, verify that the digit hasn't overflown, and multiply the digit back.
        If the digit overflows, we reset it to zero and recursively call
        `increment`.

Keep in mind that the general idea when putting together these layered designs
is to put the minimal implementation in the kernel. In this case, the kernel is
only responsible for manipulating a digit at a time in the number. The secondary
methods use these manipulations to perform more complex operations like
adding two numbers together.

Also, keep in mind that we don't know the underlying implementation. It would be
completely reasonable to create a `NaturalNumber1L` class which layers the
kernel on top of the existing `BigInteger` class in Java. It would also be
reasonable to implement `NaturalNumber2` on top of `String` as seen in
Project 2. Do not worry about your implementations at this time.

On top of everything above, there is no expectation that you have a perfect
design. Part of the goal of this project is to have you actually use your
component once it's implemented to do something interesting. At which point, you
will likely refine your design to make your implementation easier to use.

### Component Designs

> Please use this section to share your designs.

- Component Design #1: `Chord`
  - **Description**:
    - The purpose of this component is to model a music chord. The design component contains kernel methods providing manipulation of the chord (+ identifying current size of chord), as well as additional information of the chord
  - **Kernel Methods**:
    - `void insertNote(String n)`: inserts `n` to `this` (addNote can be overridden; may have a method w/ no parameter, which automatically adds a note that is 2nd of the highest existing note, or a method with an int parameter)
    - `Chord removeNote(String n)`: removes a `Chord` object based on the value of `n` and reports the note
    - `int size()`: reports size of `this`
  - **Secondary Methods**:
    - `Chord name()`: returns the name of `this`
    - `String notes()`: returns the notes of `this`
    - `String root()`: returns the root note of `this`
  - **Additional Considerations** (_note_: "I don't know" is an acceptable
    answer for each of the following questions):
    - Would this component be mutable? Answer and explain:
      - Yes, `Chord` will inherit from Standard. `clear`, `newInstance`, and `transferFrom` will mutate `this`.
    - Would this component rely on any internal classes (e.g., `Map.Pair`)?
      Answer and explain:
      - No, the `Chord` component can stand as its own class. Methods work with Chords, ints, and Strings.
    - Would this component need any enums or constants (e.g.,
      `Program.Instruction`)? Answer and explain:
      - Yes, `Chord` will need String constants (A flat, A, A# or A sharp, etc... to G/G#/G sharp) that is equivalent to Integer values correlated with these constants or Integer constants for vice versa.
    - Can you implement your secondary methods using your kernel methods?
      Answer, explain, and give at least one example:
      - No; secondary methods are methods that provide information about the chord. (This may change if I receive suggestions/ideas or have potential secondary methods in mind that involve manipulation of chords.)

- Component Design #2: `MusicSequencer`
  - **Description**:
    - The purpose of this component is to provide a utility to generate sequences of notes. I made this component design to support Note objects and Chord (see #1) objects and integrate them into utility that is a simple "music notation-software-like program except it's technical as hell".
  - **Kernel Methods**:
    - `void insert(N note)`: inserts `note` to `this`
    - `void remove(N note)`: removes `note` from `this` (used void instead of a return type to mimic deletion of music notes) (**both insert and remove can be overriden**)
    - `int length()`: reports length of `this`
  - **Secondary Methods**:
  // Could incorporate methods for adding repeats, time signatures, BPM, etc... (might be too technical)
    - `void removeSequence(int start, int end)`: removes sequences of music notes/chords from the `start`ing note/chord to the `end`ing chord/note
    - `void transpose(int o)`: transposes current sequence `o` octaves up/down
  - **Additional Considerations** (_note_: "I don't know" is an acceptable
    answer for each of the following questions):
    - Would this component be mutable? Answer and explain:
      - Yes. `this` would be mutated in different ways: adding/remove notes or chords to the existing sequence, or `clear`-ing the entire existing sequence.
    - Would this component rely on any internal classes (e.g., `Map.Pair`)?
      Answer and explain:
      - Maybe; there could be an internal class for each note/chord entry with information on the values, as well as for manipulating each entry individually (that may be a lot for a utility).
    - Would this component need any enums or constants (e.g.,
      `Program.Instruction`)? Answer and explain:
      - Possibly constants for individual notes (e.g. see Component Design #1) and chords
    - Can you implement your secondary methods using your kernel methods?
      Answer, explain, and give at least one example:
      - Yes, one kernel method such as `remove` can support the `removeSequence` method. The `remove` method, if including iteration, will remove notes from `start` to `end`.

- Component Design #3: `RhythmSong` (is there a better name for this...)
  - **Description**:
    - The purpose of this component is to model the organization of a rhythm game song select menu. The design reflects the OSU map component closely (e.g. using custom objects), except `RhythmSong` can also sort rhythm game songs in different ways.
  - **Kernel Methods**:
    - `void insert(S song, C constant)`: inserts the pair (song, constant) to `this`
    - `boolean containsSong(S song)`: reports whether there is an entry in `this` whose first component is `song`
    - `RhythmSong.Entry<S, C> remove(S song)`: removes the entry whose first component is `song` and returns it
    - `int size()`: reports size of `this` (the rhythm game song select menu)
  - **Secondary Methods**:
    - `void combineSongList(RhythmSong<S, C> rs)`: combines `rs` with `this`
    - `RhythmSong showSongs(C constant)`: returns a new object with the same _dynamic_ type as `this` with `songs` with a value of `constant` (showSongs() may be overridden to show songs starting with a certain letter, e.g. 'A')
    - `void sort(Comparator<T> order)`: sorts `this` according to the ordering provided by the compare method from `order`
    - `boolean hasConstant(C constant)`: reports if there is an entry in `this` whose second component is `constant`
    - `void replaceConstant(S song, C constant)`: replaces the constant associated with `song`
  - **Additional Considerations** (_note_: "I don't know" is an acceptable
    answer for each of the following questions):
    - Would this component be mutable? Answer and explain:
      - Yes, `RhythmSong` will inherit from Standard and be mutable. Say if a song needs to be removed from the song selection menu (because of something like "licensing issues") and gets replaced with another song, I would need to get rid of the original song (`clear`) and replace it (`transferFrom`) with the new song with its new name and difficulty info. Methods will work with other `RhythmSong` objects.
    - Would this component rely on any internal classes (e.g., `Map.Pair`)?
      Answer and explain:
      - Yes, there will be an internal class that takes an entry with a song name and difficulty to return that information in separate methods.
    - Would this component need any enums or constants (e.g.,
      `Program.Instruction`)? Answer and explain:
      - Possibly, I may need constants that represent the song level difficulty and the song beatmap constant (represented as an Integer (e.g. 11) or String (e.g. 11+)). The song beatmap constant may be represented as C as well, to support Integer or String values.
    - Can you implement your secondary methods using your kernel methods?
      Answer, explain, and give at least one example:
      - Yes, kernel methods such as `insert` and `remove` can be used to manipulate `RhythmSong`. To implement `showSongs`, I would need to also use an iterator object to iterate through each entry in `RhythmSong` and check if an entry's second component is equivalent to `constant`, then which I would use `insert` to add the entry to the new `RhythmSong` object.

## Post-Assignment

The following sections detail everything that you should do once you've
completed the assignment.

### Changelog

At the end of every assignment, you should update the
[CHANGELOG.md](../../CHANGELOG.md) file found in the root of the project folder.
Since this is likely the first time you've done this, we would recommend
browsing the existing file. It includes all of the changes made to the portfolio
project template. When you're ready, you should delete this file and start your
own. Here's what I would expect to see at the minimum:

```markdown
# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.

## 2026.02.05

### Added

- Designed a `Chord` component
- Designed a `MusicSequencer` component
- Designed a `RhythmSong` component
```

Here `YYYY.MM.DD` would be the date of your submission, such as 2024.04.21.

You may notice that things are nicely linked in the root CHANGELOG. If you'd
like to accomplish that, you will need to make GitHub releases after each pull
request merge (or at least tag your commits). This is not required.

In the future, the CHANGELOG will be used to document changes in your
designs, so we can gauge your progress. Please keep it updated at each stage
of development.

### Submission

If you have completed the assignment using this template, we recommend that
you convert it to a PDF before submission. If you're not sure how, check out
this [Markdown to PDF guide][markdown-to-pdf-guide]. However, PDFs should be
created for you automatically every time you save, so just double check that
all your work is there before submitting. For future assignments, you will
just be submitting a link to a pull request. This will be the only time
you have to submit any PDFs.

<!-- TODO: upload a PDF of this document and the CHANGELOG to Carmen then delete this comment -->

### Peer Review

Following the completion of this assignment, you will be assigned three
students' component brainstorming assignments for review. Your job during the
peer review process is to help your peers flesh out their designs. Specifically,
you should be helping them determine which of their designs would be most
practical to complete this semester. When reviewing your peers' assignments,
please treat them with respect. Note also that we can see your comments, which
could help your case if you're looking to become a grader. Ultimately, we
recommend using the following feedback rubric to ensure that your feedback is
both helpful and respectful (you may want to render the markdown as HTML or a
PDF to read this rubric as a table).

| Criteria of Constructive Feedback | Missing                                                                                                                           | Developing                                                                                                                                                                                                                                | Meeting                                                                                                                                                               |
| --------------------------------- | --------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Specific                          | All feedback is general (not specific)                                                                                            | Some (but not all) feedback is specific and some examples may be provided.                                                                                                                                                                | All feedback is specific, with examples provided where possible                                                                                                       |
| Actionable                        | None of the feedback provides actionable items or suggestions for improvement                                                     | Some feedback provides suggestions for improvement, while some do not                                                                                                                                                                     | All (or nearly all) feedback is actionable; most criticisms are followed by suggestions for improvement                                                               |
| Prioritized                       | Feedback provides only major or minor concerns, but not both. Major and minar concerns are not labeled or feedback is unorganized | Feedback provides both major and minor concerns, but it is not clear which is which and/or the feedback is not as well organized as it could be                                                                                           | Feedback clearly labels major and minor concerns. Feedback is organized in a way that allows the reader to easily understand which points to prioritize in a revision |
| Balanced                          | Feedback describes either strengths or areas of improvement, but not both                                                         | Feedback describes both strengths and areas for improvement, but it is more heavily weighted towards one or the other, and/or descusses both but does not clearly identify which part of the feedback is a strength/area for improvement  | Feedback provides balanced discussion of the document's strengths and areas for improvement. It is clear which piece of feedback is which                             |
| Tactful                           | Overall tone and language are not appropriate (e.g., not considerate, could be interpreted as personal criticism or attack)       | Overall feedback tone and language are general positive, tactul, and non-threatening, but one or more feedback comments could be interpretted as not tactful and/or feedback leans toward personal criticism, not focused on the document | Feedback tone and language are positive, tactful, and non-threatening. Feedback addesses the document, not the writer                                                 |

### Assignment Feedback

If you'd like to give feedback for this assignment (or any assignment, really),
make use of [this survey][survey]. Your feedback helps make assignments
better for future students.

<!-- TODO: follow the link to share your feedback then delete this comment -->

[example-components]: https://therenegadecoder.com/code/the-never-ending-list-of-small-programming-project-ideas/
[markdown-to-pdf-guide]: https://therenegadecoder.com/blog/how-to-convert-markdown-to-a-pdf-3-quick-solutions/
[survey]: https://forms.gle/dumXHo6A4Enucdkq9
