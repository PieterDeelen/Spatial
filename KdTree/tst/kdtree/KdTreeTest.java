package kdtree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;


public class KdTreeTest {

	@Test
	public void testEmpty() {
		List<Point> emptyList = Collections.emptyList();
		KdTree kdTree = new KdTree(emptyList);
		Assert.assertTrue(kdTree.getPoints().isEmpty());
	}
	
	@Test
	public void testOne() {
		KdTree tree = new KdTree(Arrays.asList(new Point(1, 2)));
		
		Assert.assertEquals(Arrays.asList(new Point(1, 2)), tree.getPoints());
	}

	@Test
	public void testTwo() {
		KdTree tree = new KdTree(Arrays.asList(new Point(1, 2), new Point(2, 3)));
		
		Assert.assertEquals(Arrays.asList(new Point(1, 2), new Point(2, 3)), tree.getPoints());
	}
	
	@Test
	public void testBoundingBox() {
		KdTree tree = new KdTree(Arrays.asList(new Point(1, 2), new Point(2, 3)));
		BoundingBox boundingBox = new BoundingBox(0.9, 1.1, 1.9, 2.1);
		Assert.assertEquals(Arrays.asList(new Point(1, 2)), tree.getPoints(boundingBox));
	}

	@Test
	public void testBoundingBox2() {
		List<Point> points = new ArrayList<Point>();
		for (int x = -500; x <= 500; x++) {
		for (int y = -500; y <= 500; y++) {
				points.add(new Point(x, y));
			}
		}
		new KdTree(points);
		
		long begin = System.currentTimeMillis();
		KdTree tree = new KdTree(points);
		long end = System.currentTimeMillis();
		System.out.println((end - begin) / 1000.0);
		
		BoundingBox boundingBox = new BoundingBox(0.9, 1.1, 0.9, 1.1);
		
		Assert.assertEquals(Arrays.asList(new Point(1, 1)), tree.getPoints(boundingBox));
	}
		
}
