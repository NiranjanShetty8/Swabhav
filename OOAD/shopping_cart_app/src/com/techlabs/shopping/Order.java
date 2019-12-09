package com.techlabs.shopping;

import java.util.ArrayList;
import java.util.List;

public class Order {

	private int id;
	private String date;
	private List<LineItem> item;

	public Order(int id, String date) {
		this.id = id;
		this.date = date;
		this.item = new ArrayList<LineItem>();

	}

	public int getId() {
		return id;
	}

	public String getDate() {
		return date;
	}

	public List<LineItem> getLineItemList() {
		return item;
	}

	public void addItem(LineItem lineItem) {
		for (LineItem lt : item) {
			if (lt.getProduct()== lineItem.getProduct()) {
				item.remove(lt);
				break;
			}
		}
		item.add(lineItem);
	}

	public double checkOutPrice() {
		double total = 0;
		for (LineItem lt : item) {
			total = total + lt.itemCost();
		}
		return total;
	}
}
