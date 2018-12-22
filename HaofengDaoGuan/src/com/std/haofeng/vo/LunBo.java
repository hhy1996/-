package com.std.haofeng.vo;

public class LunBo {
	private int ID;
	private String photoPath;
	private String Link;
	private String content;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public String getLink() {
		return Link;
	}

	public void setLink(String link) {
		Link = link;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((Link == null) ? 0 : Link.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((photoPath == null) ? 0 : photoPath.hashCode());
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
		LunBo other = (LunBo) obj;
		if (ID != other.ID)
			return false;
		if (Link == null) {
			if (other.Link != null)
				return false;
		} else if (!Link.equals(other.Link))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (photoPath == null) {
			if (other.photoPath != null)
				return false;
		} else if (!photoPath.equals(other.photoPath))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LunBo [ID=" + ID + ", photoPath=" + photoPath + ", Link=" + Link + ", content=" + content + "]";
	}

}
