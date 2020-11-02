
//used from reference to ferrie's slides

public class Stack {

	//initializes listNode
	listNode top;

	public void push(String lineValue) {	//push method
		
		//creating a new node to store the pushed value
		listNode newNode = new listNode(lineValue);
		
		//make the new node reference the top of the stack
		newNode.nextNode = top;
		
		//sets top to referencing the new node
		top = newNode;
	}
	
	public listNode pop() {	//pop method
		
		//if top of stack is not null
		if(top != null) {
			
			listNode oldTop = top;		//sets old top to new top
			
			//top now references the next node
			top = top.nextNode;
			
			//returns listNode oldTop to the previous node
			return oldTop;
		} 
		else {
			//returns null if top of the stack == null
			return null;
		}
	}
	
	public class listNode {
		
		//contains both the string value and object listNode nextNode
		String value;
		listNode nextNode;
		
		//constructor
		public listNode(String lineValue) {
			
			value = lineValue;		//sets value equal to lineValue in listNode class
		}
	}
}

