package interview.preperation.kit.tree;

class AVLTree{

	public TreeNode root;
	
	public AVLTree() {}
	
	public AVLTree(TreeNode root) {
		this.root = root;
	}
	
	public AVLTree(int data) {
		insert(this.root, data);
	}
	
	public TreeNode insert(TreeNode root ,int data) {
		if(root == null) {
			TreeNode newNode = new TreeNode(data);
			return newNode;
		}
		if(data < root.data) {
			root.leftChild = insert(root.leftChild, data);
			root.balanceFactor = findBalanceFactor(root);			
			
			if(root.balanceFactor == 2) {
				if(data < root.leftChild.data) {
					root = singleLeftRotation(root);
				}else {
					root.leftChild = singleRightRotation(root.leftChild);
					root = singleLeftRotation(root);
				}
			}
		}
		if(data > root.data) {
			root.rightChild = insert(root.rightChild, data);
			root.balanceFactor = findBalanceFactor(root);
			
			if(root.balanceFactor == 2) {
				if(data < root.rightChild.data) {
					root = singleRightRotation(root);
				}else {
					root.rightChild = singleLeftRotation(root.rightChild);
					root = singleRightRotation(root);
				}
			}
		}

		return root;
	}
	
	public TreeNode singleLeftRotation(TreeNode x) {
		
		TreeNode y = x.leftChild;
		TreeNode t = y.rightChild;
		
		y.rightChild = x;
		x.leftChild = t;
		
		x.balanceFactor = findBalanceFactor(x);
		y.balanceFactor = findBalanceFactor(y);
		
		return y;
	}
	
	public TreeNode singleRightRotation(TreeNode x) {
		
		TreeNode y = x.rightChild;
		TreeNode t = y.leftChild;
		
		y.leftChild = x;
		x.rightChild = t;
		
		x.balanceFactor = findBalanceFactor(x);
		y.balanceFactor = findBalanceFactor(y);
		
		return y;
	}
	
	public int findBalanceFactor(TreeNode root) {
		return Math.abs(height(root.rightChild) - height(root.leftChild));
	}
	
	public void inorderTraversal(TreeNode root) {
		if(root == null)
			return;
		inorderTraversal(root.leftChild);
		System.out.println(root.data);
		inorderTraversal(root.rightChild);
	}
	
	public int height(TreeNode root) {
		if(root == null)
			return 0;
		
		return 1 + Math.max(height(root.leftChild), height(root.rightChild));
	}
	
	public void levelOrderUtil() {
		int height = height(root);
		
		for(int i=0; i<height; i++) {
			printNodeAtHeight(root, i);
			System.out.println();
		}
		
	}
	
	public void printNodeAtHeight(TreeNode root ,int height) {
		if(root == null) return;
		if(height == 0) {
			System.out.print(root.data+" ");
			return;
		}
		printNodeAtHeight(root.leftChild, height - 1);
		printNodeAtHeight(root.rightChild, height - 1);
	}
	
	
}

public class AVLTreeImplementation {

	public static void main(String[] args) {
		
		AVLTree tree = new AVLTree();
		
		tree.root = tree.insert(tree.root, 5);
		tree.root = tree.insert(tree.root, 2);
		tree.root = tree.insert(tree.root, 1);
		tree.root = tree.insert(tree.root, 4);
		tree.root = tree.insert(tree.root, 6);
		
		//tree.inorderTraversal(tree.root);
		
		tree.levelOrderUtil();
	}

}
