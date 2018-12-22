package com.std.haofeng.vo;

public class ProductInfo {
	private int ID;
	private String productName;
	private String productIntroduce;
	private String photoPath;
	private String threeWords;
	private String passage;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductIntroduce() {
		return productIntroduce;
	}

	public void setProductIntroduce(String productIntroduce) {
		this.productIntroduce = productIntroduce;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public String getThreeWords() {
		return threeWords;
	}

	public void setThreeWords(String threeWords) {
		this.threeWords = threeWords;
	}

	public String getPassage() {
		return passage;
	}

	public void setPassage(String passage) {
		this.passage = passage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((passage == null) ? 0 : passage.hashCode());
		result = prime * result + ((photoPath == null) ? 0 : photoPath.hashCode());
		result = prime * result + ((productIntroduce == null) ? 0 : productIntroduce.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((threeWords == null) ? 0 : threeWords.hashCode());
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
		ProductInfo other = (ProductInfo) obj;
		if (ID != other.ID)
			return false;
		if (passage == null) {
			if (other.passage != null)
				return false;
		} else if (!passage.equals(other.passage))
			return false;
		if (photoPath == null) {
			if (other.photoPath != null)
				return false;
		} else if (!photoPath.equals(other.photoPath))
			return false;
		if (productIntroduce == null) {
			if (other.productIntroduce != null)
				return false;
		} else if (!productIntroduce.equals(other.productIntroduce))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (threeWords == null) {
			if (other.threeWords != null)
				return false;
		} else if (!threeWords.equals(other.threeWords))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductInfo [ID=" + ID + ", productName=" + productName + ", productIntroduce=" + productIntroduce
				+ ", photoPath=" + photoPath + ", threeWords=" + threeWords + ", passage=" + passage + "]";
	}

}
