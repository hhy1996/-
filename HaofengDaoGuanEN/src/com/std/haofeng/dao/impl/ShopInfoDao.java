package com.std.haofeng.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.std.haofeng.dao.IShopInfoDao;
import com.std.haofeng.vo.ShopInfo;

public class ShopInfoDao implements IShopInfoDao {
	private Connection conn = null;

	private PreparedStatement ps = null;

	public ShopInfoDao(Connection conn) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
	}

	@Override
	public boolean doCreate(ShopInfo shopInfo) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "INSERT INTO ShopInfo (ID,shopName,shopProvince,shopAddress,shopWay,shopTel) VALUES(?,?,?,?,?,?)";
		try {
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setInt(1, shopInfo.getID());
			this.ps.setString(2, shopInfo.getShopName());
			this.ps.setString(3, shopInfo.getShopProvince());
			this.ps.setString(4, shopInfo.getShopAddress());
			this.ps.setString(5, shopInfo.getShopWay());
			this.ps.setString(6, shopInfo.getShopTel());
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
		String sql = "Delete from ShopInfo where ID = ?";
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
	public boolean doUpdateName(int ID, String newShopName) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "Update ShopInfo set shopName = ? where ID = ?";
		try {
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setString(1, newShopName);
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
	public boolean doUpdateProvince(int ID, String newProvince) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "Update ShopInfo set shopProvince = ? where ID = ?";
		try {
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setString(1, newProvince);
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
	public boolean doUpdateAddress(int ID, String newAddress) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "Update ShopInfo set shopAddress = ? where ID = ?";
		try {
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setString(1, newAddress);
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
	public boolean doUpdateWay(int ID, String newWay) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "Update ShopInfo set shopWay = ? where ID = ?";
		try {
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setString(1, newWay);
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
	public boolean doUpdateTel(int ID, String newTel) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "Update ShopInfo set shopTel = ? where ID = ?";
		try {
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setString(1, newTel);
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
	public ShopInfo findShop(int ID) {
		// TODO Auto-generated method stub
		String sql = "Select ID,shopName,shopProvince,shopAddress,shopWay,shopTel from ShopInfo where ID = ?";
		ShopInfo shopInfo = null;
		try {
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setInt(1, ID);
			ResultSet rs = this.ps.executeQuery();

			if (rs.next()) {
				shopInfo = new ShopInfo();
				shopInfo.setID(rs.getInt(1));
				shopInfo.setShopName(rs.getString(2));
				shopInfo.setShopProvince(rs.getString(3));
				shopInfo.setShopAddress(rs.getString(4));
				shopInfo.setShopWay(rs.getString(5));
				shopInfo.setShopTel(rs.getString(6));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			this.ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return shopInfo;
	}

	@Override
	public List<ShopInfo> findShop() {
		// TODO Auto-generated method stub
		List<ShopInfo> all = new ArrayList<ShopInfo>();
		String sql = "Select ID,shopName,shopProvince,shopAddress,shopWay,shopTel from ShopInfo";
		try {
			this.ps = this.conn.prepareStatement(sql);
			ResultSet rs = this.ps.executeQuery();
			ShopInfo shopInfo = null;
			while (rs.next()) {
				shopInfo = new ShopInfo();
				shopInfo.setID(rs.getInt(1));
				shopInfo.setShopName(rs.getString(2));
				shopInfo.setShopProvince(rs.getString(3));
				shopInfo.setShopAddress(rs.getString(4));
				shopInfo.setShopWay(rs.getString(5));
				shopInfo.setShopTel(rs.getString(6));
				all.add(shopInfo);
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
	public List<ShopInfo> findShopByProvince(String province) {
		List<ShopInfo> all = new ArrayList<ShopInfo>();
		String sql = "Select ID,shopName,shopProvince,shopAddress,shopWay,shopTel from ShopInfo where shopProvince = ?";
		try {
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setString(1, province);
			ResultSet rs = this.ps.executeQuery();
			ShopInfo shopInfo = null;
			while (rs.next()) {
				shopInfo = new ShopInfo();
				shopInfo.setID(rs.getInt(1));
				shopInfo.setShopName(rs.getString(2));
				shopInfo.setShopProvince(rs.getString(3));
				shopInfo.setShopAddress(rs.getString(4));
				shopInfo.setShopWay(rs.getString(5));
				shopInfo.setShopTel(rs.getString(6));
				all.add(shopInfo);
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
