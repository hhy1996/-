package com.std.haofeng.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.std.haofeng.dao.ISecondLevelDao;
import com.std.haofeng.vo.SecondLevel;

public class SecondLevelDao implements ISecondLevelDao {
	private Connection conn = null;

	private PreparedStatement ps = null;

	public SecondLevelDao(Connection conn) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
	}

	@Override
	public boolean doCreate(SecondLevel secondLevel) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "INSERT INTO SecondLevel (ID,rootID,typeName,typeIntroduce,productID) VALUES(?,?,?,?,?)";
		try {
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setInt(1, secondLevel.getID());
			this.ps.setInt(2, secondLevel.getRootID());
			this.ps.setString(3, secondLevel.getTypeName());
			this.ps.setString(4, secondLevel.getTypeIntroduce());
			this.ps.setInt(5, secondLevel.getProductID());
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
		String sql = "Delete from SecondLevel where ID = ?";
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
	public boolean doRemoveByRoot(int rootID) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "Delete from SecondLevel where rootID = ?";
		try {
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setInt(1, rootID);
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
	public boolean doUpdateRootID(int ID, int newRootID) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "Update SecondLevel set rootID = ? where ID = ?";
		try {
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setInt(1, newRootID);
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
	public boolean doUpdateName(int ID, String newName) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "Update SecondLevel set typeName = ? where ID = ?";
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
	public boolean doUpdateIntroduce(int ID, String newIntroduce) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "Update SecondLevel set typeIntroduce = ? where ID = ?";
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
	public boolean doUpdateProductID(int ID, int newProductID) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "Update SecondLevel set productID = ? where ID = ?";
		try {
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setInt(1, newProductID);
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
	public SecondLevel findSecond(int ID) {
		// TODO Auto-generated method stub
		String sql = "Select ID,rootID,typeName,typeIntroduce,productID from SecondLevel where ID = ?";
		SecondLevel secondLevel = null;
		try {
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setInt(1, ID);
			ResultSet rs = this.ps.executeQuery();

			if (rs.next()) {
				secondLevel = new SecondLevel();
				secondLevel.setID(rs.getInt(1));
				secondLevel.setRootID(rs.getInt(2));
				secondLevel.setTypeName(rs.getString(3));
				secondLevel.setTypeIntroduce(rs.getString(4));
				secondLevel.setProductID(rs.getInt(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			this.ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return secondLevel;
	}

	@Override
	public List<SecondLevel> findSecond() {
		// TODO Auto-generated method stub
		List<SecondLevel> all = new ArrayList<SecondLevel>();
		String sql = "Select ID,rootID,typeName,typeIntroduce,productID from SecondLevel";
		try {
			this.ps = this.conn.prepareStatement(sql);
			ResultSet rs = this.ps.executeQuery();
			SecondLevel secondLevel = null;
			while (rs.next()) {
				secondLevel = new SecondLevel();
				secondLevel.setID(rs.getInt(1));
				secondLevel.setRootID(rs.getInt(2));
				secondLevel.setTypeName(rs.getString(3));
				secondLevel.setTypeIntroduce(rs.getString(4));
				secondLevel.setProductID(rs.getInt(5));
				all.add(secondLevel);
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

	@Override
	public List<SecondLevel> findSecondByRoot(int rootID) {
		List<SecondLevel> all = new ArrayList<SecondLevel>();
		String sql = "Select ID,rootID,typeName,typeIntroduce,productID from SecondLevel where rootID = ?";
		try {
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setInt(1, rootID);
			ResultSet rs = this.ps.executeQuery();
			SecondLevel secondLevel = null;
			while (rs.next()) {
				secondLevel = new SecondLevel();
				secondLevel.setID(rs.getInt(1));
				secondLevel.setRootID(rs.getInt(2));
				secondLevel.setTypeName(rs.getString(3));
				secondLevel.setTypeIntroduce(rs.getString(4));
				secondLevel.setProductID(rs.getInt(5));
				all.add(secondLevel);
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
