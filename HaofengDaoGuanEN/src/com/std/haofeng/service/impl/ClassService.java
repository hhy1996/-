package com.std.haofeng.service.impl;

import java.io.File;
import java.util.List;

import com.std.haofeng.factory.DaoFactory;
import com.std.haofeng.service.IClassService;
import com.std.haofeng.util.Util;
import com.std.haofeng.vo.FirstLevel;
import com.std.haofeng.vo.ProductInfo;
import com.std.haofeng.vo.SecondLevel;

public class ClassService implements IClassService {

	@Override
	public boolean AddFirstType(FirstLevel firstLevel) {
		firstLevel.setID(Util.CreateRandomID());
		return DaoFactory.getFirstLevelDao().doCreate(firstLevel);
	}

	@Override
	public List<FirstLevel> getAllFirstLevel() {
		return DaoFactory.getFirstLevelDao().findFirstLevel();
	}

	@Override
	public FirstLevel getFirstLevel(int ID) {
		return DaoFactory.getFirstLevelDao().findFirstLevel(ID);
	}

	@Override
	public boolean ChangeFirstLevel(int oldID, FirstLevel newFirst) {
		boolean result = true;
		FirstLevel oldFirst=DaoFactory.getFirstLevelDao().findFirstLevel(oldID);
		int ID = oldFirst.getID();
		if (!oldFirst.getTypeIntroduce().equals(newFirst.getTypeIntroduce()))
			result = result && DaoFactory.getFirstLevelDao().doUpodateIntroduce(ID, newFirst.getTypeIntroduce());
		if (!oldFirst.getTypeName().equals(newFirst.getTypeName()))
			result = result && DaoFactory.getFirstLevelDao().doUpdateTypeName(ID, newFirst.getTypeName());
		return result;
	}

	@Override
	public boolean DeleteFirstLevel(int ID) {
		boolean result = true;
		result = result && DaoFactory.getFirstLevelDao().doRemoveByID(ID);
		List<SecondLevel> second = DaoFactory.getSecondLevelDao().findSecondByRoot(ID);
		for (int i = 0; i < second.size(); i++) {
			SecondLevel temp = second.get(i);
			result = result && DaoFactory.getProductInfoDao().doRemove(temp.getProductID());
			result = result && DaoFactory.getSecondLevelDao().doRemove(temp.getID());
		}
		return result;
	}

	@Override
	public boolean AddSecondType(SecondLevel secondLevel, ProductInfo productInfo) {
		boolean result = true;
		secondLevel.setID(Util.CreateRandomID());
		int tempID = Util.CreateRandomID();
		secondLevel.setProductID(tempID);
		productInfo.setID(tempID);
		result = result && DaoFactory.getSecondLevelDao().doCreate(secondLevel);
		result = result && DaoFactory.getProductInfoDao().doCreate(productInfo);
		return result;
	}

	@Override
	public List<SecondLevel> GetAllSecondLevel() {
		return DaoFactory.getSecondLevelDao().findSecond();
	}

	@Override
	public List<SecondLevel> GetAllSecondLevel(int rootID) {
		return DaoFactory.getSecondLevelDao().findSecondByRoot(rootID);
	}

	@Override
	public boolean ChangeProduct(ProductInfo oldProduct, ProductInfo newProduct) {
		int ID = oldProduct.getID();
		boolean result = true;
		if (!oldProduct.getPassage().equals(newProduct.getPassage()))
			result = result && DaoFactory.getProductInfoDao().doUpdatePassage(ID, newProduct.getPassage());
		if (!oldProduct.getPhotoPath().equals(newProduct.getPhotoPath()))
			result = result && DaoFactory.getProductInfoDao().doUpdatePhotoPath(ID, newProduct.getPhotoPath());
		if (!oldProduct.getProductIntroduce().equals(newProduct.getProductIntroduce()))
			result = result && DaoFactory.getProductInfoDao().doUpdateIntroduce(ID, newProduct.getProductIntroduce());
		if (!oldProduct.getProductName().equals(newProduct.getProductName()))
			result = result && DaoFactory.getProductInfoDao().doUpdateName(ID, newProduct.getProductName());
		if (!oldProduct.getThreeWords().equals(newProduct.getThreeWords()))
			result = result && DaoFactory.getProductInfoDao().doUpdatethreeWords(ID, newProduct.getThreeWords());
		return result;
	}

	@Override
	public boolean DeleteProduct(int secondID,String folder) {
		boolean result = true;
		SecondLevel s=DaoFactory.getSecondLevelDao().findSecond(secondID);
		ProductInfo p=DaoFactory.getProductInfoDao().findProduct(s.getProductID());
		File file=new File(folder+s.getTypeIntroduce().split("!")[0]);
		if(file.exists())
			file.delete();
		String _split[]=p.getPhotoPath().split("!");
		for(int i=0;i<_split.length;i++)
		{
			File file1=new File(folder+_split[i]);
			if(file1.exists())
				file1.delete();
		}
		result = result && DaoFactory.getSecondLevelDao().doRemove(secondID);
		result = result && DaoFactory.getProductInfoDao().doRemove(p.getID());
		return result;
	}

	@Override
	public ProductInfo GetProduct(int ID) {
		return DaoFactory.getProductInfoDao().findProduct(ID);
	}

}
