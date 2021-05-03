package solve;

import java.util.Iterator;
import java.util.ArrayList;

public class Graph<T extends Comparable<T>> {
	
	public class Node {
		private T data;
		private int distance = -1; // use negative to represent infinity
		
		public class Pair {
			int vertice;
			int weight;
			
			Pair(int vertice, int weight){
				this.vertice = vertice;
				this.weight = weight;
			}
			
			int getWeight() {
				return this.weight;
			}
			
			int getVertice() {
				return this.vertice;
			}
		}
		private ArrayList<Pair> adjacent = new ArrayList<Pair>();
		private ArrayList<Pair> children = new ArrayList<Pair>();
		
		Node(){
			this(null);
		}
		
		Node(T data){
			this.data = data;
		}
		
		/**
		 * 
		 * @return and integer representing the index of the vertice with the shortest edge
		 */
		public int getShortest() {
			int shortest = adjacent.get(0).getVertice();
			int lowest = adjacent.get(0).getWeight();
			for(Pair tmp : adjacent) {
				if (tmp.getWeight() < lowest ) {
					shortest = tmp.getVertice();  
				}	
			}
			return shortest;
		}
				
		public int getDistance() {
			return this.distance;
		}
		
		public void setDistance(int d) {
			this.distance = d;
		}

		public T getData() {
			return this.data;
		}
		
		public void addAdjacent(int vertice, int weight) {
			this.adjacent.add(new Pair(vertice, weight));
		}
		
		public void addPath(int vertice, int weight) {
			this.children.add(new Pair(vertice, weight));
		}
		
		public void removePath(int vertice, int weight) {
			Pair tmp = new Pair(vertice,weight);
			Iterator<Graph<T>.Node.Pair> mPair = this.children();
			
			while(mPair.hasNext()) {
				tmp = mPair.next();
				if(tmp.getVertice() == vertice && tmp.getWeight() == weight) {
					this.children.remove(tmp);
				}
			}			
		}
		
		protected boolean equals(T comparison) {
			if ( this.data.compareTo(comparison) == 0 ) return true; 
			else return false;
		}
		
		Iterator<Pair> adjacents() {
			return adjacent.iterator();
		}
		
		Iterator<Pair> children(){
			return children.iterator();
		}
	} 

	private ArrayList<Node> nodes = new ArrayList<Node>();
	
	public void labelAll() {
		this.nodes.get(0).setDistance(0);
		for(int i=0; i < nodes.size(); i++) {
			this.labelNeighbors(i);
		}
	}
	
	private void labelNeighbors(int index) {
		// visited represents the node we are visiting to see it's neighbors
		Node visited = nodes.get(index);
		Node tmpNode;
		
		// got to each of the neighbors
		Iterator<Graph<T>.Node.Pair> neighborsIT = visited.adjacents();
		while(neighborsIT.hasNext()) {
			Graph<T>.Node.Pair nPair = neighborsIT.next();
			tmpNode = this.getNodebyIndex(nPair.getVertice()-1);
			if(tmpNode.getDistance() == -1) {		
				tmpNode.setDistance(nPair.getWeight()+visited.getDistance());
				visited.addPath(nPair.getVertice(), tmpNode.getDistance());
			}else {
				if(nPair.getWeight()+visited.getDistance() < tmpNode.getDistance()) {
					// replacing a path that exists
					this.removeAllPathsTo(nPair.getVertice());
					tmpNode.setDistance(nPair.getWeight()+visited.getDistance());
					visited.addPath(nPair.getVertice(), tmpNode.getDistance());
				}
			}			
		}
	}
	
	private void removeAllPathsTo(int vertice) {
		// go through each node
		for(int i=0; i < nodes.size(); i++) {
			Iterator<Graph<T>.Node.Pair> pathsIT = this.nodes.get(i).children();
			while( pathsIT.hasNext()) {
				Graph<T>.Node.Pair tmp = pathsIT.next();
				if(tmp.getVertice() == (vertice)) {
					this.nodes.get(i).removePath(vertice, tmp.getWeight());
				}
			}
		
		}
	}

	public void addNode(T data) {
		nodes.add(new Node(data));
	}
	
	public void addAdjacent(T to, T adjacent, int weight) {
		//int toIndex = this.getIndex(to);
		int aIndex = this.getIndex(adjacent);
		Node tmp = this.getNode(to);
		tmp.addAdjacent(aIndex, weight);
	}

	public Node getNode(T data) {
		for (Node tmp : this.nodes ) {
			if(tmp.getData() == data) return tmp;
		}
		return null;
	}
	
	public Node getNodebyIndex(int index) {
		return nodes.get(index);
	}
	
	private int getIndex(T data) {
		int index = 0;
		for(Node tmp : this.nodes) {
			index++;
			if(tmp.getData() == data) return index;
		}
		return -1;
	}	
	
	public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {
        Iterator<Node> iter = nodes.iterator();
        	
            @Override
            public boolean hasNext() {
            	return iter.hasNext();
            }

        	public T next() {
        		return iter.next().getData();
        	}

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }
}
