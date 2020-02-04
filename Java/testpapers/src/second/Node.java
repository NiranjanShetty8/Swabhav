package second;

public class Node {
	  int data; 
	    Node left, right; 
	   
	    public Node(int item)  
	    { 
	        data = item; 
	        left = right = null; 
	    } 
	    public static void main(String[] args) {
	    	for(int i=0;i<150;i++) {
	    		if((i-1&(i-3))==0) {
	    			System.out.println(i);
	    		}
	    	}
	    }
}
