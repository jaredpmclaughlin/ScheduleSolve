package solve;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class DotWriter {
	
	FileWriter dotFile;
	String filename;
	
	
	public DotWriter(String filename) {
		this.filename = filename;
		
	}

	private void writeParentChild(String vertice, String successor, String label) throws IOException {
		this.dotFile.write(vertice);
		this.dotFile.write(" -> ");
		this.dotFile.write(successor);
		this.dotFile.write("[label="+label+"]");
		this.dotFile.write(";\n");
		
	}
	
	private void writeSingle(String vertice) throws IOException {
		this.dotFile.write(vertice);
		this.dotFile.write(";\n");
	}
	
	private void closeDot() throws IOException {
		this.dotFile.write("}");			
		this.dotFile.close();		
	}
	/*
	public void write(Graph<Integer> input, String title) {
		try {
			this.dotFile = new FileWriter(this.filename); 
			this.dotFile.write("digraph " + title + " {\n");
			
			
			Iterator<Integer> tmp1 = input.iterator();
			
			while(tmp1.hasNext()) {
				int node = tmp1.next();
				Iterator<Graph<Integer>.Node.Pair> tmp2 = input.getNode(node).adjacents();
				while(tmp2.hasNext()) {
					
					Graph<Integer>.Node.Pair tmp3 = tmp2.next();					
					Graph<Integer>.Node child = input.getNodebyIndex(tmp3.vertice-1);

					this.writeParentChild(String.valueOf(node), String.valueOf(child.getData()), String.valueOf(tmp3.weight));
				}
			}
			// write shortest path here
			this.closeDot();
		}
		
		catch(IOException e) {
			System.out.println("File IO Error with dot file.");
		}
	}
*/
	public void write(Graph<String> input, String title) {
		try {
			this.dotFile = new FileWriter(this.filename); 
			this.dotFile.write("digraph " + title + " {\n");
			
			
			Iterator<String> tmp1 = input.iterator();
			
			while(tmp1.hasNext()) {
				String node = tmp1.next();
				Iterator<Graph<String>.Node.Pair> tmp2 = input.getNode(node).adjacents();
				while(tmp2.hasNext()) {
					
					Graph<String>.Node.Pair tmp3 = tmp2.next();					
					Graph<String>.Node child = input.getNodebyIndex(tmp3.vertice-1);

					this.writeParentChild(String.valueOf(node), String.valueOf(child.getData()), String.valueOf(tmp3.weight));
				}
			}
			// write shortest path here
			this.closeDot();
		}
		
		catch(IOException e) {
			System.out.println("File IO Error with dot file.");
		}
	}

	
	/*
	public void writeTree(Graph<Integer> input, String title) {
		try {
			this.dotFile = new FileWriter(this.filename); 
			this.dotFile.write("digraph " + title + " {\n");
			
			
			Iterator<Integer> tmp1 = input.iterator();
			
			while(tmp1.hasNext()) {
				int node = tmp1.next();
				Iterator<Graph<Integer>.Node.Pair> tmp2 = input.getNode(node).children();
				while(tmp2.hasNext()) {
					
					Graph<Integer>.Node.Pair tmp3 = tmp2.next();
					Graph<Integer>.Node child = input.getNodebyIndex(tmp3.vertice-1);
					
					this.writeParentChild(String.valueOf(node), String.valueOf(child.getData()), String.valueOf(tmp3.weight));
				}
			}
			// write shortest path here
			this.closeDot();
		}
		
		catch(IOException e) {
			System.out.println("File IO Error with dot file.");
		}
	}
*/
	public void writeTree(Graph<String> input, String title) {
		try {
			this.dotFile = new FileWriter(this.filename); 
			this.dotFile.write("digraph " + title + " {\n");
			
			
			Iterator<String> tmp1 = input.iterator();
			
			while(tmp1.hasNext()) {
				String node = tmp1.next();
				Iterator<Graph<String>.Node.Pair> tmp2 = input.getNode(node).children();
				while(tmp2.hasNext()) {
					
					Graph<String>.Node.Pair tmp3 = tmp2.next();
					Graph<String>.Node child = input.getNodebyIndex(tmp3.vertice-1);
					
					this.writeParentChild(String.valueOf(node), String.valueOf(child.getData()), String.valueOf(tmp3.weight));
				}
			}
			// write shortest path here
			this.closeDot();
		}
		
		catch(IOException e) {
			System.out.println("File IO Error with dot file.");
		}
	}
}
