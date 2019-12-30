package com.techlabs.composite;

public class File implements IStorable{
	private String name;
	private double size;
	private String extension;
	
	
	public File(String name, double size, String extension) {
		this.name = name;
		this.size = size;
		this.extension = extension;
	}
	
	public String getName() {
		return name;
	}

	public double getSize() {
		return size;
	}

	public String getExtension() {
		return extension;
	}

	@Override
	public void display(String s) {
		System.out.println(s+ this.getName()+"."+ this.getExtension()+ ": " +
	this.getSize());
//		System.out.printf("%s %s : %.2f\n",getName(),getSize(),getExtension());
	}

	@Override
	public StringBuilder parseToXml() {
		StringBuilder str = new StringBuilder();
		str.append("<" + this.getName() + ">" +"\n");
		str.append("</" +this.getName() +">" +"\n");
		return str;
	}
	
	

}
