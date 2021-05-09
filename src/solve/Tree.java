package solve;

public class Tree<T extends Comparable<T>> extends Graph<T> {
	
	public void addChild(T parent,T child, int weight) {
		// enforce by checking for cycles?
		this.addAdjacent(parent, child, weight);
	}
	
	public void addChild(T parent, T child) {
		this.addChild(parent, child, 0);
	}
	
	public void addRoot(T root) {
		this.addVertex(root);
	}
}
