
import java.io.BufferedReader; 
import java.io.FileReader; 
import java.io.IOException; 
import java.util.Scanner; 



public class A2 {								//format copied from ferrie's slides
	public static void main(String[] args) {
		bTree tree = new bTree();
		
		/**
		 * This program reads a specified text file and echos it to standard
		 * display.  You can use this as the basis of Assignment 2, adding the
		 * necessary components to implement the program specifications.
		 * @author ferrie
		 */
		
		System.out.println("Simple File Listing Program");   
		Scanner sc = new Scanner(System.in);   //initializes scanner
		BufferedReader rd = null; 
		
		while(rd == null) {  
			System.out.print("Enter name of file to list: ");    
			String filename = sc.nextLine();    
			if (filename.equals("")) {     
				System.out.println("Program terminated");     
				System.exit(0); 
			}
			
			//Uses a try/catch method to attempt to open the file of interest
			
			try {     
				rd = new BufferedReader(new FileReader(filename));    
			}    
			catch (IOException ex) {     
				System.out.println("Unable to open file, try again."); 
			} 
			
			/*Reads the file and goes through one line at a time, turning it into a string
			* Print as read to the output display
			*/
			
			System.out.println("");   
			try {    
				while (true) {     
					String line = rd.readLine();	//Reads line of text in text file
					if (line == null) break;	//Exits the file if no entries remain
					tree.addNode(line); 
				}       
			}   
			catch (Exception ex) {    
				System.out.println("I/O Error - program terminated");    
				System.exit(-1);   }         
		}
		
		//text for the console to display (not copied from slides)
		
		System.out.println("");
		System.out.println("File in sort order:");
		System.out.println("");
		tree.traverseTree();
		System.out.println("");
		System.out.println("File in reverse sort order:");
		System.out.println("");
		tree.reverseOrder();
		System.out.println("");
		System.out.println("");
		System.out.println("Program terminated ");
	}
}