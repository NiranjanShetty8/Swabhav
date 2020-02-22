package com.techlabs.thirdpaper;

class Solution {
    public int maxArea(int[] height) {
        int maxArea =0;
        int tempArea;
        for(int index = 0; index<height.length ; index++) {
                for(int j =index+1; j<height.length; j++){
                    if(height[index]>height[j]){
                          tempArea = calcArea(height[j], height[j-index]);
                    } else {
                          tempArea = calcArea(height[index], height[j-index]);
                     }
                if(tempArea > maxArea) {
                    maxArea = tempArea;
                }
            }
                
        }
        return maxArea;
    }
    
    public int calcArea(int no1,int no2) {
        return no1*no2;
    }
    
    public static void main(String args[]) {
    	int[] arr = {1,1,3,4};
    	Solution s = new Solution();
    	System.out.println(s.maxArea(arr));
    	int[] arr2 =  {1,8,6,2,5,4,8,3,7};
    	System.out.println(s.maxArea(arr2));
    	
    }
}

