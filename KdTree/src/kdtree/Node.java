package kdtree;

class Node {
	private final Point location;
	private final int depth;
	private final Node lower;
	private final Node upper;

	public Node(Point location, int depth, Node lower, Node upper) {
		this.location = location;
		this.depth = depth;
		this.lower = lower;
		this.upper = upper;
	}

	public Point getLocation() {
		return location;
	}

	public int getDepth() {
		return depth;
	}

	public Node getLower() {
		return lower;
	}

	public Node getUpper() {
		return upper;
	}
	
	@Override
	public String toString() {
		return prettyPrint(this, 0);
	}
	
	private static String prettyPrint(Node node, int depth) {
		if (node == null) {
			return indent(depth) + "()";
		} else {
			return indent(depth) + "Node " + node.location + " {\n" +
				   indent(depth) + prettyPrint(node.lower, depth + 1) + ",\n" +
				   indent(depth) + prettyPrint(node.upper, depth + 1) + "\n" +
				   indent(depth) + "}";
		}
	}
	
	private static String indent(int depth) {
		final StringBuilder builder = new StringBuilder();
		for (int i = 0; i < depth; i++) {
			builder.append("  ");
		}
		return builder.toString();
	}
}