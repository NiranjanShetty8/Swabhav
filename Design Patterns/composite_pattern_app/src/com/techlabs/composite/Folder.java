package com.techlabs.composite;

import java.util.ArrayList;

public class Folder implements IStorable {

	private String name;
	private ArrayList<IStorable> children = new ArrayList<IStorable>();

	public Folder(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public ArrayList<IStorable> getChildren() {
		return children;
	}

	public void addChild(IStorable obj) {

		this.children.add(obj);
	}

	@Override
	public void display(String s) {

		System.out.println(s + this.getName());
		s += "--";
		for (IStorable obj : children) {
			if (obj instanceof File) {
				obj.display(s);
			}
		}
		for (IStorable obj : children) {
			if (obj instanceof Folder) {
				obj.display(s);
			}
		}
	}

	public StringBuilder parseToXml() {
		StringBuilder str = new StringBuilder();
		str.append("<" + this.getName() + ">" +"\n");
		if (children.size() != 0) {
			for (IStorable obj : children) {
				str.append(obj.parseToXml());
			}
		}
		str.append("</" +this.getName() +">" +"\n");
		return str;
	}

}
