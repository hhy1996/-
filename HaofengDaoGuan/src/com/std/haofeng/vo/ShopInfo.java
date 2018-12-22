package com.std.haofeng.vo;

public class ShopInfo {
	private int ID;
	private String shopName;
	private String shopProvince;
	private String shopAddress;
	private String shopWay;
	private String shopTel;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopProvince() {
		return shopProvince;
	}

	public void setShopProvince(String shopProvince) {
		this.shopProvince = shopProvince;
	}

	public String getShopAddress() {
		return shopAddress;
	}

	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}

	public String getShopWay() {
		return shopWay;
	}

	public void setShopWay(String shopWay) {
		this.shopWay = shopWay;
	}

	public String getShopTel() {
		return shopTel;
	}

	public void setShopTel(String shopTel) {
		this.shopTel = shopTel;
	}

	@Override
	public String toString() {
		return "ShopInfo [ID=" + ID + ", shopName=" + shopName + ", shopPrivince=" + shopProvince + ", shopAddress="
				+ shopAddress + ", shopWay=" + shopWay + ", shopTel=" + shopTel + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((shopAddress == null) ? 0 : shopAddress.hashCode());
		result = prime * result + ((shopName == null) ? 0 : shopName.hashCode());
		result = prime * result + ((shopProvince == null) ? 0 : shopProvince.hashCode());
		result = prime * result + ((shopTel == null) ? 0 : shopTel.hashCode());
		result = prime * result + ((shopWay == null) ? 0 : shopWay.hashCode());
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
		ShopInfo other = (ShopInfo) obj;
		if (ID != other.ID)
			return false;
		if (shopAddress == null) {
			if (other.shopAddress != null)
				return false;
		} else if (!shopAddress.equals(other.shopAddress))
			return false;
		if (shopName == null) {
			if (other.shopName != null)
				return false;
		} else if (!shopName.equals(other.shopName))
			return false;
		if (shopProvince == null) {
			if (other.shopProvince != null)
				return false;
		} else if (!shopProvince.equals(other.shopProvince))
			return false;
		if (shopTel == null) {
			if (other.shopTel != null)
				return false;
		} else if (!shopTel.equals(other.shopTel))
			return false;
		if (shopWay == null) {
			if (other.shopWay != null)
				return false;
		} else if (!shopWay.equals(other.shopWay))
			return false;
		return true;
	}

}
