package solve;

import java.util.Iterator;


public class Solve {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph<Integer> all = new Graph<Integer>();
		Graph<String> done = new Graph<String>();
		
		DotWriter dotFile = new DotWriter("out.dot");
		DotWriter treeFile = new DotWriter("tree.dot");

/*
		done.addNode("A");
		done.addNode("E");
		done.addNode("C");
		done.addNode("D");
		done.addNode("M");
		done.addNode("Q");
		done.addNode("X");
		
		done.addAdjacent("A", "E", 1);
		done.addAdjacent("A", "C", 2);
		done.addAdjacent("E", "C", 3);
		done.addAdjacent("E", "D", 4);
		done.addAdjacent("C", "D", 5);
		done.addAdjacent("D", "M", 6);
		done.addAdjacent("D", "X", 20);
		done.addAdjacent("D", "Q", 7);
		done.addAdjacent("M", "X", 8);
		done.addAdjacent("Q", "X", 9);
		
		
		done.labelAll();
		
		System.out.println( done.getNode("Q").getDistance());
*/
		done.addNode("\"CSCI3040 FA21\"");
		done.addNode("\"CSCI2020 SP21\"");
		done.addAdjacent("\"CSCI3040 FA21\"", "\"CSCI2020 SP21\"", 5);
		
		treeFile.writeTree(done, "tree");
		dotFile.write(done, "all");
		
	}

}
