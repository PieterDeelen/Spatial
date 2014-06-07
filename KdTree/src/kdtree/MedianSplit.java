package kdtree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MedianSplit<T> {

	private List<T> lower;
	private T median;
	private List<T> upper;

	private MedianSplit(List<T> lower, T median, List<T> upper) {
		this.lower = lower;
		this.median = median;
		this.upper = upper;
	}

	public static <T extends Comparable<T>> MedianSplit<T> split(List<T> list) {
		return split(list, new Comparator<T>() {
			@Override
			public int compare(T o1, T o2) {
				return o1.compareTo(o2);
			}
		});
	}
	
	public static <T> MedianSplit<T> split(List<T> list, Comparator<T> comparator) {
		if (list.size() == 0) {
			final List<T> emptyList = Collections.emptyList();
			return new MedianSplit<T>(emptyList, null, emptyList);
		} else {
			final List<T> sorted = sorted(list, comparator);
			final int index = Math.round(sorted.size() / 2.0f) - 1;
			return new MedianSplit<T>(
					sorted.subList(0, index),
					sorted.get(index),
					sorted.subList(index + 1, sorted.size()));
		}
	}

	public List<T> getLower() {
		return lower;
	}

	public T getMedian() {
		return median;
	}

	public List<T> getUpper() {
		return upper;
	}
	
	private static <T> List<T> sorted(List<T> list, Comparator<T> comparator) {
		List<T> result = new ArrayList<T>(list);
		Collections.sort(result, comparator);
		return result;
	}
	
}
