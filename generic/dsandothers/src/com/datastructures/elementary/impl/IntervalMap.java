package com.datastructures.elementary.impl;

import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * Efficient data structure to map values to intervals e.g. set(5, 60000,
 * "hello") would set all keys in [5, 60000) to be "hello"
 *
 * All operations are O(log n) (in practice much faster since n is usually
 * number of segments)
 *
 * @param <T>
 *            The type of data to store
 */
public class IntervalMap<T> {

	private final TreeMap<Integer, Segment> segments = new TreeMap<Integer, Segment>();

	private class Segment {
		final int start, end;
		final T value;

		Segment(int start, int end, T value) {
			this.start = start;
			this.end = end;
			this.value = value;
			// todo: meld here
			segments.put(start, this);
		}

		void destroy() {
			segments.remove(start);
		}

		boolean contains(int x) {
			return start <= x && x < end;
		}
	}

	private Segment ceiling(int x) {
		return extract(segments.ceilingEntry(x));
	}

	private Segment floor(int x) {
		return extract(segments.floorEntry(x));
	}

	private Segment extract(Entry<Integer, Segment> e) {
		return e != null ? e.getValue() : null;
	}

	private Segment find(int x) {
		final Segment prev = floor(x);
		return prev != null && prev.contains(x) ? prev : ceiling(x);
	}

	/**
	 * Set all values in [x, y) to be value
	 */
	public void set(int x, int y, T value) {
		assert x < y;
		final Segment s = find(x);

		if (s == null) {
			new Segment(x, y, value);
		} else if (x < s.start) {
			if (y <= s.start) {
				new Segment(x, y, value);
			} else if (y < s.end) {
				s.destroy();
				new Segment(x, y, value);
				new Segment(y, s.end, s.value);
			} else {
				s.destroy();
				new Segment(x, s.end, value);
				set(s.end, y, value);
			}
		} else if (x < s.end) {
			s.destroy();
			new Segment(s.start, x, s.value);
			if (y < s.end) {
				new Segment(x, y, value);
				new Segment(y, s.end, s.value);
			} else {
				new Segment(x, s.end, value);
				set(s.end, y, value);
			}
		} else {
			throw new IllegalStateException();
		}
	}

	/**
	 * @return value at x
	 */
	public T get(int x) {
		final Segment s = floor(x);
		return s != null && s.contains(x) ? s.value : null;
	}
}