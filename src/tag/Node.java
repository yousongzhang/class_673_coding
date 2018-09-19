package tag;

public class Node {
	private int value;
	private Node left;
	private Node right;
	private int max;
	
	public Node(int value){
		this.value = value;
	}
	
	public void setLeft(Node left){
		this.left = left;
	}
	
	public void setRight(Node right){
		this.right = right;
	}

}
