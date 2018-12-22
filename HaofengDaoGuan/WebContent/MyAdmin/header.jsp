<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
if(request.getSession().getAttribute("user")==null)
{
	response.sendRedirect("login.jsp");
	return;
}
%>
<% 
	String _active=request.getParameter("active");
	int active=1;
	if(_active!=null)
		active=Integer.parseInt(_active);
%>
<!-- Wrapper for scrolling functionality -->
					<div id="sidebar-scroll">
						<!-- Sidebar Content -->
						<div class="sidebar-content">
							<!-- Sidebar Navigation -->
							<ul class="sidebar-nav">
								<li>
									<a href="index.jsp" <%if(active==1){%>class="active"<%}%>><i class="gi gi-compass sidebar-nav-icon"></i><span class="sidebar-nav-mini-hide">控制台</span></a>
								</li>
								<li class="sidebar-separator">
									<i class="fa fa-ellipsis-h"></i>
								</li>
								<li <%if(active>=2&&active<=3){%>class="active"<%}%>>
									<a href="#" class="sidebar-nav-menu"><i class="fa fa-chevron-left sidebar-nav-indicator sidebar-nav-mini-hide"></i><i class="fa fa-bullhorn sidebar-nav-icon"></i><span class="sidebar-nav-mini-hide">轮播管理</span></a>
									<ul>
										<li>
											<a <%if(active==2){%>class="active"<%}%> href="addlunbo.jsp">添加轮播</a>
										</li>
										<li>
											<a <%if(active==3){%>class="active"<%}%> href="chakanlunbo.jsp">查看轮播</a>
										</li>
									</ul>
								</li>
								<li <%if(active>=4&&active<=5){%>class="active"<%}%>>
									<a href="#" class="sidebar-nav-menu"><i class="fa fa-chevron-left sidebar-nav-indicator sidebar-nav-mini-hide"></i><i class="fa fa-align-justify sidebar-nav-icon"></i><span class="sidebar-nav-mini-hide">动态管理</span></a>
									<ul>
										<li>
											<a <%if(active==4){%>class="active"<%}%> href="ShowArticle.jsp">查看动态</a>
										</li>
										<li>
											<a <%if(active==5){%>class="active"<%}%> href="AddArticle.jsp">添加动态</a>
										</li>
									</ul>
								</li>
								<li <%if(active>=6&&active<=9){%>class="active"<%}%>>
									<a href="#" class="sidebar-nav-menu"><i class="fa fa-chevron-left sidebar-nav-indicator sidebar-nav-mini-hide"></i><i class="fa fa-graduation-cap sidebar-nav-icon"></i><span class="sidebar-nav-mini-hide">课程管理</span></a>
									<ul>
										<li>
											<a <%if(active==6){%>class="active"<%}%> href="AddFirstLevel.jsp">添加课程大类</a>
										</li>
										<li>
											<a <%if(active==7){%>class="active"<%}%> href="ShowFirstLevel.jsp">查看课程大类</a>
										</li>
										<li>
											<a <%if(active==8){%>class="active"<%}%> href="AddClass.jsp">添加普通课程</a>
										</li>
										<li>
											<a <%if(active==9){%>class="active"<%}%> href="ShowClass.jsp">查看课程列表</a>
										</li>
									</ul>
								</li>
								<li <%if(active>=10&&active<=11){%>class="active"<%}%>>
									<a href="#" class="sidebar-nav-menu"><i class="fa fa-chevron-left sidebar-nav-indicator sidebar-nav-mini-hide"></i><i class="fa fa-archive sidebar-nav-icon"></i><span class="sidebar-nav-mini-hide">店铺管理</span></a>
									<ul>
										<li>
											<a <%if(active==10){%>class="active"<%}%> href="ShowShop.jsp">查看店铺列表</a>
										</li>
										<li>
											<a <%if(active==11){%>class="active"<%}%> href="AddShop.jsp">添加新店铺</a>
										</li>
									</ul>
								</li>
								<li <%if(active>=12&&active<=13){%>class="active"<%}%>>
									<a href="#" class="sidebar-nav-menu"><i class="fa fa-chevron-left sidebar-nav-indicator sidebar-nav-mini-hide"></i><i class="fa fa-user sidebar-nav-icon"></i><span class="sidebar-nav-mini-hide">账户管理</span></a>
									<ul>
										<li>
											<a <%if(active==12){%>class="active"<%}%> href="adduser.jsp">添加管理账户</a>
										</li>
										<li>
											<a <%if(active==13){%>class="active"<%}%> href="chakanyonghu.jsp">查看账户列表</a>
										</li>
									</ul>
								</li>
							</ul>
							<!-- END Sidebar Navigation -->
						</div>
						<!-- END Sidebar Content -->
					</div>
					<!-- END Wrapper for scrolling functionality -->