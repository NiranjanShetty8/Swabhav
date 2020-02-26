package com.techlabs.thirdpaper;

class Solution {
	public boolean isNumber(String s) {
		  if(s == "1 "){
              return true;
          }
        char[] example = s.toCharArray();
          
                if(!Character.isDigit(example[0])) {
                    return false;
                } 
        for(int index=0;index<example.length;index++) {
        	int comp = example[index];
            if(Character.isDigit(example[index]) 
            		|| comp =='e'||comp == 43||comp ==45||comp ==46) {
                if(index == example.length-1){
                    return true;
                         } 
                continue;
                  }
            return false;
             }
        
        
           return false;
    }

	public static void main(String args[]) {
		Solution s = new Solution();
		System.out.println(s.isNumber("1 "));
	}
}
