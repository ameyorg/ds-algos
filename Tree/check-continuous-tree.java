// Check if a tree is continuous or not
import java.util.*;

class solution
{

/* A binary tree node has data, pointer to left child
and a pointer to right child */
static class Node
{
	int data;
	Node left, right;
};

/* Helper function that allocates a new node with the
given data and null left and right pointers. */

static Node newNode(int data)
{
	Node node = new Node();
	node.data = data;
	node.left = node.right = null;
	return(node);
}

// Function to check tree is continuous or not

static boolean treeContinuous( Node ptr)
{
	// if next node is empty then return true
	if (ptr == null)
		return true;

	// if current node is leaf node then return true
	// because it is end of root to leaf path
	if (ptr.left == null && ptr.right == null)
		return true;

	// If left subtree is empty, then only check right
	if (ptr.left == null)
	return (Math.abs(ptr.data - ptr.right.data) == 1) &&
			treeContinuous(ptr.right);

	// If right subtree is empty, then only check left
	if (ptr.right == null)
	return (Math.abs(ptr.data - ptr.left.data) == 1) &&
			treeContinuous(ptr.left);

	// If both left and right subtrees are not empty, check
	// everything
	return Math.abs(ptr.data - ptr.left.data)==1 &&
			Math.abs(ptr.data - ptr.right.data)==1 &&
			treeContinuous(ptr.left) &&
			treeContinuous(ptr.right);
}

/* Driver program to test mirror() */
public static void main(String args[])
{
	Node root = newNode(3);
	root.left	 = newNode(2);
	root.right	 = newNode(4);
	root.left.left = newNode(1);
	root.left.right = newNode(3);
	root.right.right = newNode(5);
	if(treeContinuous(root))
	System.out.println( "Yes") ;
	else
	System.out.println( "No");
}
}
