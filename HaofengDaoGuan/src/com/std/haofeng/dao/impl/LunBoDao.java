package com.std.haofeng.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.std.haofeng.dao.ILunBoDao;
import com.std.haofeng.vo.LunBo;

public class LunBoDao implements ILunBoDao {
	private Connection conn = null;

	private PreparedStatement ps = null;

	public LunBoDao(Connection conn) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
	}


	@Override
	public boolean doCreate(LunBo lunbo) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "INSERT INTO LunBo (ID,photoPath,Link,Content) VALUES(?,?,?,?)";
		try {
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setInt(1, lunbo.getID());
			this.ps.setString(2, lunbo.getPhotoPath());
			this.ps.setString(3, lunbo.getLink());
			this.ps.setString(4, lunbo.getContent());
			if (this.ps.executeUpdate() > 0)
				flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				this.ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	@Override
	public boolean doRemove(int ID) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "Delete from LunBo where ID = ?";
		try {
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setInt(1, ID);
			if (this.ps.executeUpdate() > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			this.ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean doUpdatePath(int ID, String newPath) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "Update LunBo set photoPath = ? where ID = ?";
		try {
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setString(1, newPath);
			this.ps.setInt(2, ID);
			if (this.ps.executeUpdate() > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean doUpdateLink(int ID, String link) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "Update LunBo set Link = ? where ID = ?";
		try {
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setString(1, link);
			this.ps.setInt(2, ID);
			if (this.ps.executeUpdate() > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean doUpdateContent(int ID, String content) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "Update LunBo set Content = ? where ID = ?";
		try {
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setString(1, content);
			this.ps.setInt(2, ID);
			if (this.ps.executeUpdate() > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public LunBo findLunBo(int ID) {
		// TODO Auto-generated method stub
		String sql = "Select ID,photoPath,Link,Content from LunBo where ID = ?";
		LunBo lunbo = null;
		try {
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setInt(1, ID);
			ResultSet rs = this.ps.executeQuery();

			if (rs.next()) {
				lunbo = new LunBo();
				lunbo.setID(rs.getInt(1));
				lunbo.setPhotoPath(rs.getString(2));
				lunbo.setLink(rs.getString(3));
				lunbo.setContent(rs.getString(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			this.ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lunbo;
	}

	@Override
	public List<LunBo> findLunBo() {
		// TODO Auto-generated method stub
		List<LunBo> all = new ArrayList<LunBo>();
		String sql = "Select ID,photoPath,Link,Content from LunBo";
		try {
			this.ps = this.conn.prepareStatement(sql);
			ResultSet rs = this.ps.executeQuery();
			LunBo lunbo = null;
			while (rs.next()) {
				lunbo = new LunBo();
				lunbo.setID(rs.getInt(1));
				lunbo.setPhotoPath(rs.getString(2));
				lunbo.setLink(rs.getString(3));
				lunbo.setContent(rs.getString(4));
				all.add(lunbo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return all;
	}

}
