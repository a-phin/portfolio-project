# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.

## 2026.03.31

### Added

- Designed abstract class (SongSelectorSecondary) for SongSelector component
- Added enum classes `SongSort` and `ConstantSort` to SongSelector interface

### Updated

- Updated SongSelectorKernel interface to extend `Iterable<SongSelector<S, C>>`
- Updated SongSelector `sortBySongName()` and `sortByConstant()` method parameters from Comparator<S> and Comparator<C> to enum classes SongSort and ConstantSort

## 2026.03.09

### Added

- Designed kernel and enhanced interfaces for SongSelector component

### Updated

- Modified initial `sort()` secondary method into `sortBySongName()` and `sortByConstant()` methods
- Modified secondary method `replaceConstant()` parameter constant to oldConstant and newConstant, to search a song with a specific constant to change

## 2026.03.01

### Added

- Designed a proof of concept for SongSelector component

### Updated

- Changed design to include `insert()`, `remove()` and `containsSong()` Kernel methods; `replaceConstant()` and `showSongs()` Secondary methods with ArrayList (temporarily, for MVP)
- `RhythmSong` component changed to `SongSelector`

## 2026.02.05

### Added

- Designed a `Chord` component
- Designed a `MusicSequencer` component
- Designed a `RhythmSong` component
