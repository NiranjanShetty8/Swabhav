package com.techlabs.node.test;

import com.techlabs.node.Node;

public class NodeTest {

	public static void main(String[] args) {
		NodeTest nt = new NodeTest();
		
		Node<String> first = new Node<String>();
		first.setData("Swabhav");
		Node<String> second = new Node<String>();
		second.setData("Teachlabs");
		Node<String> third = new Node<String>();
		third.setData("Andheri");
		
		first.setNext(second);
		second.setNext(third);
		third.setNext(null);
		
		nt.printInfo(first);
		
		Node<Integer> firstI = new Node<Integer>();
		firstI.setData(10);
		Node<Integer> secondI = new Node<Integer>();
		secondI.setData(20);
		Node<Integer> thirdI = new Node<Integer>();
		thirdI.setData(30);
		
		firstI.setNext(secondI);
		secondI.setNext(thirdI);
		thirdI.setNext(null);
		
		nt.printInfo(firstI);
	}
	
	@SuppressWarnings("rawtypes")
	public void printInfo(Node node) {
		while(node.getNext()!=null) {
			System.out.println(node.getData());
			node = node.getNext();
		}
		System.out.println(node.getData());
	}

}
