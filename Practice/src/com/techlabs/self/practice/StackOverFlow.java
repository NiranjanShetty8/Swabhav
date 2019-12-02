package com.techlabs.self.practice;

class StackOverflow { 
    public static void test(double i) 
    { 
        if (i == 0) {
        	System.out.println("in if");
            return; 
        }
        else { 
            test(i= i +1); 
           
        } 
    } 
} 
