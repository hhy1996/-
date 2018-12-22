package com.std.haofeng.service.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.std.haofeng.common.Config;
import com.std.haofeng.factory.DaoFactory;
import com.std.haofeng.service.IArticleService;
import com.std.haofeng.vo.Article;
import com.std.haofeng.vo.LunBo;
import com.std.haofeng.util.*;;

public class ArticleService implements IArticleService {

	@Override
	public boolean AddLunBo(LunBo lunbo) {
		lunbo.setID(Util.CreateRandomID());
		return DaoFactory.getLunBoDao().doCreate(lunbo);
	}

	@Override
	public boolean DeleteLunBo(int ID) {
		return DaoFactory.getLunBoDao().doRemove(ID);
	}

	@Override
	public boolean ChangeLunBo(LunBo oldLunBo, LunBo newLunBo) {
		boolean result = true;
		if (!oldLunBo.getContent().equals(newLunBo.getContent()))
			result = result && DaoFactory.getLunBoDao().doUpdateContent(oldLunBo.getID(), newLunBo.getContent());
		if (!oldLunBo.getLink().equals(newLunBo.getLink()))
			result = result && DaoFactory.getLunBoDao().doUpdateContent(oldLunBo.getID(), newLunBo.getContent());
		if (!oldLunBo.getPhotoPath().equals(newLunBo.getPhotoPath()))
			result = result && DaoFactory.getLunBoDao().doUpdatePath(oldLunBo.getID(), newLunBo.getPhotoPath());
		return result;
	}

	@Override
	public List<LunBo> GetAllLunBo() {
		return DaoFactory.getLunBoDao().findLunBo();
	}

	@Override
	public boolean PubLishArticle(String title, String textContent, String content, String FolderPath, String inner) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Article article = new Article();
		String pubTime = df.format(System.currentTimeMillis());
		article.setPubTime(pubTime);
		article.setID(Util.CreateRandomID());

		// 创建文章的代码，暂时先空着
		String result = Config.ArticleTemplate.replace("#CONTENT#", content);
		result = result.replace("#YEAR#", pubTime.split("-")[0]);
		result = result.replace("#MONTH#", pubTime.split("-")[1]);
		result = result.replace("#DAY#", pubTime.split("-")[2]);
		result = result.replace("#PUBTIME#", pubTime);
		result = result.replace("#TITLE#", title);
		String path = String.valueOf(System.currentTimeMillis())+".jsp";
		File file=new File(FolderPath+path);
		try {
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(result);
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		if(textContent.length()>20)
			article.setPath(title + "!" + textContent.substring(0, 15) + "!" + path);
		else
			article.setPath(title + "!" + textContent.substring(0, textContent.length()-1) + "!" + path);
		return DaoFactory.getArticleDao().doCreate(article);
	}

	@Override
	public boolean DeleteArticle(int ID, String FolderPath) {
		boolean result = true;
		Article article = DaoFactory.getArticleDao().findArticle(ID);
		if (article != null) {
			result = result && DaoFactory.getArticleDao().doRemove(ID);
			File file = new File(FolderPath + article.getPath());
			if (file.exists() && file.isFile()) {
				result = result && file.delete();
			}
		}
		return result;
	}

	@Override
	public List<Article> GetAllArticle() {
		return DaoFactory.getArticleDao().findArticle();
	}

}
