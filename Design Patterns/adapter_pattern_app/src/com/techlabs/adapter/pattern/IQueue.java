package com.techlabs.adapter.pattern;

public interface IQueue<T> {
	void enqueue(T item);
	T dequeue();
	int count();

}
