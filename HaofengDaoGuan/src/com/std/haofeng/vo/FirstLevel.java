package com.std.haofeng.vo;

public class FirstLevel {
	private int ID;
	private String typeName;
	private String typeIntroduce;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
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

	@Override
	public String toString() {
		return "FirstLevel [ID=" + ID + ", typeName=" + typeName + ", typeIntroduce=" + typeIntroduce + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
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
		FirstLevel other = (FirstLevel) obj;
		if (ID != other.ID)
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
