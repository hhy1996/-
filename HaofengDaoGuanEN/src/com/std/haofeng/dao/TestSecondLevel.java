package com.std.haofeng.dao;

import java.util.List;

import com.std.haofeng.dao.proxy.SecondLevelDaoProxy;
import com.std.haofeng.dao.proxy.ShopInfoDaoProxy;
import com.std.haofeng.vo.SecondLevel;
import com.std.haofeng.vo.ShopInfo;

public class TestSecondLevel {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ISecondLevelDao a =new SecondLevelDaoProxy();
		SecondLevel b=new SecondLevel();
		b.setID(3);
		b.setRootID(0);
		b.setTypeName("aa");
		b.setTypeIntroduce("ee");
		b.setProductID(8);
		//a.doCreate(b);

	//List<SecondLevel> c=a.findSecondByRoot(0);
		//System.out.println(c);
		
		//a.doUpdateName(3, "啊啊");
		a.doRemove(1);
	}
}
