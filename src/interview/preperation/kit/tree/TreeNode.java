package interview.preperation.kit.tree;

public class TreeNode {
	int data;
	TreeNode leftChild;
	TreeNode rightChild;
	int balanceFactor;
	
	public TreeNode(int data) {
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public TreeNode getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(TreeNode leftChild) {
		this.leftChild = leftChild;
	}
	public TreeNode getRightChild() {
		return rightChild;
	}
	public void setRightChild(TreeNode rightChild) {
		this.rightChild = rightChild;
	}
	
}

