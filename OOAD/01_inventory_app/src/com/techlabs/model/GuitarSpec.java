package com.techlabs.model;

public class GuitarSpec {
	private String model;
	private Builder builder;
	private Type type;
	private Wood backWood;
	private Wood topWood;
	private int noOfStrings;

	public GuitarSpec(String model, Builder builder, Type type, 
			Wood backWood, Wood topWood){
		this.model = model;
		this.builder = builder;
		this.type = type;
		this.backWood = backWood;
		this.topWood = topWood;
	}
	
	public GuitarSpec(String model, Builder builder, Type type, 
			Wood backWood, Wood topWood, int noOfStrings){
		this(model,builder, type, backWood, topWood);
		this.noOfStrings = noOfStrings;
	}
	
	public String getModel() {
		return model;
	}

	public Builder getBuilder() {
		return builder;
	}

	public Type getType() {
		return type;
	}

	public Wood getBackWood() {
		return backWood;
	}

	public Wood getTopWood() {
		return topWood;
	}
	
	public int getNoOfStrings() {
		return noOfStrings;
	}
	
	public boolean matches(GuitarSpec otherSpec) {
		if(builder != otherSpec.builder)
			return false;
		if(otherSpec.model != null && !otherSpec.model.equals("") && 
				!model.equals(otherSpec.model))
			return false;
		if(type != otherSpec.type)
			return false;
		if(backWood != otherSpec.backWood)
			return false;
		if(topWood != otherSpec.topWood)
			return false;
		if(noOfStrings != otherSpec.noOfStrings)
			return false;
		return true;
	}

}
