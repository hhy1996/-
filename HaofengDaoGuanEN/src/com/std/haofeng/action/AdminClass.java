package com.std.haofeng.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lxh.smart.SmartUpload;

import com.std.haofeng.factory.DaoFactory;
import com.std.haofeng.service.IClassService;
import com.std.haofeng.service.impl.ClassService;
import com.std.haofeng.vo.FirstLevel;
import com.std.haofeng.vo.ProductInfo;
import com.std.haofeng.vo.SecondLevel;

/**
 * Servlet implementation class AdminClass
 */
@WebServlet("/MyAdmin/AdminClass")
public class AdminClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getSession().getAttribute("user")==null)
		{
			response.sendRedirect("login.jsp");
			return;
		}
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		if (action == null)
			action = "getInfo";
		IClassService classService = new ClassService();
		switch (action) {
		case "getInfo": {
			List<SecondLevel> secondList = classService.GetAllSecondLevel();
			List<ProductInfo> productList = new ArrayList<ProductInfo>();
			for (int i = 0; i < secondList.size(); i++) {
				productList.add(DaoFactory.getProductInfoDao().findProduct(secondList.get(i).getProductID()));
			}
			request.setAttribute("SecondList", secondList);
			request.setAttribute("ProductList", productList);
			request.getRequestDispatcher("ShowClass.jsp").forward(request, response);
			break;
		}
		case "getTypeInfo": {
			List<FirstLevel> firstList = classService.getAllFirstLevel();
			request.setAttribute("firstList", firstList);
			request.getRequestDispatcher("AddClass.jsp").forward(request, response);
			break;
		}
		case "add": {
			SmartUpload su = new SmartUpload();
			try {
				su.initialize(this.getServletConfig(), request, response);
				su.upload();
				SecondLevel secondLevel = new SecondLevel();
				ProductInfo productInfo = new ProductInfo();
				String className = su.getRequest().getParameter("className");

				String productIntroduce = su.getRequest().getParameter("productIntroduce");
				String word1 = su.getRequest().getParameter("word1");
				String word2 = su.getRequest().getParameter("word2");
				String word3 = su.getRequest().getParameter("word3");
				String _rootID = su.getRequest().getParameter("rootID");
				String passage = su.getRequest().getParameter("passage");
				int photoName = com.std.haofeng.util.Util.CreateRandomID();
				if (className == null || productIntroduce == null || word1 == null || word2 == null || word3 == null
						|| _rootID == null || passage == null) {
					response.sendRedirect("AddClass.jsp");
					return;
				}
				secondLevel.setRootID(Integer.parseInt(_rootID));
				secondLevel.setTypeName(className);
				productInfo.setPassage(passage);
				productInfo.setProductIntroduce(productIntroduce);
				productInfo.setProductName(className);
				productInfo.setThreeWords(word1 + "!!!" + word2 + "!!!" + word3);
				String photoNames = "";
				for (int i = 0; i < su.getFiles().getCount(); i++) {
					if (i == 0) {
						String ext = su.getFiles().getFile(i).getFileExt();
						su.getFiles().getFile(i).saveAs(getServletContext().getRealPath("/") + "images"
								+ java.io.File.separator + photoName + "." + ext);
						secondLevel.setTypeIntroduce(photoName + "." + ext + "!" + productIntroduce);
					} else {
						String ext = su.getFiles().getFile(i).getFileExt();
						String photoPath = (photoName + i) + "." + ext;
						if (i == 1)
							photoNames += photoPath;
						else
							photoNames += "!" + photoPath;
						su.getFiles().getFile(i).saveAs(
								getServletContext().getRealPath("/") + "images" + java.io.File.separator + photoPath);
					}
				}
				productInfo.setPhotoPath(photoNames);
				classService.AddSecondType(secondLevel, productInfo);
				response.sendRedirect("AdminClass?action=getInfo");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		}
		case "delete": {
			String deleteID = request.getParameter("deleteID");
			if (deleteID != null) {
				classService.DeleteProduct(Integer.parseInt(deleteID),
						getServletContext().getRealPath("/images") + java.io.File.separator);
				response.sendRedirect("AdminClass?action=getInfo");
			}
			break;
		}
		case "jumpChange": {
			String changeID=request.getParameter("changeID");
			if(changeID!=null)
			{
				SecondLevel s=DaoFactory.getSecondLevelDao().findSecond(Integer.parseInt(changeID));
				ProductInfo p=classService.GetProduct(s.getProductID());
				List<FirstLevel> firstList = classService.getAllFirstLevel();
				request.setAttribute("firstList", firstList);
				request.setAttribute("second", s);
				request.setAttribute("product", p);
				request.setAttribute("changeID", changeID);
				request.getRequestDispatcher("ChangeClass.jsp").forward(request, response);
			}
			break;
		}
		case "change": {
			String deleteID = request.getParameter("changeID");
			if (deleteID != null) {
				classService.DeleteProduct(Integer.parseInt(deleteID),
						getServletContext().getRealPath("/images") + java.io.File.separator);
				SmartUpload su = new SmartUpload();
				try {
					su.initialize(this.getServletConfig(), request, response);
					su.upload();
					SecondLevel secondLevel = new SecondLevel();
					ProductInfo productInfo = new ProductInfo();
					String className = su.getRequest().getParameter("className");
					String productIntroduce = su.getRequest().getParameter("productIntroduce");
					String word1 = su.getRequest().getParameter("word1");
					String word2 = su.getRequest().getParameter("word2");
					String word3 = su.getRequest().getParameter("word3");
					String _rootID = su.getRequest().getParameter("rootID");
					String passage = su.getRequest().getParameter("passage");
					System.out.println(className+"|"+productIntroduce+"|"+word1+"|"+word2+"|"+word3+"|"+_rootID+"|"+passage);
					int photoName = com.std.haofeng.util.Util.CreateRandomID();
					if (className == null || productIntroduce == null || word1 == null || word2 == null || word3 == null
							|| _rootID == null || passage == null) {
						response.sendRedirect("AddClass.jsp");
						return;
					}
					secondLevel.setRootID(Integer.parseInt(_rootID));
					secondLevel.setTypeName(className);
					productInfo.setPassage(passage);
					productInfo.setProductIntroduce(productIntroduce);
					productInfo.setProductName(className);
					productInfo.setThreeWords(word1 + "!!!" + word2 + "!!!" + word3);
					String photoNames = "";
					for (int i = 0; i < su.getFiles().getCount(); i++) {
						if (i == 0) {
							String ext = su.getFiles().getFile(i).getFileExt();
							su.getFiles().getFile(i).saveAs(getServletContext().getRealPath("/") + "images"
									+ java.io.File.separator + photoName + "." + ext);
							secondLevel.setTypeIntroduce(photoName + "." + ext + "!" + productIntroduce);
						} else {
							String ext = su.getFiles().getFile(i).getFileExt();
							String photoPath = (photoName + i) + "." + ext;
							if (i == 1)
								photoNames += photoPath;
							else
								photoNames += "!" + photoPath;
							su.getFiles().getFile(i).saveAs(getServletContext().getRealPath("/") + "images"
									+ java.io.File.separator + photoPath);
						}
					}
					productInfo.setPhotoPath(photoNames);
					classService.AddSecondType(secondLevel, productInfo);
					response.sendRedirect("AdminClass?action=getInfo");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			break;
		}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
