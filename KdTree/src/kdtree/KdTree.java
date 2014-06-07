package kdtree;

import java.util.ArrayList;
import java.util.List;

public class KdTree {

	private final Node root;
	
	public KdTree(List<Point> points) {
		root = construct(points, 0);
	}

	public List<Point> getPoints() {
		return getPoints(root);
	}
	
	public List<Point> getPoints(BoundingBox boundingBox) {
		return getPoints(root, boundingBox);
	}
	
	private List<Point> getPoints(Node node, BoundingBox boundingBox) {
		final List<Point> result = new ArrayList<Point>();
		if (node != null) {
//			System.out.println("Visiting node " + node.getLocation() + " " + node.getDepth());
			final int axis = node.getDepth() % 2;
			final Point location = node.getLocation();
			if (boundingBox.getMin(axis) <= location.get(axis)) {
				result.addAll(getPoints(node.getLower(), boundingBox));
			}
			if (boundingBox.contains(location)) {
				result.add(location);
			}
			if (location.get(axis) <= boundingBox.getMax(axis)) {
				result.addAll(getPoints(node.getUpper(), boundingBox));
			}
		}
		return result;
	}

	private List<Point> getPoints(Node node) {
		final List<Point> result = new ArrayList<Point>();
		if (node != null) {
			result.addAll(getPoints(node.getLower()));
			result.add(node.getLocation());
			result.addAll(getPoints(node.getUpper()));
		}
		return result;
	}
	
	private final Node construct(List<Point> points, int depth) {
		if (points.isEmpty()) {
			return null;
		} else {
			final int axis = depth % 2;
			final MedianSplit<Point> split = MedianSplit.split(points, Point.getComparator(axis));
			return new Node(split.getMedian(), depth,
					construct(split.getLower(), depth + 1),
					construct(split.getUpper(), depth + 1));
		}
	}

	@Override
	public String toString() {
		return root.toString();
	}
	
}
