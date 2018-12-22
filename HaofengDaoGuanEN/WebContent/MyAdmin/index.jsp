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
	if(request.getSession().getAttribute("user")==null)
	{
		response.sendRedirect("login.jsp");
		return;
	}
	String JVMTotalMem=(String)request.getAttribute("JVMTotlaMem");
	String JVMFreeMem=(String)request.getAttribute("JVMFreeMem");
	String JVMCPUN=(String)request.getAttribute("JVMCPUN");
	String javaVersion=(String)request.getAttribute("javaVersion");
	String sysName=(String)request.getAttribute("sysName");
	String TodayVisit=(String)request.getAttribute("TodayVisit");
	String VisitAll=(String)request.getAttribute("VisitAll");
	String TotlaMem=(String)request.getAttribute("TotlaMem");
	String UesMem=(String)request.getAttribute("UesMem");
	String FreeMem=(String)request.getAttribute("FreeMem");
	String CPUUse=(String)request.getAttribute("CPUUse");
	if(VisitAll==null||TodayVisit==null)
	{
		response.sendRedirect("AdminHomePage");
		return;
	}

%>
<!DOCTYPE html>
<!--[if IE 9]>         <html class="no-js lt-ie10" lang="en"> <![endif]-->
<!--[if gt IE 9]><!-->
<html class="no-js" lang="ch">
	<!--<![endif]-->

	<head>
		<meta charset="utf-8">

		<title>浩枫道馆-后台</title>
		<meta name="robots" content="noindex, nofollow">

		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<!-- Icons -->
		<!-- The following icons can be replaced with your own, they are used by desktop and mobile browsers -->
		<link rel="shortcut icon" href="img/favicon.png">
		<link rel="apple-touch-icon" href="img/icon57.png" sizes="57x57">
		<link rel="apple-touch-icon" href="img/icon72.png" sizes="72x72">
		<link rel="apple-touch-icon" href="img/icon76.png" sizes="76x76">
		<link rel="apple-touch-icon" href="img/icon114.png" sizes="114x114">
		<link rel="apple-touch-icon" href="img/icon120.png" sizes="120x120">
		<link rel="apple-touch-icon" href="img/icon144.png" sizes="144x144">
		<link rel="apple-touch-icon" href="img/icon152.png" sizes="152x152">
		<link rel="apple-touch-icon" href="img/icon180.png" sizes="180x180">
		<!-- END Icons -->

		<!-- Stylesheets -->
		<!-- Bootstrap is included in its original form, unaltered -->
		<link rel="stylesheet" href="css/bootstrap.min.css">

		<!-- Related styles of various icon packs and plugins -->
		<link rel="stylesheet" href="css/plugins.css">

		<!-- The main stylesheet of this template. All Bootstrap overwrites are defined in here -->
		<link rel="stylesheet" href="css/main.css">

		<!-- Include a specific file here from css/themes/ folder to alter the default theme of the template -->

		<!-- The themes stylesheet of this template (for using specific theme color in individual elements - must included last) -->
		<link rel="stylesheet" href="css/themes.css">
		<!-- END Stylesheets -->

		<!-- Modernizr (browser feature detection library) -->
		<script src="js/vendor/modernizr-3.3.1.min.js"></script>
	</head>

	<body>
		<!-- Page Wrapper -->
		<!-- In the PHP version you can set the following options from inc/config file -->
		<!--
            Available classes:

            'page-loading'      enables page preloader
        -->
		<div id="page-wrapper" class="page-loading">
			<!-- Preloader -->
			<!-- Preloader functionality (initialized in js/app.js) - pageLoading() -->
			<!-- Used only if page preloader enabled from inc/config (PHP version) or the class 'page-loading' is added in #page-wrapper element (HTML version) -->
			<div class="preloader">
				<div class="inner">
					<!-- Animation spinner for all modern browsers -->
					<div class="preloader-spinner themed-background hidden-lt-ie10"></div>

					<!-- Text for IE9 -->
					<h3 class="text-primary visible-lt-ie10"><strong>Loading..</strong></h3>
				</div>
			</div>
			<!-- END Preloader -->

			<!-- Page Container -->
			<!-- In the PHP version you can set the following options from inc/config file -->
			<!--
                Available #page-container classes:

                'sidebar-light'                                 for a light main sidebar (You can add it along with any other class)

                'sidebar-visible-lg-mini'                       main sidebar condensed - Mini Navigation (> 991px)
                'sidebar-visible-lg-full'                       main sidebar full - Full Navigation (> 991px)

                'sidebar-alt-visible-lg'                        alternative sidebar visible by default (> 991px) (You can add it along with any other class)

                'header-fixed-top'                              has to be added only if the class 'navbar-fixed-top' was added on header.navbar
                'header-fixed-bottom'                           has to be added only if the class 'navbar-fixed-bottom' was added on header.navbar

                'fixed-width'                                   for a fixed width layout (can only be used with a static header/main sidebar layout)

                'enable-cookies'                                enables cookies for remembering active color theme when changed from the sidebar links (You can add it along with any other class)
            -->
			<div id="page-container" class="header-fixed-top sidebar-visible-lg-full">

				<!-- Main Sidebar -->
				<div id="sidebar">
					<!-- Sidebar Brand -->
					<div id="sidebar-brand" class="themed-background">
						<a href="index.html" class="sidebar-title">
							<i class="fa fa-cube"></i> <span class="sidebar-nav-mini-hide">浩枫道馆后台</span>
						</a>
					</div>
					<!-- END Sidebar Brand -->
					<jsp:include page="header.jsp?active=1" flush="true"></jsp:include>
					
				</div>
				<!-- END Main Sidebar -->

				<!-- Main Container -->
				<div id="main-container">
					<!-- Header -->
					<!-- In the PHP version you can set the following options from inc/config file -->
					<!--
                        Available header.navbar classes:

                        'navbar-default'            for the default light header
                        'navbar-inverse'            for an alternative dark header

                        'navbar-fixed-top'          for a top fixed header (fixed main sidebar with scroll will be auto initialized, functionality can be found in js/app.js - handleSidebar())
                            'header-fixed-top'      has to be added on #page-container only if the class 'navbar-fixed-top' was added

                        'navbar-fixed-bottom'       for a bottom fixed header (fixed main sidebar with scroll will be auto initialized, functionality can be found in js/app.js - handleSidebar()))
                            'header-fixed-bottom'   has to be added on #page-container only if the class 'navbar-fixed-bottom' was added
                    -->
					<header class="navbar navbar-inverse navbar-fixed-top">
						<!-- Left Header Navigation -->
						<ul class="nav navbar-nav-custom">
							<!-- Main Sidebar Toggle Button -->
							<li>
								<a href="javascript:void(0)" onclick="App.sidebar('toggle-sidebar');this.blur();">
									<i class="fa fa-ellipsis-v fa-fw animation-fadeInRight" id="sidebar-toggle-mini"></i>
									<i class="fa fa-bars fa-fw animation-fadeInRight" id="sidebar-toggle-full"></i>
								</a>
							</li>
							<!-- END Main Sidebar Toggle Button -->
						</ul>
						<!-- END Left Header Navigation -->

						<!-- Right Header Navigation -->
						<ul class="nav navbar-nav-custom pull-right">
							<!-- User Dropdown -->
							<li class="dropdown">
								<a href="Logout"><button type="button" class="btn btn-default">注销</button></a>
							</li>
							<!-- END User Dropdown -->
						</ul>
						<!-- END Right Header Navigation -->
					</header>
					<!-- END Header -->

					<!-- Page content -->
					<div id="page-content">
					<div class="row">
						<div class="col-sm-6 col-lg-3 col-lg-offset-3">
							<a href="javascript:void(0)" class="widget">
								<div class="widget-content widget-content-mini text-right clearfix">
									<div class="widget-icon pull-left themed-background">
										<i class="gi gi-cardio text-light-op"></i>
									</div>
									<h2 class="widget-heading h3">
                                            <strong><span data-toggle="counter" data-to="<%=TodayVisit%>"></span></strong>
                                        </h2>
									<span class="text-muted">今日访问量</span>
								</div>
							</a>
						</div>
						<div class="col-sm-6 col-lg-3">
							<a href="javascript:void(0)" class="widget">
								<div class="widget-content widget-content-mini text-right clearfix">
									<div class="widget-icon pull-left themed-background-success">
										<i class="gi gi-user text-light-op"></i>
									</div>
									<h2 class="widget-heading h3 text-success">
                                            <strong>+ <span data-toggle="counter" data-to="<%=VisitAll%>"></span></strong>
                                        </h2>
									<span class="text-muted">总访问量</span>
								</div>
							</a>
						</div>
					</div>
						<div class="row">
							<div class="col-sm-6 col-lg-offset-3">
								<!-- Project Widget -->
								<div class="widget">
									<div class="widget-content border-bottom">
										服务器状态
									</div>
									<table class="table table-striped table-borderless table-vcenter">
											<tbody>
												<%if(JVMTotalMem!=null){ %>
												<tr>
													<td><strong>JVM内存总量</strong></td>
													<td><%=JVMTotalMem %>MB</td>
												</tr>
												<%} %>
												<%if(JVMFreeMem!=null){ %>
												<tr>
													<td><strong>JVM可用内存</strong></td>
													<td><%=JVMFreeMem %>MB</td>
												</tr>
												<%} %>
												<%if(JVMCPUN!=null){ %>
												<tr>
													<td><strong>JVM虚拟机CPU个数</strong></td>
													<td><%=JVMCPUN %></td>
												</tr>
												<%} %>
												<%if(javaVersion!=null){ %>
												<tr>
													<td><strong>JAVA版本</strong></td>
													<td><%=javaVersion %></td>
												</tr>
												<%} %>
												<%if(sysName!=null){ %>
												<tr>
													<td><strong>系统名称</strong></td>
													<td><%=sysName %></td>
												</tr>
												<%} %>
												<%if(TotlaMem!=null){ %>
												<tr>
													<td><strong>物理内存总量</strong></td>
													<td><%=TotlaMem %>MB</td>
												</tr>
												<%} %>
												<%if(UesMem!=null){ %>
												<tr>
													<td><strong>已用内存</strong></td>
													<td><%=UesMem %>MB</td>
												</tr>
												<%} %>
												<%if(FreeMem!=null){ %>
												<tr>
													<td><strong>可用内存</strong></td>
													<td><%=FreeMem %>MB</td>
												</tr>
												<%} %>
												<%if(CPUUse!=null){ %>
												<tr>
													<td><strong>CPU使用率</strong></td>
													<td><%=CPUUse %>%</td>
												</tr>
												<%} %>
											</tbody>
										</table>
								</div>
								<!-- END Project Widget -->
							</div>
						</div>
					</div>
					<!-- END Page Content -->
				</div>
				<!-- END Main Container -->
			</div>
			<!-- END Page Container -->
		</div>
		<!-- END Page Wrapper -->

		<!-- jQuery, Bootstrap, jQuery plugins and Custom JS code -->
		<script src="js/vendor/jquery-2.2.4.min.js"></script>
		<script src="js/vendor/bootstrap.min.js"></script>
		<script src="js/plugins.js"></script>
		<script src="js/app.js"></script>

		<!-- Load and execute javascript code used only in this page -->
		<script src="js/pages/readyDashboard.js"></script>
		<script>
			$(function() {
				ReadyDashboard.init();
			});
		</script>
	</body>

</html>