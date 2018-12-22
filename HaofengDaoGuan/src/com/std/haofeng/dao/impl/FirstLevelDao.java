package com.std.haofeng.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.std.haofeng.dao.IFirstLevelDao;
import com.std.haofeng.vo.FirstLevel;

public class FirstLevelDao implements IFirstLevelDao {
	private Connection conn = null;

	private PreparedStatement ps = null;

	public FirstLevelDao(Connection conn) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
	}

	@Override
	public boolean doCreate(FirstLevel firstInfo) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "INSERT INTO FirstLevel (ID,typeName,typeintroduce) VALUES(?,?,?)";
		try {
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setInt(1, firstInfo.getID());
			this.ps.setString(2, firstInfo.getTypeName());
			this.ps.setString(3, firstInfo.getTypeIntroduce());
			if (this.ps.executeUpdate() > 0)
				flag = true;
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
	public boolean doRemoveByID(int ID) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "Delete from FirstLevel where ID = ?";
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
	public boolean doUpdateTypeName(int ID, String newName) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "Update FirstLevel set typeName = ? where ID = ?";
		try {
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setString(1, newName);
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
	public boolean doUpodateIntroduce(int ID, String newIntroduce) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "Update FirstLevel set typeintroduce = ? where ID = ?";
		try {
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setString(1, newIntroduce);
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
	public FirstLevel findFirstLevel(int ID) {
		// TODO Auto-generated method stub
		String sql = "Select ID,typeName,typeintroduce from FirstLevel where ID = ?";
		FirstLevel firstLevel = null;
		try {
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setInt(1, ID);
			ResultSet rs = this.ps.executeQuery();

			if (rs.next()) {
				firstLevel = new FirstLevel();
				firstLevel.setID(rs.getInt(1));
				firstLevel.setTypeName(rs.getString(2));
				firstLevel.setTypeIntroduce(rs.getString(3));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			this.ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return firstLevel;

	}

	@Override
	public List<FirstLevel> findFirstLevel() {
		// TODO Auto-generated method stub
		List<FirstLevel> all = new ArrayList<FirstLevel>();
		String sql = "Select ID,typeName,typeintroduce from FirstLevel";
		try {
			this.ps = this.conn.prepareStatement(sql);
			ResultSet rs = this.ps.executeQuery();
			FirstLevel airstLevel = null;
			while (rs.next()) {
				airstLevel = new FirstLevel();
				airstLevel.setID(rs.getInt(1));
				airstLevel.setTypeName(rs.getString(2));
				airstLevel.setTypeIntroduce(rs.getString(3));
				all.add(airstLevel);
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
