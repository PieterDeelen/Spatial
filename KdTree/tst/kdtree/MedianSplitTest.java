package kdtree;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;


public class MedianSplitTest {

	private static final List<Integer> EMPTY_LIST = Collections.emptyList();
	
	@Test
	public void testEmpty() {
		verifySplit(EMPTY_LIST, EMPTY_LIST, null, EMPTY_LIST);
	}
	
	@Test
	public void testOne() {
		verifySplit(Arrays.asList(1), EMPTY_LIST, 1, EMPTY_LIST);
	}
	
	@Test
	public void testTwo() {
		verifySplit(Arrays.asList(1, 2), EMPTY_LIST, 1, Arrays.asList(2));
	}
	
	@Test
	public void testThree() {
		verifySplit(Arrays.asList(1, 2, 3), Arrays.asList(1), 2, Arrays.asList(3));
	}
	
	private static <T extends Comparable<T>> void verifySplit(List<T> list, List<T> lower, T median, List<T> upper) {
		MedianSplit<T> split = MedianSplit.split(list);
		
		Assert.assertEquals(lower, split.getLower());
		Assert.assertEquals(median, split.getMedian());
		Assert.assertEquals(upper, split.getUpper());
	}
	
}
