package com.std.haofeng.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.FileSystem;
import org.hyperic.sigar.FileSystemUsage;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.NetFlags;
import org.hyperic.sigar.NetInterfaceConfig;
import org.hyperic.sigar.NetInterfaceStat;
import org.hyperic.sigar.OperatingSystem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.Swap;
import org.hyperic.sigar.Who;

/**
 * Servlet implementation class HomePage
 */
@WebServlet("/MyAdmin/AdminHomePage")
public class AdminHomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public AdminHomePage() {
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
		/*Runtime r = Runtime.getRuntime();
		Properties props = System.getProperties();
		Sigar sigar = new Sigar();
		try {
			Mem mem = sigar.getMem();
			request.setAttribute("TotlaMem", String.valueOf(mem.getTotal() / 1024L / 1024L));
			request.setAttribute("UesMem", String.valueOf(mem.getUsed() / 1024L / 1024L));
			request.setAttribute("FreeMem", String.valueOf(mem.getFree() / 1024L / 1024L));
			CpuPerc cpuList[]=sigar.getCpuPercList();
			request.setAttribute("CPUUse", String.valueOf(cpuList[0].getCombined()*100));
		} catch (SigarException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("JVMTotlaMem", String.valueOf(r.totalMemory()/ 1024L / 1024L));
		request.setAttribute("JVMFreeMem", String.valueOf(r.freeMemory()/ 1024L / 1024L));
		request.setAttribute("JVMCPUN", String.valueOf(r.availableProcessors()));
		request.setAttribute("javaVersion", props.getProperty("java.version"));
		request.setAttribute("sysName", props.getProperty("os.name"));
		*/
		request.setAttribute("TodayVisit", String.valueOf(com.std.haofeng.common.RunTime.todayVisit));
		request.setAttribute("VisitAll", String.valueOf(com.std.haofeng.common.RunTime.VisitAll));
		request.getRequestDispatcher("index.jsp").forward(request, response);
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
