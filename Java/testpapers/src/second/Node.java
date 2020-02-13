package second;

import java.util.ArrayList;

public class Node {	 
	
	    public boolean isSubstring(String mainString, String subString) {
	    	ArrayList<Integer> indexes = new ArrayList<Integer>();
	    	
	    	char[] mainStrArr = mainString.toCharArray();
	    	char[] subStrArr = subString.toCharArray();
	    	int lengthDiff = mainStrArr.length - subStrArr.length;
	    	for(int index =0; index<=lengthDiff; index++) {
	    		if(mainStrArr[index]==subStrArr[0]) {
	    			indexes.add(index);
	    		}
	    	}
	    	if(indexes.size() <1 ) {
	    		return false;
	    	}
	    	int j =0;
	    	for (int i =0; i< indexes.size(); i++) {
//	    	mainStrArr[indexes[i]]
	    	}
	    	return true;
	    }
	    
	    public static void main(String[] args) {
	    	for(int i=0;i<150;i++) {
	    		if((i-1&(i-3))==0) {
	    			System.out.println(i);
	    		}
	    	}
	    }
}
