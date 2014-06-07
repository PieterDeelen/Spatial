package kdtree;

public class BoundingBox {

	private final double[] min;
	private final double[] max;
	
	public BoundingBox(double minX, double maxX, double minY, double maxY) {
		min = new double[] {minX, minY};
		max = new double[] {maxX, maxY};
		
	}
	
	public double getMin(int axis) {
		return min[axis];
	}
	
	public double getMax(int axis) {
		return max[axis];
	}
	
	public boolean contains(Point point) {
		return min[0] <= point.get(0) && point.get(0) <= max[0] &&
				min[1] <= point.get(1) && point.get(1) <= max[1];
	}
	
}
