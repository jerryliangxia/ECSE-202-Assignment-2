
//to access listNode, bTree extends Stack

public class bTree extends Stack {
	
	public class bNode {	//helper class for bTree
		
		//binary tree node that stores data
		String data;
	
		//constructor for bNode
		public bNode (String data) {
			
			this.data = data;	//initializes data variable in bNode so it can be called later
		}
	}
	
	//@param root: an object of the class listNode
	//@param left and right: objects of the class bTree
	
	Stack.listNode root;
	bTree left;
	bTree right;
	
	//Adds node to the bTree
	
	public void addNode(String lineValue) {
		
		//code below applies if the root is equal to null. Creates bTree
		if (root == null)
		{
			//default constructor for root
			root = new listNode(lineValue);
			
			//new nodes are created and added to root, forming left and right references
			left = new bTree();
			right = new bTree();
			
			//compares given value from text to root value, and traverses through the bTree
		}
		
		else if(lineValue.compareTo(root.value) < 0) {
			
			//adds along the left branch
			left.addNode(lineValue);
		}
		else {
			
			//adds along the right branch
			right.addNode(lineValue);
		}
	}
	
	public void traverseTree()	{ //recursive method
		
		//if the left root of the tree is not null
		if(left.root != null) {
			
			//traverse the left branch of the binary tree
			//is recursive so if the left root of the tree is not null, traverses left again
			left.traverseTree();
		}
		
		//outputs the root value to the system
		System.out.println(root.value);

		//if the right root is not null
		if(right.root != null) {
			//traverse the right branch of the binary tree
			right.traverseTree();
		}
	}

	public void reverseOrder() {	//prints out values in reverse order
		
		//creates a new empty stack
		Stack myStack = new Stack();
		
		//adds contents of bTree to the stack
		addToStack(myStack, this);
		
		//as long as the top of the stack is not null, pop value is printed
		while(myStack.top != null)	{
			
			System.out.println(myStack.pop().value);
		}
	}

	public void addToStack(Stack myStack, bTree tree) {
		
		//if the left branch of the binary tree is not null
		if(tree.left.root != null) {
			
			//add the content of the left branch to the stack
			addToStack(myStack,tree.left);
		}
		//push the root value onto the stack
		myStack.push(tree.root.value);
		
		//if right branch of bTree is not null
		if(tree.right.root != null) {
			
			//add the content of the right branch to the stack
			addToStack(myStack,tree.right);
		}
	}


}