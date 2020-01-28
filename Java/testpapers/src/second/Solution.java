package second;

public class Solution {
    public static int[] solution(int[] l, int t) {
    	int lexSmallList[] = {-1,-1};
        int size = l.length;
        int sum =0;
        for(int index =0;index<size;index++) {
        	int temp = index;
        	sum = l[index];
        	if(sum==t) {
        		lexSmallList[0] = index;
        		lexSmallList[1] = index;
        		return lexSmallList;
        	}
        	while(sum<=t && temp <size-1) {
        		temp += 1;
        		sum = sum + l[temp];
        		if(sum == t) {
        			lexSmallList[0]= index;
        			lexSmallList[1] = temp;
        			return lexSmallList;
        		}
        		
        	}
        }
        return lexSmallList;
    }
    
    public static void main(String [] args) {
    	long startTime = System.nanoTime();


//    	int[] qts = {23,2,1,3,8,4,3,2,16,14};
      	int[] qts = {23, 4,2,1,3,8,3,2,16,14};
    	int[] ans = solution(qts,4);
    	for(int i : ans) {
    		System.out.println(i);
    	}

    	long endTime = System.nanoTime();
    	System.out.println("Took "+(endTime - startTime) + " ns"); 
    }
}