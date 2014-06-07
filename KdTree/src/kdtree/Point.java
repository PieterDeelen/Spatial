package kdtree;

import java.util.Arrays;
import java.util.Comparator;

public class Point {

	private final double[] vector;

	public Point(double x, double y) {
		vector = new double[] {x, y};
	}
	
	public double get(int index) {
		return vector[index];
	}
	
	public double getX() {
		return vector[0];
	}
	
	public double getY() {
		return vector[1];
	}
	
	
	
	@Override
	public int hashCode() {
		return Arrays.hashCode(vector);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Point)) {
			return false;
		}
		final Point other = (Point) obj;
		return Arrays.equals(this.vector, other.vector);
	}

	@Override
	public String toString() {
		return "(" + getX() + ", " + getY() + ")";
	}

	static final Comparator<Point> getComparator(final int axis) {
		final int nextAxis = (axis + 1) % 2;
		return new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				int result = Double.compare(o1.get(axis), o2.get(axis));
				if (result == 0) {
					result = Double.compare(o1.get(nextAxis), o2.get(nextAxis));
				}
				return result;
			}
		};
	}
}
