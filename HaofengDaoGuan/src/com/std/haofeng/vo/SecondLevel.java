package com.std.haofeng.vo;

public class SecondLevel {
	private int ID;
	private int rootID;
	private String typeName;
	private String typeIntroduce;
	private int productID;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getRootID() {
		return rootID;
	}

	public void setRootID(int rootID) {
		this.rootID = rootID;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeIntroduce() {
		return typeIntroduce;
	}

	public void setTypeIntroduce(String typeIntroduce) {
		this.typeIntroduce = typeIntroduce;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	@Override
	public String toString() {
		return "SecondLevel [ID=" + ID + ", rootID=" + rootID + ", typeName=" + typeName + ", typeIntroduce="
				+ typeIntroduce + ", productID=" + productID + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + productID;
		result = prime * result + rootID;
		result = prime * result + ((typeIntroduce == null) ? 0 : typeIntroduce.hashCode());
		result = prime * result + ((typeName == null) ? 0 : typeName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SecondLevel other = (SecondLevel) obj;
		if (ID != other.ID)
			return false;
		if (productID != other.productID)
			return false;
		if (rootID != other.rootID)
			return false;
		if (typeIntroduce == null) {
			if (other.typeIntroduce != null)
				return false;
		} else if (!typeIntroduce.equals(other.typeIntroduce))
			return false;
		if (typeName == null) {
			if (other.typeName != null)
				return false;
		} else if (!typeName.equals(other.typeName))
			return false;
		return true;
	}

}
