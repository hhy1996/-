package com.std.haofeng.vo;

public class Article {
	private int ID;
	private String path;
	private String PubTime;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPubTime() {
		return PubTime;
	}

	public void setPubTime(String pubTime) {
		PubTime = pubTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((PubTime == null) ? 0 : PubTime.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
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
		Article other = (Article) obj;
		if (ID != other.ID)
			return false;
		if (PubTime == null) {
			if (other.PubTime != null)
				return false;
		} else if (!PubTime.equals(other.PubTime))
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Article [ID=" + ID + ", path=" + path + ", PubTime=" + PubTime + "]";
	}

}
