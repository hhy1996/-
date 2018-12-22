package com.std.haofeng.dao;

import com.std.haofeng.dao.proxy.FirstLevelDaoProxy;
import com.std.haofeng.dao.proxy.SecondLevelDaoProxy;
import com.std.haofeng.vo.FirstLevel;
import com.std.haofeng.vo.SecondLevel;

public class TestFirstLevel {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IFirstLevelDao a =new FirstLevelDaoProxy();
		FirstLevel b=new FirstLevel();
		b.setID(1);
		b.setTypeName("asdasd");
		b.setTypeIntroduce("aa");
		//a.doCreate(b);

	//List<SecondLevel> c=a.findSecondByRoot(0);
		//System.out.println(c);
		
		//a.doUpdateName(3, "啊啊");
		a.doRemoveByID(3);
	}

}
